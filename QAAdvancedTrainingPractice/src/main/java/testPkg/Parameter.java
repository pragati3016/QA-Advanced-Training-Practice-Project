package testPkg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {

	@Parameters({"URL"})
	@Test
	public void check_param(String pmt) {
		
		System.out.println("Test - Parameters");
		System.out.println(pmt);
	}
}
