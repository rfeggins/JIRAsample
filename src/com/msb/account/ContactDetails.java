package com.msb.account;

import com.msb.util.GenerateData;
import com.msb.util.MSBUtils;
import com.msb.util.ReportBean;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactDetails {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	GenerateData generateData;

	@Test
	public void testAddAccount() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Contact Dtails";
		String ruleId = "contactDetails";
		String userName = "Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);
		GenerateData generateData = new GenerateData();

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "nseerapu@interfaceglobal.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//div[@id='accordian_my']/div/h4/a/span", "accountInfoHomeCustAdmin");
			
			    driver.findElement(By.xpath("//div[@id='panel-task-body']/ul/li/a/img")).click();
			    driver.findElement(By.xpath("//a[@id='contactshead']/font")).click();
			    driver.findElement(By.id("firstNameContacts")).clear();
			    driver.findElement(By.id("firstNameContacts")).sendKeys("mar");
			    driver.findElement(By.id("contactSearch")).click();
			    new Select(driver.findElement(By.id("statusContacts"))).selectByVisibleText("Registered");
			    driver.findElement(By.id("contactSearch")).click();
			    new Select(driver.findElement(By.id("statusContacts"))).selectByVisibleText("Active");
			    driver.findElement(By.id("contactSearch")).click();
			    driver.findElement(By.id("emailContacts")).clear();
			    driver.findElement(By.id("emailContacts")).sendKeys("rk@inter");
			    driver.findElement(By.id("contactSearch")).click();
			    driver.findElement(By.id("emailContacts")).clear();
			    driver.findElement(By.id("emailContacts")).sendKeys("");
			    driver.findElement(By.id("contactSearch")).click();
			    driver.findElement(By.id("firstNameContacts")).clear();
			    driver.findElement(By.id("firstNameContacts")).sendKeys("");
			    driver.findElement(By.xpath("//a[@id='addContactLink']/button")).click();
			    driver.findElement(By.id("ContactFname")).clear();
			    driver.findElement(By.id("ContactFname")).sendKeys("Martin");
			    driver.findElement(By.id("ContactLname")).clear();
			    driver.findElement(By.id("ContactLname")).sendKeys("Luther");
//			    driver.findElement(By.id("ContactEmail")).clear();
			    driver.findElement(By.id("ContactEmail")).sendKeys(generateData.generateRandomString(8));
			 // for masked input text box
				driver.findElement(By.id("Officephone")).click();
				driver.findElement(By.id("Officephone")).sendKeys(Keys.HOME + "5467892365");
			    
			    driver.findElement(By.id("contactTitle")).clear();
			    driver.findElement(By.id("contactTitle")).sendKeys("Developer");
			    new Select(driver.findElement(By.id("workingLocation"))).selectByVisibleText("Headquarters");
			    driver.findElement(By.xpath("//div[@id='skillListValue']/div/input")).click();
			    driver.findElement(By.xpath("//form[@id='addContact']/div/div[7]/div/div[2]/div/div[2]")).click();
			    driver.findElement(By.xpath("//div[@id='skillListValue']/div")).click();
			    driver.findElement(By.xpath("//form[@id='addContact']/div/div[7]/div/div[2]/div/div[2]")).click();
			    driver.findElement(By.id("conAddress")).clear();
			    driver.findElement(By.id("conAddress")).sendKeys("srk park");
			    driver.findElement(By.id("conAddress2")).clear();
			    driver.findElement(By.id("conAddress2")).sendKeys("green city");
			    driver.findElement(By.id("conCity")).clear();
			    driver.findElement(By.id("conCity")).sendKeys("idhao");
			    new Select(driver.findElement(By.id("conState"))).selectByVisibleText("Florida");
			    driver.findElement(By.id("conZip")).clear();
			    driver.findElement(By.id("conZip")).sendKeys("FL8965");
			    driver.findElement(By.id("saveContact")).click();
			    new Select(driver.findElement(By.id("statusContacts"))).selectByVisibleText("Registered");
			    driver.findElement(By.id("contactSearch")).click();
			    driver.findElement(By.xpath("//table[@id='contactPageNav']/tbody/tr[2]/td[6]/a/img")).click();
			    driver.findElement(By.id("contactSend")).click();
			    driver.findElement(By.xpath("//div[@id='contactLoginBox']/div/span/h5/a/i")).click();
			    new Select(driver.findElement(By.id("statusContacts"))).selectByVisibleText("Active");
			    driver.findElement(By.id("contactSearch")).click();
			    driver.findElement(By.xpath("//table[@id='contactPageNav']/tbody/tr[11]/td/a")).click();
//			    driver.findElement(By.xpath("//div[@id='skillListValue']/div/input")).click();
//			    driver.findElement(By.xpath("//div[@id='selectivityProfileBox']/div[3]/form/div/div/div/div[19]/div[2]/div/div")).click();
//			    driver.findElement(By.xpath("//div[@id='skillListValue']/div/input")).click();
//			    driver.findElement(By.xpath("//div[@id='selectivityProfileBox']/div[3]/form/div/div/div/div[19]/div[2]/div/div")).click();
			    new Select(driver.findElement(By.id("conState"))).selectByVisibleText("California");
			    driver.findElement(By.xpath("//button[@id='']")).click();
			    driver.findElement(By.xpath("//a[@id='contactBackButton']/i")).click();
			    driver.findElement(By.xpath("(//a[contains(text(),'Akhlaque.Ahmad')])[2]")).click();
//			    driver.findElement(By.xpath("//div[@id='skillListValue']/div/span[2]/a/i")).click();
//			    driver.findElement(By.xpath("//div[@id='skillListValue']/div/span/a/i")).click();
			    driver.findElement(By.xpath("//button[@id='']")).click();
			    driver.findElement(By.xpath("//a[@id='contactBackButton']/i")).click();
			successMessage += "Success, Contact detail ";
			timetoProcess += "" + (new Date().getTime() - beging.getTime())
					/ 1000;

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Contact detail .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Contact detail .. " + errors.toString();
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
