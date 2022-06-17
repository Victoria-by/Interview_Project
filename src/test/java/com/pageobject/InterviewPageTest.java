package com.pageobject;

import com.navigation.Navigation;
import com.util.TestListener;
import com.util.provider.BaseConfigProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
@Feature("Search across InterviewPageTest")
public class InterviewPageTest extends BaseTest {

    private final AccountHomePage accountHomePage = new AccountHomePage();
    private final InterviewPage interviewPage = new InterviewPage();
    private final MyActivitiesPage myActivitiesPage = new MyActivitiesPage();

    @BeforeClass
    @Description("Navigate to url")
    public void loadPage() {
        Navigation.navigateTo(BaseConfigProvider.getBaseUrl());
    }

    @Test
    @Description("Log in and check user status")
    @Story("Input login and password")
    public void login() {
        authorizationPage.logInFromAuthorizationPage()
                .validateUserIsLogged();
    }

    @Test(dependsOnMethods = "login")
    @Description("Check Demo status after filling forms with valid data")
    @Story("Fill general info, group2, matrix on MyActivitiesPage")
    @Owner("Victoryia Ananyeva")
    public void fillInfoAndCheckStatusTest() {
        accountHomePage.clickOnInterviewCardButton();
        interviewPage.clickOnDemoLink();
        myActivitiesPage.fillGeneralInfo()
                .fillGroup2()
                .selectMatrixValues()
                .clickOnCancelButton();
        Assert.assertEquals(interviewPage.getStatus(),
                "Not Started",
                "Demo status is not as expected");
    }
}
