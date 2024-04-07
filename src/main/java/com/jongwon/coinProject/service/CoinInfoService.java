package com.jongwon.coinProject.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


@Service
public class CoinInfoService {

    public static void getCoinInfos() {
        ChromeDriver driver;
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");            // 전체화면으로 실행
        options.addArguments("--disable-popup-blocking");    // 팝업 무시
        options.addArguments("--disable-default-apps");     // 기본앱 사용안함
        options.addArguments("--lang=ko-KR");
        driver = new ChromeDriver(options);

        driver.get("https://upbit.com/exchange?code=CRIX.UPBIT.KRW-BTC");
        String title = driver.getTitle();

        List<WebElement> webElementList = new ArrayList<>();
        webElementList = driver.findElements(By.partialLinkText("정보"));

        WebElement element = webElementList.get(0);
        element.click();
        //페이지 이동

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> titleList = new ArrayList<>();

        titleList = driver.findElements(By.className("coinInfo__info__desc"));
        if(titleList==null){
            System.out.println("null");
        }else {
            for (WebElement tele : titleList) {
                if (tele==null){
                    System.out.println("null");
                }else {
                    System.out.println("webElement.getText() = " + tele.getText());
                }
            }
        }

        String pageSource = driver.getPageSource();
        Document doc = Jsoup.parse(pageSource);
        Elements elements = doc.select(".coinInfo__info__desc");
        for (Element ele : elements) {
            System.out.println("element.text() = " + ele.text());
        }

        driver.quit();
    }

    public static void main(String[] args) {
        getCoinInfos();

    }


}
