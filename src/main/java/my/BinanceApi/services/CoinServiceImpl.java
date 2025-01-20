package my.BinanceApi.services;

import my.BinanceApi.models.Coin;
import my.BinanceApi.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CoinServiceImpl implements CoinService{

    private final CoinRepository coinRepository;

    @Autowired
    public CoinServiceImpl(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    @Override
    public List<Coin> getAllCoins() {
        return coinRepository.findAll();
    }

    @Override
    public List<Coin> getCoinsByName(String name) {
        return coinRepository.findByName(name);
    }






    @Override
    public Coin getCoinById(long id) {
        return null;
    }

    @Override
    public Coin saveCoin(Coin coin) {
        return null;
    }

    @Override
    public void removeCoin(long id) {

    }
}
