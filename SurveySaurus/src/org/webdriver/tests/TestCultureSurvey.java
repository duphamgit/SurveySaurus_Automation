/**
 * 
 */
package org.webdriver.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.webdriver.autorater.CultureSurveyRaterPage;
import org.webdriver.autorater.TestAutorater;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author du
 *
 */
public class TestCultureSurvey {

	WebDriver driver;
	TestAutorater testAutoraterCultureSurvey;
	CultureSurveyRaterPage raterPageCultureSurvey;

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
		testAutoraterCultureSurvey = new TestAutorater(driver);
		raterPageCultureSurvey = new CultureSurveyRaterPage(driver);
	}

	@Test
	public void testCultureSurvey_1() throws InterruptedException, IOException {
		String file = "/Users/du/eclipse-workspace/SurveySaurus_Automation/SurveySaurus/src/url";
		// numberOfTest number of test using get specific Url in File
		for (int numberOfTest = 0; numberOfTest <= 19; numberOfTest++) {
			String url = testAutoraterCultureSurvey.getSpecificUrl(file, numberOfTest);
			testAutoraterCultureSurvey.navigatetoCultureRaterPage(url);

			// question 1-6
			for (int i = 1; i <= 6; i++) {
				raterPageCultureSurvey.testListBox(i);
			}
			// question 7 - 84
			for (int part = 1; part <= 14; part++) {
				if (part == 1) {
					for (int i = 7; i <= 11; i++) {
						raterPageCultureSurvey.testSelectAnswerChoice(part, i);
					}
				}
				if (part == 2) {
					for (int i = 12; i <= 18; i++) {
						raterPageCultureSurvey.testSelectAnswerChoice(part, i);
					}
				}
				if (part == 3) {
					for (int i = 19; i <= 26; i++) {
						raterPageCultureSurvey.testSelectAnswerChoice(part, i);
					}
				}
				if (part == 4) {
					for (int i = 27; i <= 32; i++) {
						raterPageCultureSurvey.testSelectAnswerChoice(part, i);
					}
				}
				if (part == 5) {
					for (int i = 33; i <= 39; i++) {
						raterPageCultureSurvey.testSelectAnswerChoice(part, i);
					}
				}
				if (part == 6) {
					for (int i = 40; i <= 43; i++) {
						raterPageCultureSurvey.testSelectAnswerChoice(part, i);
					}
				}
				if (part == 7) {
					for (int i = 44; i <= 49; i++) {
						raterPageCultureSurvey.testSelectAnswerChoice(part, i);
					}
				}
				if (part == 8) {
					for (int i = 50; i <= 53; i++) {
						raterPageCultureSurvey.testSelectAnswerChoice(part, i);
					}
				}
				if (part == 9) {
					for (int i = 54; i <= 57; i++) {
						raterPageCultureSurvey.testSelectAnswerChoice(part, i);
					}
				}
				if (part == 10) {
					for (int i = 58; i <= 62; i++) {
						raterPageCultureSurvey.testSelectAnswerChoice(part, i);
					}
				}
				if (part == 11) {
					for (int i = 63; i <= 69; i++) {
						raterPageCultureSurvey.testSelectAnswerChoice(part, i);
					}
				}
				if (part == 12) {
					for (int i = 70; i <= 74; i++) {
						raterPageCultureSurvey.testSelectAnswerChoice(part, i);
					}
				}
				if (part == 13) {
					for (int i = 75; i <= 79; i++) {
						raterPageCultureSurvey.testSelectAnswerChoice(part, i);
					}
				}
				if (part == 14) {
					for (int i = 80; i <= 84; i++) {
						raterPageCultureSurvey.testSelectAnswerChoice(part, i);
					}
				}
			}

			// Click Submit btn
			raterPageCultureSurvey.clickSubmitAnswerstbn();
		}

	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
