package com.demo.UI.Automation.rough;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Selenium script for split method in java
 */
public class Demo2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//a[normalize-space()='Forgot your password?']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Reset Login']")).click();
        String resetPwdText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
        String[] passWdArray = resetPwdText.split("'");
        String password = passWdArray[1].split("'")[0];
        System.out.println(password);
        driver.quit();
		
		
	}

}
