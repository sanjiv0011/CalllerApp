package com.dialer.ReUseAblePageObject;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class ReUseAbleElement {
	
	//CONSTRUCTOR INITIALIZATIONS
	public AndroidDriver<AndroidElement> driver=null;
	public static final Logger logger = LogManager.getLogger(ReUseAbleElement.class);
	public static Actions action;
	public JavascriptExecutor jsExecutor;
	public static SoftAssert softAssert = new SoftAssert();
	
	//CREATE PAGE FACTORY METHODS WITH DRIVERS
	public ReUseAbleElement(AndroidDriver<AndroidElement> driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		jsExecutor  = (JavascriptExecutor)driver;
		action = new Actions(driver);
	}
	
	
	
	//========START=======Actions Elements===========TO USE ANY ONE OF THIS FIRST SEARCH IT SO THAT IT COMES AT TOP=========//
	
		//CONTINUE BUTTON P360
		@FindBy(xpath = "(//span[normalize-space()='Continue'])[1]")
		@CacheLookup
		public WebElement btnContinue_RU;
		public boolean clickONBtnContinue_RU() throws InterruptedException {
			boolean flag = false;
			try {
				btnContinue_RU.click();
				Thread.sleep(1000);
				flag = true;
				logger.info("Clicked on the Continue button");
			}catch(Exception e) {
				logger.info("Exceptino from clickONBtnContinue_RU: "+e.getMessage());
			}
			return flag;
		}
	
		//CONTINUE BUTTON P360 , TO AVOID THE STALE ELEMENT REFERENCE
		public String btnContinueAvoidStaleElementReference_RU ="(//span[normalize-space()='Continue'])[1]";
		public void clickONBtnContinueAvoidStaleElemenetRefernce_RU(AndroidDriver<AndroidElement> driver) throws InterruptedException {
			driver.findElement(By.xpath(btnContinueAvoidStaleElementReference_RU)).click();
			Thread.sleep(1000);
			logger.info("Clicked on the Continue button");
			
		}
	
	
		@FindBy(xpath = "//span[normalize-space()='Dashboard']")
		@CacheLookup
		public WebElement menuDashBoard_RU;
		public void clickMenuDashBoard_RU() throws InterruptedException {
			menuDashBoard_RU.click();
			Thread.sleep(3000);
			logger.info("Clicked on the Menu Dashboard");
			
		}
		
		//SEARCH BOX - 1, P360
//		@FindBy(xpath= "//input[@placeholder='Search here...']")
//		@CacheLookup
//		public  WebElement searchBox_1_RU;
		public String searchBox_1_RU_address = "//input[@placeholder='Search here...']";
		public void searchBox_1_RU(AndroidDriver<AndroidElement> driver,String SearchKey) throws InterruptedException
		{	Thread.sleep(200);
			WebElement searchBox_1_RU = driver.findElement(By.xpath(searchBox_1_RU_address));
			searchBox_1_RU.sendKeys(SearchKey,Keys.ENTER);
			logger.info("Searched the search keys in the search box: "+SearchKey);
			Thread.sleep(4000);
		}
		
		//SEARCH BOX- 2, P360
		@FindBy(xpath = "(//input[@placeholder='Search here...'])[2]")
		@CacheLookup
		public  WebElement searchBox_2_RU;
		public void searchBox_2_RU(String SearchKey) throws InterruptedException
		{	Thread.sleep(200);
			searchBox_2_RU.sendKeys(SearchKey,Keys.ENTER);
			logger.info("Searched the search keys in the search box: "+SearchKey);
			Thread.sleep(4000);
		}
		
		
		//SEARCH KEYWORDS BOX- 1, P360
		@FindBy(xpath = "(//input[@placeholder='Search Keywords'])[1]")
		@CacheLookup
		public  WebElement searchKeyWordsBox_1_RU;
		public String searchKeyWordsBox_1_RU_address =  "(//input[@placeholder='Search Keywords'])[1]";
		public void searchKeyWordsBox_1_RU(AndroidDriver<AndroidElement> driver,String SearchKey) throws InterruptedException
		{	Thread.sleep(200);
			WebElement searchKeyWordsBox_1_RU = driver.findElement(By.xpath(searchKeyWordsBox_1_RU_address));
			//searchKeyWordsBox_1_RU.sendKeys(SearchKey,Keys.ENTER);
			searchKeyWordsBox_1_RU.sendKeys(SearchKey,Keys.ENTER);
			logger.info("Searched the search keys in the search box-1 : "+SearchKey);
			Thread.sleep(4000);
		}
				
		
		//SEARCH KEY NOT FOUND
	  	public String searchKeyMessage_RU = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]";
	  	String searchKeyMessageNotFound_RU;
	  	public boolean isSearchKeysNotFound_RU() {
	  		boolean flag = false;
	  		try {
	  			Thread.sleep(1000);
	  			WebElement searchKey = driver.findElement(By.xpath(searchKeyMessage_RU));
	  			if(searchKey.isDisplayed()) {
	  				flag = true;
	  				logger.info("Searched keys is not found: "+searchKey.isDisplayed());
	  			}	
	  		}catch(Exception e) {
	  			logger.info("Searched key not found exception: "+e.getMessage());
	  		}
	  		return flag;
	  	}
	  	
		//ACTION BUTTON THREE DOTS, P360
		@FindBy(xpath = "//*[name()='svg'][contains(@title,'Options')]")		////*[name()='svg'][contains(@title,'Options')]
		@CacheLookup									////div[@class='pointer']
		public WebElement btnOptions_RU;
		public String btnThreeDot_RU =  "//div[@class='pointer']";
		// Action method to click the Action button
	    public void clickOnActionButton_RU() throws InterruptedException {
	    	//BEFORE CLICK ON THE THREE DOTS IT WILL CONFIRM FIST WHERE IT IS PRESENT OR NOT
	    	btnOptions_RU.click();
	        logger.info("Clicked on the Three dot Options button");
	        Thread.sleep(500);
	    }
	    
	    //THREE DOT ACTION BUTTON ADDRESSES
		@FindBy(xpath = "(//div[@class='pointer'])[1]")		////*[name()='svg'][contains(@title,'Options')]
		@CacheLookup									////div[@class='pointer']
		public WebElement btnThreeDot_1_RU;
	    public void clickOnActionButton_1_RU() throws InterruptedException {
	    	//BEFORE CLICK ON THE THREE DOTS IT WILL CONFIRM FIST WHERE IT IS PRESENT OR NOT
	    	btnThreeDot_1_RU.click();
	        logger.info("Clicked on thebtnThreeDot_1_RU");
	        Thread.sleep(500);
	    }
	    @FindBy(xpath = "(//div[@class='pointer'])[2]")		////*[name()='svg'][contains(@title,'Options')]
		@CacheLookup									////div[@class='pointer']
		public WebElement btnThreeDot_2_RU;
	    public void clickOnActionButton_2_RU() throws InterruptedException {
	    	//BEFORE CLICK ON THE THREE DOTS IT WILL CONFIRM FIST WHERE IT IS PRESENT OR NOT
	    	btnThreeDot_1_RU.click();
	        logger.info("Clicked on thebtnThreeDot_2_RU");
	        Thread.sleep(500);
	    }
	    @FindBy(xpath = "(//div[@class='pointer'])[3]")		////*[name()='svg'][contains(@title,'Options')]
		@CacheLookup									////div[@class='pointer']
		public WebElement btnThreeDot_3_RU;
	    public void clickOnActionButton_3_RU() throws InterruptedException {
	    	//BEFORE CLICK ON THE THREE DOTS IT WILL CONFIRM FIST WHERE IT IS PRESENT OR NOT
	    	btnThreeDot_1_RU.click();
	        logger.info("Clicked on thebtnThreeDot_3_RU");
	        Thread.sleep(500);
	    }
	    
	    
	    
	   
