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

    public By getTotalOnOrderDetails() {
        return totalOnOrderDetails;
    }

    private final By totalOnOrderDetails = By.xpath("//div[@class='col-xs-6 cart-totals-right text-right grand-total']");
    private final By checkoutInOrderDetails = By.xpath("//div[@class='cart__actions']//button[contains( text(),'Check')]");

    public RegisterPage goToRegisterPage(){
        driver.findElement(checkoutInOrderDetails).click();
        return new RegisterPage(driver);
    }

    public By getSubTotalOnOrderDetails() {
        return subTotalOnOrderDetails;
    }


}
