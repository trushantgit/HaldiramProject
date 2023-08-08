package com.haldiram.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Return;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = Logger.getLogger(BaseClass.class);
	
	
	public  WebDriver setup(String url) throws Exception  {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties");
		prop.load(fis);
		log.info("config file is loaded");
		System.out.println(System.getProperty("user.dir"));
		
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome browser is opened");
			log.info("chrome browser is launched");
		}
		else if(browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("firefox browser is opened");
			log.info("firefox browser is launched");
		}
		else if(browsername.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("edge browser is opened");
			log.info("edge browser is launched");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty(url));
		log.info("launched URL");
		System.out.println("open url "+prop.getProperty(url));
		return driver;
	
	}
	
	public void waitForVisibility(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public void waitForClicckable(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(e));
	
	}
	
	public void click(WebElement e) {
		waitForVisibility(e);
		waitForClicckable(e);
		e.click();	
	}
	
	public void sendkeys(WebElement e, String text) {
		waitForVisibility(e);
		e.sendKeys(text);
	}
	
	public String clearText(WebElement e) {
		waitForVisibility(e);
		return e.getText();
	}
	
	public String getAttribute(WebElement e, String attribute ) {
		waitForVisibility(e);
		return e.getAttribute(attribute);	
	}
	
	public void acceptAlert() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("alert name "+ driver.switchTo().alert().getText());
		alert.accept();
		System.out.println("alert is accepted");
	}
	
	public void dismissAlert() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		Alert alert =wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("alert name "+driver.switchTo().alert().getText());
		alert.dismiss();
		System.out.println("alert is dismiss");
	}
	
	
	public void switchToFrame(int frmnum) {
		int totalframe = driver.findElements(By.tagName("iframe")).size();
		System.out.println("total no of frames  "+totalframe);
		driver.switchTo().frame(frmnum);
	}
	
	public void teardown() {
		driver.close();
	}

}
