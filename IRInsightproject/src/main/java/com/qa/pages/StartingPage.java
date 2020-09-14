package com.qa.pages;

import java.time.Duration;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class StartingPage extends BaseTest{
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[31]/child::*[1]/child::*[1]/child::*[1]")
	@AndroidFindBy  (xpath = "//android.view.View/android.view.View[23]/android.view.View[1]/android.view.View/android.view.View[1]")
	private MobileElement data1;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[32]/child::*[1]/child::*[1]/child::*[1]")
	@AndroidFindBy  (xpath = "//android.view.View/android.view.View[23]/android.view.View[2]/android.view.View/android.view.View[1]")
	private MobileElement data2;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[33]/child::*[1]/child::*[1]/child::*[1]")
	@AndroidFindBy  (xpath = "//android.view.View/android.view.View[23]/android.view.View[3]/android.view.View/android.view.View[1]")
	private MobileElement data3;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[34]/child::*[1]/child::*[1]/child::*[1]")
	@AndroidFindBy  (xpath = "//android.view.View/android.view.View[23]/android.view.View[4]/android.view.View/android.view.View[1]")
	private MobileElement data4;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[35]/child::*[1]/child::*[1]/child::*[1]")
	@AndroidFindBy  (xpath = "//android.view.View/android.view.View[23]/android.view.View[5]/android.view.View/android.view.View[1]")
	private MobileElement data5;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[36]/child::*[1]/child::*[1]/child::*[1]")
	@AndroidFindBy  (xpath = "//android.view.View/android.view.View[23]/android.view.View[6]/android.view.View/android.view.View[1]")
	private MobileElement data6;
	
	public SideMenu pressSideButton() throws Exception {
		
		
		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(20, 46)).perform();

//		TouchAction action = new TouchAction(driver);
//		action.tap(PointOption.point(53, 141)).perform();
		
		
		return new SideMenu(); 
	}
	
	
	public StartingPage reachEvents() throws Exception {
		
		Thread.sleep(3000);
		TouchAction t = new TouchAction(driver);
	
		for(int i=0;i<8;i++) {
			t.press(PointOption.point(203, 567)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(203,50)).release().perform();
		}
		return this; 
	}
	
	public StartingPage waitPageToLoad() throws Exception {
		
//		Thread.sleep(50000);
		Thread.sleep(35000);
		return this; 
	}
	
	public StartingPage fetchingData() throws Exception {

		Thread.sleep(3000);
		String d1 = data1.getAttribute("value");
		System.out.println(d1);
		String d2 = data2.getAttribute("value");
		System.out.println(d2);
		String d3 = data3.getAttribute("value");
		System.out.println(d3);
		String d4 = data4.getAttribute("value");
		System.out.println(d4);
		String d5 = data5.getAttribute("value");
		System.out.println(d5);
		String d6 = data6.getAttribute("value");
		System.out.println(d6);
		
//		Thread.sleep(3000);
//		String d1 = data1.getAttribute("text");
//		System.out.println(d1);
//		String d2 = data2.getAttribute("text");
//		System.out.println(d2);
//		String d3 = data3.getAttribute("text");
//		System.out.println(d3);
//		String d4 = data4.getAttribute("text");
//		System.out.println(d4);
//		String d5 = data5.getAttribute("text");
//		System.out.println(d5);
//		String d6 = data6.getAttribute("text");
//		System.out.println(d6);
//		
		return this;
	}
	
	
}
