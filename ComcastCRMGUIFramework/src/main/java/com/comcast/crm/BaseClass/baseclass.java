package com.comcast.crm.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.ObjectRepositaryUtility.CreatingNeworganizationaPage;
import com.comcast.crm.ObjectRepositaryUtility.HomePage;
import com.comcast.crm.ObjectRepositaryUtility.LoginPage;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.fileUtility.Excel_Utility;
import com.comcast.crm.generic.fileUtility.FileUtility;

public class baseclass {
	
	public WebDriver driver;
	
	public FileUtility flib=new FileUtility();
	public Excel_Utility excel=new Excel_Utility();
	public JavaUtility java=new JavaUtility();
	public HomePage home ;
	public CreatingNeworganizationaPage createorg;
	
	public static WebDriver sdriver;

	
	
	
	@BeforeSuite(groups={"SmokeTest","Regression"})
	public void ConfigBeforeSuite()
	{
		System.out.println("Connect to Database");
		

		}
	
	
	@BeforeClass(groups={"SmokeTest","Regression"})
	public void ConfigBeforeClass() throws Throwable
	{
		System.out.println("Launch A browser");
		home=new HomePage(driver);
		
		String Browser=flib.getdatafrompropertyfile("browser");
		
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
	    sdriver=driver;
			
		}

	
	@BeforeMethod(groups={"SmokeTest","Regression"})
	public void ConfigBeforeMethod() throws Exception
	{
		LoginPage login=new LoginPage(driver);
		System.out.println(driver);

		String url=flib.getdatafrompropertyfile("url");
		driver.get(url);
		String un=flib.getdatafrompropertyfile("username");
		String pwd=flib.getdatafrompropertyfile("password");
		login.LoginToApp(un, pwd);
		 home=new HomePage(driver);
		 createorg= new CreatingNeworganizationaPage(driver);
		
	}

	
	@AfterMethod(groups={"SmokeTest","Regression"})
	public void ConfigAfterMethod() throws InterruptedException
	{
		 home=new HomePage(driver);
		System.out.println("user loggedout   Sucessfully");
		Thread.sleep(5000);
	Actions act=new Actions(driver);
	act.moveToElement(home.getAdminImg()).click().perform();
	Thread.sleep(5000);
         act.moveToElement(home.getSignOut()).click().perform();
	
	
	}
	@AfterClass(groups={"SmokeTest","Regression"})
	public void ConfigAfterClass()
	{
		System.out.println("cLOSE THE BROWSER");
		driver.quit();
	}
	@AfterSuite(groups={"SmokeTest","Regression"})
	public void AfterSuite()
	{
		System.out.println("Close db , rEPORT baCKUP");
		
	}

	
	}
	
	


