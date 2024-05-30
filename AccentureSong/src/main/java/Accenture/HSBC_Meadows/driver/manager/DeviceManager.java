package Accenture.HSBC_Meadows.driver.manager;

public final class DeviceManager {

  private static final ThreadLocal<String> DEVICE_NAME = new ThreadLocal<>();

  public static String getDeviceName() {
    return DEVICE_NAME.get();
  }

  public static void setDeviceName(String device) {
    DEVICE_NAME.set(device);
  }

  public static void removeDeviceName() {
    DEVICE_NAME.remove();
  }
}
