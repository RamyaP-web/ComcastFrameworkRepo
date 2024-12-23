package com.comcast.crm.ObjectRepositaryUtility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationsPage {
	WebDriver driver;
	
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	
	private WebElement createOrg;
	
	@FindBy(className="txtBox")
private WebElement searchOrgname;
	
	@FindBy(name="search_field")
	
	private WebElement SearchDropDown;
	
	@FindBy(name="submit")
	private WebElement Submit;
	
	
	
	public OrganizationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}


	public WebElement getCreateOrg()
	{
		return createOrg;
	}


	public WebElement getSearchOrgname() {
		return searchOrgname;
	}


	public WebElement getSearchDropDown() {
		return SearchDropDown;
	}


	public WebElement getSubmit() {
		return Submit;
	}
	
	public void Search(String search)
	{
		Select sel=new Select(SearchDropDown);
		sel.selectByVisibleText(search);
		
		
	}
	
	
	
	

	
	

}
