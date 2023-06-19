package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Base;

public class Update_Employee_Page extends Base {
	@Test
	public void updateEmployee() throws InterruptedException, IOException {

		getUrl();// 1. Navigate to http://it.microtechlimited.com
		System.out.println("hi");
		// 2. Click on Login Menu
		click(By.xpath("//a[@href=\"elogin.php\"]"));

		// 3. Click on Employee Login
		// click(By.xpath("//a[@href='clogin.php']"));

		// 4. Enter User Id as david@gmail.com
		sendKeys(By.xpath("//input[@name='mailuid']"), "testpilot@gmail.com");

		// 5. Enter Password as 1234
		sendKeys(By.xpath("//input[@name='pwd']"), "1234");
		Thread.sleep(2000);
		// 6. Click Login Button
		click(By.xpath("//input[@type='submit']"));
		System.out.println("Ok");

		String s = getText(By.xpath("//h2[text()='Welcome Test ']"));
		System.out.println(s);
		assertEquals("Welcome Test", s);
		Thread.sleep(2000);
		takeScreenshot();

	}

}
