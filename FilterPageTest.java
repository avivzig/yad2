package Yad2Tests;

import Yad2Pages.FilterPage;
import Yad2Pages.Pagination;
import Yad2Pages.WebDriverInitializer;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FilterPageTest {

    private FilterPage filter;
    private WebDriver driver;
    private Pagination testcases;

    @BeforeClass
    public void setUp() {
        driver = WebDriverInitializer.initializeChromeDriver();
        filter = new FilterPage((ChromeDriver) driver);
        testcases = new Pagination((ChromeDriver) driver);
    }

    @Test(priority = 1, description = "moving to the filter of trucks")
    @Description("loading the page URL and moving to the page of trucks choosing 2 types of trucks")
    public void gettingTheFilterPage() throws InterruptedException {
        testcases.TrackPage();
    }

    @Test(priority = 2, description = "choosing the tab of price filter")
    @Description("pressing on the price filter tabs that get the items with price only")
    public void must_be_with_price() throws InterruptedException {
        filter.price_select();
        Thread.sleep(2000);
        filter.price_click();
        Thread.sleep(2000);
        filter.price_ishrur1();
        Thread.sleep(2000);
    }

    @Test(priority = 3, description = "filtering 'zol to yakar' and checking the price ascending")
    @Description("confirm the first filter of price and products , pressing on the filter tab and" +
            " filtering the trucks from cheap to expensive and asserting the oreder ")
    public void applyFilterAndCheckPriceOrder() throws InterruptedException {
        testcases.search_tracks_tab();
        Thread.sleep(2000);
        filter.press_on_filter();
        filter.press_zol_to_yakar();
        filter.print_prices_and_assert_order();
    }
}
