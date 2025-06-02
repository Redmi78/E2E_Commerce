package stepDefinitions;

import Pages.AddToCartPage;
import Pages.RegistrationStorePage;
import Pages.SearchResultsPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utility;

import java.time.Duration;

public class RegistrationStorePageStepDefinition {
    RegistrationStorePage RegistrationStorePage;
    SearchResultsPage searchResultsPage;
    WebDriver driver = Utility.getDefaultDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @And("I fill user personal details")
    public void fillRegistrationForm() throws InterruptedException {
        RegistrationStorePage = new RegistrationStorePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        RegistrationStorePage.ClickOnOrderAsGuest();
        RegistrationStorePage.RadioBtnGenderMale();
        RegistrationStorePage.setUserData("tesr","tesr","test@test.com");
    }
}
