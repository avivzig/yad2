package Yad2Pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Pagination extends CarsPage  {

        WebDriver driver;

        By page2 = By.xpath("//a[contains(@class, 'list_link__vC2xm') and contains(text(), '2')]");

        By page3 = By.cssSelector("li[data-testid='pageItem-3'] > a");

        By NumbrOfCars = By.cssSelector("span.total-items_totalItemsBox__ajzPB[data-testid='total-items']");

        private int count1;
        private int count2;
        private int count3;

        public Pagination(WebDriver driver) {
                super(driver);

                this.driver = driver;
        }
        @Step("Track Page - filtering with 2 types of truks ")
        public void TrackPage() throws InterruptedException {
                driver.findElement(Cars_text).click();
                Thread.sleep(2000);
                driver.findElement(tracks).click();
                Thread.sleep(2000);
                driver.findElement(Trak_producer).click();
                Thread.sleep(2000);

                driver.findElement(Iveku_track_producer).click();
                Thread.sleep(2000);
                driver.findElement(International_track_producer).click();
                Thread.sleep(2000);

        }





        @Step("clicking for search truck")
        public void search_tracks_tab(){
                driver.findElement(SearchTracks).click();

        }


        @Step("Get count of items on first page")
        public int paginationMethods1() {
                // Find all elements with class name 'feed-item-base_feedItemBox__5WVY1' and data-testid 'ltcz0ygd'
                java.util.List<WebElement> elements = driver.findElements(By.cssSelector("div.feed-item-base_feedItemBox__5WVY1"));
                // Count the elements
                count1 = elements.size();
                System.out.println("Number of elements found first page: " + count1);
                return count1;
        }
        @Step("Click on page 2")
        public void clickPageMethod1() throws InterruptedException {
                driver.findElement(page2).click();
        }
        @Step("Get count of items on second page")
        public int paginationMethods2() throws InterruptedException {
                Thread.sleep(4000); // Wait for 2 seconds between pages
                // Find all elements with class name 'feed-item-base_feedItemBox__5WVY1' and data-testid 'ltcz0ygd'
                java.util.List<WebElement> elements = driver.findElements(By.cssSelector("div.feed-item-base_feedItemBox__5WVY1"));
                // Count the elements
                count2 = elements.size();
                System.out.println("Number of elements found second page: " + count2);
                return count2;
        }
        @Step("Click on page 3")
        public void clickPageMethod2() {
                driver.findElement(page3).click();
        }
        @Step("Get count of items on last page")
        public int paginationMethods3()  {
                // Find all elements with class name 'feed-item-base_feedItemBox__5WVY1' and data-testid 'ltcz0ygd'
                java.util.List<WebElement> elements = driver.findElements(By.cssSelector("div.feed-item-base_feedItemBox__5WVY1"));
                // Count the elements
                count3 = elements.size();
                System.out.println("Number of elements found last page: " + count3);
                return count3;


        }
        @Step("Get total count of items")
        public void getTotalCount() throws InterruptedException {
                int total = count1 + count2 + count3;
                System.out.println("Total number of elements across all pages: " + total);

                Thread.sleep(2000);

                //compare between the amount at page to the counter of total list items at pages:
                WebElement totalItemsElement = driver.findElement(NumbrOfCars);
                String totalItemsText = totalItemsElement.getText();
                int totalItemsOnPage = Integer.parseInt(totalItemsText.split(" ")[0]); // Extract the number of items from the text
                Thread.sleep(2000);
                // Compare the total count with the number of items displayed on the page
                Assert.assertEquals(totalItemsOnPage, total, "Total items count mismatch");

                Thread.sleep(2000);


        }



}