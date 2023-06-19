package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Base;

public class Verify_Employee_Login_Functionality extends Base {
	

	/*
	Test Case: Verify Employee Login functionalty
		1. Navigate to http://it.microtechlimited.com
		2. Click on Login Menu
		3. Click on Customer Login
		4. Enter User Id as david@gmail.com
		5. Enter Password as 1234
		6. Click Login Button
		7. Verify I am in Home Page
	*/
	@Test
	public  void verify_Employee_Login_Functionality_with_Valid_Credential() throws InterruptedException {
		//setup();// Instantiate WebDriver
		
		
		getUrl();//1. Navigate to http://it.microtechlimited.com
		//2. Click on Login Menu
		
		Thread.sleep(5000);;
		click(By.xpath("//a[@href='elogin.php']"));
		
		//3. Click on Customer Login
		//click(By.xpath("//a[@href='clogin.php']"));
		
		//4. Enter User Id as david@gmail.com
		sendKeys(By.xpath("//input[@name='mailuid']"), "testpilot@gmail.com");
		
		//5. Enter Password as 1234
		sendKeys(By.xpath("//input[@name='pwd']"), "1234");
		
		//6. Click Login Button
		click(By.xpath("//input[@type='submit']"));
		
		//7. Verify I am in Home Page
		
		String s= getText(By.xpath("//h2[text()='Welcome Test ']"));
		System.out.println(s);
		assertEquals("Welcome Test", s);	
		
	}

	
}
