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

public class ProjectDetails {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  GenerateData generateData;


  @Test
	public void testProjectSearch() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Project Search";
		String ruleId = "searchProject";
		String userName = "Project Manager";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);
		generateData =new GenerateData();

		try {
			 driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span/i", "projectsHomeProjectManager");
             if(MSBUtils.isElementPresent(By.id("prjctSearchButton"), driver)){
			    driver.findElement(By.id("projectReqSkillSet")).clear();
			    driver.findElement(By.id("projectReqSkillSet")).sendKeys("java");
			    driver.findElement(By.id("prjctSearchButton")).click();
			    driver.findElement(By.id("projectName")).clear();
			    driver.findElement(By.id("projectName")).sendKeys("mnm");
			    driver.findElement(By.id("prjctSearchButton")).click();
//			    driver.findElement(By.id("projectStartDate")).click();
//			    driver.findElement(By.xpath("//div[13]/div[3]/ul[2]/li[2]")).click();
//			    driver.findElement(By.xpath("//div[9]/div/ul/li/div")).click();
//			    driver.findElement(By.xpath("//div[9]/div[3]/ul[2]/li[2]")).click();
//			    driver.findElement(By.id("projectTargetDate")).click();
//			    driver.findElement(By.xpath("//div[9]/div/ul/li/div[2]")).click();
//			    driver.findElement(By.xpath("//div[9]/div/ul/li/div[2]")).click();
//			    driver.findElement(By.xpath("//div[9]/div[3]/ul[3]/li[3]")).click();
//			    driver.findElement(By.id("prjctSearchButton")).click();
//			    driver.findElement(By.id("projectTargetDate")).click();
			    driver.findElement(By.id("projectName")).click();
			    driver.findElement(By.id("projectName")).clear();
			    driver.findElement(By.id("projectReqSkillSet")).clear();
			    driver.findElement(By.id("prjctSearchButton")).click();
			    successMessage += "Success Project Search ";
             }else{
            	 errorMessage += "Error, Redirect to incorrect Project Search page";
            	 MSBUtils.takeScreenShot(driver, repbean);
             }
			    
   
	timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

} catch (Exception e) {
	returnvalue = false;
	System.out.println("Error in Project Search .. ");
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	errorMessage += " Error in Project Search .. "
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
	public void testAddMainProject() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Add Main Project";
		String ruleId = "addMainProject";
		String userName = "Project Manager";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);
		generateData =new GenerateData();

		try {
			 driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span/i", "projectsHomeProjectManager");
           if(MSBUtils.isElementPresent(By.id("prjctSearchButton"), driver)){
        	   driver.findElement(By.xpath("//a[@id='prjctAddButton']/button")).click();
        	    driver.findElement(By.id("projectNamePopup")).clear();
        	    String projectName= generateData.generateRandomString(6);
        	    driver.findElement(By.id("projectNamePopup")).sendKeys(projectName);
        	    driver.findElement(By.id("projectStartDateOverlay")).click();
        	    driver.findElement(By.xpath("//ul[3]/li[3]")).click();
        	    driver.findElement(By.id("projectTargetDateOverlay")).click();
        	    driver.findElement(By.xpath("//li/div[2]")).click();
        	    driver.findElement(By.xpath("//li/div[2]")).click();
        	    driver.findElement(By.xpath("//li/div[2]")).click();
        	    driver.findElement(By.xpath("//li/div[2]")).click();
        	    driver.findElement(By.xpath("//ul[3]/li[4]")).click();
        	    driver.findElement(By.id("projectTargetHrs")).clear();
        	    driver.findElement(By.id("projectTargetHrs")).sendKeys("520");
        	    new Select(driver.findElement(By.id("costCenterName"))).selectByVisibleText("cc-142");
        	    driver.findElement(By.id("projectReqSkillSetPopup")).clear();
        	    driver.findElement(By.id("projectReqSkillSetPopup")).sendKeys("javascript java");
        	    driver.findElement(By.id("project_descriptionPopup")).clear();
        	    driver.findElement(By.id("project_descriptionPopup")).sendKeys("test data");
        	    driver.findElement(By.id("addProjectButton")).click();
        	    driver.findElement(By.xpath("//a[@id='addPjctCloseButton']/i")).click();
        	   
			    successMessage += "Success Add Project ";
           }else{
          	 errorMessage += "Error, Redirect to incorrect Add Main Project  page";
          	 MSBUtils.takeScreenShot(driver, repbean);
           }
			    
 
	timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

} catch (Exception e) {
	returnvalue = false;
	System.out.println("Error in Add Main Project Details .. ");
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	errorMessage += " Error in Add Main Project Details .. "
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
 	public void testUpdateProject() throws Exception {
 		boolean returnvalue = true;
 		String query = "";
 		String errorMessage = "";
 		String successMessage = "";
 		String timetoProcess = "";
 		String page = "Update Project";
 		String ruleId = "updateProject";
 		String userName = "Project Manager";
 		String password = "";
 		String event_id = "";
 		ReportBean repbean = new ReportBean();
 		Date beging = new Date();
 		repbean.setRuleId(ruleId);
 		generateData =new GenerateData();

 		try {
 			 driver = MSBUtils.getDriver();
 			MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
 			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span/i", "projectsHomeProjectManager");
            if(MSBUtils.isElementPresent(By.id("prjctSearchButton"), driver)){
//            	driver.findElement(By.id("10")).click();
                driver.findElement(By.xpath("//form[@id='projectResultsForm']/span/a[6]")).click();
                driver.findElement(By.id("projectName")).clear();
                driver.findElement(By.id("projectName")).sendKeys("QA Automation");
                driver.findElement(By.id("prjctSearchButton")).click();
                driver.findElement(By.xpath("//table[@id='projectResults']/tbody/tr[2]/td/a")).click();
                driver.findElement(By.id("projectTargetDate")).click();
                driver.findElement(By.xpath("//li/div[2]")).click();
                driver.findElement(By.xpath("//li/div[2]")).click();
                driver.findElement(By.xpath("//li/div[2]")).click();
                driver.findElement(By.xpath("//li/div[2]")).click();
                driver.findElement(By.xpath("//ul[3]/li[4]")).click();
                driver.findElement(By.id("editProjectTargetHrs")).clear();
                driver.findElement(By.id("editProjectTargetHrs")).sendKeys("620");
                driver.findElement(By.id("project_descriptions")).clear();
                driver.findElement(By.id("project_descriptions")).sendKeys("edit test data");
                driver.findElement(By.id("projectReqSkills")).clear();
                driver.findElement(By.id("projectReqSkills")).sendKeys("java jquery sql");
                driver.findElement(By.id("updateProjectButton")).click();
                
                
//                WebElement  msg =driver.findElement(By.id("validation"));
//			    String resMessage=msg.getText();
//			    System.out.println("Message--->"+resMessage);
			    if(!(MSBUtils.isElementPresent(By.id("validation"), driver))){
			    	errorMessage += " Error in Updated Project Account .. " + "Please Enter Required field";
			    	MSBUtils.takeScreenShot(driver, repbean);
			    }else{
			    	 successMessage += "Success, Update Project ";
			    }
 			   
            }else{
           	 errorMessage += "Error, Redirect to incorrect Update Project  page";
           	 MSBUtils.takeScreenShot(driver, repbean);
            }
 			    
  
 	timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

 } catch (Exception e) {
 	returnvalue = false;
 	System.out.println("Error in Update Project Details .. ");
 	StringWriter errors = new StringWriter();
 	e.printStackTrace(new PrintWriter(errors));
 	errorMessage += " Error in Update Project Details .. "
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
  
  // For Sub Project
  
  @Test
	public void testAddSubProject() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Add Sub ProjectProject";
		String ruleId = "addSubProject";
		String userName = "Project Manager";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);
		generateData =new GenerateData();

		try {
			 driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span/i", "projectsHomeProjectManager");
			driver.findElement(By.id("projectName")).sendKeys("QA Automation");
            driver.findElement(By.id("prjctSearchButton")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//table[@id='projectResults']/tbody/tr[2]/td/a")).click();
            
          if(MSBUtils.isElementPresent(By.id("subProjectsLi"), driver)){
        	  Thread.sleep(6000);
        	  driver.findElement(By.xpath("//a[@id='subPjctAddButton']/button")).click();
        	    driver.findElement(By.id("projectNamePopup")).clear();
        	    String subProjectName=generateData.generateRandomString(6);
        	    driver.findElement(By.id("projectNamePopup")).sendKeys(subProjectName);
        	    driver.findElement(By.id("projectStartDateOverlay")).click();
        	    driver.findElement(By.xpath("//div[9]/div[3]/ul[3]/li[4]")).click();
        	    driver.findElement(By.id("projectTargetDateOverlay")).click();
        	    driver.findElement(By.xpath("//div[9]/div[3]/ul[5]/li[5]")).click();
        	    driver.findElement(By.id("projectTargetHrs")).clear();
        	    driver.findElement(By.id("projectTargetHrs")).sendKeys("40");
        	    driver.findElement(By.id("projectReqSkillSetPopup")).clear();
        	    driver.findElement(By.id("projectReqSkillSetPopup")).sendKeys("javascript");
        	    driver.findElement(By.id("project_descriptionPopup")).clear();
        	    driver.findElement(By.id("project_descriptionPopup")).sendKeys("test sub project");
        	    driver.findElement(By.id("addSubProjectButton")).click();
			    if(!(MSBUtils.isElementPresent(By.id("validation"), driver))){
			    	errorMessage += " Error in Add Sub Project Account .. " + "Please Enter Required field";
			    	MSBUtils.takeScreenShot(driver, repbean);
			    }else{
			    	 successMessage += "Success, Add Sub Project ";
			    }
			   
          }else{
         	 errorMessage += "Error, Redirect to incorrect Add Sub Project  page";
         	 MSBUtils.takeScreenShot(driver, repbean);
          }
			    

	timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

} catch (Exception e) {
	returnvalue = false;
	System.out.println("Error in Add Sub Project Details .. ");
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	errorMessage += " Error in Add Sub Project Details .. "
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

