package com.msb.home;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
 
 
 
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;


import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Timesheet {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

 

	
@Test
	public void atestSearchTimesheet() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Search Timesheet";
		String ruleId = "searchTimesheet";
		String userName = "Employee";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "corry@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span/i", "timesheetsHome");
			  if(MSBUtils.isElementPresent(By.id("tmAddButton"), driver)){
			    driver.findElement(By.id("tmstatus")).click();
			    new Select(driver.findElement(By.id("tmstatus"))).selectByVisibleText("Entered");
			    driver.findElement(By.id("searchButton")).click();
			    new Select(driver.findElement(By.id("tmstatus"))).selectByVisibleText("Select Status");
			    driver.findElement(By.id("searchButton")).click();
			    driver.findElement(By.id("docdatepickerfrom")).click();
			    driver.findElement(By.xpath("//div/ul/li/div")).click();
			    driver.findElement(By.xpath("//div/ul/li/div")).click();
			    driver.findElement(By.xpath("//div/ul/li/div")).click();
			    driver.findElement(By.xpath("//div/ul/li/div")).click();
			    driver.findElement(By.xpath("//div/ul/li/div")).click();
			    driver.findElement(By.xpath("//ul[3]/li[3]")).click();
			    driver.findElement(By.id("searchButton")).click();
			    
		        successMessage += "Success, Search Timesheet ";
			  }else{
	            	 errorMessage += "Error, Redirect to incorrect Timesheet Search page";
	            	 MSBUtils.takeScreenShot(driver, repbean);
	             }
			
			timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Search Timesheet .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Search Timesheet .. "
					+ errors.toString();
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

//	@Test(dependsOnMethods = { "testSearchTimesheet" })
	@Test
	public void btestAddTimesheet() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Add Timesheet";
		String ruleId = "addTimesheet";
		String userName = "Employee";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "corry@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span/i", "timesheetsHome");
			
			  if(MSBUtils.isElementPresent(By.id("tmAddButton"), driver)){
			    
			    
			    
			    driver.findElement(By.xpath("//a[@id='tmAddButton']/button")).click();
			    driver.findElement(By.xpath("//a[@id='tmGoButton']/button")).click();
			    driver.findElement(By.id("internalMon")).clear();
			    driver.findElement(By.id("internalMon")).sendKeys("9");
			    driver.findElement(By.id("internalTue")).clear();
			    driver.findElement(By.id("internalTue")).sendKeys("9");
			    driver.findElement(By.id("internalWed")).clear();
			    driver.findElement(By.id("internalWed")).sendKeys("9");
			    driver.findElement(By.id("internalThu")).clear();
			    driver.findElement(By.id("internalThu")).sendKeys("9");
			    driver.findElement(By.id("internalFri")).clear();
			    driver.findElement(By.id("internalFri")).sendKeys("9");
			    driver.findElement(By.id("internalSat")).clear();
			    driver.findElement(By.id("internalSat")).sendKeys("9");
			    driver.findElement(By.id("saveTimesheetButton")).click();
		        successMessage += "Success Add Timesheet ";
			  }else{
	            	 errorMessage += "Error, Redirect to incorrect Add Timesheet  page";
	            	 MSBUtils.takeScreenShot(driver, repbean);
	             }
			
			timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Add Timesheet .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Add Timesheet .. "
					+ errors.toString();
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
	public void ctestEditTimesheet() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Edit Timesheet";
		String ruleId = "editTimesheet";
		String userName = "Employee";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "corry@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span/i", "timesheetsHome");
			
			  if(MSBUtils.isElementPresent(By.id("tmAddButton"), driver)){
			    
			    driver.findElement(By.xpath("//table[@id='timesheet_results']/tbody/tr[2]/td/a/i")).click();
			    driver.findElement(By.id("internalThu")).clear();
			    driver.findElement(By.id("internalThu")).sendKeys("10");
			    driver.findElement(By.id("internalFri")).clear();
			    driver.findElement(By.id("internalFri")).sendKeys("10");
			    driver.findElement(By.id("internalSat")).clear();
			    driver.findElement(By.id("internalSat")).sendKeys("0.0");
			    driver.findElement(By.id("update")).click();
		   
		    successMessage += "Success, Edit Timesheet ";
			  }else{
	            	 errorMessage += "Error, Redirect to incorrect Edit Timesheet page";
	            	 MSBUtils.takeScreenShot(driver, repbean);
	             }
			
			timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Edit Timesheet .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Edit Timesheet .. "+ errors.toString();
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
	public void dtestApproveRejectTimesheet() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Approve Timesheet";
		String ruleId = "approveRejecttimesheet";
		String userName = "Project Manager";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_services']/div/h4/a/span", "teamTimesheetsUtilitiesProjectManager");
			
			  if(MSBUtils.isElementPresent(By.id("timesheet_results"), driver)){
			   
		    new Select(driver.findElement(By.name("tmmember"))).selectByVisibleText("Corry.Anderson");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.xpath("//table[@id='timesheet_results']/tbody/tr[2]/td/a/img")).click();
		    driver.findElement(By.id("reject")).click();
		    
		    
		    successMessage += "Success, Approve/Reject Timesheet ";
			  }else{
	            	 errorMessage += "Error, Redirect to incorrect Approve/Reject Timesheet page"+new Date();
	            	 MSBUtils.takeScreenShot(driver, repbean);
	             }
			
			timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Approve/Reject Timesheet .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Approve/Reject Timesheet .. "
					+ errors.toString();
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
	public void etestDeleteTimesheet() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Delete Timesheet";
		String ruleId = "deleteTimesheet";
		String userName = "Employee";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "corry@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span/i", "timesheetsHome");
		   if(MSBUtils.isElementPresent(By.id("tmAddButton"), driver)){
		    driver.findElement(By.xpath("//a[@id='deleteTimesheet']/i")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[2]")).click();
		    Thread.sleep(2000);
		    successMessage += "Success,Delete Timesheet ";
			  }else{
	            	 errorMessage += "Error, Redirect to incorrect Delete Timesheet  page";
	            	 MSBUtils.takeScreenShot(driver, repbean);
	             }
			
			timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Delete Timesheet .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Delete Timesheet .. "
					+ errors.toString();
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
//			fail(verificationErrorString);
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

