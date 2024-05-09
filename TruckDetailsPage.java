package Yad2Pages;

import org.openqa.selenium.By;

public class TruckDetailsPage {



    //list elements before  click on truck "find elements" :
    protected By trackName1 = By.xpath("//span[@class='feed-item-info_heading__k5pVC']");
    protected By text1 = By.xpath("//span[@class='feed-item-info_marketingText__eNE4R']");
    protected By yeaR1 = By.xpath("//span[@class='feed-item-info_yearAndHandBox___JLbc']");
    protected By priCe1 = By.xpath("//span[@class='commercial-item-left-side_priceBox__M3qDp']");
    protected By haNd1 = By.xpath("//span[@class='feed-item-info_yearAndHandBox___JLbc']");


//after click on truck elements:
    protected By trackName = By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div/div[1]/h1");
    protected By text = By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div/div[1]/h2");
    protected By yeaR = By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div/div[1]/div[2]/div[1]/span");
    protected By priCe = By.xpath("/html/body/div[2]/div[3]/main/div[2]/aside/div/div[1]/div[1]/div[1]/span/span");
    protected By haNd = By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div/div[1]/div[2]/div[2]/span[2]");

}

