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
 *         Check warning message is displayed if User leaves blank any required
 *         fields
 */
public class TestSignUp_2 {

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
	public void testSignUp_2() throws IOException, InterruptedException {
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
		// click Create Account
		signUpPage.clickCreateAccountbtn_individual();

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
	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
