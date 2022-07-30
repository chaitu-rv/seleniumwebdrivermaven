package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day20_browserMethods {

	public static void main(String[] args) {

/* Browser methods
 --------------
		close() - close single (current browser)
		quit() - close all the browsers which are opened */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
				
		driver.navigate().to("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.findElement(By.xpath("//li[contains(@class,'theme-icons-wrap fg-text-dark ffb-icon1-2')]//a")).click();
					
	//driver.close(); //close() single browser
		driver.quit(); //quit() close all browser

	}

}
