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
 */
public class TestSignIn_3 {

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

	public void testSignIn_3() throws IOException, InterruptedException {
		String url = testHome.getSpecificUrl("src/SignInDataset", 0);
		testHome.navigatetoHomePage(url);

		// Input email & password
		String email = testHome.getSpecificUrl("src/SignInDataset", 9 - 1);
		String password = testHome.getSpecificUrl("src/SignInDataset", 10 - 1);
		homePage.inputEmail(email);
		homePage.inputPassword(password);

		// click Sign In btn
		homePage.clickSignInbtn();

		// assertion
		homePage.sleep(10000);

		// Email is invalid
		System.out.println("Email is invalid");
		homePage.checkAssertion_xpath("/html/body/section/section/div/form/div[1]/p[2]", "Email is invalid");

	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
