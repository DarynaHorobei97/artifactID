import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task3 {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Daryna_Horobei\\Downloads\\chromedriver_win32_86\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void printListOfActicleName() {
        driver.get("https://gloss.ua");
        List<WebElement> namesOfarticles = driver.findElements(By.tagName("h4"));

        for (int i = 0; i < namesOfarticles.size(); i++) {
            String nameOfArticle = namesOfarticles.get(i).getText();
            System.out.println(nameOfArticle);
        }
    }

    @Test
    public void printListOfLinks() {
        driver.get("https://gloss.ua");
        List<WebElement> namesOfLinks = driver.findElements(By.tagName("a"));
        for (int i = 0; i < namesOfLinks.size(); i++) {
            String nameOfLink = namesOfLinks.get(i).getAttribute("href");
            System.out.println(nameOfLink);

        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
