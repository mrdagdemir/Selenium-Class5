package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomeWork03 {

    /*
      Go to ebay.com
    get all the categories and print them in the console
    select Computers/Tables & Networking
    click on search
    verify the header
     */

    public static String url="https://ebay.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement categoryDD=driver.findElement(By.xpath("//select[@id='gh-cat']"));
        Select select=new Select(categoryDD);
        List<WebElement> options=select.getOptions();
        for(WebElement option:options){
            String optionText=option.getText();
            System.out.println(optionText);
        }
        Thread.sleep(2000);
        select.selectByVisibleText("Computers/Tablets & Networking");
        WebElement searchButton=driver.findElement(By.xpath("//input[@id='gh-btn']"));
        searchButton.click();
        WebElement header=driver.findElement(By.xpath("//span[@class='b-pageheader__text']"));
        boolean headerText=header.isDisplayed();
        System.out.println(headerText);
        if(headerText){
            System.out.println("Header is Displayed and verified");
        }else{
            System.out.println("Header is not displayed");
        }


    }
}

