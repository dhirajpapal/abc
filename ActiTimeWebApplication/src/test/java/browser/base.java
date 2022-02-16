package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class base {
	
	public static WebDriver ChromeBrowserlaunch()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		return driver;
	}
	
	public static WebDriver EdgeBrowserlaunch()
	{
		System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe");
		WebDriver driver= new EdgeDriver();
		return driver;
	}

}
