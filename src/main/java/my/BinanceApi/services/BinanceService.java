package my.BinanceApi.services;

import java.io.IOException;

public interface BinanceService {

    public String getPublicApiKey(long id);
    public String getSecretApiKey(long id);

    public String getAccountInfo(String endpoint);
    public String getMarketData(String endpoint, String symbol)throws IOException;
}
