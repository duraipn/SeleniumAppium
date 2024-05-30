package Accenture.HSBC_Meadows.driver.manager;

import io.appium.java_client.AppiumDriver;
import java.util.Objects;

public final class DriverManager {

  private static final ThreadLocal<AppiumDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

  public static AppiumDriver getDriver() {
    return DRIVER_THREAD_LOCAL.get();
  }

  public static void setAppiumDriver(AppiumDriver driver) {
    if (Objects.nonNull(driver))
      DRIVER_THREAD_LOCAL.set(driver);
  }

  public static void unload() {
    DRIVER_THREAD_LOCAL.remove();
  }
}
