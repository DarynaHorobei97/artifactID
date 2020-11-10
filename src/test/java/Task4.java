import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task4 {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lacoste.ua/");
    }
    @Test
    public void login() {
        WebElement accountLink = driver.findElement(By.xpath("//a[@class='js-header-user']"));
        accountLink.click();
        WebElement login = driver.findElement(By.xpath("//input[@name = 'email']"));
        WebElement password = driver.findElement(By.xpath("//input[@name = 'password']"));
        login.sendKeys("daryna_horobei@ukr.net");
        password.sendKeys("Password5");
        WebElement submitButton = driver.findElement(By.xpath("//button[contains( text(),'УВІЙТИ')]"));
        submitButton.click();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
