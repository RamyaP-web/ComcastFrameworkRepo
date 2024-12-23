package Asserts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePageVerificationTestWithoutAsserts {
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
if(ActualTitle.trim().equals(ExpectedPage))
{
	System.out.println("Home Page is been Verified" + "=====Pass====");
}
else
{
	System.out.println("Home Page is not been Verified" + "=====fail=====");
}
	
System.out.println("Test1 ends");
	
	
	
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
		if(status==true) {
			System.out.println("Logo is verified====Pass");
		}
		else
		{
			System.out.println("Logo is not Verified ====fail");
		}
		System.out.println("Test2 ends");
	}

}
