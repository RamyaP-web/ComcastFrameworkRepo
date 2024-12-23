package com.comcast.crm.contactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.fileUtility.Excel_Utility;
import com.comcast.crm.generic.fileUtility.FileUtility;

public class createContactWithOrgTest {

	public static void main(String[] args) throws Exception {
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

			String orgname=exobj.getDataFromExcel("org", 1, 2)+randomint;
			
	//		String ContactLastname=row.getCell(3).toString()+randomint;

				//Login
			
			driver.get(URL);
			
			driver.findElement(By.name("user_name")).sendKeys(Username);
			
			driver.findElement(By.name("user_password")).sendKeys(Password);
			
			driver.findElement(By.id("submitButton")).click();
			
			//As per the Pre Condition Create an Org
			
			driver.findElement(By.xpath("(//a[contains(text(),'Organizations')])[1]")).click();
			
			//click on  + button
			
			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
			//Enter the Details
			
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			Thread.sleep(3000);
			//click on Send Button
			
			driver.findElement(By.xpath("(//input[@accesskey=\"S\"])[2]")).click();
			
			
			Thread.sleep(3000);
			
			
			System.out.println("User Created Sucessfully");
			
			String HeaderInfo=		driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(HeaderInfo.contains(orgname))
			{
			System.out.println(orgname + "is created ==========");	
				
			}
			else
			{
			System.out.println(orgname + "is not Created============== and its failed");	
				
			}
			/*
			 * //click on Contacts Tab
			 * 
			 * driver.findElement(By.linkText("Contacts")).click();
			 * 
			 * //click on + button
			 * 
			 * driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"
			 * )).click(); //Enter the Details
			 * 
			 * // driver.findElement(By.name("lastname")).sendKeys(ContactLastname);
			 * //Thread.sleep(3000);
			 * 
			 * //click on Orgnazation select window driver.findElement(By.xpath(
			 * "(//img[@src='themes/softed/images/select.gif'])[1]")).click();
			 * 
			 * //Switch to CHild Window
			 * 
			 * Set<String> set=driver.getWindowHandles(); Iterator<String>it=set.iterator();
			 * 
			 * while(it.hasNext()) { String WindowId=it.next();
			 * driver.switchTo().window(WindowId);
			 * 
			 * 
			 * 
			 * String actualUrl=driver.getCurrentUrl();
			 * if(actualUrl.contains("module=Accounts")) { break; } } //Perform The actions
			 * on a Child Window. driver.findElement(By.id("search_txt")).sendKeys(orgname);
			 * 
			 * driver.findElement(By.name("search")).click();
			 * 
			 * 
			 * Thread.sleep(5000);
			 * 
			 * driver.findElement(By.xpath("//a[@id='1']")).click();
			 * 
			 * Thread.sleep(3000); //Get the Control bAck to Parent Window.
			 * 
			 * Set<String> set1=driver.getWindowHandles();
			 * Iterator<String>it1=set1.iterator();
			 * 
			 * while(it1.hasNext()) { String WindowId=it1.next();
			 * driver.switchTo().window(WindowId);
			 * 
			 * 
			 * 
			 * String actualUrls=driver.getCurrentUrl();
			 * if(actualUrls.contains("module=Contacts")) { break; } } //Enter the Support
			 * Date driver.findElement(By.name("support_start_date")).clear(); //CAPTURING
			 * THE CURRENTDATE Date date=new Date(); SimpleDateFormat currDate=new
			 * SimpleDateFormat("yyyy-MM-dd"); String actdate=currDate.format(date);
			 * 
			 * //Enter the Captured Date Thread.sleep(3000);
			 * 
			 * driver.findElement(By.name("support_start_date")).sendKeys(actdate); ////
			 * //Enter the End Date
			 * 
			 * Thread.sleep(3000);
			 * 
			 * 
			 * 
			 * //capturing the next date after 30days Calendar cal=currDate.getCalendar();
			 * cal.add(Calendar.DAY_OF_MONTH,30); String
			 * endDate=currDate.format(cal.getTime());
			 * 
			 * 
			 * driver.findElement(By.name("support_end_date")).clear();
			 * 
			 * 
			 * Thread.sleep(3000);
			 * 
			 * driver.findElement(By.name("support_end_date")).sendKeys(endDate);
			 * Thread.sleep(3000);
			 * 
			 * driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			 * 
			 * 
			 * 
			 * 
			 * //validation String ContactValidation=
			 * driver.findElement(By.xpath("//SPAN[@Class='dvHeaderText']")).getText();
			 * 
			 * if(ContactValidation.contains(ContactLastname)) {
			 * System.out.println("The LAstNAme testCAses is been VALIDATED"); }
			 * //Validation Of DAte
			 * 
			 * String
			 * ValidateDate=driver.findElement(By.xpath("(//td[@class='dvtCellInfo'])[23]"))
			 * .getText(); if(ValidateDate.contains(actdate)) { System.out.println(actdate
			 * +"The Start Date is been Validated"); } else { System.out.println(actdate
			 * +"The Start Date is not Being VAlidated");
			 * 
			 * } //validate the Support Date String
			 * ValidateEndDate=driver.findElement(By.xpath(
			 * "(//td[@class='dvtCellInfo'])[25]")).getText();
			 * if(ValidateEndDate.contains(endDate)) { System.out.println(endDate
			 * +" The EndDate is been Validated Sucesasfully"); } else {
			 * System.out.println(endDate +
			 * " The End DAte id not Been  Validated Sucessfully"); } String
			 * ValidateContactLastName=driver.findElement(By.id("mouseArea_Last Name")).
			 * getText(); // if(ValidateContactLastName.contains(ContactLastname)) {
			 * 
			 * }
			 */
			driver.quit();
				
				

	}

}
