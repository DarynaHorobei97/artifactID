import desktop.pages.MainPage;
import desktop.pages.OrderDetailsPage;
import desktop.pages.RegisterPage;
import desktop.pages.ShipmentAndPickUpLocationPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkoutOnShipmentAndPickUpLocation extends BaseTest {
    private MainPage page;


    @Before
    public void setPage() {
        page = new MainPage(driver);
    }


    @Test
    public void checkTotalPricesOnOrderDetailsTest() {
        page.searchProductByCode("1934793")
                .addProductToCart()
                .goToOrderDetailsPage()
                .goToRegisterPage()
                .loginAsGuest("test@user.com");


      String subtotalOnShipmentAndPickUpLocation =  page.searchProductByCode("1934793")
                .addProductToCart()
                .goToOrderDetailsPage()
                .goToRegisterPage()
                .loginAsGuest("test@user.com").getSubtotalOnShipmentAndPickUpLocation();

      String totalOnShipmentAndPickUpLocation = page.searchProductByCode("1934793")
              .addProductToCart()
              .goToOrderDetailsPage()
              .goToRegisterPage()
              .loginAsGuest("test@user.com").getTotalOnShipmentAndPickUpLocation();

      String tax = page.searchProductByCode("1934793")
              .addProductToCart()
              .goToOrderDetailsPage()
              .goToRegisterPage()
              .loginAsGuest("test@user.com").getTax();

        Assertions.assertAll("Total prices do not equal",
                () -> assertEquals("$99.85", subtotalOnShipmentAndPickUpLocation),
                () -> assertEquals("$104.84", totalOnShipmentAndPickUpLocation),
                () -> assertEquals("Your order includes $4.99 tax.", tax)
        );
    }
}
