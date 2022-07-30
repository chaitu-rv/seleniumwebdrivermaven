package day17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsDemo2 {

	public static void main(String[] args) {
		//Launch Browser
				WebDriverManager.chromiumdriver().setup();
				WebDriver driver=new ChromeDriver();
			
			//Open Application
				driver.get("http://automationpractice.com/index.php");
				driver.manage().window().maximize();   //Maximize the WebPage

		List<WebElement>sliders=driver.findElements(By.className("homeslider-container"));
			System.out.println(sliders.size());  //5
		
		List<WebElement>links=driver.findElements(By.tagName("a"));
			System.out.println(links.size());
		
		List<WebElement>images=driver.findElements(By.tagName("img"));
			System.out.println(images.size());
			
	//locator incorrect/not matching with any element	 -- list of Wb gives zero
		List<WebElement>elements=driver.findElements(By.tagName("abc"));
			System.out.println(elements.size());  //0
			
	//error- locator incorrect - webelement gives NOSuchElementException
			WebElement dummyele=driver.findElement(By.id("abcxyz"));
			driver.quit();
	}

}
