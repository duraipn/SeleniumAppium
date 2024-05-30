package Accenture.HSBC_Meadows.driver;
import Accenture.HSBC_Meadows.driver.factory.DriverFactory;
import Accenture.HSBC_Meadows.driver.manager.DriverManager;
import Accenture.HSBC_Meadows.enums.MobilePlatformName;

import java.util.Objects;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Drivers {

  public static void initializeDriver(MobilePlatformName mobilePlatformName) {
    DriverManager.setAppiumDriver(DriverFactory.getDriver(mobilePlatformName));
  }

  public static void quitDriver() {
    if (Objects.nonNull(DriverManager.getDriver())) {
      DriverManager.getDriver().quit();
      DriverManager.unload();
    }
  }
}
