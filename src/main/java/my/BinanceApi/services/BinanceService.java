package my.BinanceApi.services;

import my.BinanceApi.models.Coin;
import java.util.List;

public interface BinanceService {
    public String getAllBinanceTransactions();
    public String getPublicApiKey(long id);
    public String getSecretApiKey(long id);
}
