package desktop.pages;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends AbstractPage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private final By guestEmailField = By.xpath("//*[@id=\"guest.email\"]");
    private final By confirmEmailField = By.xpath("//*[@id=\"guest.confirm.email\"]");
    private final By checkOutAsGuestButton = By.xpath("//*[@id=\"guestForm\"]/div[3]/button");

    public ShipmentAndPickUpLocationPage loginAsGuest(String email) {
        driver.findElement(guestEmailField).sendKeys(email);
        driver.findElement(confirmEmailField).sendKeys(email);
        driver.findElement(checkOutAsGuestButton).click();
        return new ShipmentAndPickUpLocationPage(driver);
    }

}
