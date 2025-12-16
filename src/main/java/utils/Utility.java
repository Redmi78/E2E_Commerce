package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Utility {

    // ThreadLocal ensures each test thread gets its own WebDriver
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static final String GRID_URL = System.getProperty("gridUrl", "http://localhost:4444/wd/hub");
    private static final boolean USE_GRID = Boolean.parseBoolean(System.getProperty("useGrid", "false")); // default local

    public static WebDriver getDefaultDriver() {
        if (driver.get() == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications", "--disable-popup-blocking", "--disable-extensions");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

            try {
                if (USE_GRID) {
                    System.out.println("Running test on Selenium Grid: " + GRID_URL);
                    driver.set(new RemoteWebDriver(new URL(GRID_URL), options));
                } else {
                    System.out.println("Running test locally");
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(options));
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Selenium Grid URL: " + GRID_URL, e);
            }

            driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            driver.get().manage().window().maximize();
        }

        return driver.get();
    }

    public static void quitDriver() {
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            try {
                webDriver.quit();
            } catch (Exception e) {
                System.err.println("Failed to quit driver: " + e.getMessage());
            } finally {
                driver.remove(); // remove from ThreadLocal
            }
        }
    }
}
