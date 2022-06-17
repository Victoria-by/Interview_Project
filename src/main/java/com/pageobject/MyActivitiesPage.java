package com.pageobject;

import com.block.myactivity.Date;
import com.block.myactivity.GeneralInfo;
import com.block.myactivity.Group2;
import com.block.myactivity.Matrix;
import com.util.provider.NewUserDataConfigProvider;
import com.util.service.PageElementService;
import com.util.waiter.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

public class MyActivitiesPage extends BasePage {

    private GeneralInfo generalInfo;
    private Date date;
    private Group2 group2;
    private Matrix matrix;
    private static final String CANCEL_BUTTON_XPATH = "//div[contains(@class, 'myHealthButtonsBottom')]" +
            "/button[contains(@class, 'btn btn-default cancelButton')]";

    @Name("Cancel button")
    @FindBy(xpath = CANCEL_BUTTON_XPATH)
    private Button cancelButton;

    public MyActivitiesPage fillGeneralInfo() {
        inputName();
        inputEmail();
        clickGenderRadioButton();
        clickCheckBox();
        selectDate();
        selectDropdownOption();
        return this;
    }

    public MyActivitiesPage fillGroup2() {
        scrollToCancelButton();
        uploadImage();
        moveSliderBar();
        return this;
    }

    public MyActivitiesPage selectMatrixValues() {
        scrollToCancelButton();
        matrix.selectAllMatrixValues();
        return this;
    }

    private void inputName() {
        generalInfo.inputName(NewUserDataConfigProvider.getName());
    }

    private void inputEmail() {
        generalInfo.inputEmail(NewUserDataConfigProvider.getEmail());
    }

    private void clickGenderRadioButton() {
        generalInfo.clickGenderRadioButton();
    }

    private void clickCheckBox() {
        generalInfo.clickCheckBox();
    }

    private void selectDate() {
        date.selectDate();
    }

    private void selectDropdownOption() {
        generalInfo.selectDropdownOption();
    }

    @Step("Scroll to cancel button")
    private void scrollToCancelButton() {
        PageElementService.moveTo(CANCEL_BUTTON_XPATH);
        LOG.info("Scroll to cancel button");
    }

    private void uploadImage() {
        group2.uploadImage();
    }

    private void moveSliderBar() {
        group2.moveSliderBar();
    }

    @Step("Click on cancel button")
    public MyActivitiesPage clickOnCancelButton() {
        Waiter.waitForButtonToBeClickable(cancelButton).click();
        LOG.info("Click on cancel button");
        return this;
    }
}
