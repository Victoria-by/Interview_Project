package com.pageobject;

import com.block.InterviewCard;
import com.util.waiter.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InterviewPage extends BasePage {

    private InterviewCard interviewCard;

    private static final String STATUS = "//div[contains(@class, 'crfStatusAvailable')]";

    @FindBy(xpath = STATUS)
    private WebElement status;

    public InterviewPage clickOnDemoLink() {
        interviewCard.clickOnDemoLink();
        return this;
    }

    public String getStatus() {
        return Waiter.waitForWebElementVisible(status).getText();
    }
}
