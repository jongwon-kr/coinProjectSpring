package com.jongwon.coinProject.coinInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CoinInfoController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private CoinInfoService coinInfoService;
    private GetCoinInfoService getCoinInfoService;
    private CoinInfoRepository coinInfoRepository;

    @Autowired
    public CoinInfoController(CoinInfoService coinInfoService, GetCoinInfoService getCoinInfos, CoinInfoRepository coinInfoRepository) {
        this.coinInfoService = coinInfoService;
        this.getCoinInfoService = getCoinInfos;
        this.coinInfoRepository = coinInfoRepository;
    }

    // 코인 정보 요청
    @GetMapping("/coinInfo/market/{market}")
    public CoinInfo retrieveCoinInfo(@PathVariable String market) {
        if(!coinInfoRepository.findById(market).isEmpty()){
            return coinInfoRepository.findById(market).get();
        }else{
            return getCoinInfoService.getCoinInfo(market);
        }
    }

    @DeleteMapping("/coinInfos/{market}")
    public ResponseEntity<Void> deleteCoinInfo(@PathVariable String market) {
        coinInfoRepository.deleteById(market);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/coinInfo/add/{market}")
    public String addCoinInfo(@PathVariable String market) {
        try {
            CoinInfo coinInfo = getCoinInfoService.getCoinInfo(market);
            coinInfoRepository.save(coinInfo);
            return coinInfo.getMarket()+" 코인 정보 로딩 완료";
        } catch (Exception e) {
            return "에러 메시지: " + e.getMessage();
        }
    }

    // 모든 코인 정보들 패치
    @GetMapping("/coinInfos/fetch")
    public String fetchCoinInfos() {
        try {
            List<CoinInfo> coinInfoList = getCoinInfoService.getCoinInfos();
            coinInfoList.stream().forEach(coinInfo -> coinInfoRepository.save(coinInfo));
            return "모든 코인 정보 로딩 완료";
        } catch (Exception e) {
            return "에러 메시지: " + e.getMessage();
        }
    }
}
