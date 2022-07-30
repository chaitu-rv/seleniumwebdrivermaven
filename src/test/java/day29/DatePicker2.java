package day29;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		//logic
		String mon="Jan";
		String year="1990";
		String date="20";
		
		driver.findElement(By.xpath("//input[@id='dob']")).click(); // opens date picker
		
		//month selection
		Select drpmonth = new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
		drpmonth.selectByVisibleText(mon);
		
		//Year selection
		Select drpyear=new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		drpyear.selectByVisibleText(year);
			
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		//select date
		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
		
	}

}
