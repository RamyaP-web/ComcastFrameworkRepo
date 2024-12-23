package ScreenShot;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class TakeScreenShot {
	@org.testng.annotations.Test
	public void Test() throws Exception
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		//Step1:- TypeCasting
	TakesScreenshot ts=(TakesScreenshot)driver;
	File srcfile=ts.getScreenshotAs(OutputType.FILE);
	
	File dest=new File("./ScreenShots/flipkart.png");
	
org.openqa.selenium.io.FileHandler.copy(srcfile, dest);
		
	
		
		//EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		
	}

}
