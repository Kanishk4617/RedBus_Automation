package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomepageFunctionality;

public class HomepageTest extends BaseTest {

	@Test
	public void whenUserClicksOnrpoolLink() throws Throwable {
		HomepageFunctionality hm = new HomepageFunctionality(driver);
		hm.rpoolClick();
		Assert.assertEquals(driver.getTitle(), "rPool - India’s new Carpool & Bikepool mobile app");
		Thread.sleep(4000);
	}
	
	@Test
	public void whenUserClicksOnBusHireLink() throws Throwable {
		HomepageFunctionality hm = new HomepageFunctionality(driver);
		hm.busHireClick();
		Assert.assertEquals(driver.getTitle(), "Bus Hire: Rent Volvo, AC buses, Mini Buses, Tempo Travellers & Innova Cars - Book Online");
		Thread.sleep(4000);
	}
	
	@Test
	public void whenUserClicksOnRedBusLogoLink() throws Throwable {
		HomepageFunctionality hm = new HomepageFunctionality(driver);
		hm.redBusLogoClick();
		Assert.assertEquals(driver.getTitle(), "Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India");
		Thread.sleep(4000);
	}
	
	@Test
	public void whenUserClicksOnBusTicketsLink() throws Throwable {
		HomepageFunctionality hm = new HomepageFunctionality(driver);
		hm.busTicketsClick();
		Assert.assertEquals(driver.getTitle(), "Online Bus Tickets Booking: Book Bus Ticket and Bus Reservation -redBus India");
		Thread.sleep(4000);
	}
	
	@Test
	public void whenUserClicksOnHelp() throws Throwable {
		HomepageFunctionality hm = new HomepageFunctionality(driver);
		hm.clickHelp();
		hm.changeWindow();
		hm.clickCross();
		Assert.assertEquals(driver.getTitle(), "red:Care");
		hm.closeWindow();
	}
}
