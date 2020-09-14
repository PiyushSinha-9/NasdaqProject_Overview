package com.qa;



import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BaseTest {

	protected static AppiumDriver<MobileElement> driver;
	protected static Properties props;
	protected static HashMap<String, String> strings = new  HashMap<String, String>();
	protected static String dateTime;
	protected static String platform;
	
	InputStream stringsis;
	InputStream inputStream;
	
	TestUtils utils;
	
	// constructor
	
	
	// Page factory Elements
	public BaseTest() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	@BeforeMethod
	public void beforeMethod() {
		//((CanRecordScreen) getDriver()).startRecordingScreen();
	}
	
	
	//stop video capturing and create *.mp4 file
		@AfterMethod
		public void afterMethod(ITestResult result) {
//			String media = ((CanRecordScreen) getDriver()).stopRecordingScreen();
//			
//			
//			
//			if(result.getStatus()==2) {
//				Map <String, String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();		
//				String dirPath = "videos" + File.separator + params.get("platformName") + "_" + params.get("deviceName") 
//				+ File.separator + getDateTime() + File.separator + result.getTestClass().getRealClass().getSimpleName();
//				
//				File videoDir = new File(dirPath);
//				
//				synchronized(videoDir){
//					if(!videoDir.exists()) {
//						videoDir.mkdirs();
//					}	
//				}
//				FileOutputStream stream = null;
//				try {
//					stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
//					stream.write(Base64.decodeBase64(media));
////					stream.close();
////					utils.log().info("video path: " + videoDir + File.separator + result.getName() + ".mp4");
//				} catch (Exception e) {
////					utils.log().error("error during video capture" + e.toString());
//					e.printStackTrace();
//				}
//			}
//			
				
		}
	
//	//stop video capturing and create *.mp4 file
//	@AfterMethod
//	public synchronized void afterMethod(ITestResult result) throws Exception {
//		String media = ((CanRecordScreen) getDriver()).stopRecordingScreen();
//		
//		
//		
//		if(result.getStatus()==2) {
//			
//		}
//		
//		
//		Map <String, String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();		
//		String dirPath = "videos" + File.separator + params.get("platformName") + "_" + params.get("deviceName") 
//		+ File.separator + getDateTime() + File.separator + result.getTestClass().getRealClass().getSimpleName();
//		
//		File videoDir = new File(dirPath);
//		
//		synchronized(videoDir){
//			if(!videoDir.exists()) {
//				videoDir.mkdirs();
//			}	
//		}
//		FileOutputStream stream = null;
//		try {
//			stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
//			stream.write(Base64.decodeBase64(media));
////			stream.close();
////			utils.log().info("video path: " + videoDir + File.separator + result.getName() + ".mp4");
//		} catch (Exception e) {
////			utils.log().error("error during video capture" + e.toString());
//			e.printStackTrace();
//		}
////		finally {
////			if(stream != null) {
////				stream.close();
////			}
////		}		
//	}


	@Parameters({"platformName","udid","deviceName","platformVersion"})  
	@BeforeTest
	public void beforeTest(String platformName,String udid, String deviceName,String platformVersion) throws Exception {
		utils = new TestUtils();
		dateTime=utils.dateTime();
		platform = platformName;
		URL url;
		try {

			props = new Properties();
			String propFileName= "config.properties";
			String xmlFileName="strings/strings.xml";
			
			
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);		 
			props.load(inputStream);
			DesiredCapabilities cap= new DesiredCapabilities();
			
			
			stringsis =getClass().getClassLoader().getResourceAsStream(xmlFileName);
			strings = utils.parseStringXML(stringsis);
			
			cap.setCapability("deviceName", deviceName);
			cap.setCapability("platformVersion", platformVersion);
			cap.setCapability("platformName",  platformName);
			
//			cap.setCapability("deviceName", deviceName);
//			cap.setCapability("platformVersion", platformVersion);
//			cap.setCapability("platformName", platformName);
			switch(platformName) {
			case "iOS":
				cap.setCapability("udid",udid);
				cap.setCapability("automationName",props.getProperty("IOSAutomationName"));
				cap.setCapability("bundleId", props.getProperty("IOSBundleId"));
				
				
//				Using it while working on .app, .apk file.
//				URL appURL= getClass().getClassLoader().getResource(props.getProperty("IOSAppLocation"));
//				String appURL= getClass().getResource(props.getProperty("IOSAppLocation")).getFile();
//				cap.setCapability("app",appURL);
				
				
				url = new URL(props.getProperty("appiumURL"));
				driver= new IOSDriver<MobileElement>(url, cap);
				break;
				
			// For Future Expansion
			case "Android":
				cap.setCapability("udid","7b20d9c8");
				cap.setCapability("automationName","UiAutomator2");
				
				cap.setCapability("appActivity", "com.nasdaq.irinsight.IRInsight");
				cap.setCapability("appPackage", "com.nasdaq.irinsight");
			
//				cap.setCapability("appActivity", "com.google.android.apps.gsa.assistant.handoff.BrowserReturnActivity");
//				cap.setCapability("appPackage", "com.google.android.googlequicksearchbox");
//				
				
//				cap.setCapability("appActivity", "com.mozilla.gecko.LauncherActivity");
//				cap.setCapability("appPackage", "com.mozilla.firefox");
				
//				cap.setCapability(MobileCapabilityType.BROWSER_NAME, "FireFox");
					
//				Using it while working on .app, .apk file.
//				String androidAppURL= getClass().getResource(props.getProperty("AndroidAppLocation")).getFile();
//				cap.setCapability("app",androidAppURL);

				url = new URL(props.getProperty("appiumURL"));
				driver= new AndroidDriver<MobileElement>(url, cap);
				break;
			default:
				throw new Exception("Platform Name is invalid!! - "+ platformName);
			}
		}

		catch(Exception exp) {
			System.out.println("Cause is : "+exp.getCause());
			System.out.println("Message is : "+exp.getMessage());
			//			exp.printStackTrace();
		}
		finally {
			if(inputStream != null) {
				inputStream.close();
			}
			if(stringsis != null) {
				stringsis.close();
			}
		}



	}
	
	public String getDateTime() {
		return dateTime;
	}
	
	
	public AppiumDriver getDriver() {
		return driver;
	}
	
	
	public void waitForVisibility(MobileElement e) {
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void clear(MobileElement e) {
		waitForVisibility(e);
		e.clear();
	}
	
	public void click(MobileElement e) {
		waitForVisibility(e);
		e.click();
	}
	
	public void sendKeys(MobileElement e,String txt)
	{
		waitForVisibility(e);
		e.sendKeys(txt);
	}

	
	public String getAttribute(MobileElement e, String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);
	}
	
	
	public String randomNumber() {
		Random r = new Random();
		int low = 1000;
		int high = 9999;
		int result = r.nextInt(high-low) + low;
		return Integer.toString(result); 
	}
	
	public void CloseApp() {
		((InteractsWithApps)driver).closeApp();
	}
	
	public void LaunchApp() {
		((InteractsWithApps)driver).launchApp();
	}
	
	
	
	public static void scrollup() {
		Dimension dim = driver.manage().window().getSize();
		
		
		int scrollStart = (int)(dim.getHeight()*0.5);
		int scrollEnd = (int)(dim.getHeight()*0.8);
		
		new TouchAction((PerformsTouchActions)driver).press(PointOption.point(0,scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption
				.point(0, scrollEnd)).release().perform();
		
		
	}
	
	
	

	@AfterTest
	public void afterTest() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
}
