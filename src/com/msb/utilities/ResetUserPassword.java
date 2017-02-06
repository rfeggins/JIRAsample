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




public class ResetUserPassword {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
	public void testProjectDetails() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Reset User Password";
		String ruleId = "resetUserPassword";
		String userName = "Customer Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			 driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "msbadmin@abc.com", "Msb1234");
            MSBUtils.leftMenu(driver, "//div[@id='accordian_team']/div/h4/a/span", "resetPasswordUtilitiesMenuAdmin");
			    driver.findElement(By.id("email")).clear();
			    driver.findElement(By.id("email")).sendKeys("vsiram@interfaceglobal.com");
			    driver.findElement(By.id("pwd1")).clear();
			    driver.findElement(By.id("pwd1")).sendKeys("Msb1234");
			    driver.findElement(By.id("pwd2")).clear();
			    driver.findElement(By.id("pwd2")).sendKeys("Msb1234");
			    driver.findElement(By.id("email")).clear();
			    driver.findElement(By.id("email")).sendKeys("vsira@interfaceglobal.com");
			    driver.findElement(By.id("email")).clear();
			    driver.findElement(By.id("email")).sendKeys("vsiram@interfaceglobal.com");
			    driver.findElement(By.id("submit")).click();
    successMessage += "Success Reset User Password ";
   	timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

   } catch (Exception e) {
   	returnvalue = false;
   	System.out.println("Error in Reset User Password .. ");
   	StringWriter errors = new StringWriter();
   	e.printStackTrace(new PrintWriter(errors));
   	errorMessage += " Error in Reset User Password .. "
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
