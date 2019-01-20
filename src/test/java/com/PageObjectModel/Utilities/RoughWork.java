package com.PageObjectModel.Utilities;

import java.util.ArrayList;

import com.PageObjectModel.Base.BasePage;

public class RoughWork extends BasePage {

	public static void main(String[] args) throws Exception {

		ArrayList<String> data = new ArrayList<String>();
	String locatorType = null;
		String locatorValue = null;
		String action = null;
		String testData = null;
		int step=ExcelReader.getRowCount("test_login");
		System.out.println(step);
		for (int i = 1; i < step; i++) {
//
			data = ExcelReader.getLocator("test_login", i);
 locatorType=data.get(4).trim();
		locatorValue = data.get(1).trim();
 action=data.get(2).trim();
		testData = data.get(3).trim();
			System.out.println(data.get(0));
		}
		
		//System.out.println(ExcelReader.getRowCount("test_login"));
		
		//initialization();
		//testExecution("Vessel Master");
		
		//driver.findElement(By.xpath("(//*[text()='1600RT'])[2]")).click();
		//moveMouse(2);
		//driver.findElement(By.id("txtVesselOper")).sendKeys("sujoy");
		//rt.keyPress(KeyEvent.VK_DOWN);
		//dropDown.selectByValue("3200RT");
		//Select a=new Select(elt1);
		//a.selectByValue("3200RT");
		//elt1.sendKeys("3200RT");
		//Thread.sleep(4000);
		//driver.findElement(By.id("ddlVesselCat")).sendKeys("3200RT");
//		List<WebElement> opt=driver.findElements(By.id("ddlVesselCat"));
//		System.out.println(opt.size());
//		System.out.println(opt.toString());
		//Thread.sleep(3000);
		//WebElement elt2=driver.findElement(By.xpath("//*[text()='Inactive Vessel']"));
		//moveToElement(elt2);


	}

}
