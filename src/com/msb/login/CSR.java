package com.msb.login;

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

import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;
import com.msb.util.Util;

public class CSR {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	Util util;

	@Test
	public void testSiteAdminLogin() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Admin";
		String ruleId = "csrLogin";
		String userName = "Site-Administrator";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			 driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
		// Util.accountSearch();
		Util.requirementHomeMenu();
		Util.requirementSearch(Util.driver);
		successMessage += "Success CSR Login ";
		timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

	} catch (Exception e) {
		returnvalue = false;
		System.out.println("Error in CSR login .. ");
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		errorMessage += " Error in CSR login .. "
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
		Util.driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			Util.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			Util.driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = Util.driver.switchTo().alert();
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
