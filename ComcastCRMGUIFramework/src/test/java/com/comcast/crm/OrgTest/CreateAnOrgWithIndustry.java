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
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.WebDriverUtility.JavaUtility;

public class CreateAnOrgWithIndustry {

	public static void main(String[] args) throws Exception {
		//GetPhysicalFileLocation
		FileInputStream fisobj=new FileInputStream("./ConfigarationAppdata/commondata.properties");
	    Properties pobj=new Properties();
	    pobj.load(fisobj);
	    
		//loading all the keyvalues from the property file
		String Browser=pobj.getProperty("browser");
		
		String URL=pobj.getProperty("url");
		
		
		String Username=pobj.getProperty("username");
		
		
		String Password=pobj.getProperty("password");
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
				
				FileInputStream Excelobj=new FileInputStream("./TestScriptData/TestScriptData.xlsx");
				
				Workbook wb=WorkbookFactory.create(Excelobj);
				
			Sheet sh=wb.getSheet("org");

			Row row=sh.getRow(4);
			
			//Concatnating with the data along with the random number

			String orgname=row.getCell(2).toString()+randomint;
			String industry=row.getCell(3).toString();
			String Type=row.getCell(4).toString();
			
			
				
				
				
				
				
				//Login
				driver.get(URL);
				
				driver.findElement(By.name("user_name")).sendKeys(Username);
				
				driver.findElement(By.name("user_password")).sendKeys(Password);
				
				driver.findElement(By.id("submitButton")).click();
				
			//click on Organizations Tab
				
				driver.findElement(By.xpath("(//a[contains(text(),'Organizations')])[1]")).click();
				
				//click on  + button
				
				driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
				//Enter the Details
				
				driver.findElement(By.name("accountname")).sendKeys(orgname);
				Thread.sleep(3000);
				
				//Select teh value from the Industry DropDown
			WebElement industryDropDown=	driver.findElement(By.name("industry"));
				Select sel1=new Select(industryDropDown);
				sel1.selectByVisibleText(industry);
				
				System.out.println(industry + "The value from industry DropDown is been Selected");
				
				//Select the value from the Type DropDown
				WebElement type=driver.findElement(By.name("accounttype"));
				Select sel2=new Select(type);
				sel2.selectByVisibleText(Type);
				System.out.println(Type + "The Type DropDown is been Choosen ");
				
				
				//click on save button.
				driver.findElement(By.xpath("(//input[@accesskey=\"S\"])[2]")).click();
				
				
				Thread.sleep(3000);
				
				
				System.out.println("User Created Sucessfully");
				
				//Verify the Header messsage Expected Result
				
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
				
				
				//Verify Whether the Selected DropDown is correct or not as per the Expected Result
				
	String VerifyIndustryDropdown=			driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();
		if(VerifyIndustryDropdown.contains(industry))
		{
			System.out.println(industry  +"The Verify Industry DropDown is selected Sucessfully");
		}
		else
		{
			System.out.println("The Verify  Industry DropDown is not Selected Properly");
			
		}
		
		//verify the Type
		
		String VerifyTypeDropDown=driver.findElement(By.xpath("//span[@id='dtlview_Type']")).getText();
		
		if(VerifyTypeDropDown.contains(Type))
		{
			System.out.println("The Verify Type DropDown is Selected");
		}
		else
		{
			System.out.println("The verify Type Dropdown is not Selected Properly");
		}
	
	
	
	
	
	
	
	
	driver.quit();


	}

}
