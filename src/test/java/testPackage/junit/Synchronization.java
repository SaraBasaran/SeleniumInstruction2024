package testPackage.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Synchronization {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void beforeEach(){
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @AfterEach
    public void afterEach(){
       // driver.quit();

    }
    @Test
    public void googleSearchTest(){

        driver.navigate().to("https://www.google.com");
        By searchBoxTextArea= By.className(".gLFyf");
        driver.findElement(searchBoxTextArea).sendKeys("Mac Book");


    }




}
