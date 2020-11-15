import desktop.pages.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkoutOnOrderDetails extends BaseTest {

    private MainPage page;


    @Before
    public void setPage() {
        page = new MainPage(driver);
    }


    @Test
    public void checkTotalPricesOnOrderDetailsTest() {

        String subTotalActRes = page.searchProductByCode("1934793")
                .addProductToCart()
                .goToOrderDetailsPage().getSubTotalOnOrderDetails();

        String totalActRes = page.searchProductByCode("1934793")
                .addProductToCart()
                .goToOrderDetailsPage().getTotalOnOrderDetails();


        Assertions.assertAll("Total prices do not equal",
                () -> assertEquals("$99.85", subTotalActRes),
                () -> assertEquals("$99.85", totalActRes)
        );

    }
}
