package com.msb.account;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class AddAccount {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Test
	public void testAddAccount() throws Exception {
		boolean returnvalue = true;
		String query = "";
		String errorMessage = "";
		String successMessage = "";
		String timetoProcess = "";
		String page = "Add Account";
		String ruleId = "addAccount";
		String userName = "Admin";
		String password = "";
		String event_id = "";
		ReportBean repbean = new ReportBean();
		Date beging = new Date();
		repbean.setRuleId(ruleId);
		GenerateData genData=new GenerateData();

		try {
			driver = MSBUtils.getDriver();
			MSBUtils.userLogin(driver, "msbadmin@abc.com", "Msb1234");
			MSBUtils.leftMenu(driver, "//section[@id='generalForm']/div/div[2]/div[2]/i", "addAccountSidePopupLink");
			    driver.findElement(By.id("account_name")).clear();
//			    To generate new account name
			    String accName= genData.generateRandomString(8);
			    System.out.println("Account Name------>"+accName);
//		      driver.findElement(By.id("account_name")).sendKeys(accName);
			    driver.findElement(By.id("account_url")).clear();
			    String accURL="www."+accName+".com";
			    System.out.println("URL------>"+accURL);
			    driver.findElement(By.id("account_url")).sendKeys(accURL);
			    new Select(driver.findElement(By.id("account_type"))).selectByVisibleText("Customer");
			    driver.findElement(By.id("email_ext")).clear();
			    String emailExt=accName+".com";
			    System.out.println("URL------>"+emailExt);
		        driver.findElement(By.id("email_ext")).sendKeys(emailExt);
			    driver.findElement(By.id("address1")).clear();
			    driver.findElement(By.id("address1")).sendKeys("hatro");
			    driver.findElement(By.id("address2")).clear();
			    driver.findElement(By.id("address2")).sendKeys("novi");
			    driver.findElement(By.id("acc_city")).clear();
			    driver.findElement(By.id("acc_city")).sendKeys("novi");
			    driver.findElement(By.id("acc_zip")).clear();
			    driver.findElement(By.id("acc_zip")).sendKeys("CF6758");
			    new Select(driver.findElement(By.id("acc_state"))).selectByVisibleText("California");
			    new Select(driver.findElement(By.id("acc_industry"))).selectByVisibleText("Industrial Products");
			    driver.findElement(By.id("reqion")).clear();
			    driver.findElement(By.id("reqion")).sendKeys("East");
			    driver.findElement(By.id("acc_no_of_employees")).clear();
			    driver.findElement(By.id("acc_no_of_employees")).sendKeys("2000");
			    driver.findElement(By.id("acc_tax_id")).clear();
			    driver.findElement(By.id("acc_tax_id")).sendKeys("6546");
			    driver.findElement(By.id("acc_revenue")).clear();
			    driver.findElement(By.id("acc_revenue")).sendKeys("2500");
			    driver.findElement(By.id("description")).clear();
			    driver.findElement(By.id("description")).sendKeys("Garments Company , Test data");
			    driver.findElement(By.id("addaccountsave")).click();
			    Thread.sleep(1000);	
			    WebElement  msg =driver.findElement(By.id("resultMessage"));
			    String resMessage=msg.getText();
			    System.out.println("Message--->"+resMessage);
			    if(resMessage.equals("Enter account name")){
			    	errorMessage += " Error in Add Account .. " + "Please Enter Account Name";
			    	MSBUtils.takeScreenShot(driver, repbean);
			    }else if(resMessage.equals("Enter account_url")){
			    	errorMessage += " Error in Add Account .. " + "Please Enter Account URL";
			    	MSBUtils.takeScreenShot(driver, repbean);
			    }else if(resMessage.equals("Select account_type")){
			    	errorMessage += " Error in Add Account .. " + "Please Select Account type";
			    	MSBUtils.takeScreenShot(driver, repbean);
			    }else if(resMessage.equals("Enter email_ext")){
			    	errorMessage += " Error in Add Account .. " + "Please Enter Email Extension";
			    	MSBUtils.takeScreenShot(driver, repbean);
			    }else{
			             successMessage += "Success Add Account ";
			    }
			timetoProcess += "" + (new Date().getTime() - beging.getTime())	/ 1000;
			

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in Add Account .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorMessage += " Error in Add Account .. " + errors.toString();
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
