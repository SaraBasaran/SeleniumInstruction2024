package kesifplus_selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Checkbox extends TestBase {

    @Test

    public void checkBoxTest(){

        WebElement checkBox= TestBase.driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

        //Select selectCheckbox= new Select(checkBox);

       // selectCheckbox.selectByVisibleText(" checkbox 1");

        checkBox.click();

        Assert.assertTrue(checkBox.isSelected());


    }


}
