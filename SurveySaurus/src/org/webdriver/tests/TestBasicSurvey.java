/**
 * 
 */
package org.webdriver.tests;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.webdriver.autorater.BasicSurveyRaterPage;
import org.webdriver.autorater.TestAutorater;

/**
 * @author du
 *
 */
public class TestBasicSurvey {

	WebDriver driver;
	TestAutorater testAutoraterBasicSurvey;
	BasicSurveyRaterPage raterPageBasicSurvey;

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		testAutoraterBasicSurvey = new TestAutorater(driver);
		raterPageBasicSurvey = new BasicSurveyRaterPage(driver);
	}

	@Test
	public void BasicSurveyTemplate_1() throws InterruptedException, IOException {
		String file = "/Users/du/eclipse-workspace/SurveySaurus/src/url";
		// numberOfTest number of test using get specific Url in File
		for (int numberOfTest = 0; numberOfTest <= 5000; numberOfTest++) {
			String url = testAutoraterBasicSurvey.getSpecificUrl(file, numberOfTest);
			testAutoraterBasicSurvey.navigatetoBasicRaterPage(url);

			// Question 1-6
			for (int question = 1; question <= 6; question++) {
				Random rand = new Random();
				int min = 1;
				int max = 5;
				int randomNum = rand.nextInt((max - min) + 1) + min;

				String locator = "/html/body/section/div/div/div[1]/div/div[" + question + "]/div[" + randomNum
						+ "]/label/span";
				raterPageBasicSurvey.clickCheckbox(locator);
			}
			// click Submit btn
			raterPageBasicSurvey.clickSubmitAnswerstbn();
		}
	}

	@AfterMethod
	public void end() {
		driver.close();
	}
}
