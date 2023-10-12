package com.dialer.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFiles {
	
	Properties pro;
	
	
	public ReadConfigFiles()
	{
		File src = new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch (Exception e)
		{
			System.out.println("ReadConfigFiles Exception: "+e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String url =  pro.getProperty("serverUrl");
		return url;
	}
	
	public String getUserEmail()
	{
		String userEmail = pro.getProperty("userEmail");
		return userEmail;
	}
	
	public String getUserPassword()
	{
		String userPasswprd = pro.getProperty("userPassword");
		return userPasswprd;
	}

}
