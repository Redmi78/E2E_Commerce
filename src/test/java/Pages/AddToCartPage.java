package Pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AddToCartPage {

    @FindBy(how = How.XPATH, using = "//iframe[@id='framelive']")
    public WebElement frameLive;


    @FindBy(how = How.XPATH, using = "//input[@placeholder='Search our catalog']")
    public WebElement txtSearchBox;

    @FindBy(how = How.XPATH, using = "//span[@class='ui-helper-hidden-accessible']")
    public WebElement btnSearch;

    @FindBy(how = How.ID, using = "quantity_wanted")
    public WebElement txtQuantity;

    @FindBy(how = How.XPATH, using = "//button[@data-button-action='add-to-cart']")
    public WebElement btnAddToCart;

    @FindBy(how = How.XPATH, using = "//span[@class='product-quantity']")
    public WebElement getTxtQuantity;

    @FindBy(how = How.XPATH, using = "//h6[@class='h6 product-name']")
    public WebElement getProductName;

    @FindBy(how = How.XPATH, using = "//h4[@id='myModalLabel']")
    public WebElement productSuccessMessage;

    @FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary']")
    public WebElement btnProceedToCheckout;



    WebDriver driver;
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    SoftAssert softAssert = new SoftAssert();


    public void switchToFrame() {
        driver.switchTo().frame(frameLive);
    }

    public void enterSearchText(String productName) throws InterruptedException {
        Thread.sleep(15000);

        txtSearchBox.sendKeys(productName);
        txtSearchBox.submit();
    }

    public void setTxtQuantity(String quantity) {

        txtQuantity.clear();
        txtQuantity.sendKeys(quantity);
    }

    public void clickOnAddToCartButton() {
        btnAddToCart.click();
    }
    public void validateCheckOutDetails(String productName,String Quantity) throws InterruptedException {
        softAssert.assertEquals(getProductName.getText().toLowerCase(), productName.toLowerCase());
        softAssert.assertEquals(getTxtQuantity.getText(), "Quantity: 2");
softAssert.assertEquals(productSuccessMessage.getText().replaceAll("[^\\x00-\\x7F]", "").trim(),"Product successfully added to your shopping cart");

       System.out.println(driver.findElement(By.xpath("//p[@class='cart-products-count']")).getText());
        Thread.sleep(20000);
       // btnProceedToCheckout.click();
        driver.findElement(By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/div/a")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(20000);
        System.out.println(driver.findElement(By.xpath("//*[@id='cart-subtotal-shipping']/span[1]")).getText());
       softAssert.assertAll();
    }

    public void clickOnProceedToCheckout() {
        btnProceedToCheckout.click();
    }

}