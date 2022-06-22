package com.tsi.pedro.Project.Cucumber;

import com.sun.xml.bind.v2.TODO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class addNewShopperViaWebsiteStepsDef {
    private WebDriver driver;
    private String Expected;
    private String Actual;


    @Given("The service is running")
    public void the_service_is_running() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @When("The buy page is open")
    public void the_buy_page_is_open() {
        driver.get("http://localhost:8000/buy.html");


    }
    @When("The submit button is clicked")
    public void the_submit_button_is_clicked() {
        WebElement input1 = driver.findElement(By.id("input1"));
        input1.sendKeys("seleneium test");
        WebElement input2 = driver.findElement(By.id("input2"));
        input2.sendKeys("5464546454645464");
        WebElement input3 = driver.findElement(By.id("input3"));
        input3.sendKeys("0505");
        WebElement input4 = driver.findElement(By.id("input4"));
        input4.sendKeys("505");
        WebElement button = driver.findElement(By.id("submitbutton"));
        button.click();
    }
    @Then("Redirected to success page")
    public void redirected_to_success_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerinfo")));
        Expected = "Your Customer";
        Actual = driver.getTitle();
        Assertions.assertEquals(Expected, Actual);
        driver.quit();



    }
}
