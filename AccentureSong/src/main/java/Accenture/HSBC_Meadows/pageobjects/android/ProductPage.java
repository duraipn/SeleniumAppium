package Accenture.HSBC_Meadows.pageobjects.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import Accenture.HSBC_Meadows.pageobjects.screen.ScreenActions;
import org.openqa.selenium.WebElement;

public class ProductPage extends ScreenActions {

  @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
  private static WebElement productPageTitle;

  public String getProductPageTitle() {
    return getText(productPageTitle);
  }
}
