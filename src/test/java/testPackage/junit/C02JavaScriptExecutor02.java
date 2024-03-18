package testPackage.junit;

import org.openqa.selenium.interactions.Actions;
import utilities.Tests;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JScriptUtilities;
import utilities.Tests;

public class C02JavaScriptExecutor02 extends Tests {
    /*
    Go to URL: https://api.jquery.com/dblclick/
    Double click on the blue square at the bottom of the page
    Write the changed color on search box on the top of the page
    Click "jQuery in Action" at the bottom of the page.

     */
    Actions actions=new Actions(driver);
    @Test
    public void test() {

        driver.get("https://api.jquery.com/dblclick/");
        driver.switchTo().frame(0);
        WebElement colouredButton = driver.findElement(By.cssSelector("body>div"));

        JScriptUtilities.scrollIntoViewJS(driver, colouredButton);

        actions
                .doubleClick(colouredButton)
                .perform();

        String colorCode = colouredButton.getCssValue("background-color");

        driver.switchTo().defaultContent();

        JScriptUtilities.scrollAllUpByJS(driver);

        driver.findElement(By.name("s")).sendKeys(colorCode);

        JScriptUtilities.scrollDownByJS(driver);
        driver.findElement(By.xpath("//a[@href = 'https://www.manning.com/books/jquery-in-action-third-edition']")).click();

    }
}