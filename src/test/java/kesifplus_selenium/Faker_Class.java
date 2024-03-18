package kesifplus_selenium;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;

public class Faker_Class extends TestBase {


    @Test

    public void loginToAmazon() throws InterruptedException {

        Faker fakeName= new Faker();

       String fakerEmailInput= fakeName.internet().emailAddress();

        TestBase.driver.findElement(By.cssSelector("input#email")).sendKeys(fakerEmailInput);

        TestBase.driver.wait(3000);

       String fakePwd= fakeName.internet().password(8, 20,true, true, true);

       TestBase.driver.wait(3000);
        TestBase.driver.findElement(By.xpath("")).sendKeys(fakePwd);

    }

}
