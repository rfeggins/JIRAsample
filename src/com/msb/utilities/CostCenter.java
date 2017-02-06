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

import com.msb.util.GenerateData;
import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;

public class CostCenter {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  GenerateData generateData;

  @Test
	public void testSiteAdminLogin() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Cost Center";
		String ruleId = "costCenter";
		String userName = "Customer Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			 driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "nseerapu@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "(//div[@id='accordian_services']/div/h4/a/span/i)[2]", "costCenterUtilitiesCustAdmin");
            if(MSBUtils.isElementPresent(By.id("costCenterAddLink"), driver)){
		    driver.findElement(By.id("ccName")).clear();
		    driver.findElement(By.id("ccName")).sendKeys("cc103");
		    driver.findElement(By.id("costCenterSearchButton")).click();
		    driver.findElement(By.id("ccName")).clear();
		    driver.findElement(By.id("ccName")).sendKeys("");
		    driver.findElement(By.id("ccCode")).clear();
		    driver.findElement(By.id("ccCode")).sendKeys("cc103");
		    driver.findElement(By.id("costCenterSearchButton")).click();
		    driver.findElement(By.id("ccCode")).clear();
		    driver.findElement(By.id("ccCode")).sendKeys("cc1039");
		    driver.findElement(By.id("costCenterSearchButton")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("In-Active");
		    driver.findElement(By.id("costCenterSearchButton")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Active");
		    driver.findElement(By.id("ccCode")).clear();
		    driver.findElement(By.id("ccCode")).sendKeys("");
		    driver.findElement(By.id("costCenterSearchButton")).click();
		    driver.findElement(By.id("costCenterAddLink")).click();
		    driver.findElement(By.id("name")).clear();
		    driver.findElement(By.id("name")).sendKeys("cc1221");
		    driver.findElement(By.id("add")).click();
		    driver.findElement(By.xpath("//a[@id='costCenterOverlayCloseLink']/i")).click();
		    driver.findElement(By.xpath("//table[@id='costCenterResults']/tbody/tr[3]/td[6]/a/i")).click();
		    driver.findElement(By.id("year")).clear();
		    driver.findElement(By.id("year")).sendKeys("2015");
		    driver.findElement(By.id("costCenterSearchButton")).click();
		    driver.findElement(By.id("year")).clear();
		    driver.findElement(By.id("year")).sendKeys("2014");
		    driver.findElement(By.id("costCenterSearchButton")).click();
		    driver.findElement(By.xpath("//a[@id='backToList']/i")).click();
		    driver.findElement(By.xpath("//table[@id='costCenterResults']/tbody/tr[2]/td[5]/a")).click();
		    driver.findElement(By.id("startDate")).click();
		    driver.findElement(By.xpath("//li/div[2]")).click();
		    driver.findElement(By.xpath("//li/div[2]")).click();
		    driver.findElement(By.xpath("//ul[3]/li[5]")).click();
		    driver.findElement(By.xpath("//a[@id='costCenterBudgetOverlayCloseLink']/i")).click();
		    driver.findElement(By.xpath("//table[@id='costCenterResults']/tbody/tr[10]/td/a")).click();
		    driver.findElement(By.id("update")).click();
		    driver.findElement(By.xpath("//a[@id='costCenterOverlayCloseLink']/i")).click();
		    driver.findElement(By.xpath("//table[@id='costCenterResults']/tbody/tr[3]/td[4]/a")).click();
		    driver.findElement(By.xpath("//a[@id='costCenterProjectsOverlayCloseLink']/i")).click();
		    driver.findElement(By.id("costCenterSearchButton")).click();
		    driver.findElement(By.xpath("//table[@id='costCenterResults']/tbody/tr[9]/td/a")).click();
		    driver.findElement(By.id("update")).click();
		    driver.findElement(By.xpath("//a[@id='costCenterOverlayCloseLink']/i")).click();
		    driver.findElement(By.xpath("(//a[contains(text(),'5')])[2]")).click();
		    driver.findElement(By.xpath("//a[@id='costCenterProjectsOverlayCloseLink']/i")).click();
		    driver.findElement(By.id("costCenterSearchButton")).click();
            successMessage += "Success Cost Center ";
            }else{
           	 errorMessage += "Error, Redirect to incorrect Cost Center page";
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

