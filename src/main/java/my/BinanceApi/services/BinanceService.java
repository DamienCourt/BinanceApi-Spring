package my.BinanceApi.services;

import my.BinanceApi.models.Coin;
import java.util.List;

public interface BinanceService {
    public List<Coin> getAllTransactions();
}
