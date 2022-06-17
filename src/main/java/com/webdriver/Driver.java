package com.webdriver;

import java.util.Arrays;

public enum Driver {

    CHROME("chrome", new ChromeDriverCreator());

    private String driverType;
    private final IWebDriverCreator iWebDriverCreator;

    Driver(String driverType, IWebDriverCreator iWebDriverCreator) {
        this.driverType = driverType;
        this.iWebDriverCreator = iWebDriverCreator;
    }

    public String getDriverType() {
        return driverType;
    }

    public IWebDriverCreator getWebDriverCreator() {
        return iWebDriverCreator;
    }

    public static Driver getByDriverType(String driverType) {
        return Arrays.stream(Driver.values())
                .filter(driver -> driver.getDriverType().equals(driverType))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Driver type'" + driverType
                        + "' is not specified in Driver enum"));
    }
}
