package Assignments;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day20_Condnl_Getmethods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
			
		
/*get Methods()  - accessed through WebDriver
		--
		get(url)
		getTitle()
		getCurrentURL()
		getPageSource()
		getWindowHandle()
		getWindowHandles()*/

		
	//1.get(URL) - openurl
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/\r\n");	
		driver.manage().window().maximize();
		
	//2.getTitle() //title of URL
		System.out.println("Title of Page:"+driver.getTitle()); 
		//Title of Page:Dummy ticket for applying visa - Verifiable flight reservation for embassy

	//3.getCurrentURL()
		System.out.println("Current URL of Page:"+driver.getCurrentUrl()); 
		//Current URL of Page:https://www.dummyticket.com/dummy-ticket-for-visa-application/
		
	//4.getPageSource()
		//System.out.println(driver.getPageSource());

	//5.getWindowHandle() -returns string
		
		String windowID=driver.getWindowHandle();
		System.out.println(windowID); //CDwindow-2AF2DFE24D17C5CE72201FAD4799FB86

		
	//6.getWindowHandles()- returns set<String> as url are unique no duplications (instead of list)
		
		driver.findElement(By.xpath("//li[contains(@class,'theme-icons-wrap fg-text-dark ffb-icon1-2')]//a")).click();
		
		Set<String> windowIDS=driver.getWindowHandles();
			for(String winids:windowIDS)
				System.out.println(winids);		//CDwindow-2AF2DFE24D17C5CE72201FAD4799FB86
												//CDwindow-E2CD8BB029CC81DF98DC2A72B01B0E2C
			
/*conditional methods -- accessed through WebElement
------------------
Returns a boolean value(true/false)

	1. isDisplayed()
	2. isEnabled()
	3. isSelected()  */
			
	WebElement name=driver.findElement(By.xpath("//input[@id='travname']"));
	
//1. IsDisplayed,
//2.IsEnabled Methods
	System.out.println("Display Status:"+name.isDisplayed());
	System.out.println("Enable Status:"+name.isEnabled());

//3.IsSelected()
	
	WebElement oneway=driver.findElement(By.xpath("//input[@id='traveltype_1']"));
	WebElement twoway=driver.findElement(By.xpath("//input[@id='traveltype_2']"));
	WebElement other=driver.findElement(By.xpath("//input[@id='traveltype_3']"));

//Before Selection
		System.out.println("Before Selection............");
		System.out.println(oneway.isSelected());  //false
		System.out.println(twoway.isSelected()); //false
		System.out.println(other.isSelected()); //false

//After Selection of oneway options
		oneway.click();
		
		System.out.println("After Selection of one way............");
		System.out.println(oneway.isSelected());  //true
		System.out.println(twoway.isSelected()); //false
		System.out.println(other.isSelected()); //false
		
//After Selection of two way options
	
		twoway.click();
		System.out.println("After Selection two............");
		System.out.println(oneway.isSelected());  //false
		System.out.println(twoway.isSelected()); //true
		System.out.println(other.isSelected()); //false

//After Selection of other  options
		
		other.click();
		System.out.println("After Selection other............");
		System.out.println(oneway.isSelected());  //false
		System.out.println(twoway.isSelected()); //false
		System.out.println(other.isSelected()); //true
		
		
	}

}
