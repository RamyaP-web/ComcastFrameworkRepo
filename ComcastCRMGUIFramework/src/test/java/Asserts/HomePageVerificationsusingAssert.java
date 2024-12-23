package Asserts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationsusingAssert {
	@Test
	public void homepageTest()
	
	{
		System.out.println("Test1 starts");
		String ExpectedPage="Home";
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
	String ActualTitle=	driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
//Hard Assert
	
	 Assert.assertEquals(ActualTitle, ExpectedPage);

	
System.out.println("Test1 ends");
driver.close();
	
	
	
	}
	@Test
	public void verifylogohomepageTest()
	{
		System.out.println("Test 2 Starts");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		//Hard Assert
		
		Assert.assertTrue(status);
		System.out.println("Test2 ends");
		driver.close();
	}

}
