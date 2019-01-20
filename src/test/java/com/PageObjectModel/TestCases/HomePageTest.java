package com.PageObjectModel.TestCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.PageObjectModel.Base.BasePage;
import com.PageObjectModel.Utilities.ExcelReader;

public class HomePageTest extends BasePage {

	@Test
	public void test_Logo() {

		if (!ExcelReader.getCellData("Test Suite", "HomePageTest").equals("Y")
				|| !ExcelReader.getCellData("HomePageTest", "CheckLogo").equals("Y")) {

			throw new SkipException("Skipping the test " + "CheckLogo".toUpperCase() + "as the Run mode is NO");
		}

		initialization();
		driver.switchTo().frame("mainpanel");
		testExecution("CheckLogo");
		Assert.assertTrue(elementPresent);
		tearDown();

	}

	@Test
	public void test_gotoContacts() {

		if (!ExcelReader.getCellData("Test Suite", "HomePageTest").equals("Y")
				|| !ExcelReader.getCellData("HomePageTest", "test_gotoContacts").equals("Y")) {

			throw new SkipException("Skipping the test " + "test_gotoContacts".toUpperCase() + "as the Run mode is NO");
		}

		initialization();
		driver.switchTo().frame("mainpanel");
		testExecution("gotoContacts");
		tearDown();
	}

}
