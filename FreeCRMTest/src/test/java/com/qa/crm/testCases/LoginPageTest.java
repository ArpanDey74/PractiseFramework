package com.qa.crm.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void Setup() {
		initialization();
		loginPage = new LoginPage(); 
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String titleString = loginPage.validatePageTitle();
		Assert.assertEquals(titleString, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority = 2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateCrmImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void validateLogin() {
	 homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
