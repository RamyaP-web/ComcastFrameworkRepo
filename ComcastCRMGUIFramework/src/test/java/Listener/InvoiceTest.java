package Listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.BaseClass.baseclass;



public class InvoiceTest extends baseclass{
	@Test
	public void CreateInvoiceTest()
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
	@Test
	public void CreateInvoicewithContactTest()
	{
		System.out.println("execute CreateInvoicewithContactTest");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
	
}
