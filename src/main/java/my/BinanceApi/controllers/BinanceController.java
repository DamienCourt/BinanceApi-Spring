package my.BinanceApi.controllers;

import my.BinanceApi.services.BinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/refresh")
@CrossOrigin(origins = "http://localhost:5173")
public class BinanceController {
    private final BinanceService binanceService;

    @Autowired
    public BinanceController(BinanceService binanceService){
        this.binanceService = binanceService;
    }

    @PostMapping("/data")
    public String loadTransactions() throws IOException {
        return binanceService.getMarketData("/api/v3/avgPrice","BTCUSDT");
    }

    @PostMapping("/account")
    public String getAccountInfo(){
        return binanceService.getAccountInfo("/api/v3/account");
    }

    @PostMapping("/orders")
    public String getOpenOrders() throws IOException {
        return binanceService.getOpenOrders("api/v3/openOrders","BTCUSDT");
    }


}
