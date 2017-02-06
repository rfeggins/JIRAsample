package com.msb.utilities;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Paths;
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

import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;

public class Contract {
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
		String page = "Contract";
		String ruleId = "contract";
		String userName = "Project-Manager";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "jcena@ibsplc.com", "Msb1234");
			MSBUtils.contractUtilitiesMenu();
			
			 driver.findElement(By.id("consultantName")).clear();
			    driver.findElement(By.id("consultantName")).sendKeys("simon");
			    driver.findElement(By.id("sowSearch")).click();
			    driver.findElement(By.id("customerName")).clear();
			    driver.findElement(By.id("customerName")).sendKeys("crayola");
			    driver.findElement(By.id("sowSearch")).click();
			    driver.findElement(By.id("customerName")).clear();
			    driver.findElement(By.id("customerName")).sendKeys("");
			    driver.findElement(By.id("consultantName")).clear();
			    driver.findElement(By.id("consultantName")).sendKeys("");
			    driver.findElement(By.id("sowSearch")).click();
			    driver.findElement(By.id("requirementName")).clear();
			    driver.findElement(By.id("requirementName")).sendKeys("J2ee");
			    driver.findElement(By.id("sowSearch")).click();
			    driver.findElement(By.id("requirementName")).click();
			    driver.findElement(By.id("requirementName")).clear();
			    driver.findElement(By.id("requirementName")).sendKeys("");
			    driver.findElement(By.id("sowSearch")).click();
			    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Created");
			    driver.findElement(By.id("sowSearch")).click();
			    driver.findElement(By.xpath("//table[@id='sowResults']/tbody/tr[3]/td/a")).click();
			    driver.findElement(By.id("submittedPayRate")).clear();
			    driver.findElement(By.id("submittedPayRate")).sendKeys("35.00");
			    new Select(driver.findElement(By.id("netTerms"))).selectByVisibleText("30");
			    new Select(driver.findElement(By.id("shiftType"))).selectByVisibleText("Rotation");
			    driver.findElement(By.id("customerDivision")).clear();
			    driver.findElement(By.id("customerDivision")).sendKeys("North NCR");
			    driver.findElement(By.id("locationOne")).clear();
			    driver.findElement(By.id("locationOne")).sendKeys("Noida");
			    driver.findElement(By.id("locationTwo")).clear();
			    driver.findElement(By.id("locationTwo")).sendKeys("Gurgaon");
			    driver.findElement(By.id("vendorComments")).clear();
			    driver.findElement(By.id("vendorComments")).sendKeys("test Comments");
			    driver.findElement(By.id("saveButton")).click();
			    driver.findElement(By.id("sowSearch")).click();
			    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Created");
			    driver.findElement(By.id("sowSearch")).click();
			    driver.findElement(By.xpath("//table[@id='sowResults']/tbody/tr[3]/td/a")).click();
			    driver.findElement(By.xpath("//li[@id='Attachments']/a")).click();
			    driver.findElement(By.xpath("//a[@id='attachmentsLink']/button")).click();
//			    driver.findElement(By.id("file")).clear();
			    driver.findElement(By.id("file")).sendKeys(Paths.get("").toAbsolutePath()+"\\sample\\sample Resume\\JOHN HLOOMBERT CV.docx");
			    driver.findElement(By.xpath("//form[@id='SOWAttachmentId']/div/div[3]/center/button")).click();
			    Thread.sleep(2000);
//			    driver.findElement(By.id("attachBackButton")).click();
			    driver.findElement(By.xpath("//li[@id='RecreatedList']/a")).click();
			    new Select(driver.findElement(By.id("his_serviceType"))).selectByVisibleText("SOW Proceed");
			    driver.findElement(By.xpath("//select[@id='his_serviceType']/option[2]")).click();
			    driver.findElement(By.id("recreateSearch")).click();
			    new Select(driver.findElement(By.id("his_serviceType"))).selectByVisibleText("All");
			    driver.findElement(By.id("recreateSearch")).click();
			    driver.findElement(By.xpath("//a[@id='recreateBackButton']/i")).click();
			    driver.findElement(By.xpath("//table[@id='sowResults']/tbody/tr[2]/td/a")).click();
			    driver.findElement(By.xpath("//a[@id='sowListBackButton']/i")).click();
			    new Select(driver.findElement(By.id("paginationOption"))).selectByVisibleText("50");
			    new Select(driver.findElement(By.id("paginationOption"))).selectByVisibleText("10");
			    driver.findElement(By.xpath("//select[@id='paginationOption']/option")).click();
			    driver.findElement(By.id("2")).click();
			    driver.findElement(By.id("3")).click();
		    
			successMessage += "Success Contract ";
			timetoProcess += "" + (new Date().getTime() - beging.getTime())
					/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Contract .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Contract .. "
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

