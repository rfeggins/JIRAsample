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

public class CSRSearch {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
	public void testCSRSearch() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "CSR Search";
		String ruleId = "csrSearch";
		String userName = "Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);
		GenerateData genData=new GenerateData();

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "msbadmin@abc.com", "Msb12344");
			if(MSBUtils.isElementPresent(By.id("accountName"), driver)){ 
            MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span/i", "csrListAccountsMenuAdmin");
            
		      
			    driver.findElement(By.id("name")).clear();
			    driver.findElement(By.id("name")).sendKeys("csr3");
			    driver.findElement(By.id("csrSearchButton")).click();
			    driver.findElement(By.id("email")).clear();
			    driver.findElement(By.id("email")).sendKeys("csr4@");
			    driver.findElement(By.id("csrSearchButton")).click();
			    driver.findElement(By.id("email")).clear();
			    driver.findElement(By.id("email")).sendKeys("csr3@");
			    driver.findElement(By.id("csrSearchButton")).click();
			    new Select(driver.findElement(By.id("status"))).selectByVisibleText("In-Active");
			    driver.findElement(By.id("csrSearchButton")).click();
			    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Active");
			    driver.findElement(By.id("email")).clear();
			    driver.findElement(By.id("email")).sendKeys("");
			    driver.findElement(By.id("name")).clear();
			    driver.findElement(By.id("name")).sendKeys("");
			    driver.findElement(By.id("csrSearchButton")).click();
			    driver.findElement(By.xpath("//table[@id='csrResults']/tbody/tr[5]/td[4]/a")).click();
			    driver.findElement(By.id("accountName")).clear();
			    driver.findElement(By.id("accountName")).sendKeys("hum");
			    driver.findElement(By.id("csrAccountsSearchButton")).click();
			    driver.findElement(By.id("accountName")).clear();
			    driver.findElement(By.id("accountName")).sendKeys("");
			    driver.findElement(By.id("csrAccountsSearchButton")).click();
			    new Select(driver.findElement(By.id("csrStatus"))).selectByVisibleText("In-Active");
			    driver.findElement(By.id("csrAccountsSearchButton")).click();
			    new Select(driver.findElement(By.id("csrStatus"))).selectByVisibleText("Active");
			    driver.findElement(By.id("csrAccountsSearchButton")).click();
			    driver.findElement(By.xpath("(//a[contains(text(),'Active')])[10]")).click();
			    new Select(driver.findElement(By.id("status"))).selectByVisibleText("In-Active");
			    driver.findElement(By.id("contactSend")).click();
			    driver.findElement(By.xpath("//div[@id='csrTerminateBox']/div/span/h5/a/i")).click();
			    new Select(driver.findElement(By.id("csrStatus"))).selectByVisibleText("In-Active");
			    driver.findElement(By.id("csrAccountsSearchButton")).click();
			    driver.findElement(By.xpath("(//a[contains(text(),'In-Active')])[2]")).click();
			    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Active");
			    driver.findElement(By.id("contactSend")).click();
			    driver.findElement(By.id("contactSend")).click();
			    driver.findElement(By.xpath("//div[@id='csrTerminateBox']/div/span/h5/a/i")).click();
			    new Select(driver.findElement(By.id("csrStatus"))).selectByVisibleText("Active");
                 successMessage += "Success CSR Search ";
            }else{
   	       	 errorMessage += "Error, Incorrect username or password";
   	       	 MSBUtils.takeScreenShot(driver, repbean);
   	        }
    
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


