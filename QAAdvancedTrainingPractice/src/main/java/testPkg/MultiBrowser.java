package testPkg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MultiBrowser {
	
	private WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pragati\\eclipse\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("InternetExplorer"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Pragati\\eclipse\\IEDriverServer_x64_3.150.2\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("MicrosoftEdge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Pragati\\eclipse\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Pragati\\eclipse\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get("https://www.google.co.in/");
	}
	
	@Test
	public void login() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void afterTest()
	{
		driver.quit();
	}

}