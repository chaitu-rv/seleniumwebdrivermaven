package day33;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {

	@Test(priority=0)
	void openapp()
	{
		Assert.assertTrue(true);
	}
	
	
	@Test(priority=1, dependsOnMethods= {"openapp"})
	void login()
	{
		Assert.assertTrue(false);
	}
	
	@Test(priority=2,dependsOnMethods= {"login"})
	void search()
	{
		Assert.assertTrue(true);
	}
	
	
	@Test(priority=3,dependsOnMethods= {"login","search"})
	void advsearch()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=4,dependsOnMethods= {"login"})
	void logout()
	{
		Assert.assertTrue(true);
	}

}
