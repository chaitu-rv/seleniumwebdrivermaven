package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
	//Relative Xpath
		String productName=driver.findElement(By.xpath("//a[text()='MacBook']")).getText();
		System.out.println(productName);	//MacBook
		
	//Absolute Xpath
		String str=driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/h3[1]")).getText();
		System.out.println(str);//Featured
		
		driver.quit();
	}

}
