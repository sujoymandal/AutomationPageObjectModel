package com.PageObjectModel.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.PageObjectModel.Base.BasePage;

public class TestUtil extends BasePage{
	
	//public static String screenshotPath;
	public static String screenshotName;
	
	public static void captureScreenshot(){
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		
		File destFile=new File(System.getProperty("user.dir")+
				"\\target\\surefire-reports\\html\\"+screenshotName);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
