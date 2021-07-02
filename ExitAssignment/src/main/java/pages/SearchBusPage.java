package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class SearchBusPage {
	WebDriver driver;

	public SearchBusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Elements for searching buses
	@FindBy(how = How.XPATH, using = "//a[@id='redBus']")
	public WebElement busTickets;

	@FindBy(how = How.XPATH, using = "//input[@id='txtSource']")
	public WebElement source;

	@FindBy(how = How.XPATH, using = "//input[@id='txtDestination']")
	public WebElement dest;

	@FindBy(how = How.XPATH, using = "//input[@id='txtOnwardCalendar']")
	public WebElement calendar;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div[3]/button")
	public WebElement search;

	@FindBy(how = How.XPATH, using = "//input[@id='onward_cal']")
	private WebElement date;

	public void busTicketsClick() {
		busTickets.click();
	}

	// for entering source
	public void enterSource(String from) {
		source.sendKeys(Keys.DOWN);
		source.sendKeys(Keys.DOWN);
		source.sendKeys(Keys.ENTER);
	}

	// for entering destination
	public void enterDest(String To) {
		dest.sendKeys(Keys.DOWN);
		dest.sendKeys(Keys.ENTER);

	}

	// for entering date
	public void selectDate(String dateVal) {

		calendar.sendKeys("30-Jun-2021");
	}

	public void clicksearch() throws Throwable {
		Thread.sleep(2000);
		search.click();
	}

	// method to enter invalid destination
	public void enterInvalidDestination(String To) {
		dest.sendKeys(Keys.ESCAPE);
		dest.sendKeys(To);
	}

	// method to enter invalid source
	public void enterInvalidSource(String To) {
		source.sendKeys(Keys.ESCAPE);
		source.sendKeys(To);
	}
}
