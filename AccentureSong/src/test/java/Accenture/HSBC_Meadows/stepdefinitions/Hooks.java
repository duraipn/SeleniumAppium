package Accenture.HSBC_Meadows.stepdefinitions;

import Accenture.HSBC_Meadows.TestUtils.Extent;
import Accenture.HSBC_Meadows.TestUtils.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import Accenture.HSBC_Meadows.utils.screenrecording.ScreenRecordingService;
import Accenture.HSBC_Meadows.utils.screenshot.ScreenshotService;

public class Hooks {
  ExtentReports extent = ExtentReporterNG.getReporterObject();
  @Before
  public void setUp(Scenario scenario) {
    ScreenRecordingService.startRecording();
    if (Extent.getTest() == null) Extent.setTest(extent.createTest(scenario.getName()));
  }

  @After
  public void tearDown(Scenario scenario) {

    if (scenario.isFailed()) {
      scenario.attach(ScreenshotService.getScreenshotAsBytes(),
              "image/png", scenario.getName());
    }
    ScreenRecordingService.stopRecording(scenario.getName());
  }

}
