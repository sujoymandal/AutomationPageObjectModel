package com.PageObjectModel.TestCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.PageObjectModel.Base.BasePage;
import com.PageObjectModel.Utilities.ExcelReader;

public class OperationTest extends BasePage{

	@Test
	public void gotoOperational(){
		
		if (!ExcelReader.getCellData("Test Suite", "Operational").equals("Y")
				|| !ExcelReader.getCellData("Operational", "gotoOperational").equals("Y")) {

			throw new SkipException("Skipping the test " + "gotoOperational".toUpperCase() + "as the Run mode is NO");
		}

		initialization();
		testExecution("gotoOperational");
		tearDown();

	}
	
}
