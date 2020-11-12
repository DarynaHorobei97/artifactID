package desktop.pages;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShipmentAndPickUpLocationPage extends AbstractPage {

    private final By tax = By.xpath("//div[@class='realTotals']/p");
    private final By subtotalOnShipmentAndPickUpLocationPage = By.xpath("//div[@class='subtotal']/span");
    private final By totalOnShipmentAndPickUpLocationPage = By.xpath("//div[@class='totals']/span");


    public ShipmentAndPickUpLocationPage(WebDriver driver) {
        super(driver);
    }

    public By getSubtotalOnShipmentAndPickUpLocationPage() {
        return subtotalOnShipmentAndPickUpLocationPage;
    }


    public By getTotalOnShipmentAndPickUpLocationPage() {
        return totalOnShipmentAndPickUpLocationPage;
    }


    public By getTax() {
        return tax;
    }


}
