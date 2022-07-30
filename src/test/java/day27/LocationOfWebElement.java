package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocationOfWebElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php");
		driver.manage().window().maximize();
		
		WebElement logo=driver.findElement(By.xpath("//div[@id='divLogo']//img"));

		Point loc=logo.getLocation();
		
		System.out.println(loc.getX()); //423
		System.out.println(loc.getY());  //75
		
		
		//logo.getLocation().getX();
		//logo.getLocation().getY();
		
	}

}
