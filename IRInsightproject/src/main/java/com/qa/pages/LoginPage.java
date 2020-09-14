package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;


import com.qa.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LoginPage extends BaseTest{
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"Nasdaq Sign in\"]/XCUIElementTypeTextField")
	@AndroidFindBy  (xpath = "(//android.widget.EditText[1])[1]")
	private MobileElement signup;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"Nasdaq Sign in\"]/XCUIElementTypeSecureTextField") 
	@AndroidFindBy  (xpath = "//android.widget.EditText[2]")
	private MobileElement password;
	
	@iOSXCUITFindBy (xpath = "/XCUIElementTypeButton[@name=\"Sign In\"]")
	@AndroidFindBy  (xpath = "//android.view.View[4]/android.widget.Button")
	private MobileElement signin;
	
	@iOSXCUITFindBy (xpath = "/XCUIElementTypeButton[@name=\"Sign In\"]")
	@AndroidFindBy  (xpath = "//android.widget.EditText[2]/following-sibling::*[1]/child::*[1]/child::*[1]/child::*[1]")
	private MobileElement rememberMe;

//	
//	519 902   519 666
//	
//	loginButtonsPanel			499 643
	
	
	
	public LoginPage enterUserName(String username) {
		click(signup);
		sendKeys(signup, username);
		return this;
	}
	
	public LoginPage enterPassword(String pass) {
		click(password);
		sendKeys(password, pass);
		return this;
	}
	
	
	public LoginPage pressRemeberMe() {
		click(rememberMe);
		return this;
	}
	
	
	public TouchAction t = new TouchAction(driver);
	
	public StartingPage pressLoginButton() throws Exception {
		//t.press(PointOption.point(191, 243)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(191,110)).release().perform();
//		MobileElement check123= (MobileElement) driver.findElementByAccessibilityId("Sign in");
//		Thread.sleep(3000);
//		check123.click();
//		click(signin);
//		System.out.println("deekiyo bhai zara");
//		return new OverviewPage();
//		Thread.sleep(3000);
//		TouchAction action = new TouchAction(driver);
//		driver= (AppiumDriver<MobileElement>) driver;
//		MobileElement check123=((MobileElement)driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Sign In']")));
//		action.perform();
		
		Thread.sleep(6000);
		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(157, 363)).perform();
		
		
//		click(signin);
		
		return new StartingPage(); 
	}
	
	
}