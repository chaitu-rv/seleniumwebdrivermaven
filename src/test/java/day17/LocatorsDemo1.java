package day17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsDemo1 {

	public static void main(String[] args) {

	//Launch Browser
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver=new ChromeDriver();
	
	//Open Application
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();   //Maximize the WebPage
		
	//Search Box
		driver.findElement(By.id("search_query_top")).sendKeys("T-Shirts");
	
	//Search Button
		driver.findElement(By.name("submit_search")).click();
	
	//linkTest & partialLinkText
		driver.findElement(By.linkText("Printed Chiffon Dress")).click();
		//driver.findElement(By.partialLinkText("Printed Chiffon")).click();
		
		}
	

}
