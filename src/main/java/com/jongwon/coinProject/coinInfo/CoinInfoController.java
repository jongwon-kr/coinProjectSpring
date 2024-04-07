package com.jongwon.coinProject.coinInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinInfoController {
    private CoinInfoService coinInfoService;
    private CoinInfoRepository coinInfoRepository;

    @Autowired
    public CoinInfoController(CoinInfoService coinInfoService, CoinInfoRepository coinInfoRepository) {
        this.coinInfoService = coinInfoService;
        this.coinInfoRepository = coinInfoRepository;
    }

    @GetMapping("/coin-info?market={market}")
    public CoinInfo retrieveCoinInfo(@PathVariable String market) {
        return coinInfoService.findByMarket(market);
    }
}
