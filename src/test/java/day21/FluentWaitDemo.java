package day21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
			
		driver.get("https://www.google.com/"); 
		driver.manage().window().maximize();
	
	//waiting 30 seconds for an element to be present on the page , 
	//checking its presence once every 5seconds
		
		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
		
		//driver.findElement(By.xpath("//h3[text()='Selenium']")).click();
		
		
				WebElement link_ele=mywait.until(new Function<WebDriver, WebElement>()
				{
				public WebElement apply(WebDriver driver)
				{
				return driver.findElement(By.id("//h3[text()='Selenium']"));
				}
				});
		link_ele.click();

	}

}
