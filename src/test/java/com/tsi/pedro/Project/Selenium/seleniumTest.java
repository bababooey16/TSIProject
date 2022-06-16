package com.tsi.pedro.Project.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class seleniumTest {
    public WebDriver driver;

    //Selenium tests for my webpage
    @Test
    public void chromeDriverTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }
    @Test
    public void chromeSessionTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        driver.quit();
    }

    //test for connecting to localsite, and interacting with tictactoe web app
    @Test
    public void webSiteConnectionTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8000/");
        String title = driver.getTitle();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement squarebutton = driver.findElement(By.className("square"));
        squarebutton.click();
        WebElement squarebutton3 = driver.findElement(By.xpath("(//*[@class='square'])[3]"));
        squarebutton3.click();
        WebElement historybutton = driver.findElement(By.xpath("(//*[@id='historybutton'])[2]"));
        historybutton.click();
    }







}
