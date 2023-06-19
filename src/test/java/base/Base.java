package base;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;

	@BeforeSuite
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		// Set Headless Settings
		options.setHeadless(true);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Before Suite");

	}

	public void getUrl() {
		driver.get("http://it.microtechlimited.com/");
	}

	public void click(By byObject) {
		driver.findElement(byObject).click();
	}

	public void sendKeys(By byObject, String sendValue) {
		driver.findElement(byObject).sendKeys(sendValue);
	}

	public String getText(By byObject) {
		String s = driver.findElement(byObject).getText();
		return s;
	}

	public void clear(By byObject) {

		driver.findElement(byObject).clear();
	}

	public void takeScreenshot() throws IOException {
		
		LocalDateTime CurrentDateTime = LocalDateTime.now();
		String convertedDateTime = CurrentDateTime.toString().replace(":", "-").replace(".", "-");
		// Take a screenshot and save it to memory
		File CapturedScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Take screenshot and provide a name
		FileUtils.copyFileToDirectory(CapturedScreenshot,
				new File("./target/Screenshots/" + convertedDateTime + ".png"));
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
		driver.quit();
		System.out.println("After Test");
	}

}
