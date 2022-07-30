package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day22_DropDownWithSelect {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		driver.get("https://itera-qa.azurewebsites.net/home/automation"); 
		driver.manage().window().maximize();
		
//1. Count Number of Options in the dropdown
		
		Select travel=new Select(driver.findElement(By.xpath("//select[@class='custom-select']")));
		List<WebElement>options=travel.getOptions();
		System.out.println("No of travel countries:"+options.size());

//2. Extract and print all options from dropdown
		for(WebElement option:options)
		{
			System.out.println(option.getText());
		}
		System.out.println("----------------");
//3. Select one from options
		
		//selectByVisibleText()
		//selectByValue()
		//selectByIndex()
	//travel.selectByVisibleText("Italy");
	//travel.selectByValue("6");
	travel.selectByIndex(6);
	
	
	

	}

}
