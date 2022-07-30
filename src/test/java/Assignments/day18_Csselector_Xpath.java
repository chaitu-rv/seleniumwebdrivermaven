package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day18_Csselector_Xpath {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
	//css with tag and ID: "TagName#id"
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("MacBook");

	//css with tag and class: "TagName.class"
			//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("MacBook");
			//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("MacBook");
	
	//css with tag and attribute : TagName[atrribute='any attribute']
		//driver.findElement(By.cssSelector("input[name='q']")).sendKeys("MacBook");
		driver.findElement(By.cssSelector("[name='q']")).sendKeys("MacBook");

	//css tag class attribute: TagName.class[attribute='attribute value']
		driver.findElement(By.cssSelector("button.button-1[type='submit']")).click();

		
		
		
		
	

	}

}
