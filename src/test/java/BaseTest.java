import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected static WebDriver driver;

   protected String url = "https://ecsc00a03ccd.epam.com:9002/yacceleratorstorefront/?site=electronics";

    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @After
    public void tearDown() {
        //closeWebDriver();
        driver.quit();
    }

}
