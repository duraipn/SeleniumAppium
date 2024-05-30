package Accenture.HSBC_Meadows.driver.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import Accenture.HSBC_Meadows.constants.FrameworkConstants;
import Accenture.HSBC_Meadows.customexceptions.DriverInitializationException;
import Accenture.HSBC_Meadows.enums.ConfigJson;

import java.net.URI;
import java.time.Duration;
import java.util.Optional;

import static Accenture.HSBC_Meadows.utils.configloader.JsonParser.getConfig;

public final class AndroidManager {

  public static AppiumDriver createAndroidDriver() {
    try {
      UiAutomator2Options options = new UiAutomator2Options();
      options.setDeviceName(Optional.ofNullable(System.getProperty("deviceName"))
                              .orElse(getConfig(ConfigJson.ANDROID_DEVICE_NAME)))
        .setApp(FrameworkConstants.ANDROID_APK_PATH)
        .setAppPackage(getConfig(ConfigJson.ANDROID_APP_PACKAGE))
        .setAppActivity(getConfig(ConfigJson.ANDROID_APP_ACTIVITY))
        .setSystemPort(Integer.parseInt(Optional.ofNullable(System.getProperty("systemPort"))
                                          .orElse(getConfig(
                                            ConfigJson.ANDROID_SYSTEM_PORT))));
      if (getConfig(ConfigJson.ANDROID_EMULATOR).equalsIgnoreCase("yes")) {
        options.setAvd(Optional.ofNullable(System.getProperty("deviceName"))
                         .orElse(getConfig(ConfigJson.ANDROID_DEVICE_NAME)))
          .setAvdLaunchTimeout(Duration.ofMillis(Long.parseLong(getConfig(ConfigJson.AVD_LAUNCH_TIMEOUT))));
      }
      return new AndroidDriver(new URI(getConfig(ConfigJson.APPIUM_URL)).toURL(), options);
    } catch (Exception e) {
      throw new DriverInitializationException("Failed to initialize driver. Please check the desired capabilities", e);
    }
  }
}
