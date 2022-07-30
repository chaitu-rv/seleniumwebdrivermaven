package day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
			
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/"); //orangehrm
		driver.manage().window().maximize();
		
	driver.findElement(By.linkText("OrangeHRM, Inc")).click(); //it will open another page in other tab
	Thread.sleep(5000);
	
	//driver.close();  //close() will close  single (Driver is focused)
	driver.quit(); //quit() close all browser
	

/*Browser methods
	--------------
	close() - close single (current browser)
	quit() - close all teh browsers which are opened.*/

	
	}

}
