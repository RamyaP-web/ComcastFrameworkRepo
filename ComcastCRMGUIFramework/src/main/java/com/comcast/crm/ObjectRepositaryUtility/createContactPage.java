package com.comcast.crm.ObjectRepositaryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createContactPage {

WebDriver driver ;

@FindBy(xpath="//SPAN[@Class='dvHeaderText']")
private WebElement headerMsg;

@FindBy(xpath="//td[@id='mouseArea_Last Name']")
private WebElement lastmessage;

     @FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement ClickonNewContact;
     
	@FindBy(name = "lastname")
	private WebElement lastname ;
	
	@FindBy(name = "support_start_date")
		private WebElement startdate ;
	
	@FindBy(name = "support_end_date")
	private WebElement enddate ;
	
	

	@FindBy(id = "search_txt")
	private WebElement search_in_integrate;
	
	@FindBy(css = "input[name='search']")
	private WebElement searchbutton_in_integrate;
	
	@FindBy(id = "1")
	private WebElement select_Integrated_Org ;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement savebutton ;
	
	@FindBy(name = "salutationtype")
	private WebElement firstname ;
	

	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getLastname() {
		return lastname;
	}


	public WebElement getStartdate() {
		return startdate;
	}


	public WebElement getEnddate() {
		return enddate;
	}


	public WebElement getClickonNewContact() {
		return ClickonNewContact;
	}


	


	public WebElement getLastmessage() {
		return lastmessage;
	}


	public WebElement getHeaderMsg() {
		return headerMsg;
	}


	public WebElement getSearch_in_integrate() {
		return search_in_integrate;
	}


	public WebElement getSearchbutton_in_integrate() {
		return searchbutton_in_integrate;
	}


	public WebElement getSelect_Integrated_Org() {
		return select_Integrated_Org;
	}


	public WebElement getSavebutton() {
		return savebutton;
	}


	public WebElement getFirstname() {
		return firstname;
	}


	public createContactPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	public void createContact(String Lastname)
	{
	lastname.sendKeys(Lastname);
	savebutton.click();
	
	}
	
	public void createcontactwithSupportDate(String Lastname,String startDate,String endDate)
	{
		lastname.sendKeys(Lastname);
		startdate.sendKeys(startDate);
		enddate.sendKeys(endDate);
		savebutton.click();
		
		
		
	}
	
	}
	
	

	


