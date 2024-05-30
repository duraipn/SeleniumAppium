package Accenture.HSBC_Meadows.runner;
import Accenture.HSBC_Meadows.TestUtils.ExtentReporterNG;
import Accenture.HSBC_Meadows.driver.Drivers;
import Accenture.HSBC_Meadows.driver.manager.DriverManager;
import Accenture.HSBC_Meadows.enums.ConfigJson;
import Accenture.HSBC_Meadows.enums.MobilePlatformName;
import Accenture.HSBC_Meadows.utils.AppiumServerManager;
import Accenture.HSBC_Meadows.utils.AppiumUtils;
import Accenture.HSBC_Meadows.utils.screenrecording.ScreenRecordingService;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.common.collect.ImmutableMap;
import io.cucumber.java.Scenario;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static Accenture.HSBC_Meadows.utils.AppiumServerManager.startAppiumServer;
import static Accenture.HSBC_Meadows.utils.AppiumServerManager.stopAppiumServer;
import static Accenture.HSBC_Meadows.utils.configloader.JsonParser.getConfig;


@CucumberOptions(plugin = {"pretty",
  "summary",
  "html:target/cucumber-html-output/cucumber-html-report.html",
  "json:target/cucumber-json-output/cucumber.json"},
  features = {"src/test/java/Accenture/HSBC_Meadows/feature"},
  glue = {"Accenture.HSBC_Meadows.stepdefinitions"},
  tags = "@Login"
)
public class RunnerTestNG extends AbstractTestNGCucumberTests{
    private AppiumUtils apputils;
    private static WebDriver driver;
    DriverManager driverManager = new DriverManager();

   // @BeforeMethod(alwaysRun=true)
    //public void preSetup() {
      //  ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",getConfig(ConfigJson.ANDROID_APP_PACKAGE)+"/"+getConfig(ConfigJson.ANDROID_APP_ACTIVITY)));
    //}
    @BeforeClass
    public static void setUp() {
        startAppiumServer();
        if (Objects.isNull(DriverManager.getDriver())) {
            Drivers.initializeDriver(MobilePlatformName.valueOf(
                    Optional.ofNullable(System.getProperty("platformName"))
                            .orElse(getConfig(ConfigJson.PLATFORM)).toUpperCase()));
           // driver = DriverManager.getDriver();
        }
    }

    @AfterClass
    public static void tearDown() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            Drivers.quitDriver();
        }
        stopAppiumServer();
    }
  /*  @Test(dataProvider = "getData")
    public static void getJsondata()
    {
        HashMap<String,String> input = new HashMap<>();
        String txtname=input.get("name");
        String txtgender=input.get("gender");
    }

    @DataProvider
    public Object[][] getData() throws IOException
    {
        List<HashMap<String, String>> data =apputils.getJsonData(PROJECT_PATH+"\\"+TESTDATA_PATH+"\\accountCreation.json");
        return new Object[][] { {data.get(0)},{data.get(1)}  };
    }*/
}
