package Accenture.HSBC_Meadows.runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import Accenture.HSBC_Meadows.driver.Drivers;
import Accenture.HSBC_Meadows.driver.manager.DriverManager;
import Accenture.HSBC_Meadows.enums.ConfigJson;
import Accenture.HSBC_Meadows.enums.MobilePlatformName;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.util.Objects;
import java.util.Optional;

import static Accenture.HSBC_Meadows.utils.AppiumServerManager.startAppiumServer;
import static Accenture.HSBC_Meadows.utils.AppiumServerManager.stopAppiumServer;
import static Accenture.HSBC_Meadows.utils.configloader.JsonParser.getConfig;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
  "summary",
  "html:target/cucumber-html-output/cucumber-html-report.html",
  "json:target/cucumber-json-output/cucumber.json"},
  features = {"src/test/java/Accenture/HSBC_Meadows/feature"},
  glue = {"Accenture.HSBC_Meadows.stepdefinitions"},
  monochrome = true,
  tags = "@Login"
)
public class RunnerJunit{
  private static ExtentTest test;
  private static ExtentReports extent;
  private static final Scenario scenario = null;


  private static WebDriver driver;

  DriverManager driverManager = new DriverManager();
  @BeforeClass
  public static void setUp() {
    startAppiumServer();
    if (Objects.isNull(DriverManager.getDriver())) {
      Drivers.initializeDriver(MobilePlatformName.valueOf(
        Optional.ofNullable(System.getProperty("platformName"))
          .orElse(getConfig(ConfigJson.PLATFORM)).toUpperCase()));
    }
  }

  @AfterClass
  public static void tearDown() {
    if (Objects.nonNull(DriverManager.getDriver())) {
      Drivers.quitDriver();
    }
    stopAppiumServer();
  }

}
