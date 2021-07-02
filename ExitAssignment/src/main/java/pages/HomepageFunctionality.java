package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomepageFunctionality {
	WebDriver driver;

	public HomepageFunctionality(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// elements for homepage elements
	@FindBy(how = How.XPATH, using = "//a[@id='cars']")
	public WebElement rpool;

	@FindBy(how = How.XPATH, using = "//a[@id='redBus Bus Hire']")
	public WebElement busHire;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'redbus')]")
	public WebElement redBusLogo;

	@FindBy(how = How.XPATH, using = "//a[@id='redBus']")
	public WebElement busTickets;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Help')]")
	public WebElement help;

	@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]")
	public WebElement crossIcon;

	public void rpoolClick() {
		rpool.click();
	}

	// method to open bus hire page
	public void busHireClick() {
		busHire.click();
	}

	// method to open redbus logo
	public void redBusLogoClick() {
		redBusLogo.click();
	}

	// method to open bus tickets
	public void busTicketsClick() {
		busTickets.click();
	}

	// method to open help option
	public void clickHelp() {
		help.click();
	}

	static String winHandleBefore;

	public void changeWindow() {
		winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void clickCross() throws Throwable {

		crossIcon.click();
		Thread.sleep(2000);
	}

	public void closeWindow() {
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}
}
