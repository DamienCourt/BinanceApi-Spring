package my.BinanceApi.controllers;

import my.BinanceApi.models.Coin;
import my.BinanceApi.services.CoinService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/panel")
@CrossOrigin(origins = "http://localhost:5173")
public class DisplayTransactionsController {

    private final CoinService coinService;

    public DisplayTransactionsController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping(value = "/all")
    public List<Coin> listAllCoins(){
        return coinService.getAllCoinsSorted();
    }

    @GetMapping(value = "/name/{name}")
    public List<Coin> listCoinsByName(@PathVariable String name){
        return coinService.getCoinsByName(name);
    }

    @GetMapping(value = "/id/{id}")
    public Optional<Coin> getCoinById(@PathVariable long id){
        return coinService.getCoinById(id);
    }

}
