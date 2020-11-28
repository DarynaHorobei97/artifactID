package stepsDefs;

import desktop.fragments.AddedtoYourShoppingCartForm;
import desktop.pages.MainPage;
import desktop.pages.OrderDetailsPage;
import desktop.pages.RegisterPage;
import desktop.pages.SearchResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkoutSteps {


    AddedtoYourShoppingCartForm addedtoYourShoppingCartForm = new AddedtoYourShoppingCartForm();
    OrderDetailsPage orderDetailsPage = new OrderDetailsPage();
    RegisterPage registerPage = new RegisterPage();


    @And("I select Check out in cart pop-up \\(Shopping Cart Form) and I am redirected to Cart page \\(Order Details page)")
    public void iSelectCheckOutInCartPopUpShoppingCartFormAndIAmRedirectedToCartPageOrderDetailsPage() {
        addedtoYourShoppingCartForm.goToOrderDetailsPage();
    }

    @And("I can review order summary$")
    public void iCanReviewOrderSummary(Map<String, String> values) {
        String subTotalExpRes = values.get("Subtotal");
        String totalExpRes = values.get("Total");

        String subTotalActRes = orderDetailsPage.getSubTotalOnOrderDetails();
        String totalActRes = orderDetailsPage.getTotalOnOrderDetails();


        Assertions.assertAll("Total prices do not equal",
                () -> assertEquals(subTotalExpRes, subTotalActRes),
                () -> assertEquals(totalExpRes, totalActRes)
        );
    }


    @And("I click checkout button after redirect to cart page \\(Order Details page)")
    public void iClickButtonAfterRedirectToCartPageOrderDetailsPage() {
        orderDetailsPage.goToRegisterPage();
    }


    @And("I checkout as guest user with {string} email and I am redirected to a Multocheckout delivery address page \\(Shipment And Pick Up Location page)")
    public void iCheckoutAsGuestUserWithEmailAndIAmRedirectedToAMultocheckoutDeliveryAddressPageShipmentAndPickUpLocationPage(String email) {
        registerPage.loginAsGuest(email);
    }
}
