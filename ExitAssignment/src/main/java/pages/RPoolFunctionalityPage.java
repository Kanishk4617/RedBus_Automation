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

	// elements for using rPool functionalities
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

	// method to open rPool
	public void clickrPool() {
		rpool.click();
	}

	// method to get customer reviews
	public void clickCustomerReview() {
		customerReview.click();
	}

	// method to open corporate plus
	public void clickCorporatePlus() {
		corporatePlus.click();
	}

	// method to open what is rPool
	public void clickWhatIsRpool() {
		whatIsRpool.click();
	}

	// method to open rPool for rwa
	public void clickRpoolForRwa() {
		rpoolForRwa.click();
	}

	// method to open faq
	public void clickFaq() {
		faq.click();
	}
}
