package com.pageobject;

import com.block.AuthorizationForm;
import com.block.UserInfoBlock;
import com.google.inject.Inject;
import com.util.provider.IAuthorizationConfigProvider;
import io.qameta.allure.Step;
import org.testng.Assert;

public class AuthorizationPage extends BasePage {

    private AuthorizationForm authorizationForm;
    private UserInfoBlock userInfoBlock;

    @Inject
    private IAuthorizationConfigProvider configProvider;

    public AuthorizationPage logInFromAuthorizationPage() {
        authorizationForm.logInFromAuthorizationPage(configProvider.getLogin(), configProvider.getPassword());
        return this;
    }

    @Step("Validate if User is logged")
    public void validateUserIsLogged() {
        Assert.assertTrue(userInfoBlock.isLoggedIn(configProvider.getUserName()), "User is not logged in");
    }
}
