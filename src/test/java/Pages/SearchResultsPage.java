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
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchResultsPage {
    SoftAssert softAssert = new SoftAssert();
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(how = How.CSS, using = "#js-product-list .product-miniature__title")
    public List<WebElement> getAllProductsTitle;

    @FindBy(how = How.CSS, using = "div.product-price-and-shipping > span")
    public List<WebElement> getAllProductsPrices;

    @FindBy(how = How.XPATH, using = "//button[@class='btn-unstyle select-title']")
    public WebElement dropDown;

    @FindBy(how = How.XPATH, using = "//div[@class='dropdown-menu']//a[@rel='nofollow']")
    public List<WebElement> dropdownMenu;

    //button[@data-toggle='dropdown']


    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void getProductsTitle() throws InterruptedException {

        // Find all product title links
        ArrayList<String> productTitleList = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfAllElements(getAllProductsTitle));
        for (WebElement product : getAllProductsTitle) {
            String title = product.getText().trim();
            productTitleList.add(title);
            System.out.println("Product Title: " + title);
        }
        if (productTitleList.isEmpty()) {
            System.out.println("No products found in the search results.");
        } else {
            System.out.println("Total products found: " + productTitleList.size());
        }
        //   softAssert.assertEquals(productTitleList.size(), 5);

        softAssert.assertAll();
    }

    public void setGetAllProductsPrices() {

        // Find all product title links
        ArrayList<Integer> productPricesList = new ArrayList<>();

        for (WebElement prices : getAllProductsPrices) {
            String priceText = prices.getText().replace("€", "").trim();
            double priceDouble = Double.parseDouble(priceText);
            int priceInt = (int) Math.round(priceDouble);  // or truncate with (int) priceDouble
            productPricesList.add(priceInt);
            System.out.println("Product price: " + productPricesList);
        }
        // Sort ascending
        Collections.sort(productPricesList);
        System.out.println(productPricesList);

    }

    public void clickOnProduct(String productName) {
        boolean productFound = false;
        for (WebElement product : getAllProductsTitle) {
            String actualProductName = product.getText().trim();
            System.out.println("Available Product: " + actualProductName);
            if (actualProductName.equalsIgnoreCase(productName.trim())) {
                productFound = true;
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        product);
                wait.until(ExpectedConditions.elementToBeClickable(product));

                try {

                    product.click();

                } catch (Exception e) {

                    ((JavascriptExecutor) driver)
                            .executeScript("arguments[0].click();", product);
                }

                break;
            }
        }

        if (!productFound) {
            throw new RuntimeException("Product not found: " + productName);
        }
    }

    public void getSortByDropDownValues(String criteria) throws InterruptedException {
        dropDown.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElements(dropdownMenu));
        for (WebElement element : dropdownMenu) {
            String sortByDropDownValues = element.getText().trim();
            if (sortByDropDownValues.contains("Price, low to high")) {
                element.click();
                element.isSelected();
                break;
            }
        }
    }

}