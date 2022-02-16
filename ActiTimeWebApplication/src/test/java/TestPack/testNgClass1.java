package TestPack;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import MarvenPack.ApplicationHeader;
import MarvenPack.loginPage;
import browser.base;

public class testNgClass1 extends base{
	WebDriver driver;
	ApplicationHeader applicationHeader;
	loginPage LoginPage;
	
	
	@BeforeTest
	@Parameters("browser")
	public void launchTheBrowser(String browser)
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			driver= ChromeBrowserlaunch();
		}
		
		if (browser.equalsIgnoreCase("microsoft"))
		{
			driver= ChromeBrowserlaunch();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void createPOMobjects()
	{
		LoginPage= new loginPage(driver);
		applicationHeader= new ApplicationHeader(driver);
	}
	
	@BeforeMethod
	public void openTheURL()
	{
		driver.get("http://localhost/login.do");
		LoginPage.loginToApplication();
		
	}
	
	@Test
	public void toVerifyTaskButton()
	{
	applicationHeader.openTasksPage();
	String URL= driver.getCurrentUrl();
	String Title= driver.getTitle();
	
	Assert.assertEquals(URL,"http://localhost/tasks/otasklist.do");
	Assert.assertEquals(Title,"actiTIME - Open Tasks");

	}
	@Test
	public void toVerifyReportsButton()
	{
	applicationHeader.openReportrsPage();
	String URL= driver.getCurrentUrl();
	String Title= driver.getTitle();
	
	Assert.assertEquals(URL,"http://localhost/reports/reports.do");
	Assert.assertEquals(Title,"actiTIME - Saved Reports");
	
	}
	
	
	@AfterMethod
	public void logOutFromApplication()
	{
		applicationHeader.logoutPage();
	}
	
	@AfterClass
	public void clearPomObject()
	{
		LoginPage= null;
		applicationHeader= null;
	}
	
	@AfterTest
	public void closeTheBrowser()
	{
		driver.quit();
		driver=null;
		System.gc();
	}

}
