package com.qa.tests;

import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.BaseTest;
import com.qa.pages.InvestorsPage;
import com.qa.pages.LoginPage;
import com.qa.pages.SideMenu;
import com.qa.pages.StartingPage;

public class Scenario extends BaseTest{
	
	 @BeforeClass
	  public void beforeClass() throws Exception {
		  
		 
		  
	  }

	  @AfterClass
	  public void afterClass() {
		  
//		  CloseApp();
//		  LaunchApp();
		  
	  }
	  
	  @BeforeMethod
	  public void beforeMethod(Method m) {
		  loginPage = new LoginPage();
		  System.out.println("\n" + "******  Starting Test: "+ m.getName() + "\n");
		  
		  
//		  loginPage.enterUserName(loginUsers.getJSONObject("validUser").getString("username"));
//			loginPage.enterPassword(loginUsers.getJSONObject("validUser").getString("password"));
//			overviewPage=loginPage.pressLoginButton();
	  
	  
		  
	  
	  }

	  @AfterMethod
	  public void afterMethod() {
		  
//		  sideMenu=overviewPage.pressMenuButton();
//			loginPage=sideMenu.logout();
		  
	  }
	  
	
	LoginPage loginPage;
	StartingPage startingPage;
	SideMenu sideMenu;
	InvestorsPage investorsPage;
	
	@Test
	public void test3() throws Exception{
		
		Thread.sleep(10000);
		
		
		SoftAssert sa= new SoftAssert();
		
		String eventName= "Testing-"+randomNumber();
		
		System.out.println(eventName);
		loginPage.enterUserName("saby.automation11");
		loginPage.enterPassword("Nasdaq@11");
		//loginPage.pressRemeberMe();
		startingPage=loginPage.pressLoginButton();
		
		startingPage.waitPageToLoad();
		
		startingPage.reachEvents();
		
		startingPage.fetchingData();
		
		sideMenu=startingPage.pressSideButton();
		
		investorsPage=sideMenu.pressInvestorsButton();
		
		Thread.sleep(10000);
		investorsPage.scrollEvents();
		
		sideMenu=investorsPage.pressSideButton();
		
		startingPage=sideMenu.pressLogoutButton();
		
		Thread.sleep(4000);
		
	}
	
	
}
