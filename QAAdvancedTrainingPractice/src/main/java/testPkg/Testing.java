package testPkg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testing {
	
	@AfterMethod
	public void AM()
	{
		System.out.println("This is After Method");
	}
	
	@BeforeMethod
	public void BM()
	{
		System.out.println("This is Before Method");
	}
	
	@AfterClass
	public void AC()
	{
		System.out.println("This is After Class");
	}
	
	@BeforeClass
	public void BC()
	{
		System.out.println("This is Before Class");
	}
	
	@AfterTest
	public void AT()
	{
		System.out.println("This is After Test");
	}
	
	@BeforeTest
	public void BT()
	{
		System.out.println("This is Before Test");
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("This is After Suite");
	}
	
	@BeforeSuite
	public void BS()
	{
		System.out.println("This is Before Suite");
	}

	@Test(priority = 0)
	public void edemo()
	{
		System.out.println("Hello from Me!");
	}
}
