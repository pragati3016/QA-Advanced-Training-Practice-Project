package testPkg;

import org.testng.annotations.Test;

public class DependsOn {
	
	@Test(enabled = false)
	public void demo() {
	System.out.println("Hello");
	}
	
	@Test(dependsOnMethods= {"cmethod","zmethod"})
	public void amethod()
	{
		System.out.println("This is A Method");
	}
	
	@Test
	public void cmethod() {
		System.out.println("This is C Method");
	}
	
	@Test
	public void zmethod()
	{
		System.out.println("This is Z Method");
	}

}
