package stepsDefs;

import desktop.fragments.AddedtoYourShoppingCartForm;
import desktop.pages.MainPage;
import desktop.pages.OrderDetailsPage;
import desktop.pages.RegisterPage;
import io.cucumber.java.en.And;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkoutSteps {

    private MainPage page;
    private AddedtoYourShoppingCartForm addedtoYourShoppingCartForm;
    private OrderDetailsPage orderDetailsPage;
    private RegisterPage registerPage;


    @And("I select Check out in cart pop-up \\(Shopping Cart Form) and I am redirected to Cart page \\(Order Details page)")
    public void iSelectCheckOutInCartPopUpShoppingCartFormAndIAmRedirectedToCartPageOrderDetailsPage() {
        addedtoYourShoppingCartForm.goToOrderDetailsPage();
    }

    @And("I can review order summary")
    public void iCanReviewOrderSummary() {
        String subTotalActRes = orderDetailsPage.getSubTotalOnOrderDetails();
        String totalActRes = orderDetailsPage.getTotalOnOrderDetails();


        Assertions.assertAll("Total prices do not equal",
                () -> assertEquals("$99.85", subTotalActRes),
                () -> assertEquals("$99.85", totalActRes)
        );
    }

    @And("I click checkout button after redirect to cart page \\(Order Details page)")
    public void iClickButtonAfterRedirectToCartPageOrderDetailsPage() {
        orderDetailsPage.goToRegisterPage();
    }

    @And("I checkout as guest user with {string} email and I am redirected to a {string} \\(Shipment And Pick Up Location page)")
    public void iCheckoutAsGuestUserWithEmail(String email) {
        registerPage.loginAsGuest("test@user.com");
    }


}
