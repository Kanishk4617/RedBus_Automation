package pages;

import org.openqa.selenium.By;
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
	@FindBy(how = How.XPATH, using = "//a[@id='redBus']")
	public WebElement busTickets;

	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/div[1]/footer[1]/div[1]/section[6]/div[2]/a[1]")
	public WebElement facebookIcon;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/div[1]/footer[1]/div[1]/section[6]/div[2]/a[2]")
	public WebElement twitterIcon;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/section[1]/footer[1]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]")
	public WebElement aboutus;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/section[1]/footer[1]/div[3]/div[1]/div[1]/div[1]/div[1]/a[2]")
	public WebElement contactus;
//	@FindBy(how = How.LINK_TEXT, using = "About Us")
//	public WebElement aboutus;
	public void fbIconClick() {
//		driver.switchTo().frame(driver.findElement(By.className("modalIframe")));
		facebookIcon.click();
	}

	public void twitterIconClick() {
//		driver.switchTo().frame(driver.findElement(By.className("modalIframe")));
		twitterIcon.click();
	}
	
	public void aboutUsClick() {
		aboutus.click();
	}

	public void contactUsClick() {
		contactus.click();
	}
	
	public void busTicketsClick() {
		busTickets.click();
	}
}
