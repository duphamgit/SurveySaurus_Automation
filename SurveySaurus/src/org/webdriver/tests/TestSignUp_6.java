/**
 * 
 */
package org.webdriver.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.webdriver.autorater.HomePage;
import org.webdriver.autorater.TestHome;

/**
 * @author du
 *
 *
 *         Check User can not login if email is not verified yet
 */
public class TestSignUp_6 {

	WebDriver driver;
	TestHome testHome;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		testHome = new TestHome(driver);
		homePage = new HomePage(driver);
	}

	@Test

	public void testSignUp_6() throws IOException, InterruptedException {
		// open url
		String url = testHome.getSpecificUrl("src/SignUpDataset", 1);
		testHome.navigatetoHomePage(url);

		// Input email & password
		String email = testHome.getSpecificUrl("src/SignUpDataset", 28);
		String password = testHome.getSpecificUrl("src/SignUpDataset", 30);
		homePage.inputEmail(email);
		homePage.inputPassword(password);

		// click Sign In btn
		homePage.clickSignInbtn();

		// assertion
		homePage.sleep(10000);

		// Check User can not login if email is not verified yet
		System.out.println("Check User can not login if email is not verified yet");
		homePage.waitExpectedConditions_element_xpath("/html/body/section/section/div/form/p");
		homePage.checkAssertion_xpath("/html/body/section/section/div/form/p", "Inactive account");
	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
