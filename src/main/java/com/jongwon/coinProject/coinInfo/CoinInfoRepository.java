package com.jongwon.coinProject.coinInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoinInfoRepository extends JpaRepository<CoinInfo,String> {
}
