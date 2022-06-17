package com.block;

import com.util.waiter.Waiter;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Authorization form")
@FindBy(xpath = "//div[contains(@class, 'loginContentPanel loginPageMobile')]")
public class AuthorizationForm extends HtmlElement {

    protected final Logger LOG = LogManager.getLogger(getClass());

    private static final String SIGN_IN_BUTTON_XPATH = "//span[contains(text(), 'Sign in')]";
    private static final String E_MAIL_INPUT_XPATH = "//input[contains(@id, 'login_username')]";
    private static final String PASSWORD_INPUT_XPATH = "//input[contains(@id, 'login_password')]";

    @Name("SignIn button")
    @FindBy(xpath = SIGN_IN_BUTTON_XPATH)
    private Button singInButton;

    @Name("Field for email")
    @FindBy(xpath = E_MAIL_INPUT_XPATH)
    private TextInput emailInput;

    @Name("Field for password")
    @FindBy(xpath = PASSWORD_INPUT_XPATH)
    private TextInput passwordInput;

    private void inputData(TextInput textInput, String data) {
        Waiter.waitForTextInputToBeClickable(textInput).sendKeys(data);
    }

    @Step("Click on sign in button")
    private void clickOnSignInButton(Button singInButton) {
        Waiter.waitForButtonToBeClickable(singInButton).click();
        LOG.info("Click on sing in button");
    }

    @Step("Input login and password")
    public void logInFromAuthorizationPage(String login, String password) {
        inputData(emailInput, login);
        clickOnSignInButton(singInButton);
        inputData(passwordInput, password);
        clickOnSignInButton(singInButton);
        LOG.info("User is logged in");
    }
}

