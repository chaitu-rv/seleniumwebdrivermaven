package day22;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		driver.get("https://itera-qa.azurewebsites.net/home/automation"); 
		driver.manage().window().maximize();
		
	//Select Single CheckBox
		
		//driver.findElement(By.xpath("//input[@id='monday']")).click();
		
//Select all checkboxes
	List<WebElement>checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input'and @type='checkbox']"));
	
	/*	for(int i=0;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}
		
		for(WebElement chkbx:checkboxes)
		{
			chkbx.click();
		}*/
//Select last two checkboxes
	
	/*for(int i=checkboxes.size()-2;i<checkboxes.size();i++)
	{
		checkboxes.get(i).click();

	}
		
//Select last three checkboxes
	
		for(int i=checkboxes.size()-3;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();

		}*/
//Select first two checkboxes
	
	for(int i=0;i<2;i++)
	{
		checkboxes.get(i).click();

	}
	Thread.sleep(5000);
//unselect checkboxes
	
	/*for(int i=0;i<2;i++)
	{
		if(checkboxes.get(i).isSelected())
		{
		checkboxes.get(i).click();

	}*/
	
	for(WebElement chkbox:checkboxes)
	{
		if(chkbox.isSelected()) 
		{
			chkbox.click();
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	}

}
