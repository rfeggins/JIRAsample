package com.msb.home;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Paths;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
 
 
 
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TaskDetails {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

 

	@Test
	public void aTestTaskSearch() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Task Search";
		String ruleId = "taskSearch";
		String userName = "Project-Manager";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span", "tasksHomeProjectManager");
			if(MSBUtils.isElementPresent(By.id("addTaskButtonCustomer"), driver)){
			
//		    driver.findElement(By.xpath("(//a[@id='2']/i)[2]")).click();
//		    driver.findElement(By.xpath("//a[@id='1']/i")).click();
		    driver.findElement(By.id("task_name")).clear();
		    driver.findElement(By.id("task_name")).sendKeys("test");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.id("docdatepickerfrom")).click();
		    driver.findElement(By.xpath("//div/ul/li/div")).click();
		    driver.findElement(By.xpath("//div/ul/li/div")).click();
		    driver.findElement(By.xpath("//div/ul/li/div")).click();
		    driver.findElement(By.xpath("//div/ul/li/div")).click();
		    driver.findElement(By.xpath("//ul[3]/li[2]")).click();
		    driver.findElement(By.id("searchButton")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Re-opened");
		    driver.findElement(By.id("searchButton")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Opened");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.id("task_name")).clear();
		    driver.findElement(By.id("task_name")).sendKeys("");
		    driver.findElement(By.id("searchButton")).click();
		   
			successMessage += "Success, Task Search ";
			 }else{
            	 errorMessage += "Error, Redirect to incorrect Task Search page";
            	 MSBUtils.takeScreenShot(driver, repbean);
             }
			timetoProcess += "" + (new Date().getTime() - beging.getTime())
					/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Task Page .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Task Page .. "
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
	public void bTestAddTask() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Add Task ";
		String ruleId = "addTask";
		String userName = "Project-Manager";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span", "tasksHomeProjectManager");
//			MSBUtils.taskHomeMenu();
			if(MSBUtils.isElementPresent(By.id("addTaskButtonCustomer"), driver)){
			
		    driver.findElement(By.id("addTaskButtonCustomer")).click();
		    driver.findElement(By.id("startDate")).click();
		    driver.findElement(By.xpath("//ul[3]/li[4]")).click();
		    driver.findElement(By.id("endDate")).click();
		    driver.findElement(By.xpath("//li/div[2]")).click();
		    driver.findElement(By.xpath("//li/div[2]")).click();
		    driver.findElement(By.xpath("//ul[3]/li[5]")).click();
		    new Select(driver.findElement(By.id("task_priority"))).selectByVisibleText("High");
		    new Select(driver.findElement(By.id("task_priority"))).selectByVisibleText("Low");
		    new Select(driver.findElement(By.id("taskRelatedTo"))).selectByVisibleText("Projects");
		    new Select(driver.findElement(By.id("taskType"))).selectByVisibleText("MSB Second");
		    driver.findElement(By.id("task_name")).clear();
		    driver.findElement(By.id("task_name")).sendKeys("MSB selenium test");
		    driver.findElement(By.id("task_comments")).clear();
		    driver.findElement(By.id("task_comments")).sendKeys("description");
		    driver.findElement(By.id("secondaryReport")).clear();
		    driver.findElement(By.id("secondaryReport")).sendKeys("na");
		    driver.findElement(By.xpath("//table[@id='completeTable']/tbody/tr/td/a")).click();
//		    driver.findElement(By.id("taskAttachment")).clear();
		    driver.findElement(By.id("taskAttachment")).sendKeys(Paths.get("").toAbsolutePath()+"\\sample\\sample Resume\\John CV.docx");
		    driver.findElement(By.id("addTaskButton")).click();
		    
			successMessage += "Success, Add Task ";
			 }else{
            	 errorMessage += "Error, Redirect to incorrect Add Task page";
            	 MSBUtils.takeScreenShot(driver, repbean);
             }
			timetoProcess += "" + (new Date().getTime() - beging.getTime())
					/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Add Task Page .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Add Task Page .. "
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
	public void cTestEditTask() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Edit Task";
		String ruleId = "editTask";
		String userName = "Project-Manager";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span", "tasksHomeProjectManager");
//			MSBUtils.taskHomeMenu();
			if(MSBUtils.isElementPresent(By.id("addTaskButtonCustomer"), driver)){
			
		    driver.findElement(By.xpath("//table[@id='teamTaskTable']/tbody/tr[3]/td/a")).click();
		    driver.findElement(By.xpath("//a[@id='editTaskSearchBackButtton']/i")).click();
		    driver.findElement(By.id("task_name")).clear();
		    driver.findElement(By.id("task_name")).sendKeys("MSB selenium");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.xpath("//table[@id='teamTaskTable']/tbody/tr[2]/td/a")).click();
		    driver.findElement(By.id("task_comments")).clear();
		    driver.findElement(By.id("task_comments")).sendKeys("edit description test");
		    driver.findElement(By.id("end_date")).click();
		    driver.findElement(By.xpath("//li/div[2]")).click();
		    driver.findElement(By.xpath("//li/div[2]")).click();
		    driver.findElement(By.xpath("//li/div[2]")).click();
		    driver.findElement(By.xpath("//ul[3]/li[5]")).click();
		    driver.findElement(By.xpath("//li[@id='profileLi']/a")).click();
		    driver.findElement(By.xpath("//a[@id='addAttachmentPopUpButton']/button")).click();
//		    driver.findElement(By.id("taskAttachment")).clear();
		    driver.findElement(By.id("taskAttachment")).sendKeys(Paths.get("").toAbsolutePath()+"\\sample\\sample Resume\\JOHN HLOOMBERT CV.docx");
		    driver.findElement(By.id("addAttachment_0")).click();
		    driver.findElement(By.xpath("//li[@id='messagesLi']/a")).click();
		    driver.findElement(By.xpath("//a[@id='addNotesOverlay']/button")).click();
		    driver.findElement(By.id("noteNamesadd")).clear();
		    driver.findElement(By.id("noteNamesadd")).sendKeys("Login Automation");
		    driver.findElement(By.id("noteCommentsadd")).clear();
		    driver.findElement(By.id("noteCommentsadd")).sendKeys("test description");
		    driver.findElement(By.id("addNoteButton")).click();
		    driver.findElement(By.xpath("//a[@id='closeNoteOverlayButton']/i")).click();
		    driver.findElement(By.id("notes_NameSearch")).click();
		    driver.findElement(By.xpath("//li[@id='profileLi']/a")).click();
		    driver.findElement(By.xpath("//li[@id='homeLi']/a")).click();
		    driver.findElement(By.xpath("//a[@id='editTaskSearchBackButtton']/i")).click();
			successMessage += "Success, Edit Task ";
			 }else{
            	 errorMessage += "Error, Redirect to incorrect Edit Task page";
            	 MSBUtils.takeScreenShot(driver, repbean);
             }
			timetoProcess += "" + (new Date().getTime() - beging.getTime())
					/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Edit Task Page .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Edit Task Page .. "
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
//			fail(verificationErrorString);
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

