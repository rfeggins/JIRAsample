package com.msb.utilities;

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

public class ChangeMyPassword {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Test
	public void testSiteAdminLogin() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Change My Password";
		String ruleId = "changeMyPassword";
		String userName = "Site-Administrator";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "msbadmin@abc.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_team']/div/h4/a/span/i", "changePasswordUtilitiesMenuAdmin");
		
			    driver.findElement(By.id("curPwd")).click();
			    driver.findElement(By.id("curPwd")).clear();
			    driver.findElement(By.id("curPwd")).sendKeys("Msb1234");
			    driver.findElement(By.id("curPwd")).click();
			    driver.findElement(By.id("curPwd")).click();
			    driver.findElement(By.id("curPwd")).clear();
			    driver.findElement(By.id("curPwd")).sendKeys("Msb12345");
			    driver.findElement(By.id("curPwd")).click();
			    driver.findElement(By.id("curPwd")).clear();
			    driver.findElement(By.id("curPwd")).sendKeys("Msb1234");
			    driver.findElement(By.id("pwd1")).clear();
			    driver.findElement(By.id("pwd1")).sendKeys("Msb1234");
			    driver.findElement(By.id("pwd2")).clear();
			    driver.findElement(By.id("pwd2")).sendKeys("Msb1234");
			    driver.findElement(By.id("submit")).click();
			    driver.findElement(By.id("pwd1")).click();
			    driver.findElement(By.id("pwd1")).clear();
			    driver.findElement(By.id("pwd1")).sendKeys("Msb12345");
			    driver.findElement(By.id("pwd2")).click();
			    driver.findElement(By.id("pwd2")).clear();
			    driver.findElement(By.id("pwd2")).sendKeys("Msb12345");
			    driver.findElement(By.id("submit")).click();
			    driver.findElement(By.xpath("//div[@id='accordian_team']/div/h4/a/span/i")).click();
			    driver.findElement(By.id("changePasswordUtilitiesMenuAdmin")).click();
			    driver.findElement(By.id("curPwd")).click();
			    driver.findElement(By.id("curPwd")).clear();
			    driver.findElement(By.id("curPwd")).sendKeys("Msb12345");
			    driver.findElement(By.id("pwd1")).clear();
			    driver.findElement(By.id("pwd1")).sendKeys("Msb1234");
			    driver.findElement(By.id("pwd2")).clear();
			    driver.findElement(By.id("pwd2")).sendKeys("Msb1234");
			    driver.findElement(By.id("submit")).click();
			successMessage += "Success Change My Password ";
			timetoProcess += "" + (new Date().getTime() - beging.getTime())
					/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Change My Password .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Change My Password .. " + errors.toString();
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