//	    //CANCEL THE CLASS, P360
//  		@FindBy(xpath = "//div[text()='Cancel Class']")
//  		@CacheLookup
//  		public WebElement btnCancelClass_RU;
    	public boolean clickOnBtnCancelClass_RU(AndroidDriver<AndroidElement> driver, int listRowCount) throws InterruptedException {
  	    	//BEFORE CLICK ON THE THREE DOTS IT WILL CONFIRM FIST WHERE IT IS PRESENT OR NOT
  	    	int rowCount = listRowCount;
  	    	String cancelClass_address = "(//div[contains(text(),'Cancel Class')])["+rowCount+"]";
  	    	boolean flag = false;
  	    	try {
  	    		WebElement btnCancelClass = driver.findElement(By.xpath(cancelClass_address));
  	    		if(btnCancelClass.isDisplayed()) {
  	    			btnCancelClass.click();
  	    			flag = true;
  	    			logger.info("Clicked on the button Cancel Class");
  	    		}else {
  	    			logger.info("Is Cancel Class button displayed: "+flag);
  	    		}
  	    	}catch(Exception e) {
  	    		logger.info("Exception from clickOnBtnCancelClass_RU: "+e.getMessage());
  	    	}
  	        Thread.sleep(500);
  	        return flag;
    	}
  
    	//TO CLICK ON ANY OPTION PRESENT UNDER THE THREE DOT ACTION BUTTON
    	public boolean clickOnAnyActionBtnPresentUnderThreeDotOption_RU(AndroidDriver<AndroidElement> driver, int listRowCount) throws InterruptedException {
  	    	//BEFORE CLICK ON THE THREE DOTS IT WILL CONFIRM FIST WHERE IT IS PRESENT OR NOT
  	    	int rowCount = listRowCount;
  	    	String actionAddress = "(//div[contains(@class,'ml-2 font-RobotoMedium')])["+rowCount+"]";
  	    	boolean flag = false;
  	    	try {
  	    		WebElement btnAction = driver.findElement(By.xpath(actionAddress));
  	    		if(btnAction.isDisplayed()) {
  	    			logger.info("Clicked on the button: "+btnAction.getText());
  	    			flag = true;
  	    			btnAction.click();
  	    		}else {
  	    			logger.info("Is Action button displayed: "+flag);
  	    		}
  	    	}catch(Exception e) {
  	    		
  	    		logger.info("Exception from clickOnAnyActionBtnPresentUnderThreeDotOption_RU: "+e.getMessage());
  	    	}
  	        Thread.sleep(500);
  	        return flag;
    	}
    
  
	    //===========START=======ACTIVATE AND DEACTIVATE==================//
	    
		//ACTIVATE Action P360 => To use this first search list item so that it comes at first position
		@FindBy(xpath = "//*[normalize-space(text())='Activate']")
		@CacheLookup
		public WebElement actionActivate;
	    public void clickOnActivateAction_RU() throws InterruptedException {
	      int count = 0;
	    	while(true) {
	        	try {
		        	if(actionActivate.isDisplayed() && actionActivate.isEnabled()) {
		        		actionActivate.click();
				        logger.info("Clicked on the Action_Activate button");
				        Thread.sleep(300);
				        break;
		        	}
		        }catch(Exception e) {
		        	count++;
		        	 logger.info("count: "+count);
		        	 logger.info("Exception from : "+e.getMessage());
		        }
	        	if(count>10) {
	        		logger.info("Search Loop Count: "+count);
	        		break;
	        	}
	        }
	    }
		
		//DEACTIVATE Action P360 => To use this first search list item so that it comes at first position
		@FindBy(xpath = "//*[normalize-space(text())='Deactivate']")
		@CacheLookup
		public WebElement actionDeactivate;
	    public void clickOnDeactivateAction_RU() throws InterruptedException {
	    	int count = 0;
	    	while(true) 
	       {
	    	   try {
		    	   if(actionDeactivate.isDisplayed() && actionDeactivate.isEnabled()) {
			    	   	actionDeactivate.click();
				        logger.info("Clicked on the Action_Deactivated button");
				        Thread.sleep(300);
				        break;
			       }
		       }catch(Exception e) {
		    	   count++;
		    	   logger.info("count: "+count);
		    	   logger.info("Exception from : "+e.getMessage());
		       }  
	    	   if(count>10) {
	    		   logger.info("Search Loop Count: "+count);
	        		break;
	        	}
	       }
	    }
 		
 	    //TO CHECK LABLE INACTIVE
 	    @FindBy(xpath="//span[normalize-space()='InActive']")
 	    @CacheLookup
 	    public WebElement inactiveLabel;
 	    public boolean isAlreadyInActiveDisplayed_RU() throws InterruptedException {
 	        boolean flag = false;
 	        if (inactiveLabel.isDisplayed()) {
 	            flag = true;
 	           logger.info("InActive label present: "+flag);
 	        }
 	        Thread.sleep(300);
 	        return flag;
 	    }
 	    
 	    //TO CHECK LABLE ACTIVE 
 	    @FindBy(xpath="//span[normalize-space()='Active']")
 	    @CacheLookup
 	    public WebElement activeLabel;
 	    public boolean isAlreadyActiveDisplayed_RU() throws InterruptedException {
 	        boolean flag = false;
 	        if (activeLabel.isDisplayed()) {
 	            flag = true;
 	           logger.info("InActive label present: "+flag);
 	        }
 	        Thread.sleep(300);
 	        return flag;
 	    }
	 	    
	 	//===========END=======ACTIVATE AND DEACTIVATE==================//
	    
	 	    
	    //===========START=======ARCHIVE AND RESTORE==================//
	    
	    //Archive Action, P360 => To use this first search list item so that it comes at first position
  		@FindBy(xpath = "//*[normalize-space(text())='Archive']")
  		@CacheLookup
  		public WebElement actionArchive;
  		// Action method to click the Archive action
  	    public void clickOnArchiveAction_RU() throws InterruptedException {
  	      int count =  0;
  	    	while(true) {
  	    	   try {
  	    		   if(actionArchive.isDisplayed() && actionArchive.isEnabled()) {
  	    			   actionArchive.click();
  	     	        	logger.info("Clicked on the Action_Archive button");
  	     	        	Thread.sleep(300);
  	     	        	break;
  	    		   }
  	    	   }catch(Exception e) {
  	    			count++;
  	    			 logger.info("count: "+count);
  	    		 logger.info("Exception from : "+e.getMessage());
  	    	   }
  	    	 if(count>10) {
  	    		 
	    		   logger.info("Search Loop Count: "+count);
	        		break;
	        	}
  	       }
  	    }
  		
  		//Restore Action, P360 => To use this first search list item so that it comes at first position
  		@FindBy(xpath = "//*[normalize-space(text())='Restore']")
  		@CacheLookup
  		public WebElement actionRestore;
  		 // Action method to click the Restore action
  	    public void clickOnRestoreAction_RU() throws InterruptedException{
  	       int count = 0;
  	    	while(true) {
  	    	   try {
  	    		   if(actionRestore.isDisplayed() && actionRestore.isEnabled()) {
  	    			 actionRestore.click();
  	     	        logger.info("Clicked on the Action_Restore button");
  	     	        Thread.sleep(300);
  	    		   }
  	    	   }catch(Exception e) {
  	    		   count++;
  	    		 logger.info("count: "+count);
  	    		 logger.info("Exception from : "+e.getMessage());
  	    	   }
  	    	 if(count>10) {
  	    		 
	    		   logger.info("Search Loop Count: "+count);
	        		break;
	        	}
  	       }
  	    }
		
	    //TO CHECK ALLREADY ARCHIVED
	    @FindBy(xpath="//span[text()='Archived']")
	    @CacheLookup
	    public WebElement archivedLabel;
	    public boolean isAlreadyArchivedDisplayed_RU() throws InterruptedException {
	        boolean flag = false;
	        try {
	        	if (archivedLabel.isDisplayed()) {
		            flag = true;
		            logger.info("Confirmation message is already archived: "+flag);
		        }
	        }catch(Exception e) {
	        	logger.info("Archived Exception: "+e.getMessage());
	        }
	        Thread.sleep(300);
	        return flag;
	    }
	  //===========END=======ARCHIVE AND RESTORE==================//
	    
	    
		//Edit Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[contains(text(),'Edit')])[1]")
		@CacheLookup
		public WebElement actionEdit_RU;
		// Action method to click the Edit action
	    public void clickOnEditAction_RU() throws InterruptedException {
	    	actionEdit_RU.click();
	        logger.info("Clicked on the Action_Edit button");
	        Thread.sleep(300);
	    }
		
	    
	    //===========START=======FOR THE BUTTON YES, NO, SAVE CHANGES, CROSS BUTTON, SAVE & GO TO HOME, AND DELETE, PROFILE ICON, EYE ICON===================//
	    
	    
		// DATE ICON 1, P360
	    @FindBy(xpath = "(//button[contains(@aria-label,\"Choose date\")])[1]")
		@CacheLookup
		public WebElement iconDate_1_RU;
		public void clickOnDateIcon_1_RU() throws InterruptedException{
			iconDate_1_RU.click();
		   logger.info("Clicked on the date icon 1");
		   Thread.sleep(1000);
		}
	    		
		// CHANGE DATE ICON 1, P360
	    @FindBy(xpath = "(//button[contains(@aria-label,\"change date\")])[1]")
		@CacheLookup
		public WebElement iconChangeDate_1_RU;
		public void clickOnChangeDateIcon_1_RU() throws InterruptedException{
			iconChangeDate_1_RU.click();
		   logger.info("Clicked on the iconChangeDate_1_RU");
		   Thread.sleep(1000);
		}
		
		//CHANGE DATE ICON 2, P360
	    @FindBy(xpath = "(//button[contains(@aria-label,\"change date\")])[2]")
		@CacheLookup
		public WebElement iconChangeDate_2_RU;
		public void clickOnChangeDateIcon_2_RU() throws InterruptedException{
			iconChangeDate_2_RU.click();
		   logger.info("Clicked on iconChangeDate_2_RU");
		   Thread.sleep(1000);
		}
		
				
	    
	    //TO CLICK ON THE USER PROFILE ICON FOR ICON UPLOAD
	    // PROFILE ICON 1
	    @FindBy(xpath = "(//div[contains(@class,'MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault')])[1]")
		@CacheLookup
		public WebElement iconUserProfileImage_1_RU;
		public void clickOnUserProfileIcon_1_RU() throws InterruptedException{
			iconUserProfileImage_1_RU.click();
		   logger.info("Clicked on the icon to upload the user profile image 1");
		   Thread.sleep(1000);
		}
		
		// PROFILE ICON 2
		@FindBy(xpath = "(//div[contains(@class,'MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault')])[2]")
		@CacheLookup
		public WebElement iconUserProfileImage_2_RU;
		public void clickOnUserProfileIcon_2_RU() throws InterruptedException{
			iconUserProfileImage_2_RU.click();
		   logger.info("Clicked on the icon to upload the user profile image 2");
		   Thread.sleep(1000);
		}
		
		
	    //PASSWORD VISIBILITY EYE ICON 1
	    @FindBy(xpath = "(//button[@aria-label='toggle password visibility']//*[name()='svg'])[1]")
		@CacheLookup
		public WebElement iconPasswordVisibility_1_RU;
		public void clickOnEyeIconPasswordView_1_RU() throws InterruptedException{
			iconPasswordVisibility_1_RU.click();
		   logger.info("Clicked on the eye icon to view the password");
		   Thread.sleep(1000);
		}
		
		//PASSWORD VISIBILITY EYE ICON 2
	    @FindBy(xpath = "(//button[@aria-label='toggle password visibility']//*[name()='svg'])[2]")
		@CacheLookup
		public WebElement iconPasswordVisibility_2_RU;
		public void clickOnEyeIconPasswordView_2_RU() throws InterruptedException{
			iconPasswordVisibility_2_RU.click();
		   logger.info("Clicked on the eye icon to view the password");
		   Thread.sleep(1000);
		}
		
		//PASSWORD VISIBILITY EYE ICON 3
		@FindBy(xpath = "(//button[@aria-label='toggle password visibility']//*[name()='svg'])[3]")
		@CacheLookup
		public WebElement iconPasswordVisibility_3_RU;
		public void clickOnEyeIconPasswordView_3_RU() throws InterruptedException{
			iconPasswordVisibility_3_RU.click();
		   logger.info("Clicked on the eye icon to view the password");
		   Thread.sleep(1000);
		}
		
		//CHECK BOX 1,P360
		@FindBy(xpath = "(//input[@type='checkbox'])[1]")
		@CacheLookup
		WebElement checkBox_1_RU;
		public boolean clickOnCheckBox_1_RU() throws InterruptedException{
			boolean flag = false;
			try {
				if(!checkBox_1_RU.isSelected()) {
					checkBox_1_RU.click();
				}else {
					logger.info("Check box already selected");
				}
				Thread.sleep(400);
				flag = true;
			   logger.info("Clicked on the Checkbox 1");
			}catch(Exception e) {
				logger.info("Exception from clickOnCheckBox_1_RU : "+e.getMessage());
			}
			return flag;
		}
		
		//CHECK BOX 2 ,P360
		@FindBy(xpath = "(//input[@type='checkbox'])[2]")
		@CacheLookup
		WebElement checkBox_2_RU;
		public boolean clickOnCheckBox_2_RU() throws InterruptedException{
			boolean flag = false;
			try {
				if(!checkBox_2_RU.isSelected()) {
					checkBox_2_RU.click();
				}else {
					logger.info("Check box already selected");
				}
				Thread.sleep(400);
				flag = true;
			   logger.info("Clicked on the Checkbox 2");
			}catch(Exception e) {
				logger.info("Exception from clickOnCheckBox_2_RU : "+e.getMessage());
			}
			return flag;
			
		}
		
		//SELECT ANY CHECK BOX BY PASSING CHECKBOX NUMBER ,P360
		public boolean selectCheckbox_RU(AndroidDriver<AndroidElement> driver, int checkboxNumber) throws InterruptedException{
			boolean flag = false;
			String checkbox_address = "(//input[@type='checkbox'])["+checkboxNumber+"]";
			WebElement btnCheckbox_RU = driver.findElement(By.xpath(checkbox_address));
			try {
				if(!btnCheckbox_RU.isSelected()) {
					btnCheckbox_RU.click();
				}else {
					logger.info("Check box already selected");
				}
				Thread.sleep(400);
				flag = true;
			   logger.info("Clicked on the Checkbox : "+checkboxNumber);
			}catch(Exception e) {
				logger.info("Exception from selectCheckbox_RU : "+e.getMessage());
			}
			return flag;
			
		}
		

		//BUTTON ADD , P360
		@FindBy(xpath = "//span[contains(normalize-space(text()), 'ADD')]")
  		@CacheLookup
  		public WebElement btnAdd_RU;
  		public boolean clickOnAdd_RU() throws InterruptedException {
  			boolean flag = false;
  			try {
  				flag = btnAdd_RU.isDisplayed();
  	  			if(flag) {
  	  				btnAdd_RU.click();
  	  			}
	  	  		logger.info("Is Displeyed and Clicked on the button add : "+flag);
	  
  			}catch(Exception e) {
  				logger.info("Exception from clickOnAdd_RU : "+e.getMessage());
  			}
  			if(flag == false) {
  				logger.info("Not clicked on the ADD button");
  			}
  			return flag;
  		}
		  		
		  		
		  		
		  		
		//BUTTON ADD MEMBER, P360
		@FindBy(xpath = "//span[normalize-space()='Add Member']")
  		@CacheLookup
  		public WebElement btnAddMember_RU;
  		public void clickOnAddMember_RU() throws InterruptedException {
  			boolean flag = false;
  			try {
  				flag = btnAddMember_RU.isDisplayed();
  	  			btnAddMember_RU.click();
  	  			logger.info("Is Displeyed and Clicked on the button add member: "+flag);
  	  			Thread.sleep(1000);
  			}catch(Exception e) {}
  			
  		}
		  		
  		//BUTTON ADD MEMBER, P360 , AVOID STALE ELEMENT REFERENCE
		String btnAddMemberAvoidStaleElementReference_RU = "(//span[normalize-space()='Add Member'])[1]";
		public void clickOnAddMemberAvoidStaleElementReference_1_RU(AndroidDriver<AndroidElement> driver) throws InterruptedException {
			boolean flag = false;
			WebElement ele =null;
			try {
				ele = driver.findElement(By.xpath(btnAddMemberAvoidStaleElementReference_RU));
			}catch(Exception e) {}
			flag = ele.isDisplayed();
			//logger.info("Is Displeyed: "+flag);
			ele.click();
			logger.info("Clicked on the button add member");
			Thread.sleep(1000);
		}
  	  		
		//BUTTON CANCEL 1,P360
		@FindBy(xpath = "(//span[normalize-space()='Cancel'])[1]")
		@CacheLookup
		public WebElement btnCancel_l_RU;
		public void clickOnCancelButton_1_RU() throws InterruptedException {
			try {
				if(btnCancel_l_RU.isDisplayed()) {
					btnCancel_l_RU.click();
						logger.info("Clicked on the cancel button 1");
				} else {
					logger.info("Cancel button and HomeIcon button both not found 1");
				}
					
			}catch(Exception e) {
				logger.info("Cancel button Exception: "+e.getMessage());
			}
		}
	    
		//BUTTON CANCEL 2,P360
		@FindBy(xpath = "(//span[normalize-space()='Cancel'])[2]")
		@CacheLookup
		public WebElement btnCancel_2_RU;
		public void clickOnCancelButton_2_RU() throws InterruptedException {
			try {
				if(btnCancel_2_RU.isDisplayed()) {
					btnCancel_2_RU.click();
						logger.info("Clicked on the cancel button 2");
				} else {
					logger.info("Cancel button and HomeIcon button both not found 2");
				}
					
			}catch(Exception e) {
				logger.info("Cancel button Exception: "+e.getMessage());
			}
		}
				
				
		//TO CLICK ON YES BUTTON,P360
	    public static boolean clickOnBtnYes_RU(AndroidDriver<AndroidElement> driver) throws InterruptedException {
	    	boolean flag = false;
	    	String btnYes_address;
	    	WebElement btnYes = null;
	    	try {
	    		btnYes_address = "//span[normalize-space()='Yes']";
				//logger.info("btnDeactivate_address:- "+btnDeactivate_address);
	    		btnYes = driver.findElement(By.xpath(btnYes_address));
	    		if(btnYes.isDisplayed() && btnYes.isEnabled()) {
		    		btnYes.click();
			        logger.info("Clicked on the Yes button");
			        flag = true;
		    	}else {
		    		logger.info("Yes button not present");
		    	}
	    		
			}catch(Exception e) {
				logger.info("Exception from clickOnBtnYes: "+e.getMessage());
				softAssert.assertTrue(false,"Action button Yes address not present");
			}
	    	
	    	
	        return flag;
	    }
		
		// No button before confirm the action, P360
		@FindBy(xpath = "//p[normalize-space()='No']")
		@CacheLookup
		public WebElement btnNo_RU;
		// Action method to click the No button
	    public void clickOnNoButton_RU() throws InterruptedException {
	    	btnNo_RU.click();
	        logger.info("Clicked on the No button");
	        Thread.sleep(300);
	    }
	    
	    //DELETE BUTTON
	    @FindBy(xpath = "(//div[contains(text(),'Delete')])[1]")
	    @CacheLookup
	    public WebElement btnDelete;
	    public void clickOnBtnDelete_RU() throws InterruptedException {
	    	btnDelete.click();
	    	logger.info("Clicked on the delete button");
	    	Thread.sleep(300);
	    }
	    
	    //SAVE CHANGES BUTTON(PARAGRAPH TAB)
	    @FindBy(xpath = "//p[normalize-space()='Save Changes']")
		@CacheLookup
		public WebElement btnSaveChangesPara_RU;
	    public boolean clickOnBtnSaveChangesPara_RU() throws InterruptedException {
	    	boolean flag = false;
	    	if(btnSaveChangesPara_RU.isDisplayed()) {
	    		btnSaveChangesPara_RU.click();
	    		flag = true;
				logger.info("Clicked on the save changes(Para Tab) button");
				Thread.sleep(300);
	    	}
			return flag;
		}
	    
	    //SAVE CHANGES BUTTON(SPAN TAB), P360
	    @FindBy(xpath = "//span[normalize-space()='Save Changes']")
		@CacheLookup
		public WebElement btnSaveChangesSpan_RU;
	    public boolean clickOnBtnSaveChangesSpan_RU() throws InterruptedException {
	    	boolean flag = false;
	    	if(btnSaveChangesSpan_RU.isDisplayed()) {
	    		btnSaveChangesSpan_RU.click();
	    		flag = true;
				logger.info("Clicked on the save changes(Span Tab) button");
				Thread.sleep(300);
	    	}
			return flag;
		}
	  
	    //LOGO P360
	    @FindBy(xpath = "(//img[@alt='P360'])[1]")
		@CacheLookup
		public WebElement logoP360_RU;
	    public void clickOnP360Logo_RU() throws InterruptedException {
	    	action.moveToElement(logoP360_RU).build().perform();
	    	Thread.sleep(500);
	    	action.moveToElement(logoP360_RU).doubleClick().build().perform();
			logger.info("Clicked on the P360 logo");
			Thread.sleep(1000);
		}
	    
	    //SAVE AND CLOSE BUTTON 1, P360	
	    @FindBy(xpath = "(//span[normalize-space()='Save & Close'])[1]")
		@CacheLookup
		public WebElement btnSaveAndClose_1_RU;
	    public boolean clickOnBtnSaveAndClose_1_RU() throws InterruptedException {
	    	boolean flag  = false;
	    	try {
	    		btnSaveAndClose_1_RU.click();
				logger.info("Clicked on the save and close button-1");
				flag = true;
				Thread.sleep(300);
	    	}catch(Exception e) {
	    		logger.info("Exception from clickOnBtnSaveAndClose_1_RU: "+e.getMessage());
	    	}
	    	return flag;
		}
	    
	    //SAVE AND CLOSE BUTTON 2, P360	
	    @FindBy(xpath = "(//span[normalize-space()='Save & Close'])[2]")
		@CacheLookup
		public WebElement btnSaveAndClose_2_RU;
	    public boolean clickOnBtnSaveAndClose_2_RU() throws InterruptedException {
	    	boolean flag  = false;
	    	try {
	    		btnSaveAndClose_2_RU.click();
				logger.info("Clicked on the save and close button-2");
				flag  = true;
				Thread.sleep(300);
	    	}catch(Exception e) {
	    		logger.info("Exception from clickOnBtnSaveAndClose_2_RU: "+e.getMessage());
	    	}
	    	return flag;
		}
	    
	    
	    		
		//CROSS BUTTON 1, P360
	    @FindBy(xpath = "(//*[name()='svg'][@title='Close'])[1]")
		@CacheLookup
		public WebElement btnCross_1_RU;
	    public void clickOnBtnCross_1_RU() throws InterruptedException {
	    	try {
	    		btnCross_1_RU.click();
		    	logger.info("Clicked on the cross button icon 1");
				Thread.sleep(300);
	    	}catch(Exception e) {
	    		logger.info("Exception from clickOnBtnCross_1_RU: "+e.getMessage());
	    	}
		}
	    	    
	    	    
	    //CROSS BUTTON, P360
	    @FindBy(xpath = "//button[@title='Close']")
		@CacheLookup
		public WebElement btnCross_RU;
	    public void clickOnBtnCross_RU() throws InterruptedException {
	    	try {
	    		btnCross_RU.click();
		    	logger.info("Clicked on the cross button icon");
				Thread.sleep(300);
	    	}catch(Exception e) {
	    		logger.info("Exception from clickOnBtnCross_RU: "+e.getMessage());
	    	}
		}
	    
	    //SAVE AND GO TO HOME BUTTON 1
	    @FindBy(xpath = "(//p[text()='Save & Go To Home'])[1]")
		@CacheLookup
		public WebElement btnSaveAndGoToHome_1_RU;
	    public void clickOnBtnSaveAndGoToHome_1_RU() throws InterruptedException {
	    	btnSaveAndGoToHome_1_RU.click();
	    	logger.info("Clicked on the save and go to home button");
			Thread.sleep(300);
		}
	    
	    //SAVE AND GO TO HOME BUTTON 2 
	    @FindBy(xpath = "(//p[text()='Save & Go To Home'])[2]")
		@CacheLookup
		public WebElement btnSaveAndGoToHome_2_RU;
	    public void clickOnBtnSaveAndGoToHome_2_RU() throws InterruptedException {
	    	btnSaveAndGoToHome_2_RU.click();
	    	logger.info("Clicked on the save and go to home button");
			Thread.sleep(300);
		}
	    
	    //BACK BUTTON WITH SPAN TAG, P360
	    @FindBy(xpath = "//span[normalize-space()='Back']")
		@CacheLookup
		public WebElement btnBack_1_RU;
	    public void clickOnBtnBack_1_RU() throws InterruptedException {
	    	btnBack_1_RU.click();
	    	logger.info("Clicked on the back button 1");
			Thread.sleep(300);
		}
	    
	    //BACK BUTTON WITH * TAG, P360
	    @FindBy(xpath = "//*[normalize-space()='Back']")
		@CacheLookup
		public WebElement btnBackStarTag_1_RU;
	    public String address_BackStarTag_1_RU = "//*[normalize-space()='Back']";
	    public void clickOnBtnBackStartTag_1_RU() throws InterruptedException {
	    	btnBackStarTag_1_RU.click();
	    	logger.info("Clicked on the  btnBackStarTag_1_RU");
			Thread.sleep(300);
		}
	    
	    //NEXT BUTTON WITH * TAG, P360
	    @FindBy(xpath = "//*[normalize-space()='Next']")
		@CacheLookup
		public WebElement btnNextStarTag_1_RU;
	    public String address_NextStarTag_1_RU = "//*[normalize-space()='Next']";
	    public void clickOnBtnNextStartTag_1_RU() throws InterruptedException {
	    	btnNextStarTag_1_RU.click();
	    	logger.info("Clicked on the  btnNextStarTag_1_RU");
			Thread.sleep(300);
		}
	    
	    //MONTH BUTTON WITH * TAG, P360
	    @FindBy(xpath = "//*[normalize-space()='Month']")
		@CacheLookup
		public WebElement btnMonthStarTag_1_RU;
	    public String address_MonthStarTag_1_RU = "//*[normalize-space()='Month']";
	    public void clickOnBtnMonthStartTag_1_RU() throws InterruptedException {
	    	btnMonthStarTag_1_RU.click();
	    	logger.info("Clicked on the  btnMonthStarTag_1_RU");
			Thread.sleep(300);
		}
	    
	    
	    
	    //NEXT BUTTON 1
	    @FindBy(xpath = "//span[normalize-space()='Next']")
		@CacheLookup
		public WebElement btnNext_RU;
	    public boolean clickOnBtnNext_1_RU() throws InterruptedException {
	    	boolean  flag = false;
	    	try {
	    		btnNext_RU.click();
	    		flag = true;
		    	logger.info("Clicked on the nextbutton");
				Thread.sleep(300);
	    	}catch(Exception e) {
	    		logger.info("Excepton from : "+e.getMessage());
	    	}
			return flag;
		}
	 
	    //UPDATE BUTTON, P360
	    @FindBy(xpath = "//span[normalize-space()='Update']")
		@CacheLookup
		public WebElement btnUpdate_1_RU;
	    public boolean clickOnBtnUpdate_1_RU() throws InterruptedException {
	    	boolean  flag = false;
	    	try {
	    		btnUpdate_1_RU.click();
	    		flag = true;
		    	logger.info("Clicked on the nextbutton");
				Thread.sleep(300);
	    	}catch(Exception e) {
	    		logger.info("Excepton from : "+e.getMessage());
	    	}
			return flag;
		}
	    
		
  		//DROPDOWN BOX ADDRESS 1, P360
  		@FindBy(xpath = "(//div[@role='button'])[1]")
  		@CacheLookup
  		public WebElement dropdownBoxAddress_1_RU;
  		public void clickOnDropdownBoxAddress_1_RU() throws InterruptedException {
  			action.moveToElement(dropdownBoxAddress_1_RU).build().perform();
  			Thread.sleep(500);
  			action.moveToElement(dropdownBoxAddress_1_RU).click().build().perform();
  			//dropdownBoxAddress_1_RU.click();
  			logger.info("Clicked on the dropdown box address 1 to open drop list");
  			Thread.sleep(1000);
  		}
  		
  		
  		//DROPDOWN BOX ADDRESS 2,  P360
  		@FindBy(xpath = "(//div[@role='button'])[2]")
  		@CacheLookup
  		public WebElement dropdownBoxAddress_2_RU;
  		public void clickOnDropdownBoxAddress_2_RU() throws InterruptedException {
  			action.moveToElement(dropdownBoxAddress_2_RU).build().perform();
  			Thread.sleep(500);
  			action.moveToElement(dropdownBoxAddress_2_RU).click().build().perform();
  			//dropdownBoxAddress_2_RU.click();
  			logger.info("Clicked on the dropdown box address 2 to open drop list");
  			Thread.sleep(1000);
  		}
  		
  		
	   
