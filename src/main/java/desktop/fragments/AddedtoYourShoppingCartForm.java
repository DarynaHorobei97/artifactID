package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import desktop.pages.OrderDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static driver.SingletonDriver.getDriver;

public class AddedtoYourShoppingCartForm extends AbstractFragment {

    private final By checkoutButton = By.xpath("//*[@id=\"addToCartLayer\"]/a[1]");


    public OrderDetailsPage goToOrderDetailsPage() {
        getDriver().findElement(checkoutButton).click();

        return new OrderDetailsPage();
    }
}
