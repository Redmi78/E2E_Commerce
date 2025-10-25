package Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.Utility;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = Utility.getDefaultDriver();
        driver.get("https://demo.prestashop.com/#/en/front");
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed() && driver != null) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure Screenshot");
            }
        } catch (Exception e) {
            System.err.println("⚠️ Failed to capture screenshot: " + e.getMessage());
        } finally {
            Utility.quitDriver(); // Always quit driver
        }
    }
}
