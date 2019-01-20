package com.PageObjectModel.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.PageObjectModel.Base.BasePage;
import com.PageObjectModel.Utilities.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListener extends BasePage implements ITestListener{

	public void onFinish(ITestContext arg0) {
		
		System.out.println("Test completed!!!");
		
	}

	public void onStart(ITestContext arg0) {
		
		System.out.println("Test started !!!");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		TestUtil.captureScreenshot();
		test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+" Failed");
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		report.endTest(test);
		report.flush();
		
	}

	public void onTestSkipped(ITestResult arg0) {
		test.log(LogStatus.SKIP, arg0.getName().toUpperCase()+
				" Skipped the test as the Run mode is NO");
		report.endTest(test);
		report.flush();
		
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println(arg0.getName()+"   test started....");
		test=report.startTest(arg0.getName().toUpperCase());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println(arg0.getName()+"   test successfully completed....");
		test.log(LogStatus.PASS, arg0.getName().toUpperCase()+" Passed");
		report.endTest(test);
		report.flush();
	}

}
