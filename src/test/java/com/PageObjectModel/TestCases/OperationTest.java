package com.PageObjectModel.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.PageObjectModel.Base.BasePage;

public class OperationTest extends BasePage{

	@Test
	public void gotoOperational() throws Exception{
		
//		if (!ExcelReader.getCellData("Test Suite", "Operational").equals("Y")
//				|| !ExcelReader.getCellData("Operational", "gotoOperational").equals("Y")) {
//
//			throw new SkipException("Skipping the test " + "gotoOperational".toUpperCase() + "as the Run mode is NO");
//		}

//		Operational	xpath	//*[text()='Operational']	Move
//		Contract	xpath	//*[text()='Contract']	Move
//		Contract Search	xpath	//a[text()='Contract Search']	click
//		Window	window	NA	switch
//		Contact	id	txtContractNo	sendKeys

		//change for check
		initialization();
		
		Thread.sleep(3000);
		WebElement Operational=driver.findElement(By.xpath("//*[text()='Operational']"));
		moveToElement(Operational);
		Thread.sleep(3000);
		WebElement Contract=driver.findElement(By.xpath("//*[text()='Contract']"));
		moveToElement(Contract);
		Thread.sleep(3000);
		WebElement ContratSearch =driver.findElement(By.xpath("//a[text()='Contract Search']"));
		clickOnElement(ContratSearch);
		
		tearDown();

	}
	
}
