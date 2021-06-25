package tests;

import org.testng.annotations.Test;

import pages.RPoolFunctionalityPage;

public class RPoolFunctionalityTest extends BaseTest {

	@Test
	public void whenUserClicksOnCustomerReview() throws Throwable {
		RPoolFunctionalityPage rp = new RPoolFunctionalityPage(driver);
		rp.clickrPool();
		rp.clickCustomerReview();
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	public void whenUserClicksOnCorporatePlus() throws Throwable {
		RPoolFunctionalityPage rp = new RPoolFunctionalityPage(driver);
		rp.clickrPool();
		rp.clickCorporatePlus();
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	public void whenUserClicksOn_What_is_rPool() throws Throwable {
		RPoolFunctionalityPage rp = new RPoolFunctionalityPage(driver);
		rp.clickrPool();
		rp.clickWhatIsRpool();
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	public void whenUserClicksOn_Rpool_for_rwa() throws Throwable {
		RPoolFunctionalityPage rp = new RPoolFunctionalityPage(driver);
		rp.clickrPool();
		rp.clickRpoolForRwa();
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
	} 
	
	@Test
	public void whenUserClicksOn_FAQ() throws Throwable {
		RPoolFunctionalityPage rp = new RPoolFunctionalityPage(driver);
		rp.clickrPool();
		rp.clickFaq();
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
	} 
}
