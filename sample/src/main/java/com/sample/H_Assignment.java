package com.sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class H_Assignment {
	WebDriver driver = null;

	@BeforeTest
	public void initBrowser() {
		System.setProperty(com.utils.Browser_constants.CHROME_DRIVER_CLASS, com.utils.Browser_constants.CHROME_DRIVER_EXE_PATH);
		driver = new ChromeDriver();
		driver.get("https://www.hashtag-ca.com/careers/apply?jobCode=QAE001");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void verifyData() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,1400)");

		WebElement name = driver.findElement(By.xpath("//input[@placeholder=\"Enter your name\"]"));
		name.sendKeys("Swetha");
		
		WebElement email = driver.findElement(By.xpath("//div//input[@type=\"email\"]"));
		email.sendKeys("favemaj415@lukaat.com");
		
		WebElement phone = driver.findElement(By.xpath("//div//input[@type=\"number\"][@placeholder=\"Enter your phone\"]"));
		phone.sendKeys("9876543210");
		
		//WebElement notice_period = driver.findElement(By.name("notice_time"));
		//notice_period.sendKeys("30");
		
		//WebElement experience = driver.findElement(By.name("experience"));
		//experience.sendKeys("0");
		
		WebElement open = driver.findElement(By.id("inputFile"));
		open.sendKeys("C:\\Selenium\\Work space\\Resume\\Swetha.pdf");
				
		WebElement description = driver.findElement(By.xpath("//div//*[@placeholder=\"Briefly Describe Yourself\"]"));
		description.sendKeys("I would say that I am creative , hard-working and detail oriented. I think that I am an analytical, and responsible person");
		
		WebElement apply = driver.findElement(By.xpath("//button[text()='APPLY NOW']"));
		apply.click();
	}
		
	@AfterTest
	public void closeBrowser() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
