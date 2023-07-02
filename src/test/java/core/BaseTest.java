package core;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.Browser;

import java.time.Duration;

public abstract class BaseTest {
    @BeforeClass
    public void setupBrowser() {
        Browser.setup();
    }

    @AfterClass
    public void tearDownBrowser() {
        Browser.tearDown();
    }
}
