package day32;

import org.testng.annotations.Test;

public class TestingPriority {
	@Test(priority=3)
	void c()
	{
		System.out.println("test3");
	}
	
	@Test(priority=1)
	void b()
	{
		
		System.out.println("test2");
	}
	
	
	@Test(priority=1)
	void a()
	{
		System.out.println("test1");
	}
	

}
