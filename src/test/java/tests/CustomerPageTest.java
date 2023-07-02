package tests;

import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.DashboardPage;
import pages.LoginPage;

public class CustomerPageTest extends LoginPageTest {

    @Test
    public void addNewCustomerTest(){
        loginSuccessfully();
        DashboardPage.clickOnCustomersLabel();
        DashboardPage.clickOnCustomerDropdown();
        CustomerPage.clickPlusButton();
        CustomerPage.writeFirstName("Petar");
        CustomerPage.writeLastName("Kirilov");
        CustomerPage.writeEmailAddress();
        CustomerPage.writePhoneNumber("657544862");
        CustomerPage.writePassAndConfirmPassword("parola");
        CustomerPage.clickSaveButton();
        CustomerPage.validateSuccessAlert();
    }

    @Test
    public void filterByUserName (){
        LoginPage.goToLoginPage();
        LoginPage.writeTextInUsernameInputField("admin");
        LoginPage.writeTextInPasswordInputField("parola123!");
        LoginPage.clickLoginButton();
        DashboardPage.clickOnCustomersLabel();
        DashboardPage.clickOnCustomerDropdown();
        CustomerPage.writeFilterUsername("Petar");
        CustomerPage.clickFilterButton();
        CustomerPage.verifyFilterWorkWithAvailableName();
    }

    @Test
    public void negativeFilterByUsername(){
        LoginPage.goToLoginPage();
        LoginPage.writeTextInUsernameInputField("admin");
        LoginPage.writeTextInPasswordInputField("parola123!");
        LoginPage.clickLoginButton();
        DashboardPage.clickOnCustomersLabel();
        DashboardPage.clickOnCustomerDropdown();
        CustomerPage.writeFilterUsername("Petarrrrrrrrrrr");
        CustomerPage.clickFilterButton();
        CustomerPage.verifyFilterWorkWithUnavailableName();
    }

}
