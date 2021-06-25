package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RPoolFunctionalityPage {

	WebDriver driver;

	public RPoolFunctionalityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Customer Review')]")
	public WebElement customerReview;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Corporate+')]")
	public WebElement corporatePlus;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'What is rPool')]")
	public WebElement whatIsRpool;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'rPool for RWAs')]")
	public WebElement rpoolForRwa;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'FAQs')]")
	public WebElement faq;
	
	@FindBy(how = How.XPATH, using = "//a[@id='cars']")
	public WebElement rpool;
	
	public void clickrPool() {
		rpool.click();
	}
	
	public void clickCustomerReview() {
		customerReview.click();
	}
	
	public void clickCorporatePlus() {
		corporatePlus.click();
	}
	
	public void clickWhatIsRpool() {
		whatIsRpool.click();
	}
	
	public void clickRpoolForRwa() {
		rpoolForRwa.click();
	}
	
	public void clickFaq() {
		faq.click();
	}
}
