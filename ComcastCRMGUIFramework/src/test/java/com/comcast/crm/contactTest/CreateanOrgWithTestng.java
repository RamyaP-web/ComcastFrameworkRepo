package com.comcast.crm.contactTest;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.BaseClass.baseclass;

@Listeners
public class CreateanOrgWithTestng extends baseclass{
	@Test(groups="SmokeTest")
	public void createOrg() throws Exception {
		
		String orgname=excel.getDataFromExcel("org", 1, 2)+java.getRandomNumber();
		
		//navigate to Orgnazition link
	home.getOrgname().click();
	
	//click on + icon
	createorg.getClickonCreatelink().click();
	createorg.CreateOrg(orgname);
	}
	
	@Test(groups="Regression")
	public void createorgWithPhonenumber() throws Exception
	{
		String orgname=excel.getDataFromExcel("org", 7, 2)+java.getRandomNumber();
		String phonenumber=excel.getDataFromExcel("org", 7, 3)+java.getRandomNumber();
		
		//click on orgnazation link
		home.getOrgname().click();
		
		//click on + icon
		createorg.getClickonCreatelink().click();
		createorg.createorgwithPhonenumber(orgname, phonenumber);
		
		Thread.sleep(2000);
		String VerifyOrgnameinfo=driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
		
		if(VerifyOrgnameinfo.contains(orgname))
		{
			System.out.println(orgname + "It is same as the given data");
		}
		else
		{
			System.out.println("failed to verify the orgname ");
		}
		
		
	}
	@Test(groups="Regression")
	public void createorgwithIndustry() throws Throwable
	{
		String orgname=excel.getDataFromExcel("org", 7, 2)+java.getRandomNumber();
		String phonenumber=excel.getDataFromExcel("org", 7, 3)+java.getRandomNumber();
		String industry=excel.getDataFromExcel("org", 7, 4);
		
		
		//click on orgnazation link
		home.getOrgname().click();
		//click on + icon
		createorg.getClickonCreatelink().click();
		createorg.CreateOrgWithInd(orgname, phonenumber,industry);
		Thread.sleep(4000);
		String VerifyIndustryDropdown=			driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();
		if(VerifyIndustryDropdown.contains(industry))
		{
			System.out.println(industry  +"The Verify Industry DropDown is selected Sucessfully");
		}
		else
		{
			System.out.println("The Verify  Industry DropDown is not Selected Properly");
			
		}
	}

}
