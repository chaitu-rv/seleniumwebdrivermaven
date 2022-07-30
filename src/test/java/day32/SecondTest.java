package day32;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


/*TestCase
---------
1) Open App
2) Login
3) closeApp
*/

public class SecondTest {
 
WebDriver driver;
	
	@Test(priority=1)
	void openApp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login");
	}
	
@Test(priority=2)
void login()
{
	WebElement emailbox=driver.findElement(By.xpath("//input[@id='Email']"));
	emailbox.clear();
	emailbox.sendKeys("admin@yourstore.com");
	
	WebElement pwdbox=driver.findElement(By.xpath("//input[@id='Password']"));
	pwdbox.clear();
	pwdbox.sendKeys("admin");
	
	WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();",button);
	
	String act_lbl=driver.findElement(By.xpath("//h1[normalize-space()='Dashboard']")).getText();
	
	if(act_lbl.equals("Dashboard12"))
	{
		System.out.println("Test Passed");
		Assert.assertTrue(true);
	}
	else
	{
		System.out.println("Test Failed");
		Assert.assertTrue(false);
	}
	
}

@Test(priority=3)
void closeApp()
{
	driver.quit();
}

	
}
