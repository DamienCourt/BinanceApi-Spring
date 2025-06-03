package my.BinanceApi.services;

import my.BinanceApi.repositories.BinanceRepository;
import my.BinanceApi.utils.BinanceSignature;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class BinanceServiceImpl implements BinanceService{
    private final BinanceRepository binanceRepository;
    private final OkHttpClient okHttpClient;
    private final String baseUrl = "https://api.binance.com";
    private final int apiKeyId = 1; //remove this

    @Autowired
    public BinanceServiceImpl(BinanceRepository binanceRepository){
        this.binanceRepository = binanceRepository;
        this.okHttpClient = new OkHttpClient();
    }

    @Override
    public String getPublicApiKey(long id) {
        return binanceRepository.getPublicKeyById(id);
    }

    @Override
    public String getSecretApiKey(long id){
        return binanceRepository.getSecretKeyById(id);
    }

    /** For Market data endpoints which require only public api key. No signing is required */
    @Override
    public String getMarketData(String endpoint, String symbol) throws IOException{
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse( baseUrl+ endpoint).newBuilder();
        urlBuilder.addQueryParameter("symbol", symbol);

        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .addHeader("X-MBX-APIKEY", getPublicApiKey(apiKeyId))
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    public String getAccountInfo(String endpoint){
        String timestamp = String.valueOf(System.currentTimeMillis());
        String timestampUrl = "timestamp=" + timestamp + "&omitZeroBalances=true";

        String signature = BinanceSignature.generateSignature(timestampUrl, getSecretApiKey(apiKeyId));
        String url = baseUrl + endpoint + "?timestamp="+timestamp+"&signature="+signature;

        Request request = new Request.Builder()
                .url("https://testnet.binance.vision/api/v3/account?"+timestampUrl+"&signature="+signature)
                .header("X-MBX-APIKEY",getPublicApiKey(apiKeyId))
                .build();

        try (Response response = okHttpClient.newCall(request).execute()){
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getOpenOrders(String endpoint, String symbol){
        String timestamp = String.valueOf(System.currentTimeMillis());
        String timestampUrl = "timestamp=" + timestamp; //"?symbol=" + symbol +
        String timestampUrl2 = "symbol=BTCUSDT&"+timestampUrl;

        String signature = BinanceSignature.generateSignature(timestampUrl2, getSecretApiKey(apiKeyId));
        String url = baseUrl + endpoint + timestampUrl +"&signature="+signature;

        Request request = new Request.Builder()
                .url("https://testnet.binance.vision/api/v3/openOrders?"+timestampUrl2+"&signature="+signature)
                .header("X-MBX-APIKEY", getPublicApiKey(apiKeyId))
                .build();

        try (Response response = okHttpClient.newCall(request).execute()){
            return  response.body().string();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
