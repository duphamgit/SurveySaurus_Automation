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
 *         Check warning message is displayed if User input existed email fields
 */
public class TestSignUp_Organization_4 {

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
	public void testSignUp_organization_4() throws IOException, InterruptedException {
		// Home Page
		String url = testHome.getSpecificUrl("src/SignUpDataset", 1);
		testHome.navigatetoHomePage(url);

		// click SignUp btn
		String signup_url = testHome.getSpecificUrl("src/SignUpDataset", 3);
		homePage.clickSignUpbtn();
		homePage.waitExpectedConditions_url(signup_url);
		// click organization btn
		signUpPage.waitExpectedConditions_element_xpath("/html/body/section/div/div/div/ul/li[2]/a");
		signUpPage.clickOrganizationbtn();

		// input existed email into [Email] and valid value into other fields
		// firstname
		String firstname = testHome.getSpecificUrl("src/SignUpDataset", 33);
		signUpPage.inputFirstName_individual(firstname);
		// lastname
		String lastname = testHome.getSpecificUrl("src/SignUpDataset", 35);
		signUpPage.inputLastName_individual(lastname);
		// email
		String email = testHome.getSpecificUrl("src/SignUpDataset", 37);
		signUpPage.inputEmail_individual(email);
		// password
		String password = testHome.getSpecificUrl("src/SignUpDataset", 39);
		signUpPage.inputPassword_individual(password);
		// confirm password
		String confirmPassword = testHome.getSpecificUrl("src/SignUpDataset", 41);
		signUpPage.inputConfirmPassword_individual(confirmPassword);
		// company name
		String companyname = testHome.getSpecificUrl("src/SignUpDataset", 43);
		signUpPage.inputCompanyName_organization(companyname);

		// phone number
		String phonenumber = testHome.getSpecificUrl("src/SignUpDataset", 45);
		signUpPage.inputPhoneNumber_organization(phonenumber);

		// address
		String address = testHome.getSpecificUrl("src/SignUpDataset", 47);
		signUpPage.inputAddress_organization(address);
		// city
		String city = testHome.getSpecificUrl("src/SignUpDataset", 49);
		signUpPage.inputCity_organization(city);
		// zip code
		String zipcode = testHome.getSpecificUrl("src/SignUpDataset", 51);
		signUpPage.inputZipCode_organization(zipcode);

		// state
		String state = testHome.getSpecificUrl("src/SignUpDataset", 53);
		signUpPage.inputState_organization(state);

		// click Create Account
		signUpPage.clickCreateAccountbtn_organization();

		// check Assertion
		System.out.println("Check warning message is displayed if User input existed email");
		signUpPage.waitExpectedConditions_element_xpath("/html/body/section/div/div/form/p");
		signUpPage.checkAssertion_xpath("/html/body/section/div/div/form/p",
				"Email has already been taken. You might have already created an account with this email. Please check your email to active your account.");
	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
