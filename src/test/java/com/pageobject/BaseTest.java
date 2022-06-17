package com.pageobject;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.util.provider.AuthorizationConfigProvider;
import com.webdriver.WebDriverDiscovery;
import io.qameta.allure.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    protected AuthorizationPage authorizationPage;

    @BeforeClass
    @Description("Inject mocks")
    public void initInjections() {
        Injector injector = Guice.createInjector(new AuthorizationConfigProvider());
        authorizationPage = injector.getInstance(AuthorizationPage.class);
    }

    @AfterClass
    @Description("Close driver")
    public void closeDriver() {
        WebDriverDiscovery.getWebDriver().quit();
    }
}
