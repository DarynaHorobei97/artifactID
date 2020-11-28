package desktop.pages;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static driver.SingletonDriver.getDriver;

public class ShipmentAndPickUpLocationPage extends AbstractPage {

    private final By tax = By.xpath("//div[@class='realTotals']/p");
    private final By subtotalOnShipmentAndPickUpLocationPage = By.xpath("//div[@class='subtotal']/span");
    private final By totalOnShipmentAndPickUpLocationPage = By.xpath("//div[@class='totals']/span");

 /*
 Page Factory Pattern implementation:

   @FindBy(xpath = "//div[@class='realTotals']/p")
    private WebElement tax;

       @FindBy(xpath = "//div[@class='subtotal']/span")
    private WebElement subtotalOnShipmentAndPickUpLocationPage;

       @FindBy(xpath = "//div[@class='totals']/span")
    private WebElement totalOnShipmentAndPickUpLocationPage;


    public ShipmentAndPickUpLocationPage(WebDriver driver) {
        //super(driver);
        //  PageFactory.initElements(this.driver, this);
    }
public String getSubtotalOnShipmentAndPickUpLocation() {
        return subtotalOnShipmentAndPickUpLocationPage.getText();
    }

    public String getTotalOnShipmentAndPickUpLocation() {

        return totalOnShipmentAndPickUpLocationPage.getText();
    }

    public String getTax() {
        return tax.getText();
    }

  */


    public String getSubtotalOnShipmentAndPickUpLocation() {
        return getDriver().findElement(subtotalOnShipmentAndPickUpLocationPage).getText();
    }


    public String getTotalOnShipmentAndPickUpLocation() {

        return getDriver().findElement(totalOnShipmentAndPickUpLocationPage).getText();
    }

    public String getTax() {
        return getDriver().findElement(tax).getText();
    }

    public void closeBrowser() {
        getDriver().quit();
    }

}
