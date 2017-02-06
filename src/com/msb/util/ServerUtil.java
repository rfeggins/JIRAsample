package com.msb.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ServerUtil {
	public static WebDriver driver;
public static WebDriver getDriver()
{
	if(driver==null)
	{
		driver= new FirefoxDriver();
		return driver;
	}else{
		return driver;
	}
	
}
}
