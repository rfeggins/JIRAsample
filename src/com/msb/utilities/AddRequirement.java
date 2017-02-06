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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;

public class AddRequirement {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Test
	public void testAddRequirement() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Requirement";
		String ruleId = "addRequirement";
		String userName = "Project Manager";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
			MSBUtils.requirementHomeMenu();

			// driver.get(baseUrl
			// +
			// "/MSB/recruitment/consultant/getLoginUserRequirementList.action?orgid=10002&customerFlag=customer&accountFlag=MyRequirements");
			driver.findElement(By.xpath("//section[@id='generalForm']/div/div[2]/div[2]/img")).click();
			driver.findElement(By.id("reqAddPopup")).click();
//			driver.findElement(By.xpath("//form[@id='RequirementListAllForm']/div/div/div[8]/div[2]/a/i")).click();
			driver.findElement(By.id("RequirementName")).clear();
			driver.findElement(By.id("RequirementName")).sendKeys("Selenium Webdriver");
			driver.findElement(By.id("RequirementFrom")).click();
			driver.findElement(By.xpath("//div[3]/div[3]/ul[5]/li[3]")).click();
			new Select(driver.findElement(By.id("RequirementContact1"))).selectByVisibleText("William.Cook");
			driver.findElement(By.id("RequirementNoofResources")).clear();
			driver.findElement(By.id("RequirementNoofResources")).sendKeys("3");
			driver.findElement(By.id("RequirementTargetRate")).clear();
			driver.findElement(By.id("RequirementTargetRate")).sendKeys("45");
			driver.findElement(By.id("requirementMaxRate")).clear();
			driver.findElement(By.id("requirementMaxRate")).sendKeys("65");
			new Select(driver.findElement(By.id("RequirementContact2"))).selectByVisibleText("Anderson.Hamilton");
			driver.findElement(By.id("RequirementDuration")).clear();
			driver.findElement(By.id("RequirementDuration")).sendKeys("45");
			new Select(driver.findElement(By.id("requirementDurationDescriptor"))).selectByVisibleText("Weeks");
			new Select(driver.findElement(By.id("billingContact"))).selectByVisibleText("Akhlaque.Ahmad");
			new Select(driver.findElement(By.id("RequirementYears"))).selectByVisibleText("3-6 yrs");
			driver.findElement(By.id("requirementQualification")).clear();
			driver.findElement(By.id("requirementQualification")).sendKeys("Write readable, maintainable, high performance automation\n• Develop test plans and test cases\n• Write design and functional specifications for use in testing\n• Prepare estimates for assigned tasks and complete all work according t");
			driver.findElement(By.id("RequirementJobdesc")).clear();
			driver.findElement(By.id("RequirementJobdesc"))	.sendKeys("Write readable, maintainable, high performance automation\n• Develop test plans and test cases\n• Write design and functional specifications for use in testing\n• Prepare estimates for assigned tasks and complete all work according to schedule and quality requirements");
			driver.findElement(By.id("RequirementResponse")).clear();
			driver.findElement(By.id("RequirementResponse")).sendKeys("Write readable, maintainable, high performance automation\n• Develop test plans and test cases\n• Write design and functional specifications for use in testing\n• Prepare estimates for assigned tasks and complete all work according to schedule and quality requirements");
			driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div/input")).click();
			driver.findElement(By.xpath("//form[@id='addRequirements']/span/div[7]/div/span/div[2]/div/div[3]")).click();
			driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div/span/a/i")).click();
			driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div/input")).click();
			driver.findElement(By.xpath("//form[@id='addRequirements']/span/div[7]/div/span/div[2]/div/div")).click();
			driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div"))	.click();
			driver.findElement(By.xpath("//form[@id='addRequirements']/span/div[7]/div/span/div[2]/div/div[3]")).click();
			driver.findElement(By.xpath("//div[@id='preSkillCategoryValue']/div/input")).click();
			driver.findElement(By.xpath("//form[@id='addRequirements']/span/div[7]/div[2]/div[2]/div/div[6]"))	.click();
			driver.findElement(By.id("requirementSubmit")).click();
			Thread.sleep(2000);
			if(MSBUtils.isElementPresent(By.xpath("html/body/div[1]/div/section/div/div/div[2]/div/div/div/div[3]/form/span/reqadded/b/font"), driver)){
			successMessage += "Success AddRequirement ";
			}else{ 
				errorMessage += " Error in Add Requirement .. " + "Please fill required field";
				MSBUtils.takeScreenShot(driver, repbean);
			}
			timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Add Requirement .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Add Requirement .. " + errors.toString();
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
			// fail(verificationErrorString);
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
