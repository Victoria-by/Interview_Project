package com.util.provider;

import com.google.inject.AbstractModule;
import com.util.propertiesreader.PropertiesReader;

public class AuthorizationConfigProvider extends AbstractModule implements IAuthorizationConfigProvider {

    @Override
    protected void configure() {
        bind(IAuthorizationConfigProvider.class).to(AuthorizationConfigProvider.class);
    }
    private static final String AUTHORISATION_PROPERTIES_PATH = "src/main/resources/authorization.properties";

    public String getLogin() {
        return PropertiesReader.getStringFromPropertiesFile(AUTHORISATION_PROPERTIES_PATH, "login");
    }

    public String getPassword() {
        return PropertiesReader.getStringFromPropertiesFile(AUTHORISATION_PROPERTIES_PATH, "password");
    }

    public String getUserName() {
        return PropertiesReader.getStringFromPropertiesFile(AUTHORISATION_PROPERTIES_PATH, "userName");
    }
}
