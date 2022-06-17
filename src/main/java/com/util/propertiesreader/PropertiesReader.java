package com.util.propertiesreader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private PropertiesReader() {
    }

    public static String getStringFromPropertiesFile(String path, String property) {
        try (InputStream input = new FileInputStream(path)) {
            Properties appProps = new Properties();
            appProps.load(input);
            return appProps.getProperty(property);
        } catch (IOException ex) {
            throw new IllegalStateException("Check directory to the properties file");
        }
    }
}
