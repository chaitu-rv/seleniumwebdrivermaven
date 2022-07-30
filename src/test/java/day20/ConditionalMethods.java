package day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionalMethods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
			
		//driver.get("https://demo.nopcommerce.com/");	
		driver.get("https://demo.nopcommerce.com/register");
		
		driver.manage().window().maximize();
		
		WebElement searchbox=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		
	//IsDisplayed, IsEnabled Methods
		System.out.println("Display status:"+searchbox.isDisplayed());
		System.out.println("Enable status:"+searchbox.isEnabled());
		
	//IsSelected()
	WebElement male_rd=driver.findElement(By.xpath("//input[@id='gender-male']"));
	WebElement female_rd=driver.findElement(By.xpath("//input[@id='gender-female']"));
	
	//Before Selection
	System.out.println("Before Selection............");
	System.out.println(male_rd.isSelected());  //false
	System.out.println(female_rd.isSelected()); //false
	
	//After Selection of male raio
	male_rd.click(); //select male option
		System.out.println("After Selection............");
		System.out.println(male_rd.isSelected());  //true
		System.out.println(female_rd.isSelected());//false
		
	//After Selection of female raio
		female_rd.click(); //select male option
			System.out.println("After Selection............");
			System.out.println(male_rd.isSelected());  //false
			System.out.println(female_rd.isSelected());//true
			
	
//conditional methods -- accessed through WebElement
			
			//Returns a boolean value(true/false)

			//isDisplayed()
			//isEnabled()
			//isSelected()		
		
		
	}

}
