package com.test.simple;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.simple.LogUtil;
import org.testng.annotations.*;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import java.io.ByteArrayInputStream;


public class LoginPageTest{

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
	
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Checking the title of the loaded page.")
	@Story("Test verify expected page title is present")
	public void validateLoginPageTitle(){
		
		String title = driver.getTitle();
        assertEquals(title,"OrangeHRM");
        LogUtil.log("Test Passed. Expected: OrangeHRM | Actual: "+title);
        System.out.println("Page Loaded");
        Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));       
 }
	
	@Test(priority=2)
	@Severity(SeverityLevel.NORMAL)
	@Description("Cest verify application logo is present")
	@Story("Test verify application logo is present")
	public void validateOrnageHrmLogo(){
		driver.findElement(By.id("divLogo")).isDisplayed();
	}
		
	@Test(priority=3)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Cest verify application logo is present")
	@Story("Test verify login works properly")
	public void LoginIntoapplication(){
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertEquals(driver.findElement(By.id("welcome")).getText(),"Welcome raj");
	}
	
	
}
