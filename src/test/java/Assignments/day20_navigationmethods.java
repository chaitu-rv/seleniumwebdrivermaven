package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day20_navigationmethods {

	public static void main(String[] args) {
		
		/*Navigational methods -- accessed through WebDriver
		--------------------------------------------------------------------
				1. navigate().to(URL)
				2. navigate().back(URL)
				3. navigate().forward(URL)
				4. navigate().refresh(URL) */
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
				
		driver.navigate().to("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		System.out.println(driver.getTitle());  //Dummy ticket for applying visa - Verifiable flight reservation for embassy

		driver.navigate().to("https://demo.nopcommerce.com/\r\n");
		System.out.println(driver.getTitle()); //nopCommerce demo store

				driver.navigate().back();
				System.out.println(driver.getTitle()); //Dummy ticket for applying visa - Verifiable flight reservation for embassy

				driver.navigate().forward();
				System.out.println(driver.getTitle()); //nopCommerce demo store

				driver.navigate().refresh();
				System.out.println(driver.getTitle()); //nopCommerce demo store


	}

}
