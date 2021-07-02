package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AboutRedbusPage {
	public WebDriver driver;

	public AboutRedbusPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'About Us')]")
	public WebElement aboutus;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Contact Us')]")
	public WebElement contactus;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Mobile Version')]")
	public WebElement redbusMobile;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sitemap')]")
	public WebElement sitemap;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Offers')]")
	public WebElement offers;
	
	public void aboutUsClick() {
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aboutus.click();
	}

	public void contactUsClick() {
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		contactus.click();
	}
	
	public void redbusMobileClick() {
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		redbusMobile.click();
	}
	
	public void sitemapClick() throws Throwable {
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		sitemap.click();
	}
	
	public void offersClick() {
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		offers.click();
	}
	
	static String winHandleBefore;

	public void changeWindow() {
		winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

	}
}
