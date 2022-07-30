package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day26_DragAndDrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/drag_drop.html");					
	    
		//Element(BANK) which need to drag.		
		WebElement From1=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
        
     	//Element(DEBIT SIDE) on which need to drop.		
		WebElement To1=driver.findElement(By.xpath("//*[@id='bank']/li"));					
	      
		//Element(SALES) which need to drag.		
		WebElement From2=driver.findElement(By.xpath("//*[@id='credit1']/a"));
        
		//Element(CREDIT SIDE) on which need to drop.  		
		WebElement To2=driver.findElement(By.xpath("//*[@id='loan']/li"));					
	     
     	//Element(5000) which need to drag.		
		WebElement From3=driver.findElement(By.xpath("//*[@id='fourth']/a"));					
        
        //Element(DEBIT SIDE) on which need to drop.	
		WebElement To3=driver.findElement(By.xpath("//*[@id='amt7']/li"));					
        
		//Element(5000) which need to drag.		
		WebElement From4=driver.findElement(By.xpath("//*[@id='fourth']/a"));					
	        
	     //Element(CREDIT SIDE) on which need to drop.
		 WebElement To4=driver.findElement(By.xpath("//*[@id='amt8']/li"));					
	      
		//Using Actions class for drag and drop.
			Actions act=new Actions(driver);					

		//BANK drag and drop.	
			act.dragAndDrop(From1, To1).perform();
		//SALES drag and drop.
			act.dragAndDrop(From2, To2).perform();
		//5000 drag and drop debit side.
			act.dragAndDrop(From3, To3).perform();
		//-5000 drag and drop credit side.
			act.dragAndDrop(From4, To4).perform();

		//Verifying the Perfect! message.		
			if(driver.findElement(By.xpath("//a[contains(text(),'Perfect')]")).isDisplayed())							
		     	{		
		         	System.out.println("Perfect Displayed !!!");					
		     	}
				else
		     	{
		        	System.out.println("Perfect not Displayed !!!");					
		     	}    	    	
	     	
	}

}
