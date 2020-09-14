package com.qa.pages;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SideMenu extends BaseTest{
	
	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeStaticText[@name=\"RESEARCH\"])[1]")
	@AndroidFindBy  (xpath = "/XCUIElementTypeButton[@name=\"Sign In\"]")
	private MobileElement ResearchButton;
	
	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeStaticText[@name=\"INVESTORS\"])[1]")
	@AndroidFindBy  (xpath = "//android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.ListView[1]/android.view.View[7]/android.view.View")
	private MobileElement InvestorsButton;
	
	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeStaticText[@name=\"LOG OUT\"])[1]")
	@AndroidFindBy  (xpath = "//android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.ListView[1]/android.view.View[7]/android.view.View")
	private MobileElement LogoutButton;
	
	public InvestorsPage pressInvestorsButton() {
		click(InvestorsButton);
		return new InvestorsPage();
	}
	
	public StartingPage pressLogoutButton() {
		click(LogoutButton);
		return new StartingPage();
	}
	
	
}
