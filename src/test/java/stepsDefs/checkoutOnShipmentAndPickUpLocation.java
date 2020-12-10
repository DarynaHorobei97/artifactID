package stepsDefs;
import desktop.pages.ShipmentAndPickUpLocationPage;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkoutOnShipmentAndPickUpLocation {

    ShipmentAndPickUpLocationPage shipmentAndPickUpLocationPage = new ShipmentAndPickUpLocationPage();

    @And("I have the following final review$")
    public void iHaveTheFollowingFinalReview(Map<String, String> values) {

        String subtotalOnShipmentAndPickUpLocationExpRes = values.get("Subtotal");
        String totalOnShipmentAndPickUpLocationExpRes = values.get("Subtotal");
        String taxExpRes = values.get("Tax");

        String subtotalOnShipmentAndPickUpLocation = shipmentAndPickUpLocationPage.getSubtotalOnShipmentAndPickUpLocation();
        String totalOnShipmentAndPickUpLocation = shipmentAndPickUpLocationPage.getTotalOnShipmentAndPickUpLocation();
        String tax = shipmentAndPickUpLocationPage.getTax();

        Assertions.assertAll("Total prices do not equal",
                () -> assertEquals(subtotalOnShipmentAndPickUpLocationExpRes, subtotalOnShipmentAndPickUpLocation),
                () -> assertEquals(totalOnShipmentAndPickUpLocationExpRes, totalOnShipmentAndPickUpLocation),
                () -> assertEquals("Your order includes $4.99 tax.", tax)
        );
        shipmentAndPickUpLocationPage.closeBrowser();
    }

}
