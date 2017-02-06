package com.msb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class Util {

	public static WebDriver driver = null;
	private static String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	 public static WebDriver getDriver() {
	 if (driver == null) {
	 driver = new FirefoxDriver();
	 }
	 return driver;
	 }
	public static WebDriver initUrl() {
		
		
		return driver;
	}

	public static void userLogin(WebDriver driver, String uName, String pwd) {
//		 baseUrl = "http://192.168.1.239:8080";
//		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		 driver.findElement(By.xpath("//div[@id='header_top']/div/div/div[2]/ul/li/a")).click();
//		 driver.findElement(By.xpath("(//form[@id='userLoginForm']/div/input)[3]")).sendKeys(uName);
//		 driver.findElement(By.xpath("(//form[@id='userLoginForm']/div[2]/input)[2]")).sendKeys(pwd);
//		 driver.findElement(By.xpath("//form[@id='userLoginForm']/div[3]/button")).click();
		 
		System.out.println("login");
		 driver.findElement(By.xpath("//div[@id='header_top']/div/div/div[2]/ul/li/a")).click();
//			driver.findElement(By.xpath("//form[@id='userLoginForm']/div/input)[3]")).clear();
			driver.findElement(By.xpath("(//form[@id='userLoginForm']/div/input)[3]")).sendKeys(uName);
			driver.findElement(By.xpath("(//form[@id='userLoginForm']/div[2]/input)[2]")).clear();
			driver.findElement(By.xpath("(//form[@id='userLoginForm']/div[2]/input)[2]")).sendKeys(pwd);
			driver.findElement(By.xpath("//form[@id='userLoginForm']/div[3]/button")).click();
			
		 
		 

	}

	public static void userLogOut(WebDriver driver) {
		driver.findElement(By.xpath("//a[@id='dropdownMenu2']/font/span/i")).click();
		driver.findElement(By.xpath("//div[@id='col-sm-6']/div/ul/li/table/tbody/tr/td[2]/ul/div/div[2]/ul/li[3]/a/i")).click();
	}

	public static void clickLeftMenu(WebDriver driver, String menuId) {

	}
	public static void requirementHomeMenu(){
		driver.findElement(By.xpath("//div[@id='accordian_my']/div/h4/a/span/i")).click();
		driver.findElement(By.xpath("//div[@id='sportswear']/div/ul/li[3]/a")).click();
	}
	
	public static void requirementSearch(WebDriver driver){
		
		
	    driver.findElement(By.xpath("//form[@id='RequirementListAllForm']/div/div/div/input")).clear();
	    driver.findElement(By.xpath("//form[@id='RequirementListAllForm']/div/div/div/input")).sendKeys("232");
	    driver.findElement(By.id("RequirementListAllForm_0")).click();
	    driver.findElement(By.id("jdId")).clear();
	    driver.findElement(By.id("jdId")).sendKeys("");
	    driver.findElement(By.id("RequirementListAllForm_0")).click();
	    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div/input")).click();
	    driver.findElement(By.xpath("//form[@id='RequirementListAllForm']/div/div/div[7]/div[2]/div/div[2]")).click();
	    driver.findElement(By.id("RequirementListAllForm_0")).click();
	    driver.findElement(By.xpath("//div[@id='skillCategoryValue']/div/span/a/i")).click();
	    driver.findElement(By.id("RequirementListAllForm_0")).click();
	    driver.findElement(By.id("jobTitle")).clear();
	    driver.findElement(By.id("jobTitle")).sendKeys("java");
	    driver.findElement(By.id("RequirementListAllForm_0")).click();
	    driver.findElement(By.id("jobTitle")).clear();
	    driver.findElement(By.id("jobTitle")).sendKeys("");
	    new Select(driver.findElement(By.id("reqCategoryValue"))).selectByVisibleText("SAP");
	    driver.findElement(By.id("RequirementListAllForm_0")).click();
	    new Select(driver.findElement(By.id("reqCategoryValue"))).selectByVisibleText("OTHERS");
	    driver.findElement(By.id("RequirementListAllForm_0")).click();
	    new Select(driver.findElement(By.id("reqCategoryValue"))).selectByVisibleText("All");
	    driver.findElement(By.id("RequirementListAllForm_0")).click();
	    new Select(driver.findElement(By.id("requirementStatus"))).selectByVisibleText("Opened");
	    driver.findElement(By.id("RequirementListAllForm_0")).click();
	    new Select(driver.findElement(By.id("requirementStatus"))).selectByVisibleText("All");
	    driver.findElement(By.id("RequirementListAllForm_0")).click();
	    driver.findElement(By.id("reqStart")).click();
	    driver.findElement(By.xpath("//div/ul/li/div")).click();
	    driver.findElement(By.xpath("//div/ul/li/div")).click();
	    driver.findElement(By.xpath("//ul[3]/li[3]")).click();
	    driver.findElement(By.id("reqEnd")).click();
	    driver.findElement(By.xpath("//ul[5]/li[4]")).click();
	    driver.findElement(By.id("RequirementListAllForm_0")).click();
		
	}
	
	

	public static void accountSearch() {

		driver.findElement(By.id("accountName")).clear();
		driver.findElement(By.id("accountName")).sendKeys("interface");
		driver.findElement(By.id("searchAccountsBy_0")).click();
		new Select(driver.findElement(By.id("accountType")))
				.selectByVisibleText("Vendor");
		driver.findElement(By.id("searchAccountsBy_0")).click();
		driver.findElement(By.id("accountName")).clear();
		driver.findElement(By.id("accountName")).sendKeys("interfaceer");
		driver.findElement(By.id("searchAccountsBy_0")).click();
		driver.findElement(By.id("accountName")).clear();
		driver.findElement(By.id("accountName")).sendKeys("i");
		driver.findElement(By.id("searchAccountsBy_0")).click();
		new Select(driver.findElement(By.id("accountType")))
				.selectByVisibleText("Customer");
		driver.findElement(By.id("searchAccountsBy_0")).click();
		new Select(driver.findElement(By.id("Countries")))
				.selectByVisibleText("Australia");
		driver.findElement(By.cssSelector("option[value=\"1\"]")).click();
		driver.findElement(By.id("searchAccountsBy_0")).click();
		new Select(driver.findElement(By.id("Countries")))
				.selectByVisibleText("Canada");
		driver.findElement(By.cssSelector("option[value=\"5\"]")).click();
		driver.findElement(By.id("searchAccountsBy_0")).click();
		new Select(driver.findElement(By.id("Countries")))
				.selectByVisibleText("Germany");
		driver.findElement(By.cssSelector("option[value=\"4\"]")).click();
		driver.findElement(By.id("searchAccountsBy_0")).click();
		new Select(driver.findElement(By.id("accountIndustry")))
				.selectByVisibleText("IT Services & Staffing And Recruiting");
		driver.findElement(By.id("searchAccountsBy_0")).click();
		new Select(driver.findElement(By.id("accountIndustry")))
				.selectByVisibleText("Select Industry");
		driver.findElement(By.id("searchAccountsBy_0")).click();
		new Select(driver.findElement(By.id("Countries")))
				.selectByVisibleText("Select Country");
		driver.findElement(By.cssSelector("option[value=\"-1\"]")).click();
		driver.findElement(By.id("searchAccountsBy_0")).click();
		new Select(driver.findElement(By.id("Countries")))
				.selectByVisibleText("USA");
		driver.findElement(By.cssSelector("option[value=\"3\"]")).click();
		new Select(driver.findElement(By.id("accountState")))
				.selectByVisibleText("California");
		driver.findElement(By.id("searchAccountsBy_0")).click();
		driver.findElement(By.id("accountName")).clear();
		driver.findElement(By.id("accountName")).sendKeys("");
		driver.findElement(By.id("searchAccountsBy_0")).click();
		driver.findElement(By.id("accountName")).clear();
		driver.findElement(By.id("accountName")).sendKeys("inter");
		driver.findElement(By.id("searchAccountsBy_0")).click();
		new Select(driver.findElement(By.id("Countries")))
				.selectByVisibleText("Select Country");
		driver.findElement(By.cssSelector("option[value=\"-1\"]")).click();
		driver.findElement(By.id("searchAccountsBy_0")).click();
	}

	public static void copyFile(String from, String to)

	{
		System.out.println("FROM=======>" + from);
		System.out.println("TO=======>" + to);
		File sourceFile = new File(from);

		File destFile = new File(to);

		/* verify whether file exist in source location */

		if (!sourceFile.exists()) {

			System.out.println("Source File Not Found!");

		}

		/* if file not exist then create one */

		if (!destFile.exists()) {

			try {

				destFile.createNewFile();

				System.out
						.println("Destination file doesn't exist. Creating one!");

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		FileChannel source = null;

		FileChannel destination = null;

		try {

			source = new FileInputStream(sourceFile).getChannel();

			destination = new FileOutputStream(destFile).getChannel();

			if (destination != null && source != null) {

				destination.transferFrom(source, 0, source.size());

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}

		finally {

			if (source != null) {

				try {

					source.close();

				} catch (IOException e) {

					e.printStackTrace();

				}

			}

			if (destination != null) {
				try {
					destination.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
