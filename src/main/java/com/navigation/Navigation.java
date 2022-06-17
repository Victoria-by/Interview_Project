package com.navigation;

import com.webdriver.WebDriverDiscovery;

public class Navigation {

    public static void navigateTo(String url) {
        WebDriverDiscovery.getWebDriver().get(url);
    }
}
