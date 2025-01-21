package my.BinanceApi.controllers;

import my.BinanceApi.models.Coin;
import my.BinanceApi.services.CoinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/panel")
public class DisplayCoinsController {

    private final CoinService coinService;

    public DisplayCoinsController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping(value = "/all")
    public List<Coin> listAllCoins(){
        return coinService.getAllCoins();
    }

    @GetMapping(value = "/name/{name}")
    public List<Coin> listCoinsByName(@PathVariable String name){
        return coinService.getCoinsByName(name);
    }

    @GetMapping(value = "/id/{id}")
    public Optional<Coin> getCoinById(@PathVariable long id){
        return coinService.getCoinById(id);
    }

    @GetMapping(value = "/r/{id}")
    public void removeCoinById(@PathVariable long id){
        coinService.removeCoin(id);
    }

}
