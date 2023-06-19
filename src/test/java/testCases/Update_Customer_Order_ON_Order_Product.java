package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.Base;

public class Update_Customer_Order_ON_Order_Product extends Base {
	@Test
	public void UpdateCustomerOrderONOrderProduct() throws InterruptedException, IOException {
		/*
		 * Requirements: Test Case: Verify Customer Login functionality 1. Navigate to
		 * http://it.microtechlimited.com 2. Click on Login Menu 3. Click on Customer
		 * Login 4. Enter User Id as david@gmail.com // Test Steps 5. Enter Password as
		 * 1234 6. Click Login Button 7. Verify I am in Home Page 8. Click profile Menu
		 * 9. Click Update Info 10. Replace Contact Number 44555 11. Click Submit button
		 * 12. Verify Contact Number is changed to 44555
		 */
		getUrl();// 1. Navigate to http://it.microtechlimited.com

		// 2. Click on Login Menu
		click(By.xpath("//a[@href='elogin.php']"));

		// 3. Click on Customer Login
		click(By.xpath("//a[text()='Customer Login']"));

		// 4. Enter User Id as david@gmail.com
		sendKeys(By.xpath("//input[@name='mailuid']"), "david@gmail.com");

		// 5. Enter Password as 1234
		sendKeys(By.xpath("//input[@name='pwd']"), "1234");

		// 6. Click Login Button
		click(By.xpath("//input[@type='submit']"));
		// 7.Click on Order Product
		click(By.xpath("//a[@href='productOrder.php?id=4']"));
		//Thread.sleep(3000);

		// 8. Set Order Date
		// sendKeys(By.xpath("//input[@name='ordDate']"), "9/13/2022");
		// 9.Click on choose product name
		// click(By.xpath("//select[@name='prodId']"));

		// 10. Select Product name
		Select se = new Select(driver.findElement(By.xpath("//select[@name='prodId']")));
		se.selectByVisibleText("Camera");
		//Thread.sleep(3000);
		// 11. Verify the "Order Product"
		sendKeys(By.xpath("//input[@name='ordDate']"), "1/24/2023");

		String t = getText(By.xpath("//h2[@class='title']"));
		assertEquals("Order Product", t);

		// 12. Click on order product

		click(By.xpath("//button[@type='submit']"));
		Thread.sleep(3000);
		// click on confirm button
		click(By.xpath("//tbody/tr[last()]/td[last()]/a"));
		Thread.sleep(3000);

		// 13.Verify Confirmed Order

		String s = getText(By.xpath("//tbody/tr[last()]/td[text()='Confirmed']"));
		assertEquals("Confirmed", s);
		Thread.sleep(2000);
		takeScreenshot();
		// 14. Click LogOut Button
		click(By.xpath("//a[text()='Log Out']"));
		
		

	}
}