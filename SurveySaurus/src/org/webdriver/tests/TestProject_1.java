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
import org.webdriver.autorater.ProjectListPage;
import org.webdriver.autorater.TestHome;

/**
 * @author du
 *
 */
public class TestProject_1 {

	WebDriver driver;
	TestHome testHome;
	HomePage homePage;
	ProjectListPage projectListPage;

	@BeforeMethod
	public void setUp() {

		driver = new FirefoxDriver();
		testHome = new TestHome(driver);
		projectListPage = new ProjectListPage(driver);
		homePage = new HomePage(driver);
	}

	@Test

	public void testProject_1() throws IOException, InterruptedException {
		String url = testHome.getSpecificUrl("src/ProjectListDataset", 0);
		testHome.navigatetoHomePage(url);

		// Login
		// Input email & password
		String email = testHome.getSpecificUrl("src/ProjectListDataset", 3);
		String password = testHome.getSpecificUrl("src/ProjectListDataset", 5);
		homePage.inputEmail(email);
		homePage.inputPassword(password);

		// click Sign In btn
		homePage.clickSignInbtn();

		// check Url
		System.out.println(url + "project-list");
		projectListPage.waitExpectedConditions_url(url + "project-list");
		System.out.println(url + "project-list");
		projectListPage.checkAssertion_url(url + "project-list");
		// check GUI
		projectListPage.checkAssertion();
	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
