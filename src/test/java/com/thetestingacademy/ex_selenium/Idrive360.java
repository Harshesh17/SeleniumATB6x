package com.thetestingacademy.ex_selenium;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static junit.framework.Assert.assertEquals;

public class Idrive360 {

    @Test
    @Description("Login with valid credentials")

    public void login() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.idrive360.com/enterprise/login");
        driver.manage().window().maximize();
        System.out.println("Landing page title: " + driver.getTitle());
        System.out.println("Landing page current url: " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(), "IDrive® 360 - Sign in to your account");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.idrive360.com/enterprise/login");
        driver.findElement(By.name("username")).sendKeys("augtest_040823@idrive.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.xpath("//div[@class='id-check-container']")).click();
        driver.findElement(By.xpath("//button[@class='id-btn id-info-btn-frm']")).click();
        Thread.sleep(20000);
        WebElement message = driver.findElement(By.xpath("//span[contains(text(),'Your free trial has expired')]"));
        assertEquals(message.getText(), "Your free trial has expired");
        assertEquals(driver.getCurrentUrl(), "https://www.idrive360.com/enterprise/account?upgradenow=true");
        driver.close();

        //    Assert.assertEquals(driver.findElement(By.className("id-card-title")).getText(), "Your free trial has expired");

    }
}