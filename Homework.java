package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Homework {

/*
TC 1: Facebook dropdown verification
Open chrome browser
Go to “https://www.facebook.com”
click on create new account
Verify:
month dd has 12 month options
day dd has 31 day options
year dd has 115 year options
Select your date of birth
Quit browsers
 */

    public static String url = "https://www.facebook.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement createNewAccountButton = driver.findElement(By.xpath("//a[text()='Create new account']"));
        createNewAccountButton.click();
        Thread.sleep(2000);

        WebElement monthDD = driver.findElement(By.xpath("//select[@id='month']"));
        Select select = new Select(monthDD);
        List<WebElement> monthOptions = select.getOptions();
        int monthSize = monthOptions.size();
        System.out.println(monthSize);
        select.selectByIndex(9);

        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select select1 = new Select(day);
        List<WebElement> daysOptions = select1.getOptions();
        int daySize = daysOptions.size();
        System.out.println(daySize);
        select1.selectByValue("21");

        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        Select select2 = new Select(year);
        List<WebElement> yearOptions = select2.getOptions();
        int yearSize = yearOptions.size();
        System.out.println(yearSize);
        select2.selectByVisibleText("1990");
        Thread.sleep(1000);
        driver.quit();
    }
}