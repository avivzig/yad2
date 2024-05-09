package Yad2Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CarsPage extends HomePage  {

    WebDriver driver;
    By privatecar = By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/main/div[1]/form/div/div[2]/ul/li[1]/a/span");

    // 6 sub menu filter of "private cars":

    By Car_kind = By.xpath("//span[@class='desktop-only' and contains(text(),'סוג רכב')]");
    By Producer = By.xpath("//span[contains(@class, 'desktop-only') and contains(text(), 'יצרן')]");
    By Firm = By.xpath("//span[contains(@class, 'desktop-only') and contains(text(), 'דגם')]");
    By Year = By.xpath("//span[contains(@class, 'pseudo-drop-button_text__duTa4') and contains(text(), 'שנה')]");
    By More_Filters =  By.xpath("//span[contains(@class, 'toggle-button_buttonText__jUvpU') and contains(text(), 'סינונים נוספים')]");
    By Search = By.xpath("//span[contains(text(), 'חיפוש')]");

    By motorcycle = By.xpath("//span[text()='אופנועים']");
    By minibike = By.xpath("//span[text()='קטנועים']");

    By tracks = By.xpath("//span[text()='משאיות']");
    //sub menu filter for "traks tab":

   By Trak_producer = By.xpath("//span[@class='desktop-only' and text()='יצרן']");

   //the menu after pressing on the "producer" tab:

    By Iveku_track_producer = By.xpath("//span[text()='איווקו']");
    By International_track_producer = By.xpath("//span[text()='אינטרנשיונל']");
    By more_Filters_track = By.xpath("//span[@class='toggle-button_buttonText__jUvpU' and text()='סינונים נוספים']");
    //mark the checkbox:
    By filter_checkbox = By.xpath("//svg[@class='check-box_checkIcon__3Rwjj']");
    //confirm the filter details:

    By Confirm_tracks_filter = By.cssSelector("button.action-buttons_approve__pG6HF");

    By SearchTracks = By.xpath("//span[text()='חיפוש']");

    By sea_travel = By.xpath("//span[text()='כלי שייט']");
    By special = By.xpath("//span[text()='מיוחדים']");



    //text header of page:

    By privatecar_header = By.xpath("//h1[contains(@class, 'search-results_heading__R1Ikr') and text()='רכבים למכירה']");

    By motorcycle_header = By.xpath("//h1[@class='search-results_heading__R1Ikr' and text()='אופנועים למכירה']");

    By minibike_header = By.xpath("//h1[@class='search-results_heading__R1Ikr' and text()='קטנועים למכירה']");
    By tracks_header = By.xpath("//h1[@class='search-results_heading__R1Ikr' and text()='משאיות למכירה']");

    By sea_travel_header = By.xpath("//h1[@class='search-results_heading__R1Ikr' and text()='כלי שייט למכירה']");
    By special_headre = By.xpath("//h1[@class='search-results_heading__R1Ikr' and text()='רכבים מיוחדים למכירה']");


    public CarsPage(WebDriver driver) {
        super(driver);

        this.driver = driver;


    }

    public void clickoncartext(){
        HomePage carTextTab = new HomePage(driver);
        carTextTab.Click_on_car_text_tab();
    }


    @Step("clicking on private cars and asserting the title of page")
    public void verifyPrivateCar() {

        driver.findElement(privatecar).click();
        WebElement motorcycleElement7 = driver.findElement(privatecar);
        Assert.assertTrue(motorcycleElement7.isDisplayed(), "element is not displayed");

        driver.findElement(privatecar_header).isDisplayed();
        WebElement motorcycleElement8 = driver.findElement(privatecar_header);
        Assert.assertTrue(motorcycleElement8.isDisplayed(), "header element is not displayed");
    }


    //motorcycle header
    @Step("clicking on motorcycle and asserting the title of page")
    public void verifyMotorcycleTabs() {

            driver.findElement(motorcycle).click();
            WebElement motorcycleElement1 = driver.findElement(motorcycle);
            Assert.assertTrue(motorcycleElement1.isDisplayed(), "element is not displayed");

         driver.findElement(motorcycle_header).isDisplayed();
        WebElement motorcycleElement2 = driver.findElement(motorcycle_header);
        Assert.assertTrue(motorcycleElement2.isDisplayed(), "header element is not displayed");
    }




    // minibike headers
    @Step("clicking on minibike and asserting the title of page")
    public void verifybikeTabs() {

        driver.findElement(minibike).click();
        WebElement motorcycleElement3 = driver.findElement(minibike);
        Assert.assertTrue(motorcycleElement3.isDisplayed(), "element is not displayed");

        driver.findElement(minibike_header).isDisplayed();
        WebElement motorcycleElement4 = driver.findElement(minibike_header);
        Assert.assertTrue(motorcycleElement4.isDisplayed(), "header element is not displayed");
    }



    @Step("clicking on trucks and asserting the title of page")
    public void tracks() {

        driver.findElement(tracks).click();
        WebElement motorcycleElement5 = driver.findElement(tracks);
        Assert.assertTrue(motorcycleElement5.isDisplayed(), "element is not displayed");

        driver.findElement(tracks_header).isDisplayed();
        WebElement motorcycleElement6 = driver.findElement(tracks_header);
        Assert.assertTrue(motorcycleElement6.isDisplayed(), "header element is not displayed");
    }

    @Step("clicking on sea travel and asserting the title of page")
    public void verifySeatravel() {

        driver.findElement(sea_travel).click();
        WebElement motorcycleElement9 = driver.findElement(sea_travel);
        Assert.assertTrue(motorcycleElement9.isDisplayed(), "element is not displayed");

        driver.findElement(sea_travel_header).isDisplayed();
        WebElement motorcycleElement10 = driver.findElement(sea_travel_header);
        Assert.assertTrue(motorcycleElement10.isDisplayed(), "header element is not displayed");
    }


    @Step("clicking on special items and asserting the title of page")
    public void verifySpecialTravel() {

        driver.findElement(special).click();
        WebElement motorcycleElement11 = driver.findElement(special);
        Assert.assertTrue(motorcycleElement11.isDisplayed(), " element is not displayed");

        driver.findElement(special_headre).isDisplayed();
        WebElement motorcycleElement12 = driver.findElement(special_headre);
        Assert.assertTrue(motorcycleElement12.isDisplayed(), "header element is not displayed");
    }







    }
