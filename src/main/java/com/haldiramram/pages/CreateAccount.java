package com.haldiramram.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.haldiram.base.BaseClass;

public class CreateAccount extends BaseClass {
	
	public CreateAccount(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="firstname")private WebElement firstName;
	@FindBy(id="lastname")private WebElement lastName;
	@FindBy(id="email_address")private WebElement emial;
	@FindBy(id="password")private WebElement password;
	@FindBy(id="password-confirmation")private WebElement confirmPassword;
	@FindBy(id="recaptcha-anchor")private WebElement captcha;
	@FindBy(xpath="(//*[@type='submit'])[3]")private WebElement createAccountbutton;
	
	
	
	public CreateAccount enterFirstName() {
		sendkeys(firstName, "Trushant");
		System.out.println("enter firstName");
		return this;
	}
	
	public CreateAccount enterLastName() {
		sendkeys(lastName, "Solat");
		System.out.println("enter lastName");
		return this;
	}
	
	public CreateAccount enterMailid() {
		sendkeys(emial, "trushantsolat29@gmail.com");
		System.out.println("enter email ID");
		return this;
	}
	
	public CreateAccount enterPassword() {
		sendkeys(password, "Trushant#1234");
		System.out.println("enter a password");
		return this;
	}
	
	public CreateAccount enterConfirmPassword() {
		sendkeys(confirmPassword, "Trushant#1234");
		System.out.println("enter confirmPassword");
		return this;
	}
	
	public CreateAccount clickOnCaptcha() {
		waitForVisibility(captcha);
		clearText(captcha);
		System.out.println("click on captcha ");
		return this;
	}
	
	public CreateAccount clickOnCreateAccountButton() {
		waitForVisibility(createAccountbutton);
		click(createAccountbutton);
		System.out.println("click on create Account button");
		return this;
	}

}
