package day20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
			
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/"); //orangehrm
		System.out.println(driver.getTitle());
		
		driver.navigate().to("https://demo.nopcommerce.com/"); //nopcommerce
		System.out.println(driver.getTitle());

		
		driver.navigate().back(); //orangehrm
		System.out.println(driver.getTitle());

		driver.navigate().forward();//nopcommerce
		System.out.println(driver.getTitle());

		driver.navigate().refresh();//reload
		System.out.println(driver.getTitle());

		
		
//Navigational methods -- accessed through WebDriver
		
//navigate().to(URL)
//navigate().back(URL)
//navigate().forward(URL)
//navigate().refresh(URL)

		
		
	}

}
