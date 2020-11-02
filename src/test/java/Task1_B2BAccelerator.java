import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1_B2BAccelerator {

    private WebDriver driver;
    private String url = "https://ecsc00a03ccd.epam.com:9002/yacceleratorstorefront/?site=electronics";
    private String pathForSearchField = "//input[@id='js-site-search-input']";
    private String pathForSearchButton = "//button[@type='submit']";

    @Before
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
    public void locatorsLocation() {
        WebElement logo = driver.findElement(By.xpath("//img[@title='hybris Accelerator']"));
        WebElement SignOrRegisterButton = driver.findElement(By.xpath("//a[contains( text(),'Sign')]"));
        WebElement searchField = driver.findElement(By.xpath("//*[@id='js-site-search-input']"));
        List<WebElement> navigationMenu = driver.findElements(By.xpath("//ul[@class='nav__links nav__links--products js-offcanvas-links']//a"));
        WebElement banner = driver.findElement(By.xpath("//img[@class='js-responsive-image']"));
    }

    @Test
    public void searchAndAddToCartCamelio() {
        WebElement searchField = driver.findElement(By.xpath(pathForSearchField));
        searchField.sendKeys("camileo");
        WebElement searchButton = driver.findElement(By.xpath(pathForSearchButton));
        searchButton.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block glyphicon glyphicon-shopping-cart js-enable-btn']"));
        addToCartButton.click();
        WebElement continueShopButton = driver.findElement(By.xpath("//a[contains(text(),'Continue Shopping')]"));
        continueShopButton.click();
        WebElement camelioLink = driver.findElement(By.xpath("//a[@href='/yacceleratorstorefront/electronics/en/Open-Catalogue/Cameras/Hand-held-Camcorders/Camileo-S10-EU/p/1776948']"));
        camelioLink.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}




