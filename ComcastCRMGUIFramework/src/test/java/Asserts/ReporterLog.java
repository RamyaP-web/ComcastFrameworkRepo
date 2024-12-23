package Asserts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReporterLog 
{
	@Test
	public void Reports()
	{
	
	SoftAssert assertobj=new SoftAssert();
	Reporter.log("Test1 starts");
	Reporter.log("Step1",true);
	Reporter.log("Step2");
	assertobj.assertEquals("Home", "Home");
	Reporter.log("Step3");
	assertobj.assertEquals("Home-CRM","Home-CRM");
     assertobj.assertAll();
	Reporter.log("Step4");
	

}
@Test
public void verifylogohomepageTest()
{
	Reporter.log("Test 2 Starts");
	SoftAssert assertobj=new SoftAssert();
	Reporter.log("Step1");
	Reporter.log("Step2");
	assertobj.assertTrue(true);
	Reporter.log("Step3");
	Assert.assertEquals("Home-CRM","Home-CRM");
	Reporter.log("Step4");
}
}


