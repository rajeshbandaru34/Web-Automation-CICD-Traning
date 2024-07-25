package TestCases;

import org.testng.annotations.Test;

import Utilites.Baseone;

public class TC_002 extends Baseone{
	@Test(priority = 1)
	public static void Login() {
		implicitlywait();
		Senddata(elements.Username, "standard_user");
		implicitlywait();
		Senddata(elements.Password, "secret_sauce");
		implicitlywait();
		Click(elements.Login_Button);
	}
	@Test(priority = 2)
	public static void Add_To_Cart() {
		Click(elements.Add_To_cart);
		implicitlywait();
		Click(elements.Cart);
		implicitlywait();
		Click(elements.Checkout);
		implicitlywait();
		Senddata(elements.First_Name, "rajesh");
		Senddata(elements.Last_Name, "bandaru");
		Senddata(elements.Postal_Code, "512155");
		Click(elements.Continue_Button);
		implicitlywait();
		Click(elements.Finish_Button);
		implicitlywait();
		//Click(elements.Back_To_home);
	}

}
