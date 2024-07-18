package com.thetestingacademy.ex_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Loginvwo {

    // [Assignment] - Automating the Login Page of VWO.com
//Fetch the locators - https://app.vwo.com/
//Create a Maven project and add TestNG.
//Add the Allure Report (Allure TestNG)
//Automate the two Test cases of VWO.com
//Valid Username and Valid Password
//Verify name on dashboard page.
//Run them and share results.
//Push the code to github.com
//Git repo - ReadMe.md a Screen shot of allure.//
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
      options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("vwo@1secmail.com");
       driver.findElement(By.name("password")).sendKeys("Vwo@1234");
       // driver.findElement(By.name("username")).sendKeys("vwo1@1secmail.com");
       // driver.findElement(By.name("password")).sendKeys("Vwo1@1234");

        driver.findElement(By.id("js-login-btn")).click();

        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        System.out.println(driver.getTitle());
        driver.close();

    }
}
