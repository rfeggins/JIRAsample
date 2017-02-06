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

public class CsrSearchTest {
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
		String page = "CSR Search";
		String ruleId = "CSRSearch";
		String userName = "Site-Administrator";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "msbadmin@abc.com", "Msb1234");
    
    driver.findElement(By.xpath("//div[@id='accordian_my']/div/h4/a/span/i")).click();
    driver.findElement(By.xpath("//div[@id='sportswear']/div/ul/li[3]/a")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("csr2");
    driver.findElement(By.id("csrList_0")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("");
    new Select(driver.findElement(By.id("status"))).selectByVisibleText("In-Active");
    driver.findElement(By.id("csrList_0")).click();
    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Active");
    driver.findElement(By.id("csrList_0")).click();
    successMessage += "Success CSR Search ";
	timetoProcess += "" + (new Date().getTime() - beging.getTime())
			/ 1000;

} catch (Exception e) {
	returnvalue = false;
	System.out.println("Error in CSR Search .. ");
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	errorMessage += " Error in CSR Search .. " + errors.toString();
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
