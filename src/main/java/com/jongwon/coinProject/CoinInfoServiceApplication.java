package com.jongwon.coinProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoinInfoServiceApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CoinInfoServiceApplication.class, args);
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium.dev");
        driver.quit();
    }
}
