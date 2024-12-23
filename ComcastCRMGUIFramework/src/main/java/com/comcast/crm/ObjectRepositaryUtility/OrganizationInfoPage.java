package com.comcast.crm.ObjectRepositaryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	WebDriver driver;
	
	@FindBy(className="dvHeaderText")
private 	WebElement header_info;
	
	public OrganizationInfoPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getHeader_info() {
		return header_info;
	}
	
	
	
	

}
