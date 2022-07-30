package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day24_HandlingFrames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		driver.switchTo().frame(0);  //frame(Index)
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys("chaitanya");
		driver.findElement(By.id("RESULT_TextField-2")).sendKeys("lokesh");
		driver.findElement(By.id("RESULT_TextField-3")).sendKeys("11111111");
		driver.findElement(By.id("RESULT_TextField-4")).sendKeys("India");
		driver.findElement(By.id("RESULT_TextField-5")).sendKeys("Hyderabad");
		driver.findElement(By.id("RESULT_TextField-6")).sendKeys("abc@gmail.com");
		
		
		driver.findElement(By.xpath("//label[@for='RESULT_RadioButton-7_0']")).click();

List<WebElement>days=driver.findElements(By.xpath("//input[@type='checkbox' and @name='RESULT_CheckBox-8']/ancestor::td/child::label"));

		Thread.sleep(5000);
		
		for(WebElement availabe:days)
		{
			availabe.click();
		}

//Count Number of Options in the dropdown
		Select drpdown=new Select(driver.findElement(By.xpath("//select[@name='RESULT_RadioButton-9']")));
		List<WebElement>options = drpdown.getOptions();
		System.out.println("Total No.of Options:"+options.size());

//Extract and print all options from dropdown
		for(WebElement option:options)
		{
			System.out.println(option.getText());
		}
		
//Select option from dropdown
		drpdown.selectByVisibleText("Evening"); //Evening
		//drpdown.selectByValue("Radio-2"); //Evening
		//drpdown.selectByIndex(3);//Evening
	
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Thread.sleep(5000);

		WebElement link=driver.findElement(By.xpath("//*[@id='q23']/div/a"));  //unable to click on link
		js.executeScript("arguments[0].click();", link);

	}
}