package my.BinanceApi.services;

import my.BinanceApi.repositories.BinanceRepository;
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

    @Autowired
    public BinanceServiceImpl(BinanceRepository binanceRepository){
        this.binanceRepository = binanceRepository;
        this.okHttpClient = new OkHttpClient();
    }

    public String getAllBinanceTransactions() {
        String public_key = getPublicApiKey(1);
        String secret_key = getSecretApiKey(1);
        String timestamp = String.valueOf(System.currentTimeMillis());
        String API_URL = "https://api.binance.com";

        String altUrl = "https://testnet.binance.vision/api/v3/account";
        String url = "https://api.binance.com/api/v3/account&timestamp=" + timestamp;

        Request request = new Request.Builder()
                .url("https://testnet.binance.vision/api/v3/account&timestamp"+timestamp)
                .header("X-MBX-APIKEY",public_key)
                .build();


        System.out.println(request.headers()+" body: "+ request.body());
        //try with resources
        try (Response response = okHttpClient.newCall(request).execute()) {
            if(response.isSuccessful()){
                System.out.println(response.body());
                return response.body().toString();
            }
            else{
                System.out.println(timestamp);
                return timestamp;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //save them in db
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
        int apiKeyId = 1;
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
}
