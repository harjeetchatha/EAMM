package com.web.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import io.qameta.allure.Step;

public class GoogleSearchPage {
  
  
  @FindBy(xpath = "//*[@name ='q']")
  WebElement      googleSrch;

  @FindBy(xpath = "(//*[@class='gNO89b'])[2]")
  WebElement      assetTxtField;
  
  
  
 
  public void googleSrchIsAvailable(WebDriver driver) {
    Assert.assertTrue(googleSrch.isDisplayed());
  }

}
