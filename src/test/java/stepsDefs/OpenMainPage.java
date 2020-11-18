package stepsDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class OpenMainPage {

    public static WebDriver driver;
    protected String url = "https://ecsc00a03ccd.epam.com:9002/yacceleratorstorefront/?site=electronics";


    @Given("I am anonymous customer and I open main page")
    public void iAmAnonymousCustomerAndIOpenMainPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }
}
