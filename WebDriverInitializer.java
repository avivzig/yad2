package Yad2Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class WebDriverInitializer {

    @Step("setting up the URL for starting every test")
    public static WebDriver initializeChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\Maven1\\Appium\\chromedriver5a\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.yad2.co.il/"); // Navigate to the URL
        return driver;
    }


}
