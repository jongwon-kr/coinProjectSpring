package com.jongwon.coinProject.coinInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinInfoRepository extends JpaRepository<CoinInfo,String> {
    List<CoinInfo> findByMarket(String market);
}
