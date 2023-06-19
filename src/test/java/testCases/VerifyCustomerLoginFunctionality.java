package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Base;

public class VerifyCustomerLoginFunctionality extends Base {
	@Test
	public void VerifyCustomerLogin() {
		/*
		 * Test Case: Verify Customer Login functionalty 1. Navigate to
		 * http://it.microtechlimited.com 2. Click on Login Menu 3. Click on Customer
		 * Login 4. Enter User Id as david@gmail.com 5. Enter Password as 1234 6. Click
		 * Login Button 7. Verify I am in Home Page
		 */
		// setup();// Instantiate WebDriver

		getUrl();// 1. Navigate to http://it.microtechlimited.com

		// 2. Click on Login Menu
		click(By.xpath("//a[@href=\"elogin.php\"]"));

		// 3. Click on Customer Login
		click(By.xpath("//a[@href='clogin.php']"));

		// 4. Enter User Id as david@gmail.com
		sendKeys(By.xpath("//input[@name='mailuid']"), "david@gmail.com");

		// 5. Enter Password as 1234
		sendKeys(By.xpath("//input[@name='pwd']"), "1234");

		// 6. Click Login Button
		click(By.xpath("//input[@type='submit']"));

		// 7. Verify I am in Home Page
		String s = getText(By.xpath("//h2[2]"));
//		if(s.contentEquals("Welcome David1"))
//			System.out.println("Login--Pass");
//		else System.out.println("Loging-Fail");
//		
//		//tearDown();
		// assertArrayEquals("Welcome David1", s);
		assertEquals("Welcome David", s);

	}

}
