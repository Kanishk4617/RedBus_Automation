package tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.AboutRedbusPage;
import utils.CommonUtils;

public class AboutRedBusTest extends BaseTest {
	// sheet name which is used by all tests
	private String sheetName = "AboutusPageTest";

	@Test
	public void whenUserClicksOnAboutUs() throws Throwable {
		// testcase name
		String testName = "whenUserClicksOnAboutUs";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("About us test");
		AboutRedbusPage aboutus = new AboutRedbusPage(driver);
		aboutus.aboutUsClick();
		logger.info("About Us button is clicked");

		Thread.sleep(4000);
		aboutus.changeWindow();
		logger.info("Window is switched");

		String str = driver.getTitle();

		if (str.equals(expectedTitle)) {
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case failed");
		}
	}

	@Test
	public void whenUserClicksOnContactUs() throws Throwable {
		// testcase name
		String testName = "whenUserClicksOnContactUs";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("Contact us test");
		AboutRedbusPage socialMedia = new AboutRedbusPage(driver);
		socialMedia.contactUsClick();
		logger.info("Contact Us button is clicked");
		Thread.sleep(4000);

		socialMedia.changeWindow();
		logger.info("Window is switched");

		String str = driver.getTitle();
		System.out.println(str);

		if (str.equals(expectedTitle)) {
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case failed");
		}
	}

	@Test
	public void whenUserClicksOnredbusMobile() throws Throwable {
		// testcase name
		String testName = "whenUserClicksOnredbusMobile";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("redBus Mobile test");
		AboutRedbusPage socialMedia = new AboutRedbusPage(driver);
		socialMedia.redbusMobileClick();
		logger.info("Redbus Mobile is clicked");
		Thread.sleep(4000);

		socialMedia.changeWindow();
		logger.info("Window is switched");

		String str = driver.getTitle();
//		System.out.println(str);
		if (str.equals(expectedTitle)) {
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case failed");
		}
	}

	@Test
	public void whenUserClicksOnSitemap() throws Throwable {
		// testcase name
		String testName = "whenUserClicksOnSitemap";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("Sitemap test");

		AboutRedbusPage socialMedia = new AboutRedbusPage(driver);
		socialMedia.sitemapClick();
		logger.info("Sitemap button is clicked");
		Thread.sleep(4000);

		socialMedia.changeWindow();
		logger.info("Window is switched");

		String str = driver.getTitle();

		if (str.equals(expectedTitle)) {
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case failed");
		}
	}

	@Test
	public void whenUserClicksOnOffers() throws Throwable {
		// testcase name
		String testName = "whenUserClicksOnOffers";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("Offers test");

		AboutRedbusPage offer = new AboutRedbusPage(driver);
		offer.offersClick();
		logger.info("Offers button is clicked");
		Thread.sleep(4000);

		offer.changeWindow();
		logger.info("Window is switched");

		String str = driver.getTitle();
		System.out.print(str);
		if (str.equals(expectedTitle)) {
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedTitle, driver.getTitle());
			logger.info("test case failed");
		}
	}
}
