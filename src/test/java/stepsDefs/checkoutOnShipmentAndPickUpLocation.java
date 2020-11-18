package stepsDefs;

import desktop.pages.MainPage;
import desktop.pages.ShipmentAndPickUpLocationPage;
import io.cucumber.java.en.And;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkoutOnShipmentAndPickUpLocation {

    private ShipmentAndPickUpLocationPage shipmentAndPickUpLocationPage;

    @And("I have the following final review")
    public void iHaveTheFollowingFinalReview() {

        String subtotalOnShipmentAndPickUpLocation = shipmentAndPickUpLocationPage.getSubtotalOnShipmentAndPickUpLocation();
        String totalOnShipmentAndPickUpLocation = shipmentAndPickUpLocationPage.getTotalOnShipmentAndPickUpLocation();
        String tax = shipmentAndPickUpLocationPage.getTax();

        Assertions.assertAll("Total prices do not equal",
                () -> assertEquals("$99.85", subtotalOnShipmentAndPickUpLocation),
                () -> assertEquals("$104.84", totalOnShipmentAndPickUpLocation),
                () -> assertEquals("Your order includes $4.99 tax.", tax)
        );
    }

}
