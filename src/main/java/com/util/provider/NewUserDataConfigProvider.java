package com.util.provider;

import com.util.propertiesreader.PropertiesReader;

public class NewUserDataConfigProvider {

    private static final String NEW_USER_DATA_PROPERTIES_PATH = "src/main/resources/newUserData.properties";

    private NewUserDataConfigProvider() {
    }

    public static String getName() {
        return PropertiesReader.getStringFromPropertiesFile(NEW_USER_DATA_PROPERTIES_PATH, "Name");
    }

    public static String getEmail() {
        return PropertiesReader.getStringFromPropertiesFile(NEW_USER_DATA_PROPERTIES_PATH, "E-mail");
    }

    public static String getGender() {
        return PropertiesReader.getStringFromPropertiesFile(NEW_USER_DATA_PROPERTIES_PATH, "Gender");
    }

    public static String getCheckBoxValue() {
        return PropertiesReader.getStringFromPropertiesFile(NEW_USER_DATA_PROPERTIES_PATH, "CheckBox_Value");
    }

    public static String getDate() {
        return PropertiesReader.getStringFromPropertiesFile(NEW_USER_DATA_PROPERTIES_PATH, "Date");
    }

    public static String getDropdownOption() {
        return PropertiesReader.getStringFromPropertiesFile(NEW_USER_DATA_PROPERTIES_PATH, "Dropdown");
    }

    public static String getSliderValue() {
        return PropertiesReader.getStringFromPropertiesFile(NEW_USER_DATA_PROPERTIES_PATH, "Slider");
    }

    public static String getRow1() {
        return PropertiesReader.getStringFromPropertiesFile(NEW_USER_DATA_PROPERTIES_PATH, "Row1");
    }

    public static String getRow2() {
        return PropertiesReader.getStringFromPropertiesFile(NEW_USER_DATA_PROPERTIES_PATH, "Row2");
    }
}
