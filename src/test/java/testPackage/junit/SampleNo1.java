package testPackage.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Tests;

public class SampleNo1 extends Tests {

      /*
    Go to URL: https://api.jquery.com/dblclick/
    Double click on the blue square at the bottom of the page
    Write the changed color on search box on the top of the page
    Click "jQuery in Action" at the bottom of the page.

     */


    @Test
    public void doubleClickElementCheck(){
        Actions actions=new Actions(driver);

        driver.navigate().to("https://api.jquery.com/dblclick/");

       WebElement dblClickElement= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(dblClickElement);

        WebElement blueColouredButton= driver.findElement(By.cssSelector("body>div"));
        JavascriptExecutor jsexecutor1= (JavascriptExecutor) driver;
        jsexecutor1.executeScript("arguments[0].scrollIntoView();", blueColouredButton);

        String beforeClickColor=  blueColouredButton.getCssValue("background-color");
        System.out.println("color = " + beforeClickColor);

        actions.doubleClick(blueColouredButton).perform();

        String color=  blueColouredButton.getCssValue("background-color");
        System.out.println("color = " + color);

        Assertions.assertNotEquals(beforeClickColor, color);

        driver.switchTo().defaultContent();

        JavascriptExecutor js= (JavascriptExecutor) driver;


        WebElement searchBar= driver.findElement(By.name("s"));
       //js.executeScript("arguments[0].scrollIntoView();", searchBar); --> that would work fine

        js.executeScript("window.scrollTo(0,0)");
        searchBar.sendKeys(color);

        //a[@href="https://www.manning.com/books/jquery-in-action-third-edition"]

        WebElement jsInActionImg=driver.findElement(By.xpath("//a[@href='https://www.manning.com/books/jquery-in-action-third-edition']"));

        js.executeScript("arguments[0].scrollIntoView();", jsInActionImg);
        jsInActionImg.click();

        String currentURL= driver.getCurrentUrl();
        Assertions.assertEquals("https://www.manning.com/books/jquery-in-action-third-edition", currentURL);

    }

}
