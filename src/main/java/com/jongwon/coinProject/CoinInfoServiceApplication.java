package com.jongwon.coinProject;

import com.jongwon.coinProject.service.CoinInfoService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CoinInfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoinInfoServiceApplication.class, args);

    }
}
