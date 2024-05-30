package Accenture.HSBC_Meadows.driver.factory;

import io.appium.java_client.AppiumDriver;
import Accenture.HSBC_Meadows.driver.manager.AndroidManager;
import Accenture.HSBC_Meadows.enums.MobilePlatformName;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import static Accenture.HSBC_Meadows.enums.MobilePlatformName.ANDROID;
import static Accenture.HSBC_Meadows.enums.MobilePlatformName.IOS;

public final class DriverFactory {

  private static final Map<MobilePlatformName, Supplier<AppiumDriver>> DRIVER_TYPE_MAP =
    new EnumMap<>(MobilePlatformName.class);

  static {
    DRIVER_TYPE_MAP.put(ANDROID, AndroidManager::createAndroidDriver);
    //DRIVER_TYPE_MAP.put(IOS, IosManager::createIOSDriver);
  }

  public static AppiumDriver getDriver(MobilePlatformName mobilePlatformName) {
    return DRIVER_TYPE_MAP.get(mobilePlatformName).get();
  }
}
