package desktop.pages;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderDetailsPage extends AbstractPage {
    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final By subTotalOnOrderDetails = By.xpath("//div[@class='col-xs-6 cart-totals-right text-right']");

    private final By totalOnOrderDetails = By.xpath("//div[@class='col-xs-6 cart-totals-right text-right grand-total']");
    private final By checkoutInOrderDetails = By.xpath("//div[@class='cart__actions']//button[contains( text(),'Check')]");

    public RegisterPage goToRegisterPage() {
        driver.findElement(checkoutInOrderDetails).click();
        return new RegisterPage(driver);
    }

    /*
 Page Factory Pattern implementation:

   @FindBy(xpath = "//div[@class='col-xs-6 cart-totals-right text-right']")
    private WebElement subTotalOnOrderDetails;

    @FindBy(xpath = "//div[@class='col-xs-6 cart-totals-right text-right grand-total']")
    private WebElement totalOnOrderDetails;

     @FindBy(xpath = "//div[@class='cart__actions']//button[contains( text(),'Check')]")
    private WebElement checkoutInOrderDetails;


    public OrderDetailsPage(WebDriver driver) {
        //super(driver);
        //  PageFactory.initElements(this.driver, this);
    }

    public RegisterPage goToRegisterPage() {
        checkoutInOrderDetails.click();
        return new RegisterPage(driver);
    }
     public String getSubTotalOnOrderDetails() {
        return driver.findElement(subTotalOnOrderDetails).getText();
    }

    public String getTotalOnOrderDetails() {
        return driver.findElement(totalOnOrderDetails).getText();
    }

    public String getSubTotalOnOrderDetails() {
        return subTotalOnOrderDetails.getText();
    }

    public String getTotalOnOrderDetails() {
        return totalOnOrderDetails.getText();
    }



  */


    public String getSubTotalOnOrderDetails() {

        return driver.findElement(subTotalOnOrderDetails).getText();
    }

    public String getTotalOnOrderDetails() {

        return driver.findElement(totalOnOrderDetails).getText();
    }


}
