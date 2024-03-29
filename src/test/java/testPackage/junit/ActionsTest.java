package testPackage.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.Tests;

import java.io.File;
import java.time.Duration;
import java.util.Objects;

public class ActionsTest extends Tests {

    @BeforeEach
    public void beforeEach(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(1))
                .ignoring(NoSuchElementException.class);
    }

    @Test
    public void dragAndDrop(){
        driver.navigate().to("https://www.selenium.dev/selenium/web/droppableItems.html");
        By draggable = By.id("draggable");
        By droppable = By.id("droppable");

        new Actions(driver)
//                .clickAndHold(driver.findElement(draggable))
//                .pause(Duration.ofMillis(500))
//                .moveToElement(driver.findElement(droppable))
//                .pause(Duration.ofMillis(500))
//                .release()
                .dragAndDrop(driver.findElement(draggable)
                        , driver.findElement(droppable))
                .perform();

        Assertions.assertEquals("Dropped!"
                , driver.findElement(droppable).getText());
    }

    @Test
    public void dragHorizontally(){
        driver.navigate().to("https://rangeslider.js.org/");
        By sliderHandle = By.className("rangeslider__handle");
        By output = By.id("js-output");

        wait.until(f ->{
            new Actions(driver)
                    .dragAndDropBy(driver.findElement(sliderHandle), 10, 0)
                    .perform();
            return Objects.equals(driver.findElement(output).getText(), "700");
        });

//        new Actions(driver)
//                .clickAndHold(driver.findElement(sliderHandle))
//                .moveByOffset(210,0)
//                .perform();

        Assertions.assertEquals("700"
                , driver.findElement(output).getText());
    }

    @Test
    public void javascriptExecutorTest(){
        driver.navigate().to("https://www.selenium.dev/");
//        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000);");

        By browserStackImage = By.xpath("//img[@alt='BrowserStack']");
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(browserStackImage));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(browserStackImage));

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        new Actions(driver).scrollToElement(driver.findElement(browserStackImage)).perform();
        driver.findElement(browserStackImage).click();
    }
}