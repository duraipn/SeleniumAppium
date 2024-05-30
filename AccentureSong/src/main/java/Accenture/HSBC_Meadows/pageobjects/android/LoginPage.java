package Accenture.HSBC_Meadows.pageobjects.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import Accenture.HSBC_Meadows.pageobjects.screen.ScreenActions;
import org.openqa.selenium.WebElement;

public class LoginPage extends ScreenActions {

  @AndroidFindBy(accessibility = "test-Username")
  @iOSXCUITFindBy(accessibility = "test-Username")
  private static WebElement txtFieldUsername;

  @AndroidFindBy(accessibility = "test-Password")
  @iOSXCUITFindBy(accessibility = "test-Password")
  private static WebElement txtFieldPassword;

  @AndroidFindBy(accessibility = "test-LOGIN")
  @iOSXCUITFindBy(accessibility = "test-LOGIN")
  private static WebElement btnLogin;

  @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
  private static WebElement errorMessage;

  @AndroidFindBy(accessibility = "test-Menu")
  @iOSXCUITFindBy(accessibility = "test-Menu")
  private static WebElement menuHamburger;

  @AndroidFindBy(accessibility = "test-LOGOUT")
  @iOSXCUITFindBy(accessibility = "test-LOGOUT")
  private static WebElement btnLogout;

  public boolean isLoginPageDisplayed() {
    return isElementDisplayed(txtFieldUsername);
  }

  public LoginPage setUsername(String username) {
    enter(txtFieldUsername, username);
    return this;
  }

  public LoginPage setPassword(String password) {
    enter(txtFieldPassword, password);
    return this;
  }

  public ProductPage tapOnLogin() {
    click(btnLogin);
    return new ProductPage();
  }

  public ProductPage login(String username, String password) {
    setUsername(username)
            .setPassword(password)
            .tapOnLogin();

    return new ProductPage();
  }

  public String getErrorText() {
    return getText(errorMessage);
  }

  public LoginPage tapOnLogout() {
    click(menuHamburger);
    click(btnLogout);
    return new LoginPage();
  }
}

