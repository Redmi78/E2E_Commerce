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
    public static String stack, broswer;
public  static  WebDriver driver;
    static Properties prop = new Properties();

    public static String getStack() {
        if (stack == null) {
            stack = System.getProperty("stack", "pie").toLowerCase();
        }
        return stack;
    }


    public static String getProxyHostName() {
        return System.getProperty("proxyHostName", "localhost");
    }

    public static int getProxyPort() {
        return Integer.parseInt(System.getProperty("proxyPort", "8080"));
    }

    public static String getPropertyFilePath() {
        String path;
        switch (getStack()) {
            case "pie":
                path = new File("src/test/resources/pie.properties").getAbsolutePath();
                break;
            case "stg":
                path = new File("src/test/resources/stg.properties").getAbsolutePath();
                break;

            default:
                throw new IllegalArgumentException("Invalid stack: " + getStack());
        }
        return path;
    }

    public static String getBrowser()
    {
        if (broswer == null) {
            broswer = System.getProperty("browser", "chrome").toLowerCase();
        }
        return broswer;
    }

    public static WebDriver getDefaultDriver() {
        if (driver != null) {
return  driver;
        }
        if("edge".equalsIgnoreCase(getBrowser()))
        {
            WebDriverManager.edgedriver().setup();
        }
        else{
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().clearDriverCache().setup();
            WebDriverManager.chromedriver().clearResolutionCache().setup();
            WebDriverManager.chromedriver().setup();
           // options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-extensions");
            //PageLoadStrategy.EAGER: As soon as the DOM is loaded, Selenium proceeds—even if images or styles are still loading.
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            driver = new ChromeDriver(options);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
            driver.manage().window().maximize();

        }
        return driver;
    }

    public static String base64Encode(String value) {
        return java.util.Base64.getEncoder().encodeToString(value.getBytes());
    }

    public static String base64Decode(String value) {
        return new String(java.util.Base64.getDecoder().decode(value));
    }

    public static String generateGuid() {
        return java.util.UUID.randomUUID().toString();
    }

    //date
    public static String getTodayUTCDate()
    {
        return Instant.now().toString().split("T")[0];
    }

    public  static  String addDaysToDate() {
        String durationType = "Month";
        DateFormat dateFormat = new SimpleDateFormat("MM");
        Date cuttentDate = new Date();
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(cuttentDate);
        switch (durationType.toLowerCase())
        {
            case "year":
                calendar.add(Calendar.YEAR, 1);
                break;
            case "month":
                calendar.add(Calendar.MONTH, 1);
                break;
            case "day":
                    calendar.add(Calendar.DATE,1);
                break;
            default:
                throw new IllegalArgumentException("Invalid duration type: " + durationType);
        }


        Date currentDatePlusDuration = calendar.getTime();
        return dateFormat.format(currentDatePlusDuration);
    }
}
