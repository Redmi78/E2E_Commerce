package Pages;

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
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @FindBy(how = How.CSS, using = "h2.h3.product-title > a")
    public List<WebElement> getAllProductsTitle;

    @FindBy(how = How.CSS, using = "div.product-price-and-shipping > span")
    public List<WebElement> getAllProductsPrices;


    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getProductsTitle() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfAllElements(getAllProductsTitle));

        // Find all product title links
        ArrayList<String> productTitleList = new ArrayList<>();

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
        softAssert.assertEquals(productTitleList.size(), 5);

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
        for (WebElement product : getAllProductsTitle) {
            if (product.getText().trim().equalsIgnoreCase(productName)) {
                product.click();
                break;
            }
        }
    }

}