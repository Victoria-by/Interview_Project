package com.webdriver;

import com.util.provider.BaseConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverDiscovery {

    private static final ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<>();

    private WebDriverDiscovery() {
    }

    private static void startBrowser() {
        setWebDriver(Driver.getByDriverType(BaseConfigProvider.getDriverType())
                .getWebDriverCreator()
                .create());
    }

    private static void setWebDriver(RemoteWebDriver driver) {
        remoteWebDriver.set(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    public static WebDriver getWebDriver() {
        if (remoteWebDriver.get() == null) {
            startBrowser();
        }
        return remoteWebDriver.get();
    }
}
