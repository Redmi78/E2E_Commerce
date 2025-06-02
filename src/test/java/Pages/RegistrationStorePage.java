package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class RegistrationStorePage {

    SoftAssert softAssert = new SoftAssert();
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @FindBy(how = How.XPATH, using = "//input[@id='field-id_gender-1']")
    public WebElement radioBtnGenderMale;

    @FindBy(how = How.ID_OR_NAME, using = "field-firstname")
    public WebElement txtFirstName;

    @FindBy(how = How.ID_OR_NAME, using = "field-lastname")
    public WebElement txtLastName;

    @FindBy(how = How.ID_OR_NAME, using = "field-email")
    public WebElement txtEmail;

    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Order as a guest')]")
    public WebElement clickOnOrderAsGuest;


    @FindBy(how = How.XPATH, using = "//input[@name='newsletter' and @type='checkbox']")
    public WebElement checkboxNewsletter;

    @FindBy(how = How.ID_OR_NAME, using = "//input[@name='psgdpr' and @type='checkbox']")
    public WebElement checkBoxpsgdpr;


    public RegistrationStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickOnOrderAsGuest() {
        clickOnOrderAsGuest.click();
    }
    public void RadioBtnGenderMale() {
        radioBtnGenderMale.click();
    }

    public void setUserData(String firstName, String lastName, String email) {
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtEmail.sendKeys(email);
    }




}
