/**
 * 
 */
package org.webdriver.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
public class TestSignUp_3 {

	WebDriver driver;
	TestHome testHome;
	SignUpPage signUpPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() throws IOException {
		/// Config Geckodriver
		String file_geckodriver_config = "src/GeckodriverConfig";
		String geckodriver = "webdriver.gecko.driver";
		String environment_geckodriver = Files.readAllLines(Paths.get(file_geckodriver_config)).get(3);
		// Edit in GeckodriverConfig at line 3:
		// Mac: src/geckodriver
		// Windows: src/geckodriver.exe
		System.setProperty(geckodriver, environment_geckodriver);
		driver = new FirefoxDriver();
		testHome = new TestHome(driver);
		signUpPage = new SignUpPage(driver);
		homePage = new HomePage(driver);
	}

	@Test
	public void testSignUp_3() throws IOException, InterruptedException {
		// Home Page
		String url = testHome.getSpecificUrl("src/SignUpDataset", 1);
		testHome.navigatetoHomePage(url);

		// click SignUp btn
		String signup_url = testHome.getSpecificUrl("src/SignUpDataset", 3);
		homePage.clickSignUpbtn();
		homePage.waitExpectedConditions_url(signup_url);
		// click individual btn
		signUpPage.waitExpectedConditions_element_xpath("/html/body/section/div/div/div/ul/li[1]/a");
		signUpPage.clickIndividualbtn();

		// input existed email into [Email] and valid value into other fields
		// firstname
		String firstname = testHome.getSpecificUrl("src/SignUpDataset", 6);
		signUpPage.inputFirstName_individual(firstname);
		// lastname
		String lastname = testHome.getSpecificUrl("src/SignUpDataset", 8);
		signUpPage.inputLastName_individual(lastname);
		// email
		String email = testHome.getSpecificUrl("src/SignUpDataset", 10);
		signUpPage.inputEmail_individual(email);
		// password
		String password = testHome.getSpecificUrl("src/SignUpDataset", 12);
		signUpPage.inputPassword_individual(password);
		// confirm password
		String confirmPassword = testHome.getSpecificUrl("src/SignUpDataset", 14);
		signUpPage.inputConfirmPassword_individual(confirmPassword);

		// click Create Account
		signUpPage.clickCreateAccountbtn_individual();

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
