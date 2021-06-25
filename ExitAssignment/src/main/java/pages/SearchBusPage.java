package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pagesUtils.HelperClass;

public class SearchBusPage {
	WebDriver driver;
	public SearchBusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
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
	
	
	public void enterSource(String from) {
//		source.sendKeys(Keys.ESCAPE);
//		source.sendKeys(from);
		source.sendKeys(Keys.DOWN);
		source.sendKeys(Keys.DOWN);
		source.sendKeys(Keys.ENTER);
	}
	
	public void enterDest(String To) {
//		source.sendKeys(Keys.ESCAPE);
//		dest.sendKeys(To);
//		source.sendKeys(Keys.DOWN);
//		source.sendKeys(Keys.UP);
		dest.sendKeys(Keys.DOWN);
		dest.sendKeys(Keys.ENTER);	
		
	}
	
	public void selectDate(String dateVal) {

		calendar.sendKeys("30-Jun-2021");
//		date.click();
//		HelperClass.selectDatefromCalendar(driver, dateVal);
	}
	public void clicksearch() throws Throwable {
		Thread.sleep(2000);
		search.click();
//		new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).
//		until(ExpectedConditions.elementToBeClickable(search));
//		driver.findElement(By.xpath("//section[@id='search']//button[@id='search_btn']")).click();
	}
	
	public void enterInvalidDestination(String To) {
		dest.sendKeys(Keys.ESCAPE);
		dest.sendKeys(To);
	}
	
	public void enterInvalidSource(String To) {
		source.sendKeys(Keys.ESCAPE);
		source.sendKeys(To);
	}
}
