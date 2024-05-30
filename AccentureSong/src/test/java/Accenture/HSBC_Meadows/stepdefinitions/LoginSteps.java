package Accenture.HSBC_Meadows.stepdefinitions;

import Accenture.HSBC_Meadows.TestUtils.Extent;
import Accenture.HSBC_Meadows.TestUtils.ExtentReporterNG;
import Accenture.HSBC_Meadows.utils.screenshot.ScreenshotService;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Accenture.HSBC_Meadows.pageobjects.android.LoginPage;
import Accenture.HSBC_Meadows.pageobjects.android.ProductPage;
import org.junit.Assert;


public class LoginSteps{

  @When("^User enter username as \"([^\"]*)\"$")
  public void userEnterUsernameAs(String username) {
    new LoginPage().setUsername(username);
    Extent.getTest().log(Status.PASS, "Login Page: User entered the Username: "+username);
  }

  @When("^User enter password as \"([^\"]*)\"$")
  public void userEnterPasswordAs(String password) {
    new LoginPage().setPassword(password);
    Extent.getTest().log(Status.PASS, "Login Page: User entered the Password: "+password);
  }

  @When("^clicks on login$")
  public void clickOnLogin() {
    new LoginPage().tapOnLogin();
    Extent.getTest().log(Status.PASS, "Login Page: User clicked Login button ");
  }

  @Then("^login should fail with an error \"([^\"]*)\"$")
  public void loginShouldFailWithAnError(String err) {
    Assert.assertEquals(new LoginPage().getErrorText(), err);
    Extent.getTest().log(Status.PASS, "Login Page: User able to see the error message as expected - "+err);
  }

  @Then("^User should see Products page with title \"([^\"]*)\"$")
  public void userShouldSeeProductsPageWithTitle(String title) {
    //Assert.assertEquals(new ProductPage().getProductPageTitle(), title);
    Extent.getTest().log(Status.PASS, "Product Page: User navigated to products page");
    String actualValue = new ProductPage().getProductPageTitle();
    if (actualValue.equals(title)) {
      Extent.getTest().log(Status.PASS, "Actual Value - " + actualValue + " is matching with Expected Value - " + title);
      //Extent.getTest().addScreenCaptureFromPath(appUtils.getScreenshotPath(scenarioName,driver), scenarioName);
    } else {
      Extent.getTest().log(Status.FAIL, "Actual Value - " + actualValue + " is NOT matching with Expected Value - " + title);
      //Assert.fail();
      //Extent.getTest().addScreenCaptureFromPath(appUtils.getScreenshotPath(scenarioName,driver), scenarioName);

    }
  }
  @And("^User able to logout successfully")
  public void userAbleToLogoutSuccessfully(){
    new LoginPage().tapOnLogout();
    Extent.getTest().log(Status.PASS, "Login Page: User Logout and navigated to Login page");
  }
  @When("User enter username: {string} and password: {string}")
  public void userEnterUsernameAndPassword(String username, String password) {
    new LoginPage().setUsername(username).setPassword(password);
    Extent.getTest().log(Status.PASS, "Login Page: User entered the Username: "+username);
    Extent.getTest().log(Status.PASS, "Login Page: User entered the Password: "+password);
  }
}
