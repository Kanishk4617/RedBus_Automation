package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import utils.Screenshots;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utils.ExcelFileIO;

public class BaseTest {

	static WebDriver driver;
	public static Logger logger = Logger.getLogger(BaseTest.class);

	public static String LOG_FILE = ".\\Resources\\log4j.properties";
	static FileInputStream logfile = null;
	static File file = new File(".\\Resources\\config.properties");
	static FileInputStream fis = null;
	static Properties prop = new Properties();
	public static ExcelFileIO reader = null;

	static {
		try {
			fis = new FileInputStream(file);
			logfile = new FileInputStream(LOG_FILE);
			PropertyConfigurator.configure(logfile);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
			prop.load(logfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {

			reader = new ExcelFileIO(".\\Resources\\testDataExcel.xlsx");
		}
		catch(Exception e) {

			logger.error(e.getMessage());
		}
	}
//	@AfterMethod(groups = { "valid", "invalid" })
//	public void attachScreenshots(ITestResult result) {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			String screenshotPath = Screenshots.takeScreenshot(driver, result.getName());
//			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			extentTest.log(LogStatus.PASS, "Passed successfully");
//		}
//		extent.endTest(extentTest);
//	}

	@BeforeMethod

	public static void intializeWebdriver() throws Exception {

		String browser = prop.getProperty("browser");
		String headless = prop.getProperty("headless");
		// Check if parameter passed is firefox
		if (browser.equalsIgnoreCase("firefox")) {
			if (headless.equalsIgnoreCase("yes")) {
				System.setProperty(prop.getProperty("firefox_driver"), prop.getProperty("firefox_path"));
				FirefoxBinary firefoxBinary = new FirefoxBinary();
				firefoxBinary.addCommandLineOptions("-headless");
				FirefoxOptions options = new FirefoxOptions();
				options.setBinary(firefoxBinary);
				driver = new FirefoxDriver(options);
			} else if (headless.equalsIgnoreCase("no")) {
				System.setProperty(prop.getProperty("firefox_driver"), prop.getProperty("firefox_path"));
				driver = new FirefoxDriver();
			}
		}

		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			if (headless.equalsIgnoreCase("yes")) {
				System.setProperty(prop.getProperty("driver_chrome"), prop.getProperty("path_chrome"));
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				driver = new ChromeDriver(options);
			} else if (headless.equalsIgnoreCase("no")) {
				System.setProperty(prop.getProperty("driver_chrome"), prop.getProperty("path_chrome"));
				driver = new ChromeDriver();
			}
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty(prop.getProperty("edge_driver"), prop.getProperty("edge_path"));
			// create Edge instance
			driver = new EdgeDriver();
		} else {
			// If no browser passed throw exception
			throw new Exception("PLEASE CHECK THE BROWSER NAME !");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public static void openBrowser() {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		}

	@AfterMethod
	public static void closeBrowser() {
		driver.close();
	}

}
