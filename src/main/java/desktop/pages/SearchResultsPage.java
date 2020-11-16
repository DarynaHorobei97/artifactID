package desktop.pages;

import abstractClasses.page.AbstractPage;
import desktop.fragments.AddedtoYourShoppingCartForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends AbstractPage {

    private final By addToCartButton = By.xpath("//button[@class='btn btn-primary btn-block glyphicon glyphicon-shopping-cart js-enable-btn']");

    /*
 Page Factory Pattern implementation:

   @FindBy(xpath = "//button[@class='btn btn-primary btn-block glyphicon glyphicon-shopping-cart js-enable-btn']")
    private WebElement addToCartButton;


    public SearchResultsPage(WebDriver driver) {
        //super(driver);
        //  PageFactory.initElements(this.driver, this);
    }
     public AddedtoYourShoppingCartForm addProductToCart() {
        addToCartButton.click();
        return new AddedtoYourShoppingCartForm(driver);
    }



  */



    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public AddedtoYourShoppingCartForm addProductToCart() {
        driver.findElement(addToCartButton).click();
        return new AddedtoYourShoppingCartForm(driver);
    }
}
