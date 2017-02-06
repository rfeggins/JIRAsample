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

public class EditRequirement {
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
		String page = "Requirement";
		String ruleId = "editRequirement";
		String userName = "Project-Manager";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "vsiram@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span", "requirementsHomeProjectManager");
//			MSBUtils.requirementHomeMenu();
			if(MSBUtils.isElementPresent(By.id("jdId"), driver)){
			driver.findElement(By.xpath("//div[@id='accordian_my']/div/h4/a/span/i")).click();
		    driver.findElement(By.id("requirementsHomeProjectManager")).click();
		    driver.findElement(By.xpath("//form[@id='RequirementListAllForm']/div/div/div/input")).clear();
		    driver.findElement(By.xpath("//form[@id='RequirementListAllForm']/div/div/div/input")).sendKeys("jd-219");
		    driver.findElement(By.id("requirementsListSearch")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//table[@id='reqTableInRecruiter']/tbody/tr[2]/td/a")).click();
		    driver.findElement(By.id("RequirementFrom")).click();
		    driver.findElement(By.xpath("//div/ul/li/div")).click();
		    driver.findElement(By.xpath("//div/ul/li/div")).click();
		    driver.findElement(By.xpath("//ul[3]/li[2]")).click();
		    driver.findElement(By.id("RequirementNoofResources")).clear();
		    driver.findElement(By.id("RequirementNoofResources")).sendKeys("5");
		    driver.findElement(By.id("RequirementDuration")).clear();
		    driver.findElement(By.id("RequirementDuration")).sendKeys("4");
		    driver.findElement(By.id("RequirementDuration")).clear();
		    driver.findElement(By.id("RequirementDuration")).sendKeys("12");
		    new Select(driver.findElement(By.id("requirementDurationDescriptor"))).selectByVisibleText("Weeks");
		    new Select(driver.findElement(By.id("RequirementYears"))).selectByVisibleText("3-6 yrs");
		    new Select(driver.findElement(By.id("RequirementLocation"))).selectByVisibleText("Onsite");
		    new Select(driver.findElement(By.id("RequirementContact1"))).selectByVisibleText("Anderson.Hamilton");
		    new Select(driver.findElement(By.id("RequirementContact2"))).selectByVisibleText("William.Cook");
		    new Select(driver.findElement(By.id("billingContact"))).selectByVisibleText("Jackiee.Chink");
		    driver.findElement(By.id("RequirementTargetRate")).clear();
		    driver.findElement(By.id("RequirementTargetRate")).sendKeys("25");
		    driver.findElement(By.id("requirementMaxRate")).clear();
		    driver.findElement(By.id("requirementMaxRate")).sendKeys("30");
		    driver.findElement(By.id("requirementQualification")).clear();
		    driver.findElement(By.id("requirementQualification")).sendKeys("MCA or Btech");
		    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div")).click();
		    driver.findElement(By.xpath("//form[@id='#']/span/div[5]/div/span/div[2]/div/div")).click();
		    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div")).click();
		    driver.findElement(By.xpath("//form[@id='#']/span/div[5]/div/span/div[2]/div/div[2]")).click();
		    driver.findElement(By.xpath("//div[@id='preSkillCategoryValue']/div")).click();
		    driver.findElement(By.xpath("//form[@id='#']/span/div[5]/div[2]/div[2]/div/div")).click();
		    driver.findElement(By.id("RequirementComments")).clear();
		    driver.findElement(By.id("RequirementComments")).sendKeys("test");
		    driver.findElement(By.id("update")).click();
		    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div/span[3]/a/i")).click();
		    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div/span[3]/a/i")).click();
		    driver.findElement(By.xpath("//div[@id='preSkillCategoryValue']/div/span[3]/a")).click();
		    driver.findElement(By.id("update")).click();
		    driver.findElement(By.xpath("//li[@id='vendorAssociationLi']/a")).click();
		    driver.findElement(By.id("status")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("In-Active");
		    driver.findElement(By.id("vendorAssociationSearchButton")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Active");
		    driver.findElement(By.id("vendorAssociationSearchButton")).click();
		    driver.findElement(By.xpath("//table[@id='vendorAssociationResults']/tbody/tr[2]/td/a")).click();
		    new Select(driver.findElement(By.id("statusEdit"))).selectByVisibleText("In-Active");
		    driver.findElement(By.id("vendorAssociationUpdateButton")).click();
		    new Select(driver.findElement(By.id("status"))).selectByVisibleText("In-Active");
		    driver.findElement(By.id("vendorAssociationSearchButton")).click();
		    driver.findElement(By.xpath("//table[@id='vendorAssociationResults']/tbody/tr[2]/td/a")).click();
		    new Select(driver.findElement(By.id("statusEdit"))).selectByVisibleText("Active");
		    driver.findElement(By.id("vendorAssociationUpdateButton")).click();
		    driver.findElement(By.id("vendorAssociationAddButton")).click();
		    new Select(driver.findElement(By.id("tireType"))).selectByVisibleText("Tier-1");
		    driver.findElement(By.id("accessTime")).click();
		    driver.findElement(By.xpath("//div[12]/div[3]/ul[2]/li[6]")).click();
		    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=vendorNames | label=Devcare Solutions]]
		    driver.findElement(By.id("vendorAssociationSaveButton")).click();
		    driver.findElement(By.xpath("//a[@id='vendorAddAssociationOverlayClose']/i")).click();
		    driver.findElement(By.xpath("//li[@id='consultantListLi']/a")).click();
		    driver.findElement(By.id("vendorName")).clear();
		    driver.findElement(By.id("vendorName")).sendKeys("ibb");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.id("vendorName")).clear();
		    driver.findElement(By.id("vendorName")).sendKeys("ibs");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.id("vendorName")).clear();
		    driver.findElement(By.id("vendorName")).sendKeys("");
		    driver.findElement(By.id("consult_name")).clear();
		    driver.findElement(By.id("consult_name")).sendKeys("Mark");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.id("consult_name")).clear();
		    driver.findElement(By.id("consult_name")).sendKeys("");
		    driver.findElement(By.id("consult_ssnNo")).clear();
		    driver.findElement(By.id("consult_ssnNo")).sendKeys("987");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.id("consult_ssnNo")).clear();
		    driver.findElement(By.id("consult_ssnNo")).sendKeys("");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.id("consult_ssnNo")).clear();
		    driver.findElement(By.id("consult_ssnNo")).sendKeys("98712391");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.id("consult_ssnNo")).clear();
		    driver.findElement(By.id("consult_ssnNo")).sendKeys("9871");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.id("consult_ssnNo")).clear();
		    driver.findElement(By.id("consult_ssnNo")).sendKeys("");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.id("consult_skill")).clear();
		    driver.findElement(By.id("consult_skill")).sendKeys("java");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.id("consult_skill")).clear();
		    driver.findElement(By.id("consult_skill")).sendKeys("");
		    driver.findElement(By.xpath("//a[contains(text(),'Akhlaque  Ahmad')]")).click();
		    driver.findElement(By.xpath("//a[@id='techReviewBackButton']/i")).click();
		    driver.findElement(By.xpath("//table[@id='consultantListTable']/tbody/tr[2]/td[9]/a")).click();
		    driver.findElement(By.id("techSearchButton")).click();
		    driver.findElement(By.id("searchInterviewDate")).click();
		    driver.findElement(By.xpath("//div[4]/div[3]/ul[2]/li[5]")).click();
		    driver.findElement(By.id("techSearchButton")).click();
		    driver.findElement(By.xpath("//div[@id='profileBox']/div/div/h4/span/a/i")).click();
		    driver.findElement(By.xpath("//a[@id='reqBackButton']/img")).click();
			successMessage += "Success : Edit Requirement ";
			}else{
           	 errorMessage += "Error, Redirect to incorrect Edit Requirement page";
           	 MSBUtils.takeScreenShot(driver, repbean);
            }
			timetoProcess += "" + (new Date().getTime() - beging.getTime())
					/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Edit Requirement .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Edit Requirement .. "
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
