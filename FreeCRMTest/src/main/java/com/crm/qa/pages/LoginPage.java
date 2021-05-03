package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement login;
	
	@FindBy(linkText = "Sign Up")
	WebElement signup;
	
	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement crmImage;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCrmImage() {
		return crmImage.isDisplayed();
	}
	
	public HomePage login(String name, String pass) {
		username.sendKeys(name);
		password.sendKeys(pass);
		login.click();
		
		return new HomePage();
	}
}
