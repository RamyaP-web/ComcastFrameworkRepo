package com.comcast.crm.ObjectRepositaryUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Creating a seperate Class
public class HomePage {
	public WebDriver driver;
	Actions action;
	

	
	
	//Rule2:- Object Identificateion
	@FindBy(xpath="(//a[contains(text(),'Organizations')])[1]")
	private WebElement orgname;
	
	@FindBy(linkText="Contacts")
	private WebElement  contacts;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaigns;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(xpath= "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOut;
	
	
	
	//Rule 3:- (Object Initialization ) Creating an Constructor and using Page Factory
	public HomePage(WebDriver driver)
	{
//this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	//Rule 4:- Object Encapsulation
	public WebElement getOrgname() {
		return orgname;
	}
	
	
	
	public WebElement getContacts() {
		return contacts;
		
	}
	

	public WebElement getCampaigns() {
		return campaigns;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOut() {
		return SignOut;
	}

	//Rule 5:- Object Utilization
	/*
	 * public void ClickOnOrganizationLink() {
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 * orgname.click(); }
	 */
	//dont create a business library when we have  a single operation to 
	//be performed.
	public void NavigateToCampaignPage()
	{
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action=new Actions(driver);
		action.moveToElement(moreLink).build().perform();
		campaigns.click();
		
		
		
	}
	

//	public void Signout()
//	{
//		new Actions(driver);
//		System.out.println("logging out");
//		action.moveToElement(adminImg).build().perform();
//		action.moveToElement(SignOut).build().perform();
//		SignOut.click();
//	}
	
	
	
	
	

}
