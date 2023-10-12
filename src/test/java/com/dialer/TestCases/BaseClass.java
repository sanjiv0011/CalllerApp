package com.dialer.TestCases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.SoftAssert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.MalformedURLException;
import java.net.URL;


import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.dialer.Utilities.ReadConfigFiles;
import com.github.javafaker.Faker;


public class BaseClass {
	//TESTNG SOFT ASSERTIONS
	public SoftAssert softAssert = new SoftAssert();
	
	//FAKER LIBRARY TO GENERATE RADOM DATA FOR THE TEST 
	public Faker faker = new Faker();
	
	//TO LOG THE MESSAGES ON THE CONSOLE AND LOG FILES BOTH
	public Logger logger = LogManager.getLogger(this.getClass());
	
	
	//TO READ THE FILE FROM THE utilities.ReadConfigFiles
	public ReadConfigFiles rcf = new ReadConfigFiles();
	public String serverUrl = rcf.getApplicationUrl();
	
	//ANDROID DRIVER CONSTRUCTOR
	public static AndroidDriver<AndroidElement> driver = null;
	URL url = null;
	DesiredCapabilities cap = null;
	
	
	//SETUP METHODS TO START THE DRIVERS
	@BeforeTest
	public void Setup() throws InterruptedException
	{ 	
		logger.info("Current thread name: "+Thread.currentThread().getName());
		
	    cap = new DesiredCapabilities();
	    
	    logger.info("Start to set capabilities");
	    //CAPABILITY SETTING
	    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	    cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
	    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	    
	    //FOR THE NATIVE APPS PROVIDES THIS DETAILS
	    cap.setCapability("appPackage", "com.google.android.dialer");
	    cap.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
	    logger.info("All the capabilities are loaded");
	    
	    
	    try 
	    {
	        url = new URL(serverUrl);
	        logger.info("Server url matched");
	        driver = new AndroidDriver<AndroidElement>(url, cap);
	        logger.info("Started the Android Driver");
	        Thread.sleep(5000);
	      
	    } 
	    catch (MalformedURLException e)
	    {
            System.out.println("\n MalformedURLException From: " + e.getMessage());
            e.printStackTrace();
	    } 
	    catch (Exception ex) 
	    {
            System.out.println("\n Exception From: " + ex.getMessage());
            ex.printStackTrace();
	    }
	    
	}
			

	//TEARDOWN METHOD TO CLOSE THE DIRVER
	@AfterTest
	public void Teardown() {
		driver.quit();
		logger.info("Driver shutdown");
	}
		
	//TO GENERATES RANDOM STRING HAVING LENGTH 6 CHARACTER
	public static String randomString(int intLength) {
		String generatedstring = RandomStringUtils.randomAlphabetic(intLength);
		return generatedstring;
	}
	
	
	//TO GENERATES RANDOM STRING NUMBER WITH MIN AND MAX AS PER USER DATA
	public static String randomStringNumber( int min, int max) {
		String rdmStringNumber = RandomStringUtils.randomNumeric(min, max);
		return rdmStringNumber;
	}
}