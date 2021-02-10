package com.kp.apps.web.library;

import static org.testng.Assert.assertFalse;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author sreemoore
*/
public class EAMMPageActions {

  private Logger  logger      = Logger.getLogger(EAMMPageActions.class);

  WebDriver driver;
  Actions actions;
  Alert alert;

  public EAMMPageActions(WebDriver driver) {
    this.driver = driver;
    actions = new Actions(driver);
  }

  public void type(WebElement element, String value, String steplog) {
    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
    SeleniumWait.hold(GlobalVariables.mediumSleep);
    element.clear();
    element.click();
    element.sendKeys(value);
    actions.sendKeys(Keys.TAB).build().perform();
    logger.info(steplog);
  }

  public void clickAt(WebElement element, String steplog) {
    element = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(element));
    actions.moveToElement(element).click(element).build().perform();
    logger.info(steplog);
  }

  public WebElement waitForElementToBeClickable(By elementLocator, int timeout) {
    WebElement webElement = null;

    WebDriverWait wait = new WebDriverWait(driver, timeout);
    try {

      webElement = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));

    } catch (StaleElementReferenceException e) {
      // do nothing, don't want to log this
    }

    // if element wasn't found -> fail test
    if (webElement == null) {
      assertFalse(true, "WebElement not found within " + timeout + " seconds. Failing test!"
          + " of element: " + elementLocator + "\nCurrent page: " + driver.getCurrentUrl());
    }
    return webElement;
  }

  public WebElement waitForElementToBeClickable(WebElement element, int timeout) {
    WebElement webElement = null;
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    try {
      webElement = wait.until(ExpectedConditions.elementToBeClickable(element));

    } catch (StaleElementReferenceException e) {
      // do nothing, don't want to log this
    }

    // if element wasn't found -> fail test
    if (webElement == null) {
      assertFalse(true, "WebElement not found within " + timeout + " seconds. Failing test!"
          + " of element: " + element + "\nCurrent page: " + driver.getCurrentUrl());
    }
    return webElement;
  }

  public boolean selectDropDown(WebElement element, String val)
      {
    boolean result = false;
    int attempts = 0;
    Select select;
    while (attempts < 5) {
      try {
        select = new Select(element);
        select.selectByVisibleText(val);
        result = true;
        break;
      } catch (StaleElementReferenceException e) {
      }
      attempts++;
      assertFalse(true, "WebElement not found within " + attempts + " Failing test!"
          + " of element: " + element + "\nCurrent page: " + driver.getCurrentUrl());
    }
    return result;
  }

  public String getVisibleText(WebElement element) {
    WebElement ele =
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(element));
    logger.info("Text captured :" + ele.getText().trim());
    return ele.getText().trim();

  }

  public void typeAndPressEnterKey(WebElement element, String value, String steplog) {
    new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(element));
    element.clear();
    actions.sendKeys(element,value).sendKeys(element,Keys.ENTER).build().perform();
    logger.info(steplog);
  }

  public void clickAndType(WebElement element, String value, String steplog) {
    new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
    element.clear();
    actions.click(element).sendKeys(element,value).build().perform();
    logger.info(steplog);
  }


  public void clickUsingJs(WebElement element,String steplog) {
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", element);
    logger.info(steplog);
  }

  // To double click on the webelement:

  public void doubleClick(WebElement element, String LogMessage) {
    new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
    actions.doubleClick(element).perform();
    logger.info(LogMessage);
  }


//To wait for TransactionsToLoad text invisibility
  public void waitForTransactionsToLoad() {
    try {
    WebDriverWait wait = new WebDriverWait(driver, 5000L);
    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("#atf_session_message_outer_div_id")))); // wait for loader to disappear
    }catch(Exception e) {
      logger.info("element not available"+e.getMessage());
    }
}

//To accept the Alert
  public String acceptAlert() {

  driver.switchTo().defaultContent();
  new WebDriverWait(driver,60).until(ExpectedConditions.alertIsPresent());
  alert=driver.switchTo().alert();
  String alertText = alert.getText();
  alert.accept();

  return alertText;
}

 //To dismiss the Alert
  public String dismissAlert() {
    driver.switchTo().defaultContent();
    new WebDriverWait(driver,60).until(ExpectedConditions.alertIsPresent());
    alert=driver.switchTo().alert();
    String alertText = alert.getText();
    alert.dismiss();
    return alertText;

}

//To verify the Element is available
  public boolean isElementAvailable(WebElement element,String steplog) {
    new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(element));
     logger.info(steplog);
     return element.isDisplayed();
  }

 //To wait for LeftNavToLoad icon invisibility
      public void waitForLeftNavToLoad() {
        try {
        WebDriverWait wait = new WebDriverWait(driver, 5000L);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div/Span[@class='icon-loading']")))); // wait for Left Nav loader to disappear
        }catch(Exception e) {
          logger.info("element not available"+e.getMessage());
        }
    }

/*To wait for HomePageToLoad icon invisibility,
      This function has to be called after we
      switch to the frame as this is displayed in the frame.*/
  public void waitForHomePageToLoad() {
    try {
    WebDriverWait wait = new WebDriverWait(driver, 5000L);
    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("(//div[@class='loading-container'])[1]")))); // wait for Home Page loader to disappear
    }catch(Exception e) {
      logger.info("element not available"+e.getMessage());
    }
}

  //To get the Attribute
  public String getAttribute(WebElement element) {
    WebElement ele =
        (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOf(element));
    logger.info("Text captured :" + ele.getAttribute("value").trim());
    return ele.getAttribute("value").trim();

  }

//To get the selected Dropdown Value
  public String getSelectedDropdownValue(WebElement element) {
    WebElement ele =
        (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOf(element));
    String selectedOption = new Select(element).getFirstSelectedOption().getText();
    logger.info("Text captured :" +selectedOption.trim());
    return selectedOption.trim();

  }

  //Scroll page until element is visible:
  public void scrollthePage(WebElement element) {
  JavascriptExecutor executor = (JavascriptExecutor) driver;
  executor.executeScript("arguments[0].scrollIntoView(true);",element );
  }



//To verify the Checkbox is selected
  public boolean isCheckboxSelected(WebElement element,String steplog) {
    new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(element));
     logger.info(steplog);
     return element.isSelected();
  }

}
