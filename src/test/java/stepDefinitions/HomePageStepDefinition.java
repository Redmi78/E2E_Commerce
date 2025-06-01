package stepDefinitions;

import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Utility;

import static utils.Utility.driver;

public class HomePageStepDefinition {
//static  WebDriver driver;

WebDriver driver = Utility.getDefaultDriver();
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(10000);
        homePage.clickOnSignIn();
driver.getTitle();
    }



}
