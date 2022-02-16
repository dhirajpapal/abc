package MarvenPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	@FindBy (xpath = "//input[@name='username']")
	private WebElement userName;
	
	@FindBy (xpath = "//input[@name='pwd']")
	private WebElement password;
	
	@FindBy (xpath = "//input[@id='keepLoggedInCheckBox']")
	private WebElement keepMeLoginCheckbox;
	
	@FindBy (xpath = "//div[text()='Login ']")
	private WebElement login;

	public loginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	
	public void loginToApplication()
	{
		userName.sendKeys("admin");
		password.sendKeys("manager");
		keepMeLoginCheckbox.click();
		login.click();
	}
	

	
	
	
}
