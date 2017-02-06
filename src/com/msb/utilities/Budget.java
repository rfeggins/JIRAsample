package com.msb.utilities;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Budget {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
	public void aTestBudgetSearch() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Budget Search";
		String ruleId = "budgetSearch";
		String userName = "Project Manager";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			 driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span", "budgetsHomeProjectManager");

			if(MSBUtils.isElementPresent(By.id("budgetYear"), driver)){
		    driver.findElement(By.id("budgetYear")).clear();
		    driver.findElement(By.id("budgetYear")).sendKeys("2015");
		    driver.findElement(By.xpath("//a[@id='budgetSearch']/button")).click();
		    driver.findElement(By.id("budgetYear")).clear();
		    driver.findElement(By.id("budgetYear")).sendKeys("2016");
		    new Select(driver.findElement(By.id("project"))).selectByVisibleText("Msb");
		    new Select(driver.findElement(By.id("quarterId"))).selectByVisibleText("Q1");
		    driver.findElement(By.xpath("//a[@id='budgetSearch']/button")).click();
		    new Select(driver.findElement(By.id("quarterId"))).selectByVisibleText("Q4");
		    driver.findElement(By.xpath("//a[@id='budgetSearch']/button")).click();
		    new Select(driver.findElement(By.id("quarterId"))).selectByVisibleText("All");
		    new Select(driver.findElement(By.id("project"))).selectByVisibleText("All");
		    driver.findElement(By.xpath("//a[@id='budgetSearch']/button")).click();
			  
             successMessage += "Success, Budget Search ";
			}else{
           	 errorMessage += "Error, Redirect to incorrect Budget Search page";
           	 MSBUtils.takeScreenShot(driver, repbean);
            }
	timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

} catch (Exception e) {
	returnvalue = false;
	System.out.println("Error in Budget Search .. ");
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	errorMessage += " Error in Budget Search .. "
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
  
  @Test
	public void bTestAddBudget() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Add Budget";
		String ruleId = "addBudget";
		String userName = "Project Manager";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			 driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span", "budgetsHomeProjectManager");
			if(MSBUtils.isElementPresent(By.id("budgetYear"), driver)){	    
		    driver.findElement(By.xpath("//a[@id='budgetAdd']/button")).click();
		    new Select(driver.findElement(By.id("oproject"))).selectByVisibleText("test5");
		    driver.findElement(By.id("oestimateBudget")).clear();
		    driver.findElement(By.id("oestimateBudget")).sendKeys("5000");
		    driver.findElement(By.id("ocomments")).clear();
		    driver.findElement(By.id("ocomments")).sendKeys("test budget");
		    driver.findElement(By.xpath("(//button[@id=''])[2]")).click();
		    driver.findElement(By.xpath("//div[@id='projectBudgetBox']/div/span/h5/a/i")).click();
		    new Select(driver.findElement(By.id("project"))).selectByVisibleText("test5");
		    driver.findElement(By.xpath("//a[@id='budgetSearch']/button")).click();
		    driver.findElement(By.xpath("//table[@id='projectBudgetTable']/tbody/tr[2]/td/a")).click();
		    driver.findElement(By.xpath("//button[@id='']")).click();
		    driver.findElement(By.xpath("//div[@id='projectBudgetBox']/div/span/h5/a/i")).click();
		   
            successMessage += "Success, Add Budget  ";
			}else{
         	 errorMessage += "Error, Redirect to incorrect Add Budget  page";
         	 MSBUtils.takeScreenShot(driver, repbean);
          }
	timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

} catch (Exception e) {
	returnvalue = false;
	System.out.println("Error in Add Budget  .. ");
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	errorMessage += " Error in Add Budget  .. "+ errors.toString();
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
  
  @Test
	public void cTestApproveRejectBudget() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Approve/Reject Budget";
		String ruleId = "approveRejectBudget";
		String userName = "Customer Director";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			 driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "keron@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "(//div[@id='accordian_services']/div/h4/a/span)[2]", "budgetsUtilitiesCustDirector");
  
			if(MSBUtils.isElementPresent(By.id("budgetYear"), driver)){		    
				
				new Select(driver.findElement(By.xpath("//form[@id='projectbudgetForm']/div/div/div[2]/select"))).selectByVisibleText("test5");
			    driver.findElement(By.xpath("//a[@id='budgetSearch']/button")).click();
			    driver.findElement(By.xpath("//table[@id='projectBudgetTable']/tbody/tr[2]/td/a")).click();
			    driver.findElement(By.id("approveComments")).clear();
			    driver.findElement(By.id("approveComments")).sendKeys("test reject");
			    if(!(MSBUtils.isElementPresent(By.xpath("(//button[@id=''])[2]"), driver))){
			    driver.findElement(By.xpath("(//button[@id=''])[2]")).click();
			    }
			    driver.findElement(By.xpath("//div[@id='projectBudgetBox']/div/span/h5/a/i")).click();
		    
            successMessage += "Success, Approve/Reject Budget ";
			}else{
         	 errorMessage += "Error, Redirect to incorrect Approve/Reject Budget  page";
         	 MSBUtils.takeScreenShot(driver, repbean);
          }
	timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

} catch (Exception e) {
	returnvalue = false;
	System.out.println("Error in Approve/Reject Budget .. ");
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	errorMessage += " Error in Approve/Reject Budget .. "
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
  
  @Test
	public void dTestDeleteBudget() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Delete Budget";
		String ruleId = "budgetDelete";
		String userName = "Project Manager";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			 driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span", "budgetsHomeProjectManager");
  
			if(MSBUtils.isElementPresent(By.id("budgetYear"), driver)){
		    
		    new Select(driver.findElement(By.id("project"))).selectByVisibleText("test5");
		    driver.findElement(By.xpath("//a[@id='budgetSearch']/button")).click();
		    driver.findElement(By.xpath("//table[@id='projectBudgetTable']/tbody/tr[2]/td[9]/a/img")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[2]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[2]")).click();
		    driver.findElement(By.xpath("//a[@id='budgetSearch']/button")).click();
		    new Select(driver.findElement(By.id("project"))).selectByVisibleText("All");
		    driver.findElement(By.xpath("//a[@id='budgetSearch']/button")).click();
			    System.out.println("after ok");
  successMessage += "Success, Delete Budget ";
			}else{
         	 errorMessage += "Error, Redirect to incorrect Budget Details page";
         	 MSBUtils.takeScreenShot(driver, repbean);
          }
	timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

} catch (Exception e) {
	returnvalue = false;
	System.out.println("Error in Delete Budget  .. ");
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	errorMessage += " Error in Delete Budget .. "
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
