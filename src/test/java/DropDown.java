import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Collections;
import java.util.List;

public class DropDown extends TestBase{

    @Test

    public void trendyolDropdown() throws InterruptedException {

              List<WebElement> dropdownList= driver.findElements(By.cssSelector("a.sub-category-header"));
        driver.findElement(By.xpath("//a[@href=\"/butik/liste/1/kadin\"]")).sendKeys(Keys.ENTER);

        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//a[@href=\"/butik/liste/1/kadin\"]"));
        action.moveToElement(we).build().perform();
        driver.wait(3000);

        for (WebElement dropdownEle: dropdownList) {
           String dropdownListKadin= dropdownEle.getText();
            System.out.println("dropdownListKadin = " + dropdownListKadin);
        }



      



                //a.category-titles
      // By firstSubHeader= driver.findElements().getFirst().getText();
        // creative approach

        //        By firstCartItemNameLabel = By.xpath("//div[@class='inventory_item_name']");
        //        var actualFirstItemName = driver.findElement(firstCartItemNameLabel).getText();
        //        Assertions.assertEquals("Sauce Labs Backpack", actualFirstItemName);

    }


}
