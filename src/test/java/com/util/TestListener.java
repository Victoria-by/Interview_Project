package com.util;

import com.webdriver.WebDriverDiscovery;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    protected final Logger LOG = LogManager.getLogger(getClass());

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.getLifecycle().addAttachment(
                "screenshot", "image/png", "png",
                ((TakesScreenshot) WebDriverDiscovery.getWebDriver()).getScreenshotAs(OutputType.BYTES));
        LOG.info("Screenshot on test failure");
        WebDriverDiscovery.getWebDriver().close();
    }
}
