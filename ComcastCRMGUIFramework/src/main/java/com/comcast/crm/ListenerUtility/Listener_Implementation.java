package com.comcast.crm.ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.BaseClass.baseclass;

public class Listener_Implementation implements ITestListener,ISuiteListener
{
	public ExtentSparkReporter spark;
public static 	ExtentReports report=new ExtentReports();
public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report Configuration");
		//spark report confog
		
		spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");//Title of  the Generated Report
		spark.config().setReportName("CRM Report");//ReportName
		spark.config().setTheme(Theme.DARK);//Theme of the Report
		
		//Add envi information and create Test
		
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Browser", "Chrome-100");

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();
		System.out.println("Report BackUp");
	
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("======  " +result +result.getMethod().getMethodName() + " ====START====");
		
		 test=report.createTest(result.getMethod().getMethodName());
		 test.log(Status.INFO,result.getMethod().getMethodName() + "=====Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("======  " +result +result.getMethod().getMethodName() + " ====END====");
	test.log(Status.INFO,result +result.getMethod().getMethodName() + "Completed" );
	
	}

	@Override
	public void onTestFailure(ITestResult result)
	{

String testname=	result.getMethod().getMethodName() ;
TakesScreenshot ts=(TakesScreenshot)baseclass.sdriver;
String  src_of_file=	ts.getScreenshotAs(OutputType.BASE64);

String time=new Date().toString().replace(" ", "_").replace(":", "_");
test.addScreenCaptureFromBase64String(src_of_file, testname +" " + time);
test.log(Status.INFO,result +result.getMethod().getMethodName() + "Failed" );


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.INFO,result +result.getMethod().getMethodName() + "Skipped" );
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
