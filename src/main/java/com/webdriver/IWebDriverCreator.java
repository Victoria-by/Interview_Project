package com.webdriver;

import org.openqa.selenium.remote.RemoteWebDriver;

public interface IWebDriverCreator<T extends RemoteWebDriver> {
    T create();
}
