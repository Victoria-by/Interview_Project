package com.util.provider;

import com.util.propertiesreader.PropertiesReader;

public class BaseConfigProvider {

    private static final String CONFIG_PATH = "src/main/resources/config.properties";

    private BaseConfigProvider() {
    }

    public static String getBaseUrl() {
        return PropertiesReader.getStringFromPropertiesFile(CONFIG_PATH, "baseUrl");
    }

    public static String getDriverType() {
        return PropertiesReader.getStringFromPropertiesFile(CONFIG_PATH, "driverType");
    }
}
