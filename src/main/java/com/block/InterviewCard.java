package com.block;

import com.util.waiter.Waiter;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@Name("Interview card content")
@FindBy(xpath = "//div[contains(@class, 'myRccContentWrapper')]")
public class InterviewCard extends HtmlElement {

    protected final Logger LOG = LogManager.getLogger(getClass());

    private static final String DEMO_LINK_XPATH = "//div[contains(text(), 'Demo')]";

    @Name("Demo link")
    @FindBy(xpath = DEMO_LINK_XPATH)
    private Link demoLink;

    @Step("Click on Demo link")
    public void clickOnDemoLink() {
        Waiter.waitForLinkToBeClickable(demoLink).click();
        LOG.info("Click on Demo link");
    }
}
