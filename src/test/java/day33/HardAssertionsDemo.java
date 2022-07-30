package day33;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionsDemo {
	@Test
	void test()
	{
		
		//Assert.assertTrue(true);   //passed
		//Assert.assertTrue(false);   // fail
		
		//Assert.assertFalse(false);  //pass
		//Assert.assertFalse(true);  //fail
		
		int a=10;
		int b=20;
		int c=30;
		
		//Assert.assertEquals(actual, expected, description);
		
		//Assert.assertEquals(a>b, true); //failed
		//Assert.assertNotEquals(a<b, true);   //fail
	
		//Assert.assertEquals(a<b, false);   //fail
		
		String s1="abc";
		String s2="abc";
		
		//Assert.assertEquals(s1, s2,"both are not matched..");   
		
		//Assert.assertEquals(s1, s2,"both are not matched..");    //fail
		
		
		if(false)
		{
			Assert.assertTrue(true);
		}
		else
		{
			//Assert.assertTrue(false);
			Assert.fail();
		}
		
		
		
	}

}
