package com.kp.apps.web.nuvolo.functions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
//import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.automatedowl.tools.drivers.testngholder.JSErrorsDriverHolder;
import com.kp.apps.web.library.Functions;
import com.kp.apps.web.library.GlobalVariables;
import com.kp.apps.web.library.TestProperties;
import com.kp.apps.web.library.GlobalVariables.browser_list;
import com.sun.jna.platform.win32.Secur32;
import com.sun.jna.platform.win32.Secur32Util;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

/**
 * @author Sree Moore
 *         To run tests in Parallel
 */
@Parameters({"env", "browser"})
public class BaseTest {
  private static final Logger logger = Logger.getLogger(BaseTest.class);

  /**
   *
   * Contains the properties of the test
   */
  private Properties          props;

  /**
   * The webdriver to use
   */

  public ExtentReports        extent;
  public ExtentTest           log;


  /**
   * Function to read application under test entry points from default.properties file
   */
  @BeforeSuite(alwaysRun = true)
  @Parameters({"env", "browser"})
  public void SetPortalEntrypoints(@Optional("kpqa") String env,@Optional("chrome") String browser) throws Exception {
    ExtentHtmlReporter reporter =
        new ExtentHtmlReporter(Functions.getTimeStamp() + "AutomationExtentReport.html");
    extent = new ExtentReports();
    extent.attachReporter(reporter);

    try {
      logger.info(
          "**********************Test Execution Started**********************************************************");
      logger.info("SetPortalEntrypoints() -- starting @BeforeSuite");
      logger.info("Environment Variables:" + env);
      logger.info("Browser Variables:" + browser);
      props = new Properties();
      props = TestProperties.getInstance().getDefaultProperties();
      GlobalVariables.environment = env;
      // props.getProperty("environment");
      logger.info("Environment Variables set to jenkins parameter:" + GlobalVariables.environment);
      GlobalVariables.systemUserName =
          Secur32Util.getUserNameEx(Secur32.EXTENDED_NAME_FORMAT.NameDisplay);

      GlobalVariables.sComputerName = getComputerName().toLowerCase();

      GlobalVariables.NationalAdmin().put("Name", props.getProperty("Snow_NationalUser_Name"));
      GlobalVariables.NationalAdmin().put("Role", props.getProperty("Snow_NationalUser_Role"));
      GlobalVariables.NationalAdmin().put("NUID", props.getProperty("Snow_NationalUser_NUID"));
      GlobalVariables.NationalAdmin().put("Group", props.getProperty("Snow_NationalUser_Group"));
      // Externalized KPLoginUsername and Password to pass through Jenkins.Added by Sree
      if (System.getProperty("KPLoginUsername") != null
          && System.getProperty("KPLoginPassword") != null) {
        GlobalVariables.KPLoginUsername = System.getProperty("KPLoginUsername");
        GlobalVariables.KPLoginPassword = System.getProperty("KPLoginPassword");
      }
      else {
        GlobalVariables.KPLoginUsername = props.getProperty("KPLoginUsername");
        GlobalVariables.KPLoginPassword = props.getProperty("KPLoginPassword");
      }
      String sLoginCredentials;
      if (GlobalVariables.sComputerName.contains("CNHARAM5523919")) {
        Assert.assertTrue(
            GlobalVariables.KPLoginPassword != null || GlobalVariables.KPLoginUsername != null,
            "NUID and NUID password is not provided @ "
                + TestProperties.getInstance().propFile.toString());
        sLoginCredentials = "http://" + GlobalVariables.KPLoginUsername + ":"
            + GlobalVariables.KPLoginPassword + "@";
      }
      else
        sLoginCredentials = "http://";

      if (GlobalVariables.environment.contains("kpscoedev")) {
        logger.info("*****************SetPortalEntrypoints to ******KpscoeDEV********** ");

        GlobalVariables.NuvoloCustomerPortalURL =
            sLoginCredentials + props.getProperty("SCOEDEV") + "/sp";
        GlobalVariables.GoogleApplicationURL = sLoginCredentials + props.getProperty("SCOEDEV");
        GlobalVariables.sTestDataFile = "./src/test/resources/kpscoedev/TestData.xls";
      }
      else if (GlobalVariables.environment.contains("kpqa")) {
        logger.info("*****************SetPortalEntrypoints :KpQA ********** ");
        GlobalVariables.NuvoloCustomerPortalURL =
            sLoginCredentials + props.getProperty("QA") + "/sp";
        GlobalVariables.GoogleApplicationURL = sLoginCredentials + props.getProperty("QA");
        GlobalVariables.sTestDataFile = "./src/test/resources/kpqa/TestData.xls";
      }
      else if (GlobalVariables.environment.contains("kpuat")) {
        logger.info("*****************SetPortalEntrypoints :KpUAT ********** ");
        GlobalVariables.NuvoloCustomerPortalURL =
            sLoginCredentials + props.getProperty("UAT") + "/sp";
        GlobalVariables.GoogleApplicationURL = sLoginCredentials + props.getProperty("UAT");
        GlobalVariables.sTestDataFile = "./src/test/resources/kpqa/TestData.xls";
      }
      
      else if (GlobalVariables.environment.contains("kpreprod")) {
        logger.info("*****************SetPortalEntrypoints :KpPreprod ********** ");
        GlobalVariables.NuvoloCustomerPortalURL =
            sLoginCredentials + props.getProperty("PREPROD") + "/sp";
        GlobalVariables.GoogleApplicationURL = sLoginCredentials + props.getProperty("PREPROD");
        GlobalVariables.sTestDataFile = "./src/test/resources/kppreprod/TestData.xls";
      }
      

      else {
        logger.info("*****************SetPortalEntrypoints to******KpscoeSandBox********** ");
        GlobalVariables.NuvoloCustomerPortalURL =
            sLoginCredentials + props.getProperty("Sandbox") + "/sp";
        GlobalVariables.GoogleApplicationURL = sLoginCredentials + props.getProperty("Sandbox");
        GlobalVariables.sTestDataFile = "./src/test/resources/kpsandbox/TestData.xls";
      }

      GlobalVariables.browser =browser.toUpperCase();
          //props.getProperty("Browser");
      logger.info("Execution starting with Browser from Jenkins:=" +  GlobalVariables.browser);
      logger.info("Execution starting with Browser:=" + browser.toUpperCase());
          //GlobalVariables.browser);
      logger.info("NuvoloCustomerPortalURL:=" + GlobalVariables.NuvoloCustomerPortalURL);
      logger.info("NuvoloApplicationURL:=" + GlobalVariables.GoogleApplicationURL);
      // Added below code to display environment details in Allure report:
      createFile("environment.properties", env, browser, GlobalVariables.GoogleApplicationURL,
          GlobalVariables.NuvoloCustomerPortalURL);
      
      logger.info("SetPortalEntrypoints() -- end of @BeforeSuite");
    } catch (Exception e) {
      e.printStackTrace();
      logger.info("SetPortalEntrypoints failed with exception:" + e);
      Assert.fail("setUp failed with exception:" + e);
    }
  }
  
