package kesifplus_selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;

public class TestCase01 {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");

    }


    @AfterEach
    public void tearDown() {
        //driver.quit();

    }

    @Test
    public void testcase01() {

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("porcelain pot");
        Actions actions= new Actions(driver);

        actions.sendKeys(Keys.ENTER).perform();

        String resultText=driver.findElement(By.cssSelector("div#result-stats")).getText();
        System.out.println("resultText = " + resultText);

        String[] firstFormatted=resultText.split(" ");
        System.out.println("Arrays.toString(firstFormatted) = " + Arrays.toString(firstFormatted));

        String resultInString= firstFormatted[1].replace(".", "");
        int resultNum= Integer.parseInt(resultInString);
        System.out.println("resultNum = " + resultNum);

        Assertions.assertTrue(resultNum>1000000);


    }
}