package stepsDefs;
import io.cucumber.java.en.Given;

import static driver.SingletonDriver.getDriver;

public class OpenMainPage {

    protected String url = "https://ecsc00a03ccd.epam.com:9002/yacceleratorstorefront/?site=electronics";

    @Given("I am anonymous customer and I open main page")
    public void iAmAnonymousCustomerAndIOpenMainPage() {
        getDriver().get(url);
    }


}
