package day25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//1) how to find total rows in a table
		
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		//int rows=driver.findElements(By.tagName("tr")).size(); // preferable if you have single table in  a page
		System.out.println("number of rows:"+rows); //7
		
		//2) how to find total number columns in table
		
		int cols=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		//int cols= driver.findElements(By.tagName("th")).size();  // prefers only if you have single table
		System.out.println("Number of coloumns:"+cols);  //4
		
		//3) read the specific row & column data
		//String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();
		//System.out.println(value); //Master In Selenium
		
		//4) read data from all the rows & Columns
		 
		/*System.out.println("Book Name"+"     "+"Author"+"    "+"Subject"+"       "+"Price");
		
		for(int r=2;r<=rows;r++) //2  3   4
		{
			for(int c=1;c<=cols;c++)  //1
			{
				String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td["+c+"]")).getText();
				System.out.print(value+"     ");
			}
			
			System.out.println();
		}*/
		
		
		// 5) Print book names whose auther is Amit
		
		/*for(int r=2;r<=rows;r++)
		{
			String author=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			
			if(author.equals("Amit"))
			{
				String bookname=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				
				System.out.println(bookname+"      "+author);
			}
			
		}*/
		
		//6) Find sum of price of all books
		
		int total=0;
		for(int r=2;r<=rows;r++)
		{
			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			total=total+Integer.parseInt(price);
			
		}
		
		System.out.println(" total price of all teh boosk:"+total);	
	}
}