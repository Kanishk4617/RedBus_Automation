package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SocialMediaHandlePage {

	WebDriver driver;

	public SocialMediaHandlePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Elements and flow for using social media pages
	@FindBy(how = How.XPATH, using = "//a[@id='redBus']")
	public WebElement busTickets;

	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/div[1]/footer[1]/div[1]/section[6]/div[2]/a[1]")
	public WebElement facebookIcon;

	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/div[1]/footer[1]/div[1]/section[6]/div[2]/a[2]")
	public WebElement twitterIcon;

	// for opening facebook page
	public void fbIconClick() {
		facebookIcon.click();
	}

	// for opening twitter page
	public void twitterIconClick() {
		twitterIcon.click();
	}

	// for openeing bus tickets page
	public void busTicketsClick() {
		busTickets.click();
	}
}
