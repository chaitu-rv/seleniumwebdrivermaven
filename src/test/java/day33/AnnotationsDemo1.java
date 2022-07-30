package day33;
import org.testng.annotations.*;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

public class AnnotationsDemo1 {
	
	@BeforeMethod
	void login() {
		System.out.println("Login....");
	}

	@Test(priority = 1)
	void search() {
		System.out.println("Searching.... ");
	}

	@Test(priority = 2)
	void advancedsearch() {
		System.out.println("Advaced searching...");
	}

	@AfterMethod
	void logout() {
		System.out.println("logout...");
	}

}
