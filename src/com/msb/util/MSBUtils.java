package com.msb.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.Select;

import com.sun.jna.platform.FileUtils;



public class MSBUtils {
	static int countOftest = 0;
	static Properties dataProb = null;
	static Properties emailprop = null;
	static Properties querDesc = null;
	static Properties commonSysvar = null;
	static Properties workspaceSysvar = null;
	static FileWriter fw = null;
	static FileWriter Htmlfw = null;
	static BufferedWriter bw = null;
	static BufferedWriter htmlbw = null;
	static Connection conn = null;
	static WebDriver driver = null;
	static int tablecount = 0;
	static String environmentTotest = null;
	static HashMap<String, HashMap<String, Integer>> valPgsAdCntByCat = new HashMap<String, HashMap<String, Integer>>();
	public static String username = "miraclesauce";
	public static String accesskey = "b5144da9-2eca-4511-94cb-ed5a48eda714";

	public MSBUtils(WebDriver driver) {
		this.driver = driver;
	}

	public static enum Mode {
		ALPHA, ALPHANUMERIC, NUMERIC
	}

	// Aklakh
	public static void userLogin(WebDriver driver, String uName, String pwd) {
		
		
		driver.findElement(By.xpath("//div[@id='header_top']/div/div/div[2]/ul/li/a")).click();
//		driver.findElement(By.xpath("//form[@id='userLoginForm']/div/input)[3]")).clear();
		driver.findElement(By.xpath("(//form[@id='userLoginForm']/div/input)[3]")).sendKeys(uName);
		driver.findElement(By.xpath("(//form[@id='userLoginForm']/div[2]/input)[2]")).clear();
		driver.findElement(By.xpath("(//form[@id='userLoginForm']/div[2]/input)[2]")).sendKeys(pwd);
		driver.findElement(By.xpath("//form[@id='userLoginForm']/div[3]/button")).click();
		
			
		

	}

	public static void userLogOut(WebDriver driver) {
		driver.findElement(By.xpath("//a[@id='dropdownMenu2']/font/span/i")).click();
		driver.findElement(By.xpath("//div[@id='col-sm-6']/div/ul/li/table/tbody/tr/td[2]/ul/div/div[2]/ul/li[3]/a/i")).click();
		// driver.findElement(By.cssSelector("img[alt=\"Logout\"]")).click();
	}
	
	public static void requirementHomeMenu(){
		 driver.findElement(By.xpath("//div[@id='accordian_my']/div/h4/a/span")).click();
		    driver.findElement(By.id("requirementsHomeProjectManager")).click();
	}
	public static void taskHomeMenu(){
		driver.findElement(By.xpath("//div[@id='accordian_my']/div/h4/a/span")).click();
	    driver.findElement(By.id("tasksHomeProjectManager")).click();
	}
	public static void timesheetHomeMenu(){
		driver.findElement(By.xpath("//div[@id='accordian_my']/div/h4/a/span/i")).click();
	    driver.findElement(By.xpath("//div[@id='sportswear']/div/ul/li/a")).click();
	}
	public static void timesheetUtilitiesMenu(){
		driver.findElement(By.xpath("//div[@id='accordian_services']/div/h4/a/span")).click();
	    driver.findElement(By.xpath("//div[@id='womens']/div/ul/li/a")).click();
	}
	public static void contractUtilitiesMenu(){
		driver.findElement(By.xpath("//div[@id='accordian_services']/div/h4/a/span")).click();
	    driver.findElement(By.id("contractsUtilitiesMenuVen")).click();
	}
	public static void invoiceUtilitiesMenu(){
		 driver.findElement(By.xpath("//div[@id='accordian_services']/div/h4/a/span")).click();
		 driver.findElement(By.id("invoiceUtilitiesMenuVen")).click();
	}
	
