package com.dialer.PageObject;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.testng.asserts.SoftAssert;

import com.dialer.ReUseAblePageObject.ReUseAbleElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;



public class PO_HomePage extends ReUseAbleElement{
	
	//CONSTRUCTOR DECLARATION
	public AndroidDriver<AndroidElement> driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();
	
	//HOMEPAGE CONSTRUCTOR CREATION
	public PO_HomePage(AndroidDriver<AndroidElement> driver) {	
		super(driver);
	    this.driver = driver;
	    jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		action = new Actions(driver);

	}
	
	//=========START========HOME PAGE OBJECTS=============//
	@AndroidFindBy(id = "com.google.android.dialer:id/call_log_tab")
	@CacheLookup
	WebElement recentTab;
	
	@AndroidFindBy(id = "com.google.android.dialer:id/contacts_tab")
	@CacheLookup
	WebElement contactTab;
	
	@AndroidFindBy(id = "com.google.android.dialer:id/voicemail_tab")
	@CacheLookup
	WebElement voiceMailTab;
	
	@AndroidFindBy(id = "com.google.android.dialer:id/speed_dial_tab")
	@CacheLookup
	WebElement favoriteTab;
	
	@AndroidFindBy(id = "com.google.android.dialer:id/fab")
	@CacheLookup
	WebElement dialerIcon;
	//=========END========HOME PAGE OBJECTS=============//
	
	
	//=========START========ACTION METHODS FOR HOME PAGE OBJECTS=============//
	public void clickRecentTab() throws InterruptedException {
		recentTab.click();
		Thread.sleep(1000);
		logger.info("Clicked on the recentTab");
	}
	
	public void clickContactTab() throws InterruptedException {
		contactTab.click();
		Thread.sleep(1000);
		logger.info("Clicked on the contactTab");
	}
	public void clickVoiceTab() throws InterruptedException {
		voiceMailTab.click();
		Thread.sleep(1000);
		logger.info("Clicked on the voiceMailTab");
	}
	
	public void clickFavoriteTab() throws InterruptedException {
		favoriteTab.click();
		Thread.sleep(1000);
		logger.info("Clicked on the favoriteTab");
	}
	public void clickDialerTab() throws InterruptedException {
		dialerIcon.click();
		Thread.sleep(1000);
		logger.info("Clicked on the dialerIcon");
	}
	
	//=========END========ACTION METHODS FOR HOME PAGE OBJECTS=============//
	
		
	//TO HOME PAGE ELEMENT
	public PO_HomePage checkHomePageElement() throws InterruptedException
	{	logger.info("Method called: checkHomePageElement");
		clickRecentTab();
		clickContactTab();
		clickVoiceTab();
		clickFavoriteTab();
		clickDialerTab();
		
		driver.navigate().back();
        logger.info("Clicked on the device back button");
        Thread.sleep(1000);
	        
		softAssert.assertAll();
		return new PO_HomePage(driver);
		
	}
	
	
	
}
