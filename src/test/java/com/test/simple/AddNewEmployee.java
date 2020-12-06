package com.test.simple;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AddNewEmployee {
	
	WebDriver driver;
	WebDriverWait Wait;
	
	@BeforeMethod
	public void browserSetup(){
		
		System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Wait = new WebDriverWait(driver,50);
			}
	
	/*@Test(priority=1)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Cest verify application logo is present")
	@Story("Test verify login works properly")
	public void LoginIntoapplication(){
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertEquals(driver.findElement(By.id("welcome")).getText(),"Welcome Paul");
	}*/
	
	@Test(priority=1)
	public void AddNewEmployee(){
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']/b")).click();
		//driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.name("firstName")).click();
		driver.findElement(By.name("firstName")).sendKeys("Interview");
		driver.findElement(By.name("middleName")).click();
		driver.findElement(By.name("middleName")).sendKeys("T");
		driver.findElement(By.name("lastName")).click();
		driver.findElement(By.name("lastName")).sendKeys("Code");
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.name("user_name")).click();
		driver.findElement(By.name("user_name")).sendKeys("InterviewCode");
		driver.findElement(By.name("user_password")).click();
		driver.findElement(By.name("user_password")).sendKeys("Admin@12");
		driver.findElement(By.name("re_password")).click();
		driver.findElement(By.name("re_password")).sendKeys("Admin@12");
		driver.findElement(By.id("btnSave")).click();
		Assert.assertEquals(driver.findElement(By.id("profile-pic")).getText(),"InterviewCode");
		
		
	}
	
	
	
}
