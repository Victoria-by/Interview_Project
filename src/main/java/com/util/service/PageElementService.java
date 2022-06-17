package com.util.service;

import com.webdriver.WebDriverDiscovery;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class PageElementService {

    private PageElementService() {
    }

    public static WebElement findElement(By by) {
        return WebDriverDiscovery.getWebDriver().findElement(by);
    }

    public static List<WebElement> findElements(By by){
        return WebDriverDiscovery.getWebDriver().findElements(by);
    }

    public static void selectElementWithText(String text, String xpath) {
        List<WebElement> elements = findElements(By.xpath(xpath));
        for (WebElement e : elements) {
            if (e.getText().equals(text)) {
                e.click();
                break;
            }
        }
    }

    public static void moveTo(String xpath){
        WebElement element = findElement(By.xpath(xpath));
        Actions actions = new Actions(WebDriverDiscovery.getWebDriver());
        actions.moveToElement(element).build().perform();
    }

    public static boolean isDisplayed(By locator){
        try{
            return findElement(locator).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
