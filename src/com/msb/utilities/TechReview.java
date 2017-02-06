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

public class TechReview {
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
		String page = "Tech Review";
		String ruleId = "techReview";
		String userName = "Project-Manager";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span/i", "techReviewsHomeProjectManager");
//			 driver.findElement(By.xpath("//div[@id='accordian_my']/div/h4/a/span/i")).click();
//			    driver.findElement(By.id("techReviewsHomeProjectManager")).click();
			    driver.findElement(By.xpath("//table[@id='techReviewTable']/tbody/tr[2]/td[9]/a")).click();
			    driver.findElement(By.xpath("//div[@id='techReviewBox']/div/span/h5/a/i")).click();
			    driver.findElement(By.xpath("//table[@id='techReviewTable']/tbody/tr[7]/td[9]/a")).click();
			    driver.findElement(By.xpath("//div[@id='techReviewBox']/div/span/h5/a/i")).click();
			    driver.findElement(By.xpath("(//a[contains(text(),'Vinod.Siram')])[2]")).click();
			    driver.findElement(By.xpath("//div[@id='recruiterBox']/div/span/h5/a/i")).click();
			    driver.findElement(By.xpath("//table[@id='techReviewTable']/tbody/tr[2]/td/a")).click();
			    driver.findElement(By.xpath("//a[@id='techReviewBackButton']/i")).click();
			    driver.findElement(By.id("reviewStartDate")).click();
			    driver.findElement(By.xpath("//div[5]/div/ul/li/div")).click();
			    driver.findElement(By.xpath("//div[5]/div/ul/li/div")).click();
			    driver.findElement(By.xpath("//div[5]/div[3]/ul[2]/li[3]")).click();
			    driver.findElement(By.id("reviewEndDate")).click();
			    driver.findElement(By.xpath("//div[6]/div/ul/li/div[2]")).click();
			    driver.findElement(By.xpath("//div[6]/div[3]/ul[3]/li[5]")).click();
			    driver.findElement(By.id("techReviewListSearch")).click();
			    new Select(driver.findElement(By.id("techReviewStatus"))).selectByVisibleText("Processing");
			    driver.findElement(By.id("techReviewListSearch")).click();
			    new Select(driver.findElement(By.id("techReviewStatus"))).selectByVisibleText("All");
			    driver.findElement(By.id("techReviewListSearch")).click();
			    driver.findElement(By.id("reviewEndDate")).click();
			    driver.findElement(By.id("reviewStartDate")).click();
			    driver.findElement(By.id("techReviewListSearch")).click();
			    Thread.sleep(2000);
//			    driver.findElement(By.id("2")).click();
			    new Select(driver.findElement(By.id("paginationOption"))).selectByVisibleText("25");
			    new Select(driver.findElement(By.id("paginationOption"))).selectByVisibleText("10");
    successMessage += "Success Tech Review ";
	timetoProcess += "" + (new Date().getTime() - beging.getTime())
			/ 1000;

} catch (Exception e) {
	returnvalue = false;
	System.out.println("Error in Tech Review .. ");
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	errorMessage += " Error in Tech Review .. "
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
