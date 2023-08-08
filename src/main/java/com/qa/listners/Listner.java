package com.qa.listners;

import java.io.IOException;
import java.util.Date;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listner implements ITestListener, ISuiteListener{
	
	static Date d = new Date();
	
	static String fileName  = "Extent_"+ d.toString().replace(":", "_").replace(" ", "_")+".html";
	
	private static ExtentReports extent =ExtendReportListner.createInstance(".\\extentReports\\"+fileName);
	
	public static ExtentTest test;
	
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName()+"\n"+"@Test Case : "+result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logTest = "<1>"+" TEST CASE "+methodName.toUpperCase() +" - PASSED "+"<1>";
		com.aventstack.extentreports.markuputils.Markup m= MarkupHelper.createLabel(logTest, ExtentColor.GREEN);
		test.pass(m);
	}
	
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable().getMessage());
		try {
			ExtendReportListner.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String methodName =result.getMethod().getMethodName();
		String logTest = "<1>"+" TEST CASE "+methodName.toUpperCase() +" - FAILED "+"<1>";
		com.aventstack.extentreports.markuputils.Markup m= MarkupHelper.createLabel(logTest, ExtentColor.RED);
		test.log(Status.FAIL, m);
		
	}
	
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logTest = "<1>"+" TEST CASE "+methodName.toUpperCase() +" - Skipped "+"<1>";
		com.aventstack.extentreports.markuputils.Markup m= MarkupHelper.createLabel(logTest, ExtentColor.YELLOW);
		test.pass(m);
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	

}
