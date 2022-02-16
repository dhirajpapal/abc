package TestPack;
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

public class testNgClass2 extends base
{
	WebDriver driver;
	ApplicationHeader applicationHeader;
	loginPage LoginPage;
	
	@BeforeTest
	@Parameters("browser")
	public void launchTheBrowser(String browser) 
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver= ChromeBrowserlaunch();
		}
		
		if(browser.equalsIgnoreCase("microsoft"))
		{
			driver= EdgeBrowserlaunch();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void createPomObjects()
	{
		LoginPage= new loginPage(driver);
		applicationHeader= new ApplicationHeader(driver);
	}
	
	@BeforeMethod
	public void openTheURL()
	{
		driver.get("http://localhost/login.do");
		//driver.manage().window().maximize();
		LoginPage.loginToApplication();
	}
	
	@Test
	public void toVerifyTaskUsers()
	{
	
	applicationHeader.openUsersPage();
	String URL= driver.getCurrentUrl();
	String Title= driver.getTitle();
	Assert.assertEquals(URL,"http://localhost/administration/userlist.do");
	Assert.assertEquals(Title,"actiTIME - User List");

	}
	@Test
	public void toVerifyWorkScheduled()
	{
	applicationHeader.openWorkSchedulePage();
	String URL= driver.getCurrentUrl();
	String Title= driver.getTitle();
	Assert.assertEquals(URL,"http://localhost/administration/workingdays.do");
	Assert.assertEquals(Title,"actiTIME - Corporate Schedule");
	
	}
	
	
	@AfterMethod
	public void logOutFromApplication()
	{
		applicationHeader.logoutPage();
	}
	
	@AfterClass
	public void clearPomObjects()
	{
		LoginPage= null;
		applicationHeader= null;
	}
	
	@AfterTest
	public void closeTheBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}
	
}
	
