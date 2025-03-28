package my.BinanceApi.services;

import my.BinanceApi.models.Coin;
import java.util.List;
import java.util.Optional;

public interface CoinService {

    List<Coin> getAllCoins();
    List<Coin> getAllCoinsSorted();
    List<Coin> getCoinsByName(String name);
    Optional<Coin> getCoinById(long id);
    Coin saveCoin(Coin coin);

    void removeCoin(long id);

}
