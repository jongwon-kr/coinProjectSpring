package com.jongwon.coinProject.coinInfo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinInfoControllerTest {

    private CoinInfoRepository coinInfoRepository;

    @Test
    void addCoinInfo() {
        coinInfoRepository.save(new CoinInfo("1", "2", "3", "4"));
    }

    @Test
    void retrieveCoinInfos() {
    }
}