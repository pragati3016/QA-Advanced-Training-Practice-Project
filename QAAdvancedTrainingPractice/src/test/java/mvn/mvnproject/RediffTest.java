package mvn.mvnproject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class RediffTest {
	public WebDriver driver;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	
	public ExtentTest test;
	

	@BeforeTest
	public void setExtent() {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myRediffReport.html");
		
		htmlReporter.config().setDocumentTitle("Rediff Test"); 
		htmlReporter.config().setReportName("Functional Testing"); 
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Pragati");
		extent.setSystemInfo("OS","Windows 10");
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pragati\\eclipse\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rediff.com/");
	}

	// Test1
	@Test
	public void RediffTitleTest() {
		test = extent.createTest("RediffTitleTest");
		String title = driver.getTitle();
		System.out.println(title);
		test.log(Status.INFO, "test.log - INFO - checking title in this test");
		Assert.assertEquals(title, "Redifffff");
	}

	// Test2
	@Test
	public void RediffSignUpCheckTest() {
		test = extent.createTest("RediffSignUpCheckTest");
		driver.findElement(By.xpath("./html/body/div[2]/div/div[2]/a[2]")).click();
		boolean b = driver.findElement(By.xpath(".//*[@id=\'signin_info\']/a[2]")).isDisplayed();
		test.log(Status.INFO, "test.log - INFO  - Checking the demo store image");
		Assert.assertTrue(b);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); 
			
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); 
																					
			String screenshotPath = RediffTest.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		}
		driver.quit();
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
