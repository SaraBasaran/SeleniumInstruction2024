import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TestBase {
     public static WebDriver driver= new ChromeDriver();

    @Before
    public void setUp(){
      // *** after selenium 4.6 no need for web driver manager and system setup arrangements...

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.trendyol.com/butik/liste/1/kadin");
         driver.manage().window().maximize();
    }

    @After
    public void tearDown(){

       // driver.close();

    }

}
