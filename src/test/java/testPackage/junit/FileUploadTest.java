package testPackage.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.Tests;

public class FileUploadTest extends Tests {
    /**
     * Breakout Activity: 20 minute
     * navigate to <a href="https://the-internet.herokuapp.com/upload">Upload Test</a>
     * uploading any file from your machine (make it small please)
     * checking to see that the file was successfully uploaded
     */

    @Test
    public void uploadFileTEst(){

        driver.get("https://the-internet.herokuapp.com/upload");
        By fileUploadInput= By.id("file-upload");
        driver.findElement(fileUploadInput).sendKeys("C:\\Users\\sarab\\OneDrive\\Documents\\my-cypress-framework\\node_modules\\type-fest\\source\\asyncify.d.ts");

        driver.findElement(fileUploadInput).submit();

        By uploadSuccessfullyLabel=By.tagName("h3");
        Assertions.assertTrue(driver.findElement(uploadSuccessfullyLabel).isDisplayed());



    }

}
