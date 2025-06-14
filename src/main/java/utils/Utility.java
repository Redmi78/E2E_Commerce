package utils;

import com.sun.jna.platform.win32.OaIdl;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class Utility {


    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDefaultDriver() {
        if (driver.get() == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications", "--disable-popup-blocking", "--disable-extensions");
            driver.set(new ChromeDriver(options));
            driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public static void resetDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

