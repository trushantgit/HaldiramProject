package com.qa.test;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.haldiram.base.BaseClass;
import com.haldiramram.pages.CreateAccount;
import com.haldiramram.pages.CustomerAccount;
import com.haldiramram.pages.Facebook;
import com.haldiramram.pages.Home;


public class FacebookTest extends BaseClass {
	
	public static WebDriver driver;
	public static Home home;
	public static Facebook fb;
	
	
	
	@BeforeMethod
	public void beforeMethod(Method m) throws Exception {
		driver=setup("urlFB");
		System.out.println("******Starting test"+m.getName()+"*****");
	}
	
	@Test
	public void createAccout() {
		home = new Home(driver);
		fb= new Facebook(driver);
		fb.enteremail();
		fb.enterPassword();
		fb.clickOnCreateAcount();
	
	}
	
	@AfterMethod
	public void afterMethod() {
	    teardown();
	    log.info("test is completed");
	}

}
