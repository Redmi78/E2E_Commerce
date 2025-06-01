package stepDefinitions;

import Pages.SearchResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class searchResultsStepDefinition {
SearchResultsPage searchResultsPage;
WebDriver driver = utils.Utility.getDefaultDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    @And("Click on search button")
    public void clickOnSearchButton() {

    }

    @Then("I should see search results for {string}")
    public void iShouldSeeSearchResultsFor(String arg0) throws InterruptedException {
        searchResultsPage=  new SearchResultsPage(driver);
        searchResultsPage.getProductsTitle();
    }

    @And("Verify all products related to Mugs")
    public void verifyAllProductsRelatedToMugs() {
    }
}
