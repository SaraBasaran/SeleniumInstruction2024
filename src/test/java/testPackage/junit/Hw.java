package testPackage.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Tests;
//import utilities.kesifplus_selenium.TestBase;

import java.awt.*;
import java.time.Duration;

public class Hw extends Tests {

/*
   Amazon Scenario:
1. Open the https://www.amazon.com/ca/ website.
2. Verify that the home page is opened.
3. Accept cookies by selecting "Accept Cookies" from the cookie preferences.
4. Log in to the site. Email: "bigasatranc@gmail.com" , password: "Pass123"
5. Verify the login process.
6. Create a new list named "Shopping List for Ramadan Eid" from the "My Account" section.
7. Select the "Computer" category from the categories tab next to the search button.
8. Verify that the "Computer" category is selected.
9. Enter "msi" in the search field and perform a search.
10. Verify that the search is performed.
11. Open the 2nd page from the search results page.
12. Verify that the 2nd page is opened.
13. Add the 2nd product on the page to the "Shopping List for Ramadan Eid" list.
14. Verify that the 2nd product is added to the list.
15. Go to the "Shopping List" page in "My Account."
16. Verify that the "Shopping List" page is opened.
17. Remove the added product from the "Shopping List for Ramadan Eid."
18. Verify that the deletion is successful.
19. Delete the "Shopping List for Ramadan Eid."
20. Perform the logout operation.
21. Verify that the logout process is completed.
Note: The "Shopping List for Ramadan Eid" is deleted to ensure no issues when the task is rerun.
*/


        @Test
        public void virgosol() throws AWTException, InterruptedException {
            Actions actions=new Actions(driver);
            JavascriptExecutor jse = ((JavascriptExecutor) driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Robot robot = new Robot();

            // Open the https://www.amazon.com/ca website.
            driver.get("https://www.amazon.com/ca/");
            wait.withTimeout(Duration.ofSeconds(3));

            // Verify that the home page is opened.
            driver.navigate().refresh();
            Assertions.assertTrue(driver.getCurrentUrl().contains("amazon.com/ca"));


            // Accept cookies by selecting "Accept Cookies" from the cookie preferences.
//            WebElement cookieAcceptButton = driver.findElement(By.id("sp-cc-accept"));
//            if (cookieAcceptButton.isDisplayed()) {
//                cookieAcceptButton.click();
//            }

            // Log in to the site.
            driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
            driver.findElement(By.id("ap_email")).sendKeys("bigasatranc@gmail.com");
            driver.findElement(By.cssSelector("span#continue")).click();
            driver.findElement(By.id("ap_password")).sendKeys("Pass123" + Keys.ENTER);

            // Verify the login process.
            Assertions.assertTrue(driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText().contains("Biga"));
            Assertions.assertFalse(driver.findElement(By.xpath("//a[@id='nav-link-accountList']/div")).getText().contains("Giriş"));

            // Create a new list named "Shopping List for Ramadan Eid" from the "My Account" section.
            WebElement accountLists = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
            accountLists.click();
            driver.findElement(By.xpath("(//span[@class='a-color-secondary'])[9]")).click();
            driver.findElement(By.xpath("//span[text()='Account & Lists']")).click();

            driver.findElement(By.cssSelector("span.nav-text")).click();

     //       Actions actions1=new Actions(driver);
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("document.getElementByCssSelector('a.').setAttribute('class', 'sub-nav animation enable')");
//
//           WebElement createListLink= driver.findElement(By.xpath("//span[text()='Create a List']"));
//            actions1.moveToElement(createListLink).build().perform();




            driver.findElement(By.id("list-name")).clear();
            driver.findElement(By.id("list-name")).sendKeys("");
            WebElement createListButton = driver.findElement(By.xpath("(//input[@class='a-button-input a-declarative'])[3]"));
            wait.until(ExpectedConditions.elementToBeClickable(createListButton));
            createListButton.sendKeys(Keys.ENTER);

            // Select the "Computer" category from the categories tab next to the search button.
            driver.navigate().refresh();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='nav-search-facade']")));
            WebElement categoriesDropDown = driver.findElement(By.id("searchDropdownBox"));
            Select select = new Select(categoriesDropDown);
            select.selectByValue("search-alias=computers");

            // Verify that the "Computer" category is selected.
            Assertions.assertTrue(select.getFirstSelectedOption().getText().contains("Bilgisayar"));

            // Enter "msi" in the search field and perform a search.
            actions.click(driver.findElement(By.id("twotabsearchtextbox"))).sendKeys("msi" + Keys.ENTER).perform();

            // Verify that the search is performed.
            WebElement searchedProduct = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
            Assertions.assertTrue(searchedProduct.getText().contains("msi"));

            // Open the 2nd page from the search results page.
            actions.click(driver.findElement(By.xpath("//a[@aria-label='2 sayfasına git']"))).perform();

            // Verify that the 2nd page is opened.
            Assertions.assertEquals("2", driver.findElement(By.xpath("//span[@aria-label='Geçerli sayfa, sayfa 2']")).getText());

            // Add the 2nd product on the page to the "Virgosol Liste" list.
            driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[2]")).click();
            driver.findElement(By.id("add-to-wishlist-button-submit")).click();

            // Verify that the 2nd product is added to the list.
            Assertions.assertTrue(driver.findElement(By.xpath("//*[.='1 ürün şuraya eklendi:']")).isDisplayed());

            // Go to the "Shopping List" page in "My Account."
            driver.findElement(By.xpath("//button[@data-action='a-popover-close']")).click();
            Thread.sleep(2000);
            robot.mouseWheel(-500);
            WebElement accountLink = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
            jse.executeScript("arguments[0].click();", accountLink);
            driver.findElement(By.xpath("//img[@alt='Listeleriniz']")).click();

            // Verify that the "Virgosol Listesi" page is opened.
            Assertions.assertTrue(driver.findElement(By.id("profile-list-name")).getText().toLowerCase().contains("virgosol"));

            // Remove the added product from the "Virgosol Liste."
            driver.findElement(By.name("submit.deleteItem")).click();

            // Verify that the deletion is successful.
            Assertions.assertTrue(driver.findElement(By.xpath("(//div[.='Silindi'])[2]")).isDisplayed());

            // Delete the "Virgosol Liste."
            WebElement moreOptions = driver.findElement(By.id("overflow-menu-popover-trigger"));
            jse.executeScript("arguments[0].click();", moreOptions);

            WebElement manageList = driver.findElement(By.id("editYourList"));
            jse.executeScript("arguments[0].click();", manageList);
            Thread.sleep(2000);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            actions.sendKeys(Keys.PAGE_DOWN).perform();

            WebElement listeyiSil= driver.findElement(By.xpath("//span[contains(text(),'Listeyi sil')]"));

            jse.executeScript("arguments[0].click();", listeyiSil);

            WebElement evetButton = driver.findElement(By.id("list-delete-confirm-announce"));
            wait.until(ExpectedConditions.textToBePresentInElement(evetButton, "Evet"));
            jse.executeScript("arguments[0].click();",evetButton);

            //Log out
            robot.mouseWheel(-500);
            driver.navigate().refresh();
            WebElement hesaplar= driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
            wait.until(ExpectedConditions.textToBePresentInElement(hesaplar,"Hesap ve Listeler"));
            actions.moveToElement(hesaplar).perform();

            WebElement cikisYap= driver.findElement(By.xpath("//span[contains(text(),'Çıkış Yap')]"));

            jse.executeScript("arguments[0].click();",cikisYap );

            //Verify log out process completed
            Assertions.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Giriş yap')]")).getText().contains("Giriş yap"));

        }
    }


