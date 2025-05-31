package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Utility;

import java.time.Duration;

public class RegistrationPage {
@FindBy(how = How.XPATH,using = "//input[@id='email_create']")
    WebElement txtEmailCreate;
    @FindBy(how = How.XPATH,using = "//span[normalize-space()='Create an account']")
    WebElement submitCreateAccountButton;
    @FindBy(how = How.ID_OR_NAME,using = "id_gender1")
    WebElement btnGenderMale;

    @FindBy(how = How.ID,using = "customer_firstname")
    WebElement txtFirstName;
    @FindBy(how = How.ID,using = "customer_lastname")
    WebElement txtLastName;
    @FindBy(how = How.ID,using = "passwd")
    WebElement txtPassword;

    @FindBy(how = How.ID,using = "days")
    WebElement dropdownDays;
    @FindBy(how = How.ID,using = "months")
    WebElement dropdownMonths;
    @FindBy(how = How.ID,using = "years")
    WebElement dropdownYears;


    WebDriver driver ;
    public  RegistrationPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
public void setTxtEmailCreate()
{
    txtEmailCreate.sendKeys("testuser@dummy.com");
}

public  void btnCreateAccount()
{
    submitCreateAccountButton.click();
}
    public  void fillRegistrationForm(String firstName, String lastName, String password, String Day, String Month, String Year) {
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        btnGenderMale.click();
    txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtPassword.sendKeys(password);
       Select selectDay = new Select( dropdownDays);
       selectDay.selectByValue(Day);
        Select selectMonths = new Select( dropdownMonths);
        selectMonths.selectByIndex(12);
        Select selectYears = new Select( dropdownYears);
        selectYears.selectByValue(Year);

    }
}
