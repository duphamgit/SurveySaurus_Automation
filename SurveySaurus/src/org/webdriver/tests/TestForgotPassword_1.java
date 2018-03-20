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
import org.webdriver.autorater.ForgotPasswordPage;
import org.webdriver.autorater.HomePage;
import org.webdriver.autorater.TestHome;

/**
 * @author du
 *
 *         Check GUI of Forgot your password screen
 */
public class TestForgotPassword_1 {

	WebDriver driver;
	TestHome testHome;
	HomePage homePage;
	ForgotPasswordPage forgotPasswordPage;

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		testHome = new TestHome(driver);
		homePage = new HomePage(driver);
		forgotPasswordPage = new ForgotPasswordPage(driver);
	}

	@Test

	public void testForgotPassword_1() throws IOException, InterruptedException {
		String url = testHome.getSpecificUrl(
				"/Users/du/eclipse-workspace/SurveySaurus_Automation/SurveySaurus/src/ForgotPasswordDataset", 1);
		testHome.navigatetoHomePage(url);

		// click Forgot Password btn
		testHome.waitExpectedConditions_element_xpath("/html/body/section/section/div/form/div[3]/a");
		homePage.clickForgotPasswordbtn();
		// Check GUI of Forgot your password screen
		// SignIn btn
		testHome.checkPageContainElement("/html/body/header/div/div/div[2]/div/ul/li/a");
		System.out.println("Appear Sign IN btn");
		// Email textfield
		testHome.checkPageContainElement("/html/body/section/section/div/form/div[1]/input");
		System.out.println("Appear Email textfield");
		// Submit btn
		testHome.checkPageContainElement("/html/body/section/section/div/form/div[3]/button");
		System.out.println("Appear SUBMIT btn");
	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
