package com.msb.login;

import org.junit.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.*;
import org.testng.annotations.Test;

import com.msb.util.*;


import java.util.concurrent.TimeUnit;
import java.io.IOException;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AllLogin 
{
static MsbExl xlsUtil;
public static WebDriver driver;
public AllLogin() throws BiffException, IOException
{
   xlsUtil = new MsbExl("D://SeleniumLoginWorkspace//MSB_Login.xls");
   MsbExl.ColumnDictionary();
}
@Test
public void MSBLoginPage(){
	try{
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.1.239:8080//MSB/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	//Create a for loop.. for iterate through our Excel sheet for all the test cases.
	 for(int rowCnt = 1;rowCnt<MsbExl.RowCount();rowCnt++)
	 {
	  System.out.println("No of User=" + rowCnt);
	  driver.findElement(By.xpath(".//*[@id='header_top']/div/div/div[2]/ul/li[1]/a")).click();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  WebElement MSBEmail = driver.findElement(By.xpath("//div[2]/form/div/input"));
	  MSBEmail.sendKeys(MsbExl.ReadCell(MsbExl.GetCell("EmailName"), rowCnt));
	  WebElement MSBPWD = driver.findElement(By.xpath("//div[2]/form/div[2]/input"));
	  MSBPWD.clear();
	  MSBPWD.sendKeys(MsbExl.ReadCell(MsbExl.GetCell("Password"), rowCnt));
	  
	  driver.findElement(By.xpath("//div[3]/button")).click();    	  
	   driver.findElement(By.xpath(".//*[@id='dropdownMenu2']/font/span/i")).click();
	   
	    
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='col-sm-6']/div/ul/li/table/tbody/tr/td[2]/ul/div/div[2]/ul/li[3]/a/i")).click();
	    
	 }
	 Util.userLogOut(Util.driver);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
}

