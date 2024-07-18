package com.thetestingacademy.ex_selenium;


import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class katalonLogin {
@Test
@Description("Login with valid credentials")
    public void loginWithValid() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        System.out.println("Landing page title: "+driver.getTitle());
        System.out.println("Landing page current url: "+driver.getCurrentUrl());
    Assert.assertEquals(driver.getTitle() ,"CURA Healthcare Service" );
    Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
    WebElement appointmentBtn = driver.findElement(By.xpath("//a[text()='Make Appointment']"));
    System.out.println("Appointment button text is: "+appointmentBtn.getText());
    Assert.assertEquals(appointmentBtn.getText(),"Make Appointment");
    appointmentBtn.click();

    driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
    System.out.println("Home page URL: "+driver.getCurrentUrl());
    Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
    Thread.sleep(2000);
    WebElement dropdown = driver.findElement(By.id("combo_facility"));
    dropdown.findElement(By.xpath("(//select[@id='combo_facility'])[1]")).click();
    WebElement checkbox = driver.findElement(By.id("chk_hospotal_readmission"));
    checkbox.click();

    List<WebElement> radioButtons = driver.findElements(By.name("programs"));
    radioButtons.get(0).click(); // Index 1 corresponds to the second radio button
    Thread.sleep(2000);
    driver.findElement(By.id("txt_visit_date")).sendKeys("19/07/2024");
    Thread.sleep(2000);

    driver.findElement(By.id("txt_comment")).sendKeys("Hi I want to book an appointment");
    Thread.sleep(2000);
    driver.findElement(By.id("btn-book-appointment")).click();
    driver.findElement(By.xpath("//a[@href='https://katalon-demo-cura.herokuapp.com/']")).click();
   // driver.findElement(By.linkText("Go to Homepage")).click();
    Thread.sleep(2000);
    driver.close();
    }
}
