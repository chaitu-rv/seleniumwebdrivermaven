package Assignments;

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

public class day30_screenshot {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		// screenshot of full page
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir") + "\\screenshots\\Googlefullpage.png");
		FileUtils.copyFile(src, trg);

		// screenshot of specific area from the page
		WebElement fp = driver.findElement(By.xpath("//div[@id='hplogo']"));
		src = fp.getScreenshotAs(OutputType.FILE);
		trg = new File(System.getProperty("user.dir") + "\\screenshots\\Googlelogo.png");
		FileUtils.copyFile(src, trg);

		// capture screenshot of specific web element
		WebElement search = driver.findElement(By.xpath("//div[@class='SDkEP']"));
		src = search.getScreenshotAs(OutputType.FILE);
		trg = new File(System.getProperty("user.dir") + "\\screenshots\\Googlesearch.png");
		FileUtils.copyFile(src, trg);

		driver.quit();

	}

}
