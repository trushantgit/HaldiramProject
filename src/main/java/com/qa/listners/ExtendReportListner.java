package com.qa.listners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.haldiram.base.BaseClass;

;

public class ExtendReportListner {
	
	private static ExtentReports extent;
	public static String fileName ;
	
	public static ExtentReports createInstance(String filename) {
		
		ExtentSparkReporter report = new ExtentSparkReporter(filename);
		report.config().setTheme(Theme.STANDARD);
		report.config().setDocumentTitle(filename);
		report.config().setEncoding("utf-8");
		report.config().setReportName(filename);
		report.config().setTimeStampFormat("EEEE,MMMM dd,yyyy,hh:mm a'('zzz')'");
		
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Organization", "TrushantCoder");
		extent.setSystemInfo("project", "Haldiram");
		extent.setSystemInfo("Enviroment", "Live");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("publish Date", "Jan2023");
		extent.setSystemInfo("Test run", "Publish");
		extent.setSystemInfo("Automation Tester", "Trushant");
		
		return extent;
		
	}
	
	public static void captureScreenshot() throws IOException  {
		
		Date d= new Date();
		fileName =d.toString().replace(":", "_").replace(" ", "_")+".png";
		File screenshot =((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//Screenshot//"+fileName));
	}

}
