package stepDefinitions;

import Pages.HomePage;
import Pages.RegistrationPage;
import Pages.SearchResultsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Utility;

import java.util.Map;


public class RegistrationPageStepDefinition {
  private  RegistrationPage registrationPage;


    private WebDriver driver;

    public RegistrationPageStepDefinition() {
        this.driver = Utility.getDefaultDriver();
        this.registrationPage = new RegistrationPage(driver);
    }
    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {


    }

    @When("I enter a valid email address")
    public void iEnterAValidEmailAddress() {
        Utility.getDefaultDriver();
        driver.get("http://www.automationpractice.pl/index.php");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSignIn();
        registrationPage = new RegistrationPage(driver);
        registrationPage.setTxtEmailCreate();
    }

    @And("I click on the {string} button")
    public void iClickOnTheButton(String arg0) {
        registrationPage.btnCreateAccount();

    }

    @Then("I should be redirected to the account creation form")
    public void iShouldBeRedirectedToTheAccountCreationForm() {
    }

    @And("I enter the following registration details:")
    public void iEnterTheFollowingRegistrationDetails(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegistrationForm(
                data.get("First Name"),
                data.get("Last Name"),
                data.get("Password"),
                data.get("Day"),
                data.get("Month"),
                data.get("Year")
        );
  driver.getTitle();
    }



}
