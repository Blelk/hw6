package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Browser;
import utils.WaitTool;

public class DashboardPage extends BasePage {
    @FindBy(xpath = "//img[@id='user-profile']/ ..")
    private static WebElement usernameLink;

    @FindBy(xpath = "//*[@id='menu-customer']/a")
    private static WebElement customersLabel;

    @FindBy(xpath = "//*[@id=\"menu-customer\"]//li[1]/a")
    private static WebElement customerDropdown;

    @FindBy(xpath = "//*[@class = 'fa fa-sign-out']/ ..")
    private static WebElement logoutButton;

    static {
        PageFactory.initElements(driver, DashboardPage.class);
    }

    public static void verifyUsernameLabelText(String expectedText) {
        WaitTool.waitForElementVisibility(By.xpath("//img[@id='user-profile']/ .."), 3);
        Assert.assertEquals(usernameLink.getText(), expectedText);
    }

    public static void clickOnCustomersLabel() {
        clickOnElement(customersLabel);
    }

    public static void clickOnCustomerDropdown(){
        WaitTool.waitForElementVisibility(By.xpath("//*[@id=\"menu-customer\"]//li[1]/a"),3);
        clickOnElement(customerDropdown);
    }

    public static void clickOnLogoutButton(){
        clickOnElement(logoutButton);
    }
}
