package com.block;

import com.util.waiter.Waiter;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Account menu")
@FindBy(xpath = "//div[contains(@class, 'panelContent')]")
public class AccountMenu extends HtmlElement {

    protected final Logger LOG = LogManager.getLogger(getClass());

    private static final String INTERVIEW_ELEMENT_XPATH = "//div[contains(@class, 'card card-4')]";

    @Name("Interview card link")
    @FindBy(xpath = INTERVIEW_ELEMENT_XPATH)
    private HtmlElement interviewElement;

    @Step("Click on interview card")
    public void clickOnInterviewCard() {
        Waiter.waitForElementToBeClickable(interviewElement).click();
        LOG.info("Click on Interview card");
    }
}