  // Added below code to display environment details in Allure report:
  private void createFile(String fileName, String env, String browser, String appURL,
      String cpURL) {
   try {
      File directory = new File("target/allure-results");
      if (!directory.exists()) {        
        directory.mkdirs();
      }
      OutputStream output = new FileOutputStream(directory+"/environment.properties");
      Properties prop = new Properties();
      // set the properties value      
      prop.setProperty("Environment", env);
      prop.setProperty("Browser", browser);
      prop.setProperty("NuvoloCustomerPortalURL", cpURL);
      prop.setProperty("NuvoloApplicationURL", appURL);
      // save properties to project root folder
      prop.store(output, null);
      System.out.println(prop);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
    
  /**
   * Function to launch the browser
   */
  @Parameters("browser")
  @BeforeMethod(alwaysRun = true)
  public void setUp(Method method,@Optional("chrome")String browserParam) throws Exception {
    WebDriver driver = null;
    try {

      logger.info("Loading setUp() before method()" );
      logger.info("Browser Param" +  browserParam);

      browser_list browser = browser_list.valueOf(browserParam.toUpperCase());
      DesiredCapabilities capabilities;
      logger.info("Browser Param After Conversion" +  browserParam);
      switch (browser) {
        case IE:
          WebDriverManager.iedriver().setup();
          driver = new InternetExplorerDriver();
          break;

        case CHROME:
          WebDriverManager.chromedriver().setup();
          ChromeOptions options = new ChromeOptions();
          options.addArguments("--test-type");
          options.addArguments("--disable-extensions");
          options.addArguments("disable-infobars");
          options.addArguments("--disable-notifications");
          options.addArguments("enable-automation");
          options.addArguments("--disable-popup-blocking");
          options.addArguments("start-maximized");
//          options.setExperimentalOption("excludeSwitches",
//              Collections.singletonList("enable-automation"));
          options.setExperimentalOption("useAutomationExtension", false);

          capabilities = new DesiredCapabilities();
          capabilities.setCapability(ChromeOptions.CAPABILITY, options);
          options.merge(capabilities);
          driver = new ChromeDriver(options);
          driver.manage().deleteAllCookies();
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.info("setUp failed with exception:" + e);
      Assert.fail("setUp failed with exception:" + e);
    }
    if (driver != null) {
      Factory.getinstance().setDriver(driver);
      JSErrorsDriverHolder.setDriverForTest(method.getName(), driver);
    }
  }

  public static String getComputerName() {
    Map<String, String> env = System.getenv();
    if (env.containsKey("COMPUTERNAME"))
      return env.get("COMPUTERNAME");
    else if (env.containsKey("HOSTNAME"))
      return env.get("HOSTNAME");
    else
      return "Unknown Computer";
  }

  /**
   * @author Sree Moore
   *         To capture ScreenShot for failed tests.
   */

  @AfterMethod(alwaysRun = true)
  public void afterMethod(ITestResult result) throws IOException {
    if (result.getStatus() == ITestResult.FAILURE) {
      saveScreenshotPNG(Factory.getinstance().getDriver());
    }
    else if (result.getStatus() == ITestResult.SKIP) {
      allureLog("Test Case SKIPPED IS " + result.getName());
    }
    else if (result.getStatus() == ITestResult.SUCCESS) {
      allureLog("Test Case PASSED IS " + result.getName());

    }
    try {
      if (Factory.getinstance().getDriver() == null)
        return;
      Factory.getinstance().getDriver().quit();
    } catch (Exception e) {
      // TODO Need to check w.r.t Exception
      // INFO: Unable to drain process streams. Ignoring but the exception being swallowed follows.
      // org.apache.commons.exec.ExecuteException: The stop timeout of 2000 ms was exceeded (Exit
      // value: -559038737)
    }
  }

  // Text attachments for Allure
  @Attachment(value = "Page screenshot", type = "image/png")
  public byte[] saveScreenshotPNG(WebDriver driver) {
    return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
  }

  @Step(value = "{0}")
  public static String allureLog(String message) {
    return message;
  }

  public WebDriver getDriver() {
    return Factory.getinstance().getDriver();
  }

}
