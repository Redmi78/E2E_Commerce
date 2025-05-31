package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "C:\\Users\\ADMIN\\IdeaProjects\\E2E_EcommerceProject\\src\\test\\java\\features",
        glue ={"stepDefinitions","Pages"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestNGCucumberRunner extends  AbstractTestNGCucumberTests {

}
