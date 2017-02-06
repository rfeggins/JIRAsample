package com.msb.util;
import org.junit.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.*;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.SeleneseTestCase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login1 extends SeleneseTestCase
{
static MsbExl xlsUtil;
public static WebDriver driver;
public Login1() throws BiffException, IOException
{
   xlsUtil = new MsbExl("F://SeleniumLoginWorkspace//MSB_Login.xls");
   MsbExl.ColumnDictionary();
}
@Test
public void MSBLoginPage(){
	try{
	driver = new FirefoxDriver();
	//System.setProperty("webdriver.chrome.driver","E:\\share\\Selenium\\selenium-2.45.0\\chromedriver.exe");
//	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.1.239:8080/MSB/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	//Create a for loop.. for iterate through our Excel sheet for all the test cases.
	 for(int rowCnt = 1;rowCnt<MsbExl.RowCount();rowCnt++)
	 {
	  System.out.println("No of User=" + rowCnt);
	//click on Sign In Button  
	  driver.findElement(By.xpath(".//*[@id='header_top']/div/div/div[2]/ul/li[1]/a")).click();
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  //Enter the Email
	  WebElement MSBEmail = driver.findElement(By.cssSelector("div.modal-body > #userLoginForm > div.logCredential > #emailId"));
			  //cssSelector("div.modal-body > #userLoginForm > #emailId"));
	  MSBEmail.clear();
	  MSBEmail.sendKeys(MsbExl.ReadCell(MsbExl.GetCell("EmailName"), rowCnt));
	  //MSBEmail.sendKeys("msbadmin@abc.com");
	  
	  //Enter the Password
	  WebElement MSBPWD = driver.findElement(By.cssSelector("div.modal-body > #userLoginForm > div.logCredential > #password"));
	  MSBPWD.clear();
	  MSBPWD.sendKeys(MsbExl.ReadCell(MsbExl.GetCell("Password"), rowCnt));
	  
	//Click on Login Page
	    driver.findElement(By.cssSelector("#userLoginForm > div.LoginButton > button[type=\"submit\"]")).click();
	    //Assert.assertEquals("MSB Admin", driver.getTitle());	    	  
//	    driver.findElement(By.xpath(".//*[@id='dropdownMenu2']/font/span/i")).click();
	    Util.userLogOut(driver);
//	 Util.userLogin(Util.driver,MsbExl.ReadCell(MsbExl.GetCell("EmailName"), rowCnt), MsbExl.ReadCell(MsbExl.GetCell("Password"), rowCnt));
	    
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
//	    driver.findElement(By.xpath(".//*[@id='col-sm-6']/div/ul/li/table/tbody/tr/td[2]/ul/div/div[2]/ul/li[3]/a/i")).click();
//	    MSBUtils.userLogOut(driver);
	 }
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
