package stepsDefs;

import driver.SingletonDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static driver.SingletonDriver.getDriver;

public class OpenMainPage {

    protected String url = "https://ecsc00a03ccd.epam.com:9002/yacceleratorstorefront/?site=electronics";

    @Given("I am anonymous customer and I open main page")
    public void iAmAnonymousCustomerAndIOpenMainPage() {
        getDriver().get(url);
    }


}
