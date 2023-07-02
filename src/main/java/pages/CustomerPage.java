package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.EmailGenarator;
import utils.WaitTool;

public class CustomerPage extends BasePage {

    private static final By PLUS_BUTTON =  By.xpath("//*[@class = \"fa fa-plus\"]/ ..");
    private static final By FIRST_NAME_INPUT = By.id("input-firstname");
    private static final By LAST_NAME_INPUT = By.id("input-lastname");
    private static final By EMAIL_INPUT = By.id("input-email");
    private static final By PHONE_NUMBER = By.id("input-telephone");
    private static final By PASSWORD_INPUT = By.id("input-password");
    private static final By CONFIRM_PASSWORD_INPUT = By.id("input-confirm");
    private static final By SAVE_BUTTON = By.xpath("//*[@class = \"fa fa-save\"]/ ..");

    private static final By USERNAME_FILTER_INPUT = By.id("input-name");

    private static final By FILTER_BUTTON = By.id("button-filter");

    private static final By CUSTOMER_LIST_CUSTOMER_NAME = By.xpath("//*[@id='form-customer']/table/tbody/tr/td[2]");

    private static final By CUSTOMER_LIST_NO_RESULT_LABEL = By.xpath("//*[@id='form-customer']/table/tbody/tr/td");

    private static String emailAddress = EmailGenarator.generator();



    public static void clickPlusButton(){ clickOnElementByLocator(PLUS_BUTTON);}

    public static void writeFirstName(String name){
        driver.findElement(FIRST_NAME_INPUT).sendKeys(name);
    }
    public static void writeLastName(String name){
        driver.findElement(LAST_NAME_INPUT).sendKeys(name);
    }

    public static void writeEmailAddress(){

       driver.findElement(EMAIL_INPUT).sendKeys(emailAddress);
    }
    public static void writePhoneNumber(String phoneNumber){
        driver.findElement(PHONE_NUMBER).sendKeys(phoneNumber);
    }

    public static void writePassAndConfirmPassword(String password){
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(password);
    }

    public static void clickSaveButton(){
        clickOnElementByLocator(SAVE_BUTTON);
    }

    public static void validateSuccessAlert(){

       WebElement alert = WaitTool.waitForElementVisibility(By.className("alert-success"), 3);

        Assert.assertTrue(alert.isDisplayed());
    }

    public static void writeFilterUsername(String name){

        driver.findElement(USERNAME_FILTER_INPUT).sendKeys(name);
    }

    public static void clickFilterButton() {
        clickOnElementByLocator(FILTER_BUTTON);
    }

    public static void verifyFilterWorkWithAvailableName(){
        WebElement searchedName = WaitTool.waitForElementVisibility(CUSTOMER_LIST_CUSTOMER_NAME, 3);

        Assert.assertTrue(searchedName.isDisplayed());
    }

    public static void verifyFilterWorkWithUnavailableName(){
        WebElement noResultLabel = WaitTool.waitForElementVisibility(CUSTOMER_LIST_NO_RESULT_LABEL, 3);
        Assert.assertEquals( noResultLabel.getText(), "No results!");
    }
}
