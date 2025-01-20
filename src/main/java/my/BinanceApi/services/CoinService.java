package my.BinanceApi.services;

import my.BinanceApi.models.Coin;
import java.util.List;

public interface CoinService {

    List<Coin> getAllCoins();
    List<Coin> getCoinsByName(String name);
    Coin getCoinById(long id);
    Coin saveCoin(Coin coin);

    void removeCoin(long id);

}
