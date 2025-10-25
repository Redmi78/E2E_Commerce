package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utility;

import java.time.Duration;
import java.util.List;


public class HomePage {
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Sign in']")
    public WebElement signInButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'title') and contains(@data-toggle,'collapse')]")
    public List<WebElement> sectionTitles;

    @FindBy(how = How.XPATH, using = ".//span[@class='h3']")
    public WebElement linksUnderFooterHeaders;


    WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOnSignIn() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign in']")));
        signInButton.click();
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
    }

    public void getFooterHeaders() throws InterruptedException {


    }
}