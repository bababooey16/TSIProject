package com.tsi.pedro.Project.Cucumber;

import com.sun.xml.bind.v2.TODO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
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
import java.util.List;
import java.util.Map;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerinfo")));
        Expected = "Your Customer";
        Actual = driver.getTitle();
        Assertions.assertEquals(Expected, Actual);
        driver.quit();

    }

    @Given("The service is currently running")
    public void the_service_is_currently_running() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @When("The buy page is currently open")
    public void the_buy_page_is_currently_open() {
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



    @Given("The API is currently running")
    public void the_api_is_currently_running() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @When("The buy page is presently open")
    public void the_buy_page_is_presently_open() {
        driver.get("http://localhost:8000/buy.html");
    }
    @When("I input {string}, {string}, {string}, {string}")
    public void i_input(String name, String card, String expiry, String cvc) {
        WebElement input1 = driver.findElement(By.id("input1"));
        input1.sendKeys(name);
        WebElement input2 = driver.findElement(By.id("input2"));
        input2.sendKeys(card);
        WebElement input3 = driver.findElement(By.id("input3"));
        input3.sendKeys(expiry);
        WebElement input4 = driver.findElement(By.id("input4"));
        input4.sendKeys(cvc);
    }
    @When("I press the submit button")
    public void i_press_the_submit_button() {
        WebElement button = driver.findElement(By.id("submitbutton"));
        button.click();
    }
    @Then("a validation format error will show {string}")
    public void a_validation_format_error_will_show(String inputs) {
        WebElement finalInput = driver.findElement(By.id(inputs));
        Assertions.assertTrue(Boolean.parseBoolean(finalInput.getAttribute("required")), "Input incorrect ");
        driver.quit();
    }




}
