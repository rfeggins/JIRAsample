package com.msb.account;

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
import org.openqa.selenium.support.ui.Select;

import com.msb.util.GenerateData;
import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;

public class  AttachmentDetails{
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
		String page = "Attachment Details";
		String ruleId = "attachmentDetails";
		String userName = "Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);
		GenerateData genData = new GenerateData();

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "nseerapu@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span", "accountInfoHomeCustAdmin");
		    driver.findElement(By.xpath("//div[@id='panel-task-body']/ul/li/a/img")).click();
		    driver.findElement(By.xpath("//a[@id='vendorFormsHead']/font")).click();
		    driver.findElement(By.id("attachmentTitle")).clear();
		    driver.findElement(By.id("attachmentTitle")).sendKeys("test");
		    driver.findElement(By.id("vendorFormSearch")).click();
		    driver.findElement(By.id("validFrom")).click();
		   
		    driver.findElement(By.xpath("//div[3]/div/ul/li/div")).click();
		    driver.findElement(By.xpath("//div[3]/div[3]/ul[3]/li[3]")).click();
		    driver.findElement(By.id("vendorFormSearch")).click();
		    driver.findElement(By.id("validTo")).click();
		    driver.findElement(By.xpath("//div[3]/div[3]/ul[3]/li[3]")).click();
		    driver.findElement(By.id("vendorFormSearch")).click();
		    new Select(driver.findElement(By.id("vendorDocs"))).selectByVisibleText("W-9 Form");
		    new Select(driver.findElement(By.id("vendorDocs"))).selectByVisibleText("Minority Certification");
		    driver.findElement(By.id("vendorFormSearch")).click();
		    new Select(driver.findElement(By.id("vendorDocs"))).selectByVisibleText("All");
		    driver.findElement(By.id("validTo")).click();
		    driver.findElement(By.id("attachmentTitle")).click();
		    driver.findElement(By.id("attachmentTitle")).clear();
		    driver.findElement(By.id("attachmentTitle")).sendKeys("");
		    driver.findElement(By.id("vendorFormSearch")).click();
		    driver.findElement(By.id("vendorFormAdd")).click();
		    driver.findElement(By.id("attachmentTitle")).clear();
		    driver.findElement(By.id("attachmentTitle")).sendKeys("Test file");
		    new Select(driver.findElement(By.id("vendorDocs_add"))).selectByVisibleText("Minority Certification");
//		    driver.findElement(By.id("file")).clear();
		    driver.findElement(By.id("file")).sendKeys(Paths.get("").toAbsolutePath()+"\\sample\\sample Resume\\JOHN HLOOMBERT CV.docx");
		    driver.findElement(By.id("attachmentComments")).clear();
		    driver.findElement(By.id("attachmentComments")).sendKeys("test data");
		    driver.findElement(By.id("validity")).click();
		    driver.findElement(By.xpath("//div[6]/div[3]/ul[4]/li[4]")).click();
		    driver.findElement(By.id("saveVendorForm")).click();
//		    driver.findElement(By.xpath("//button[@value='482']")).click();
		    driver.findElement(By.id("2")).click();
		    new Select(driver.findElement(By.id("vpaginationOption"))).selectByVisibleText("15");
		    new Select(driver.findElement(By.id("vpaginationOption"))).selectByVisibleText("10");
			successMessage += "Success Account Attachement Details ";
			timetoProcess += "" + (new Date().getTime() - beging.getTime())
					/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Account Attachement Details .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Account Attachement Details .. " + errors.toString();
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
