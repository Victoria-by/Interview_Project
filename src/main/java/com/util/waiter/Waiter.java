package com.util.waiter;

import com.webdriver.WebDriverDiscovery;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import ru.yandex.qatools.htmlelements.element.*;

import java.time.Duration;

public class Waiter {

    private static final int SECONDS_TO_WAIT = 30;
    private static final int MILLIS_POLLING_INTERVAL = 500;

    private Waiter() {

    }

    public static HtmlElement waitForElementToBeClickable(HtmlElement htmlElement) {
        new FluentWait<>(WebDriverDiscovery.getWebDriver()).withTimeout(Duration.ofSeconds(SECONDS_TO_WAIT))
                .pollingEvery(Duration.ofMillis(MILLIS_POLLING_INTERVAL))
                .until((ExpectedCondition<Boolean>) webDriver -> htmlElement.isDisplayed() && htmlElement.isEnabled());
        return htmlElement;
    }

    public static Button waitForButtonToBeClickable(Button button) {
        new FluentWait<>(WebDriverDiscovery.getWebDriver()).withTimeout(Duration.ofSeconds(SECONDS_TO_WAIT))
                .pollingEvery(Duration.ofMillis(MILLIS_POLLING_INTERVAL))
                .until((ExpectedCondition<Boolean>) webDriver -> button.isDisplayed() && button.isEnabled());
        return button;
    }

    public static TextInput waitForTextInputToBeClickable(TextInput textInput) {
        new FluentWait<>(WebDriverDiscovery.getWebDriver()).withTimeout(Duration.ofSeconds(SECONDS_TO_WAIT))
                .pollingEvery(Duration.ofMillis(MILLIS_POLLING_INTERVAL))
                .until((ExpectedCondition<Boolean>) webDriver -> textInput.isDisplayed() && textInput.isEnabled());
        return textInput;
    }

    public static Link waitForLinkToBeClickable(Link link) {
        new FluentWait<>(WebDriverDiscovery.getWebDriver()).withTimeout(Duration.ofSeconds(SECONDS_TO_WAIT))
                .pollingEvery(Duration.ofMillis(MILLIS_POLLING_INTERVAL))
                .until((ExpectedCondition<Boolean>) webDriver -> link.isDisplayed() && link.isEnabled());
        return link;
    }

    public static Radio waitForRadioToBeClickable(Radio radio) {
        new FluentWait<>(WebDriverDiscovery.getWebDriver()).withTimeout(Duration.ofSeconds(SECONDS_TO_WAIT))
                .pollingEvery(Duration.ofMillis(MILLIS_POLLING_INTERVAL))
                .until((ExpectedCondition<Boolean>) webDriver -> radio.isDisplayed() && radio.isEnabled());
        return radio;
    }

    public static CheckBox waitForCheckBoxToBeClickable(CheckBox checkBox) {
        new FluentWait<>(WebDriverDiscovery.getWebDriver()).withTimeout(Duration.ofSeconds(SECONDS_TO_WAIT))
                .pollingEvery(Duration.ofMillis(MILLIS_POLLING_INTERVAL))
                .until((ExpectedCondition<Boolean>) webDriver -> checkBox.isDisplayed() && checkBox.isEnabled());
        return checkBox;
    }

    public static WebElement waitForElementVisibleLocatedBy(By by) {
        Wait<WebDriver> wait = new WebDriverWait(WebDriverDiscovery.getWebDriver(), (long) SECONDS_TO_WAIT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement waitForWebElementVisible(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(WebDriverDiscovery.getWebDriver(), (long) SECONDS_TO_WAIT);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
