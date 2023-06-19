package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Base;

public class Verify_The_Orde_List extends Base {
	@Test
	public void verifyOrderlist() {
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
		// 7.Clich on Order List
		click(By.xpath("//a[@href='orderList.php?id=4']"));
		// 8.Verify the order list text

		String s = getText(By.id("orderList-title"));
		assertEquals("Order List", s);
		System.out.println(s);
		// 9.Logout From the page
		click(By.xpath("//a[@href='clogin.php']"));

	}
}
