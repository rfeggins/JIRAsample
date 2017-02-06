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

public class EmployeeGrouping {
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
		String page = "Cost Center";
		String ruleId = "checkActiveinEvent_cptk12";
		String userName = "Customer Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			 driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "nseerapu@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "(//div[@id='accordian_services']/div/h4/a/span)[2]", "empCategoryUtilitiesCustAdmin");
			if(MSBUtils.isElementPresent(By.id("searchUserGroupButton"), driver)){
		    driver.findElement(By.id("empName")).clear();
		    driver.findElement(By.id("empName")).sendKeys("ros");
		    driver.findElement(By.id("searchUserGroupButton")).click();
		    new Select(driver.findElement(By.id("categoryType"))).selectByVisibleText("recruitment");
		    driver.findElement(By.id("searchUserGroupButton")).click();
		    new Select(driver.findElement(By.id("empStatus"))).selectByVisibleText("In-Active");
		    driver.findElement(By.id("searchUserGroupButton")).click();
		    new Select(driver.findElement(By.id("empStatus"))).selectByVisibleText("Active");
		    new Select(driver.findElement(By.id("categoryType"))).selectByVisibleText("Select Category");
		    driver.findElement(By.id("empName")).clear();
		    driver.findElement(By.id("empName")).sendKeys("");
		    driver.findElement(By.id("searchUserGroupButton")).click();
//		    driver.findElement(By.xpath("//a[@id='addUserGroupButton']/button")).click();
//		    driver.findElement(By.xpath("html/body/div[2]/div[1]/div/div[2]/div[1]/div[7]/input")).click();
		    driver.findElement(By.xpath("//table[@id='empCategorizationResults']/tbody/tr[3]/td/a")).click();
		    driver.findElement(By.xpath("//div[@id='usrCategoryValue']/div/input")).click();
		    driver.findElement(By.xpath("//div[@id='selectivityProfileBox']/div[3]/div[2]/div/div[2]")).click();
		    driver.findElement(By.id("saveUserGroupButton")).click();
		    driver.findElement(By.xpath("//a[@id='userGroupBackButton']/i")).click();
		    driver.findElement(By.xpath("//table[@id='empCategorizationResults']/tbody/tr[3]/td/a")).click();
		    driver.findElement(By.xpath("//div[@id='usrCategoryValue']/div/span[3]/a/i")).click();
		    driver.findElement(By.id("saveUserGroupButton")).click();
		    driver.findElement(By.xpath("//a[@id='userGroupBackButton']/i")).click();
		    new Select(driver.findElement(By.id("paginationOption"))).selectByVisibleText("15");
		    new Select(driver.findElement(By.id("paginationOption"))).selectByVisibleText("10");
		    new Select(driver.findElement(By.id("paginationOption"))).selectByVisibleText("5");
		    driver.findElement(By.id("3")).click();
//		    driver.findElement(By.xpath("//table[@id='empCategorizationResults']/tbody/tr[15]/td[7]/center/a/i")).click();
//		    driver.findElement(By.xpath("//div[7]/button")).click();
//		    driver.findElement(By.xpath("//button[2]")).click();
            successMessage += "Success Cost Center ";
			 }else{
	           	 errorMessage += "Error, Redirect to incorrect Employee grouping page";
	           	 MSBUtils.takeScreenShot(driver, repbean);
	            }
   	timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

   } catch (Exception e) {
   	returnvalue = false;
   	System.out.println("Error in Cost Center .. ");
   	StringWriter errors = new StringWriter();
   	e.printStackTrace(new PrintWriter(errors));
   	errorMessage += " Error in Cost Center .. "
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
