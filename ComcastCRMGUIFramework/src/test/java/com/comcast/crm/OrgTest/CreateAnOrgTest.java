package com.comcast.crm.OrgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.ObjectRepositaryUtility.CreatingNeworganizationaPage;
import com.comcast.crm.ObjectRepositaryUtility.HomePage;
import com.comcast.crm.ObjectRepositaryUtility.LoginPage;
import com.comcast.crm.ObjectRepositaryUtility.OrganizationInfoPage;
import com.comcast.crm.ObjectRepositaryUtility.OrganizationsPage;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.fileUtility.Excel_Utility;
import com.comcast.crm.generic.fileUtility.FileUtility;

public class CreateAnOrgTest 
{
	 public static void main(String[] args) throws Exception 
	 {
	
		 FileUtility fisobj=new FileUtility();

			//loading all the keyvalues from the property file
			String Browser=	fisobj.getdatafrompropertyfile("browser");
			
			String URL=fisobj.getdatafrompropertyfile("url");
			
			String Username=fisobj.getdatafrompropertyfile("username");
			String Password=fisobj.getdatafrompropertyfile("password");
		
		//using RAndom Class to create a different Orgzansiation Name each Time.
		JavaUtility jobj=new JavaUtility();
		int randomint=jobj.getRandomNumber();
		
		
		
		
		//using polymorphism concept in terms of browser
		
		WebDriver  driver=null;
		
		if(Browser.equals("chrome"))
			
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(Browser.equals("edge"))
		{
			driver=new EdgeDriver();
			
		}
		else
		{
			driver=new ChromeDriver();
			
		}
		
		//using Implicit Wait.
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Read TestScript DAta from Excel File
		
		Excel_Utility exobj=new Excel_Utility();
		//Concatnating with the data along with the random number
		String orgname=exobj.getDataFromExcel("org", 10, 2)+randomint;
	
//Login
driver.get(URL);
LoginPage login=new LoginPage(driver);
login.LoginToApp("admin","manager");


	//click on Organizations Tab

HomePage home=new HomePage(driver);

   home.getOrgname().click();

//click on + link

OrganizationsPage org=new OrganizationsPage(driver);
org.getCreateOrg().click();

//Enter all the Deatils in the Organizations Link
		
CreatingNeworganizationaPage create=new CreatingNeworganizationaPage(driver);
create.CreateOrg(orgname);

//Validate the data
OrganizationInfoPage validate=new OrganizationInfoPage(driver);
String Validate_Org_Name=validate.getHeader_info().getText();


if(Validate_Org_Name.contains(orgname))
{
	System.out.println(orgname + "The Header of the OrgName is Created and Validated Sucessfully");
}
else
{
	System.out.println("the Org Name is not Validated Sucessfully");
}
		
		
		
		
		

		driver.quit();
		
		
	}

}
