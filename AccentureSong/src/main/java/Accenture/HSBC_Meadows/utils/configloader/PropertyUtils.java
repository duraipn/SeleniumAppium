package Accenture.HSBC_Meadows.utils.configloader;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import Accenture.HSBC_Meadows.constants.FrameworkConstants;
import Accenture.HSBC_Meadows.customexceptions.PropertyFileUsageException;
import Accenture.HSBC_Meadows.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PropertyUtils {

  private static final Properties property = new Properties();

  static void loadProperties() {
    try (var input = new FileInputStream(FrameworkConstants.CONFIG_PROPERTIES_PATH)) {
      property.load(input);
    } catch (IOException e) {
      throw new PropertyFileUsageException("IOException occurred while loading Property file in the specified path");
    }
  }

  public static String getPropertyValue(ConfigProperties key) {
    loadProperties();
    if (Objects.isNull(property.getProperty(key.name().toLowerCase()))) {
      throw new PropertyFileUsageException("Property name - " + key + " is not found. Please check the config.properties");
    }
    return property.getProperty(key.name().toLowerCase());
  }
}
