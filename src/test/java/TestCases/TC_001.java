package TestCases;

import org.testng.annotations.Test;


import Utilites.Baseone;

public class TC_001 extends Baseone {
	@Test
	public static void name() {
		get("https://www.saucedemo.com/");
	}

}
