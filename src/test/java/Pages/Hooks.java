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
    @Before
    public void setUp() {
        WebDriver driver = Utility.getDefaultDriver();
        driver.get("https://demo.prestashop.com/#/en/front");
    }

    @After
    public void tearDown() {
        Utility.resetDriver();
    }

    @AfterStep
    public void addScreenShot(Scenario scenario) throws IOException {
        WebDriver driver = Utility.getDefaultDriver();
        if (scenario.isFailed()) {
            try {
                System.out.println("The scenario has failed. Taking a screenshot...");
                TakesScreenshot scrht = (TakesScreenshot) driver;
                byte[] fileContent = scrht.getScreenshotAs(OutputType.BYTES);
                scenario.attach(fileContent, "image/png", "Failure Screenshot");
            } catch (Exception e) {
                System.err.println("Failed to capture screenshot: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
