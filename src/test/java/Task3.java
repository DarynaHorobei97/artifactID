import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task3 {

    private WebDriver driver;
    private String url = "https://gloss.ua";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Daryna_Horobei\\Downloads\\chromedriver_win32_86\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
    @Test
    public void printListOfActicleName() {
        List<WebElement> namesOfarticles = driver.findElements(By.tagName("h4"));
        for (int i = 0; i < namesOfarticles.size(); i++) {
            String nameOfArticle = namesOfarticles.get(i).getText();
            System.out.println(nameOfArticle);
        }
    }
    @Test
    public void printListOfLinks() {
        List<WebElement> namesOfLinks = driver.findElements(By.tagName("a"));
        Set<String> namesOf_Links = new HashSet<>();
        for (int i = 0; i < namesOfLinks.size(); i++) {
            String nameOfLink = namesOfLinks.get(i).getAttribute("href");
            namesOf_Links.add(nameOfLink);
        }
        for (String el : namesOf_Links) {
            System.out.println(el);
        }
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
