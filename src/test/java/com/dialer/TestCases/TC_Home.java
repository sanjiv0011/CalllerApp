package com.dialer.TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dialer.PageObject.PO_HomePage;
import com.github.javafaker.Faker;


public class TC_Home extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Home() {
		super();
	}
	
	public Logger logger = LogManager.getLogger(this.getClass());
	
	//CONSTRUCTOR DECLARATION
	public PO_HomePage hp;
	public Faker faker  = new Faker();
	public SoftAssert softAssert = new SoftAssert();
	
	
	//TO CHECK HOME PAGE ELEMENT
	@Test(priority = 1)
	public void test_HomePage() throws InterruptedException {
		logger.info("Started test_HomePage");
		hp = new PO_HomePage(driver);
		hp.checkHomePageElement();
	}
		
		

}
