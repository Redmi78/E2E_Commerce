package Pages;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.Utility;

import java.io.File;
import java.io.IOException;

public class Hooks {
 WebDriver driver= Utility.getDefaultDriver();
   @Before
    public void setUp() {
        // This method will run before each scenario
        System.out.println("Setting up the test environment...");
        // You can add more setup code here, like initializing WebDriver, etc.

      //  driver.get("http://www.automationpractice.pl/index.php");

       driver.get("https://demo.prestashop.com/#/en/front");
    }

    @After
    public void tearDown() {
        // This method will run after each scenario
        System.out.println("Tearing down the test environment...");
        // You can add more teardown code here, like closing WebDriver, etc.
        if (driver != null) {// Quit WebDriver after the test
            driver = null; // Reset the driver to avoid reuse
        }
    }

    public void addScreenShot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            System.out.println("The scenario has failed. Taking a screenshot...");
            TakesScreenshot scrht = (TakesScreenshot) driver;
            File sourcePath = scrht.getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");
        }
    }
}
