package com.kp.apps.web.nuvolo.application;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.kp.apps.web.library.GlobalVariables;
import com.kp.apps.web.nuvolo.functions.BaseTest;

public class HomePage {

  private Logger logger = Logger.getLogger(HomePage.class);

  public void goto_NuvoloAppHomePage(WebDriver driver) throws Exception {
    try {
      driver.get(GlobalVariables.GoogleApplicationURL);
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      Thread.sleep(GlobalVariables.vvlongSleep);
    }  
   catch (Exception e) {
      logger.error("Failed to navigate Nuvolo application home page" + e.toString());
    }
  }
}

