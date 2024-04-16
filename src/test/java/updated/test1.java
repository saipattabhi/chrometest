package updated;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test1 {

	@Test
	public void t1() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saipa\\eclipse-workspace\\cb\\driver\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();

		options.setBinary("C:\\Users\\saipa\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://www.cgi.com/en");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

		WebElement table = driver
				.findElement(By.xpath("//*[@class=\"views-table table-result-search cols-5 responsive\"]//tbody"));

		List<WebElement> rows = table.findElements(By.xpath("tr"));

		int row = rows.size();

		for (int i = 0; i < row; i++) {

			List<WebElement> columns = rows.get(i).findElements(By.xpath("td"));

			int column = columns.size();

			for (int j = 0; j < column; j++) {

				String coltext = columns.get(j).getText();

				if (coltext.equals("J0424-0958")) {

					String req = columns.get(1).getText();

					System.out.println(req);

				}

			}

		}

	}

}
