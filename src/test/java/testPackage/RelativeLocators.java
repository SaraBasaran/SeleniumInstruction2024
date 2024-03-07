package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocators {

/**
 * Navigate to <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
 * login as standard_user
 * use Selenium Relative Locators to identify the login button
 */

WebDriver driver;

    String landingPageUrl = "https://www.saucedemo.com/v1/inventory.html";
    @BeforeEach
public void beforeEach(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.navigate().to("https://www.saucedemo.com/v1/index.html");
}

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

    String standardUser = "standard_user";
    String lockedOutUser = "locked_out_user";
    String unifiedPassword = "secret_sauce";
    @Test
    public void successfulLogin(){
        login (standardUser,unifiedPassword);
        var currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(landingPageUrl, currentUrl);
    }

    private void login(String username, String password){
        By usernameTextArea = By.id("user-name");
        By passwordTextArea = By.id("password");
        By loginButton = By.id("login-button");

        driver.findElement(usernameTextArea).sendKeys(username);
        driver.findElement(passwordTextArea).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    /** how to convert xpath to css?
     * xpath = //tagName[@attribute='value']
     * css = tagName[attribute='value']
     * xpath = //tagName[@id='value']
     * css = tagName#value
     * xpath = //tagName[@class='value']
     * css = tagName.value
     */






}
