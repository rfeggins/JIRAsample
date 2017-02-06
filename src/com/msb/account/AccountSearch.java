package com.msb.account;

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

import com.msb.util.GenerateData;
import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;

public class AccountSearch {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
	public void testSearchAccount() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Search Account";
		String ruleId = "searchAccount";
		String userName = "Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);
		GenerateData genData=new GenerateData();

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "msbadmin@abc.com", "Msb1234");
            MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span", "searchAccountsMenuAdmin");
            if(MSBUtils.isElementPresent(By.id("accountSearchButton"), driver)){
    driver.findElement(By.id("accountName")).clear();
    driver.findElement(By.id("accountName")).sendKeys("interface");
    driver.findElement(By.id("accountSearchButton")).click();
    new Select(driver.findElement(By.id("accountType"))).selectByVisibleText("Vendor");
    driver.findElement(By.id("accountSearchButton")).click();
    driver.findElement(By.id("accountName")).clear();
    driver.findElement(By.id("accountName")).sendKeys("interfaceer");
    driver.findElement(By.id("accountSearchButton")).click();
    driver.findElement(By.id("accountName")).clear();
    driver.findElement(By.id("accountName")).sendKeys("i");
    driver.findElement(By.id("accountSearchButton")).click();
    new Select(driver.findElement(By.id("accountType"))).selectByVisibleText("Customer");
    driver.findElement(By.id("accountSearchButton")).click();
    new Select(driver.findElement(By.id("Countries"))).selectByVisibleText("Australia");
    driver.findElement(By.cssSelector("option[value=\"1\"]")).click();
    driver.findElement(By.id("accountSearchButton")).click();
    new Select(driver.findElement(By.id("Countries"))).selectByVisibleText("Canada");
    driver.findElement(By.cssSelector("option[value=\"5\"]")).click();
    driver.findElement(By.id("accountSearchButton")).click();
    new Select(driver.findElement(By.id("Countries"))).selectByVisibleText("Germany");
    driver.findElement(By.cssSelector("option[value=\"4\"]")).click();
    driver.findElement(By.id("accountSearchButton")).click();
    new Select(driver.findElement(By.id("accountIndustry"))).selectByVisibleText("IT Services & Staffing And Recruiting");
    driver.findElement(By.id("accountSearchButton")).click();
    new Select(driver.findElement(By.id("accountIndustry"))).selectByVisibleText("Select Industry");
    driver.findElement(By.id("accountSearchButton")).click();
    new Select(driver.findElement(By.id("Countries"))).selectByVisibleText("Select Country");
    driver.findElement(By.cssSelector("option[value=\"-1\"]")).click();
    driver.findElement(By.id("accountSearchButton")).click();
    new Select(driver.findElement(By.id("Countries"))).selectByVisibleText("USA");
    driver.findElement(By.cssSelector("option[value=\"3\"]")).click();
    new Select(driver.findElement(By.id("accountState"))).selectByVisibleText("California");
    driver.findElement(By.id("accountSearchButton")).click();
    driver.findElement(By.id("accountName")).clear();
    driver.findElement(By.id("accountName")).sendKeys("");
    driver.findElement(By.id("accountSearchButton")).click();
    driver.findElement(By.id("accountName")).clear();
    driver.findElement(By.id("accountName")).sendKeys("inter");
    driver.findElement(By.id("accountSearchButton")).click();
    new Select(driver.findElement(By.id("Countries"))).selectByVisibleText("Select Country");
    driver.findElement(By.cssSelector("option[value=\"-1\"]")).click();
    driver.findElement(By.id("accountSearchButton")).click();

    successMessage += "Success, Search Account ";
            }else{
           	 errorMessage += "Error, Redirect to incorrect Account Search page";
           	 MSBUtils.takeScreenShot(driver, repbean);
            }
	timetoProcess += "" + (new Date().getTime() - beging.getTime())
			/ 1000;

} catch (Exception e) {
	returnvalue = false;
	System.out.println("Error in Search Account .. ");
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	errorMessage += " Error in Search Account .. " + errors.toString();
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

