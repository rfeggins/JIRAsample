package com.msb.utilities;


import static org.junit.Assert.*;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;

public class Invoice {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

 

	@Test
	public void testEditRequirement() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Invoice";
		String ruleId = "checkActiveinEvent_cptk12";
		String userName = "Vendor";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "jcena@ibsplc.com", "Msb1234");
			MSBUtils.invoiceUtilitiesMenu();
			
			   
			    driver.findElement(By.id("invoiceYear")).clear();
			    driver.findElement(By.id("invoiceYear")).sendKeys("2015");
			    driver.findElement(By.id("invoiceSearch")).click();
			    driver.findElement(By.id("invoiceYear")).clear();
			    driver.findElement(By.id("invoiceYear")).sendKeys("2016");
			    driver.findElement(By.id("invoiceSearch")).click();
			    new Select(driver.findElement(By.id("invoiceMonth"))).selectByVisibleText("January");
			    driver.findElement(By.id("invoiceSearch")).click();
			    new Select(driver.findElement(By.id("invoiceMonth"))).selectByVisibleText("February");
			    driver.findElement(By.id("invoiceSearch")).click();
			    new Select(driver.findElement(By.id("invoiceMonth"))).selectByVisibleText("May");
			    driver.findElement(By.id("invoiceSearch")).click();
			    new Select(driver.findElement(By.id("invoiceMonth"))).selectByVisibleText("March");
			    driver.findElement(By.id("invoiceSearch")).click();
			    new Select(driver.findElement(By.id("invoiceMonth"))).selectByVisibleText("All");
			    driver.findElement(By.id("invoiceSearch")).click();
			    driver.findElement(By.id("invVendor")).clear();
			    driver.findElement(By.id("invVendor")).sendKeys("interface");
			    driver.findElement(By.id("invoiceSearch")).click();
			    driver.findElement(By.id("invVendor")).clear();
			    driver.findElement(By.id("invVendor")).sendKeys("");
			    driver.findElement(By.id("invoiceSearch")).click();
			    driver.findElement(By.xpath("//table[@id='InvoiceTable']/tbody/tr[2]/td/a")).click();
			    driver.findElement(By.xpath("//a[@id='invoiceBackButton']/i")).click();
			    driver.findElement(By.id("generateInvoice")).click();
			    new Select(driver.findElement(By.id("invoiceMonthOver"))).selectByVisibleText("March");
			    driver.findElement(By.id("resourceAll")).click();
			    driver.findElement(By.id("invoiceGenerateOverlay")).click();

			    driver.findElement(By.xpath("//div[@id='InvoiceGenerationOverlay']/div/span/h5/a[2]/i")).click();
//			    assertEquals(closeAlertAndGetItsText(), "inn else");
			    // For alert popup
			    WebDriverWait wait = new WebDriverWait(driver, 2);
		        wait.until(ExpectedConditions.alertIsPresent());
			    Alert alert = driver.switchTo().alert();
		        alert.accept();
			    driver.findElement(By.xpath("//table[@id='InvoiceTable']/tbody/tr[3]/td/a")).click();
			    driver.findElement(By.id("description")).clear();
			    driver.findElement(By.id("description")).sendKeys("test");
			    driver.findElement(By.id("invoiceSave")).click();
			    driver.findElement(By.xpath("//table[@id='InvoiceTable']/tbody/tr[3]/td/a")).click();
			    driver.findElement(By.id("description")).clear();
			    driver.findElement(By.id("description")).sendKeys("test data");
			    driver.findElement(By.id("invoiceSave")).click();
		    
			successMessage += "Success Invoice ";
			timetoProcess += "" + (new Date().getTime() - beging.getTime())
					/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Invoice .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Invoice .. "
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

