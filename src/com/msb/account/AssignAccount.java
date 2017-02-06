package com.msb.account;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.msb.util.GenerateData;
import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;

public class AssignAccount {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Test
	public void testCopyAccount() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Assign Account";
		String ruleId = "assignAccount";
		String userName = "Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "msbadmin@abc.com", "Msb1234");
            MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span/i", "assignAccountsMenuAdmin");
            if(MSBUtils.isElementPresent(By.id("typeTransfer"), driver)){
		    new Select(driver.findElement(By.id("typeTransfer"))).selectByVisibleText("Copy Accounts");
		    driver.findElement(By.id("fromCSR")).clear();
		    driver.findElement(By.id("fromCSR")).sendKeys("csr");
		    driver.findElement(By.xpath("//table[@id='completeTable']/tbody/tr[9]/td/a")).click();
		    driver.findElement(By.id("toCSR")).clear();
		    driver.findElement(By.id("toCSR")).sendKeys("csr");
		    driver.findElement(By.xpath("//table[@id='completeTable']/tbody/tr[10]/td/a")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("transfer")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[2]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[2]")).click();
		    Thread.sleep(2000);
		    WebElement  msg =driver.findElement(By.id("validationMessage"));
		    String resMessage=msg.getText();
		    System.out.println("Message--->"+resMessage);
		    if(resMessage.equals("Please enter existing toCSR")){
		    	errorMessage += " Error in Add Account .. " + "Please select existing CSR";
		    	MSBUtils.takeScreenShot(driver, repbean);
		    }else{
		    	successMessage += "Success, Copy Account ";
		    }
		    	
		 }else{
        	 errorMessage += "Error, Redirect to incorrect Copy Account page";
        	 MSBUtils.takeScreenShot(driver, repbean);
         }
			
			timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;
			System.out.println("Total time 1--->"+repbean.getTime()+"diff-->"+timetoProcess);

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Assign Account .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Assign Account .. " + errors.toString();
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
	
	@Test
	public void testTransferAccount() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Assign Account";
		String ruleId = "assignAccount";
		String userName = "Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "msbadmin@abc.com", "Msb1234");
            MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span/i", "assignAccountsMenuAdmin");
            if(MSBUtils.isElementPresent(By.id("typeTransfer"), driver)){
		    new Select(driver.findElement(By.id("typeTransfer"))).selectByVisibleText("Transfer Accounts");
		    driver.findElement(By.id("fromCSR")).clear();
		    driver.findElement(By.id("fromCSR")).sendKeys("csr");
		    driver.findElement(By.xpath("//table[@id='completeTable']/tbody/tr[11]/td/a")).click();
		    driver.findElement(By.id("toCSR")).clear();
		    driver.findElement(By.id("toCSR")).sendKeys("csr");
		    driver.findElement(By.xpath("//table[@id='completeTable']/tbody/tr[12]/td/a")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("transfer")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[2]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[2]")).click();
		    Thread.sleep(2000);
		    WebElement  msg =driver.findElement(By.id("validationMessage"));
		    String resMessage=msg.getText();
		    if(resMessage.equals("Please enter existing toCSR")){
		    	errorMessage += " Error in Add Account .. " + "Please select existing CSR";
		    	MSBUtils.takeScreenShot(driver, repbean);
		    }else{
		    	successMessage += "Success, Transfer Account ";
		    }
		 }else{
        	 errorMessage += "Error, Redirect to incorrect Transfer Account page";
        	 MSBUtils.takeScreenShot(driver, repbean);
         }
			
			timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;
			System.out.println("Total time 2--->"+repbean.getTime()+"diff-->"+timetoProcess);

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Assign Account .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Assign Account .. " + errors.toString();
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
