package TestPack;
import org.openqa.selenium.chrome.ChromeDriver;

import MarvenPack.ApplicationHeader;
import MarvenPack.loginPage;

public class testclass1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://localhost/login.do");
		driver.manage().window().maximize();
		
		//login page pom class object
		
		loginPage Loginpage= new loginPage(driver);
		Loginpage.loginToApplication();	
		
		//ApplicationHeader pom class object
		
		ApplicationHeader applicationHeader=new ApplicationHeader(driver);
		applicationHeader.openUsersPage();
		
		
		
	}

}
