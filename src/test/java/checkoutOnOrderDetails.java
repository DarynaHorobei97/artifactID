import desktop.pages.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkoutOnOrderDetails extends BaseTest {

    private MainPage mainPage;
    private OrderDetailsPage orderDetailsPage;

    @BeforeEach
    public void setPage() {
        this.mainPage = new MainPage(driver);
        this.orderDetailsPage = new OrderDetailsPage(driver);
    }


    @Test
    public void checkTotalPricesOnOrderDetailsTest() {

        mainPage.searchProductByCode("1934793")
                .addProductToCart()
                .goToOrderDetailsPage();

        Assertions.assertAll("Total prices do not equal",
                () -> assertEquals("$99.85", orderDetailsPage.getSubTotalOnOrderDetails()),
                () -> assertEquals("$99.85", orderDetailsPage.getTotalOnOrderDetails())
        );

    }
}
