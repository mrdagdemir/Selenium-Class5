package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomeWork2 {


    /*
     HW1
Go to facebook sign up page
Fill out the whole form
Click signup
     */
    public static String url = "https://www.facebook.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement createNewAccountButton = driver.findElement(By.xpath("//a[text()='Create new account']"));
        createNewAccountButton.click();
        Thread.sleep(2000);

        WebElement firstName= driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Eva");
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Cri");
        WebElement phoneNumber=driver.findElement(By.xpath("//input[@name='reg_email__']"));
        phoneNumber.sendKeys("571-222-3333");
        WebElement password=driver.findElement(By.xpath("//input[@id='password_step_input']"));
        password.sendKeys("KKJ123456");

        WebElement birthMonth=driver.findElement(By.xpath("//select[@id='month']"));
        Select select=new Select(birthMonth);
        List<WebElement> monthOptions=select.getOptions();
        select.selectByValue("7");

        WebElement birthDay=driver.findElement(By.xpath("//select[@id='day']"));
        Select select1=new Select(birthDay);
        List<WebElement> daysOptions=select1.getOptions();
        select1.selectByVisibleText("1");

        WebElement year=driver.findElement(By.xpath("//select[@id='year']"));
        Select select2=new Select(year);
        List<WebElement> yearOptions=select2.getOptions();
        select2.selectByValue("1994");

        WebElement gender=driver.findElement(By.xpath("//input[@value='2']"));
        gender.click();
        WebElement signUp=driver.findElement(By.xpath("//button[@name='websubmit']"));
        signUp.click();
        Thread.sleep(2000);
        WebElement popUp=driver.findElement(By.xpath("//img[@src='https://static.xx.fbcdn.net/rsrc.php/v3/y2/r/__geKiQnSG-.png']"));
        popUp.click();

    }
}

