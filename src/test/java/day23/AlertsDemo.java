package day23;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));	//explictwait declaration		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts"); 
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		//Approach 1
			//Alert alert = driver.switchTo().alert();
		
		//Approach 2		
		Alert alert = mywait.until(ExpectedConditions.alertIsPresent());
		
		//Thread.sleep(5000);
			alert.sendKeys("welcome");
			alert.accept(); //this will close the alert window by using OK Button
			//alert.dismiss(); //this will close the alert window by using cancel Button
			
			String exp_value="You entered: welcome";
			String act_value=driver.findElement(By.xpath("//p[@id='result']")).getText();
			
			if(exp_value.equals(act_value))
			{
				System.out.println("Test Passed");
			}
			else
			{
				System.out.println("Test failed");
			}
	}

}
