package MarvenPack;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationHeader {
	private WebDriverWait wait;
		
	@FindBy (xpath = "//div[text()='Time-Track']")
	private WebElement timeTrack;
		
	@FindBy (xpath = "//div[text()='Tasks']")
	private WebElement tasks;
		
	@FindBy (xpath = "//div[text()='Reports']")
	private WebElement reportrs;
	
	@FindBy (xpath = "//div[text()='Users']")
	private WebElement users;
		
	@FindBy (xpath = "//div[text()='Work Schedule']")
	private WebElement workSchedule;
	
	@FindBy (xpath = "//a[text()='Logout']")
	private WebElement logout;
		

	public ApplicationHeader(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,20);
	}
		

	public void openTimeTrackPage()
	{
		wait.until(ExpectedConditions.visibilityOf(timeTrack));
		timeTrack.click();	
	}
	
	public void openTasksPage()
	{
		tasks.click();	
	}
	
	public void openReportrsPage()
	{
		reportrs.click();	
	}
		
	public void openUsersPage()
	{
		users.click();	
	}
		
	public void openWorkSchedulePage()
	{
		workSchedule.click();	
	}
	
	public void logoutPage()
	{
		logout.click();	
	}
}
