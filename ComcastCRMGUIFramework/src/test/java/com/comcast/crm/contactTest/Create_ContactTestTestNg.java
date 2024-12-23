package com.comcast.crm.contactTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.BaseClass.baseclass;
import com.comcast.crm.ObjectRepositaryUtility.createContactPage;

public class Create_ContactTestTestNg extends baseclass {
	@Test(groups="SmokeTest")
	public void CreateContact() throws Exception
	{
	
		//step2:-((Navigate  to Contact Module)
	System.out.println("this is test method");
	Thread.sleep(4000);
	
		home.getContacts().click();
	
		//step3:- Click on create COntact Button
		createContactPage ccp=new createContactPage(driver);
		ccp.getClickonNewContact().click();
		String lastname=excel.getDataFromExcel("Contact", 1, 2)+java.getRandomNumber();
		
		//STEP4:- ENTER ALL THE DEATILS IN THE CONTACT PAGE:-
		ccp.createContact(lastname);
String ContactValidation=	ccp.getHeaderMsg().getText();
		boolean status=ContactValidation.contains(lastname);
		Assert.assertEquals(status, true);
		
		String lastNameValidation=ccp.getLastmessage().getText();
		boolean ststus1=lastNameValidation.contains(lastname);
		Assert.assertEquals(ststus1, true);
		
	
	}
@Test(groups="Regression")
	public void CreateContactWithSupportDateTest() throws Exception
	{
		//Read data from the excel file
		String lastname=excel.getDataFromExcel("Contact", 1, 2)+java.getRandomNumber();
		//Navigate to Contact Module
		//Click on create Contact Button
		createContactPage ccp=new createContactPage(driver);
		ccp.getClickonNewContact().click();
		
		//enter all the details and create a new Contact
		String enddate=java.getSystemDateYYYYDDMM();
		String startdate=java.getDateAfterDays("YYYYMMDD", 30);
		ccp.createcontactwithSupportDate(lastname, startdate, enddate);
		
		
	}
	
//	@Test
	public void CreateContactwithOrg()
	{
	}

}
