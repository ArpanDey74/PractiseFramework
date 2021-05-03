package com.qa.crm.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage =  new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test(priority = 1)
	public void HomePageTitleTest() {
		String titleString = homePage.validateHomePageTitle();
		Assert.assertEquals(titleString, "CRMPRO");
	}
	
	@Test(priority = 2)
	public void crmUserNameTest() {		
		testUtil.switchToFrame();
		boolean flag = homePage.validateUserName();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void VerifyContactLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickonContactsLink();		
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
