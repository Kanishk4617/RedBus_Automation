package tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.RPoolFunctionalityPage;
import utils.CommonUtils;

public class RPoolFunctionalityTest extends BaseTest {
	// sheet name which is used by all tests
	private String sheetName = "rPoolFunctionalityTest";

	@Test
	public void whenUserClicksOnCustomerReview() throws Throwable {
		// testcase name
		String testName = "whenUserClicksOnCustomerReview";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedUrl = testData.get("Expected URL");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("rPool : Customer Review test");

		RPoolFunctionalityPage rp = new RPoolFunctionalityPage(driver);
		rp.clickrPool();
		logger.info("rPool button is clicked");

		rp.clickCustomerReview();
		logger.info("Customer Review button is clicked");
		Thread.sleep(3000);

		String str = driver.getCurrentUrl();
		if (str.equals(expectedUrl)) {
			Assert.assertEquals(expectedUrl, str);
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedUrl, str);
			logger.info("test case failed");
		}
	}

	@Test
	public void whenUserClicksOnCorporatePlus() throws Throwable {
		// testcase name
		String testName = "whenUserClicksOnCorporatePlus";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedUrl = testData.get("Expected URL");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("rPool: Corporate Plus test");

		RPoolFunctionalityPage rp = new RPoolFunctionalityPage(driver);
		rp.clickrPool();
		logger.info("rPool button is clicked");

		rp.clickCorporatePlus();
		logger.info("Corporate Plus button is clicked");
		Thread.sleep(3000);

		String str = driver.getCurrentUrl();
		if (str.equals(expectedUrl)) {
			Assert.assertEquals(expectedUrl, str);
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedUrl, str);
			logger.info("test case failed");
		}
	}

	@Test
	public void whenUserClicksOn_What_is_rPool() throws Throwable {
		// testcase name
		String testName = "whenUserClicksOn_What_is_rPool";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedUrl = testData.get("Expected URL");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("rPool : What is rPool test");
		RPoolFunctionalityPage rp = new RPoolFunctionalityPage(driver);

		rp.clickrPool();
		logger.info("rPool button is clicked");

		rp.clickWhatIsRpool();
		logger.info("What is rPool button is clicked");
		Thread.sleep(3000);

		String str = driver.getCurrentUrl();
		if (str.equals(expectedUrl)) {
			Assert.assertEquals(expectedUrl, str);
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedUrl, str);
			logger.info("test case failed");
		}
	}

	@Test
	public void whenUserClicksOn_Rpool_for_rwa() throws Throwable {
		// testcase name
		String testName = "whenUserClicksOn_Rpool_for_rwa";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedUrl = testData.get("Expected URL");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("rPool : rPool for rwa test");

		RPoolFunctionalityPage rp = new RPoolFunctionalityPage(driver);
		rp.clickrPool();
		logger.info("rPool button is clicked");

		rp.clickRpoolForRwa();
		logger.info("rPool for rwa button is clicked");
		Thread.sleep(3000);
		String str = driver.getCurrentUrl();
		if (str.equals(expectedUrl)) {
			Assert.assertEquals(expectedUrl, str);
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedUrl, str);
			logger.info("test case failed");
		}
	}

	@Test
	public void whenUserClicksOn_FAQ() throws Throwable {
		// testcase name
		String testName = "whenUserClicksOn_FAQ";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedUrl = testData.get("Expected URL");

		// if execution required field is no
		CommonUtils.toCheckExecutionRequired(executionRequired);

		extentTest = extent.startTest("rPool : FAQ test");

		RPoolFunctionalityPage rp = new RPoolFunctionalityPage(driver);
		rp.clickrPool();
		logger.info("rPool button is clicked");

		rp.clickFaq();
		logger.info("FAQ button is clicked");
		Thread.sleep(3000);
		String str = driver.getCurrentUrl();
		if (str.equals(expectedUrl)) {
			Assert.assertEquals(expectedUrl, str);
			logger.info("test case passed");
		} else {
			extentTest.log(LogStatus.FAIL, "Test case failed");
			Assert.assertEquals(expectedUrl, str);
			logger.info("test case failed");
		}
	}
}
