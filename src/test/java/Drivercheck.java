import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Drivercheck {
    public static void main(String[] args) {
       // WebDriverManager.chromedriver().setup(); --> selenium 4.6 and over no need to use webdriver manager..)
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.get("https://techproeducation.com/");


    }
}
