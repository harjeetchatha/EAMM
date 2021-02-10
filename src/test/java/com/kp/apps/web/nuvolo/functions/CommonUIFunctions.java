package com.kp.apps.web.nuvolo.functions;

import static com.kp.apps.web.library.GlobalVariables.ShortSleep;
import static com.kp.apps.web.library.GlobalVariables.longSleep;
import static com.kp.apps.web.library.GlobalVariables.mediumSleep;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.kp.apps.web.library.GlobalVariables;
import com.kp.apps.web.library.SeleniumWait;

public class CommonUIFunctions {
  private static final Logger logger = Logger.getLogger(CommonUIFunctions.class);

  public boolean retrievecurrentstateOfThecheckbox(WebDriver driver, By byLocator) throws Exception {
    boolean bstate = false;
    try {
      logger.info("retrievecurrentstateOfThecheckbox");
      WebElement e = driver.findElement(byLocator);
      if (e.getAttribute("value").equalsIgnoreCase("true")) {
        logger.info("Checkbox displayed with state: Checked");
        bstate = true;
      }
      else {
        logger.info("Checkbox displayed with state:  Unchecked");
        bstate = false;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return bstate;
  }

  // TODO -- hk duplicate method. move this file to the functions
  public void toggleCheckbox(WebDriver driver, By byID, By byLabel, boolean bToggle)
      throws Exception {
    try {
      logger.debug("Checkbox with locator :" + byID + " To state: " + bToggle);
      Assert.assertTrue(driver.findElements(byID).size() > 0, "Check box not displayed");
      boolean bCurrentstate = retrievecurrentstateOfThecheckbox(driver, byID);
      logger.info("Checkbox with locator :" + byID + " is dispalyed with state: " + bCurrentstate);

      if (bToggle) {
        if (bCurrentstate)
          logger.debug("Checkbox already in checked state");
        else {
          logger.debug("Toggling Checkbox state To - Checked");
          driver.findElement(byLabel).click();
        }
      }
      else {
        if (bCurrentstate) {
          logger.debug("Toggling Checkbox state To - Unchecked");
          driver.findElement(byLabel).click();
        }
        else
          logger.debug("Checkbox already in unchecked state");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  // Search by a number
  // TODO (Added by RD) Will add the argument details-


  public static void searchByValue(WebDriver driver, By menuLocator, By menuItemLocator,
      By inputLocator, String searchValue) throws Exception {
    try {
      logger.debug("In Search By Value: " + searchValue);
      Assert.assertTrue(driver.findElement(menuLocator).isEnabled());
      driver.findElement(menuLocator).click();
      driver.findElement(menuItemLocator).click();
      logger.debug("Search- Value select");

      // driver.findElement(By.xpath("//select[contains(@id,'select')]")).click();
      Actions act = new Actions(driver);
      logger.info("Search Value -" + searchValue);
      driver.findElement(inputLocator).sendKeys(searchValue);

      act.sendKeys(Keys.ENTER).build().perform();
      SeleniumWait.hold(GlobalVariables.ShortSleep);
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("searchByValue function failed" + e.toString());
      Assert.fail("searchByValue function failed" + e.toString());
    }
  }

  // TODO (Added by RD) Will add the argument details-

  public static void validateValueInRow(WebDriver driver, String searchValue, int colVal)
      throws Exception {
    try {
      logger.info("Validate Value on first row: " + searchValue);
      String value_locator = "//tr[1][contains(., '" + searchValue + "')]/td[" + colVal + "]/a";
      Assert.assertTrue(driver.findElement(By.xpath(value_locator)).isDisplayed(),
          "Value not found" + searchValue);
//            logger.info("Clicking on the value: " + searchValue);
      // TODO RD - Not sure if this click is needed
//            driver.findElement(By.xpath(value_locator)).click();
      Thread.sleep(GlobalVariables.ShortSleep);
      logger.info(searchValue + ": Found on first row");
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("validateValueInRow function failed" + e.toString());
      Assert.fail("validateValueInRow function failed" + e.toString());
    }
  }

  public static void clickOnThisElementOnRow(WebDriver driver, String searchValue, int colVal)
      throws Exception {
    try {
      logger.info("Validate Value on first row: " + searchValue);
      String value_locator = "//tr[1][contains(., '" + searchValue + "')]/td[" + colVal + "]/a";
      Assert.assertTrue(driver.findElement(By.xpath(value_locator)).isDisplayed(),
          "Value not found" + searchValue);
      logger.info(searchValue + ": Found on first row");
      logger.info("Clicking on the value: " + searchValue);
      driver.findElement(By.xpath(value_locator)).click();
      Thread.sleep(GlobalVariables.ShortSleep);
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("validateValueInRow function failed" + e.toString());
      Assert.fail("validateValueInRow function failed" + e.toString());
    }
  }

  // TODO (Added by RD) Will add the argument details-

  public static void setDisplayColumnFiltersToDefaults(WebDriver driver, By bySettingsIconButton,
      By bySettingsPageTitle, By byOkBtn, By byResetToDefaultsBtn) throws Exception {
    try {

      CommonUIFunctions.goToSettingIconMenu(driver, bySettingsIconButton, bySettingsPageTitle);

      // CLick on the Column Settings button
      logger.info("setting CompanyDisplay Column Filters ToDefaults");
      SeleniumWait.hold(ShortSleep);
      if (driver.findElement(byResetToDefaultsBtn).isDisplayed()) {
        logger.debug("Clicking 'reset_column_defaults' button in personalize list columns pop up");
        driver.findElement(byResetToDefaultsBtn).click();
      }
      else {

        logger.debug("Clicking 'OK' button in personalize list columns pop up");
        driver.findElement(byOkBtn).click();
      }
      SeleniumWait.hold(ShortSleep);
    } catch (Exception e) {
      logger.error("Not able to setCompanyDisplayColumnFiltersToDefaults" + e.toString());
      Assert.fail("Not able to setCompanyDisplayColumnFiltersToDefaults" + e.toString());
    }
  }

  public static void goToSettingIconMenu(WebDriver driver, By settingMenuBtn, By bySettingsPageTitle)
      throws Exception {
    try {
      // CLick on the Column Settings button
      SeleniumWait.hold(ShortSleep);
      logger.info("Going to click on Column Settings Button");
      driver.findElement(settingMenuBtn).click();
      SeleniumWait.hold(ShortSleep);

      Assert.assertTrue(driver.findElement(bySettingsPageTitle).isDisplayed(),
          "Oops.. Personalize Model  is not displayed");
      logger.info("Clicked on Column Settings Button");
    } catch (Exception e) {
      logger.error("Not able to goToSettingIconMenu" + e.toString());
      Assert.fail("Not able to goToSettingIconMenu" + e.toString());
    }
  }

  // ToDO THis needs to be tested...
  public static void resetColumnToDefaultSettings(WebDriver driver, By resetBtn, By okBtn,
      By cancelBtn) throws Exception {
    try {
      // CLick on the Column Settings button
      logger.info("Going to reset column filters to defaults");
      if (driver.findElement(resetBtn).isDisplayed()) {
        logger.info("Reset button is displayed");
      }
      else if (driver.findElement(cancelBtn).isDisplayed()) {
        logger.info("Cancel button is displayed");
      }
      SeleniumWait.hold(ShortSleep);
    } catch (Exception e) {
      logger.error("Not able to setCompanyDisplayColumnFiltersToDefaults" + e.toString());
      Assert.fail("Not able to setCompanyDisplayColumnFiltersToDefaults" + e.toString());
    }
  }

  // Arguments list
  // hbBtn - Hamburger Button on the left top
  // hbMenuItem - to pick a menu item - like Group By or Show
  // hbItemVal - to pick the value in Group By - like Active or Manufacturer

  public static void searchHamburgerMenuGroupBy(WebDriver driver, By hbBtn, By hbMenuItem,
      By hbItemVal) throws Exception {
    try {
      logger.info("Search Parts through HamburgerMenu and Group By");
      Assert.assertTrue(driver.findElement(hbBtn).isDisplayed(), "Hamburger button not displayed: "
          + hbBtn);
      driver.findElement(hbBtn).click();
      Assert.assertTrue(driver.findElement(hbMenuItem).isDisplayed(),
          "Hamburger menu item not displayed" + hbMenuItem);
      driver.findElement(hbMenuItem).click();
      Assert.assertTrue(driver.findElement(hbItemVal).isDisplayed(),
          "Filter By value not displayed" + hbItemVal);
      driver.findElement(hbItemVal).click();
      SeleniumWait.hold(ShortSleep);
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("searchHamburgerMenuGroupBy " + e.toString());
    }
  }

  // Arguments list
  // totalRows - Total Rows in the application
  // groupByItem - to pick the group item - like Group By Active
  // noRecords - When no rows, then it displays this 'no records'
  public static void validateGroupByDisplay(WebDriver driver, By totalRows, By groupByItem,
      By noRecords) {
    logger.info("Validating Filter Parts Group By");
    boolean found_rows = false;

    String total_rows_str = null;
    String filter_rows_string = null;
    int filter_rows_num = 0, total_rows_num = 0;

    try {
      if (driver.findElement(totalRows).isDisplayed()) {
        logger.debug("Found total rows display");
        total_rows_str = driver.findElement(totalRows).getText();
        total_rows_str = total_rows_str.replaceAll("\\D+", "");
        total_rows_num = Integer.parseInt(total_rows_str);
        logger.info("Total Rows = " + total_rows_str);
        if (total_rows_num != 0) {
          found_rows = true;
        }
        else {
          logger.info("No companies found to display");
        }
      }
    } catch (Exception e) {
      found_rows = false;
      logger.info("Could not find total rows display");
      logger.info("Now checking for - No records to display");

      if (!driver.findElement(noRecords).isDisplayed()) {
        logger.info("Oops did not find - No records to display");
      }
      else {
        logger.info("Found - No records to display");
      }
    }
    if (found_rows) {
      // Search for Active Companies
      try {
        if (driver.findElement(groupByItem).isDisplayed()) {
          logger.info("Found total rows display");
          filter_rows_string = driver.findElement(groupByItem).getText();
          logger.info("Rows = " + filter_rows_string);

          filter_rows_string = filter_rows_string.replaceAll("\\D+", "");
          filter_rows_num = Integer.parseInt(filter_rows_string);
          logger.info(filter_rows_num);
          int val = total_rows_num - filter_rows_num;
          Assert.assertTrue((filter_rows_num <= total_rows_num),
              "Filtered rows are greater than total rows ");
          logger.info("Filtered number of rows: " + filter_rows_num
              + " is lesser than or equal to total rows: " + total_rows_num);

        }
      } catch (Exception e) {
        logger.error("Could not find filter rows to display");
      }
    }
  }

  public static int getColumnNumberForColumnHeader(WebDriver driver, String tableName,
      String headerName) {
    int i = -1;
    String data = null;


    WebElement ele = null;
    List<WebElement> header_list =
        driver.findElements(By.xpath("//table[contains(@id,'" + tableName
            + "')]//th[contains(@class,'list_header')]"));

    for (i = 0; i < header_list.size(); i++) {
      logger.info(header_list.get(i).getText());
      logger.info(headerName);
      data = header_list.get(i).getText().trim();
      String[] data1 = header_list.get(i).getText().split("\n");
      if (headerName.equalsIgnoreCase(data1[0])) {
        logger.info("It is equal!!!");
        logger.info("Column number for header = " + headerName + " is " + i);
        break;
      }
      if (data.compareTo(headerName) == 0) {
        logger.info("Column number for header = " + headerName + " is " + i);
        break;
      }
    }
    return i;
  }

  public static void verifyNewButtonEnabled(WebDriver driver, boolean bPrivilegedUser,
      String sUser, By newBtn, By newBtnTitle) throws Exception {
    try {
      if (bPrivilegedUser) {
        Thread.sleep(GlobalVariables.mediumSleep);
        Assert.assertTrue(driver.findElement(newBtn).isDisplayed(), "New button is not displayed");
        driver.findElement(newBtn).click();

        logger.info("The new button is displayed and clicked" + newBtn);
        Thread.sleep(GlobalVariables.longSleep);

        Assert.assertTrue(
            (driver.findElement(newBtnTitle).isDisplayed() && driver.findElement(newBtn)
                .isDisplayed()), "New Page is not displayed");
      }
      else {
        Assert.assertTrue(driver.findElements(newBtn).size() > 0,
            "New button is not displayed for non privileged user :" + sUser);
        logger.info("New button is displayed for " + sUser + " user as expected");
      }

    } catch (Exception e) {
      logger.error("verifyNewButtonEnabled --failed with error" + e.toString());
      Assert.fail("verifyNewButtonEnabled --failed with error" + e.toString());
    }
  }

  /*
   *This method validateDisplayColumnFilters
   * Input - WebDriver, String[] of column filters
   * column filters - {"Number", "Name", "Manufacturer"}
   */
  public static boolean validateDisplayColumnFilters(WebDriver driver, String tableName,
      String[] colFilters) {
    boolean res = true;
    logger.info("Validate Column Filters");
    if (colFilters.length > 0) {
      for (int i = 0; i < colFilters.length; i++) {
        if (CommonUIFunctions.getColumnNumberForColumnHeader(driver, tableName, colFilters[i]) >= 0) {
          logger.info("Found column header: " + colFilters[i]);

        }
        else {
          logger.info(" Did not find column header: " + colFilters[i]);
          logger.error(" Did not find column header: " + colFilters[i]);
          res = false;
        }
      }
    }
    return res;
  }

  /*
   *This method modifies the display filter column.
   * Input - WebDriver, String[] of column filters
   * column filters - {"Number", "Name", "Manufacturer"}
   * Few of the locators
   */
  public static void addThisToColumnDisplay(WebDriver driver, String[] defaultCols,
      String[] colFilters, By bySettingsBtn, By byColHdrsList, By byAddToDisplayCol, By byOkBtn)
      throws Exception {
    try {
      logger.info("- updating CompanyDisplayColumns in company page");

      if (Arrays.equals(colFilters, defaultCols)) {
        logger.info("Both requested columns is same as default columns");
        logger.info("No need to modify the header");
        return;
      }
      else {
        logger.info("Requested columns is different from default columns");
      }
      /*
      String tt = driver.getTitle();
      logger.info("Title = "+tt);
      if (!driver.getTitle().contains("Personalize List Columns")) {
          logger.info("Click Settings again");
          driver.findElement(bySettingsBtn).click();
      }

       */
      SeleniumWait.hold(longSleep); // added this as it is failing in bulk run
      SeleniumWait.hold(longSleep); // added this as it is failing in bulk run
      if (colFilters.length > 0) {
        Select se = new Select(driver.findElement(byColHdrsList));
        SeleniumWait.hold(mediumSleep); // Added this one too
        JavascriptExecutor je = ((JavascriptExecutor) driver);
        for (int j = 0; j < colFilters.length; j++) {
          logger.debug("Column name to search -- " + colFilters[j]);
          try {
            se.deselectAll();
            se.selectByVisibleText(colFilters[j]);
            logger.info("Found Column Element -- " + colFilters[j]);
            if (!driver.findElement(byAddToDisplayCol).isDisplayed()) {
              je.executeScript("arguments[0].scrollIntoView(true);", byAddToDisplayCol);
            }
            if (!driver.findElement(byAddToDisplayCol).isDisplayed())
              SeleniumWait.hold(longSleep);
            driver.findElement(byAddToDisplayCol).click();
            if (!driver.findElement(byColHdrsList).isDisplayed())
              logger.debug("Column Header List is not displayed, will wait");
            else
              SeleniumWait.hold(mediumSleep);
            driver.findElement(byColHdrsList).click();
            SeleniumWait.hold(ShortSleep);


          } catch (Exception e) {
            logger.info("Exception, element not found in Left List -  " + colFilters[j]);
            continue;
          }
        }
        SeleniumWait.hold(mediumSleep); // Added this one too

        driver.findElement(byOkBtn).click();
        SeleniumWait.hold(mediumSleep); // Added this one too
      }
    } catch (Exception e) {
      logger.error("Not able to updateCompanyDisplayColumnFilters" + e.toString());
      Assert.fail("Not able to updateCompanyDisplayColumnFilters" + e.toString());
    }
  }

  /*
  This method helps in identifying the frame that has the element
  Arguments - driver, element to be found

   */
  public static int getFrameIdForThisElement(WebDriver driver, By element) {
    int numofframes = driver.findElements(By.tagName("iframe")).size();
    int frameID = -1;
    logger.debug("Number of frames = " + numofframes);
    for (int i = 0; i < numofframes; i++) {
      driver.switchTo().frame(i);
      int size = driver.findElements(element).size();
      logger.debug("size = " + size + " i= " + i);
      if (size > 0)
        frameID = i;
      driver.switchTo().defaultContent();
    }
    return frameID;
  }

  public static boolean switchToFrameWithThisElement(WebDriver driver, By element) {
    boolean res = true;

    int numofframes = driver.findElements(By.tagName("iframe")).size();
    int frameID = -1;
    logger.debug("Number of frames = " + numofframes);
    for (int i = 0; i < numofframes; i++) {
      driver.switchTo().frame(i);
      int size = driver.findElements(element).size();
      logger.debug("size = " + size + " i= " + i);
      if (size > 0)
        frameID = i;
      driver.switchTo().defaultContent();
    }
    if (frameID >= 0) {
      logger.info("Valid Frame found, switching to it");
      driver.switchTo().frame(frameID);
    }
    else {
      logger.error("No Valid Frame found with the element+ " + element);
      res = false;
    }
    return res;
  }
}
