package day24;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html"); 
		driver.manage().window().maximize();
		
		driver.switchTo().frame("packageListFrame"); //1st frame // here you can specify either Name or ID directly without using locator
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		
		driver.switchTo().defaultContent();  // will go back to main page
		
		driver.switchTo().frame("packageFrame"); // 2nd frame
		driver.findElement(By.linkText("WebDriver")).click();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("classFrame"); //3rd frame
		driver.findElement(By.xpath("//a[text()='Index']")).click();
	}

}
