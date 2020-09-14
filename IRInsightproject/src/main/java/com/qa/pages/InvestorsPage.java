package com.qa.pages;

import java.time.Duration;

import com.qa.BaseTest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class InvestorsPage extends BaseTest{
	
	
	public InvestorsPage scrollEvents() throws Exception {
		
		Thread.sleep(3000);
		TouchAction t = new TouchAction(driver);
	
		for(int i=0;i<2;i++) {
			t.press(PointOption.point(203, 567)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(203,50)).release().perform();
		}
		return this; 
	}
	
	
	public SideMenu pressSideButton() throws Exception {
		
		
		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(20, 46)).perform();

//		TouchAction action = new TouchAction(driver);
//		action.tap(PointOption.point(53, 141)).perform();
		
		
		return new SideMenu(); 
	}
	
}
