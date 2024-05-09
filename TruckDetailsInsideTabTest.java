package Yad2Tests;

import Yad2Pages.FilterPage;
import Yad2Pages.Pagination;
import Yad2Pages.TruckDetailsPage;
import Yad2Pages.WebDriverInitializer;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TruckDetailsInsideTabTest extends TruckDetailsPage {

    ChromeDriver driver;
    WebDriverWait wait;
    String parentWindowHandle;
    private Pagination testcases;
    private FilterPage filter;


    @BeforeSuite
    public void setup() {
        // Initialize WebDriver using the method from WebDriverInitializer
        driver = (ChromeDriver) WebDriverInitializer.initializeChromeDriver();


        wait = new WebDriverWait(driver, 20);

        parentWindowHandle = driver.getWindowHandle();
        testcases = new Pagination(driver);
        filter = new FilterPage(driver);
    }

    // Your test methods here




    @Test(priority = 1, description = "getting to the trucks page with all previus filters")
    @Description("after setup the yad2 URL , getting to the point previus Test : FilterPageTest stoped")
    public void gettingToTheTrackPageFlow() throws InterruptedException {

        testcases.TrackPage();

        filter.price_select();
        Thread.sleep(2000);
        filter.price_click();
        Thread.sleep(2000);
        filter.price_ishrur1();
        Thread.sleep(2000);

        testcases.search_tracks_tab();
        Thread.sleep(2000);
        filter.press_on_filter();
        filter.press_zol_to_yakar();
        Thread.sleep(2000);
    }



    @Test(priority = 2, description = "extract elements of trucks before and after clicking on each tab",dependsOnMethods = "gettingToTheTrackPageFlow")
    @Description("after getting to the point of previus test: FilterPageTest , listing all the 3 first track elements before clicking on" +
            "each tab of truck and after that  getting inside every truck details and asserting the details of truck before clicking and after  ")
    public void findTrucksAndMarketingText() {
        // Find all elements with the class 'feed-item-info_heading__k5pVC'
        List<WebElement> truckElements = driver.findElements(trackName1);
        // Find all elements with the class 'feed-item-info_marketingText__eNE4R'
        List<WebElement> marketingTextElements = driver.findElements(text1);

        List<WebElement> yearConditionElement = driver.findElements(yeaR1);

        List<WebElement> priceElement = driver.findElements(priCe1);

        List<WebElement> carHand = driver.findElements(haNd1);

        // Iterate through each truck
        int numTrucksToProcess = Math.min(3, truckElements.size());
        for (int i = 0; i < numTrucksToProcess; i++) {
            WebElement truck = truckElements.get(i);
            WebElement marketingTextElement = marketingTextElements.get(i);
            WebElement year = yearConditionElement.get(i);
            WebElement price = priceElement.get(i);
            WebElement hand = carHand.get(i);

            // Print truck elements and store the text of the first element
            String beforeMakeModel = truck.getText();
            System.out.println("Truck make: " + beforeMakeModel);

            // Print marketing text elements and store their text
            String beforeDescription = marketingTextElement.getText();
            System.out.println("Marketing Text: " + beforeDescription);

            String beforeYearCondition = year.getText().split(" ")[0];
            System.out.println("year Text: " + beforeYearCondition);

            String beforePrice = price.getText();
            System.out.println("price Text: " + beforePrice);

            String[] splitText = hand.getText().split(" ");
            String beforehand = splitText[splitText.length - 1];
            System.out.println("hand Text: " + beforehand);

            // Wait until the truck element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(truck));

            // Click on the truck
            truck.click();

            // Switch to the new window
            switchToNewWindow();

            // Wait for the page to load completely
            waitForPageToLoad();

            // Get the text of the element after clicking
            WebElement makeModelElement = driver.findElement(trackName);
            String afterMakeModel = makeModelElement.getText();
            assertEquals(beforeMakeModel, afterMakeModel);

            // Get the text of the description element before clicking
            WebElement descriptionElement = driver.findElement(text);
            String afterDescription = descriptionElement.getText();
            assertEquals(beforeDescription, afterDescription);

            WebElement yearConditionElement1 = driver.findElement(yeaR);
            String afterYearCondition = yearConditionElement1.getText();
            assertEquals(beforeYearCondition, afterYearCondition);

            WebElement priceElement1 = driver.findElement(priCe);
            String afterPrice = priceElement1.getText();
            assertEquals(beforePrice, afterPrice);

            WebElement handElement1 = driver.findElement(haNd);
            String afterhand = handElement1.getText();
            assertEquals(beforehand, afterhand);

            // Close the current window and switch back to the parent window
            closeAndSwitchToParentWindow();

            // Scroll the page
            scrollPage();

            // Add a wait to stabilize the test
            waitForPageToStabilize();
        }
    }

    @AfterSuite
    public void tearDown() {
        // Close the WebDriver instance after test execution
        driver.quit();
    }

    private void switchToNewWindow() {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    private void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div/div[1]/h1")));
    }

    private void closeAndSwitchToParentWindow() {
        driver.close();
        driver.switchTo().window(parentWindowHandle);
    }

    private void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200)");
    }

    private void waitForPageToStabilize() {
        // Add code to wait for specific conditions indicating that the page has stabilized
        // For example, wait for a loading spinner to disappear or for a certain element to be present
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-spinner")));
    }
}
