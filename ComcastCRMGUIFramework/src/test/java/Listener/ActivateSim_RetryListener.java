package Listener;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.BaseClass.baseclass;

public class ActivateSim_RetryListener extends baseclass {
	@Test(retryAnalyzer = com.comcast.crm.ListenerUtility.Retry_Listener.class)
	public void ActivateSim()
	{
		System.out.println("execute CreateInvoiceTest");
		
	String Title=	driver.getTitle();
	Assert.assertEquals(Title, "Login");
	System.out.println(Title);
	System.out.println("Step-1");
	System.out.println("Step-2");
	System.out.println("Step-3");
	System.out.println("Step-4");
	}


}
