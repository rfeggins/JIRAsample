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

public class HomeRedirect {
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
		String page = "Admin";
		String ruleId = "homeRedirect";
		String userName = "Site-Administrator";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "msbadmin@abc.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_team']/div/h4/a/span", "homeRedirectUtilitiesMenuAdmin");
			if(MSBUtils.isElementPresent(By.id("addHomeRedirectButton"), driver)){
		    new Select(driver.findElement(By.id("typeOfUser"))).selectByVisibleText("Site Admin");
		    driver.findElement(By.id("searchHomeRedirectButton")).click();
		    new Select(driver.findElement(By.id("accountName"))).selectByVisibleText("Stratabare International");
		    driver.findElement(By.id("searchHomeRedirectButton")).click();
		    new Select(driver.findElement(By.id("accountName"))).selectByVisibleText("All");
		    new Select(driver.findElement(By.id("primaryRole"))).selectByVisibleText("SiteAdministrator");
		    driver.findElement(By.id("searchHomeRedirectButton")).click();
		    new Select(driver.findElement(By.id("primaryRole"))).selectByVisibleText("CSR");
		    driver.findElement(By.id("searchHomeRedirectButton")).click();
		    new Select(driver.findElement(By.id("primaryRole"))).selectByVisibleText("Customer-Admin");
		    driver.findElement(By.id("searchHomeRedirectButton")).click();
		    new Select(driver.findElement(By.id("typeOfUser"))).selectByVisibleText("Customer");
		    driver.findElement(By.id("searchHomeRedirectButton")).click();
		    new Select(driver.findElement(By.id("typeOfUser"))).selectByVisibleText("All");
		    new Select(driver.findElement(By.id("primaryRole"))).selectByVisibleText("All");
		    driver.findElement(By.id("searchHomeRedirectButton")).click();
		    driver.findElement(By.id("3")).click();
		    driver.findElement(By.xpath("(//a[contains(text(),'/ChangeMyPassword.action')])[2]")).click();
		    driver.findElement(By.id("description")).clear();
		    driver.findElement(By.id("description")).sendKeys("edit test data");
		    driver.findElement(By.id("editSumbitButton")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("In-Active");
		    driver.findElement(By.id("editSumbitButton")).click();
		    driver.findElement(By.xpath("//a[@id='editHomeRedirectBackButton']/i")).click();
		    driver.findElement(By.id("3")).click();
		    driver.findElement(By.xpath("(//a[contains(text(),'/ChangeMyPassword.action')])[2]")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Active");
		    driver.findElement(By.id("editSumbitButton")).click();
		    driver.findElement(By.xpath("//a[@id='editHomeRedirectBackButton']/i")).click();
		    driver.findElement(By.xpath("//a[@id='addHomeRedirectButton']/button")).click();
		    driver.findElement(By.xpath("//a[@id='addHomeRedirectBackButton']/i")).click();
		    new Select(driver.findElement(By.id("paginationOption"))).selectByVisibleText("25");
		    new Select(driver.findElement(By.id("paginationOption"))).selectByVisibleText("50");
		    new Select(driver.findElement(By.id("paginationOption"))).selectByVisibleText("10");
		    driver.findElement(By.xpath("//select[@id='paginationOption']/option")).click();
			successMessage += "Success, Home Redirect ";
			 }else{
            	 errorMessage += "Error, Redirect to incorrect Home Redirect page";
            	 MSBUtils.takeScreenShot(driver, repbean);
             }
			timetoProcess += "" + (new Date().getTime() - beging.getTime())
					/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Home Redirect .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Home Redirect .. " + errors.toString();
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
