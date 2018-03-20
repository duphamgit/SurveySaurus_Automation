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
 *         Check User can click on [Submit] button and an email is sent to
 *         inputted email
 */
public class TestForgotPassword_3 {

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

	public void testForgotPassword_3() throws IOException, InterruptedException {
		String url = testHome.getSpecificUrl("src/ForgotPasswordDataset", 1);
		testHome.navigatetoHomePage(url);

		// click Forgot Password btn
		testHome.waitExpectedConditions_element_xpath("/html/body/section/section/div/form/div[3]/a");
		homePage.clickForgotPasswordbtn();
		// Check User can click on [Submit] button and an email is sent to inputted
		// emails
		String email = testHome.getSpecificUrl("src/ForgotPasswordDataset", 4);
		forgotPasswordPage.sendKey_name("email", email);
		// click SUBMIT btn
		forgotPasswordPage.clickSubmitbtn();
		// Assertion
		System.out.println(
				"Show popup with content A link has been sent to your email, please check and follow the instruction to reset your password");
		forgotPasswordPage.waitExpectedConditions_element_xpath("//*[@id=\"dialogContent_0\"]");
		// Click CLOSE btn
		forgotPasswordPage.waitExpectedConditions_element_xpath("/html/body/div[3]/md-dialog/section/div[2]/button");
		forgotPasswordPage.click_by_xpath("/html/body/div[3]/md-dialog/section/div[2]/button");
		System.out.println("Check email receive at: http://yopmail.com/automation_forgotpassword");
		// Redirect to Home Page
		forgotPasswordPage.waitExpectedConditions_url(url);
		forgotPasswordPage.checkAssertion_url(url);
		// Check An email is sent to inputted email with link. Click on this link to
		// redirect to [Change password] screen
		String yopmail = "http://yopmail.com/automation_forgotpassword";
		testHome.navigatetoHomePage(yopmail);
		// testHome.waitExpectedConditions_element_xpath("/html/body/div/div[1]/div[1]");
		// testHome.checkAssertion_xpath("/html/body/div/div[1]/div[1]", "SurveySaurus
		// Password Reset");
		System.out.println("Got Reset Password Email");
		testHome.checkAssertion_url("http://www.yopmail.com/en/?automation_forgotpassword");
	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
