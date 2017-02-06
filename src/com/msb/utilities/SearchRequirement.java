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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;

public class SearchRequirement {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

 

  @Test
  public void testSearchRequirement() throws Exception {
	  boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Search Requirement";
		String ruleId = "searchRequirement";
		String userName = "Project Manager";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			 driver = MSBUtils.getDriver();
//    driver.get(baseUrl + "/MSB/getMainProjects.action");
//    driver.findElement(By.cssSelector("i.fa.fa-sort-asc")).click();
//    driver.findElement(By.xpath("//div[@id='sportswear']/div/ul/li[3]/a")).click();
    MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
    MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span", "requirementsHomeProjectManager");
   
    
    new Select(driver.findElement(By.id("paginationOption"))).selectByVisibleText("15");
    new Select(driver.findElement(By.id("paginationOption"))).selectByVisibleText("10");
    driver.findElement(By.xpath("//select[@id='paginationOption']/option")).click();
    driver.findElement(By.id("jdId")).clear();
    driver.findElement(By.id("jdId")).sendKeys("12");
    driver.findElement(By.id("requirementsListSearch")).click();
    driver.findElement(By.id("jdId")).clear();
    driver.findElement(By.id("jdId")).sendKeys("Jd-120");
    driver.findElement(By.id("requirementsListSearch")).click();
    driver.findElement(By.id("jobTitle")).clear();
    driver.findElement(By.id("jobTitle")).sendKeys("java");
    driver.findElement(By.id("requirementsListSearch")).click();
    driver.findElement(By.id("jobTitle")).clear();
    driver.findElement(By.id("jobTitle")).sendKeys("");
    new Select(driver.findElement(By.id("reqCategoryValue"))).selectByVisibleText("SAP");
    driver.findElement(By.id("requirementsListSearch")).click();
    new Select(driver.findElement(By.id("reqCategoryValue"))).selectByVisibleText("All");
    driver.findElement(By.id("requirementsListSearch")).click();
    new Select(driver.findElement(By.id("requirementStatus"))).selectByVisibleText("Released");
    driver.findElement(By.id("requirementsListSearch")).click();
    new Select(driver.findElement(By.id("requirementStatus"))).selectByVisibleText("Forecast");
    driver.findElement(By.id("requirementsListSearch")).click();
    new Select(driver.findElement(By.id("requirementStatus"))).selectByVisibleText("Released");
    driver.findElement(By.id("requirementsListSearch")).click();
    driver.findElement(By.id("reqStart")).click();
    driver.findElement(By.xpath("//ul[4]/li[4]")).click();
    driver.findElement(By.id("reqEnd")).click();
    driver.findElement(By.xpath("//li/div[2]")).click();
    driver.findElement(By.xpath("//li/div[2]")).click();
    driver.findElement(By.xpath("//ul[4]/li[4]")).click();
    driver.findElement(By.id("jdId")).clear();
    driver.findElement(By.id("jdId")).sendKeys("");
    driver.findElement(By.id("requirementsListSearch")).click();
    driver.findElement(By.id("reqStart")).click();
    driver.findElement(By.xpath("//div/ul/li/div")).click();
    driver.findElement(By.xpath("//div/ul/li/div")).click();
    driver.findElement(By.xpath("//div/ul/li/div")).click();
    driver.findElement(By.xpath("//div/ul/li/div")).click();
    driver.findElement(By.xpath("//div/ul/li/div")).click();
    driver.findElement(By.xpath("//div/ul/li/div")).click();
    driver.findElement(By.xpath("//ul[3]/li[3]")).click();
    driver.findElement(By.id("requirementsListSearch")).click();
    driver.findElement(By.id("reqStart")).click();
    driver.findElement(By.id("reqEnd")).click();
    driver.findElement(By.xpath("//form[@id='RequirementListAllForm']/div/div/div[8]/div")).click();
    driver.findElement(By.id("requirementsListSearch")).click();
    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div/input")).click();
    driver.findElement(By.xpath("//body/div[3]")).click();
    driver.findElement(By.id("requirementsListSearch")).click();
    driver.findElement(By.id("reqStart")).click();
    driver.findElement(By.id("reqEnd")).click();
    driver.findElement(By.id("requirementsListSearch")).click();
    new Select(driver.findElement(By.id("requirementStatus"))).selectByVisibleText("All");
    driver.findElement(By.id("requirementsListSearch")).click();
    driver.findElement(By.id("jdId")).clear();
    driver.findElement(By.id("jdId")).sendKeys("");
    driver.findElement(By.id("requirementsListSearch")).click();
    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div/input")).click();
    driver.findElement(By.xpath("//form[@id='RequirementListAllForm']/div/div/div[7]/div[2]/div/div[2]")).click();
    driver.findElement(By.id("requirementsListSearch")).click();
    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div")).click();
    driver.findElement(By.xpath("//form[@id='RequirementListAllForm']/div/div/div[7]/div[2]/div/div[5]")).click();
    driver.findElement(By.id("requirementsListSearch")).click();
    driver.findElement(By.xpath("//table[@id='reqTableInRecruiter']/tbody/tr[2]/td[4]/a")).click();
    driver.findElement(By.xpath("//div[@id='reqskillBox']/div/span/h5/a/i")).click();
    driver.findElement(By.xpath("//table[@id='reqTableInRecruiter']/tbody/tr[6]/td[4]/a")).click();
    driver.findElement(By.xpath("//div[@id='reqskillBox']/div/span/h5/a/i")).click();
    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div/span[2]/a/i")).click();
    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div/span/a/i")).click();
    driver.findElement(By.id("requirementsListSearch")).click();
    driver.findElement(By.id("4")).click();
  
    successMessage += "Success SearchRequirement ";
	timetoProcess += "" + (new Date().getTime() - beging.getTime())
			/ 1000;
		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Search Requirement .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Search Requirement .. "
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
//      fail(verificationErrorString);
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

