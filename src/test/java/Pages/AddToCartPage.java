package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

    @FindBy(how = How.XPATH, using = "//iframe[@id='framelive']")
    public WebElement frameLive;


    @FindBy(how = How.XPATH, using = "//input[@placeholder='Search our catalog']")
    public WebElement txtSearchBox;

    @FindBy(how = How.XPATH, using = "//span[@class='ui-helper-hidden-accessible']")
    public WebElement btnSearch;

    WebDriver driver ;
    public  AddToCartPage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }


    public void switchToFrame() {
        driver.switchTo().frame(frameLive);
    }

    public void enterSearchText(String searchText) throws InterruptedException {
        Thread.sleep(15000);
        txtSearchBox.sendKeys(searchText);
        txtSearchBox.submit();
        driver.getTitle();
    }


}
