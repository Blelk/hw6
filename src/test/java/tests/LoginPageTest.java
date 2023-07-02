package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginSuccessfully() {
        LoginPage.goToLoginPage();
        LoginPage.writeTextInUsernameInputField("admin");
        LoginPage.writeTextInPasswordInputField("parola123!");
        LoginPage.clickLoginButton();
        DashboardPage.verifyUsernameLabelText("Milen Strahinski");
    }

    @Test
    public void loginWithNotCorrectCredentials() {
        LoginPage.goToLoginPage();
        LoginPage.writeTextInUsernameInputField("admin");
        LoginPage.writeTextInPasswordInputField("invalid password");
        LoginPage.clickLoginButton();
        LoginPage.verifyValidationMessage("No match for Username and/or Password.");
    }
}
