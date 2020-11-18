package stepsDefs;

import desktop.fragments.AddedtoYourShoppingCartForm;
import desktop.pages.MainPage;
import desktop.pages.OrderDetailsPage;
import desktop.pages.SearchResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class SearchProductStep{

    private WebDriver driver;
    MainPage  page = new MainPage(driver);
    private SearchResultsPage searchResultsPage;



    @When("I search for 1934793 product and I am redirected to search results page")
    public void iSearchForProductAndIAmRedirectedToSearchResultsPage() {
        page.searchProductByCode("1934793");
    }

    @Then("I click \"Add to Cart\" button for product \"1934793\"")
    public void addToCart(){
        searchResultsPage.addProductToCart();
    }
}
