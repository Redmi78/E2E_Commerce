package stepDefinitions;

import Pages.AddToCartPage;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Utility;


public class HomePageStepDefinition {
//static  WebDriver driver;
private WebDriver driver;
    private HomePage homePage;

    public HomePageStepDefinition() {
        this.driver = Utility.getDefaultDriver();
        this.homePage = new HomePage(driver);
    }
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(10000);
        homePage.clickOnSignIn();
driver.getTitle();
    }


    @When("I Get a footer links")
    public void iGetAFooterLinks() throws InterruptedException {
        homePage.getFooterHeaders();

    }


}
