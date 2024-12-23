package ExtentReports;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ScreenShot.TakeScreenShot;

public class SampleReportTest {
	ExtentReports report=new ExtentReports();
	@BeforeSuite
	public void configBeforeSuiteReports()
	{
		//spark report confog
				ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
				spark.config().setDocumentTitle("CRM Test Suite Results");//Title of  the Generated Report
				spark.config().setReportName("CRM Report");//ReportName
				spark.config().setTheme(Theme.DARK);//Theme of the Report
				
				//Add envi information and create Test
				
				report.attachReporter(spark);
				report.setSystemInfo("OS", "Windows 10");
				report.setSystemInfo("Browser", "Chrome-100");
	}
	
	
	
	@AfterSuite
	public void configAfterSuiteReports()
	{
		report.flush();
	}
	
	
	
	
	
	
	
	@Test
	public void cretecontact()
	{
		
	ExtentTest test=report.createTest("createContactTest");
		
	test.log(Status.INFO,"Login to the app");
	test.log(Status.INFO,"Navigate to Contact Page");
	test.log(Status.INFO,"Create a Contact");
	if("HDFC".equals("HDFC"))
	{
		test.log(Status.PASS,"contact is created");	
	}
	else
	{
		test.log(Status.FAIL,"Contact is failed");
	}

	System.out.println("Logout the app");
	}
	
	
	@Test
	public void CreateTestcasewithOrg()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
	String  src_of_file=	ts.getScreenshotAs(OutputType.BASE64);
	
		
		
		
		ExtentTest test=	report.createTest("createTestcasewithOrg");
		
		test.log(Status.INFO,"Login to the app");
		test.log(Status.INFO,"navigate to Org Page");
		test.log(Status.INFO,"Create a Organization");
		test.log(Status.INFO,"Navigate to Contact Page");
		test.log(Status.INFO,"Create a Contact");
		if("HDFC".equals("HfDC"))
		{
			test.log(Status.PASS,"contact is created");	
		}
		else
		{
			test.addScreenCaptureFromBase64String(src_of_file, "ErrorFile");
			
			
		}

		System.out.println("Logout the app");
	}
	
	
	@Test
	public void CreateContactWithPhoneNumber()
	{
		ExtentTest test=	report.createTest("CreateContactWithPhoneNumber");
		
		test.log(Status.INFO,"Login to the app");
		test.log(Status.INFO,"Navigate to Contact Page");
		test.log(Status.INFO,"Create a Contact with phone Number");
		if("HDFC".equals("HDFC"))
		{
			test.log(Status.PASS,"contact is created");	
		}
		else
		{
			test.log(Status.FAIL,"Contact is failed");
		}

		System.out.println("Logout the app");
	}

}
