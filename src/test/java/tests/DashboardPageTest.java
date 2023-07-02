package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardPageTest extends BaseTest {
    @Test
    public void logoutTest(){
        LoginPage.goToLoginPage();
        LoginPage.writeTextInUsernameInputField("admin");
        LoginPage.writeTextInPasswordInputField("parola123!");
        LoginPage.clickLoginButton();
        DashboardPage.clickOnLogoutButton();
        LoginPage.checkForLoginButton();
    }
}
