package day24;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindows {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); // 1 browser windows
		
		Set<String>windowIDs=driver.getWindowHandles();
		
	//Approach:1
		
	List<String>windowidsList=new ArrayList(windowIDs); // convert Set ---> List
		
	/*  String parentwindID=windowidsList.get(0);  //parent Window ID
		String childwindID=windowidsList.get(1);   //Child Window ID
		
		driver.switchTo().window(childwindID);  //switching to child window
		driver.findElement(By.xpath("//a[text()='Contact Sales']")).click();  //// 2nd browser window
	 */
	
	//OrangeHRM
	//OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS

	/*Approach:2
			
		for(String winid:windowidsList) {
			String title=driver.switchTo().window(winid).getTitle();
			//System.out.println(title);
		
			if(title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS"))  //	//*perform on child browser window
			{
				driver.findElement(By.xpath("//a[text()='Contact Sales']")).click();

			}
		}*/
	
	//	driver.close(); //parent window close
	//  driver.quit(); //child window close
				
	for(String winid:windowidsList) {
		String title=driver.switchTo().window(winid).getTitle();
	
	/*	if(title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS"))  //close child window
		{
			driver.close();
		}
		if(title.equals("OrangeHRM"))  //close parent window
		{
			driver.close();
		}*/
		
	if(title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS"))  //close child window
		{
			driver.close();
		}
		if(title.equals("OrangeHRM") || title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS"))  //close parent &Child window
		//if(title.equals("OrangeHRM") || title.equals("xyz") || title.equals("abc"))
		{
			driver.close();
		}
	
		
	}
	
	
}
	
}
