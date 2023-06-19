package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Base;

public class Verify_Customer_Contact_Number_Modification_Functionality extends Base {

	@Test
	public void Verify_Customer_Contact_Number_Modification_Functionality_Test() throws InterruptedException, IOException {
		
		/*
		 * Requirements: Test Case: Verify Customer Login functionality 1. Navigate to
		 * http://it.microtechlimited.com 2. Click on Login Menu 3. Click on Customer
		 * Login 4. Enter User Id as david@gmail.com // Test Steps 5. Enter Password as
		 * 1234 6. Click Login Button 7. Verify I am in Home Page 8. Click profile Menu
		 * 9. Click Update Info 10. Replace Contact Number 44555 11. Click Submit button
		 * 12. Verify Contact Number is changed to 44555
		 */

		setup(); // Instantiate WebDriver

		// 1. Navigate to http://it.microtechlimited.com
		getUrl();

		// 2. Click on Login Menu
		click(By.xpath("//a[@href='elogin.php']"));

		// 3. Click on Customer Login
		click(By.xpath("//a[@href='clogin.php']"));

		// 4. Enter UserId as a Customer login
		sendKeys(By.xpath("//input[@name='mailuid']"), "david@gmail.com");

		// 5. Enter Password as 1234
		sendKeys(By.xpath("//input[@name='pwd']"), "1234");

		// 6. Click Login Button
		click(By.name("login-submit"));

		// 7. Verify I am in Home Page

		// String s = getElementText("//h2[2]");

		// 8.Click Profile Menu
		click(By.linkText("My Profile"));

		// 9.Click Update Info
		Thread.sleep(3000);

		click(By.xpath("//button[@name='send']"));

		// 10.Replace Contact Number 44555
		Thread.sleep(3000);
		clear(By.name("contact"));

		sendKeys(By.name("contact"), "44555");

		// 11. Click Submit Button
		Thread.sleep(3000);
		click(By.name("update"));

		// 12. Verify Contact Number is changed to 44555
		Thread.sleep(3000);
		String v = driver.findElement(By.name("contact")).getAttribute("value");
		assertEquals("44555", v);
		takeScreenshot();

	}

}