package day20;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetMethods {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
			
		driver.get("https://opensource-demo.orangehrmlive.com/");	
		driver.manage().window().maximize();
		
		System.out.println("title of the page:"+driver.getTitle());
		System.out.println("Current URL of the page:"+driver.getCurrentUrl());
		
		//System.out.println("page Source........."+driver.getPageSource());

//getWindowHandle method returns string
		//String WindowID=driver.getWindowHandle();
			//System.out.println(WindowID);  //CDwindow-AB8CB67DF951A85F7FB2E1E9FC27DA70
										    //CDwindow-31C06AF42C8B57693322E318875249DE
		
//getWindowHandles method returns set<String> as url are unique no duplications (instead of list)
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
			Set<String> WindowIDs=driver.getWindowHandles();
				for(String winid:WindowIDs)
					System.out.println(winid);  //CDwindow-C8901076D5E4C8E800C6352E89BCFD8A
											    //CDwindow-230473A7826AB5FE2F325FF529244C70
				
			

/*get methods  - accessed through WebDriver
				--
				get(url)
				getTitle()
				getCurrentURL()
				getPageSource()
				getWindowHandle()
				getWindowHandles()*/
			
		

			
	}

}
