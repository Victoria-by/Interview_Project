package com.webdriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator implements IWebDriverCreator {

    protected final Logger LOG = LogManager.getLogger(getClass());

    @Override
    public ChromeDriver create() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        LOG.info("ChromeDriver was created");
        return new ChromeDriver();
    }
}
