package com.PageObjectModel.TestCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.PageObjectModel.Base.BasePage;
import com.PageObjectModel.Pages.ContactsPage;
import com.PageObjectModel.Utilities.ExcelReader;

public class ContactPageTest extends BasePage {

	@Test
	public void test_createNewContact() {

		if (!ExcelReader.getCellData("Test Suite", "ContactPageTest").equals("Y")
				|| !ExcelReader.getCellData("ContactPageTest", "test_createNewContact").equals("Y")) {

			throw new SkipException("Skipping the test " + "test_login".toUpperCase() + "as the Run mode is NO");
		}

		initialization();
		testExecution("createContact");
		tearDown();
	}

}
