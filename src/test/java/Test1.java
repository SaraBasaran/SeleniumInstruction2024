import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Test1 extends TestBase{
 @Test
    public void test1() throws InterruptedException {

     String pageURL= driver.getCurrentUrl();
     Thread.sleep(3000);
     Assert.assertEquals("https://www.trendyol.com/", pageURL);

     int x = 10;
     int y = 20;

     SoftAssert softAssert= new SoftAssert();

     softAssert.assertEquals(x,y);

      WebDriverWait driverWait= new WebDriverWait(driver, Duration.ofSeconds(8));
      driverWait.withMessage("test passes");

     driver.findElement(By.cssSelector("div.modal-close")).click();
     driver.findElement(By.cssSelector("div#browsing-gw-homepage a:nth-child(3) > span")).click();

     softAssert.assertAll();

 }


}
