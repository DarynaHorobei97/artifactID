import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Task1_B2BAccelerator.class
})

public class Task1_B2BAccelerator {

    private WebDriver driver;
    private String url = "https://ecsc00a03ccd.epam.com:9002/yacceleratorstorefront/?site=electronics";
    private String pathForSearchField = "//input[@id='js-site-search-input']";
    private String pathForSearchButton = "//button[@type='submit']";

    private String pathForAddToCartButton = "//button[@class='btn btn-primary btn-block glyphicon glyphicon-shopping-cart js-enable-btn']";

    @BeforeEach
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void checkoutTest() {
        WebElement searchField = driver.findElement(By.xpath(pathForSearchField));
        searchField.sendKeys("1934793");
        WebElement searchButton = driver.findElement(By.xpath(pathForSearchButton));
        searchButton.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"addToCartForm1934793\"]/button"));
        addToCartButton.click();
        WebElement checkout = driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/a[1]"));
        checkout.click();
        WebElement subTotal = driver.findElement(By.xpath("//div[@class='col-xs-6 cart-totals-right text-right']"));
        WebElement total = driver.findElement(By.xpath("//div[@class='col-xs-6 cart-totals-right text-right grand-total']"));
        WebElement checkout1 = driver.findElement(By.xpath("//div[@class='cart__actions']//button[contains( text(),'Check')]"));


        Assertions.assertAll("Total prices do not equal",
                () -> assertEquals("$99.85", subTotal.getText()),
                () -> assertEquals("$99.85", total.getText())
        );


        checkout1.click();
        WebElement guestEmail = driver.findElement(By.xpath("//*[@id=\"guest.email\"]"));
        WebElement confirmEmail = driver.findElement(By.xpath("//*[@id=\"guest.confirm.email\"]"));
        guestEmail.sendKeys("test@user.com");
        confirmEmail.sendKeys("test@user.com");
        WebElement checkOutAsGuestButton = driver.findElement(By.xpath("//*[@id=\"guestForm\"]/div[3]/button"));
        checkOutAsGuestButton.click();
        WebElement subtotal1 = driver.findElement(By.xpath("//div[@class='subtotal']/span"));
        WebElement total1 = driver.findElement(By.xpath("//div[@class='totals']/span"));
        WebElement tax = driver.findElement(By.xpath("//div[@class='realTotals']/p"));


        Assertions.assertAll("Total prices do not equal",
                () -> assertEquals("$99.85", subtotal1.getText()),
                () -> assertEquals("$104.84", total1.getText()),
                () -> assertEquals("Your order includes $4.99 tax.", tax.getText())
        );


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}




