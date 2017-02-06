package com.msb.home;


import com.msb.util.GenerateData;
import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Paths;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditProfile {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	GenerateData generateData;

	@Test
	public void testEditProfile() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Edit Profile";
		String ruleId = "editProfile";
		String userName = "Customer-Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);
		GenerateData generateData = new GenerateData();
		String errorField="";

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "nseerapu@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span/i", "profileHomeCustAdmin");
		if(MSBUtils.isElementPresent(By.id("ContactFname"), driver)){
		    driver.findElement(By.xpath("//font[@value='east']")).click();
//		    driver.findElement(By.id("imageupdate")).clear();
		    driver.findElement(By.id("imageupdate")).sendKeys(Paths.get("").toAbsolutePath()+"\\sample\\profile.jpg");
		    driver.findElement(By.id("profileImageUpdateButton")).click();
		    driver.findElement(By.id("ContactFname")).clear();
		    driver.findElement(By.id("ContactFname")).sendKeys("Nagireddy1");
		    driver.findElement(By.id("ContactLname")).clear();
		    driver.findElement(By.id("ContactLname")).sendKeys("Seerapu");
//		    driver.findElement(By.id("ContactLname")).sendKeys("Se");
		    driver.findElement(By.id("contactTitle")).clear();
		    driver.findElement(By.id("contactTitle")).sendKeys("Developer");
		   

		    driver.findElement(By.id("conAddress2")).clear();
		    driver.findElement(By.id("conAddress2")).sendKeys("MHeights");
		    new Select(driver.findElement(By.id("conState"))).selectByVisibleText("California");
		    driver.findElement(By.id("conCity")).clear();
		    driver.findElement(By.id("conCity")).sendKeys("silk city");
		    driver.findElement(By.xpath("//button[@id='']")).click();
		    Thread.sleep(2000);

		    WebElement  msg =driver.findElement(By.id("InsertContactInfo"));
		    String resMessage=msg.getText();
		    System.out.println("Message--->"+resMessage);
		    if(resMessage.equals("must be valid First Name")){
		    	errorMessage += "Error in Edit Profile .."+"Please Enter First Name...";
		    	MSBUtils.takeScreenShot(driver, repbean);
		    	System.out.println("error msg-->"+errorField);
		    }else if(resMessage.equals("must be valid Last Name")){
		    	errorMessage += "Error in Edit Profile .."+"Please Enter Last Name...";
		    	MSBUtils.takeScreenShot(driver, repbean);
		    }else{
		             successMessage += "Success, Edit Profile ";
		    }
		 }else{
        	 errorMessage += "Error, Redirect to incorrect Edit Profile page";
        	 MSBUtils.takeScreenShot(driver, repbean);
         }
			timetoProcess += "" + (new Date().getTime() - beging.getTime())
					/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Edit Profile .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Edit Profile .. "+ errors.toString();
			System.out.println("error-->"+errorMessage);
			MSBUtils.takeScreenShot(driver, repbean);
			e.printStackTrace();

		} finally {
			repbean.setRuleId(ruleId);
			repbean.setUserId(userName);
			repbean.setFariId(password);
			repbean.setErrorMessage(errorMessage);
			repbean.setSuccessMessage(successMessage);
			repbean.setTime(timetoProcess);
			repbean.setQuery(query);
			repbean.setPage(page);
			MSBUtils.prepareWriteLog(repbean);
			MSBUtils.writeHtmlReport(repbean);
			MSBUtils.userLogOut(driver);
			if (errorMessage != "") {
				throw new Exception();
			}
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}

