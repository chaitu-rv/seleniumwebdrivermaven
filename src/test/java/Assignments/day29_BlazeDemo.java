package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day29_BlazeDemo {

	public static void main(String[] args) {

		// Driver Interface
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// 1
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		// 2
		driver.findElement(By.xpath("//select[@name='fromPort']")).sendKeys("Boston");
		// 3
		driver.findElement(By.xpath("//select[@name='toPort']")).sendKeys("London");
		// 4
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		// 5
		int rows = driver.findElements(By.xpath("//body//div//table//tr")).size();
		int cols = driver.findElements(By.xpath("//body//div//table//tr/th")).size();
		System.out.println(rows - 1);

		// 6
		driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).click();
		// 7
		String a = driver.findElement(By.xpath("//p[normalize-space()='Airline: United']")).getText();
		String b = driver.findElement(By.xpath("//p[normalize-space()='Flight Number: UA954']")).getText();
		String c = driver.findElement(By.xpath("//p[normalize-space()='Price: 400']")).getText();
		String d = driver.findElement(By.xpath("//p[normalize-space()='Arbitrary Fees and Taxes: 514.76']")).getText();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		// 8
		driver.findElement(By.id("inputName")).sendKeys("Naga");
		driver.findElement(By.id("address")).sendKeys("1403 American Beauty Ln");
		driver.findElement(By.id("city")).sendKeys("Columbus");
		driver.findElement(By.id("state")).sendKeys("OH");
		driver.findElement(By.id("zipCode")).sendKeys("43240");
		driver.findElement(By.id("creditCardNumber")).sendKeys("6789067345231267");
		driver.findElement(By.id("creditCardYear")).clear();
		driver.findElement(By.id("creditCardYear")).sendKeys("2022");
		driver.findElement(By.id("nameOnCard")).sendKeys("NagaK");
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

		// 9
		System.out.println(driver.getTitle());
		String val1 = driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']"))
				.getText();
		String val2 = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		String val3 = driver.findElement(By.xpath("//tbody/tr[2]")).getText();
		String val4 = driver.findElement(By.xpath("//tbody/tr[3]")).getText();
		String val5 = driver.findElement(By.xpath("//tbody/tr[4]")).getText();
		String val6 = driver.findElement(By.xpath("//tbody/tr[5]")).getText();
		String val7 = driver.findElement(By.xpath("//tbody/tr[6]")).getText();
		String val8 = driver.findElement(By.xpath("//tbody/tr[7]")).getText();
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(val3);
		System.out.println(val4);
		System.out.println(val5);
		System.out.println(val6);
		System.out.println(val7);
		System.out.println(val8);

	}

}
