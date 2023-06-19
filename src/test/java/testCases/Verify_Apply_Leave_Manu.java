package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Base;

public class Verify_Apply_Leave_Manu extends Base {
	@Test
	public void verifiApplyLeave() throws InterruptedException {

		getUrl();// 1. Navigate to http://it.microtechlimited.com
		// 2. Click on Login Menu
		click(By.xpath("//a[@href='elogin.php']"));

		// 3. Click on Customer Login
		// click(By.xpath("//a[@href='clogin.php']"));

		// 4. Enter User Id as david@gmail.com
		sendKeys(By.xpath("//input[@name='mailuid']"), "testpilot@gmail.com");

		// 5. Enter Password as 1234
		sendKeys(By.xpath("//input[@name='pwd']"), "1234");
		click(By.xpath("//input[@type='submit']"));
		// 10.Click on Apply leave manu bar
		Thread.sleep(3000);
		// 11.click on Apply Leave Text Button
		click(By.xpath("//a[text()='Apply Leave']"));
		Thread.sleep(3000);

		// 12.Putt Reason On Apply leave form
		sendKeys(By.xpath("//input[@placeholder='Reason']"), "FEVER");
		Thread.sleep(3000);
		sendKeys(By.xpath("//input[@name='start']"), "o1/24/2023");
		Thread.sleep(3000);

		sendKeys(By.xpath("//input[@name='end']"), "02/02/2023");
		Thread.sleep(3000);
		click(By.xpath("//button"));
		// 13.Verify Leave reason(Last click asserton)
		String s = getText(By.xpath("//tbody/tr[last()]/td[text()='FEVER']"));
		assertEquals("FEVER", s);
		// 14. Click LogOut Button
		click(By.xpath("//a[text()='Log Out']"));

	}
}
