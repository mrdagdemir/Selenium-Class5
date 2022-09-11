package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class HomeWork3 {

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
        Iterator<WebElement> it=options.iterator();
        while (it.hasNext()){
            WebElement ddOption=it.next();
            String optionsText=ddOption.getText();
            System.out.println(optionsText);
        }
        Thread.sleep(2000);
        select.selectByValue("58058");
        WebElement searchButton=driver.findElement(By.xpath("//input[@value='Search']"));
        Thread.sleep(2000);
        searchButton.click();
        WebElement header=driver.findElement(By.xpath("//h1[@class='b-pageheader']"));
        String headerText=header.getText();
        System.out.println(headerText);
        if(header.isDisplayed() && headerText.equals("Computers, Tablets & Network Hardware")){
            System.out.println("Header is correct and verified");
        }else{
            System.out.println("Header is not displayed");
        }
    }

}
