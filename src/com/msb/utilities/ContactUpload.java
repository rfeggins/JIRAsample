package com.msb.utilities;


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

public class ContactUpload {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  GenerateData genData;

  @Test
	public void testSiteAdminLogin() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Contact Upload";
		String ruleId = "contactUpload";
		String userName = "Site-Administrator";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);
		genData=new GenerateData();

		try {
			 driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "msbadmin@abc.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_team']/div/h4/a/span/i", "uploadContactsUtilitiesMenuAdmin");
			 if(MSBUtils.isElementPresent(By.id("sumbitUserUpload"), driver)){
//			    driver.findElement(By.id("file")).clear();
			 // Generate random string
			    String randomStr= genData.generateRandomString(8);
			    System.out.println("Generated String:-"+randomStr);
			    // Current file
			    String curFile= Paths.get("").toAbsolutePath()+"\\sample\\SampleFile\\ContactList11.xls";
			    String genratedFile =Paths.get("").toAbsolutePath()+"\\sample\\SampleFile\\"+randomStr+".xls";
			    //Copying new same file with random name
			    MSBUtils.copyFile(curFile, genratedFile);
			    driver.findElement(By.id("file")).sendKeys(Paths.get("").toAbsolutePath()+"\\sample\\SampleFile\\"+randomStr+".xls");
			    
//			    driver.findElement(By.id("file")).sendKeys("C:\\Users\\miracle\\Documents\\SampleFile\\ContactList11.xls");
			    driver.findElement(By.id("sumbitUserUpload")).click();
			    new Select(driver.findElement(By.id("contactMname"))).selectByVisibleText("Middle Name(1,0)");
			    new Select(driver.findElement(By.id("contactLname"))).selectByVisibleText("Last Name(2,0)");
			    new Select(driver.findElement(By.id("email1"))).selectByVisibleText("Email(3,0)");
			    new Select(driver.findElement(By.id("email2"))).selectByVisibleText("Alternate Email(14,0)");
			    new Select(driver.findElement(By.id("contactGender"))).selectByVisibleText("Gender(13,0)");
			    new Select(driver.findElement(By.id("workPhone"))).selectByVisibleText("Office Phone(4,0)");
			    new Select(driver.findElement(By.id("phone"))).selectByVisibleText("Mobile Phone(5,0)");
			    new Select(driver.findElement(By.id("phone1"))).selectByVisibleText("Home Phone(12,0)");
			    new Select(driver.findElement(By.id("title"))).selectByVisibleText("Title(15,0)");
			    new Select(driver.findElement(By.id("address"))).selectByVisibleText("Address2(7,0)");
			    new Select(driver.findElement(By.id("address2"))).selectByVisibleText("Address2(7,0)");
			    new Select(driver.findElement(By.id("city"))).selectByVisibleText("City(8,0)");
			    new Select(driver.findElement(By.id("country"))).selectByVisibleText("Country(10,0)");
			    new Select(driver.findElement(By.id("state"))).selectByVisibleText("State(11,0)");
			    new Select(driver.findElement(By.id("zip"))).selectByVisibleText("Zip(9,0)");
			    driver.findElement(By.id("saveButton")).click();
			    driver.findElement(By.id("created_Date")).click();
			    driver.findElement(By.xpath("//ul[2]/li[4]")).click();
			    driver.findElement(By.id("searchButton")).click();
			    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Success");
			    driver.findElement(By.id("searchButton")).click();
			    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Un-Success");
			    driver.findElement(By.id("searchButton")).click();
               successMessage += "Success, Contact Upload ";
			 }else{
            	 errorMessage += "Error, Redirect to incorrect Contact Upload page";
            	 MSBUtils.takeScreenShot(driver, repbean);
             }
	timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

} catch (Exception e) {
	returnvalue = false;
	System.out.println("Error in Contact Upload .. ");
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	errorMessage += " Error in Contact Upload .. "
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

