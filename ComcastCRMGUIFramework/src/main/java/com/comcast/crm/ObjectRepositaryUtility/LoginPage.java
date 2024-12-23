package com.comcast.crm.ObjectRepositaryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
//Rule1:- create a Seperate Calss for all the pages
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	//Rule 2:-Object Creation
	
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
     @FindBy(id="submitbutton")
    //AutoHealing
	private	WebElement LoginButton;
	
	//Rule3 :-Object Initaialization
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	//Rule 4:- Object Encapsulation

	public WebElement getUsername() {
		return usernameEdit;
	}

	public WebElement getPassword() {
		return passwordEdit;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//Rule 5:- provide Action to business Libraries
//	(This code is specific to the Business)
	
	public void LoginToApp(String username,String password)
	{
		//driver.manage().window().maximize();
		
		usernameEdit.sendKeys(username);
	    passwordEdit.sendKeys(password);
	      LoginButton.click();
	}
	

	
	
	
	
	
	
	
	

}
