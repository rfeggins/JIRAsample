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

public class Question {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Test
	public void aTestQuestionSearch() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Question Search";
		String ruleId = "questionSearch";
		String userName = "Customer Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "nseerapu@interfaceglobal.com","Msb1234");
            MSBUtils.leftMenu(driver, "(//div[@id='accordian_services']/div/h4/a/span/i)[2]", "questionsUtilitiesCustAdmin");
			if(MSBUtils.isElementPresent(By.id("question"), driver)){
			driver.findElement(By.id("question")).clear();
			driver.findElement(By.id("question")).sendKeys("what");
			driver.findElement(By.id("searchQuestionsForm")).click();
			driver.findElement(By.id("question")).clear();
			driver.findElement(By.id("question")).sendKeys("");
			new Select(driver.findElement(By.id("examType"))).selectByVisibleText("Psychometric");
			driver.findElement(By.id("searchQuestionsForm")).click();
			driver.findElement(By.id("searchQuestionsForm")).click();
			new Select(driver.findElement(By.id("answerType"))).selectByVisibleText("Multiple");
			driver.findElement(By.id("searchQuestionsForm")).click();
			new Select(driver.findElement(By.id("answerType"))).selectByVisibleText("All");
			driver.findElement(By.id("searchQuestionsForm")).click();
			
			successMessage += "Success, Question Search ";
		}else{
          	 errorMessage += "Error, Redirect to incorrect Question Search page";
          	 MSBUtils.takeScreenShot(driver, repbean);
           }
			timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Question Upload .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Question Upload .. " + errors.toString();
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
	public void bTestQuestionAdd() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Question Add";
		String ruleId = "questionAdd";
		String userName = "Customer Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "nseerapu@interfaceglobal.com","Msb1234");
            MSBUtils.leftMenu(driver, "(//div[@id='accordian_services']/div/h4/a/span)[2]", "questionsUtilitiesCustAdmin");
			
			if(MSBUtils.isElementPresent(By.id("question"), driver)){
			driver.findElement(By.id("addEditQuestions")).click();
//			new Select(driver.findElement(By.id("skillCategoryValue"))).selectByVisibleText("javascript");
			
			// driver.findElement(By.id("question")).clear();
			driver.findElement(By.id("question")).sendKeys("What is Javascript");
			driver.findElement(By.id("option1")).clear();
			driver.findElement(By.id("option1")).sendKeys("scripting language");
			driver.findElement(By.id("option2")).clear();
			driver.findElement(By.id("option2")).sendKeys("technology");
			driver.findElement(By.id("option3")).clear();
			driver.findElement(By.id("option3")).sendKeys("above");
			driver.findElement(By.id("option4")).clear();
			driver.findElement(By.id("option4")).sendKeys("none");
			driver.findElement(By.id("answerAnswer1")).click();
			driver.findElement(By.id("addEditSubmit")).click();
			driver.findElement(By.cssSelector("i.fa.fa-undo")).click();
			driver.findElement(By.xpath("//div[2]/a")).click();
			Thread.sleep(2000);
			new Select(driver.findElement(By.id("skillCategoryValue"))).selectByVisibleText("Datapower");
			// driver.findElement(By.id("question")).clear();
			driver.findElement(By.id("question")).sendKeys("Can you find the correct number which should replace the question mark in the picture below");
			driver.findElement(By.id("isPic")).click();
			// driver.findElement(By.id("showImg")).clear();
			driver.findElement(By.id("showImg")).sendKeys("C:\\Users\\miracle\\Pictures\\Question-Mark.jpg");
			driver.findElement(By.id("option1")).clear();
			driver.findElement(By.id("option1")).sendKeys("12");
			driver.findElement(By.id("option2")).clear();
			driver.findElement(By.id("option2")).sendKeys("15");
			driver.findElement(By.id("option3")).clear();
			driver.findElement(By.id("option3")).sendKeys("25");
			driver.findElement(By.id("option4")).clear();
			driver.findElement(By.id("option4")).sendKeys("18");
			driver.findElement(By.id("option5")).clear();
			driver.findElement(By.id("option5")).sendKeys("17");
			driver.findElement(By.id("option6")).clear();
			driver.findElement(By.id("option6")).sendKeys("34");
			driver.findElement(By.id("answerAnswer3")).click();
			driver.findElement(By.id("addEditSubmit")).click();
			driver.findElement(By.cssSelector("i.fa.fa-undo")).click();
			driver.findElement(By.linkText("What is Javascript")).click();
			driver.findElement(	By.xpath("//div[@id='quesOverlayBox']/div/span/h5/a/i")).click();
			driver.findElement(By.xpath("//table[@id='QuestionsList']/tbody/tr[3]/td/center/a/i")).click();
			driver.findElement(By.id("answerAnswer2")).click();
			driver.findElement(By.id("addEditSubmit")).click();
			driver.findElement(By.xpath("//span/a/i")).click();
			successMessage += "Success Question Add ";
			}else{
           	 errorMessage += "Error, Redirect to incorrect Question Add page";
           	 MSBUtils.takeScreenShot(driver, repbean);
            }
			timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Question Upload .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Question Upload .. " + errors.toString();
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
