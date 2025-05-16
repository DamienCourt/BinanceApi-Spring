package my.BinanceApi.controllers;

import my.BinanceApi.services.BinanceService;
import my.BinanceApi.utils.BinanceSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/refresh")
@CrossOrigin
public class BinanceController {
    private final BinanceService binanceService;

    @Autowired
    public BinanceController(BinanceService binanceService){
        this.binanceService = binanceService;
    }

    @PostMapping("/data")
    public void loadTransactions() throws IOException {

        //String data = binanceService.getMarketData("/api/v3/avgPrice","BTCUSDT" );

    }

}
