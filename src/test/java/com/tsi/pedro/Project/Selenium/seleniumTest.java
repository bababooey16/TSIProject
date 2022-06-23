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
    void testNav(String id, String expected){
        driver.get("http://localhost:8000/index.html");
        driver.findElement(By.id(id)).click();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, HOME_URL + expected, "Incorrect Page");
        driver.quit();
    }

    @Test
    void testBuy(){
        driver.get("http://localhost:8000/buy.html");

        WebElement input2 = driver.findElement(By.id("input2"));
        input2.sendKeys("5464546454645464");
        WebElement input3 = driver.findElement(By.id("input3"));
        input3.sendKeys("0505");
        WebElement input4 = driver.findElement(By.id("input4"));
        input4.sendKeys("505");

        WebElement button = driver.findElement(By.id("submitbutton"));
        button.click();
        Assertions.assertTrue(Boolean.parseBoolean(input2.getAttribute("required")), "Input incorrect ");
        driver.quit();
    }



}
