import desktop.pages.MainPage;
import desktop.pages.OrderDetailsPage;
import desktop.pages.RegisterPage;
import desktop.pages.ShipmentAndPickUpLocationPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkoutOnShipmentAndPickUpLocation extends BaseTest {
    private MainPage mainPage;
    private OrderDetailsPage orderDetailsPage;
    private ShipmentAndPickUpLocationPage shipmentAndPickUpLocationPage;

    @BeforeEach
    public void setPage() {
        this.mainPage = new MainPage(driver);
        this.orderDetailsPage = new OrderDetailsPage(driver);
        this.shipmentAndPickUpLocationPage = new ShipmentAndPickUpLocationPage(driver);
    }




    @Test
    public void checkTotalPricesOnOrderDetailsTest() {
        mainPage.searchProductByCode("1934793")
                .addProductToCart()
                .goToOrderDetailsPage()
                .goToRegisterPage()
                .loginAsGuest("test@user.com");

        Assertions.assertAll("Total prices do not equal",
                () -> assertEquals("$99.85", shipmentAndPickUpLocationPage.getSubtotalOnShipmentAndPickUpLocationPage()),
                () -> assertEquals("$104.84", shipmentAndPickUpLocationPage.getTotalOnShipmentAndPickUpLocationPage()),
                () -> assertEquals("Your order includes $4.99 tax.", shipmentAndPickUpLocationPage.getTax())
        );
    }
}
