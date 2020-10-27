import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2_Lacoste {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Daryna_Horobei\\Downloads\\chromedriver_win32_86\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void printNameAndUrlOfPage() {
        driver.get("https://www.lacoste.ua/");
        String pageUrl = driver.getCurrentUrl();
        String pageTitle = driver.getTitle();

        System.out.println(pageUrl);
        System.out.println(pageTitle);

        WebElement storeLink = driver.findElement(By.xpath("//a[contains(text(),'БУТІК')]"));
        storeLink.click();

        String pageUrl1 = driver.getCurrentUrl();
        String pageTitle1 = driver.getTitle();

        System.out.println(pageUrl1);
        System.out.println(pageTitle1);

        driver.navigate().back();
        driver.navigate().refresh();

        String pageUrl2 = driver.getCurrentUrl();
        String pageTitle2 = driver.getTitle();

        System.out.println(pageUrl2);
        System.out.println(pageTitle2);


    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
