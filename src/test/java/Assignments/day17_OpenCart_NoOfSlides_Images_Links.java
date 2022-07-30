package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day17_OpenCart_NoOfSlides_Images_Links {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		List<WebElement>sliders=driver.findElements(By.className("img-fluid"));
		System.out.println(sliders.size());  //18
		
		List<WebElement>images=driver.findElements(By.tagName("img"));
		System.out.println(images.size());  //18
		
		List<WebElement>links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());  //76
		
		//List<WebElement>MacBook=driver.findElements(By.linkText("MacBook"));
		//System.out.println(MacBook.size());  //1
		
//Error: ElementClickInterceptedException
		//driver.findElement(By.linkText("MacBook")).click();
		//driver.findElement(By.partialLinkText("Mac")).click();
		
		driver.quit();
		
	}

}
