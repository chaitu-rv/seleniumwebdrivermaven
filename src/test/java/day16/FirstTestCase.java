package day16;

import javax.annotation.concurrent.ThreadSafe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException {

	//Launch ChromeBrowser
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver =new ChromeDriver();
		
	//Edge Browser
		//WebDriverManager.edgedriver().setup();
		//WebDriver driver=new EdgeDriver();
		
	//Firefox browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
	//open application url
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	//enter username and password
		
		//WebElement username=driver.findElement(By.name("txtUsername"));
		//username.sendKeys("Admin");
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
	//Click on login Button	
		driver.findElement(By.id("btnLogin")).click();
		
	//Validation
		String acc_title=driver.getTitle();
		String exp_title="OrangeHRM";
		
	if(acc_title.equals(exp_title))
	{
	System.out.println("Test Passed");
	}
	else
	{
		System.out.println("Test Failed");
	}
//driver.close();
	driver.quit();

		
		
	}

}
