package kesifplus_selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectFromDropdown {
    WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

    }


    @AfterEach
    public void tearDown(){
        driver.quit();

    }


    @Test
    public void selectDropdownByIndex(){

         //List<WebElement> dropdownIdx= driver.findElements(By.cssSelector("select#dropdown"));

      WebElement selectOption1=  driver.findElement(By.id("dropdown"));
     Select select= new Select(selectOption1);
     select.selectByIndex(1);



     }


}
