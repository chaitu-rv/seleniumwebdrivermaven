package day31_datadriventesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FixedDepositCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();

		String file = System.getProperty("user.dir") + "\\testdata\\caldata.xlsx";

		int rows = XlUtils.getRowCount(file, "Sheet1");
		for (int i = 1; i <= rows; i++) {
			// reading data from excel
			String princ = XlUtils.getCellData(file, "Sheet1", i, 0);
			String rateofinterest = XlUtils.getCellData(file, "Sheet1", i, 1);
			String per1 = XlUtils.getCellData(file, "Sheet1", i, 2);
			String per2 = XlUtils.getCellData(file, "Sheet1", i, 3);
			String fre = XlUtils.getCellData(file, "Sheet1", i, 4);
			String exp_mvalue = XlUtils.getCellData(file, "Sheet1", i, 5);

			// passing data to the application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(princ);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofinterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);

			Select perdrp = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			perdrp.selectByVisibleText(per2);

			Select fredrp = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrp.selectByVisibleText(fre);

			Thread.sleep(3000);

			WebElement calbutton = driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")); // calculate button
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", calbutton);

			String act_mvalue = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();

			// validation
			if (Double.parseDouble(exp_mvalue) == Double.parseDouble(act_mvalue)) {
				System.out.println("Test passed");
				XlUtils.setCellData(file, "Sheet1", i, 7, "Passed");
				XlUtils.fillGreenColor(file, "Sheet1", i, 7);
			} else {
				System.out.println("Test failed");
				XlUtils.setCellData(file, "Sheet1", i, 7, "Failed");
				XlUtils.fillRedColor(file, "Sheet1", i, 7);
			}

			WebElement clearbutton = driver.findElement(By.xpath("//img[@class='PL5']"));
			js.executeScript("arguments[0].click();", clearbutton);

			Thread.sleep(3000);
		}

		driver.quit();
	}
}