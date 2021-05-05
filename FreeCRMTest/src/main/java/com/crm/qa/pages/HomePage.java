package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//td[contains(text(),'User: group automation')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	 public HomePage() {
		PageFactory.initElements(driver, this);
	}
	  

	public WebElement contactsNewLocator() {
		return driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickonContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickonDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TaskPage clickonTasksLink() {
		taskLink.click();
		return new TaskPage();
	}
	
	public void clickonNewContactsLink(){
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.ignoring(ElementClickInterceptedException.class);
		//wait.until(drv -> contactsNewLocator.isEnabled());
		
		
		
		/*
		 * Actions action = new Actions(driver);
		 * action.moveToElement(contactsNewLocator()).build().perform();
		 */
		 
		
		String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);"; 
		((JavascriptExecutor) driver).executeScript(strJavaScript, contactsLink); 
		
		
		newContactLink.click();
	}
	
}
