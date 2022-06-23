package com.tsi.pedro.Project.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class seleniumTest {
    public WebDriver driver;
    public final String HOME_URL= "http://localhost:8000/";


    @BeforeEach
            public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //parameterized testing
    @ParameterizedTest
    @CsvSource({
            "home, index.html",
            "buy, buy.html",
            "about, about.html",
    })
    void testNav(String id, String expectedurl){
        driver.get("http://localhost:8000/index.html");
        driver.findElement(By.id(id)).click();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, HOME_URL + expectedurl, "Incorrect Page");
        driver.quit();
    }





}
