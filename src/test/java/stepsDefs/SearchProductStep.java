package stepsDefs;

import desktop.fragments.AddedtoYourShoppingCartForm;
import desktop.pages.MainPage;
import desktop.pages.OrderDetailsPage;
import desktop.pages.SearchResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static driver.SingletonDriver.getDriver;

public class SearchProductStep{

    MainPage  page = new MainPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();



    @When("I search for 1934793 product(?:s|) and I am redirected to ([\\s\\w]+page$)")
    public void iSearchForProductAndIAmRedirectedToSearchResultsPage() {
        page.searchProductByCode("1934793");
    }

    @Then("I click \"Add to Cart\" button for product {string}")
    public void addToCart(String product){
        searchResultsPage.addProductToCart();
    }


}
