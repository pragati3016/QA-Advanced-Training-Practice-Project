package testPkg;

import org.testng.annotations.Test;

public class File2 {
	
	@Test(groups = "group1")
	public void func1() {
		System.out.println("Hello, This is Function 1 of File 2");

	}
	
	@Test(priority = 4)
	public void func2() {
		System.out.println("Hello, This is Function 2 of File 2");
		
	}

}
