package Yad2Pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FilterPage {

    WebDriver driver;

    By price_filter = By.cssSelector("svg.pseudo-sort-button_arrowIcon__ZlYnC");
    By Zol_to_yakar = By.xpath("//span[text()='מחיר - מהזול ליקר']");
    By priceElementLocator = By.xpath("//span[@class='price_price__xQt90' and @data-testid='price']");

    //tracks with price only:

    By price_of_track_select = By.cssSelector("span.toggle-button_buttonText__jUvpU");

    By price_track_click = By.xpath("//span[contains(@class,'check-box_title__i76lj') and contains(text(),'עם מחיר')]");
    By price_ishur = By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/main/div[1]/form/div/div[2]/div/div/div[1]/div[5]/div/div/div[2]/div/div[3]/button[2]");

    public FilterPage(WebDriver driver) {

        this.driver = driver;
    }

    //3 methods for choosing the price filter
    @Step("clicking on filter tab")
    public void price_select(){
        driver.findElement(price_of_track_select).click();
    }
    @Step("clicking on price filter tab")
    public void price_click(){
        driver.findElement(price_track_click).click();
    }

    @Step(" clicking on confirm")
    public void price_ishrur1(){
        driver.findElement(price_ishur).click();
    }




    @Step("clicking on the filter tab")
    public void press_on_filter() throws InterruptedException {
        driver.findElement(price_filter).click();
        Thread.sleep(2000);
    }


    @Step("clicking on the tab of filter price and choosing the filter of lower price to expensive ")
    public void press_zol_to_yakar() throws InterruptedException {
        driver.findElement(Zol_to_yakar).click();
        Thread.sleep(2000);
    }


    @Step("asserting the order of prices at the list item")
    public void print_prices_and_assert_order() {
        // Locate all price elements
        List<WebElement> priceElements = driver.findElements(priceElementLocator);

        // Iterate through each price element and extract the price
        int previousPrice = Integer.MIN_VALUE;
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText();
            // Remove any non-digit characters from the price text and convert to integer
            int price = Integer.parseInt(priceText.replaceAll("[^\\d]", ""));
            System.out.println("Price: " + price);

            // Assert that the current price is greater than or equal to the previous price
            assert price >= previousPrice : "Prices are not in ascending order";

            // Update the previousPrice for the next iteration
            previousPrice = price;
        }

        System.out.println("Assertion passed: Prices are in ascending order");

        // Print prices in a list
        System.out.println("Prices in list format:");
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText();
            int price = Integer.parseInt(priceText.replaceAll("[^\\d]", ""));
            System.out.println(price);
        }
    }
}