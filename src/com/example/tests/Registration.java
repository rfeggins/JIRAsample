package com.example.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
 
public class Registration {
 private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
 
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://automationpractice.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
 
  @Test
  public void testRegistration() throws Exception {
    driver.get(baseUrl + "/index.php");
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("email_create")).click();
    driver.findElement(By.id("email_create")).clear();
    driver.findElement(By.id("email_create")).sendKeys("test123456@yahoo.com");
    driver.findElement(By.id("SubmitCreate")).click();
    driver.findElement(By.id("customer_firstname")).clear();
    driver.findElement(By.id("customer_firstname")).sendKeys("Test");
    driver.findElement(By.id("customer_lastname")).clear();
    driver.findElement(By.id("customer_lastname")).sendKeys("Test");
    driver.findElement(By.id("passwd")).clear();
    driver.findElement(By.id("passwd")).sendKeys("test1234");
    new Select(driver.findElement(By.id("days"))).selectByValue("1");
    driver.findElement(By.cssSelector("option[value=\"1\"]")).click();
    new Select(driver.findElement(By.id("months"))).selectByIndex(1);
    driver.findElement(By.cssSelector("#months > option[value=\"1\"]")).click();
    new Select(driver.findElement(By.id("years"))).selectByValue("1981");
    driver.findElement(By.cssSelector("option[value=\"1981\"]")).click();
    //driver.findElement(By.id("days")).clear();
    //driver.findElement(By.id("days")).sendKeys("1");
    //driver.findElement(By.id("months")).clear();
    //driver.findElement(By.id("months")).sendKeys("Jan");
   // driver.findElement(By.id("years")).clear();
    //driver.findElement(By.id("years")).sendKeys("1981");
    driver.findElement(By.id("company")).clear();
    driver.findElement(By.id("company")).sendKeys("Test");
    driver.findElement(By.id("address1")).clear();
    driver.findElement(By.id("address1")).sendKeys("Test 1");
    driver.findElement(By.id("city")).clear();
    driver.findElement(By.id("city")).sendKeys("Atlanta");
    new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("Georgia");
    driver.findElement(By.cssSelector("#id_state > option[value=\"10\"]")).click();
    driver.findElement(By.id("postcode")).clear();
    driver.findElement(By.id("postcode")).sendKeys("30097");
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("678-209-1234");
    driver.findElement(By.id("submitAccount")).click();
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
