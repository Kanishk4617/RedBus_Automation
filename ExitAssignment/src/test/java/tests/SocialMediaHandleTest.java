package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SocialMediaHandlePage;

public class SocialMediaHandleTest extends BaseTest {

	@Test
	public void userClicksFacebookIcon() throws Throwable {
		SocialMediaHandlePage socialMedia = new SocialMediaHandlePage(driver);
		socialMedia.busTicketsClick();
		socialMedia.fbIconClick();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/redBus.in/");
	}
	
	@Test
	public void userClicksTwitterIcon() throws Throwable {
		SocialMediaHandlePage socialMedia = new SocialMediaHandlePage(driver);
		socialMedia.busTicketsClick();
		socialMedia.twitterIconClick();
		Assert.assertEquals(driver.getTitle(), "redBus (@redBus_in) / Twitter");
		Thread.sleep(5000);
	}
	
//	@Test
//	public void whenUserClicksOnContactUs() throws Throwable {
//		SocialMediaHandlePage socialMedia = new SocialMediaHandlePage(driver);
//		socialMedia.busTicketsClick();
//		socialMedia.fbIconClick();
//		Thread.sleep(2000);
//		System.out.println(driver.getTitle());
//	}
}
