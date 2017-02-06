package com.msb.utilities;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date; 
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.msb.util.GenerateData;
import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;

public class EditConsultant {

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
		String page = "Add Consultant";
		String ruleId = "addConsultant";
		String userName = "Vendor Employee";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);
		GenerateData generateData=new GenerateData();

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "andy@ibsplc.com", "Msb1234");
//			MSBUtils.invoiceUtilitiesMenu();
			
			driver.findElement(By.xpath("//div[@id='accordian_my']/div/h4/a/span/i")).click();
		    driver.findElement(By.id("consultantsHomeMenuVen")).click();
		    driver.findElement(By.id("consult_name")).clear();
		    driver.findElement(By.id("consult_name")).sendKeys("corry");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.id("consult_name")).clear();
		    driver.findElement(By.id("consult_name")).sendKeys("");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.xpath("//a[@id='8']/i")).click();
		    driver.findElement(By.id("6")).click();
		    driver.findElement(By.id("consult_name")).clear();
		    driver.findElement(By.id("consult_name")).sendKeys("james");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.id("consult_name")).clear();
		    driver.findElement(By.id("consult_name")).sendKeys("James");
		    driver.findElement(By.id("consult_email")).clear();
		    driver.findElement(By.id("consult_email")).sendKeys("james@gmail.com");
		    driver.findElement(By.id("searchButton")).click();
		    driver.findElement(By.xpath("//a[contains(text(),'James  Lee')]")).click();
//		    driver.findElement(By.id("consult_midname")).clear();
//		    driver.findElement(By.id("consult_midname")).sendKeys("Jakson");
		    driver.findElement(By.id("consult_dob")).click();
		    driver.findElement(By.xpath("//div[7]/div/ul/li/span[2]")).click();
		    driver.findElement(By.xpath("//td[2]/div/ul[3]/li")).click();
		    driver.findElement(By.xpath("//div[7]/div/ul/li/span")).click();
		    driver.findElement(By.xpath("//td[2]/div[2]/ul/li")).click();
		    driver.findElement(By.xpath("//div[7]/div[3]/ul[3]/li[2]")).click();
		    driver.findElement(By.id("consult_ssnNo")).clear();
		    driver.findElement(By.id("consult_ssnNo")).sendKeys("654564564");
		    new Select(driver.findElement(By.id("consult_lcountry"))).selectByVisibleText("USA");
		    driver.findElement(By.id("consult_linkedInId")).clear();
		    driver.findElement(By.id("consult_linkedInId")).sendKeys("https://in.linkedin.com/in/akhlaque-ahmad-26782044");
		    driver.findElement(By.id("consult_twitterId")).clear();
		    driver.findElement(By.id("consult_twitterId")).sendKeys("https://in.linkedin.com/in/akhlaque-ahmad-26782044");
//		    new Select(driver.findElement(By.id("consultantIdProof"))).selectByVisibleText("Visa");
//		    Thread.sleep(2000);
//		    new Select(driver.findElement(By.id("consultantVisa"))).selectByVisibleText("H-1B");
//		    driver.findElement(By.id("idProofUpload")).click();
//		    driver.findElement(By.id("file")).click();
////		    driver.findElement(By.id("file")).clear();
//		    driver.findElement(By.id("file")).sendKeys("D:\\Self\\Document\\IMG_20140428_105829.jpg");
//		    driver.findElement(By.id("addButton")).click();
//		    driver.findElement(By.xpath("//div[@id='visaAttachOverlay']/div/span/h5/a/i")).click();
		    driver.findElement(By.id("consult_Address")).click();
		    driver.findElement(By.id("consult_Address")).clear();
		    driver.findElement(By.id("consult_Address")).sendKeys("Komaddi");
		    driver.findElement(By.id("consult_City")).clear();
		    driver.findElement(By.id("consult_City")).sendKeys("vizag");
//		    driver.findElement(By.id("consult_Country")).click();
//		    new Select(driver.findElement(By.id("consult_Country"))).selectByVisibleText("India");
//		    driver.findElement(By.xpath("//select[@id='consult_Country']/option[4]")).click();
//		    Thread.sleep(4000);
//		    driver.findElement(By.id("consult_State")).click();
//		    new Select(driver.findElement(By.xpath("//div[@id='AddressBox']/div[2]/span/select"))).selectByVisibleText("Andhra Pradesh");
//		    driver.findElement(By.xpath("//select[@id='consult_State']/option[2]")).click();
		    driver.findElement(By.id("consult_Zip")).click();
		    driver.findElement(By.id("consult_Zip")).clear();
		    driver.findElement(By.id("consult_Zip")).sendKeys("530048");
		    driver.findElement(By.id("consult_checkAddress")).click();
		    driver.findElement(By.id("consult_education")).clear();
		    driver.findElement(By.id("consult_education")).sendKeys("MCA");
		    driver.findElement(By.id("consult_jobTitle")).clear();
		    driver.findElement(By.id("consult_jobTitle")).sendKeys("Selenium Developer");
		    new Select(driver.findElement(By.id("consult_industry"))).selectByVisibleText("Computer & Network Security");
		    new Select(driver.findElement(By.id("consult_relocation"))).selectByVisibleText("Yes");
		    new Select(driver.findElement(By.id("consult_preferredCountry"))).selectByVisibleText("USA");
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//div[@id='consult_preferredState']/div/input")).click();
		    driver.findElement(By.xpath("//div[@id='task-panel']/div[3]/div[2]/div/div[5]")).click();
		    driver.findElement(By.id("savetask")).click();
		    driver.findElement(By.id("c_attach")).click();
		    driver.findElement(By.xpath("//div[@id='consult_attach']/a/button")).click();
//		    driver.findElement(By.id("consultAttachment")).clear();
		    driver.findElement(By.id("consultAttachment")).sendKeys("C:\\Users\\miracle\\Documents\\sample Resume\\JOHN HLOOMBERT CV.docx");
		    driver.findElement(By.id("consultAttachUpload")).click();
		    driver.findElement(By.xpath("//a[@id='vendorBackButton']/img")).click();
			successMessage += "Success Edit Consultant ";
			timetoProcess += "" + (new Date().getTime() - beging.getTime())/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Edit Consultant .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Edit Consultant .. " + errors.toString();
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

