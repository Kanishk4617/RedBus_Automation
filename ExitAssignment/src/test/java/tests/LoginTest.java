package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void invalidPhone() throws Throwable {
		LoginPage login = new LoginPage(driver);
		login.iconClick();
		login.signInClick();
//		login.switchIframe();
		login.enterContact("123456");
		if(login.checkVisibility())
		{
			System.out.println("passed");
		}
	}
	
	@Test
	public void invalidCountryCode() throws Throwable {
		LoginPage login = new LoginPage(driver);
		login.iconClick();
		login.signInClick();
		login.enterContact("1234567890");
		login.selectCountry();
		login.clickCaptcha();
		login.getOtp();
		if(login.getError())
		{
			System.out.println("passed");
		}
	}

	@Test
	public void whenUserGoogleSignIn() throws Throwable {
		LoginPage login = new LoginPage(driver);
		login.iconClick();
		login.signInClick();
		login.clickGoogleSignIn();
		Thread.sleep(5000);
	}
}
