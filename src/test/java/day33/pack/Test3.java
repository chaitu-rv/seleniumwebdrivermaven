package day33.pack;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Test3 {
	@Test
	void c()
	{
		System.out.println(" I'm C");
	}
	@AfterTest
	void n()
	{
		System.out.println("this is AfterTest method");
	}

}
