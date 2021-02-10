package com.web.googleTest;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.kp.apps.web.library.GlobalVariables;
import com.kp.apps.web.nuvolo.application.HomePage;
import com.kp.apps.web.nuvolo.functions.BaseTest;
import com.web.google.GoogleSearchPage;



public class GoogleTest extends BaseTest {
  
  HomePage      home = new HomePage();
  private Logger logger =  Logger.getLogger(GoogleTest.class);
  WebDriver driver;
 
  
  @Test
  public void ValidateGoogleSearch() throws Exception {
   logger.info("Verifying google search home page");
   ValidateGoogleHomePage();

   }


  //Actions:
  
  public void ValidateGoogleHomePage() throws Exception {
    try {
   home.goto_NuvoloAppHomePage(getDriver());
   logger.info("Google application launched successfully");
     
   }
   finally {
     logger.info("\n************Execution of testcase: " +  "  ends.************\n");

   }
  }
  
  
}
