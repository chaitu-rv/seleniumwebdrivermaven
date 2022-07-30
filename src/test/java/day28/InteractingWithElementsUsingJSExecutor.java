package day28;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractingWithElementsUsingJSExecutor {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
	//First name - inputbox
		WebElement inputbox=driver.findElement(By.xpath("//input[@id='RESULT_TextField-1']"));
		js.executeScript("arguments[0].setAttribute('value','Testing');",inputbox); //Testing
	
	//radio button
		WebElement radiobtn=driver.findElement(By.xpath("//input[@id='RESULT_RadioButton-7_0']"));
		js.executeScript("arguments[0].click();",radiobtn); //male
				
	//checkbox  - sunday
		WebElement chkbox=driver.findElement(By.xpath("//input[@id='RESULT_CheckBox-8_0']"));
		js.executeScript("arguments[0].click();", chkbox);		
		
	//button
		WebElement button=driver.findElement(By.xpath("//input[@id='FSsubmit']"));
		js.executeScript("arguments[0].click();", button);
				

	}

}
