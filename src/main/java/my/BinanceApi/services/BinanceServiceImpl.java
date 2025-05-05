package my.BinanceApi.services;

import my.BinanceApi.models.Coin;
import my.BinanceApi.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BinanceServiceImpl implements BinanceService{
    private final CoinRepository coinRepository;
    private final String api_key = "";
    private final String url = "https://api.binance.com";


    @Autowired
    public BinanceServiceImpl(CoinRepository coinRepository){
        this.coinRepository = coinRepository;
    }

    @Override
    public List<Coin> getAllTransactions() {

        coinRepository.findAll();
        System.out.println();
        return List.of();
    }
}
