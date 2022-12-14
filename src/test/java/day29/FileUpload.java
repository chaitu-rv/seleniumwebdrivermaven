package day29;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@class='btn block resume-btn btn-orange mt20']")).click();
		driver.findElement(By.xpath("//*[@id='file-upload']")).sendKeys("C:\\Chaitanya Office\\chaitu IT 2020-2021 form.pdf");
	}

}
