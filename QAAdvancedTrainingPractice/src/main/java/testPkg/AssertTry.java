package testPkg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTry {
	
	@Test
	public void demo() {
	String act = "Gooooogle - Wrong string";
	System.out.println("Below assert would fail - ");
	Assert.assertEquals(act, "Google");
	
	}
}