//	    //DROPDOWN ICON 1, P360
//  		@FindBy(xpath = "(//button[@title='Open']//*[name()='svg'])[1]")
//  		@CacheLookup
//  		public WebElement iconDropdown_1_RU;
  		public String iconDropdown_1_RU_Address = "(//button[@title='Open']//*[name()='svg'])[1]";
  		public void clickOnDropdown_1_RU(AndroidDriver<AndroidElement> driver) throws InterruptedException {
  			try {
  				WebElement iconDropdown_1_RU = driver.findElement(By.xpath(iconDropdown_1_RU_Address));
  	  			iconDropdown_1_RU.click();
  	  			logger.info("Clicked on the icon dropdown 1");
  	  			Thread.sleep(1000);
  			}catch(Exception e) {
  				logger.info("Exceptin from clickOnDropdown_1_RU: "+e.getMessage());
  				
  			}
  		} 		
  		
  		
  		
//  		//DROPDOWN ADDRESS 2, P360
//  		@FindBy(xpath = "(//button[@title='Open']//*[name()='svg'])[2]")
//  		@CacheLookup
//  		public WebElement iconDropdown_2_RU;
  		public String iconDropdown_2_RU_Address = "(//button[@title='Open']//*[name()='svg'])[2]";
  		public void clickOnDropdown_2_RU() throws InterruptedException {
  			try {
  				WebElement iconDropdown_2_RU = driver.findElement(By.xpath(iconDropdown_2_RU_Address));
  	  			iconDropdown_2_RU.click();
  	  			logger.info("Clicked on the icon dropdown 2");
  	  			Thread.sleep(1000);
  			}catch(Exception e) {
  				logger.info("Exceptin from clickOnDropdown_2_RU: "+e.getMessage());
  				
  			}
  		}
  		
  		
