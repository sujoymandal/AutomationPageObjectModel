package com.PageObjectModel.TestCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.PageObjectModel.Base.BasePage;
import com.PageObjectModel.Utilities.ExcelReader;

public class VoyageTest extends BasePage{
	
	
	
	@Test
	public void gotoVeselMaster(){
		
		if (!ExcelReader.getCellData("Test Suite", "Voyage").equals("Y")
				|| !ExcelReader.getCellData("Voyage", "Vessel Master").equals("Y")) {

			throw new SkipException("Skipping the test " + "gotoVeselMaster".toUpperCase() + "as the Run mode is NO");
		}

		initialization();
		testExecution("Vessel Master");
		//tearDown();

	}

}
