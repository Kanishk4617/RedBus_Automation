package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HelpPage {

	WebDriver driver;

	public HelpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Help')]")
	public WebElement help;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'New bus booking help')]")
	public WebElement newBusBookingHelp;
	
	@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]")
	public WebElement crossIcon;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Need help to make a new bus ticket booking')]")
	public WebElement needBusTitle;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'COVID-19 travel advisory')]")
	public WebElement covidTravelAdvisory;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Government advisory for travel')]")
	public WebElement govtAdvisoryHeading;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Safety+ feature')]")
	public WebElement safetyFeature;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Technical Issues')]")
	public WebElement technicalIssue;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'I faced some technical issue with redBus app/websi')]")
	public WebElement TechnicalIssueHeading;
	
	public void clickHelp() {
		help.click();
	}
    static String winHandleBefore;
	public void changeWindow() {
		winHandleBefore = driver.getWindowHandle();
//		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
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
	
	public void clickNewBusBookingHelp() {
		driver.switchTo().frame(driver.findElement(By.xpath("//body/section[@id='rh_main']/div[@id='mBWrapper']/div[@id='content']/div[1]/div[1]/iframe[1]")));
		newBusBookingHelp.click();
	}
	
	public String isNeedHelpDisaplyed() {
		String str = needBusTitle.getText();
		return str;
	}
	
	public void clickCovidTravelAdvisory() {
		driver.switchTo().frame(driver.findElement(By.xpath("//body/section[@id='rh_main']/div[@id='mBWrapper']/div[@id='content']/div[1]/div[1]/iframe[1]")));
		covidTravelAdvisory.click();
	}
	
	public String getTextfromTravelAdvisory() {
		String str = govtAdvisoryHeading.getText();
		return str;
	}
	
	public void clickSafetyFeature() {
		driver.switchTo().frame(driver.findElement(By.xpath("//body/section[@id='rh_main']/div[@id='mBWrapper']/div[@id='content']/div[1]/div[1]/iframe[1]")));
		safetyFeature.click();
	}
	
	public void clickTechnicalIssue() {
		driver.switchTo().frame(driver.findElement(By.xpath("//body/section[@id='rh_main']/div[@id='mBWrapper']/div[@id='content']/div[1]/div[1]/iframe[1]")));
		technicalIssue.click();
	}
	
	public String getTextfromTechnicalIssue() {
		String str = TechnicalIssueHeading.getText();
		return str;
	}
	
	
}
