package com.comcast.crm.contactTest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

public class CreateATestCaseWithDate {
	

	public static void main(String[] args) throws Exception {
	
		FileInputStream fisobj=new FileInputStream("./ConfigarationAppdata/commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fisobj);
		//LOAD ALL THE OBJECTS FROM PROPERTY FILE TO JAVA
		String Browser=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String UserName=pobj.getProperty("username");
		String Password=pobj.getProperty("password");
		
		//Generate a Random Number For Creating an Last Name

		Random random=new Random();
		int randomint=random.nextInt(1000);
		
		//Browser using PolyMorphism
		
		WebDriver driver=null;
		
		if(Browser.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (Browser.equals("Firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		else if(Browser.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		//---------------------------------------//
		
		//ImplictWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		//Read the Data from an Excel Sheet

		FileInputStream ExcelObj=new FileInputStream("./TestScriptData/TestScriptData.xlsx");
		
		Workbook wb=WorkbookFactory.create(ExcelObj);
		
		Sheet sh=wb.getSheet("Contact");
		
		Row row=sh.getRow(4);
		
		String LastName=row.getCell(2).toString()+randomint;

		
		//Login to the app
		
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		
		driver.findElement(By.name("user_password")).sendKeys(Password);
		
		driver.findElement(By.id("submitButton")).click();
		
	//click on Contacts  Tab
		
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on  + button
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//Enter the Details
		
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		//Thread.sleep(3000);
		
	//Enter the Support Date
	driver.findElement(By.name("support_start_date")).clear();
	//CAPTURING THE CURRENTDATE
	Date date=new Date();
	SimpleDateFormat currDate=new SimpleDateFormat("yyyy-MM-dd");
	String actdate=currDate.format(date);
	
	//Enter the Captured Date
	Thread.sleep(3000);
		
	driver.findElement(By.name("support_start_date")).sendKeys(actdate);
////		//Enter the End Date
	
	Thread.sleep(3000);
		
  
      
      //capturing the next date after 30days
      Calendar cal=currDate.getCalendar();
      cal.add(Calendar.DAY_OF_MONTH,30);
      String endDate=currDate.format(cal.getTime());
      
      
      driver.findElement(By.name("support_end_date")).clear();
      
      
  	Thread.sleep(3000);
      
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		Thread.sleep(3000);

driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		
		
		
		//validation
	String ContactValidation=	driver.findElement(By.xpath("//SPAN[@Class='dvHeaderText']")).getText();
		
		if(ContactValidation.contains(LastName)) {
			System.out.println("The LAstNAme testCAses is been VALIDATED");
		}
		//Validation Of DAte
		
		String ValidateDate=driver.findElement(By.xpath("(//td[@class='dvtCellInfo'])[23]")).getText();
		if(ValidateDate.contains(actdate))
		{
			System.out.println(actdate +"The Start Date is been Validated");
		}
		else
		{
			System.out.println(actdate +"The Start Date is not Being VAlidated");
			
		}
		//validate the Support Date
String ValidateEndDate=driver.findElement(By.xpath("(//td[@class='dvtCellInfo'])[25]")).getText();
if(ValidateEndDate.contains(endDate))
{
	System.out.println(endDate +" The EndDate is been Validated Sucesasfully");
}
else
{
	System.out.println(endDate + " The End DAte id not Been  Validated Sucessfully");
}
		
		driver.quit();
	}
}
		

	



