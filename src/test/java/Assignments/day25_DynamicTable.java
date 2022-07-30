package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day25_DynamicTable {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		
		//Login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");  //Admin
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");  //admin123
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']")).click();
		driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']")).click();
		
	//Handling table
		int rows=driver.findElements(By.xpath("//table[@id='resultTable']//tbody//tr")).size();
		
		int count=0;  
		for(int r=1;r<=rows;r++)
		{
			String status=driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr["+r+"]/td[5]")).getText();
			
			if(status.equals("Enabled"))
			{
				count++;
			}
		}	
		System.out.println("Total no of users:"+rows);
		System.out.println("Enabled users:"+count);
		System.out.println("Disabled users:"+(rows-count));
		
	}
}
