package desktop.pages;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static driver.SingletonDriver.getDriver;

public class RegisterPage extends AbstractPage {

    private final By guestEmailField = By.xpath("//*[@id=\"guest.email\"]");
    private final By confirmEmailField = By.xpath("//*[@id=\"guest.confirm.email\"]");
    private final By checkOutAsGuestButton = By.xpath("//*[@id=\"guestForm\"]/div[3]/button");

     /*
 Page Factory Pattern implementation:

   @FindBy(xpath = "//*[@id="guest.email"]")
    private WebElement guestEmailField;

    @FindBy(xpath = "//*[@id="guest.confirm.email"]")
    private WebElement confirmEmailField;

     @FindBy(xpath = "//*[@id="guestForm"]/div[3]/button")
    private WebElement checkOutAsGuestButton;


    public RegisterPage(WebDriver driver) {
        //super(driver);
        //  PageFactory.initElements(this.driver, this);
    }

     public ShipmentAndPickUpLocationPage loginAsGuest(String email) {
        guestEmailField.sendKeys(email);
        confirmEmailField.sendKeys(email);
        checkOutAsGuestButton.click();
        return new ShipmentAndPickUpLocationPage(driver);
    }



  */


    public ShipmentAndPickUpLocationPage loginAsGuest(String email) {
        getDriver().findElement(guestEmailField).sendKeys(email);
        getDriver().findElement(confirmEmailField).sendKeys(email);
        getDriver().findElement(checkOutAsGuestButton).click();
        return new ShipmentAndPickUpLocationPage();
    }

}
