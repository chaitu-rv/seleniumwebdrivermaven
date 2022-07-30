package day30;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshot {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		// screenshot of full page
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir") + "\\screenshots\\fullpage.png");
		FileUtils.copyFile(src, trg);
		
		// screenshot of specific area from the page

		WebElement fp = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		src = fp.getScreenshotAs(OutputType.FILE);
		trg = new File(System.getProperty("user.dir") + "\\screenshots\\featuredproducts.png");
		FileUtils.copyFile(src, trg);

		// capture screenshot of specific web element
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		src = logo.getScreenshotAs(OutputType.FILE);
		trg = new File(System.getProperty("user.dir") + "\\screenshots\\logo.png");
		FileUtils.copyFile(src, trg);

		driver.quit();

	}

}
