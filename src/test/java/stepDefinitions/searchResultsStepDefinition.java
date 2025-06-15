package stepDefinitions;

import Pages.AddToCartPage;
import Pages.SearchResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.Utility;


public class searchResultsStepDefinition {
    private SearchResultsPage searchResultsPage;
    private WebDriver driver;

    public searchResultsStepDefinition() {
        this.driver = Utility.getDefaultDriver();
        this.searchResultsPage = new SearchResultsPage(driver);
    }

    @And("Click on search button")
    public void clickOnSearchButton() {

    }

    @Then("I should see search results for {string}")
    public void iShouldSeeSearchResultsFor(String arg0) throws InterruptedException {
        searchResultsPage.getProductsTitle();
        searchResultsPage.setGetAllProductsPrices();
        System.out.println("pages search successfully");
    }

    @And("Verify all products related to Mugs")
    public void verifyAllProductsRelatedToMugs() {
    }

    @And("I sort the products by {string}")
    public void iSortTheProductsBy(String criteria) throws InterruptedException {
        searchResultsPage.getSortByDropDownValues(criteria);
    }


}
