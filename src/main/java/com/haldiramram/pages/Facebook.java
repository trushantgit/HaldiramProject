package com.haldiramram.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.haldiram.base.BaseClass;

public class Facebook extends BaseClass {
	
	public Facebook(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="email")private WebElement email;
	@FindBy(id="pass")private WebElement password;
	@FindBy(xpath="//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selectedd _51sy']")private WebElement newAcount;
	@FindBy(id="loginbutton")private WebElement login;
	@FindBy(xpath="//*[@class='_9ay7']")private WebElement Message;
	

	
	
	
	public Facebook enteremail() {
		sendkeys(email, "trushant");
		System.out.println("enter email");
		log.info("enter emailid");
		return this;
	}
	
	public Facebook enterPassword() {
		sendkeys(password,"8805208277");
		System.out.println("enter password");
		log.info("enter password");
		return this;
	}
	
	public Facebook clickOnCreateAcount() {
		click(newAcount);
		System.out.println("click on new Acount button");
		log.info("click on create acount button");
		return this;	
	}
	


}
