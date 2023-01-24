/**
 * 
 */
package com.ecommerce.utility;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


/**
 * @author Admin
 *
 */
public class Listner extends ExtentManager implements ITestListener{
	
	
	
	@Override
	public void onStart(ITestContext context) {
		
		Log.info("Test Class  :"+context.getName().getClass());
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		Log.info("onTestStart");
		test=report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS);
		test.log(Status.PASS, MarkupHelper.createLabel("Test case Passed  "+result.getMethod().getMethodName(), ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if(result.getStatus()==ITestResult.SKIP);
		test.log(Status.PASS, MarkupHelper.createLabel("Test case Passed  "+result.getMethod().getMethodName(), ExtentColor.YELLOW));
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		endExtent();
		
	}

}
