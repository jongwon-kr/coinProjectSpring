package com.jongwon.coinProject.coinInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CoinInfoController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private CoinInfoService coinInfoService;
    private CoinInfoRepository coinInfoRepository;

    @Autowired
    public CoinInfoController(CoinInfoService coinInfoService, CoinInfoRepository coinInfoRepository) {
        this.coinInfoService = coinInfoService;
        this.coinInfoRepository = coinInfoRepository;
    }

    @GetMapping("/get-coin-info/market={market}")
    public CoinInfo retrieveCoinInfo(@PathVariable String market) {
        return coinInfoService.getCoinInfo(market);
    }

    @GetMapping("/hello-world")
    public String helloworld() {
        return "HelloWorld";
    }

    @GetMapping("/get-coin-infos")
    public String retrieveCoinInfos() throws Exception {
        logger.info("Start get Coin Infos");

        List<CoinInfo> coinInfoList = coinInfoService.getCoinInfos();
        for (CoinInfo coinInfo : coinInfoList) {
            System.out.println("coinInfo.getMarket() = " + coinInfo.toString());
        }

        logger.info("End get Coin Infos");

        return "코인 정보 로딩 완료";
    }
}
