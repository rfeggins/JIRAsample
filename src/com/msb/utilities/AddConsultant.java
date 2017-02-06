package com.msb.utilities;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Paths;
import java.util.Date; 

import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.msb.util.GenerateData;
import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;

public class AddConsultant {

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
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span", "addConsultantHomeMenuVen");
            if(MSBUtils.isElementPresent(By.id("consult_email"), driver)){
		    driver.findElement(By.id("consult_email")).clear();
		    driver.findElement(By.id("consult_email")).sendKeys(generateData.generateEmail(15));
		    new Select(driver.findElement(By.id("consult_available"))).selectByVisibleText("Yes");
		    driver.findElement(By.id("consult_add_date")).click();
		    driver.findElement(By.xpath("//ul[2]/li[6]")).click();
		    driver.findElement(By.id("consult_fstname")).clear();
		    driver.findElement(By.id("consult_fstname")).sendKeys("Fossil");
		    driver.findElement(By.id("consult_lstname")).clear();
		    driver.findElement(By.id("consult_lstname")).sendKeys("Komal");
		    driver.findElement(By.id("consult_dob")).click();
		    driver.findElement(By.xpath("//div[3]/div/ul/li/span[2]")).click();
		    driver.findElement(By.xpath("//div[6]/table/tbody/tr/td")).click();
		    driver.findElement(By.xpath("//div[6]/table/tbody/tr/td")).click();
		    driver.findElement(By.xpath("//div[6]/table/tbody/tr/td")).click();
		    driver.findElement(By.xpath("//div[6]/table/tbody/tr/td")).click();
		    driver.findElement(By.xpath("//td[2]/div/ul[2]/li")).click();
		    driver.findElement(By.xpath("//div[3]/div[3]/ul[2]/li[3]")).click();
		    
		 // for masked input text box (mobile number)
//		    driver.findElement(By.id("consult_mobileNo")).click();
//		    driver.findElement(By.id("consult_mobileNo")).sendKeys(Keys.HOME+ "5467892365");
		    
		    driver.findElement(By.id("consult_ssnNo")).clear();
		    driver.findElement(By.id("consult_ssnNo")).sendKeys("455646454");
		    new Select(driver.findElement(By.id("consult_lcountry"))).selectByVisibleText("USA");
		    driver.findElement(By.id("consult_Address")).click();
		    driver.findElement(By.id("consult_Address")).clear();
		    driver.findElement(By.id("consult_Address")).sendKeys("giri park");
		    driver.findElement(By.id("consult_City")).clear();
		    driver.findElement(By.id("consult_City")).sendKeys("novelty");
		    driver.findElement(By.id("consult_Country")).click();
		    driver.findElement(By.xpath("//select[@id='consult_Country']/option[6]")).click();
		    new Select(driver.findElement(By.id("consult_State"))).selectByVisibleText("Florida");
		    driver.findElement(By.id("consult_Zip")).click();
		    driver.findElement(By.id("consult_Zip")).clear();
		    driver.findElement(By.id("consult_Zip")).sendKeys("FL0987");
		    driver.findElement(By.id("addconsult_checkAddress")).click();
		    driver.findElement(By.id("consult_education")).clear();
		    driver.findElement(By.id("consult_education")).sendKeys("MCA");
		    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div")).click();
		    driver.findElement(By.xpath("//form[@id='consultantForm']/div[5]/div[2]/div/div")).click();
		    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div")).click();
		    driver.findElement(By.xpath("//form[@id='consultantForm']/div[5]/div[2]/div/div[2]")).click();
		    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div")).click();
		    driver.findElement(By.xpath("//form[@id='consultantForm']/div[5]/div[2]/div/div[3]")).click();
		    driver.findElement(By.id("consult_jobTitle")).clear();
		    driver.findElement(By.id("consult_jobTitle")).sendKeys("Developer");
		    new Select(driver.findElement(By.id("consult_experience"))).selectByVisibleText("1-3 yrs");
		    new Select(driver.findElement(By.id("consult_wcountry"))).selectByVisibleText("India");
		    new Select(driver.findElement(By.id("consult_industry"))).selectByVisibleText("software Industry");
		    driver.findElement(By.id("consult_referredBy")).clear();
		    driver.findElement(By.id("consult_referredBy")).sendKeys("Raja");
		    driver.findElement(By.id("consult_salary")).clear();
		    driver.findElement(By.id("consult_salary")).sendKeys("20000");
		    new Select(driver.findElement(By.id("consult_relocation"))).selectByVisibleText("Yes");
		    new Select(driver.findElement(By.id("consult_pcountry"))).selectByVisibleText("India");
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//div[@id='consult_preferredState']/div/input")).click();
		    driver.findElement(By.xpath("//div[@id='task-panel']/div/div[3]/div[2]/div/div[4]")).click();
		    driver.findElement(By.xpath("//div[@id='consult_preferredState']/div/input")).click();
		    driver.findElement(By.xpath("//div[@id='task-panel']/div/div[3]/div[2]/div/div[9]")).click();
//		    driver.findElement(By.id("file")).clear();
		    driver.findElement(By.id("file")).sendKeys(Paths.get("").toAbsolutePath()+"\\sample\\sample Resume\\John CV.docx");
		    driver.findElement(By.id("consult_comments")).clear();
		    driver.findElement(By.id("consult_comments")).sendKeys("test data");
		    driver.findElement(By.id("addConsult")).click();
//		    driver.findElement(By.xpath("//section[@id='generalForm']/div/div/div[2]/div/div/div/div/h4/span/a/i")).click();
		    Thread.sleep(2000);
//		    WebElement  msg =driver.findElement(By.id("sucessfull"));
//		    String resMessage=msg.getText();
//		    System.out.println("Message--->"+resMessage);
		    if(!(MSBUtils.isElementPresent(By.id("sucessfull"), driver))){
		    	errorMessage += " Error in Add Consultant .. " + "Please Enter Required field";
		    	MSBUtils.takeScreenShot(driver, repbean);
		    	
		    }else{
		    	successMessage += "Success Add Consultant ";
		    }
			
            }else{
           	 errorMessage += "Error, Redirect to incorrect Add Consultant page";
           	 MSBUtils.takeScreenShot(driver, repbean);
            }
			timetoProcess += "" + (new Date().getTime() - beging.getTime())
					/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Add Consultant .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Add Consultant .. "
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

