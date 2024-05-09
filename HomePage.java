package Yad2Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {


    WebDriver driver;
    //text menu tabs
    By Nadlan_text = By.xpath("//span[contains(text(),'נדל״ן')]");
    By Cars_text = By.xpath("//span[contains(text(),'רכב')]");
    By Yadshniya_text = By.xpath("//span[contains(text(),'יד שנייה')]");
    By DrushimIL_text = By.xpath("//span[contains(text(),'דרושים IL')]");
    By Asakim_text = By.xpath("//span[contains(text(),'עסקים למכירה')]");
    By Hayot_text = By.xpath("//span[contains(text(),'חיות מחמד')]");
    By Baaleymikzoa_text = By.xpath("//span[contains(text(),'בעלי מקצוע')]");
    By Magazin_text = By.xpath("//span[contains(text(),'מגזין יד2')]");

    //lower menu text

    By Nadlan_img = By.cssSelector("#__next main section:nth-child(2) main ul li:first-child a div span img");
    By Cars_img = By.xpath("//img[@alt='רכב']");
    By Yadshniya_img =  By.xpath("//*[@alt='יד שנייה']");
    By DrushimIL_img = By.xpath("//*[@alt='דרושים']");
    By Asakim_img = By.xpath("//img[@alt='עסקים למכירה' and contains(@class, 'menu-category-item_arrowIcon__BD42Q')]");
    By Hayot_img = By.xpath("//img[@alt='חיות מחמד' and contains(@class, 'menu-category-item_arrowIcon__BD42Q')]");
    By Baaleymikzoa_img = By.xpath("//img[@alt='בעלי מקצוע' and contains(@class, 'menu-category-item_arrowIcon__BD42Q')]");




    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("clicking on text car tab only")
    public void click_on_cartext(){

        driver.findElement(Cars_text).click();
    }

    @Step("clicking on text car tab and getting the URL and asserting it")
    public void Click_on_car_text_tab(){
        driver.findElement(Cars_text).click();
        String currentURL = driver.getCurrentUrl();
        String expectedURL1 = "https://www.yad2.co.il/vehicles/cars";
        Assert.assertEquals(currentURL,expectedURL1);
        //boolean isURLMatched = currentURL.equals(expectedURL1);

    }


    @Step("clicking on img car tab and getting the URL and asserting the the url with the text car TAB ")
    public void Click_on_car_img_tab(){
        driver.findElement(Cars_img).click();
        String currentURL = driver.getCurrentUrl();
        String expectedURL2 = "https://www.yad2.co.il/vehicles/cars";
        boolean isURLMatched = currentURL.equals(expectedURL2);


    }








}
