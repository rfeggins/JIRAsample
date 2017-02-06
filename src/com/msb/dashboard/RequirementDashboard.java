package com.msb.dashboard;

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

public class RequirementDashboard {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Test
	public void testRequirementDashboard() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Requirement Dashboard";
		String ruleId = "requirementDashboard";
		String userName = "Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);
		GenerateData genData = new GenerateData();

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "msbadmin@abc.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_services']/div/h4/a/span", "requirementsDashboardMenuAdmin");
			if(MSBUtils.isElementPresent(By.id("dashBoardDetails_0"), driver)){
			    driver.findElement(By.id("dashYears")).clear();
			    driver.findElement(By.id("dashYears")).sendKeys("2015");
			    driver.findElement(By.id("dashBoardDetails_0")).click();
			    driver.findElement(By.id("dashYears")).clear();
			    driver.findElement(By.id("dashYears")).sendKeys("2016");
			    driver.findElement(By.id("dashBoardDetails_0")).click();
			    driver.findElement(By.id("dashYears")).clear();
			    driver.findElement(By.id("dashYears")).sendKeys("2019");
			    driver.findElement(By.id("dashBoardDetails_0")).click();
			    driver.findElement(By.id("dashYears")).clear();
			    driver.findElement(By.id("dashYears")).sendKeys("2016");
			    driver.findElement(By.id("dashBoardDetails_0")).click();
			    driver.findElement(By.id("accountNamePopup")).clear();
			    driver.findElement(By.id("accountNamePopup")).sendKeys("eri");
			    driver.findElement(By.xpath("//table[@id='completeTable']/tbody/tr/td/a")).click();
			    Thread.sleep(2000);
			    driver.findElement(By.id("dashBoardDetails_0")).click();
			    // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
			    driver.findElement(By.xpath("//section[@id='generalForm']/div/div/div[2]/ul/li/a/img")).click();
			    driver.findElement(By.id("vendorBoard")).click();
			    driver.findElement(By.id("vdashYears")).clear();
			    driver.findElement(By.id("vdashYears")).sendKeys("2015");
			    driver.findElement(By.id("requirementsDashBoardSearch")).click();
			    // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
			    driver.findElement(By.id("vdashYears")).clear();
			    driver.findElement(By.id("vdashYears")).sendKeys("2016");
			    driver.findElement(By.id("requirementsDashBoardSearch")).click();
			    driver.findElement(By.id("vendorAccountNamePopup")).clear();
			    driver.findElement(By.id("vendorAccountNamePopup")).sendKeys("gle");
			    driver.findElement(By.xpath("//table[@id='completeTable']/tbody/tr/td/a")).click();
			    Thread.sleep(2000);
			    driver.findElement(By.id("requirementsDashBoardSearch")).click();
			    driver.findElement(By.id("vendorAccountNamePopup")).clear();
			    driver.findElement(By.id("vendorAccountNamePopup")).sendKeys("");
			    driver.findElement(By.id("requirementsDashBoardSearch")).click();
			    driver.findElement(By.xpath("//table[@id='VendorDashBoardTable']/tbody/tr[2]/td[7]/a")).click();
			    driver.findElement(By.xpath("//div[@id='csrVenBox']/div/span/h5/a/i")).click();
			successMessage += "Success, Requirement Dashboard ";
			 }else{
            	 errorMessage += "Error, Redirect to incorrect Requirement Dashboard page";
            	 MSBUtils.takeScreenShot(driver, repbean);
             }
			timetoProcess += "" + (new Date().getTime() - beging.getTime())
					/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Requirement Dashboard .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Requirement Dashboard .. "
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
