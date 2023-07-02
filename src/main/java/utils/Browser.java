package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Browser {
    private static WebDriver driver;

    public static void setup() {
        if(driver == null) {
          driver = new ChromeDriver();
          driver.manage().window().maximize();
        }
    }

    public static void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }


}
