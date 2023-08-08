package com.haldiramram.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.haldiram.base.BaseClass;

public class CustomerAccount extends BaseClass {
	
	public CustomerAccount(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//*[@class='action create primary']")private WebElement createAccount;
	
	
	public CustomerAccount clickOnCustomerAccount() {
		click(createAccount);
		System.out.println("clcick on customer Account");
		return this;
	}

}
