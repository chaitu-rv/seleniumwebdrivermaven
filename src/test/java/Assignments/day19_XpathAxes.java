package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day19_XpathAxes {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		
	//Self - selects the current node
		String text=driver.findElement(By.xpath("//a[normalize-space()='Shoppers Stop']/self::a")).getText();
		System.out.println(text); //Shoppers Stop

		
	//parent - selects the parent of current node(always one)
		text=driver.findElement(By.xpath("//a[normalize-space()='Shoppers Stop']/parent::td")).getText();
		System.out.println(text); //Shoppers Stop

	//child - Selects all children of the current node(one or many)
		List<WebElement>childs=driver.findElements(By.xpath("//a[normalize-space()='Shoppers Stop']/ancestor::tr/child::td"));
		System.out.println("Number of Child Elements:"+ childs.size()); //Number of Child Elements:5

	//Ancestors : selects all ancestors (Parents,grand parents etc.,)
		text=driver.findElement(By.xpath("//a[normalize-space()='Shoppers Stop']/ancestor::tr")).getText();
		System.out.println(text); //Shoppers Stop A 485.70 518.90 + 6.84

	//descendant : selects all descendants (child,grand children etc.,) of current node
		List<WebElement>descendants=driver.findElements(By.xpath("//a[normalize-space()='Shoppers Stop']/ancestor::tr/descendant::td"));
		System.out.println("Number of decendants:"+descendants.size()); //Number of descendants:5

	//following-selects everything in the documents after the closing tag of the current node 	
	
		List<WebElement>following=driver.findElements(By.xpath("//a[normalize-space()='Shoppers Stop']/ancestor::tr/following::tr"));
		System.out.println("Number of following:"+following.size());
		
	//following-sibling:selects all siblings after the current node
		List<WebElement>followingSibling=driver.findElements(By.xpath("//a[normalize-space()='Shoppers Stop']/ancestor::tr/following-sibling::tr"));
		System.out.println("Number of followingSibling:"+followingSibling.size());

	//preceding-selects everything in the documents before the current node in document	
		
			List<WebElement>preceding=driver.findElements(By.xpath("//a[normalize-space()='Shoppers Stop']/ancestor::tr/preceding::tr"));
			System.out.println("Number of following:"+preceding.size());
		
	//preceding-sibling-selects everything in the documents before the current node in document	
			
			List<WebElement>precedingSibling=driver.findElements(By.xpath("//a[normalize-space()='Shoppers Stop']/ancestor::tr/preceding-sibling::tr"));
			System.out.println("Number of following:"+precedingSibling.size());
	
		driver.quit();
	}

}
