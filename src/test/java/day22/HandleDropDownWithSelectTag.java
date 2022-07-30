package day22;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDownWithSelectTag {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		driver.get("https://www.opencart.com/index.php?route=account/register"); 
		driver.manage().window().maximize();
		
//Count Number of Options in the dropdown
		
		Select drpcountry=new Select(driver.findElement(By.xpath("//select[@name='country_id']")));
		List<WebElement>options = drpcountry.getOptions();
		System.out.println("Total No.of Options:"+options.size());
		
//Extract and print all options from dropdown
		/*for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}*/
		
		for(WebElement option:options)
		{
			System.out.println(option.getText());
		}
//Select option from dropdown
		//drpcountry.selectByVisibleText("Germany"); //Germany
		//drpcountry.selectByValue("38"); //Canada
		
		//drpcountry.selectByIndex(38);//canada
		drpcountry.selectByIndex(13);//Australia
		
	}

}
