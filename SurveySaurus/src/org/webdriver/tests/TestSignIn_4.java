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
public class TestSignIn_4 {

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

	public void testSignIn_4() throws IOException, InterruptedException {
		String url = testHome.getSpecificUrl("/Users/du/eclipse-workspace/SurveySaurus/src/SignInDataset", 0);
		testHome.navigatetoHomePage(url);

		// Input email & password
		String email = testHome.getSpecificUrl("/Users/du/eclipse-workspace/SurveySaurus/src/SignInDataset", 12 - 1);
		String password = testHome.getSpecificUrl("/Users/du/eclipse-workspace/SurveySaurus/src/SignInDataset", 13 - 1);
		homePage.inputEmail(email);
		homePage.inputPassword(password);

		// click Sign In btn
		homePage.clickSignInbtn();

		// assertion
		homePage.sleep(10000);

		// Check Invalid email
		System.out.println("Check Invalid email");
		homePage.checkAssertion_xpath("/html/body/section/section/div/form/p", "Invalid email or password");

	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
