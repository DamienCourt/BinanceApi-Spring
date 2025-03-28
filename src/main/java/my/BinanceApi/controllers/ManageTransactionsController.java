package my.BinanceApi.controllers;

import my.BinanceApi.models.Coin;
import my.BinanceApi.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/panel")
@CrossOrigin
public class ManageTransactionsController {
    private final CoinService coinService;

    @Autowired
    public ManageTransactionsController(CoinService coinService){
        this.coinService = coinService;
    }

    @PostMapping("/submitForm")
    @ResponseBody
    public long saveTransaction(@RequestBody Coin coin){
        Coin response = coinService.saveCoin(coin);
        return response.getId();
    }

    @PostMapping("/remove/{id}")
    public void removeTransaction(@PathVariable long id){
        coinService.removeCoin(id);
    }
}
