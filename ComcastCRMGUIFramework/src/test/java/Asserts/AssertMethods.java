package Asserts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertMethods {
	@Test
	public void homepageTest()
	
	{
		SoftAssert assertobj=new SoftAssert();
		System.out.println("Test1 starts");
		System.out.println("Step1");
		System.out.println("Step2");
		assertobj.assertEquals("Home", "Home-Page");
		System.out.println("Step3");
		assertobj.assertEquals("Home-CRM","Home-CRM");
         assertobj.assertAll();
		System.out.println("Step4");
		
		
	
	
	}
	@Test
	public void verifylogohomepageTest()
	{
		System.out.println("Test 2 Starts");
		SoftAssert assertobj=new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
		assertobj.assertTrue(true);
		System.out.println("Step3");
		Assert.assertEquals("Home-CRM","Home-CRM");
		System.out.println("Step4");
	}


}
