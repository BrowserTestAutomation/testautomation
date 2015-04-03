package com.selenium.examples;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCaseSample1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private Commando command;

  /*@Before
  public void setUp() throws Exception {
	command=new Commando();
	command.initHub();
	
			
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:9090/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }*/
  @Before
  public void setUp() throws Exception {
	
	
			
    /*driver = new FirefoxDriver();
    baseUrl = "http://localhost:9090/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
  }
  

  //@Test
  public void testCaseSantosh() throws Exception {
	  driver = new InternetExplorerDriver();
    driver.get("http://localhost:9090/SupportAssist/resx/login.jsp");
    driver.findElement(By.id("usernamefield")).clear();
    driver.findElement(By.id("usernamefield")).sendKeys("administrator");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Pa$$word!");
    driver.findElement(By.id("btnLogin")).click();
   

    driver.findElement(By.cssSelector("#ManageDevices > span")).click();
    driver.findElement(By.cssSelector("#ManageDevices > span")).click();
    driver.findElement(By.cssSelector("img.k-image")).click();
    driver.findElement(By.id("DevIPAddress")).clear();
    driver.findElement(By.id("DevIPAddress")).sendKeys("10.94.217.229");
    driver.findElement(By.id("DevIPAddress")).clear();
    driver.findElement(By.id("DevIPAddress")).sendKeys("10.94.217.229");
    driver.findElement(By.id("DevUserName")).clear();
    driver.findElement(By.id("DevUserName")).sendKeys("root");
    driver.findElement(By.id("DevUserName")).clear();
    driver.findElement(By.id("DevUserName")).sendKeys("root");
    driver.findElement(By.id("DevPwd")).clear();
    driver.findElement(By.id("DevPwd")).sendKeys("Dell_123$");
    driver.findElement(By.id("DevPwd")).clear();
    driver.findElement(By.id("DevPwd")).sendKeys("Dell_123$");
// driver.findElement(By.cssSelector("#lnklogout > span")).click();
  }

  @Test
  public void testFirefox(){
	//DesiredCapabilities capability = DesiredCapabilities.firefox();
	
 DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
	  try {
		 
		System.setProperty("webdriver.ie.driver", "C:\\softwares\\Browser_automation\\IEDriverServer.exe");
		driver = new RemoteWebDriver(
		          new URL("http://localhost:4444/wd/hub"), capability);
	//	driver = new InternetExplorerDriver();
		driver.get( "http://www.indianrail.gov.in/");
	    driver.findElement(By.linkText("Reserved Train Schedule")).click();
	    driver.findElement(By.linkText("Reserved Train Schedule")).click();
	    driver.findElement(By.id("lccp_trnname")).clear();
	    driver.findElement(By.id("lccp_trnname")).sendKeys("16525");
	    driver.findElement(By.id("lccp_trnname")).clear();
	    driver.findElement(By.id("lccp_trnname")).sendKeys("16525");
	    driver.findElement(By.name("getIt")).click();
	    driver.findElement(By.name("getIt")).click();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  
 /* @Test
  public void testinternetExplorer(){
	  DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
	  DesiredCapabilities capability = DesiredCapabilities.firefox();
	  try {
		driver = new RemoteWebDriver(
		          new URL("http://localhost:4444/wd/hub"), capability);
		driver.get("http://localhost:9090/SupportAssist/resx/login.jsp");
		driver.findElement(By.id("usernamefield")).clear();
	    driver.findElement(By.id("usernamefield")).sendKeys("administrator");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("Pa$$word!");
	    driver.findElement(By.id("btnLogin")).click();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}*/
  
  
  @After
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
