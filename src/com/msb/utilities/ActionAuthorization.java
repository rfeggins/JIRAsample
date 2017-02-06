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

public class ActionAuthorization {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
	public void testActionAuthorization() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Action Authorization";
		String ruleId = "actionAuthorization";
		String userName = "Site-Administrator";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			 driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "msbadmin@abc.com", "Msb1234");
            MSBUtils.leftMenu(driver, "//div[@id='accordian_team']/div/h4/a/span", "actionAuthUtilitiesMenuAdmin");

		    driver.findElement(By.id("actionName")).clear();
		    driver.findElement(By.id("actionName")).sendKeys("team");
		    driver.findElement(By.id("accAuthSearchButton")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("In-Active");
		    driver.findElement(By.id("accAuthSearchButton")).click();
		    driver.findElement(By.id("actionName")).clear();
		    driver.findElement(By.id("actionName")).sendKeys("");
		    driver.findElement(By.id("accAuthSearchButton")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Active");
		    driver.findElement(By.id("accAuthSearchButton")).click();
		    driver.findElement(By.id("5")).click();
		    driver.findElement(By.id("9")).click();
		    driver.findElement(By.id("12")).click();
		    driver.findElement(By.cssSelector("u")).click();
		    driver.findElement(By.xpath("//form[@id='searchAccAuthorization']/span/a[6]")).click();
		    driver.findElement(By.xpath("//form[@id='searchAccAuthorization']/span/a[5]")).click();
		    driver.findElement(By.xpath("//form[@id='searchAccAuthorization']/span/a[4]")).click();
		    driver.findElement(By.xpath("//form[@id='searchAccAuthorization']/span/a[3]")).click();
		    driver.findElement(By.id("1")).click();
		    driver.findElement(By.xpath("(//a[contains(text(),'GO')])[10]")).click();
		    new Select(driver.findElement(By.id("accType"))).selectByVisibleText("Customer");
		    driver.findElement(By.id("resSearchButton")).click();
		    new Select(driver.findElement(By.id("accType"))).selectByVisibleText("Vendor");
		    driver.findElement(By.id("resSearchButton")).click();
		    new Select(driver.findElement(By.id("accType"))).selectByVisibleText("Main");
		    driver.findElement(By.id("resSearchButton")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("In-Active");
		    driver.findElement(By.id("resSearchButton")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Active");
		    driver.findElement(By.id("resSearchButton")).click();
		    new Select(driver.findElement(By.id("roles"))).selectByVisibleText("SiteAdministrator");
		    driver.findElement(By.id("resSearchButton")).click();
		    driver.findElement(By.id("resSearchButton")).click();
		    new Select(driver.findElement(By.id("roles"))).selectByVisibleText("All");
		    driver.findElement(By.id("resSearchButton")).click();
		    driver.findElement(By.id("resSearchButton")).click();
		    driver.findElement(By.id("resSearchButton")).click();
		    driver.findElement(By.id("resSearchButton")).click();
		    driver.findElement(By.id("resSearchButton")).click();
		    new Select(driver.findElement(By.id("roles"))).selectByVisibleText("CSR");
		    driver.findElement(By.id("resSearchButton")).click();
		    new Select(driver.findElement(By.id("roles"))).selectByVisibleText("SiteAdministrator");
		    driver.findElement(By.id("resSearchButton")).click();
		    driver.findElement(By.id("accountNamePopup")).clear();
		    driver.findElement(By.id("accountNamePopup")).sendKeys("abc");
		    driver.findElement(By.xpath("//table[@id='completeTable']/tbody/tr/td/a")).click();
		    driver.findElement(By.id("resSearchButton")).click();
		    new Select(driver.findElement(By.id("roles"))).selectByVisibleText("CSR");
		    driver.findElement(By.id("resSearchButton")).click();
		    new Select(driver.findElement(By.id("roles"))).selectByVisibleText("All");
		    driver.findElement(By.id("resSearchButton")).click();
		    driver.findElement(By.xpath("//a[@id='resourcesBackButton']/i")).click();
    successMessage += "Success Action Authorization ";
	timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

} catch (Exception e) {
	returnvalue = false;
	System.out.println("Error in Action Authorization .. ");
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	errorMessage += " Error in Action Authorization .. "
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

