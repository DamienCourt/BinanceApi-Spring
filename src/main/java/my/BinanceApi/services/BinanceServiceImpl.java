package my.BinanceApi.services;

import my.BinanceApi.repositories.BinanceRepository;
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

    @Autowired
    public BinanceServiceImpl(BinanceRepository binanceRepository){
        this.binanceRepository = binanceRepository;
        this.okHttpClient = new OkHttpClient();
    }

    public String getAllBinanceTransactions() {
        String public_key = getPublicApiKey(1);
        String secret_key = getSecretApiKey(1);
        String timestamp = String.valueOf(System.currentTimeMillis());

        String altUrl = "https://testnet.binance.vision/api/v3/account";
        String url = "https://api.binance.com/api/v3/account&timestamp=" + timestamp;

        Request request = new Request.Builder()
                .url("https://testnet.binance.vision/api/v3/account&timestamp"+timestamp)
                .header("X-MBX-APIKEY",secret_key)
                .build();

        //try with resources
        try (Response response = okHttpClient.newCall(request).execute()) {
            if(response.isSuccessful()){
                return response.body().toString();
            }
            else{
                return timeStamp;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //save them in db
    }

    public String getPublicApiKey(long id) {
        return binanceRepository.getPublicKeyById(id);
    }
    public String getSecretApiKey(long id){
        return binanceRepository.getSecretKeyById(id);
    }

}
