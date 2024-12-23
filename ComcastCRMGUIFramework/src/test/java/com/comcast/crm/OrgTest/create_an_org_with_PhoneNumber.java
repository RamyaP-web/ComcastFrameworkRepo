package com.comcast.crm.OrgTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.WebDriverUtility.JavaUtility;

public class create_an_org_with_PhoneNumber {

	public static void main(String[] args) throws Exception {
//Get the Physical File
		FileInputStream fisobj=new FileInputStream("./ConfigarationAppdata/commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fisobj);
		//LOAD ALL THE OBJECTS FROM PROPERTY FILE TO JAVA
		String Browser=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String UserName=pobj.getProperty("username");
		String Password=pobj.getProperty("password");
		
		//Generate a Random Number For Creating an Organization Name

		JavaUtility jobj=new JavaUtility();
		int randomint=jobj.getRandomNumber();
		
		
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
		
		Sheet sh=wb.getSheet("org");
		
		Row row=sh.getRow(7);
		
		String orgname=row.getCell(2).toString()+randomint;
		String PhoneNumber=row.getCell(3).toString();
		
		//Login to the app
		
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		
		driver.findElement(By.name("user_password")).sendKeys(Password);
		
		driver.findElement(By.id("submitButton")).click();
		
	//click on Organizations Tab
		
		driver.findElement(By.xpath("(//a[contains(text(),'Organizations')])[1]")).click();
		
		//click on  + button
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		//Enter the Details
		
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		//Thread.sleep(3000);
		
		//Enter the  phonenumber in the Excel
WebElement data=	driver.findElement(By.xpath("//input[@id='phone']"));

data.sendKeys(PhoneNumber);
//click on save button.
driver.findElement(By.xpath("(//input[@accesskey=\"S\"])[2]")).click();


Thread.sleep(3000);


System.out.println("User Created Sucessfully");



//VALIDATION-----------------------------//
String HeaderInfo=		driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if(HeaderInfo.contains(orgname))
{
System.out.println(orgname + "is created ==========");	
	
}
else
{
System.out.println(orgname + "is not Created============== and its failed");	
	
}
	//Verify the OrgName info
String VerifyOrgnameinfo=driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
	
	if(VerifyOrgnameinfo.contains(orgname))
	{
		System.out.println(orgname + "It is same as the given data");
	}
	else
	{
		System.out.println("failed to verify the orgname ");
	}
	
	//VERIFY THE PHONE NUMBER
	
	String VerifyPhoneNumber=driver.findElement(By.id("dtlview_Phone")).getText();
	if(VerifyPhoneNumber.equals(PhoneNumber))
	{
		System.out.println(PhoneNumber+ " The Number is Validated");
	}
	else
	{
		System.out.println("The Number isnt VAlidated");
	}
	
	
	driver.quit();





				
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
