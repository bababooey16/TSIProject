package com.tsi.pedro.Project.Cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class failToAddNewShopperViaWebSiteStepsDef {
    private WebDriver driver;

    @Given("The service is currently running")
    public void the_service_is_currently_running() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @When("The buy page is currently open")
    public void the_buy_page_is_currently_open() {
        System.out.printf("psghaetii");
        driver.get("http://localhost:8000/buy.html");
    }
    @When("I enter {string}, {string}, {string}, {string}")
    public void i_enter(String name, String card, String expiry, String cvc) {
        WebElement input1 = driver.findElement(By.id("input1"));
        input1.sendKeys(name);
        WebElement input2 = driver.findElement(By.id("input2"));
        input2.sendKeys(card);
        WebElement input3 = driver.findElement(By.id("input3"));
        input3.sendKeys(expiry);
        WebElement input4 = driver.findElement(By.id("input4"));
        input4.sendKeys(cvc);
    }
    @When("The submit button is pressed")
    public void the_submit_button_is_pressed() {
        WebElement button = driver.findElement(By.id("submitbutton"));
        button.click();

    }
    @Then("A validation error will show {string}")
    public void a_validation_error_will_show(String inputs) {
        WebElement finalInput = driver.findElement(By.id(inputs));

        Assertions.assertTrue(Boolean.parseBoolean(finalInput.getAttribute("required")), "Input incorrect ");
        driver.quit();
    }

}
