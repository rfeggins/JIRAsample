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

public class LocationDetails {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Test
	public void testAttachmentDetails() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Location Details";
		String ruleId = "locationDetails";
		String userName = "Customer-Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);
		GenerateData genData = new GenerateData();

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "nseerapu@interfaceglobal.com", "Msb1234");
			 driver.findElement(By.xpath("//div[@id='accordian_my']/div/h4/a/span/i")).click();
			    driver.findElement(By.id("accountInfoHomeCustAdmin")).click();
			    driver.findElement(By.xpath("//div[@id='panel-task-body']/ul/li/a/img")).click();
			    driver.findElement(By.xpath("//a[@id='location']/font")).click();
			    driver.findElement(By.id("locationSearchName")).clear();
			    driver.findElement(By.id("locationSearchName")).sendKeys("Head");
			    driver.findElement(By.id("locationSearchCity")).clear();
			    driver.findElement(By.id("locationSearchCity")).sendKeys("San");
			    driver.findElement(By.id("searchLocationButton")).click();
			    driver.findElement(By.id("locationSearchCity")).clear();
			    driver.findElement(By.id("locationSearchCity")).sendKeys("");
			    driver.findElement(By.id("searchLocationButton")).click();
			    driver.findElement(By.id("locationSearchName")).clear();
			    driver.findElement(By.id("locationSearchName")).sendKeys("");
			    driver.findElement(By.id("searchLocationButton")).click();
			    driver.findElement(By.id("searchLocationButton")).click();
			    driver.findElement(By.id("addLocationButton")).click();
//			    driver.findElement(By.id("locationName")).clear();
			    String locatioName =genData.generateRandomString(8);
			    driver.findElement(By.id("locationName")).sendKeys(locatioName);
			    driver.findElement(By.id("locationAddress1")).clear();
			    driver.findElement(By.id("locationAddress1")).sendKeys("RK Beach");
			    new Select(driver.findElement(By.id("locationCountry"))).selectByVisibleText("India");
			    Thread.sleep(2000);
			    new Select(driver.findElement(By.id("locationState"))).selectByVisibleText("Andhra Pradesh");
			 // for masked input text box
				driver.findElement(By.id("locationPhone")).click();
				driver.findElement(By.id("locationPhone")).sendKeys(Keys.HOME + "5467892365");
				
			    driver.findElement(By.id("locationCity")).clear();
			    driver.findElement(By.id("locationCity")).sendKeys("Vizag");
			    driver.findElement(By.id("locationZip")).clear();
			    driver.findElement(By.id("locationZip")).sendKeys("530048");
			    driver.findElement(By.id("saveLocation")).click();
			    driver.findElement(By.xpath("//div[@id='AddLocationOverlay']/div/span/h5/a/i")).click();
			    driver.findElement(By.id("locationSearchName")).clear();
			    driver.findElement(By.id("locationSearchName")).sendKeys(locatioName);
			    driver.findElement(By.id("searchLocationButton")).click();
			    driver.findElement(By.xpath("//table[@id='LocationPageNav']/tbody/tr[2]/td/a")).click();
			    driver.findElement(By.id("locationAddress2")).clear();
			    driver.findElement(By.id("locationAddress2")).sendKeys("Rishikonda");
			    driver.findElement(By.id("locationAddress1")).clear();
			    driver.findElement(By.id("locationAddress1")).sendKeys("RK Beach 112");
			    driver.findElement(By.id("addOrUpdateLocation")).click();
			    driver.findElement(By.xpath("//div[@id='AddLocationOverlay']/div/span/h5/a/i")).click();
			successMessage += "Success Account Location Details ";
			timetoProcess += "" + (new Date().getTime() - beging.getTime())
					/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Account Location Details .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Account Location Details .. " + errors.toString();
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
