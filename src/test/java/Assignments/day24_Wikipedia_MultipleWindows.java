package Assignments;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day24_Wikipedia_MultipleWindows {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.className("wikipedia-search-input")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	List<WebElement>search=driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']/div/a"));		
	
	System.out.println("No.of search list:"+search.size());
	System.out.println("printing & clicking Search links................");

	for(WebElement link:search)
	{
		System.out.println(link.getText());
		link.click();
	}
	
	//After opening all the pages, capture windowid's
		Set<String>windowids=driver.getWindowHandles();
		
		System.out.println("-------------------"); 
		System.out.println("Switching to each browser window and getting the titles........"); 

	for(String windid:windowids)
	{
		String title = driver.switchTo().window(windid).getTitle();
		System.out.println(title);
		
	if(title.equals("Selenium disulfide - Wikipedia") || title.equals("Selenium in biology - Wikipedia"))
	{
		driver.close();
	}
	}
	//driver.quit();
	
	}
}

//Automation Testing Practice
//Selenium dioxide - Wikipedia
//Selenium disulfide - Wikipedia
//Selenium (software) - Wikipedia
//Selenium in biology - Wikipedia
//Selenium - Wikipedia


