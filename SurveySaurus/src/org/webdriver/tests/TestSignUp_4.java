/**
 * 
 */
package org.webdriver.tests;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.webdriver.autorater.HomePage;
import org.webdriver.autorater.SignUpPage;
import org.webdriver.autorater.TestHome;

/**
 * @author du
 * 
 *         User can click on [Create Account] button, Create account successful
 */
public class TestSignUp_4 {

	WebDriver driver;
	TestHome testHome;
	SignUpPage signUpPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		testHome = new TestHome(driver);
		signUpPage = new SignUpPage(driver);
		homePage = new HomePage(driver);
	}

	@Test
	public void testSignUp_4() throws IOException, InterruptedException {
		// Home Page
		String url = testHome.getSpecificUrl(
				"/Users/du/eclipse-workspace/SurveySaurus_Automation/SurveySaurus/src/SignUpDataset", 1);
		testHome.navigatetoHomePage(url);

		// click SignUp btn
		String signup_url = testHome.getSpecificUrl(
				"/Users/du/eclipse-workspace/SurveySaurus_Automation/SurveySaurus/src/SignUpDataset", 3);
		homePage.clickSignUpbtn();
		homePage.waitExpectedConditions_url(signup_url);
		// click individual btn
		signUpPage.waitExpectedConditions_element_xpath("/html/body/section/div/div/div/ul/li[1]/a");
		signUpPage.clickIndividualbtn();

		// input existed email into [Email] and valid value into other fields
		// firstname
		String firstname = testHome.getSpecificUrl(
				"/Users/du/eclipse-workspace/SurveySaurus_Automation/SurveySaurus/src/SignUpDataset", 6);
		signUpPage.inputFirstName_individual(firstname);
		// lastname
		String lastname = testHome.getSpecificUrl(
				"/Users/du/eclipse-workspace/SurveySaurus_Automation/SurveySaurus/src/SignUpDataset", 8);
		signUpPage.inputLastName_individual(lastname);
		// email
		String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String email = "automation" + date + "@yopmail.com";
		signUpPage.inputEmail_individual(email);
		// password
		String password = testHome.getSpecificUrl(
				"/Users/du/eclipse-workspace/SurveySaurus_Automation/SurveySaurus/src/SignUpDataset", 12);
		signUpPage.inputPassword_individual(password);
		// confirm password
		String confirmPassword = testHome.getSpecificUrl(
				"/Users/du/eclipse-workspace/SurveySaurus_Automation/SurveySaurus/src/SignUpDataset", 14);
		signUpPage.inputConfirmPassword_individual(confirmPassword);

		// click Create Account
		signUpPage.clickCreateAccountbtn();

		// check Assertion User can click on [Create Account] button, Create account
		// successful
		System.out.println("User can click on [Create Account] button, Create account successful");
		System.out.println(email);
		signUpPage.waitExpectedConditions_element_xpath("//*[@id=\"dialogContent_0\"]");
		// //signUpPage.checkAssertion_xpath("//*[@id=\"dialogContent_0\"]",
		// "Thank you for registering.\n" + "An email has been sent to email " + email +
		// ".\n"
		// + "Please check your email and active the account.");
		// Click OK
		signUpPage.waitExpectedConditions_element_xpath("/html/body/div[3]/md-dialog/section/div[2]/button");
		signUpPage.click_by_xpath("/html/body/div[3]/md-dialog/section/div[2]/button");
	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
