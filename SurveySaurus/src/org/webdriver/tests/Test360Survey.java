/**
 * 
 */
package org.webdriver.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.webdriver.autorater.Survey360RaterPage;
import org.webdriver.autorater.TestAutorater;

/**
 * @author du
 *
 */
public class Test360Survey {

	WebDriver driver;
	TestAutorater testAutorater360Survey;
	Survey360RaterPage raterPage360Survey;

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
		testAutorater360Survey = new TestAutorater(driver);
		raterPage360Survey = new Survey360RaterPage(driver);

	}

	@Test
	public void Survey360Template_1() throws InterruptedException, IOException {
		String file = "/Users/du/eclipse-workspace/SurveySaurus_Automation/SurveySaurus/src/url";
		// numberOfTest number of test using get specific Url in File
		for (int numberOfTest = 0; numberOfTest <= 19; numberOfTest++) {
			String url = testAutorater360Survey.getSpecificUrl(file, numberOfTest);
			testAutorater360Survey.navigateto360RaterPage(url);

			// Question 1-50
			for (int question = 1; question <= 50; question++) {
				Random rand = new Random();
				int min = 1;
				int max = 7;
				int randomNum = rand.nextInt((max - min) + 1) + min;
				int question_id = 0;
				if (question < 6) {
					question_id = question + 1;
				}
				if (question >= 6 && question <= 10) {
					question_id = question + 2;
				}
				if (question >= 11 && question <= 15) {
					question_id = question + 3;
				}
				if (question >= 16 && question <= 20) {
					question_id = question + 4;
				}
				if (question >= 21 && question <= 25) {
					question_id = question + 5;
				}
				if (question >= 26 && question <= 30) {
					question_id = question + 6;
				}
				if (question >= 31 && question <= 35) {
					question_id = question + 7;
				}
				if (question >= 36 && question <= 40) {
					question_id = question + 8;
				}
				if (question >= 41 && question <= 45) {
					question_id = question + 9;
				}
				if (question >= 46 && question <= 50) {
					question_id = question + 10;
				}
				String locator = "/html/body/section/div/div/div[1]/div/div[" + question_id + "]/div[" + randomNum
						+ "]/label/span";
				raterPage360Survey.clickCheckbox(locator);
			}
			// click Submit btn
			raterPage360Survey.clickSubmitAnswerstbn();

		}
	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
