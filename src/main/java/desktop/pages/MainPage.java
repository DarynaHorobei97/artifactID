package desktop.pages;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By logo = By.xpath("//img[@title='hybris Accelerator']");
    private final By SignOrRegisterButton = By.xpath("//*[@id='js-site-search-input']");
    private final By searchField = By.id("js-site-search-input");
    private final By navigationMenu = By.xpath("//ul[@class='nav__links nav__links--products js-offcanvas-links']//a");
    //List<WebElement> navigationMenu = driver.findElements(By.xpath("//ul[@class='nav__links nav__links--products js-offcanvas-links']//a"));
    private final By banner = By.xpath("//img[@class='js-responsive-image']");

    private final By searchButton = By.xpath("//button[@type='submit']");

   /*
 Page Factory Pattern implementation:

   @FindBy(xpath = "//img[@title='hybris Accelerator']")
    private WebElement logo;

    @FindBy(xpath = "//*[@id='js-site-search-input']")
    private WebElement SignOrRegisterButton;

    @FindBy(id = "js-site-search-input")
    private WebElement searchField;

     @FindBy(xpath = "//ul[@class='nav__links nav__links--products js-offcanvas-links']//a")
    private WebElement navigationMenu;

       @FindBy(xpath = "//img[@class='js-responsive-image']")
    private WebElement banner;

       @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;


    public MainPage(WebDriver driver) {
        //super(driver);
        //  PageFactory.initElements(this.driver, this);
    }

  */


    public SearchResultsPage searchProductByCode(String product) {
        driver.findElement(searchField).sendKeys(product);
        driver.findElement(searchButton).click();
        return new SearchResultsPage(driver);
    }


   /*
 Page Factory Pattern implementation:
   public SearchResultsPage searchProductByCode(String product) {
        searchField.sendKeys(product);
        searchButton.click();
        return new SearchResultsPage(driver);
    }



    Singleton Pattern implementation:
    private static MainPage instance = new MainPage();
    private MainPage() {
    }

    public static MainPage getInstance() {
        return instance;
    }
}

           */
}
