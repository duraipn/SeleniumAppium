package Accenture.HSBC_Meadows.utils.configloader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import Accenture.HSBC_Meadows.constants.FrameworkConstants;
import Accenture.HSBC_Meadows.customexceptions.JsonFileUsageException;
import Accenture.HSBC_Meadows.enums.ConfigJson;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class JsonParser {
  private static Map<String, String> map;
  static void readJson(String jsonPath) {
    try {
      map = new ObjectMapper().readValue(new File(jsonPath),
                                         new TypeReference<HashMap<String, String>>() {
                                         });
    } catch (IOException e) {
      throw new JsonFileUsageException("Exception occurred while reading Json file in the specified path");
    }
  }

  public static String getConfig(ConfigJson key) {
    readJson(FrameworkConstants.CONFIG_JSON_PATH);
    if (Objects.isNull(map.get(key.name().toLowerCase()))) {
      throw new JsonFileUsageException("Property name - " + key + " is not found. Please check the config.json");
    }
    return map.get(key.name().toLowerCase());
  }
}