	public static void adminDashBoard(String id){
		 driver.findElement(By.xpath("//div[@id='accordian_services']/div/h4/a/span")).click();
		 if(id.equals("customerDashboardCustAdmin")){
			 driver.findElement(By.id("customerDashboardCustAdmin")).click();
		 }else if(id.equals("costcenterDashboardCustAdmin")){
			 driver.findElement(By.id("costcenterDashboardCustAdmin")).click();
		 }else if(id.equals("projectDashboardCustAdmin")){
			 driver.findElement(By.id("projectDashboardCustAdmin")).click();
		 }
	}
	public static void leftMenu(WebDriver driver ,String id1, String id2){
		 driver.findElement(By.xpath(id1)).click();
		 driver.findElement(By.id(id2)).click();
	}
	
	
	public static void browserClose(){
		 driver.close();
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
	
	
	
	
	

	public static LinkedList browsersStrings() {
		LinkedList browsers = new LinkedList();
		browsers.add(new String[] { "Windows 7", "41", "chrome", null, null });
		browsers.add(new String[] { "Windows XP", "35", "firefox", null, null });
		// browsers.add(new String[]{"Windows 7", "9", "internet explorer",
		// null, null});
		// browsers.add(new String[]{"Windows 8", "10", "internet explorer",
		// null, null});
		// browsers.add(new String[]{"Windows 8.1", "11", "internet explorer",
		// null, null});
		// browsers.add(new String[]{"OSX 10.8", "6", "safari", null, null});
		// browsers.add(new String[]{"OSX 10.9", "7", "safari", null, null});
		// browsers.add(new String[]{"OSX 10.10", "8", "safari", null, null});
		// browsers.add(new String[]{"Linux", "37", "firefox", null, null});

		return browsers;
	}

	public static boolean findElementFor60Seconds(String findingId) {
		boolean returnResult = false;
		try {
			for (int second = 0;; second++) {
				if (second >= 60) {
					returnResult = false;
					break;
				}
				try {
					if (MSBUtils.isElementPresent(By.id(findingId), driver)) {
						returnResult = true;
						break;
					} else {
						returnResult = false;
						break;
					}
				} catch (Exception e) {
					returnResult = false;
					break;
				}
			}
		} catch (Exception e) {
			returnResult = false;
		}
		return returnResult;
	}

	public static String generateRandomString(int length, Mode mode)
			throws Exception {

		StringBuffer buffer = new StringBuffer();
		String characters = "";

		switch (mode) {

		case ALPHA:
			characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			break;

		case ALPHANUMERIC:
			characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			break;

		case NUMERIC:
			characters = "1234567890";
			break;
		}

		int charactersLength = characters.length();

		for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString();
	}

	public static String getTimeDiffenrece(String diffMs)

	{
		System.out
				.println("diffMs==================================>" + diffMs);
		if (diffMs != null || !" ".equals(diffMs)) {

			// try {
System.out.println("Inside if");
			long diffSec = Long.parseLong(diffMs)*1000;
			int seconds = (int) (diffSec / 1000) % 60 ;
			int minutes = (int) ((diffSec / (1000*60)) % 60);
			
			long min = diffSec / 60;
			long sec = diffSec % 60;
          System.out.println("diffSec-->"+diffSec+"Min-->"+minutes+"Sec--->"+seconds);
			// if (min > 0)
			// {
			// return "" + min + " min " + sec + " sec";
			// } else {
			// return "" + sec + " sec";
			// }
			return "" + minutes + " min " + seconds + " sec";

			// } catch (Exception e) {
			// e.printStackTrace();
			// return "Error :"+diffMs;
			// }
		} else {
			return "0";

		}

	}

	public static String displayTableReport() {

		System.out.println("Entered displayTableReport===========");
		String retunValue = "";
		try {
			Iterator<Map.Entry<String, HashMap<String, Integer>>> parent = valPgsAdCntByCat.entrySet().iterator();
			System.out.println("parent-->"+parent);
			String totalReporttabl = "<table class=\"extra_table\"><thead><tr><th>#</th><th>Page Name</th><th>Success</th><th>Fail</th><th>Warning</th><th>Remarks</th></tr></thead><tbody>";
			int count = 1;
			while (parent.hasNext()) {

				totalReporttabl += "<tr><td>" + count++ + "</td>";
				Map.Entry<String, HashMap<String, Integer>> parentPair = parent.next();
				totalReporttabl += "<td>" + parentPair.getKey() + "</td>";
				Iterator<Map.Entry<String, Integer>> child = (parentPair.getValue()).entrySet().iterator();
				String Warning = "";
				String Success = "";
				String Fail = "";
				while (child.hasNext()) {

					Map.Entry childPair = child.next();
	System.out.println("childPair.getValue()"+ childPair.getValue());
	
					if ("Warning".equalsIgnoreCase("" + childPair.getKey())) {
						Warning = "" + childPair.getValue();
					}
					if ("Success".equalsIgnoreCase("" + childPair.getKey())) {
						Success = "" + childPair.getValue();
					}
					if ("Error".equalsIgnoreCase("" + childPair.getKey())) {
						Fail = "" + childPair.getValue();
					}
					child.remove();
				}

				totalReporttabl += "<td>" + Success + "</td>";
				totalReporttabl += "<td>" + Fail + "</td>";
				totalReporttabl += "<td>" + Warning + "</td></tr>";

			}
			totalReporttabl += "</tbody></table>";
			System.out.println("totalReporttabl-->"+totalReporttabl);
			reportHtmlResult = totalReporttabl;
			writeHtmlLog(reportHtmlResult);
          System.out.println("displayTableReport ending");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("retunValue--"+retunValue);
		return retunValue;
	}

	public static boolean OpenMenuOption(WebDriver driver) {

		System.out.println("OpenMenuOption==================" + driver);

		String contentToWrite = "";
		boolean returnvalue = true;
		try {
			Thread.sleep(2000);
			// if(CPTUtils.isElementPresent(By.id("cpt_topnav_menu-trigger"),
			// driver))
			{

				WebElement ob = driver.findElement(By
						.id("cpt_topnav_menu-trigger"));
				// driver.findElement(By.id("cpt_topnav_menu-trigger")).click();
				if ("menu menu-opened".equalsIgnoreCase(ob
						.getAttribute("class"))) {
					return true;
				} else if ("menu".equalsIgnoreCase(ob.getAttribute("class"))) {
					driver.findElement(By.id("id_toolMenu")).click();
					return false;
				}
			}
		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in OpenMenuOption .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			contentToWrite += "Error in OpenMenuOption .. " + errors.toString();
			MSBUtils.writeLog(contentToWrite);
			e.printStackTrace();
		}
		return returnvalue;
	}

	public static boolean ClickMenuOption(String menuId, WebDriver driver) {
		System.out.println("DRIVER in clickmenu option===" + driver);
		String contentToWrite = "";
		boolean returnvalue = true;
		try {
			for (int second = 0;; second++) {
				if (second >= 60) {
					System.out.println("Unable to open Menu");
				}
				returnvalue = false;
				try {
					if (OpenMenuOption(driver)) {
						System.out.println("DRIVER in clickmenu option==="
								+ driver);
						returnvalue = true;
						break;
					}

				} catch (Exception e) {
				}
				Thread.sleep(2000);
			}
			if (returnvalue) {
				driver.findElement(By.id(menuId)).click();
			} else {
				System.out.println(menuId + " id_");
				JavascriptExecutor jsx = (JavascriptExecutor) MSBUtils
						.getDriver();
				jsx.executeScript("document.getElementById(\"" + menuId
						+ "\").click()");
			}
			// Thread.sleep(2000);
			// driver.findElement(By.id("id_toolMenu")).click();
			// WebElement ob =
			// driver.findElement(By.id("cpt_topnav_menu-trigger"));
			// if
			// ("menu menu-opened".equalsIgnoreCase(ob.getAttribute("class"))) {
			// driver.findElement(By.id(menuId)).click();
			// } else if ("menu".equalsIgnoreCase(ob.getAttribute("class"))) {
			// driver.findElement(By.id("id_toolMenu")).click();
			// if (!CPTUtils.isElementPresent(By.id(menuId))) {
			// driver.findElement(By.id("id_toolMenu")).click();
			// Thread.sleep(100);
			// driver.findElement(By.id(menuId)).click();
			// } else {
			// driver.findElement(By.id(menuId)).click();
			// }
			// }

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in ClickNewBookfair .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			contentToWrite += "Error in ClickNewBookfair .. "
					+ errors.toString();
			MSBUtils.writeLog(contentToWrite);
			e.printStackTrace();
		}
		return returnvalue;
	}

	@SuppressWarnings("unused")
	public static boolean signOut(WebDriver driver) {
		boolean returnvalue = true;
		String contentToWrite = "";
		try {
			if (MSBUtils.isElementPresent(By.id("SPS-Toolkit-Nav-SignOutLink"),
					driver)) {
				driver.findElement(By.id("SPS-Toolkit-Nav-SignOutLink"))
						.click();
			} else if (MSBUtils.isElementPresent(
					By.id("Admin-Nav-SignOutLink"), driver)) {
				driver.findElement(By.id("Admin-Nav-SignOutLink")).click();
			}

		} catch (Exception e) {
			returnvalue = false;
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			contentToWrite += "Error " + errors.toString();

			e.printStackTrace();
		}
		return returnvalue;
	}

	public static boolean clickBookfair(String EnterTookKit_BookFairId,
			WebDriver driver) {
		boolean returnvalue = true;

		// System.out.println("clickBookfairss============="
		// + EnterTookKit_BookFairId);

		try {
			String fairId = "";
			fairId = EnterTookKit_BookFairId;
			if (MSBUtils.isElementPresent(By.id("enterToolkit_" + fairId),
					driver)) {
				driver.findElement(By.id("enterToolkit_" + fairId)).click();

				if (!MSBUtils.isElementPresent(By.id("top_fairId"), driver)) {
					System.out
							.println("Error : EnterConfirmedBookFair Unable to locate the bookfai id"
									+ fairId);
					MSBUtils.writeLog("Error : EnterConfirmedBookFair Unable to locate the bookfai id"
							+ fairId);
				}

			}

		} catch (Exception e) {
			returnvalue = false;
			System.out.println("Error in clickBookfair .. ");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			MSBUtils.writeLog("Error in clickBookfair .. " + errors.toString());

			e.printStackTrace();
		}
		return returnvalue;
	}

	/*
	 * WebDriver driver is a global variable to access the same WebDriver object
	 * in the entire test script
	 */
	public static WebDriver getDriver() {
		if (driver == null) {
			//System.out.println("running from Selenium");
			try{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
//			String baseUrl = "http://172.17.0.164:8080/";
			String baseUrl = "http://192.168.1.239:8080/";
			driver.get(baseUrl + "msb/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return driver;
		} else {
			return driver;
		}
	}

	public static String LoginSauce(String UserId, WebDriver driver) {
		String returnvalue = "";
		// System.out.println("Login page==============================" +
		// UserId + "Driverr======================" + driver);

		try {

			String Login_baseUrl = null;
			if ("199".equals(getEnvironmentTotest())) {
				Login_baseUrl = retunStringFromCommonSystemproperties("Login_baseUrl_199");
			} else if ("115".equals(getEnvironmentTotest())) {
				Login_baseUrl = retunStringFromCommonSystemproperties("Login_baseUrl_115");
			} else if ("200".equals(getEnvironmentTotest())) {
				Login_baseUrl = retunStringFromCommonSystemproperties("Login_baseUrl_200");
			} else if ("dev".equals(getEnvironmentTotest())) {
				Login_baseUrl = retunStringFromCommonSystemproperties("Login_baseUrl_dev");
			} else if ("qa".equals(getEnvironmentTotest())) {
				Login_baseUrl = retunStringFromCommonSystemproperties("Login_baseUrl_qa");
			}
			System.out.println("Login URL" + Login_baseUrl);
			driver.get(Login_baseUrl);
			driver.findElement(By.name("CPEmail")).clear();
			driver.findElement(By.name("CPEmail")).sendKeys(UserId);
			driver.findElement(By.id("submitter")).click();
			// String erroLoginXpath =
			// "//td[@class=\"ErrorFont\" and @align=\"CENTER\"]";
			// if (CPTUtils.isElementPresent(By.xpath(erroLoginXpath)))
			// {
			// returnvalue = "Problem with UserId " + UserId;
			// System.out.println("Problem with UserId " + UserId);
			// }
		} catch (Exception e) {
			// System.out.println("Error on login..");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			writeLog("Error in Login .. " + errors.toString());
			returnvalue = "Problem with UserId " + UserId + " "
					+ errors.toString();
			e.printStackTrace();
		}
		return returnvalue;
	}

	/*
	 * Login is Util method to get the base url and login with with UserId
	 * parameter
	 */
	public static String Login(String UserId) {
		String returnvalue = "";
		try {

			String Login_baseUrl = null;
			if ("199".equals(getEnvironmentTotest())) {
				Login_baseUrl = retunStringFromCommonSystemproperties("Login_baseUrl_199");
			} else if ("115".equals(getEnvironmentTotest())) {
				Login_baseUrl = retunStringFromCommonSystemproperties("Login_baseUrl_115");
			} else if ("200".equals(getEnvironmentTotest())) {
				Login_baseUrl = retunStringFromCommonSystemproperties("Login_baseUrl_200");
			} else if ("dev".equals(getEnvironmentTotest())) {
				Login_baseUrl = retunStringFromCommonSystemproperties("Login_baseUrl_dev");
			} else if ("qa".equals(getEnvironmentTotest())) {
				Login_baseUrl = retunStringFromCommonSystemproperties("Login_baseUrl_qa");
			}
			MSBUtils.getDriver().get(Login_baseUrl);
			MSBUtils.getDriver().findElement(By.name("CPEmail")).clear();
			MSBUtils.getDriver().findElement(By.name("CPEmail"))
					.sendKeys(UserId);
			MSBUtils.getDriver().findElement(By.id("submitter")).click();
			// String erroLoginXpath =
			// "//td[@class=\"ErrorFont\" and @align=\"CENTER\"]";
			// if (CPTUtils.isElementPresent(By.xpath(erroLoginXpath)))
			// {
			// returnvalue = "Problem with UserId " + UserId;
			// System.out.println("Problem with UserId " + UserId);
			// }
		} catch (Exception e) {
			System.out.println("Error on login..");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			writeLog("Error in Login .. " + errors.toString());
			returnvalue = "Problem with UserId " + UserId + " "
					+ errors.toString();
			e.printStackTrace();
		}
		return returnvalue;
	}

	public static String adminLoginSauce(String UserId, String password,
			WebDriver driver) {
		// System.out.println("Userid======"+UserId+password+driver);
		String returnvalue = "";
		System.out.println("Entered Admin login");
		try {

			String adminLoginBaseUrl = null;
			if ("admin".equals(getEnvironmentTotest())) {
				adminLoginBaseUrl = retunStringFromCommonSystemproperties("adminLoginBaseUrl_admin");
			} else if ("admin200".equals(getEnvironmentTotest())) {
				adminLoginBaseUrl = retunStringFromCommonSystemproperties("adminLoginBaseUrl_admin200");
			}
			System.out.println("Admin URL" + adminLoginBaseUrl);

			// adminLoginBaseUrl="http://10.33.22.141/bookfairs/cptoolkit/profile/logintoolkit.jsp";
			driver.get(adminLoginBaseUrl);
			driver.findElement(By.name("UserName")).clear();
			driver.findElement(By.name("UserName")).sendKeys(UserId);
			driver.findElement(By.name("Password")).clear();
			driver.findElement(By.name("Password")).sendKeys(password);
			driver.findElement(By.name("SignIn")).click();
			if (!MSBUtils.isElementPresent(By.id("CptkHeader"), driver)) {
				returnvalue = "Problem with UserId " + UserId;
				System.out.println("Problem with UserId " + UserId);
			}

		} catch (Exception e) {
			System.out.println("Error on login..");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			writeLog("Error in Login .. " + errors.toString());
			returnvalue = "Problem with UserId " + UserId + " "
					+ errors.toString();
			e.printStackTrace();
		}

		return returnvalue;
	}

	public static String adminLogin(String UserId, String password) {
		String returnvalue = "";

		try {
			// String Login_baseUrl =
			// retunStringFromCommonSystemproperties("adminLoginBaseUrl");//
			// "http://10.32.48.199/bookfairs/cptoolkit/profile/logintoolkit.jsp";
			String Login_baseUrl = "http://10.33.22.141/bookfairs/cptoolkit/admin/admin_login.jsp";
			MSBUtils.getDriver().get(Login_baseUrl);
			MSBUtils.getDriver().findElement(By.name("UserName")).clear();
			MSBUtils.getDriver().findElement(By.name("UserName"))
					.sendKeys(UserId);
			MSBUtils.getDriver().findElement(By.name("Password")).clear();
			MSBUtils.getDriver().findElement(By.name("Password"))
					.sendKeys(password);
			MSBUtils.getDriver().findElement(By.id("SignIn")).click();
			if (!MSBUtils.isElementPresent(By.id("CptkHeader"), driver)) {
				returnvalue = "Problem with UserId " + UserId;
				System.out.println("Problem with UserId " + UserId);
			}
		} catch (Exception e) {
			System.out.println("Error on adminLogin..");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			writeLog("Error in adminLogin .. " + errors.toString());
			returnvalue = "Problem with UserId " + UserId + " "
					+ errors.toString();
			e.printStackTrace();
		}
		return returnvalue;
	}

	/*
	 * getConnection() will return the connection object to maintain the same
	 * connection object for the entire test script
	 */
	public static Connection getConnection() {

		// JDBC driver name and database URL
		String getEnvionment = getEnvironmentTotest();
		String env_test = null;
		if ("199".equalsIgnoreCase(getEnvionment)
				|| "115".equalsIgnoreCase(getEnvionment)
				|| "200".equalsIgnoreCase(getEnvionment)
				|| "dev".equalsIgnoreCase(getEnvionment)
				|| "admin200".equalsIgnoreCase(getEnvionment)
				|| "admin".equalsIgnoreCase(getEnvionment)) {
			env_test = "_dev";
		} else if ("dev2".equalsIgnoreCase(getEnvionment)) {
			env_test = "_dev2";
		} else if ("qa".endsWith(getEnvionment)) {
			env_test = "_qa";
		} else if ("qa2".equalsIgnoreCase(getEnvionment)) {
			env_test = "_qa2";
		}

		String JDBC_DRIVER = MSBUtils
				.retunStringFromDataBaseproperties("JDBC_DRIVER");

		System.out.println("JDBC_DRIVE=====>" + JDBC_DRIVER);
		// String DB_URL =
		// "jdbc:db2//ec-e1b-ldbd-006.scholastic.net:50000/bkf01d";
		String DB_URL = MSBUtils.retunStringFromDataBaseproperties("DB_URL"
				+ env_test);
		// System.out.println("DB_URL=====>"+DB_URL);

		// Database credentials
		String USER = MSBUtils.retunStringFromDataBaseproperties("USER"
				+ env_test);
		// System.out.println("USER=====>"+USER);

		String PASS = MSBUtils.retunStringFromDataBaseproperties("PASS"
				+ env_test);
		// System.out.println("DATABASE ENvironment======"+env_test);
		// System.out.println("PASS======"+PASS);
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			if (conn == null) {
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				valPgsAdCntByCat = new HashMap<String, HashMap<String, Integer>>();
			}
			// STEP 4: Execute a query

		} catch (Exception e) {
			// Handle errors for Class.forName
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			writeLog("Error in Login .. " + errors.toString());
			e.printStackTrace();
		} finally {
			try {
				// if (conn != null)
				// conn.close();
			} catch (Exception se) {
				StringWriter errors = new StringWriter();
				se.printStackTrace(new PrintWriter(errors));
				writeLog("Error in Login .. " + errors.toString());

			}// end finally try
		}// end try
		return conn;
	}

	/*
	 * getpropertiesKeys() this method is used to get the properties has a hash
	 * table
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Hashtable getpropertiesKeys(Properties prop) {
		Hashtable key_value = new Hashtable();

		try {
			FileOutputStream out = new FileOutputStream(
					"src/constants.properties");
			Properties p = new Properties();
			p.load(new FileInputStream("src/quries_constants.properties"));
			Enumeration e = p.propertyNames();
			for (; e.hasMoreElements();) {
				String key = e.nextElement().toString();
				if (key.split("\\.")[2].equals("query")) {
					String value = p.getProperty(key);
					if (value != null && !"".equals(value)) {
						key_value.put(key, value);
						System.out.println("Before "
								+ prop.getProperty(key.replace("query",
										"userid")));
						prop.setProperty(key.replace("query", "userid"), value);
						System.out.println("After alter .. "
								+ prop.getProperty(key.replace("query",
										"userid")));
					} else {
						System.out.println(key + " does't have any value");
					}
				}
			}
			prop.store(out, null);
			out.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return key_value;
	}

	/*
	 * 
	 * isElementPresent() is used verify the the element is existed in the
	 * current page or not
	 */
	public static boolean isElementPresent(By by, WebDriver driver) {
		try {
			// System.out.println("BYYYYYYYYYYYYYY"+by);
			driver.findElement(by);

			// driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * loadEmailProperties() is used to load emailconfig properties. the
	 * properties object is common for entire test script
	 */
	public static Properties loadEmailProperties() {
		try {
			if (emailprop == null) {
				emailprop = new Properties();
				String propFileName = loadWorkspaceproperties().getProperty(
						"propertiesLocations")
						+ "/emailConfig.properties";
				FileInputStream inputStream = new FileInputStream(propFileName);
				emailprop.load(inputStream);
			} else {
				return emailprop;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emailprop;
	}

	/*
	 * loadDataBaseproperties() is used to load databaseconfig properties. the
	 * properties object is common for entire test script
	 */
	public static Properties loadDataBaseproperties() {
		try {
			if (dataProb == null) {
				dataProb = new Properties();
				String propFileName = loadWorkspaceproperties().getProperty(
						"propertiesLocations")
						+ "/dataBase.properties";
				FileInputStream inputStream = new FileInputStream(propFileName);
				dataProb.load(inputStream);
			} else {
				return dataProb;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Database property" + dataProb);
		return dataProb;
	}

	/*
	 * loadQueryproperties() is used to load query properties. the properties
	 * object is common for entire test script
	 */
	public static Properties loadQueryproperties() {
		try {
			if (querDesc == null) {
				querDesc = new Properties();
				String propFileName1 = loadWorkspaceproperties().getProperty(
						"propertiesLocations")
						+ "/quries_constants.properties";
				FileInputStream inputStream1 = new FileInputStream(
						propFileName1);
				querDesc.load(inputStream1);
			} else {
				return querDesc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return querDesc;
	}

	public static Properties loadWorkspaceproperties() {
		try {
			if (workspaceSysvar == null) {
				workspaceSysvar = new Properties();
				String propFileName1 = "src/test/java/workspace.properties";
				FileInputStream inputStream1 = new FileInputStream(
						propFileName1);
				workspaceSysvar.load(inputStream1);
				// System.out.println("property file======" + workspaceSysvar);
			} else {
				return workspaceSysvar;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workspaceSysvar;
	}

	public static Properties loadTestresultProperties() {

		Properties workspaceSysvar1 = null;
		try {
			workspaceSysvar1 = new Properties();
			String propFileName1 = "src/test/java/workspace.properties";
			FileInputStream inputStream1 = new FileInputStream(propFileName1);
			workspaceSysvar1.load(inputStream1);
			System.out.println("property file======" + workspaceSysvar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workspaceSysvar1;
	}

	/*
	 * loadQueryproperties() is used to load query properties. the properties
	 * object is common for entire test script
	 */
	public static String retunStringFromQueryprop(String query) {
		System.out.println("Query====" + query);
		String returnValue = "";
		returnValue = loadQueryproperties().getProperty(query);
		System.out.println("Return Value==" + returnValue);
		return returnValue;
	}

	public static String retunStringFromCommonSystemproperties(String query) {
		String returnValue = "";
		System.out.println("Common path======" + query);
		returnValue = loadCommonSystemproperties1().getProperty(query);
		System.out.println("ADMIN PROPERTY======>" + returnValue);
		return returnValue;
	}

	public static String retunStringFromDataBaseproperties(String query) {
		String returnValue = "";
		returnValue = loadDataBaseproperties().getProperty(query);
		System.out.println("DBURL+++++++++++++++++++++===========>"
				+ returnValue);
		return returnValue;
	}

	public static Properties loadCommonSystemproperties1() {
		try {
			if (commonSysvar == null) {
				commonSysvar = new Properties();
				String propertiesLocations = loadWorkspaceproperties()
						.getProperty("propertiesLocations");
				// String propertiesLocations="D:/properties";
				String propFileName1 = propertiesLocations
						+ "/commonSystemValues.properties";
				FileInputStream inputStream1 = new FileInputStream(
						propFileName1);
				commonSysvar.load(inputStream1);
				System.out.println("commonsys===" + commonSysvar);
			} else {
				return commonSysvar;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonSysvar;
	}

	/*
	 * Depricated not used in the project
	 */
	public static String Count(String contentToWrite) {
		return contentToWrite += "Test Count :" + ++countOftest + " ";
	}

	/*
	 * This method is used to write log file in the specified directory as a txt
	 * format
	 */

	public static FileWriter writeFile() {
		try {
			if (fw == null) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				String filepath = Paths.get("").toAbsolutePath()+"//report/"; // retunStringFromCommonSystemproperties("filePath");
				// get current date time with Date()
				Date date = new Date();
				System.out.println(dateFormat.format(date));
				System.out.println("filepath-->"+ filepath);
				
				//File file1 = new File("D://SVN_hubble/trunk/MSBWorkSpaceMSBWorkSpace/report");
				File file1 = new File("filepath");
				boolean blnDeleted = file1.delete();
				   
			     System.out.println("Was file deleted ? : " + blnDeleted);
				
//				for(File file: filepath.listFiles()) file.delete();
				//FileUtils.deleteDirectory(new File(filepath));
//				File file = new File("filepath");      
//			       String[] myFiles;    
//			           if(file.isDirectory()){
//			               myFiles = file.list();
//			               for (int i=0; i<myFiles.length; i++) {
//			                   File myFile = new File(file, myFiles[i]); 
//			                   myFile.delete();
//			               }
//			            }
				String fileName = filepath
						+ "MSBReport"+ ".txt";
				System.out.println(fileName);
				File file = new File(fileName);
				
				if (!file.exists()) {
					file.createNewFile();
				}

				fw = new FileWriter(file.getAbsoluteFile());
			} else {
				return fw;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fw;
	}

	/*
	 * This method is used to write log file in the specified directory as a
	 * html format
	 */
	public static FileWriter writeHtmlFile() {
		try {
			if (Htmlfw == null) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				// get current date time with Date()
				String filepath = Paths.get("").toAbsolutePath()+"//report/";// retunStringFromCommonSystemproperties("filePath");
				Date date = new Date();
				System.out.println(dateFormat.format(date));
				File file1 = new File("filepath");
				boolean blnDeleted = file1.delete();
				   
			     System.out.println("Was file deleted ? : " + blnDeleted);
				
				String fileName = filepath
						+ "MSBReport" + ".html";
				System.out.println(fileName);
				File file = new File(fileName);
				if (!file.exists()) {
					file.createNewFile();
				}

				Htmlfw = new FileWriter(file.getAbsoluteFile());
			} else {
				return Htmlfw;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Htmlfw;
	}

	/*
	 * get the buffer write object if not existed
	 */
	public static BufferedWriter getBufferWriter() {
		if (bw == null) {
			return bw = new BufferedWriter(MSBUtils.writeFile());
		} else {
			return bw;
		}
	}

	/*
	 * get the buffer write object if not existed
	 */
	public static BufferedWriter getHtmlBufferWriter() {
		if (htmlbw == null) {
			return htmlbw = new BufferedWriter(MSBUtils.writeHtmlFile());
		} else {
			return htmlbw;
		}
	}

	/*
	 * for the close connection
	 */
	public static void closeConnection() {
		try {
			if (conn != null) {

				conn.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * getResult() will return hastable as the result for the query (need to
	 * specify 'As' to get the result)
	 */
	public static String getEnvironmentTotest() {
		if (environmentTotest == null) {
			environmentTotest = "dev";// retunStringFromCommonSystemproperties("environment");
			System.out.println("Environemnt to test" + environmentTotest);
		} else {
			return environmentTotest;
		}
		System.out.println("Environment to test" + environmentTotest);
		return environmentTotest;
	}

	public static String getbasicUrl() {

		return retunStringFromCommonSystemproperties("baseUrlwithContext_"
				+ environmentTotest);
	}

	public static void takeScreenShot(WebDriver driver, ReportBean ob) {

		try {
			WebDriver augmentedDriver = new Augmenter().augment(driver);
			File screenshot = ((TakesScreenshot) augmentedDriver)
					.getScreenshotAs(OutputType.FILE);

			// System.out.println("FILEPATH===>" + screenshot.getPath());
			// System.out.println("RULE ID" + ob.getRuleId());
			// System.out.println("======="+CPTUtils.loadTestresultProperties());
			String ruleId = "";

			// System.out
			// .println("CPTUtils.loadTestresultProperties().getProperty(propertiesLocations1)"
			// + MSBUtils.loadTestresultProperties().getProperty(
			// "propertiesLocations1"));

			// copyImage(
			// screenshot.getPath(),
			// ob.getRuleId() == null || "".equals(ob.getRuleId()) ? CPTUtils
			// .generateRandomString(10, Mode.ALPHANUMERIC)
			// :CPTUtils.loadTestresultProperties().getProperty("propertiesLocations1")+ob
			// .getRuleId().replaceAll("\\.", "_")+".png");

			if (ob.getRuleId() == null || "".equals(ob.getRuleId())) {
				ruleId = MSBUtils.generateRandomString(10, Mode.ALPHANUMERIC)
						+ ".png";
			} else {
				ruleId = ob.getRuleId().replaceAll("\\.", "_") + ".png";
			}
			System.out.println("RULEID PATH" + ruleId);
			String imagepath = Paths.get("").toAbsolutePath()+"\\report\\" + ruleId;
			System.out.println("Error Image path" + imagepath);
			
//			File file1 = new File("imagepath");
//			boolean blnDeleted = file1.delete();
//			   
//		     System.out.println("Was file deleted ? : " + blnDeleted);
//			
			
			
			ob.setErrorpath(imagepath);

			copyImage(screenshot.getPath(), Paths.get("").toAbsolutePath()+"\\report\\" + ruleId);

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void copyImage(String from, String to)

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

	public static Hashtable<String, String> getResult(String qurey) {
		Hashtable<String, String> restult = new Hashtable<String, String>();
		try {

			Statement stmt = null;
			stmt = getConnection().createStatement();
			String replaceString = MSBUtils.getEnvironmentTotest();
			if (qurey.indexOf("@likeenvironment@") != -1) {
				System.out.println("likeenvironment" + qurey);
				if ("dev".equalsIgnoreCase(replaceString)) {
					qurey = qurey.replace("@likeenvironment@",
							"like \'dev%%dev\' ");
				} else if ("qa".equalsIgnoreCase(replaceString)) {
					qurey = qurey.replace("@likeenvironment@",
							"like \'qa%%qa\' ");
				}
			}
			System.out.println("After qurey" + qurey);
			ResultSet rs = stmt.executeQuery(qurey);
			String PRODUCT_LISTINGandGROUP_ID = "";
			String RSVP_TOTAL_EVENTS = "";
			String Category_program_recomanded_flags = "";
			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = 0;
				String email = "";
				String activated = "";
				String taxrate = "";
				String userName = "";
				String password = "";
				String event_id = "";
				String event_name = "";
				String product_id = "";
				String RSVP_ABLE = "";
				String category_id = "";
				String PROGRAM_ID = "";
				String RECOMMENDED_FLAG = "";
				String schoolId = "";
				String zipcode = "";
				String timeDiff = "false";
//				if (qurey.contains("as Fairid")) {
//					id = rs.getInt("Fairid");
//				}
				if (qurey.contains("as email")) {
					email = rs.getString("email");
				}
				if (qurey.contains("as activated")) {
					activated = rs.getString("activated");
				}
				if (qurey.contains("as taxrate")) {
					taxrate = rs.getString("taxrate");
				}
				if (qurey.contains("as userName")) {
					userName = rs.getString("userName");
				}
				if (qurey.contains("as password")) {
					password = rs.getString("password");
				}
				if (qurey.contains("as event_id")) {
					event_id = rs.getString("event_id");
				}
				if (qurey.contains("as event_name")) {
					event_name = rs.getString("event_name");
				}
				if (qurey.contains("as schoolId")) {
					schoolId = rs.getString("schoolId");
				}
				if (qurey.contains("as zipcode")) {
					zipcode = rs.getString("zipcode");
				}

				if (qurey.contains("as product_id")) {
					product_id = rs.getString("product_id");
				}
				if (qurey.contains("as RSVP_ABLE")) {
					RSVP_ABLE = rs.getString("RSVP_ABLE");
				}
				if (qurey.contains("as category_id")) {
					category_id = rs.getString("category_id");
				}
				if (qurey.contains("as PROGRAM_ID")) {
					PROGRAM_ID = rs.getString("PROGRAM_ID");
				}
				if (qurey.contains("as RECOMMENDED_FLAG")) {
					RECOMMENDED_FLAG = rs.getString("RECOMMENDED_FLAG");
				}

				if (qurey.contains("as publish_date1")) {
					Date date1 = rs.getDate("publish_date1");
					Date date2 = rs.getDate("publish_date2");
					long difference = date2.getTime() - date1.getTime();
					if (difference != 0) {
						timeDiff = "true";
					} else {
						timeDiff = "false";
					}
				}
				if (qurey.contains("as GROUP_ID")) {
					PRODUCT_LISTINGandGROUP_ID += rs.getString("GROUP_ID")
							+ "@@" + rs.getString("PRODUCT_LISTING") + "##";
				}
				if (qurey.contains("as active")
						&& qurey.contains("as event_id")
						&& qurey.contains("as event_name")) {
					RSVP_TOTAL_EVENTS += event_id + "@@" + event_name + "^^"
							+ RSVP_ABLE + "##";
				}
				if (qurey.contains("as category_id")
						&& qurey.contains("as PROGRAM_ID")
						&& qurey.contains("as RECOMMENDED_FLAG")) {
					Category_program_recomanded_flags += PROGRAM_ID + "##";
				}
//				restult.put("fairid", "" + id);
				restult.put("userid", "" + email);
				restult.put("taxrate", "" + taxrate);
				restult.put("activated", "" + activated);
				restult.put("userName", "" + userName);
				restult.put("password", "" + password);
				restult.put("event_id", "" + event_id);
				restult.put("event_name", "" + event_name);
				restult.put("timeDiff", "" + timeDiff);
				restult.put("product_id", "" + product_id);
				restult.put("active", "" + RSVP_ABLE);
				restult.put("schoolId", "" + schoolId);
				restult.put("zipcode", "" + zipcode);
				restult.put("Category_program_recomanded_flags", ""
						+ Category_program_recomanded_flags);
				restult.put("PRODUCT_LISTINGandGROUP_ID", ""
						+ PRODUCT_LISTINGandGROUP_ID);
				restult.put("RSVP_TOTAL_EVENTS", "" + RSVP_TOTAL_EVENTS);

				System.out.println(email + " " + id);
				// Display values
				// System.out.println("ID: " + id);
				// System.out.println(", email: " + email);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			String contentToWrite = "";
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			e.printStackTrace();
			contentToWrite += " Query : " + qurey;
			contentToWrite += " Error : " + errors.toString();
			MSBUtils.writeLog(contentToWrite);
			e.printStackTrace();
		}
		return restult;
	}

	/*
	 * displayReport() after complete the test cases inorder display the the
	 * status
	 */
	@SuppressWarnings("rawtypes")
	public static String displayReport() {
		String retunValue = "";
		try {
			Iterator pages = MSBUtils.valPgsAdCntByCat.entrySet().iterator();
			while (pages.hasNext()) {
				Map.Entry pair = (Map.Entry) pages.next();
				// System.out.println("_^_ " + pair.getKey() + " = " +
				// pair.getValue());
				retunValue += pair.getKey() + " = " + pair.getValue();
				// Iterator PageReport = ((HashMap<String, Integer>)
				// pair.getValue()).entrySet().iterator();
				// while (PageReport.hasNext()) {
				// Map.Entry innerReport = (Map.Entry) PageReport.next();
				// System.out.println("***" + innerReport.getKey() + " = " +
				// innerReport.getValue());
				// // PageReport.remove();
				// }
				// pages.remove(); // avoids a ConcurrentModificationException
			}
		} catch (Exception e)

		{
			e.printStackTrace();
		}
		return retunValue;
	}

	/*
	 * setPageReport is to maintain the page and status count for the test
	 * result
	 */
	public static void setPageReport(String page, String status) {

		if (valPgsAdCntByCat.get(page) != null) {
			HashMap<String, Integer> pagewise = new HashMap<String, Integer>();
			pagewise = valPgsAdCntByCat.get(page);
			if (pagewise.get(status) != null) {
				pagewise.put(status, (pagewise.get(status)) + new Integer(1));
			} else {
				pagewise.put(status, new Integer(1));
			}
			valPgsAdCntByCat.put(page, pagewise);

		} else {
			HashMap<String, Integer> pagewise = new HashMap<String, Integer>();
			pagewise.put(status, new Integer(1));
			valPgsAdCntByCat.put(page, pagewise);
		}
	}

	/*
	 * prepareWriteLog to create and update the log Txt and html format out puts
	 */
	public static void prepareWriteLog(ReportBean ob) {
		String contentToWrite = "";
		boolean error = false;
		if (ob != null) {
			contentToWrite += "\n" + "Test Count : " + tablecount;
			contentToWrite += "\n" + "Page : " + ob.getPage();
			contentToWrite += "\n" + "Rule Id : " + ob.getRuleId();
			System.out.println(ob.getPage() + " " + ob.getRuleId());
			contentToWrite += "\n Description : ";
			if (ob.getErrorMessage() != null
					&& !"".equals(ob.getErrorMessage())) {
				error = true;
				if (ob.getErrorMessage().indexOf("Error") != -1) {
					setPageReport(ob.getPage(), "Error");
					contentToWrite += "\n" + "Error : "
							+ ob.getErrorMessage().replace("Error", "");
					contentToWrite += "\n" + "User Id : " + ob.getUserId();
					contentToWrite += "\n" + "Fair Id : " + ob.getFariId();

				} else {
					contentToWrite += "\n" + "Warning : "
							+ ob.getErrorMessage().replace("Warning", "");
					setPageReport(ob.getPage(), "Warning");
				}
				contentToWrite += "\n" + "Query : " + ob.getQuery();
			}
			if (ob.getSuccessMessage() != null) {
				if (!error) {
					setPageReport(ob.getPage(), "Success");
				}
				contentToWrite += "\n" + "Success : Completed "
						+ ob.getRuleId();
				contentToWrite += "\n\t\t\t"
						+ ob.getSuccessMessage().replace("Success", "");
				if (ob.getItemtoFind() != null && "".equals(ob.getItemtoFind())) {
					contentToWrite += " Item for business rule "
							+ ob.getItemtoFind();
				}
			}
			contentToWrite += "\n" + "Time : " + ob.getTime() + "\n\n\n";
			contentToWrite += displayReport();
			writeLog(contentToWrite);
		}
	}

	public static String difftime(String timeAsText) {
		String retrunValues = "";
		long diffSeconds = Long.parseLong(timeAsText) / (1000 % 60);
		long diffMinutes = Long.parseLong(timeAsText) / ((60 * 1000) % 60);
		long diffHours = Long.parseLong(timeAsText) / (60 * 60 * 1000) / 24;
		if (diffHours > 0) {
			retrunValues += diffHours + " Hours ";
		} else if (diffMinutes > 0) {
			retrunValues += diffMinutes + " Min ";
		} else if (diffSeconds > 0) {
			retrunValues += diffSeconds + " Sec ";
		}

		return retrunValues;
	}

	/*
	 * write/update test logs content in a text file
	 */
	public static void writeLog(String contentToWrite) {
		try {
			URL location = Test.class.getProtectionDomain().getCodeSource().getLocation();
	        System.out.println("Location--->"+location.getFile());
	        System.out.println("Location Path--->"+Paths.get("").toAbsolutePath());
	        
			System.out.println("Entered writelog");
			getBufferWriter().write(contentToWrite);
			getBufferWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * write/update test logs content in a html file
	 */
	public static void writeHtmlLog(String reportHtmlResult) {
		try {
			reportHtmlResult = reportHtmlResult.replaceAll("</tbody></table>",
					"");
			getHtmlBufferWriter().write(reportHtmlResult);
			// getHtmlBufferWriter().write("</tbody></table>");
			getHtmlBufferWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static String reportHtmlResult = "";

	public static void writeHtmlReport(ReportBean ob) {

		if (ob != null) {

			if (tablecount == 0) {

				reportHtmlResult += "<meta charset=\"UTF-8\"><link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/1.10.5/css/jquery.dataTables.css\">";
				reportHtmlResult += "<style type=\"text/css\">a{color: #0254EB}a:visited { color: #0254EB}a.morelink { text-decoration:none; outline: none;}.morecontent span { display:none;}.comment { width: 400px; background-color: #f0f0f0; margin: 10px;}body{font-family: Verdana, Arial, Helvetica, sans-serif}table{width: 800px !important;}thead{background-color: #25a136 !important;}table th{font-size: 13px;font-weight: 400 !important;background-color: #CCCCCC;color: #fff !important;}table.dataTable.display tbody tr.even > .sorting_1, table.dataTable.order-column.stripe tbody tr.even > .sorting_1{background-color: #fff; !important;border-left: 1px solid #ccc;font-weight: bold}table.dataTable.display tbody tr.odd > .sorting_1, table.dataTable.order-column.stripe tbody tr.odd > .sorting_1{background-color: #fff; !important;border-left: 1px solid #ccc;font-weight: bold}table.dataTable.stripe tbody tr.odd, table.dataTable.display tbody tr.odd{background-color: #fff; !important;}table.dataTable.stripe tbody tr.odd, table.dataTable.display tbody tr.even{background-color: #fff; !important;padding-top: 15px;padding-bottom: 15px;}tbody{border-left: 1px solid #ccc;}tbody td{border-right: 1px solid #ccc;}table.dataTable.display tbody tr.even > .sorting_1,table.dataTable.order-column.stripe tbody tr.even > .sorting_1:hover{background-color: #fff; !important;}table.dataTable.display tbody tr:hover > .sorting_1, table.dataTable.display tbody tr.odd:hover > .sorting_1, table.dataTable.display tbody tr.even:hover > .sorting_1, table.dataTable.order-column.hover tbody tr:hover > .sorting_1, table.dataTable.order-column.hover tbody tr.odd:hover > .sorting_1, table.dataTable.order-column.hover tbody tr.even:hover > .sorting_1{background-color: #fff; !important;}table.dataTable.display tbody tr.odd > .sorting_1, table.dataTable.order-column.stripe tbody tr.odd > .sorting_1:hover{background-color: #fff; !important;}table.dataTable.stripe tbody tr.odd, table.dataTable.display tbody tr.odd:hover{background-color: #fff; !important;}table.dataTable.stripe tbody tr.odd, table.dataTable.display tbody tr.even:hover{background-color: #fff; !important;padding-top: 15px;padding-bottom: 15px;}table td{font-size: 11px;font-weight: 400;vertical-align: top;}#example_info{font-size: 12px;color: #000;float: left;margin-left: 15px;}#example_paginate{font-size: 12px;color: #fff !important;}a.paginate_button previous disabled{color: #ddd !important}#example_wrapper{background-color: #ededed;float: left;}#example_length{color: #000 !important;font-size: 12px !important;float: left;margin-left: 15px;margin-top: 15px;margin-bottom: 15px;}#example_filter{float: right;color: #000 !important;font-size: 12px !important;margin-left: 15px;margin-top: 15px;margin-bottom: 15px;margin-right: 180px;}table.extra_table{width: 100% !important;}table.extra_table thead{background-color: #25a136 !important;}.extra_table th{padding: 10px 0px;font-weight: bold !important;color: #fff !important;background: none !important}.extra_table td{text-align: center;color: #000;padding: 10px 0px;}</style>";
				reportHtmlResult += "<script src=\"https://code.jquery.com/jquery-1.11.1.min.js\"></script><script src=\"https://cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js\"></script><script>$(document).ready(function() { $('#example').dataTable({\"iDisplayLength\": 100});} );</script>";
				reportHtmlResult += "<script>$(document).ready(function(){var showChar=100;var ellipsestext=\"...\";var moretext = \"more\";var lesstext = \"less\";$('.more').each(function() { var content = $(this).html();if(content.length > showChar){var c = content.substr(0, showChar);var h = content.substr(showChar-1, content.length - showChar);var html = c + '<span class=\"moreellipses\">' + ellipsestext+ '&nbsp;</span><span class=\"morecontent\"><span>' + h + '</span>&nbsp;&nbsp;<a href=\"\" class=\"morelink\">' + moretext + '</a></span>';$(this).html(html);}});$(\".morelink\").click(function(){if($(this).hasClass(\"less\")) { $(this).removeClass(\"less\");$(this).html(moretext);} else {$(this).addClass(\"less\");$(this).html(lesstext);}$(this).parent().prev().toggle();$(this).prev().toggle();return false; });});</script>";
				reportHtmlResult += "<table id=\"example\" class=\"display\" cellspacing=\"0\" width=\"100%\"><thead><tr><th>Count</th><th>Description</th><th>User</th><th>Time</th><th>Success</th><th>Error</th><th>Error Path</th></tr></thead><tbody>";
				// <th>Rule</th>
				tablecount++;
			} else {
				reportHtmlResult = "";
			}
			if (!"".equals(ob.getRuleId())) {
				reportHtmlResult += "<tr>";
				reportHtmlResult += "<td>" + tablecount++ + "</td>";
				// reportHtmlResult += "<td class=\"comment more\">" +
				// ob.getRuleId()+ "</td>";
				reportHtmlResult += "<td>" + ob.getPage() + "</td>"; // MSBUtils.retunStringFromQueryprop(ob.getRuleId()+
//				if (ob.getFariId() != null
//						&& !"null".equalsIgnoreCase(ob.getFariId())) {
//					reportHtmlResult += "<td>" + ob.getFariId() + "</td>";
//				} else {
//					reportHtmlResult += "<td></td>";
//				}
				if (ob.getUserId() != null
						&& !"null".equalsIgnoreCase(ob.getUserId())) {
					reportHtmlResult += "<td>" + ob.getUserId() + "</td>";
				} else {
					reportHtmlResult += "<td></td>";
				}
//				reportHtmlResult += "<td class=\"comment more\">"
//						+ ob.getQuery() + "</td>";
				System.out.println("Time---->"+ob.getTime());
				if(!"".equals(ob.getTime())){
                    reportHtmlResult += "<td>" + getTimeDiffenrece(ob.getTime()) + "</td>";
                    }else{reportHtmlResult += "<td>" + 0 + "</td>";}
				reportHtmlResult += "<td class=\"comment more\">"
						+ ob.getSuccessMessage() + "</td>";
				reportHtmlResult += "<td class=\"comment more\">"
						+ ob.getErrorMessage() + "</td>";
				if (ob.getErrorpath() != null) {
					reportHtmlResult += "<td> <a href=" + "file://"
							+ ob.getErrorpath() + " target='_blank'><img src="
							+ "file://" + ob.getErrorpath()
							+ " alt='imgage' height='42' width='42'></a></td>";
				} else {
					reportHtmlResult += "<td></td>";
				}
				reportHtmlResult += "</tr>";
				writeHtmlLog(reportHtmlResult);
			}
		}
	}
	

	
	
	
	
}