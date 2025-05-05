package my.BinanceApi.controllers;

import my.BinanceApi.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/refresh")
@CrossOrigin
public class BinanceController {
    private final CoinService coinService;

    @Autowired
    public BinanceController(CoinService coinService){
        this.coinService = coinService;
    }

    @PostMapping("/data")
    public void loadTransactions(){
        coinService.getAllCoins();
        System.out.println("load");
    }

}
