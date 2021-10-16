package testPkg;

import org.testng.annotations.Test;

public class ParallelTest {
	
	@Test
	public void methodA()
	{
		long id = Thread.currentThread().getId();
		System.out.println("methodA. Thread id is: " + id);
	}

	@Test
	public void methodB()
	{
		long id = Thread.currentThread().getId();
		System.out.println("methodB. Thread id is: " + id);
	}
	
	@Test
	public void methodC()
	{
		long id = Thread.currentThread().getId();
		System.out.println("methodC. Thread id is: " + id);
	}
	
	@Test
	public void methodD()
	{
		long id = Thread.currentThread().getId();
		System.out.println("methodD. Thread id is: " + id);
	}
}
