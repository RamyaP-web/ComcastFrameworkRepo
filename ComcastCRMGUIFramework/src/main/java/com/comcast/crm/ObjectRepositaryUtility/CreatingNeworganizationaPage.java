package com.comcast.crm.ObjectRepositaryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNeworganizationaPage {
	WebDriver driver;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement ClickonCreatelink;
	
	@FindBy(name="accountname")
	private WebElement Orgname;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveButton;
	
	@FindBy(name="industry")
	private WebElement industryDropDrown;
	
	@FindBy(id="phone")
	private WebElement phonenumber;
	
	
	
	public CreatingNeworganizationaPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrgname() {
		return Orgname;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	public WebElement getIndustryDropDrown() {
		return industryDropDrown;
	}

	public WebElement getClickonCreatelink() {
		return ClickonCreatelink;
	}
	
	

	public WebElement getPhonenumber() {
		return phonenumber;
	}

	public void CreateOrg(String orgname)
	{
		Orgname.sendKeys(orgname);
	SaveButton.click();
	}
	public void CreateOrgWithInd(String orgname,String Phonenumber,String pin_industry)
	{
		Orgname.sendKeys(orgname);
		phonenumber.sendKeys(Phonenumber);
		Select sel1=new Select(industryDropDrown);
		sel1.selectByVisibleText(pin_industry);
		SaveButton.click();
	}
	public void createorgwithPhonenumber(String orgname,String Phonenumber)
	{
		Orgname.sendKeys(orgname);
		phonenumber.sendKeys(Phonenumber);
		SaveButton.click();
	}

}

