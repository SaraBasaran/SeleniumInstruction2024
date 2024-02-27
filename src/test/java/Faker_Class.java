import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;

public class Faker_Class extends TestBase{


    @Test

    public void loginToAmazon() throws InterruptedException {

        Faker fakeName= new Faker();

       String fakerEmailInput= fakeName.internet().emailAddress();

        driver.findElement(By.cssSelector("input#email")).sendKeys(fakerEmailInput);

        driver.wait(3000);

       String fakePwd= fakeName.internet().password(8, 20,true, true, true);

       driver.wait(3000);
        driver.findElement(By.xpath("")).sendKeys(fakePwd);

    }

}
