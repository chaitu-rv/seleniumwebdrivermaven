package day33.pack;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
	@Test
	void a()
	{
		System.out.println(" I'm A");
	}
	@BeforeTest
	void m()
	{
		System.out.println("this is BeforeTest method");
	}
	@BeforeSuite
	void m1()
	{
		System.out.println("this is Before suite method.....");
	}
	
	@AfterSuite
	void m2()
	{
		System.out.println("this is After suite method.....");
	}
}
