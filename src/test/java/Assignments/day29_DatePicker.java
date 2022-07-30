package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day29_DatePicker {

	static void selectDate(WebDriver driver, WebElement dobDatePicker, String date, String month, String year) {
		dobDatePicker.click();

		Select mon = new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
		mon.selectByVisibleText(month);

		Select yr = new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		yr.selectByVisibleText(year);

		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td"));

		for (WebElement dt : dates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();

		String month = "Jan";
		String year = "1990";
		String date = "20";

		driver.findElement(By.id("product_550")).click(); // 990
		driver.findElement(By.id("travname")).sendKeys("John"); // First Given name
		driver.findElement(By.id("travlastname")).sendKeys("Kenedy"); // Last Surname (optional)
		driver.findElement(By.id("order_comments")).sendKeys("Testing"); // order_comments

		// Selecting DOB Logic
		/*
		 * driver.findElement(By.xpath("//input[@id='dob']")).click();
		 * 
		 * 
		 * Select mon=new
		 * Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
		 * mon.selectByVisibleText(month);
		 * 
		 * Select yr = new
		 * Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		 * yr.selectByVisibleText(year);
		 * 
		 * List<WebElement>dates=driver.findElements(By.xpath(
		 * "//table[@class='ui-datepicker-calendar']//tr/td"));
		 * 
		 * for(WebElement dt:dates) { if(dt.getText().equals(date)) { dt.click(); break;
		 * } }
		 */

		WebElement dobDatePicker = driver.findElement(By.xpath("//input[@id='dob']"));
		selectDate(driver, dobDatePicker, "5", "Jul", "1985"); // date, month,year //User defined method to select DOB.
		// DOB - END

		driver.findElement(By.id("sex_2")).click(); // Sex
		driver.findElement(By.id("traveltype_2")).click(); // Round Trip
		driver.findElement(By.name("fromcity")).sendKeys("Hyderabad"); // From city / Origin
		driver.findElement(By.name("tocity")).sendKeys("Delhi"); // To city. /Destination

		WebElement depDateDatePicker = driver.findElement(By.xpath("//input[@id='departon']"));
		selectDate(driver, depDateDatePicker, "30", "Jul", "2022"); // Departure date DD/MM/YYYY

		WebElement returnDateDatePicker = driver.findElement(By.xpath("//input[@id='returndate']"));
		selectDate(driver, returnDateDatePicker, "15", "Aug", "2022"); // return date DD/MM/YYYY

		// Delivery options:

		// What is the dummy ticket for...? //Boostrap DropDown
		driver.findElement(By.xpath("//span[@id='select2-reasondummy-container']")).click();
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Visa extension" + Keys.ENTER);

		// How will you like to receive the dummy ticket (optional)
		driver.findElement(By.xpath("//input[@id='deliverymethod_2']")).click(); // WhatsApp

		// Billing Details:

		driver.findElement(By.name("billname")).sendKeys("John");
		driver.findElement(By.name("billing_phone")).sendKeys("703-789-5417");
		driver.findElement(By.name("billing_email")).sendKeys("abcd@gmail.com");

		driver.findElement(By.xpath("//span[@id='select2-billing_country-container']")).click(); // Boostrap DropDown
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("India" + Keys.ENTER); // Country

		// Street address
		driver.findElement(By.name("billing_address_1")).sendKeys("13646 ABC");
		driver.findElement(By.name("billing_address_2")).sendKeys("ABC");
		driver.findElement(By.name("billing_city")).sendKeys("HYD");

		// State selection
		driver.findElement(By.xpath("//input[@id='billing_state']")).sendKeys("Telangana" + Keys.ENTER); // Boostrap DropDown
		//driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Telangana" + Keys.ENTER); // state

		driver.findElement(By.id("billing_postcode")).sendKeys("500090"); // Pin

		
	}

}
