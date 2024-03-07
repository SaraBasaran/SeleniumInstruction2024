package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTests {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void beforeEach(){
        //ChromeOptions chromeOptions=new ChromeOptions();
      // chromeOptions.addArguments("start maximized");
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();

    }

    @AfterEach
    public void afterEach(){
        // driver.quit();

    }
    @Test
    public void alertTest(){

        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
        By alertBtn= By.cssSelector("button[onclick='alertbox()']");
        driver.findElement(alertBtn).click();

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

//Store the alert text in a variable
        String text = alert.getText();

//Press the OK button
        alert.accept();

        Assertions.assertEquals("I am an alert box!", text);
    }



}
