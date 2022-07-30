package day22;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class HandleDropDownWithoutSelect {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		driver.get("https://www.opencart.com/index.php?route=account/register"); 
		driver.manage().window().maximize();
		
//1. Count Number of Options in the dropdown
		List<WebElement>options=driver.findElements(By.xpath("//select[@id='input-country']/option"));
		System.out.println("No.of options:"+options.size());
		
//2. Extract and print all options from dropdown
		for(WebElement option:options)
		{
			System.out.println(option.getText());
		}		
//3. Select option from dropdown
		
		for(WebElement option:options)
		{
		if (option.getText().equals("India"))
		{
			option.click();
			break;
		}
		}
}
}
