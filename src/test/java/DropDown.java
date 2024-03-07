import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class DropDown extends TestBase{

    @Test

    public void trendyolDropdown() throws InterruptedException {

           List<WebElement> subheaderList= driver.findElements(By.cssSelector("a.sub-category-header"));

       try{
            Actions action = new Actions(driver);
            WebElement headerKadin = driver.findElement(By.xpath("//a[@href='/butik/liste/1/kadin']"));

            action.moveToElement(headerKadin).build().perform();

           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("document.getElementById('sub-nav-1').setAttribute('class', 'sub-nav animation enable')");

            for (WebElement dropdownEle: subheaderList) {
                String subheaderItem= dropdownEle.getText();
                System.out.println(subheaderItem);
            }

        }catch (StaleElementReferenceException e){

            System.out.println("subheaderList = " + subheaderList);

        }

       //sub-item-list
       List<WebElement> subItemList= driver.findElements(By.xpath("//ul[@class='sub-item-list']"));

        Assert.assertEquals(subItemList.size(), 84);

        for (WebElement eachSubItem: subItemList) {
            String subListItem= eachSubItem.getText();
            System.out.println(subListItem);
        }























                //a.category-titles
      // By firstSubHeader= driver.findElements().getFirst().getText();
        // creative approach

        //        By firstCartItemNameLabel = By.xpath("//div[@class='inventory_item_name']");
        //        var actualFirstItemName = driver.findElement(firstCartItemNameLabel).getText();
        //        Assertions.assertEquals("Sauce Labs Backpack", actualFirstItemName);

    }


}
