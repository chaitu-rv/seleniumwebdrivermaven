package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day17_SearchItem {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		
		//driver.findElement(By.id("input")).sendKeys("rice");
		//driver.findElement(By.className("btn btn-default bb-search")).click();
	
		driver.findElement(By.linkText("button")).click();
	}

}
