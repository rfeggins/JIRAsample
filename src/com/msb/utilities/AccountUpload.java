package com.msb.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import jxl.Workbook;
import jxl.write.WritableWorkbook;

import org.testng.annotations.*;
import static org.testng.Assert.*;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.msb.util.GenerateData;
import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;

public class AccountUpload {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	GenerateData genData;
	Workbook wbook;
	WritableWorkbook wwbCopy;

	@Test
	public void testAccountUpload() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Account Upload";
		String ruleId = "accountUpload";
		String userName = "Site-Administrator";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);
		genData=new GenerateData();

		try {
			 driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "msbadmin@abc.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_team']/div/h4/a/span", "uploadAccountsUtilitiesMenuAdmin");
		    new Select(driver.findElement(By.id("accountType"))).selectByVisibleText("Vendor");
		    new Select(driver.findElement(By.id("accountType"))).selectByVisibleText("Customer");
//		    driver.findElement(By.id("file")).clear();
		    // copy another file with same data
		    String randomStr = genData.generateRandomString(8);
			System.out.println("Generated String:-" + randomStr);
			String curFile = Paths.get("").toAbsolutePath()+"\\sample\\SampleFile\\CustomerList.xls";
			String genratedFile = Paths.get("").toAbsolutePath()+"\\sample\\SampleFile\\"	+ randomStr + ".xls";
			MSBUtils.copyFile(curFile, genratedFile);
			driver.findElement(By.id("file")).sendKeys(Paths.get("").toAbsolutePath()+"\\sample\\SampleFile\\" + randomStr+ ".xls");
//		    driver.findElement(By.id("file")).sendKeys("C:\\Users\\miracle\\Documents\\SampleFile\\CustomerList.xls");
		    driver.findElement(By.id("myForm_submit")).click();
		    new Select(driver.findElement(By.id("accUrl"))).selectByVisibleText("Url(1,0)");
		    new Select(driver.findElement(By.id("mailExt"))).selectByVisibleText("Mail Extentions(2,0)");
		    new Select(driver.findElement(By.id("accAddress1"))).selectByVisibleText("Address1(3,0)");
		    new Select(driver.findElement(By.id("accAddress2"))).selectByVisibleText("Address2(4,0)");
		    new Select(driver.findElement(By.id("accCity"))).selectByVisibleText("City(5,0)");
		    new Select(driver.findElement(By.id("zip"))).selectByVisibleText("zip(6,0)");
		    new Select(driver.findElement(By.id("accCountry"))).selectByVisibleText("Country(7,0)");
		    new Select(driver.findElement(By.id("accState"))).selectByVisibleText("State(8,0)");
		    new Select(driver.findElement(By.id("phone"))).selectByVisibleText("phone(9,0)");
		    new Select(driver.findElement(By.id("accFax"))).selectByVisibleText("Fax(10,0)");
		    new Select(driver.findElement(By.id("industry"))).selectByVisibleText("Industry(11,0)");
		    new Select(driver.findElement(By.id("region"))).selectByVisibleText("Region(12,0)");
		    new Select(driver.findElement(By.id("territory"))).selectByVisibleText("territory(13,0)");
		    new Select(driver.findElement(By.id("noOfEmp"))).selectByVisibleText("No.of Employees(14,0)");
		    new Select(driver.findElement(By.id("taxId"))).selectByVisibleText("taxId(15,0)");
		    new Select(driver.findElement(By.id("stockSymbol"))).selectByVisibleText("stockSymbol(16,0)");
		    new Select(driver.findElement(By.id("revenue"))).selectByVisibleText("Revenue(17,0)");
		    new Select(driver.findElement(By.id("description"))).selectByVisibleText("Description(18,0)");
		    driver.findElement(By.id("submitContentButton")).click();
//		    driver.findElement(By.xpath("//table[@id='Utility_logger']/tbody/tr[2]/td[3]/a")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Un-Success");
		    driver.findElement(By.id("searchButton")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Success");
		    driver.findElement(By.id("created_Date")).click();
		    driver.findElement(By.xpath("//ul[2]/li[4]")).click();
		    driver.findElement(By.id("searchButton")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Un-Success");
		    driver.findElement(By.id("searchButton")).click();
//		    driver.findElement(By.xpath("//table[@id='Utility_logger']/tbody/tr[2]/td/a")).click();
		successMessage += "Success Account Upload ";
		timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

	} catch (Exception e) {
		returnvalue = false;
		System.out.println("Error in Account Upload .. ");
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		errorMessage += " Error in Account Upload .. "
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
