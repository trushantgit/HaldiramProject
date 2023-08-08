package com.qa.test;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.haldiram.base.BaseClass;
import com.haldiramram.pages.CreateAccount;
import com.haldiramram.pages.CustomerAccount;
import com.haldiramram.pages.Home;


public class CreateAccountTest extends BaseClass {
	
	public static WebDriver driver;
	public static Home home;
	public static CustomerAccount custAcount;
	public static CreateAccount crtAcount;
	
	
	@BeforeMethod
	public void beforeMethod(Method m) throws Exception {
		driver=setup("url");
		System.out.println("******Starting test"+m.getName()+"*****");
	}
	
	@Test
	public void createAccout() {
		home = new Home(driver);
		custAcount = new CustomerAccount(driver);
		crtAcount = new CreateAccount(driver);
		
		home.clickOnCustomerAccount();
		custAcount.clickOnCustomerAccount();
		crtAcount.enterFirstName();
		crtAcount.enterLastName();
		crtAcount.enterMailid();
		crtAcount.enterPassword();
		crtAcount.enterConfirmPassword();
		switchToFrame(0);
		crtAcount.clickOnCaptcha();
	}
	
	@AfterMethod
	public void afterMethod() {
	    teardown();
	}

}