//  		//DROPDOWN ADDRESS 3, P360
//  		@FindBy(xpath = "(//button[@title='Open']//*[name()='svg'])[3]")
//  		@CacheLookup
//  		public WebElement iconDropdown_3_RU;
  		public String iconDropdown_3_RU_Address = "(//button[@title='Open']//*[name()='svg'])[3]";
  		public void clickOnDropdown_3_RU() throws InterruptedException {
  			try {
  				WebElement iconDropdown_3_RU = driver.findElement(By.xpath(iconDropdown_3_RU_Address));
  	  			iconDropdown_3_RU.click();
  	  			logger.info("Clicked on the icon dropdown 3");
  	  			Thread.sleep(1000);
  			}catch(Exception e) {
  				logger.info("Exceptin from clickOnDropdown_3_RU: "+e.getMessage());
  				
  			}
  		}
  		
  		
//  		//DROPDOWN ADDRESS 4,P360
//  		@FindBy(xpath = "(//button[@title='Open']//*[name()='svg'])[4]")
//  		@CacheLookup
//  		public WebElement iconDropdown_4_RU;
  		public String iconDropdown_4_RU_Address = "(//button[@title='Open']//*[name()='svg'])[4]";
  		public void clickOnDropdown_4_RU() throws InterruptedException {
  			try {
  				WebElement iconDropdown_4_RU = driver.findElement(By.xpath(iconDropdown_4_RU_Address));
  	  			iconDropdown_4_RU.click();
  	  			logger.info("Clicked on the icon dropdown 4");
  	  			Thread.sleep(1000);
  			}catch(Exception e) {
  				logger.info("Exceptin from clickOnDropdown_4_RU: "+e.getMessage());
  				
  			}
  		}
  			
	   	
		//REMOVE BUTTON 1, P360
  		@FindBy(xpath = "(//span[normalize-space()='Remove'])[1]")
  		@CacheLookup
  		public WebElement btnRemove_1_RU;
  		public boolean clickOnBtnRemove_1_RU() throws InterruptedException {
  			boolean flag = false;
  			try {
  				btnRemove_1_RU.click();
  	  			logger.info("Clicked on the btnRemove_1_RU");
  	  			flag = true;
  			}catch(Exception e) {
  				logger.info("Exception from clickOnBtnRemove_1_RU: "+e.getMessage());
  			}
  			return flag;
  		}
	  		
  		  		
  		  		
  		//SAVE BUTTON 1, P360
  		@FindBy(xpath = "(//span[normalize-space()='Save'])[1]")
  		@CacheLookup
  		public WebElement btnSave_1_RU;
  		public boolean clickOnBtnSave_1_RU() throws InterruptedException {
  			boolean flag = false;
  			try {
  				btnSave_1_RU.click();
  	  			logger.info("Clicked on the button save");
  	  			flag = true;
  	  			Thread.sleep(300);
  			}catch(Exception e) {
  				logger.info("Exception from clickOnBtnSave_1_RU: "+e.getMessage());
  			}
  			return flag;
  		}
  		
  
  		//DROPDWON LIST P360
  		@FindBy(xpath = "//ul[@role='listbox']//li")
  		@CacheLookup
  		public List <WebElement>  listOption_RU;
  		//BELOW LINE IS USED TO AVOID THE STALE ELEMENT REFERENCE
  		public String listOptionAddress_RU = "//ul[@role='listbox']//li";
  	
  		
  		//CONFIRM BUTTON ADDRESS AND ACTION METHODS
  		@FindBy(xpath = "//span[normalize-space()='Confirm']")
  		@CacheLookup
  		public WebElement  btnConfirm_RU;
  		public boolean clickOnBtnConfirm_RU() throws InterruptedException{
  			boolean flag = false;
  			try {
  				if(btnConfirm_RU.isDisplayed()) {
  					btnConfirm_RU.click();
  					flag = true;
  	  	  			logger.info("Clicked on the confirm button");
  	  	  			Thread.sleep(300);
  				}
  			}catch(Exception e) {
  				logger.info("Is btnConfirm_RU Displyed: "+flag);
  			}
  			return flag;
  		}
	  //===========END=======FOR THE BUTTON YES, NO, SAVE CHANGES, CROSS BUTTON, SAVE & GO TO HOME, DORPDOWN ICON AND DELETE==================//
	//========START=======Actions Elements=========TO USER ANY ONE OF THIS FIRST SEARCH IT SO THAT IT COMES AT TOP===========//
	    

		
  //===========START======ACTIVATE AND DEACTIVATE ONLY FOR USER PAGE OBJECT AND ITE ACTION METHODS===========//
		//ACTIVATE Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[normalize-space()='Activate'])[1]")
		@CacheLookup
		public WebElement actionActivateUser;
		// Action method to click the Archive action
	    public void clickOnActivateAction_RU_User() throws InterruptedException {
	    	actionActivateUser.click();
	        logger.info("Clicked on the Action_Activate button");
	        Thread.sleep(300);
	    }
		
		//DEACTIVATE Action => To use this first search list item so that it comes at first position
		@FindBy(xpath = "(//div[contains(text(),'Deactivate')])[1]")
		@CacheLookup
		public WebElement actionDeactivateUser;
		 // Action method to click the Restore action
	    public void clickOnDeactivateAction_RU_User() throws InterruptedException {
	    	actionDeactivateUser.click();
	        logger.info("Clicked on the Action_Deactivated button");
	        Thread.sleep(300);
	    }
	    
	
  //===========END======ACTIVATE AND DEACTIVATE ONLY FOR USER PAGE OBJECT AND ITE ACTION METHODS===========//	
	    
 
  //==========START==========TIME SELECTION PAGE OBJECTS AND ITS ACTION METHODS=====USE THIS METHODS IF AND ONLY IF TIME PICKRE FAILED TO PICK THE TIME======//
	  //START AND END TIME REQUIRED MESSAGES ADDRESS
	  		String endTimeRequired_RU = "//p[contains(.,'End time is required')]";
	  		String startTimeRequired_RU = "//p[contains(.,'Start time is required')]";
	  		
	  		//START AND END TIME PLACE HOLDER ADDRESS
	  		String textTimePlaceHolder_1_RU = "(//input[@placeholder='hh:mm aa'])[1]";
	  		String textTimePlaceHolder_2_RU = "(//input[@placeholder='hh:mm aa'])[2]";
	  		
	  		//TO CONFFIRM THE END TIME REQUIRED MESSAGE
	  		public boolean isDisplayedEndTimeRequired_RU() {
	  			WebElement endTimeMsg = driver.findElement(By.xpath(endTimeRequired_RU));
	  			return endTimeMsg.isDisplayed();
	  		}
	  		
	  		//TO CONFFIRM THE START TIME REQUIRED MESSAGE
	  		public boolean isDisplayedStartTimeRequired_RU() {
	  			WebElement startTimeMsg = driver.findElement(By.xpath(startTimeRequired_RU));
	  			return startTimeMsg.isDisplayed();
	  		}
	  		
	  		//TO SET TIME WITHOUT USING END TIME PICKER
	  		public void setTimeWithoutUsingTimePicker_RU(AndroidDriver<AndroidElement> driver, String hours, String minutes, String AmPm) throws InterruptedException
	  		{
	  			WebElement timePlaceHolder = driver.findElement(By.xpath("(//input[@name='time'])[1]"));
	  			timePlaceHolder.sendKeys(Keys.CONTROL, "a");      // Select all text
	  			timePlaceHolder.sendKeys(Keys.CONTROL, "DELETE"); // Delete selected text

	  			logger.info("hours: "+hours);
	  			timePlaceHolder.sendKeys(hours);
	  			Thread.sleep(300);
	  			timePlaceHolder.sendKeys(minutes);
	  			logger.info("minutes: "+minutes);
	  			Thread.sleep(300);
	  			timePlaceHolder.sendKeys(AmPm);
	  			logger.info("AmPm: "+AmPm);
	  			Thread.sleep(300);
	  			logger.info("Entered end time");
	  		}
	  		
	  		//TO SET START TIME WITHOUT USING TIME PICKER
	  		public void setStartTimeWithoutUsingTimePicker_RU(AndroidDriver<AndroidElement> driver, String hours, String minutes, String AmPm) throws InterruptedException
	  		{
	  			WebElement endTimePlaceHolder = driver.findElement(By.xpath(textTimePlaceHolder_2_RU));
	  			endTimePlaceHolder.sendKeys(Keys.CONTROL, "a");      // Select all text
	  			endTimePlaceHolder.sendKeys(Keys.CONTROL, "DELETE"); // Delete selected text

	  			logger.info("hours: "+hours);
	  			endTimePlaceHolder.sendKeys(hours);
	  			Thread.sleep(300);
	  			endTimePlaceHolder.sendKeys(minutes);
	  			logger.info("minutes: "+minutes);
	  			Thread.sleep(300);
	  			endTimePlaceHolder.sendKeys(AmPm);
	  			logger.info("AmPm: "+AmPm);
	  			Thread.sleep(300);
	  			logger.info("Entered end time");
	  		}

	  	  //==========END==========TIME SELECTION PAGE OBJECTS AND ITS ACTION METHODS=====USE THIS METHODS IF AND ONLY IF TIME PICKRE FAILED TO PICK THE TIME======//
  		
	  
	
	  		
	  	//ALARTS ADDRESS AND ACTIONS METHODS
	  	public String alertAddress_RU = "//div[@role=\"alert\"]";
	  	String alertMessageContent_RU;
	  	public String snakeAlertMessagesDisplayedContent_RU() throws InterruptedException {
	  			//logger.info("Alert - Try");
	  			WebElement alertSnakeMessage = null;
	  			int alertLoopCount = 0;
	  			String exception = null;
	  			boolean flag = false;
	  			while(alertLoopCount <= 5000)
	  			{	alertLoopCount++;
	  				try {
	  					alertSnakeMessage = driver.findElement(By.xpath(alertAddress_RU));
	  					flag = alertSnakeMessage.isDisplayed();
		  					if(flag) {
		  						logger.info("Checking alert on intervel of 150 milliSeconds and loop count is: "+alertLoopCount);
		  						logger.info("Alert message is displayed: "+flag);
		  			  			alertMessageContent_RU = alertSnakeMessage.getText();
		  			  			logger.info("===>>> Alert Message Content: "+alertMessageContent_RU);
		  					}else {
		  						Thread.sleep(150);
		  					}
	  				}catch(Exception e) {
	  					exception = e.getMessage();
	  				}
	  				
	  				if(flag) {
	  					Thread.sleep(500);
	  					break;
	  				}
	  				if(alertLoopCount == 2500) {
	  					logger.info("Alert message check frequency is 150 milli seconds and loop count is: "+alertLoopCount);
	  				}
	  			}
	  		
	  		logger.info("Alert not cought exception: "+exception);
	  		Thread.sleep(2000);
	  		return alertMessageContent_RU;
	  	}
	  	
	  	//REQUIRED FIELD MESSAGES
	  	public String requiredOrInvalidMessage_RU = "//p[contains(normalize-space(), 'provide valid')] | //p[contains(normalize-space(), 'required')]";
	  	public boolean isRequiredOrInvalidMessageDisplayed_RU() {
	  		boolean flag = false;
	  		try {
	  			List<AndroidElement> requiredMessage = driver.findElements(By.xpath(requiredOrInvalidMessage_RU));
	  			for(WebElement ele : requiredMessage ) {
	  				if(ele.isDisplayed()) {
		  				flag = true;
		  				Thread.sleep(500);
		  				logger.info("===>>>Is Required/Invalid/Provide Valid Message Displayed: "+ele.isDisplayed()+" And Content: "+ele.getText());
		  			}
	  			}
	  		}catch(Exception e) {
	  			logger.info("Exception from isRequiredMessageDisplayed_RU: "+e.getMessage());
	  		}
	  		return flag;
	  	}
	  	
	 	
	  
  		//TEXT FIELD DESCRITPION 2,P360
  		@FindBy(xpath = "(//div[contains(@class,'ql-editor')]//p)[1]")
  		@CacheLookup
  		public WebElement textArea_1_RU;
  		public void setDescription_1_RU(String description) throws InterruptedException {
  			textArea_1_RU.sendKeys(Keys.CONTROL,"a");
  			textArea_1_RU.sendKeys(Keys.DELETE);
  			textArea_1_RU.sendKeys(description);;
  			logger.info("Entered the  textArea_1_RU: "+description);
  			Thread.sleep(300);
  		}
  		
  		//TEXT FIELD DESCRITPION 2,P360
  		@FindBy(xpath = "(//div[contains(@class,'ql-editor')]//p)[2]")
  		@CacheLookup
  		public WebElement textArea_2_RU;
  		public void setDescription_2_RU(String description) throws InterruptedException {
  			textArea_2_RU.sendKeys(Keys.CONTROL,"a");
  			textArea_2_RU.sendKeys(Keys.DELETE);
  			textArea_2_RU.sendKeys(description);;
  			logger.info("Entered the  textArea: "+description);
  			Thread.sleep(300);
  		}
  		
  		
  		//FIELD/DROPDOWN FIELD BOX ADDRESS AND ACTION METHODS:- 1, P360
  		@FindBy(xpath = "(//div[contains(@class,'MuiInputBase-formControl')])[1]")
  		@CacheLookup
  		public WebElement fieldOrDropdownBox_1_RU;
  		public void clickOnDropdownBox_1_RU() throws InterruptedException {
  			try {
  				fieldOrDropdownBox_1_RU.click();
  				Thread.sleep(500);
  				logger.info("Clicked on the region dropdown box field");
  			}catch(Exception e) {
  				softAssert.assertTrue(false, "Element not Region not clickable");
  			}
  		}
  		
  		//FIELD/DROPDOWN FIELD BOX ADDRESS AND ACTION METHODS:- 2, P360
  		@FindBy(xpath = "(//div[contains(@class,'MuiInputBase-formControl')])[2]")
  		@CacheLookup
  		public WebElement fieldOrDropdownBox_2_RU;
  		public void setFieldOrDropdownBox_2_RU(String value) throws InterruptedException {
  			fieldOrDropdownBox_2_RU.sendKeys(Keys.CONTROL,"a");
  			fieldOrDropdownBox_2_RU.sendKeys(Keys.DELETE);
  			fieldOrDropdownBox_2_RU.sendKeys(value);;
  			logger.info("Entered the value in the fieldBox- 2: "+value);
  			Thread.sleep(300);
  		}
  		
  		//FIELD/DROPDOWN FIELD BOX ADDRESS AND ACTION METHODS:- 3, P360
  		@FindBy(xpath = "(//div[contains(@class,'MuiInputBase-formControl')])[3]")
  		@CacheLookup
  		public WebElement fieldOrDropdownBox_3_RU;
  		public void setFieldOrDropdownBox_3_RU(String value) throws InterruptedException {
  			fieldOrDropdownBox_3_RU.sendKeys(Keys.CONTROL,"a");
  			fieldOrDropdownBox_3_RU.sendKeys(Keys.DELETE);
  			fieldOrDropdownBox_3_RU.sendKeys(value);;
  			logger.info("Entered the value in the fieldBox- 3: "+value);
  			Thread.sleep(300);
  		}
  		
  		public String listActionMenuItem_RU = "//li[@role=\"menuitem\"]";
  
  		
  		//FIELD/DROPDOWN FIELD BOX ADDRESS AND ACTION METHODS:- 4, P360
  		@FindBy(xpath = "(//div[contains(@class,'MuiInputBase-formControl')])[4]")
  		@CacheLookup
  		public WebElement fieldOrDropdownBox_4_RU;
  		public void setFieldOrDropdownBox_4_RU(String value) throws InterruptedException {
  			fieldOrDropdownBox_4_RU.sendKeys(Keys.CONTROL,"a");
  			fieldOrDropdownBox_4_RU.sendKeys(Keys.DELETE);
  			fieldOrDropdownBox_4_RU.sendKeys(value);;
  			logger.info("Entered the value in the fieldBox- 4: "+value);
  			Thread.sleep(300);
  		}
  		
  		//FIELD/DROPDOWN FIELD BOX ADDRESS AND ACTION METHODS:- 5, P360
  		@FindBy(xpath = "(//div[contains(@class,'MuiInputBase-formControl')])[5]")
  		@CacheLookup
  		public WebElement fieldOrDropdownBox_5_RU;
  		public void setFieldOrDropdownBox_5_RU(String value) throws InterruptedException {
  			fieldOrDropdownBox_5_RU.sendKeys(Keys.CONTROL,"a");
  			fieldOrDropdownBox_5_RU.sendKeys(Keys.DELETE);
  			fieldOrDropdownBox_5_RU.sendKeys(value);;
  			logger.info("Entered the value in the fieldBox- 5: "+value);
  			Thread.sleep(300);
  		}
  		
  		//SELECT SPECIFIC DATA FROM THE LIST AND CLICK ON THE THREE DOT ACTION BUTTON PURPOSE
		@FindBy(xpath = "//div[contains(@class,'p-4 flex gap-2 flex-row')]")
		@CacheLookup
		public List <WebElement> listData_RU;
		
		//RADIO BUTTON-1,P360
		@FindBy(xpath = "(//input[@type='radio'])[1]")
		@CacheLookup
		WebElement btnRadio_1_RU;
		public void clickOnRadioButton_1_RU() throws InterruptedException {
			btnRadio_1_RU.click();
			logger.info("Clicked on the radio button -1");
			Thread.sleep(500);
		}
		
		//RADIO BUTTON-2,P360
		@FindBy(xpath = "(//input[@type='radio'])[2]")
		@CacheLookup
		WebElement btnRadio_2_RU;
		public void clickOnRadioButton_2_RU() throws InterruptedException {
			btnRadio_2_RU.click();
			logger.info("Clicked on the radio button -2");
			Thread.sleep(500);
		}
		
		
		//METHODS TO CLICK ON THE ACTION BUTTON
		public boolean clickOnActionListButton_RU(String yourAddressWithoutNumber)
		{
			String btn_address = yourAddressWithoutNumber;
			int count =0;
			boolean flag = false;
			while(true) {
				count++;
				try {
					WebElement btnYour = driver.findElement(By.xpath("("+btn_address+")["+count+"]"));
					logger.info("Your button address: "+btnYour);
					if(btnYour.isDisplayed() && btnYour.isEnabled()) {
						logger.info("Clicked on your button address: "+btnYour.getText());
						action.moveToElement(btnYour).build().perform();
						Thread.sleep(500);
						btnYour.click();
						flag = true;
						Thread.sleep(1000);
						break;
					}
				}catch(Exception e) {
					if(count == 20) {
						logger.info("Exception from clickOnActionListButton :"+e.getMessage());
					}
				}
				if(count>20) {
					break;
				}
			}
			if(count >= 20 && flag == false ) {
				logger.info("Action button you want to click is not present");
				softAssert.assertTrue(flag,"Action button you want to click is not present");
			}
			
			return flag;
		}


}

