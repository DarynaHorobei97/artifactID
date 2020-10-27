import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1_B2BAccelerator {


    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Daryna_Horobei\\Downloads\\chromedriver_win32_86\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    //Task 1.1
    @Test
    public void openSite() {
        driver.get("https://ecsc00a03ccd.epam.com:9002/yacceleratorstorefront/?site=electronics");

    }

    //Task 1.2
//    WebElement logo = driver.findElement(By.xpath("//img[@title='hybris Accelerator']"));
//    WebElement SignOrRegisterButton = driver.findElement(By.xpath("//a[contains( text(),'Sign')]"));
//    WebElement searchField = driver.findElement(By.xpath("//*[@id='js-site-search-input']"));
//    List<WebElement> navigationMenu = driver.findElements(By.xpath("//ul[@class='nav__links nav__links--products js-offcanvas-links']//a"));
//    WebElement banner = driver.findElement(By.xpath("img[@class='js-responsive-image']"));


    //Task 1.3-1.4
    @Test
    public void searchAndAddToCartCamelio() {
        driver.get("https://ecsc00a03ccd.epam.com:9002/yacceleratorstorefront/?site=electronics");

        WebElement searchField = driver.findElement(By.xpath("//*[@id='js-site-search-input']"));
        searchField.sendKeys("camileo");
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-link js_search_button']"));
        searchButton.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block glyphicon glyphicon-shopping-cart js-enable-btn']"));
        addToCartButton.click();
    }

    //Task 1.5
    @Test
    public void searchAndClickOnCamelio() {
        driver.get("https://ecsc00a03ccd.epam.com:9002/yacceleratorstorefront/?site=electronics");

        WebElement searchField = driver.findElement(By.xpath("//*[@id='js-site-search-input']"));
        searchField.sendKeys("camileo");
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-link js_search_button']"));
        searchButton.click();
        WebElement camelioLink = driver.findElement(By.xpath("//a[@href='/yacceleratorstorefront/electronics/en/Open-Catalogue/Cameras/Hand-held-Camcorders/Camileo-S10-EU/p/1776948']"));
        camelioLink.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}




