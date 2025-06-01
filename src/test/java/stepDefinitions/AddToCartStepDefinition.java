package stepDefinitions;

import Pages.AddToCartPage;
import Pages.SearchResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Utility;

import java.time.Duration;

public class AddToCartStepDefinition {
    AddToCartPage addToCartPage;
    WebDriver driver = Utility.getDefaultDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @Given("I open the PrestaShop demo site")
    public void iOpenThePrestaShopDemoSite() throws InterruptedException {
        addToCartPage = new AddToCartPage(driver);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(addToCartPage.frameLive));
        // Wait for the search box to be visible and enter the search text
    }

    @When("I search for {string}")
    public void iSearchFor(String productName) throws InterruptedException {
       // wait.until(ExpectedConditions.visibilityOf(addToCartPage.txtSearchBox)).sendKeys(productName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        addToCartPage.enterSearchText(productName);
      //  Assert.assertEquals(driver.getTitle(),"test");
       /* searchResultsPage=  new SearchResultsPage(driver);
        searchResultsPage.getProductsTitle();*/
    }

    @And("I add the product to the cart")
    public void iAddTheProductToTheCart() {
    }

    @Then("the product should be added successfully")
    public void theProductShouldBeAddedSuccessfully() {
    }

    @And("the cart count should be updated")
    public void theCartCountShouldBeUpdated() {
    }
}


