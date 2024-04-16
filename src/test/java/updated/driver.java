package updated;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class driver {

	@Test
	public void driver1() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saipa\\eclipse-workspace\\cb\\driver\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();

		options.setBinary("C:\\Users\\saipa\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://omayo.blogspot.com/");

	}

}
