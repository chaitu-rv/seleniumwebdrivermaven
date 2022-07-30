package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day22_DropDownWithOutSelect {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		driver.get("https://itera-qa.azurewebsites.net/home/automation"); 
		driver.manage().window().maximize();
		
//1. Count Number of Options in the dropdown
				
	List<WebElement>option=driver.findElements(By.xpath("//select[@class='custom-select']/option"));
	System.out.println("No.of Options:"+option.size());

//2. Extract and print all options from dropdown

	for(WebElement options:option)
	{
		System.out.println(options.getText());
	}
//3. Select option from dropdown
		for(WebElement options:option)
		{
			if(options.getText().equals("Italy"))
			{
				options.click();
			}
}
		
	}
	
	

}
