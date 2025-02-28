package my.BinanceApi.services;

import my.BinanceApi.models.Coin;
import my.BinanceApi.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
    public Optional<Coin> getCoinById(long id) {
        return coinRepository.findById(id);
    }

    @Override
    public void removeCoin(long id) {
        coinRepository.deleteById(id);
    }



    @Override
    public Coin saveCoin(Coin coin) {
        Coin newEntry = new Coin();
        newEntry.setName(coin.getName().toUpperCase());
        newEntry.setAmount(coin.getAmount());
        newEntry.setPurchaseValue(coin.getPurchaseValue());
        newEntry.setPurchasePrice(coin.getPurchasePrice());
        newEntry.setDate(coin.getDate());
        System.out.println(newEntry);

        return coinRepository.save(newEntry);
    }


}
