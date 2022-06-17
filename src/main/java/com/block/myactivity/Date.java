package com.block.myactivity;

import com.util.provider.NewUserDataConfigProvider;
import com.util.service.PageElementService;
import com.util.waiter.Waiter;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;

public class Date extends HtmlElement {

    protected final Logger LOG = LogManager.getLogger(getClass());

    private static final String DATE_BUTTON = "//div[@class = 'dciInputPanel']" +
            "//div[@aria-hidden = 'true' and @class = 'fi']";
    private static final String DATE_BOX_POPUP_XPATH = "//div[contains(@class, 'popupContent')]";
    private static final String MONTH_LISTBOX_XPATH = "//td[contains(@class, 'datePickerMonth')]/select";
    private static final String YEAR_LISTBOX_XPATH = "//td[contains(@class, 'datePickerYear')]/select";
    private static final String DAY_XPATH = "//div[contains(@class, 'datePickerDay ') " +
            "and not (contains(@class, 'datePickerDayIsFiller '))]";

    @Name("Month listbox select")
    @FindBy(xpath = MONTH_LISTBOX_XPATH)
    private Select monthSelect;

    @Name("Year listbox select")
    @FindBy(xpath = YEAR_LISTBOX_XPATH)
    private Select yearSelect;

    public void selectDate() {
        clickOnTheDateForm();
        switchToDateBoxPopup();
        selectMonth();
        selectYear();
        selectDay();
    }

    @Step("Click on the date form")
    private void clickOnTheDateForm() {
        Waiter.waitForElementVisibleLocatedBy(By.xpath(DATE_BUTTON)).click();
        LOG.info("Click on the date form");
    }

    @Step("Switch to the date popup")
    private void switchToDateBoxPopup() {
        PageElementService.moveTo(DATE_BOX_POPUP_XPATH);
        LOG.info("Switch to the date popup");
    }

    @Step("Select month")
    private void selectMonth() {
        monthSelect.selectByValue(getMonth(splitDate()));
        LOG.info("Month selected");
    }

    @Step("Select year")
    private void selectYear() {
        yearSelect.selectByValue(getYear(splitDate()));
        LOG.info("Year selected");
    }

    @Step("Select day")
    private void selectDay() {
        PageElementService.selectElementWithText(getDay(splitDate()), DAY_XPATH);
        LOG.info("Day selected");
    }

    private String[] splitDate() {
        String propertyDate = NewUserDataConfigProvider.getDate();
        LOG.info("Split date from property");
        return propertyDate.split(" ");
    }

    private String getDay(String[] split) {
        return split[1];
    }

    private String getMonth(String[] split) {
        return split[0];
    }

    private String getYear(String[] split) {
        return split[2];
    }
}

