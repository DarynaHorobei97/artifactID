package stepsDefs;

import desktop.pages.MainPage;
import desktop.pages.SearchResultsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class SearchProductStep{

    MainPage  page = new MainPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();



    @When("I search for 1934793 product and I am redirected to search results page")
    public void iSearchForProductAndIAmRedirectedToSearchResultsPage() {
        page.searchProductByCode("1934793");
    }

    @Then("I click \"Add to Cart\" button for product {string}")
    public void addToCart(String product){
        searchResultsPage.addProductToCart();
    }


}
