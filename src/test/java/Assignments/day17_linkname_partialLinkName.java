package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day17_linkname_partialLinkName {

	public static void main(String[] args) {
		//Launch Browser
				WebDriverManager.chromiumdriver().setup();
				WebDriver driver=new ChromeDriver();
			
			//Open Application
				driver.get("http://automationpractice.com/index.php");
				driver.manage().window().maximize();   //Maximize the WebPage
				
			//linkTest & partialLinkText
				//driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();
			driver.findElement(By.partialLinkText("Faded")).click();
			//driver.quit();
	}

}
