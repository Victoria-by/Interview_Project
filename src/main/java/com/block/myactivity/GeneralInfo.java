package com.block.myactivity;

import com.util.provider.NewUserDataConfigProvider;
import com.util.service.PageElementService;
import com.util.waiter.Waiter;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Radio;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

@Name("General info section")
@FindBy(xpath = "//div[contains(@class, 'myRccContentWrapper')]")
public class GeneralInfo extends HtmlElement {

    protected final Logger LOG = LogManager.getLogger(getClass());

    private static final String NAME_INPUT_XPATH = "//input[contains(@id, 'name')]";
    private static final String EMAIL_INPUT_XPATH = "//input[contains(@id, 'e_mail')]";
    private static final String MALE_GENDER_RADIOBUTTON_XPATH = "//input[contains(@id, 'gwt-uid-109')]";
    private static final String FEMALE_GENDER_RADIOBUTTON_XPATH = "//input[contains(@id, 'gwt-uid-110')]";
    private static final String NO_CHECKBOX_XPATH = "//div[text() = 'No']";
    private static final String YES_CHECKBOX_XPATH = "//div[text() = 'Yes']";
    private static final String DROPDOWN_SELECT_XPATH = "//input[contains(@title, 'Select')]";
    private static final String DROPDOWN_POPUP_XPATH = "//ul[@class = 'dropdown-menu']";

    @Name("Field for name")
    @FindBy(xpath = NAME_INPUT_XPATH)
    private TextInput nameInput;

    @Name("Field for email")
    @FindBy(xpath = EMAIL_INPUT_XPATH)
    private TextInput emailInput;

    @Name("Male gender radioButton")
    @FindBy(xpath = MALE_GENDER_RADIOBUTTON_XPATH)
    private Radio maleGenderRadioButton;

    @Name("Female gender radioButton")
    @FindBy(xpath = FEMALE_GENDER_RADIOBUTTON_XPATH)
    private Radio femaleGenderRadioButton;

    @Name("CheckBox NO")
    @FindBy(xpath = NO_CHECKBOX_XPATH)
    private CheckBox noCheckBox;

    @Name("CheckBox YES")
    @FindBy(xpath = YES_CHECKBOX_XPATH)
    private CheckBox yesCheckBox;

    @Step("Input name in the field")
    public void inputName(String name) {
        Waiter.waitForTextInputToBeClickable(nameInput);
        nameInput.sendKeys(name);
        LOG.info("Name added");
    }

    @Step("Input email in the field")
    public void inputEmail(String email) {
        Waiter.waitForTextInputToBeClickable(emailInput);
        emailInput.sendKeys(email);
        LOG.info("E-mail added");
    }

    public void clickGenderRadioButton() {
        String gender = NewUserDataConfigProvider.getGender();
        if (gender.equalsIgnoreCase("Male")) {
            clickMaleGenderRadioButton();
        } else if (gender.equalsIgnoreCase("Female")) {
            clickFemaleGenderRadioButton();
        }
        LOG.info("Gender added");
    }

    @Step("Click male gender radioButton")
    private void clickMaleGenderRadioButton() {
        Waiter.waitForRadioToBeClickable(maleGenderRadioButton).click();
    }

    @Step("Click female gender radioButton")
    private void clickFemaleGenderRadioButton() {
        Waiter.waitForRadioToBeClickable(femaleGenderRadioButton).click();
    }

    public void clickCheckBox() {
        String value = NewUserDataConfigProvider.getCheckBoxValue();
        if (value.equalsIgnoreCase("No")) {
            clickNoCheckBox();
        } else if (value.equalsIgnoreCase("Yes")) {
            clickYesCheckBox();
        }
        LOG.info("CheckBox value selected");
    }

    @Step("Click checkBox NO")
    private void clickNoCheckBox() {
        Waiter.waitForCheckBoxToBeClickable(noCheckBox).select();
    }

    @Step("Click checkBox YES")
    private void clickYesCheckBox() {
        Waiter.waitForCheckBoxToBeClickable(yesCheckBox).select();
    }

    @Step("Select dropdown option")
    public void selectDropdownOption() {
        PageElementService.findElement(By.xpath(DROPDOWN_SELECT_XPATH)).click();
        PageElementService.moveTo(DROPDOWN_POPUP_XPATH);
        String dropdown = NewUserDataConfigProvider.getDropdownOption();
        List<WebElement> elements = PageElementService
                .findElements(By.xpath("//ul[@class = 'dropdown-menu']//li"));
        for (WebElement webElement : elements) {
            if (webElement.getText().equals(dropdown)) {
                webElement.click();
                break;
            }
        }
        LOG.info("Dropdown option selected");
    }
}
