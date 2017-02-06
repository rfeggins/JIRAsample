package com.msb.account;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Paths;
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

public class EditAccount {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
	public void testEditAccount() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Edit Account";
		String ruleId = "editAccount";
		String userName = "Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);
		GenerateData genData=new GenerateData();

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "nseerapu@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span", "accountInfoHomeCustAdmin");
           if(MSBUtils.isElementPresent(By.id("accountName"), driver)){
		    driver.findElement(By.xpath("//font[@value='east']")).click();
//		    driver.findElement(By.id("file")).clear();
		    driver.findElement(By.id("file")).sendKeys(Paths.get("").toAbsolutePath()+"\\sample\\CLogo.jpg");
		    driver.findElement(By.id("logoUpload")).click();
		    driver.findElement(By.id("account_address2")).clear();
		    driver.findElement(By.id("account_address2")).sendKeys("markzor");
//		    driver.findElement(By.id("account_zip")).clear();
		    driver.findElement(By.id("account_zip")).sendKeys("MR5465");
		    Thread.sleep(2000);
		    new Select(driver.findElement(By.id("account_state"))).selectByVisibleText("Florida");
		    Thread.sleep(2000);
		    new Select(driver.findElement(By.id("account_industry"))).selectByVisibleText("Products and Services");
		    driver.findElement(By.id("account_region")).clear();
		    Thread.sleep(2000);
		    driver.findElement(By.id("account_region")).sendKeys("north");
		    driver.findElement(By.id("account_noemp")).clear();
		    driver.findElement(By.id("account_noemp")).sendKeys("562");
		    driver.findElement(By.id("account_taxid")).clear();
		    driver.findElement(By.id("account_taxid")).sendKeys("5465465");
		    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div")).click();
		    driver.findElement(By.xpath("//div[@id='task-panel']/div[4]/div/div/div[2]/div/div")).click();
		    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div")).click();
		    driver.findElement(By.xpath("//div[@id='task-panel']/div[4]/div/div/div[2]/div/div[2]")).click();
		    driver.findElement(By.id("account_description")).clear();
		    driver.findElement(By.id("account_description")).sendKeys("test description");
		    driver.findElement(By.id("beneficiaryName")).clear();
		    driver.findElement(By.id("beneficiaryName")).sendKeys("Idaho ulam");
		    driver.findElement(By.id("bankName")).clear();
		    driver.findElement(By.id("bankName")).sendKeys("AXIS");
		    driver.findElement(By.id("Bank Account No.")).clear();
		    //For masked input 
		    driver.findElement(By.id("Bank Account No.")).click();
		    driver.findElement(By.id("Bank Account No.")).sendKeys(Keys.HOME+ "5467892365");
		    driver.findElement(By.id("bankRoutingNumber")).clear();
		    driver.findElement(By.id("bankRoutingNumber")).sendKeys("6546");
		    driver.findElement(By.id("bankCity")).clear();
		    driver.findElement(By.id("bankCity")).sendKeys("Idhao");
		    driver.findElement(By.id("bankZip")).clear();
		    driver.findElement(By.id("bankZip")).sendKeys("ID6548");
		    driver.findElement(By.xpath("//a[@id='detailsFormSubmit']/button")).click();
		    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div/span[4]/a/i")).click();
		    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div/span[4]/a/i")).click();
		    driver.findElement(By.xpath("//a[@id='detailsFormSubmit']/button")).click();
		    driver.findElement(By.xpath("//div[@id='panel-task-body']/ul/li/a/img")).click();
		    driver.findElement(By.xpath("//a[@id='location']/font")).click();
            successMessage += "Success, Edit Account ";
           }else{
          	 errorMessage += "Error, Redirect to incorrect Edit Account page";
          	 MSBUtils.takeScreenShot(driver, repbean);
           }
	timetoProcess += "" + (new Date().getTime() - beging.getTime())
			/ 1000;

} catch (Exception e) {
	returnvalue = false;
	System.out.println("Error in Edit Account .. ");
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	errorMessage += " Error in Edit Account .. " + errors.toString();
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

