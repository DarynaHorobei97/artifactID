import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
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
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Daryna_Horobei\\Downloads\\chromedriver_win32_86\\chromedriver.exe");
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

        assertEquals(subTotal.getText(), "$99.85");
        assertEquals(total.getText(), "$99.85");

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

        assertEquals("$99.85", subtotal1.getText());
        assertEquals("$104.84", total1.getText());
        assertEquals("Your order includes $4.99 tax.", tax.getText());
    }


//    @Test
//    public void locatorsLocation() {
//        WebElement logo = driver.findElement(By.xpath("//img[@title='hybris Accelerator']"));
//        WebElement SignOrRegisterButton = driver.findElement(By.xpath("//a[contains( text(),'Sign')]"));
//        WebElement searchField = driver.findElement(By.xpath("//*[@id='js-site-search-input']"));
//        List<WebElement> navigationMenu = driver.findElements(By.xpath("//ul[@class='nav__links nav__links--products js-offcanvas-links']//a"));
//        WebElement banner = driver.findElement(By.xpath("//img[@class='js-responsive-image']"));
//    }
//
//    @Test
//    public void searchAndAddToCartCamelio() {
//        WebElement searchField = driver.findElement(By.xpath(pathForSearchField));
//        searchField.sendKeys("camileo");
//        WebElement searchButton = driver.findElement(By.xpath(pathForSearchButton));
//        searchButton.click();
//        WebElement addToCartButton = driver.findElement(By.xpath(pathForAddToCartButton));
//        addToCartButton.click();
//        WebElement continueShopButton = driver.findElement(By.xpath("//a[contains(text(),'Continue Shopping')]"));
//        continueShopButton.click();
//        WebElement camelioLink = driver.findElement(By.xpath("//a[@href='/yacceleratorstorefront/electronics/en/Open-Catalogue/Cameras/Hand-held-Camcorders/Camileo-S10-EU/p/1776948']"));
//        camelioLink.click();
//    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}




