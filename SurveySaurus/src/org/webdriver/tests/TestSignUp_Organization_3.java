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
import org.webdriver.autorater.SignUpPage;
import org.webdriver.autorater.TestHome;

/**
 * @author du
 * 
 *         Check warning message is displayed if User leaves blank any required
 *         fields
 */
public class TestSignUp_Organization_3 {

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
	public void TestSignUp_organization_3() throws IOException, InterruptedException {
		// Home Page
		String url = testHome.getSpecificUrl("src/SignUpDataset", 1);
		testHome.navigatetoHomePage(url);

		// click SignUp btn
		String signup_url = testHome.getSpecificUrl("src/SignUpDataset", 3);
		homePage.clickSignUpbtn();
		homePage.waitExpectedConditions_url(signup_url);
		// click Organization btn
		signUpPage.waitExpectedConditions_element_xpath("/html/body/section/div/div/div/ul/li[2]/a");
		signUpPage.clickOrganizationbtn();
		// click Create Account
		signUpPage.clickCreateAccountbtn_organization();

		// Check Assertion
		System.out.println("Empty FirstName");
		signUpPage.checkAssertion_xpath("/html/body/section/div/div/form/div[1]/p", "Please enter your first name");

		System.out.println("Empty LastName");
		signUpPage.checkAssertion_xpath("/html/body/section/div/div/form/div[2]/p", "Please enter your last name");

		System.out.println("Empty Email");
		signUpPage.checkAssertion_xpath("/html/body/section/div/div/form/div[3]/p[1]", "Please enter your email");

		System.out.println("Empty Password");
		signUpPage.checkAssertion_xpath("/html/body/section/div/div/form/div[4]/p[2]", "Please enter your password");

		System.out.println("Empty Confirm Password");
		signUpPage.checkAssertion_xpath("/html/body/section/div/div/form/div[5]/p[1]",
				"Please enter your confirm password");

		System.out.println("Empty Company Name");
		signUpPage.checkAssertion_xpath("/html/body/section/div/div/form/div[6]/div[1]/p",
				"Please enter your organization name");
		System.out.println("Empty Phone Number");
		signUpPage.checkAssertion_xpath("/html/body/section/div/div/form/div[6]/div[2]/p",
				"Please enter your organization phone number");
		System.out.println("Empty Address");
		signUpPage.checkAssertion_xpath("/html/body/section/div/div/form/div[6]/div[3]/p",
				"Please enter your organization address");
		System.out.println("Empty City");
		signUpPage.checkAssertion_xpath("/html/body/section/div/div/form/div[6]/div[4]/p",
				"Please enter your organization city");
		System.out.println("Empty Zip Code");
		signUpPage.checkAssertion_xpath("/html/body/section/div/div/form/div[6]/div[5]/p",
				"Please enter your organization zipcode");
		System.out.println("Empty Zip Code");
		signUpPage.checkAssertion_xpath("/html/body/section/div/div/form/div[6]/div[7]/p",
				"Please enter your organization state");
	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
