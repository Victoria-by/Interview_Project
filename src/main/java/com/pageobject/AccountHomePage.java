package com.pageobject;

import com.block.AccountMenu;
import io.qameta.allure.Step;

public class AccountHomePage extends BasePage {

    private AccountMenu accountMenu;

    @Step("Click on Interview card button")
    public AccountHomePage clickOnInterviewCardButton() {
        accountMenu.clickOnInterviewCard();
        return this;
    }
}
