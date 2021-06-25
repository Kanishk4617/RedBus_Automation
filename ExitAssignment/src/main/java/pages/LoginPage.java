package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//i[@id='i-icon-profile']")
	public WebElement icon;
	
	@FindBy(how = How.XPATH, using = "//li[@id='signInLink']")
	public WebElement signIn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='mobileNoInp']")
	public WebElement contact;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Please enter valid mobile number')]")
	public WebElement invalidPhone;
	
	@FindBy(how = How.XPATH, using = "//body/div[7]/div[1]/div[2]/div[1]/div[1]/div[3]/iframe[1]")
	public WebElement signinIframe;
	
	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]")
	public WebElement countryCodes;
	
	@FindBy(how = How.XPATH, using = "//li[@id='ALB']")
	public WebElement country;
	
	@FindBy(how = How.XPATH, using = "//div[@id='recaptchaElement']")
	public WebElement captcha;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'GENERATE OTP')]")
	public WebElement generateOtp;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Phone code should be 91 for Indian numbers')]")
	public WebElement codeError;
	
	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
	public WebElement googleSign;
	
	@FindBy(how = How.CLASS_NAME, using = "social-acc-box-br margin-g")
    public WebElement googleIcon;
	
	public void iconClick() {
		icon.click();
	}

	public void signInClick() {
		signIn.click();
	}
		
	public void enterContact(String number) throws Throwable{
//		driver.switchTo().frame(signinIframe);
		driver.switchTo().frame(driver.findElement(By.className("modalIframe")));
		contact.sendKeys(number);
		Thread.sleep(5000);
	}
	public boolean checkVisibility()
	{
		boolean eleSelected = invalidPhone.isDisplayed();
		return eleSelected;
	}
	public void switchIframe() {
		driver.switchTo().frame(signinIframe);
	}
	public void selectCountry() {
		countryCodes.click();
		country.click();
	}

	public void clickCaptcha() {
		captcha.click();
	}
	public void getOtp() {
		generateOtp.click();
	}
	
	public boolean getError()
	{
		boolean eleSelected = codeError.isDisplayed();
		return eleSelected;
	}
	public void clickGoogleSignIn() throws Throwable {
		driver.switchTo().frame(driver.findElement(By.xpath("//body/div[6]/div[1]/div[2]/div[1]/div[1]/div[3]/iframe[1]")));
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[8]/div[1]")).click();
//		googleSign.click();
	}
	
}
