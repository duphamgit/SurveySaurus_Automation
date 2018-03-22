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
import org.webdriver.autorater.ForgotPasswordPage;
import org.webdriver.autorater.HomePage;
import org.webdriver.autorater.TestHome;

/**
 * @author du
 *
 *         Check warning message is displayed if User leave blank [Email] field
 */
public class TestForgotPassword_2 {

	WebDriver driver;
	TestHome testHome;
	HomePage homePage;
	ForgotPasswordPage forgotPasswordPage;

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
		homePage = new HomePage(driver);
		forgotPasswordPage = new ForgotPasswordPage(driver);
	}

	@Test

	public void testForgotPassword_2() throws IOException, InterruptedException {
		String url = testHome.getSpecificUrl("src/ForgotPasswordDataset", 1);
		testHome.navigatetoHomePage(url);

		// click Forgot Password btn
		testHome.waitExpectedConditions_element_xpath("/html/body/section/section/div/form/div[3]/a");
		homePage.clickForgotPasswordbtn();
		// click SUBMIT btn
		forgotPasswordPage.clickSubmitbtn();
		// Check warning message is displayed if User leave blank [Email] field
		System.out.println("Empty Email");
		forgotPasswordPage.checkAssertion_xpath("/html/body/section/section/div/form/p[1]", "Please enter your email");
	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
