package com.msb.utilities;


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

import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;

public class VendorRequirement {
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
		String page = "Vendor Requirement";
		String ruleId = "vendorRequirement";
		String userName = "Vendor";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "andy@ibsplc.com", "Msb1234");
            MSBUtils.leftMenu(driver, "(//div[@id='accordian_services']/div/h4/a/span/i)[2]", "requirementsDashboardUtilitiesMenuVen");
            if(MSBUtils.isElementPresent(By.id("requirementsListSearch"), driver)){
            	
            	driver.findElement(By.id("jdId")).clear();
                driver.findElement(By.id("jdId")).sendKeys("jd");
                driver.findElement(By.id("requirementsListSearch")).click();
                driver.findElement(By.id("jdId")).clear();
                driver.findElement(By.id("jdId")).sendKeys("jd-19");
                driver.findElement(By.id("requirementsListSearch")).click();
                driver.findElement(By.id("jobTitle")).clear();
                driver.findElement(By.id("jobTitle")).sendKeys("java");
                driver.findElement(By.id("requirementsListSearch")).click();
                driver.findElement(By.id("customerName")).clear();
                driver.findElement(By.id("customerName")).sendKeys("interface");
                driver.findElement(By.id("requirementsListSearch")).click();
                driver.findElement(By.id("reqStart")).click();
                driver.findElement(By.xpath("//div/ul/li/div")).click();
                driver.findElement(By.xpath("//div/ul/li/div")).click();
                driver.findElement(By.xpath("//div/ul/li/div")).click();
                driver.findElement(By.xpath("//ul[3]/li[2]")).click();
                driver.findElement(By.id("reqEnd")).click();
                driver.findElement(By.xpath("//li/div[2]")).click();
                driver.findElement(By.xpath("//li/div[2]")).click();
                driver.findElement(By.xpath("//li/div[2]")).click();
                driver.findElement(By.xpath("//li/div[2]")).click();
                driver.findElement(By.xpath("//li/div[2]")).click();
                driver.findElement(By.xpath("//li/div[2]")).click();
                driver.findElement(By.xpath("//ul[4]/li[4]")).click();
                driver.findElement(By.id("requirementsListSearch")).click();
                driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div/input")).click();
                driver.findElement(By.xpath("//form[@id='RequirementListAllForm']/div/div/div[6]/div[2]/div/div[2]")).click();
                driver.findElement(By.id("requirementsListSearch")).click();
                driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div/span/a/i")).click();
                driver.findElement(By.id("reqEnd")).click();
                driver.findElement(By.id("reqEnd")).sendKeys("");
                driver.findElement(By.id("reqStart")).click();
                driver.findElement(By.id("reqStart")).sendKeys("");
                driver.findElement(By.id("customerName")).click();
                driver.findElement(By.id("customerName")).clear();
                driver.findElement(By.id("customerName")).sendKeys("");
                driver.findElement(By.id("jobTitle")).clear();
                driver.findElement(By.id("jobTitle")).sendKeys("");
                driver.findElement(By.id("jdId")).clear();
                driver.findElement(By.id("jdId")).sendKeys("");
                driver.findElement(By.id("requirementsListSearch")).click();
                driver.findElement(By.id("customerName")).clear();
                driver.findElement(By.id("customerName")).sendKeys("");
                driver.findElement(By.id("requirementsListSearch")).click();
                driver.findElement(By.id("jobTitle")).clear();
                driver.findElement(By.id("jobTitle")).sendKeys("");
                driver.findElement(By.id("jdId")).clear();
                driver.findElement(By.id("jdId")).sendKeys("");
                driver.findElement(By.id("requirementsListSearch")).click();
                Thread.sleep(2000);
//                driver.findElement(By.id("2")).click();
//                driver.findElement(By.id("3")).click();
//                driver.findElement(By.id("4")).click();
            	
            	successMessage += "Success Vendor Requirement ";
            }else{
           	 errorMessage += "Error, Redirect to Vendor Requirement page";
           	 MSBUtils.takeScreenShot(driver, repbean);
            }
			
			timetoProcess += "" + (new Date().getTime() - beging.getTime())
					/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Vendor Requirement .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Vendor Requirement .. "
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

