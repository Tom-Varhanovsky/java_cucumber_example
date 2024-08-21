package java_cucumber_example;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import static java.lang.Thread.sleep;

public class StepDefinitions {

    private final WebDriver driver = new FirefoxDriver();

    @Given("Login website is open")
    public void loginWebsiteIsOpen() throws InterruptedException {
        //WebDriver driver = new FirefoxDriver();
        driver.get("https://practice.expandtesting.com/login");
        sleep(1000);

    }

    @When("user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String usrname, String passwd) {
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(usrname);
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(passwd);
    }

    @When("user clicks login")
    public void clicksLogin() {
        WebElement loginButton = driver.findElement(By.xpath("//button[text() = 'Login']"));
        loginButton.click();
    }


    @Then("user is shown success alert")
    public void isShownSuccessAlert() {
        WebElement alertSuccess = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));
        assert alertSuccess.isDisplayed();
    }

    @Then("user is shown failure alert")
    public void isShownFailureAlert() {
        WebElement alertFailure = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        assert alertFailure.isDisplayed();
    }

    @Then("is shown secure area page")
    public void isShownSecureAreaPage() {
        WebElement secureAreaSuccess = driver.findElement(By.xpath("//h1[contains(text(), 'Secure Area page for Automation Testing Practice')]"));
        assert (secureAreaSuccess.isDisplayed() && driver.getCurrentUrl().equals("https://practice.expandtesting.com/secure"));
    }

    @After
    public void cleanup() {
        driver.quit();
    }

}
