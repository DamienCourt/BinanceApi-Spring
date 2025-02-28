package my.BinanceApi.controllers;

import my.BinanceApi.models.Coin;
import my.BinanceApi.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panel")
@CrossOrigin
public class ManageTransactionsController {
    private final CoinService coinService;

    @Autowired
    public ManageTransactionsController(CoinService coinService){
        this.coinService = coinService;
    }

    @PostMapping("/form")
    public void savecoin(@RequestBody Coin coin){
        System.out.println(coin);
        coinService.saveCoin(coin);
    }
}
