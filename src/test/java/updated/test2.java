package updated;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class test2 {

	@Test
	public void t2() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saipa\\eclipse-workspace\\cb\\driver\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();

		options.setBinary("C:\\Users\\saipa\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://www.cgi.com/en");

		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"popup-buttons\"]//button[1]")).click();

		WebElement c = driver.findElement(By.xpath("//*[@href=\"/en/careers\"]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", c);

		driver.findElement(By.xpath("//*[contains(@aria-label,\"Learn more about Careers\")]")).click();

		Set<String> window = driver.getWindowHandles();

		Iterator<String> itr = window.iterator();

		String parent = itr.next();

		String child = itr.next();

		driver.switchTo().window(child);

		String req1 = driver.findElement(By.xpath("//*[text()=\"Current opportunities\"]")).getText();

		Assert.assertEquals(req1, "Current opportunities");

		// WebElement table = driver
		// .findElement(By.xpath("//*[@class=\"views-table table-result-search cols-5
		// responsive\"]//tbody"));

		// List<WebElement> rows = table.findElements(By.xpath("tr"));
		// int row = rows.size();

		WebElement next = driver.findElement(By.xpath("//a[text()=\"NEXT\"]"));

		boolean datafound = false;

		WebElement table;

		while (!datafound) {
			try {
				table = driver.findElement(
						By.xpath("//*[@class='views-table table-result-search cols-5 responsive']//tbody"));
				List<WebElement> rows = table.findElements(By.xpath("tr"));

				for (WebElement row : rows) {
					List<WebElement> columns = row.findElements(By.xpath("td"));

					for (WebElement column : columns) {
						String coltext = column.getText();

						if (coltext.equals("J0424-1556")) {
							String re = columns.get(1).getText();
							// Assert.assertEquals(re, "Softwar");

							String r1 = columns.get(2).getText();
							String r2 = columns.get(3).getText();
							String r3 = columns.get(4).getText();
							System.out.println(re);
							System.out.println(r1);
							System.out.println(r2);
							System.out.println(r3);

							Assert.assertEquals(r3, "Softwar");
							datafound = true;
							break;
						}
					}

					if (datafound) {
						break;
					}
				}

				if (!datafound) {
					next = driver.findElement(By.xpath("//a[text()='NEXT']"));
					Actions actions = new Actions(driver);
					actions.moveToElement(next).click().build().perform();
				}
			} catch (StaleElementReferenceException e) {
				// Refresh the elements and continue the loop
				table = driver.findElement(
						By.xpath("//*[@class='views-table table-result-search cols-5 responsive']//tbody"));
			}
		}

	}

}
