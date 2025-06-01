package stepDefinitions;

import Pages.AddToCartPage;
import Pages.SearchResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utility;

import java.time.Duration;

public class AddToCartStepDefinition {
    AddToCartPage addToCartPage;
    SearchResultsPage searchResultsPage;
    WebDriver driver = Utility.getDefaultDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @Given("I open the PrestaShop demo site")
    public void iOpenThePrestaShopDemoSite() throws InterruptedException {
        addToCartPage = new AddToCartPage(driver);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(addToCartPage.frameLive));

    }

    @When("I search for {string}")
    public void iSearchFor(String productName) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        addToCartPage.enterSearchText(productName);

    }

   @When("I search for products {string}")
    public void searchForSpecificProducts(String products) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        addToCartPage.enterSearchText(products);

    }

    @Then("click on the specific product {string}")
    public void clickOnTheSpecificProductName(String productNames) throws InterruptedException {
        searchResultsPage=  new SearchResultsPage(driver);
        searchResultsPage.getProductsTitle();
        searchResultsPage.clickOnProduct(productNames);
    }

    @Then("select quantity {string}")
    public void selectQuantityQuantity(String quantity) {

        addToCartPage.setTxtQuantity(quantity);
    }

    @And("click on the {string} button")
    public void clickOnTheButton(String arg0) throws InterruptedException {
        Thread.sleep(5000);
        addToCartPage.clickOnAddToCartButton();
        Thread.sleep(20000);

    }
    @Then("I should see the product {string} in the cart with quantity {string}")
    public void iShouldSeeTheProductInTheCartWithQuantity(String productName, String quantity) {
        addToCartPage.validateCheckOutDetails(productName, quantity);
    }


}


