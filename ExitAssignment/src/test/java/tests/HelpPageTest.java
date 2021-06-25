package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HelpPage;

public class HelpPageTest extends BaseTest {
	@Test
	public void WhenuserClicks_New_Bus_booking_help() throws Throwable {
		HelpPage hp = new HelpPage(driver);
		hp.clickHelp();
		hp.changeWindow();
		hp.clickCross();
		Assert.assertEquals(driver.getTitle(), "red:Care");
		hp.clickNewBusBookingHelp();
		Thread.sleep(3000);
		String str = hp.isNeedHelpDisaplyed();
		Assert.assertEquals(str, "Need help to make a new bus ticket booking");
		hp.closeWindow();
	}
	
	@Test
	public void WhenuserClicks_Covid19_travel_Advisory() throws Throwable {
		HelpPage hp = new HelpPage(driver);
		hp.clickHelp();
		hp.changeWindow();
		hp.clickCross();
		Assert.assertEquals(driver.getTitle(), "red:Care");
		hp.clickCovidTravelAdvisory();
		Thread.sleep(3000);
		String str = hp.getTextfromTravelAdvisory();
		Assert.assertEquals(str, "Government advisory for travel");
		hp.closeWindow();
	}
	
	@Test
	public void WhenuserClicks_safety_Feature() throws Throwable {
		HelpPage hp = new HelpPage(driver);
		hp.clickHelp();
		hp.changeWindow();
		hp.clickCross();
		Assert.assertEquals(driver.getTitle(), "red:Care");
		hp.clickSafetyFeature();
		Thread.sleep(3000);
		String str = hp.getTextfromTravelAdvisory();
		Assert.assertEquals(str, "Government advisory for travel");
		hp.closeWindow();
	}
	
	@Test
	public void WhenuserClicks_Technical_Issue_Option() throws Throwable {
		HelpPage hp = new HelpPage(driver);
		hp.clickHelp();
		hp.changeWindow();
		hp.clickCross();
		Assert.assertEquals(driver.getTitle(), "red:Care");
		hp.clickTechnicalIssue();
		Thread.sleep(3000);
		String str = hp.getTextfromTechnicalIssue();
		Assert.assertEquals(str, "I faced some technical issue with redBus app/website");
		hp.closeWindow();
	}
}
