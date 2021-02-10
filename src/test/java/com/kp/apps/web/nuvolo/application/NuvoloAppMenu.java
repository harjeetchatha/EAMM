package com.kp.apps.web.nuvolo.application;

import static com.kp.apps.web.library.GlobalVariables.ShortSleep;
import static com.kp.apps.web.library.GlobalVariables.longSleep;
import static com.kp.apps.web.library.GlobalVariables.mediumSleep;
import static com.kp.apps.web.library.GlobalVariables.xlongSleep;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.kp.apps.web.library.Functions;
import com.kp.apps.web.library.GlobalVariables;
import com.kp.apps.web.library.SeleniumWait;

public class NuvoloAppMenu {
  Functions               functions                                       = new Functions();

  private Logger          logger                                          =
      Logger.getLogger(NuvoloAppMenu.class);

  @FindBy(xpath = "//h1[@class='loading-message']")
  private WebElement      byLoadingMessage;

  private By              byClinicalAssetManagementAdmin                  =

      By.xpath("//span[contains(text(),'Clinical Asset Management Admin')]");
  private By              byClinicalAssetManagement                       =
      By.xpath("//span[text()='Clinical Asset Management']");
  private By              byCam_Inventorylnk                              =
      By.xpath("//a[span='Clinical Asset Management']/..//span[text()='Inventory']");

  private By              byCAMA_ExternalCompanies                        = By.xpath(
      "//span[text()='Clinical Asset Management']/ancestor::li/descendant::li/descendant::div[text()=''External Companies'']");
  private By              byCAMA_ExternalCompanies_NewCompany             = By.xpath(
      "//a[span='Clinical Asset Management Admin']/..//div[@class='sn-widget-list-title'][contains(text(),'New Company')]");

  private By              byCAMA_ExternalCompanies_AllCompany             = By.xpath(
      "//span[text()='Clinical Asset Management']/ancestor::li/descendant::li/descendant::div[text()='All']");
  private By              byCAMA_ExternalCompanies_Manufacturers          =
      By.xpath("//li/descendant::a/descendant::div[text()='Manufacturers ']");


  // "//a[span='Clinical Asset Management
  // Admin']/..//div[@class='sn-widget-list-title'][contains(text(),'Manufacturers')]");

  //
  private By              byCAMA_ExternalCompanies_Vendors                = By.xpath(
      "//span[text()='External Companies']/ancestor::li/div/ul/li/descendant::div[text()='Vendors']");

  private By              byCAM_InventoryVendors                          = By.xpath(
      "//a[span='Clinical Asset Management']/..//div[@class='sn-widget-list-title'][text()='Vendors']");

  private By              byCAMA_ExternalCompanies_ServiceProviders       = By.xpath(
      " //span[text()='Clinical Asset Management']/ancestor::li/descendant::div[text()='Service Providers']");

  /* private By     byNewCompanySubmitBtn          = By.xpath("//button[@id='sysverb_insert']");*/

  private By              byNewRecord                                     =
      By.xpath("//div[text()='New record']");
  private By              byCompanyText                                   =
      By.xpath("//h1/descendant::*[text()='Company']");

  private static final By vendorCompany                                   =
      By.xpath("//*[contains(@class,'form_header navbar-title')]/span");
  private static final By vendorNewRecord                                 =
      By.xpath("//*[contains(@class,'form_header navbar-title')]/span/div");

  private static final By vendorsNewButton                                =
      By.xpath("//button[@id='sysverb_new']");

//button[@id='sysverb_new']

  private By              byCAMInventory_Vendorsfilter                    =

      By.xpath("//a[@filter='vendor=true']");
  private By              byNewStockroomsPageTitle                        =
      By.xpath("//h1/span[contains(text(),'Stockrooms')]");

  private By              byClinicalModelsPageTitle                       =
      By.xpath("//h1/*[contains(text(),'Clinical Models')]");

  private By              byCAMA_ExternalCompanies_AllCompaniesFilter     =
      By.xpath("//b[contains(text(),'All')]");
  private By              byCAMA_ExternalCompanies_ManufacturersFilter    =
      By.xpath("//b[contains(text(),'Manufacturer = true')]");
  private By              byCAMA_ExternalCompanies_VendorsFilter          =
      By.xpath("//b[contains(text(),'Vendor = true')]");
  private By              byCAMA_ExternalCompanies_ServiceProvidersFilter =
      By.xpath("//b[contains(text(),'Service Provider = true')]");
  private By              byNavPageFilter                                 =
      By.xpath("//input[contains(@id,'filter')]");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  // This

  private By              byUserInfoButton                                =
      By.xpath("//button[@id='user_info_dropdown']");
  private By              byUserProfileInfo                               =
      By.xpath("//*[@id=\"user_info_dropdown\"]/div/span[1]");
  private By              byUserProfile                                   =
      By.xpath("//a[contains(text(),'Profile')]");
  private By              byUserImpersonateUser                           =
      By.xpath("//a[contains(text(),'Impersonate User')]");
  private By              byUserLogout                                    =
      By.xpath("//a[contains(text(),'Logout')]");
  private By              byUserEndImpersonation                          =
      By.xpath("//a[contains(text(),'End Impersonation')]");
  private By              byUserInfoDropDownBtn                           =
      By.xpath("//button[@id='user_info_dropdown']//span[contains(@class,'caret')]");
  private By              byImpersonateUserSearch                         =
      By.xpath("//div[@id='select2-drop-mask']");
  private By              byImpersonateUserSelect                         =
      By.xpath("//input[@id='s2id_autogen2_search']");
  private By              byImpersonateUserModalTitle                     =
      By.xpath("//h4[@id='impersonate_title']");
  private By              bySearchForUser                                 =
      By.xpath("//span[@id='select2-chosen-2']");
  private By              byCloseImpUserModalButton                       =
      By.xpath("//div[contains(@class,'modal-dialog modal-sm impersonate-dialog ng-scope')]"
          + "//button[contains(@class,'btn-icon close icon-cross')]");
  private By              byServiceNowPageFrame                           =
      By.xpath("//iframe[contains(@title,'ServiceNow')]");

  private By              clinicalAssetManagementLink                     =
      By.xpath("//a[span='Clinical Asset Management']");


  private By              clinicalAssetInventoryLink                      =
      By.xpath("//a[span='Clinical Asset Management']/..//a/span[.='Inventory']/..");


  private By              byClinicalInvVendors                            = By.xpath(
      "//a[span='Clinical Asset Management']/..//div[@class='sn-widget-list-title'][contains(text(),'Vendors')]");
  private By              byClinicalInventory                             =
      By.xpath("//span[contains(text(),'Inventory')]");

  private By              byClinicalInvNewAsset                           =
      By.xpath("//span[contains(text(),'New Asset')]");
  private By              byClinicalInvAssets                             =
      By.xpath("//span[contains(text(),'Assets')]");
  private By              byClinicalInvAssetTypes                         =
      By.xpath("//span[contains(text(),'Asset Types')]");
  private By              byClincalInvParts                               =
      By.xpath("//span[contains(text(),'Parts')]");
  private By              byClincalInvPartTypes                           =
      By.xpath("//span[contains(text(),'Part Types')]");
  private By              byClincalInvModels                              =
      By.xpath("//span[contains(text(),'Models')]");
  private By              byClincalInvStckrms                             =
      By.xpath("//span[contains(text(),'Stockrooms')]");
  private By              byClincalInvStckrmTrans                         =
      By.xpath("//span[contains(text(),'Stockroom Transactions')]");
  private By              byMenuInputFilter                               =
      By.xpath("//input[@id='filter']");
  private By              byCAM_InventoryPartTypes                        = By.xpath(
      "//a[span='Clinical Asset Management']/..//div[@class='sn-widget-list-title'][text()='Part Types']");

  private By              byNewButton                                     =
      By.xpath("//button[@id='sysverb_new']");
  private By              byClinicalPartTypeText                          =
      By.xpath("//span[contains(text(),'Clinical Part Type')]");

  private By              byCAM_InventoryStockRoom                        = By.xpath(
      "//a[span='Clinical Asset Management']/..//div[@class='sn-widget-list-title'][text()='Stockrooms']");

  private By              byCAM_InventoryStockRoomTransaction             = By.xpath(
      "//a[span='Clinical Asset Management']/..//div[@class='sn-widget-list-title'][text()='Stockroom Transactions']");

  private By              byCAM_InventoryStockRoomTitle                   =
      By.xpath("//*[@id='list_nav_x_nuvo_eam_stockrooms']/div/div[1]/a/h2");

  private By              byCAM_InventoryModelTitle                       =
      By.xpath("//a[@class='list_action list_top_title']");

  private By              byCAM_InventoryStockRoomTransactionTitle        =
      By.xpath("//h2[contains(@class,'navbar-title list_title')]");

  private By              byCAM_InventoryParts                            = By.xpath(
      "//a[span='Clinical Asset Management']/..//div[@class='sn-widget-list-title'][text()='Parts']");

  private By              byClinicalPartsText                             =
      By.xpath("//span[contains(text(),'Clinical Parts')]");

  private By              clinicalAssetManagementAdminLink                =
      By.xpath("//a[span='Clinical Asset Management Admin']");

  private By              clinicalAssetAdminScheduledMaintenanceLink      = By.xpath(
      "//a[span='Clinical Asset Management Admin']/..//a/span[.='Scheduled Maintenance']/..");

  private By              scheduledMaintenanceNavLink                     =
      By.xpath("//a[span='Clinical Asset Management Admin']/..//a/span[.='Scheduled Maintenance']");

  private By              filterTextbox                                   = By.id("filter");



  private By              byFAMAA_ExternalCompanies_Manufacturers         = By.xpath(
      "//span[text()='Facilities Asset Management Admin']/ancestor::li/descendant::div[text()='Manufacturers']");


  private By              byFAMA_ExternalCompanies_Vendors                = By.xpath(
      "//span[text()='Facilities Asset Management Admin']/ancestor::li/descendant::div[text()='Vendors']");

  private By              byFAMA_ExternalCompanies_ServiceProviders       = By.xpath(
      "//span[text()='Facilities Asset Management Admin']/ancestor::li/descendant::div[text()='Service Providers']");



  private By              byFAMA_ExternalCompanies_AllCompany             = By.xpath(
      "//span[text()='Facilities Asset Management Admin']/ancestor::li/descendant::span[text()='External Companies']/../../descendant::li/descendant::div[text()='All']");


  private By              byFAMA_ExternalCompanies_NewCompany             = By.xpath(
      "//a[span='Facilities Asset Management Admin']/..//div[@class='sn-widget-list-title'][contains(text(),'New Company')]");

  private By              byFAMA_ExternalCompanies_AllCompaniesFilter     =
      By.xpath("//b[contains(text(),'All')]");
  private By              byFAMA_ExternalCompanies_ManufacturersFilter    =
      By.xpath("//b[contains(text(),'Manufacturer = true')]");
  private By              byFAMA_ExternalCompanies_VendorsFilter          =
      By.xpath("//b[contains(text(),'Vendor = true')]");
  private By              byFAMA_ExternalCompanies_ServiceProvidersFilter =
      By.xpath("//b[contains(text(),'Service Provider = true')]");

  private By              byFAMA_InventoryVendors                         = By.xpath(
      "//a[span='Facilities Asset Management Admin']/..//div[@class='sn-widget-list-title'][text()='Vendors']");

  private By              byFAMAInventory_Vendorsfilter                   =
      By.xpath("//a[@filter='vendor=true']");


  private By              facilitiesAssetManagementLink                   =
      By.xpath("//a[span='Facilities Asset Management']");


  private By              facilitiesAssetInventoryLink                    =
      By.xpath("//a[span='Facilities Asset Management']/..//a/span[.='Inventory']/..");


  public By getInventoryLinksByName(String linkName) {

    return By.xpath(
        "//a[span='Clinical Asset Management']/..//div[@class='sn-widget-list-title'][contains(text(),'"
            + linkName + "')]");
  }


  public By getFAMInventoryLinksByName(String linkName) {

    return By.xpath(
        "//a[span='Facilities Asset Management']/..//div[@class='sn-widget-list-title'][contains(text(),'"
            + linkName + "')]");
  }

  public By getAdminScheduledLinksByName(String linkName) {

    return By.xpath(
        "//a[span='Clinical Asset Management Admin']/..//div[@class='sn-widget-list-title'][contains(text(),'"
            + linkName + "')]");
  }

  private By bylinkAllVendors                       = By.xpath("//a[@filter='vendor=true']");
  private By byAllCompaniesFilter                   = By.xpath("//b[contains(text(),'All')]");
  private By byManufacturersFilter                  =
      By.xpath("//b[contains(text(),'Manufacturer = true')]");
  private By byVendorsFilter                        =
      By.xpath("//b[contains(text(),'Vendor = true')]");
  private By byServiceProvidersFilter               =
      By.xpath("//b[contains(text(),'Service Provider = true')]");

  private By bySearchFilter                         = By.xpath("//input[@id='filter']");

  // Facilities Asset Management

  private By facilityAssetManagementLink            =
      By.xpath("//a[.='Facilities Asset Management']");

  private By facilityAssetManagementLink_WorkOrders =
      By.xpath("//a[span='Facilities Asset Management']/..//a/span[.='Work Orders']/..");
////a[span='Facilities Asset Management']/..//a/span[.='Work Orders']/..

  public By getWorkOrderLinksByName(String linkName) {

    return By.xpath(
        "//a[span='Facilities Asset Management']/..//ul[contains(@aria-label,'Work Orders')]//a[.='"
            + linkName + "']");
  }

  private By byPartTypeNewButton                    =
      By.xpath("//h2[.='Clinical Part Types']/../..//button[.='New']");


  private By byPartTypeName                         =
      By.xpath("//input[@id='x_nuvo_eam_clinical_part_type.name']");

  // Clinical work Order--------:
  private By clinicalAssetManagementLink_WorkOrders =
      By.xpath("//a[span='Clinical Asset Management']/..//a/span[.='Work Orders']/..");


  public By geClinicalWorkOrderLinksByName(String linkName) {

    return By.xpath(
        "//a[span='Clinical Asset Management']/..//ul[contains(@aria-label,'Work Orders')]//a[.='"
            + linkName + "']");
  }
  // -------End Clinical WO-----------

  public By getByServiceNowPageFrame() {
    return byServiceNowPageFrame;
  }

  // This method displays the name that is on the profile
  public String get_displayProfileName(WebDriver driver) {

    String displayProfileName = null;
    logger.info("get_displayProfileName");
    SeleniumWait.hold(longSleep);
    Assert.assertTrue(driver.findElement(byUserProfileInfo).isDisplayed(),
        "Profile is not displayed");
    displayProfileName = driver.findElement(byUserProfileInfo).getText();

    logger.info("Found the profile name");
    logger.info(displayProfileName);
    return displayProfileName;
  }

  // This method verifies if the impersonation can be done
  // Then impersonifies and verifies that the impersonation worked
  // Then compares the impersonified name is same as what was requested
  public void set_impersonateUser(WebDriver driver, String impersonateUser) throws Exception {
    try {
      String profileUserName = null;
      logger.debug("Impersonating user to : " + impersonateUser);
      driver.switchTo().defaultContent();
      Actions act = new Actions(driver);
      // Check if the User Profile is displayed
      SeleniumWait.hold(ShortSleep);
      Assert.assertTrue(driver.findElement(byUserProfileInfo).isDisplayed(),
          "Profile is not displayed");
      profileUserName = driver.findElement(byUserProfileInfo).getText();

      if (profileUserName.equalsIgnoreCase(impersonateUser)) {
        logger.info("Profile User :'" + profileUserName + "' and impersonate user '"
            + impersonateUser + "' are same");
      }
      else {
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        // Find the drop down button & click
        driver.findElement(byUserInfoDropDownBtn).click();
        // Find the Impersonate User and click on text
        Assert.assertTrue(driver.findElement(byUserImpersonateUser).isDisplayed(),
            "Impersonation is not allowed for logged in user");
        driver.findElement(byUserImpersonateUser).click();
        SeleniumWait.hold(ShortSleep);
        // This opens the Impersonate User modal, enter the user name provided and make sure the
        // impersonation is successful
        Assert.assertTrue(driver.findElement(byImpersonateUserModalTitle).isDisplayed(),
            "To Impersonate, user modal is not dsipalyed as expected");
        driver.findElement(byImpersonateUserModalTitle).click();
        Assert.assertTrue(driver.findElement(bySearchForUser).isDisplayed(),
            "SearchForUser pop up is not dispalyed");
        // driver.findElement(bySearchForUser).isDisplayed();
        driver.findElement(bySearchForUser).click();

        // Now send the user name keys
        // driver.findElement(byImpersonateUserSearch).isDisplayed();
        driver.findElement(byImpersonateUserSelect).sendKeys(impersonateUser);
        SeleniumWait.hold(ShortSleep);

        WebElement element = driver.findElement(byImpersonateUserSelect);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).sendKeys(Keys.ENTER).build().perform();

        // act.sendKeys(Keys.ENTER).build().perform();
        SeleniumWait.hold(xlongSleep);
        profileUserName = driver.findElement(byUserProfileInfo).getText();
        logger.debug(profileUserName);
        Assert.assertEquals(profileUserName, impersonateUser);
        logger.info("Successfully Impersonated with User :" + impersonateUser);
        logger.info("Waiting for page to laod");
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
      }
      // driver.navigate().refresh();
      Thread.sleep(ShortSleep);
    } catch (Exception e) {
      logger.error("Not able to Impersonate User" + e.toString());

    }
  }

  // End Impersonation
  public void endImpersonation(WebDriver driver) throws Exception {
    try {
      logger.info("Ending Impersonation");
      driver.switchTo().defaultContent();
      SeleniumWait.hold(ShortSleep);
      String sLoggedInUser =
          driver.findElement(By.xpath("//button[@id='user_info_dropdown']/div/span")).getText();

      if (!GlobalVariables.systemUserName.equalsIgnoreCase(sLoggedInUser)) {
        driver.findElement(byUserInfoDropDownBtn).click();
        driver.findElement(byUserEndImpersonation).click();
        SeleniumWait.hold(mediumSleep);
        logger.debug("Impersonation Ended");
      }

      else
        logger.debug("User is not impersonated to end impersonation");

       } catch (Exception e) {
      logger.error("Not able to End Impersonation" + e.toString());
      Assert.fail("Not able to End Impersonation");
    }
  }

 
// check this method to change the name of the link menu for inventory
  public void goto_menufiltersearch(WebDriver driver, String sMenuItem) throws Exception {
    try {
      logger.info("Finding '" + sMenuItem + "' menu item in left menu by search filter");

      if (driver.findElements(byNavPageFilter).size() > 0) {
        driver.findElement(byNavPageFilter).click();
        driver.findElement(byNavPageFilter).clear();
        driver.findElement(byNavPageFilter).sendKeys(sMenuItem);
      }
      else {
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        driver.findElement(byNavPageFilter).click();
        driver.findElement(byNavPageFilter).sendKeys(sMenuItem);
      }
      driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
      Thread.sleep(GlobalVariables.mediumSleep);
      logger.info("goto_menufiltersearch -- completed");
    } catch (Exception e) {
      logger.error("unable to access filter search field" + e.toString());
      Assert.fail("unable to access filter search field");
    }
  }

  public static String getTextNode(WebElement e) {
    String text = e.getText().trim();
    List<WebElement> children = e.findElements(By.xpath("./*"));
    for (WebElement child : children) {
      text = text.replaceFirst(child.getText(), "").trim();
    }
    return text;
  }

  public void goto_CAM_Inventory_Vendor(WebDriver driver, boolean bCreateNew) throws Exception {
    try {
      logger.info("Go to CAM Vendors Page");
      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      goto_menufiltersearch(driver, "Vendors");
      Actions act = new Actions(driver);
      act.moveToElement(driver.findElement(byCAM_InventoryVendors)).build().perform();
      functions.clickAt(driver, byCAM_InventoryVendors, "Clicked on Vendor filter page");

      // driver.findElement(byCAM_InventoryVendors).click();
      // logger.info("Clicked on Vendor filter page");
      int i = 0;
      while (driver.findElements(getByServiceNowPageFrame()).size() == 0) {
        logger.info("waiting for page to load :" + i);
      }
      while (!driver.findElement(getByServiceNowPageFrame()).isDisplayed() && i < 2);

      functions.waitForWebElementInvisibility(driver, byLoadingMessage);

      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));
      // Now check if we are on the companies page with vendor=true filter
      Assert.assertTrue((driver.findElement(byCAMInventory_Vendorsfilter).isDisplayed()),
          "Vendors Page is not displayed");
      if (bCreateNew) {
        // TODO remove hardcoded xpaths
        Thread.sleep(GlobalVariables.mediumSleep);
        // driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
        functions.clickAt(driver, vendorsNewButton, "clicked the new button ");
        Thread.sleep(GlobalVariables.longSleep);

        Assert.assertEquals(getTextNode(driver.findElement(vendorCompany)), "Company",
            "Failed to verify vendor page");
        functions.highlighElement(driver, vendorCompany);
        logger.info("Vendor Page  verified Actual: [ "
            + driver.findElement(vendorCompany).getText().trim() + " ] Expected : [ Company ]");

        Assert.assertEquals(driver.findElement(vendorNewRecord).getText().trim(), "New record",
            "Failed to verify vendor page");
        functions.highlighElement(driver, vendorNewRecord);
        logger.info(
            "Vendor Page verified Actual: [ " + driver.findElement(vendorNewRecord).getText().trim()
                + " ] Expected : [ New record ]");


      }
    } catch (AssertionError e) {
      e.printStackTrace();
      logger.error("goto_filterCAM_Inventory_Vendor --failed with error" + e.toString());

    } catch (Exception e) {
      e.printStackTrace();
      logger.error("goto_filterCAM_Inventory_Vendor --failed with error" + e.toString());

    }
  }

  public void goto_CAMA_ExternalCompany_NewCompany(WebDriver driver) throws Exception {
    try {
      logger.info("Navigating to CAMA_ExternalCompany_NewCompany Page");

      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      // driver.navigate().refresh();
      goto_menufiltersearch(driver, "New Company");
      Actions act = new Actions(driver);
      act.moveToElement(driver.findElement(byCAMA_ExternalCompanies_NewCompany)).build().perform();
      driver.findElement(byCAMA_ExternalCompanies_NewCompany).click();
      int i = 0;


      while (driver.findElements(getByServiceNowPageFrame()).size() == 0) {
        logger.info("waiting for frame to load :");
      }
      SeleniumWait.hold(GlobalVariables.ShortSleep);
      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));

    } catch (Exception e) {
      e.printStackTrace();
      logger.error("Not able to goto_CAMA_ExternalCompany_NewCompany" + e.toString());
    }
  }

  public void goto_CAMA_ExternalCompany_AllCompany(WebDriver driver) throws Exception {
    try {
      logger.info("goto_CAMA_ExternalCompany_AllCompany page");

      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      goto_menufiltersearch(driver, "com");
      Actions act = new Actions(driver);

      functions.waitForElementPrescence(driver, byCAMA_ExternalCompanies_AllCompany);
      driver.findElement(byCAMA_ExternalCompanies_AllCompany).click();

      int i = 0;
      do {
        SeleniumWait.hold(GlobalVariables.longSleep);
        i++;
        logger.info("waiting for page to load :" + i);
      } while (!driver.findElement(getByServiceNowPageFrame()).isDisplayed() && i < 2);
      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));
      Assert.assertTrue(
          (driver.findElement(byCAMA_ExternalCompanies_AllCompaniesFilter).isDisplayed()),
          "All company filter page is not displayed");
      logger.info("AllCompanies page displayed with all companies filter");
    } catch (Exception e) {
      logger.error("Not able to goto_CAMA_ExternalCompany_AllCompany" + e.toString());
      Assert.fail("Not able to goto_CAMA_ExternalCompany_AllCompany");
    }
  }

  private boolean goto_clinicalAssetManagementAdminMenu(WebDriver driver) {
    boolean found = false;

    if (driver.findElement(byClinicalAssetManagementAdmin).isDisplayed()) {
      driver.findElement(byClinicalAssetManagementAdmin).click();
      // Now check if the menu options below New Companies is displayed
      if (driver.findElement(byCAMA_ExternalCompanies_NewCompany).isDisplayed()) {
        // CLinical New Company is displayed so we are on the Clinical External Companies Menu
        logger.info("Clinical Asset Management Admin is displayed");
        found = true;
      }
      else {
        logger.info("Clinical Asset Management Admin is not displayed");
        found = false;
      }
    }
    else {
      logger.info("Clinical Asset Management Admin is not displayed.. Might be a pop up window");
      found = false;
    }
    return found;
  }

  public void goto_CAMA_ExternalCompany_ManufacturersCompany(WebDriver driver) {
    try {
      logger.info("goto_CAMA_ExternalCompany_ManufacturersCompany page");

      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      goto_menufiltersearch(driver, "Manufacturers");
         driver.findElement(byCAMA_ExternalCompanies_Manufacturers).click();

      int i = 0;
         do {
        SeleniumWait.hold(GlobalVariables.longSleep);
        i++;
        logger.info("waiting for page to load :" + i);
      } while (!driver.findElement(getByServiceNowPageFrame()).isDisplayed() && i < 2);
      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));

      Assert.assertTrue(
          (driver.findElement(byCAMA_ExternalCompanies_ManufacturersFilter).isDisplayed()),
          "Manufacturer company filter page is not displayed");
      logger.info("page displayed with companies having Manufacturer relationship");
    } catch (Exception e) {
      logger.error("Not able to goto_filterClinicalManufacturersCompany" + e.toString());
      Assert.fail("Not able to goto_filterClinicalManufacturersCompany");

    }
  }

  public void goto_CAMA_ExternalCompany_VendorsCompany(WebDriver driver) throws Exception {
    try {
      logger.info("goto_CAMA_ExternalCompany_VendorsCompany page");
      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      goto_menufiltersearch(driver, "Vendors");
      driver.findElement(byCAMA_ExternalCompanies_Vendors).click();

      int i = 0;
      do {
        SeleniumWait.hold(GlobalVariables.longSleep);
        i++;
        logger.info("waiting for page to load :" + i);
      } while (!driver.findElement(getByServiceNowPageFrame()).isDisplayed() && i < 2);
      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));
      // Now check if we are on the Vendors company page
      Assert.assertTrue((driver.findElement(byCAMA_ExternalCompanies_VendorsFilter).isDisplayed()),
          "Vendors company filter page is not displayed");
      logger.info("page displayed with companies having Vendor relationship");
    } catch (Exception e) {
      logger.error("Not able to goto_CAMA_ExternalCompany_VendorsCompany" + e.toString());
      Assert.fail("Not able to goto_CAMA_ExternalCompany_VendorsCompany");
    }
  }

  public void goto_CAMA_ExternalCompany_ServiceProvidersCompany(WebDriver driver) {
    try {
      logger.info("goto_CAMA_ExternalCompany_ServiceProvidersCompany page");

      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      // driver.navigate().refresh();
      goto_menufiltersearch(driver, "Service Providers");
      Actions act = new Actions(driver);
      act.moveToElement(driver.findElement(byCAMA_ExternalCompanies_ServiceProviders)).build()
          .perform();

      driver.findElement(byCAMA_ExternalCompanies_ServiceProviders).click();
      int i = 0;
         do {
        SeleniumWait.hold(GlobalVariables.longSleep);
        i++;
        logger.info("waiting for page to load :" + i);
      } while (!driver.findElement(getByServiceNowPageFrame()).isDisplayed() && i < 2);
      SeleniumWait.hold(GlobalVariables.ShortSleep);
      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));

      // Now check if we are on theService Providers company filter page
      Assert.assertTrue(
          (driver.findElement(byCAMA_ExternalCompanies_ServiceProvidersFilter).isDisplayed()),
          "Service Providers company filter page is not displayed");
      logger.info("page displayed with companies having Service Provider relationship");
    } catch (Exception e) {
      logger.error("Not able to goto_filterClinicalServiceProvidersCompany" + e.toString());
      Assert.fail("Not able to goto_filterClinicalServiceProvidersCompany");

    }
  }

  public void goto_filterClinicalInventory(WebDriver driver) {
    try {
      if (driver.findElement(clinicalAssetManagementLink).isDisplayed()) {
        driver.findElement(clinicalAssetManagementLink).click();
        if (driver.findElement(clinicalAssetInventoryLink).isDisplayed()
            && driver.findElement(clinicalAssetInventoryLink).getAttribute("area-expanded")
                .equalsIgnoreCase("true")) {
          logger.info("ClinicalAssetInventoryLink is already expanded");
        }
        else {
          driver.findElement(clinicalAssetManagementLink).click();
        }
      }
    } catch (Exception e) {
      logger.error("Not able to goto_filterClinicalInventory" + e.toString());
      Assert.fail("Not able to goto_filterClinicalInventory");

    }
  }


  public void goto_CAM_IventoryLinks(WebDriver driver, String linkName) {
    try {
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      if (driver.findElement(clinicalAssetManagementLink).isDisplayed()
          && driver.findElement(clinicalAssetManagementLink).getAttribute("aria-expanded")
              .equalsIgnoreCase("false")) {
        functions.clickAt(driver, clinicalAssetManagementLink);
        logger.info("clinicalAssetManagementLink is clicked");

        SeleniumWait.hold(GlobalVariables.mediumSleep);
        if (driver.findElement(clinicalAssetInventoryLink).isDisplayed()
            && driver.findElement(clinicalAssetInventoryLink).getAttribute("aria-expanded")
                .equalsIgnoreCase("false")) {
          functions.click(driver, clinicalAssetInventoryLink,
              "Clicked on clinicalAssetInventoryLink");
          SeleniumWait.hold(GlobalVariables.mediumSleep);

        }
        else {
          logger.info("ClinicalAssetInventoryLink is already expanded");
        }

      }
      else {
        SeleniumWait.hold(GlobalVariables.mediumSleep);
        if (driver.findElement(clinicalAssetInventoryLink).isDisplayed()
            && driver.findElement(clinicalAssetInventoryLink).getAttribute("aria-expanded")
                .equalsIgnoreCase("false")) {
          functions.click(driver, clinicalAssetInventoryLink,
              "Clicked on clinicalAssetInventoryLink");
          SeleniumWait.hold(GlobalVariables.mediumSleep);

        }
        else {
          logger.info("ClinicalAssetInventoryLink is already expanded");
        }
      }
      if (driver.findElement(getInventoryLinksByName(linkName)).isDisplayed()) {
        functions.click(driver, getInventoryLinksByName(linkName),
            "Clicked on Inventory Link" + getInventoryLinksByName(linkName));
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("Not able to goto_filterClinicalInventory" + e.toString());


    }
  }

  public void goto_CAM_Inventory_PartTypes(WebDriver driver, boolean bCreateNew) throws Exception {
    try {
      logger.info("Go to CAM Part Types Page");
      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      // driver.navigate().refresh();
      goto_menufiltersearch(driver, "Part Types");
      SeleniumWait.hold(ShortSleep);
      Actions act = new Actions(driver);
      act.moveToElement(driver.findElement(byCAM_InventoryPartTypes)).build().perform();

      driver.findElement(byCAM_InventoryPartTypes).click();
      logger.info("Clicked on Part Types filter page");

      while (driver.findElements(getByServiceNowPageFrame()).size() == 0) {
        logger.info("waiting for frame to load :");
      }

      SeleniumWait.hold(GlobalVariables.ShortSleep);
      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));
      logger.info("switched to frame");


      if (bCreateNew) {
        int i = 0;
        int j = 0;
        boolean displayed = false;
        while (i < 10) {
          Thread.sleep(i * 500);
          if (driver.findElements(byPartTypeNewButton).size() > 0) {
            displayed = true;
            logger.info("New button is visible after " + i + " try");
            break;
          }
          i++;
        }
        while (j < 10) {
          Thread.sleep(j * 500);
          if (driver.findElement(byPartTypeNewButton).isEnabled()) {
            logger.info("New button is enabled after " + j + " try");
            try {
              driver.findElement(byPartTypeNewButton).click();
            } catch (ElementClickInterceptedException e) {
              logger.info(" ElementClickInterceptedException Identified");
              Thread.sleep(2000);
              driver.findElement(byPartTypeNewButton).click();
              logger.info(" ElementClickInterceptedException resolved");
            }
            break;
          }
          j++;
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        if (driver.findElements(byPartTypeName).size() == 0) {
          functions.clickAt(driver, byPartTypeNewButton, "clicking partType new button");
          logger.info("Clicked again");
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        Assert.assertTrue(
            (driver.findElement(byClinicalPartTypeText).isDisplayed()
                && driver.findElement(byNewRecord).isDisplayed()),
            "New Part Types Page is not displayed");
      }
    } catch (Exception e) {
      logger.error(driver.getCurrentUrl());
      logger.error("goto_CAM_Inventory_PartTypes --failed with error" + e.toString());

    }
  }


  public void goto_CAM_Inventory_StockRoom(WebDriver driver, boolean bCreateNew) throws Exception {
    try {
      logger.info("Go to CAM StockRoom Page");
      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      // driver.navigate().refresh();
      goto_menufiltersearch(driver, "Stockroom");
      Actions act = new Actions(driver);
      act.moveToElement(driver.findElement(byCAM_InventoryStockRoom)).build().perform();
      functions.waitElementToLoad(driver, byCAM_InventoryStockRoom, 5);
      functions.click(driver, byCAM_InventoryStockRoom, "clicked on stockRoom filter page");
      int i = 0;
      while (driver.findElements(getByServiceNowPageFrame()).size() == 0) {
        logger.info("waiting for page to load :" + i);
        i++;
      }

      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));
      // stepped failed- check
      Assert.assertTrue((driver.findElement(byCAM_InventoryStockRoomTitle).isDisplayed()),
          "StockRoom Page is not displayed");
      if (bCreateNew) {
        functions.waitElementToLoad(driver, byNewButton, 40);
        Thread.sleep(GlobalVariables.mediumSleep);
        functions.click(driver, byNewButton, "clicked on the new button");
        Thread.sleep(GlobalVariables.mediumSleep);
        Assert.assertTrue(
            (driver.findElement(byNewStockroomsPageTitle).isDisplayed()
                && driver.findElement(byNewRecord).isDisplayed()),
            "New StockRoom Page is not displayed");
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("goto_CAM_Inventory_StockRoom --failed with error" + e.toString());

    }
  }

  public void goto_CAM_Inventory_ModelsPage(WebDriver driver, boolean bCreateNew, String pageName)
      throws Exception {
    try {
      logger.info("Go to CAM StockRoom Page");
      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      // driver.navigate().refresh();
      goto_menufiltersearch(driver, pageName);
      Actions act = new Actions(driver);
      act.moveToElement(driver.findElement(getInventoryLinksByName(pageName))).build().perform();

      driver.findElement(getInventoryLinksByName(pageName)).click();
      logger.info("Clicked on Models link");
      int i = 0;
      while (driver.findElements(getByServiceNowPageFrame()).size() == 0) {
        logger.info("waiting for page to load :" + i);
        i++;
      }
      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));
      Assert.assertTrue((driver.findElement(byCAM_InventoryModelTitle).isDisplayed()),
          "Model page title is not displayed");

      if (bCreateNew) {
        functions.waitElementToLoad(driver, byNewButton, 10);
        functions.click(driver, byNewButton);
        // driver.findElement(byNewButton).click();

        Thread.sleep(GlobalVariables.longSleep);
        Assert.assertTrue(
            (driver.findElement(byClinicalModelsPageTitle).isDisplayed()
                && driver.findElement(byNewRecord).isDisplayed()),
            " New Clinical Model page is not displayed");
      }
    } catch (Exception e) {
      e.printStackTrace();

      logger.error("goto_CAM_Inventory_ModelsPage --failed with error" + e.toString());
    }
  }

  public void goto_CAM_Inventory_StockRoomTransactions(WebDriver driver, boolean bCreateNew)
      throws Exception {
    try {
      logger.info("Go to CAM StockRoom Transactions Page");
      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      goto_menufiltersearch(driver, "Stockroom Transactions");
      Actions act = new Actions(driver);
      act.moveToElement(driver.findElement(byCAM_InventoryStockRoomTransaction)).build().perform();

      driver.findElement(byCAM_InventoryStockRoomTransaction).click();
      logger.info("Clicked on StockRoom Transactions filter page");
      int i = 0;

      do {
        SeleniumWait.hold(GlobalVariables.longSleep);
        i++;
        logger.info("waiting for page to load :" + i);
      } while (!driver.findElement(getByServiceNowPageFrame()).isDisplayed() && i < 2);
      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));
      Assert.assertTrue(
          (driver.findElement(byCAM_InventoryStockRoomTransactionTitle).isDisplayed()),
          "StockRoom Transactions Page is not displayed");
      if (bCreateNew) {
        driver.findElement(byNewButton).click();
        Thread.sleep(GlobalVariables.longSleep);
        Assert.assertTrue(
            (driver.findElement(byNewStockroomsPageTitle).isDisplayed()
                && driver.findElement(byNewRecord).isDisplayed()),
            "New StockRoom Transactions Page is not displayed");
      }
    } catch (Exception e) {
      logger.error("goto_CAM_Inventory_StockRoomTransactions --failed with error" + e.toString());
    }
  }

  public void to_ValidateNewButton(WebDriver driver, boolean bPrivilegedUser, String sUser)
      throws Exception {
    try {
      if (bPrivilegedUser) {
        Thread.sleep(GlobalVariables.mediumSleep);
        Assert.assertTrue(driver.findElement(byNewButton).isDisplayed(),
            "New button is not displayed");
        driver.findElement(byNewButton).click();
        logger.info("The new button is displayed and clicked" + byNewButton);
        // driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
        Thread.sleep(GlobalVariables.longSleep);
        Assert.assertTrue(
            (driver.findElement(byNewStockroomsPageTitle).isDisplayed()
                && driver.findElement(byNewRecord).isDisplayed()),
            "New StockRoom Page is not displayed");
      }
      else {

        Assert.assertFalse(driver.findElements(byNewButton).size() > 0,
            "New button is displayed for not Privileged User :" + sUser);
      }
      logger.info("New button is not displayed for not Privileged user as expected");
    } catch (AssertionError e) {
      logger.info("New button is displayed for Privileged user [ " + sUser + " ] as expected");
    }
  }

  public long getEpocTimeStamp() throws ParseException {
    Date today = Calendar.getInstance().getTime();
    // Constructs a SimpleDateFormat using the given pattern
    SimpleDateFormat crunchifyFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss.SSS zzz");

    // format() formats a Date into a date/time string.
    String currentTime = crunchifyFormat.format(today);
    System.out.println("Current Time = " + currentTime);
    // parse() parses text from the beginning of the given string to produce a date.
    Date date = crunchifyFormat.parse(currentTime);
    long epochTime = date.getTime();
    System.out.println("Current Time in Epoch: " + epochTime);
    return epochTime;
  }

  public void goto_CAM_Inventory_Parts(WebDriver driver, boolean bCreateNew) throws Exception {
    try {
      logger.info("Go to CAM Parts Page");
      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      // driver.navigate().refresh();
      goto_menufiltersearch(driver, "Parts");
      SeleniumWait.hold(ShortSleep);
      Actions act = new Actions(driver);
      act.moveToElement(driver.findElement(byCAM_InventoryParts)).build().perform();

      driver.findElement(byCAM_InventoryParts).click();
      logger.info("Clicked on Parts filter page");
      while (driver.findElements(getByServiceNowPageFrame()).size() == 0) {
        logger.info("waiting for frame to load :");
      }

      SeleniumWait.hold(GlobalVariables.ShortSleep);
      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));

      if (bCreateNew) {

        try {
          driver.findElement(byNewButton).click();
        } catch (StaleElementReferenceException e) {
          SeleniumWait.hold(GlobalVariables.mediumSleep);
          driver.findElement(byNewButton).click();
        } catch (ElementClickInterceptedException e) {
          SeleniumWait.hold(GlobalVariables.mediumSleep);
          driver.findElement(byNewButton).click();
        }
        Thread.sleep(GlobalVariables.longSleep);

        Assert.assertTrue(
            (driver.findElement(byClinicalPartsText).isDisplayed()
                && driver.findElement(byNewRecord).isDisplayed()),
            "New Parts Page is not displayed");
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(driver.getCurrentUrl());
      logger.error("goto_CAM_Inventory_Parts --failed with error" + e.toString());
    }
  }



  public void goto_CAMA_Models(WebDriver driver) {
    try {
      logger.info("goto_CAMA_Models page");

      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      goto_menufiltersearch(driver, "Clinical Asset Management Admin");
      int i = 0;
       } catch (Exception e) {
      logger.error("Not able to goto_filterModelCompany" + e.toString());

    }
  }

  /*
   * @author sreemoore
   */
  public boolean isCAMAdminLinkAvailableForTechnician(WebDriver driver) {
    try {
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      driver.findElement(clinicalAssetManagementAdminLink).isDisplayed();

    } catch (NoSuchElementException e) {
      return false;
    }

    return true;
  }

  /*
   * @author sreemoore
   */

  public void goto_CAM_AdminLinks(WebDriver driver, String linkName) {
    try {
      By linkElement = By.xpath("//div[text()='" + linkName
          + "']/ancestor::ul[contains(@aria-label,'Clinical Asset Management Admin')]/ancestor::li//child::div[text()='"
          + linkName + "']");
      functions.type(driver, bySearchFilter, linkName, "Search for " + linkName);
      logger.info("Search Link Completed");
      Thread.sleep(mediumSleep);
      if (driver.findElement(getAdminScheduledLinksByName(linkName)).isDisplayed()) {
        functions.click(driver, linkElement, "Clicked on Inventory Link" + linkName);
      }

    } catch (Exception e) {

    }
  }

  // Harjeet Code

  public void goto_FAM_WorkOrders(WebDriver driver, String linkName) {
    try {
      //Added on 01/13/2021 by sree as by default it is taking to favourites tab. 
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      functions.click(driver, By.xpath("//a[.='All applications']"));
      
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      if (driver.findElement(facilityAssetManagementLink).isDisplayed()) {
        if (driver.findElement(facilityAssetManagementLink).getAttribute("aria-expanded")
            .equalsIgnoreCase("false")) {
          functions.clickAt(driver, facilityAssetManagementLink);
        }
        SeleniumWait.hold(GlobalVariables.mediumSleep);
        if (driver.findElement(facilityAssetManagementLink_WorkOrders).isDisplayed()
            && driver.findElement(facilityAssetManagementLink_WorkOrders)
                .getAttribute("aria-expanded").equalsIgnoreCase("true")) {
          logger.info("facilityAssetManagementLink_WorkOrders is already expanded");
        }
        else {
          functions.clickAt(driver, facilityAssetManagementLink_WorkOrders,
              "Clicked on facilityAssetManagementLink_WorkOrders");
          SeleniumWait.hold(GlobalVariables.mediumSleep);

        }
//TODO - check on wait times. try moving by actions or wait by click
        if (driver.findElement(getWorkOrderLinksByName(linkName)).isDisplayed()) {
          functions.click(driver, getWorkOrderLinksByName(linkName),
              "Clicked on WorkOrder Link" + linkName);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("Not able to goto_filterWorkOrder" + e.toString());


    }
  }

  public void goto_FAMA_ExternalCompany_ManufacturersCompany(WebDriver driver) {
    try {
      logger.info("goto_FAMA_ExternalCompany_ManufacturersCompany page");
      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      goto_menufiltersearch(driver, "Manufacturers");
      driver.findElement(byFAMAA_ExternalCompanies_Manufacturers).click();

      int i = 0;

      do {
        SeleniumWait.hold(GlobalVariables.longSleep);
        i++;
        logger.info("waiting for page to load :" + i);
      } while (!driver.findElement(getByServiceNowPageFrame()).isDisplayed() && i < 2);
      functions.waitForWebElementInvisibility(driver, byLoadingMessage);
      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));

      Assert.assertTrue(
          (driver.findElement(byFAMA_ExternalCompanies_ManufacturersFilter).isDisplayed()),
          "Manufacturer company filter page is not displayed");
      logger.info("page displayed with companies having Manufacturer relationship");
    } catch (Exception e) {
      logger.error("Not able to goto_filterFacilityManufacturersCompany" + e.toString());
      Assert.fail("Not able to goto_filterFacilityManufacturersCompany");

    }
  }

  public void goto_FAMA_ExternalCompany_VendorsCompany(WebDriver driver) throws Exception {
    try {
      logger.info("goto_FAMA_ExternalCompany_VendorsCompany page");
      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      goto_menufiltersearch(driver, "Vendors");
      driver.findElement(byFAMA_ExternalCompanies_Vendors).click();

      int i = 0;
      do {
        SeleniumWait.hold(GlobalVariables.longSleep);
        i++;
        logger.info("waiting for page to load :" + i);
      } while (!driver.findElement(getByServiceNowPageFrame()).isDisplayed() && i < 2);
      functions.waitForWebElementInvisibility(driver, byLoadingMessage);
      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));
     // Now check if we are on the Vendors company page
      Assert.assertTrue((driver.findElement(byFAMA_ExternalCompanies_VendorsFilter).isDisplayed()),
          "Vendors company filter page is not displayed");
      logger.info("page displayed with companies having Vendor relationship");
    } catch (Exception e) {
      logger.error("Not able to goto_FAMA_ExternalCompany_VendorsCompany" + e.toString());
      Assert.fail("Not able to goto_FAMA_ExternalCompany_VendorsCompany");
    }
  }

  public void goto_FAMA_ExternalCompany_ServiceProvidersCompany(WebDriver driver) {
    try {
      logger.info("goto_CAMA_ExternalCompany_ServiceProvidersCompany page");
       if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      // driver.navigate().refresh();
      goto_menufiltersearch(driver, "Service Providers");
      Actions act = new Actions(driver);
      act.moveToElement(driver.findElement(byFAMA_ExternalCompanies_ServiceProviders)).build()
          .perform();

      driver.findElement(byFAMA_ExternalCompanies_ServiceProviders).click();
      int i = 0;
      do {
        SeleniumWait.hold(GlobalVariables.longSleep);
        i++;
        logger.info("waiting for page to load :" + i);
      } while (!driver.findElement(getByServiceNowPageFrame()).isDisplayed() && i < 2);
      functions.waitForWebElementInvisibility(driver, byLoadingMessage);
      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));


      // Now check if we are on theService Providers company filter page
      Assert.assertTrue(
          (driver.findElement(byFAMA_ExternalCompanies_ServiceProvidersFilter).isDisplayed()),
          "Service Providers company filter page is not displayed");
      logger.info("page displayed with companies having Service Provider relationship");
    } catch (Exception e) {
      logger.error("Not able to goto_filterFacilityServiceProvidersCompany" + e.toString());
      Assert.fail("Not able to goto_filterFacilityServiceProvidersCompany");

    }
  }


  public void goto_FAMA_ExternalCompany_AllCompany(WebDriver driver) throws Exception {
    try {
      logger.info("goto_FAMA_ExternalCompany_AllCompany page");

      /*driver.switchTo().defaultContent();
      if (!driver.findElement(byClinicalAllCompany).isDisplayed()) {
        logger.debug("All Company filter option is not displayed");
        if (goto_clinicalAssetManagementAdminMenu(driver))
          logger.debug("Now go to Clinical Asset Management Menu");
        else
          logger.error("Maybe there are some popups");
      }
      */

      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      // driver.navigate().refresh();
      goto_menufiltersearch(driver, "facilities");
      Actions act = new Actions(driver);

      functions.waitForElementPrescence(driver, byFAMA_ExternalCompanies_AllCompany);
      driver.findElement(byFAMA_ExternalCompanies_AllCompany).click();

      int i = 0;
      /* do {
         SeleniumWait.hold(GlobalVariables.longSleep);
         i++;
         logger.info("waiting for page to load :" + i);
       } while (!(driver.findElements(byCAMA_ExternalCompanies_AllCompaniesFilter).size() > 0)
           && i < 2);
       driver.switchTo().frame(driver.findElement(this.getByServiceNowCompanyFrame()));*/
      do {
        SeleniumWait.hold(GlobalVariables.longSleep);
        i++;
        logger.info("waiting for page to load :" + i);
      } while (!driver.findElement(getByServiceNowPageFrame()).isDisplayed() && i < 2);
      functions.waitForWebElementInvisibility(driver, byLoadingMessage);
      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));
      Assert.assertTrue(
          (driver.findElement(byFAMA_ExternalCompanies_AllCompaniesFilter).isDisplayed()),
          "All company filter page is not displayed");
      logger.info("AllCompanies page displayed with all companies filter");
    } catch (Exception e) {
      logger.error("Not able to goto_FAMA_ExternalCompany_AllCompany" + e.toString());
      Assert.fail("Not able to goto_FAMA_ExternalCompany_AllCompany");
    }
  }



  public void goto_FAMA_ExternalCompany_NewCompany(WebDriver driver) throws Exception {
    try {
      logger.info("Navigating to FAMA_ExternalCompany_NewCompany Page");
      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      // driver.navigate().refresh();
      goto_menufiltersearch(driver, "New Company");
      Actions act = new Actions(driver);
      act.moveToElement(driver.findElement(byFAMA_ExternalCompanies_NewCompany)).build().perform();
      driver.findElement(byFAMA_ExternalCompanies_NewCompany).click();
      int i = 0;

      do {
        SeleniumWait.hold(GlobalVariables.longSleep);
        i++;
        logger.info("waiting for page to load :" + i);
      } while (!driver.findElement(getByServiceNowPageFrame()).isDisplayed() && i < 2);


      functions.waitForWebElementInvisibility(driver, byLoadingMessage);

      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));

      // functions.waitForElementPrescence(driver, byCompanyText);

      // Now check if we are on the new company page
      Assert.assertTrue(
          (driver.findElement(byCompanyText).isDisplayed()
              && driver.findElement(byNewRecord).isDisplayed()),
          "New Company Page is not displayed");

    } catch (Exception e) {
      logger.error("Not able to goto_FAMA_ExternalCompany_NewCompany" + e.toString());
      Assert.fail("Not able to goto_FAMA_ExternalCompany_NewCompany");
    }
  }

  public void goto_FAMA_Inventory_Vendor(WebDriver driver, boolean bCreateNew) throws Exception {
    try {
      logger.info("Go to FAMA Vendors Page");
      if (!driver.getTitle().toLowerCase().contains("servicenow")) {
        driver.navigate().refresh();
        Thread.sleep(longSleep);
      }
      // driver.navigate().refresh();
      goto_menufiltersearch(driver, "Vendors");
      Actions act = new Actions(driver);
      act.moveToElement(driver.findElement(byFAMA_InventoryVendors)).build().perform();

      driver.findElement(byFAMA_InventoryVendors).click();
      logger.info("Clicked on Vendor filter page");
      int i = 0;
      do {
        SeleniumWait.hold(GlobalVariables.longSleep);
        i++;
        logger.info("waiting for page to load :" + i);
      } while (!driver.findElement(getByServiceNowPageFrame()).isDisplayed() && i < 2);
      functions.waitForWebElementInvisibility(driver, byLoadingMessage);
      driver.switchTo().frame(driver.findElement(getByServiceNowPageFrame()));
      // Now check if we are on the companies page with vendor=true filter
      Assert.assertTrue((driver.findElement(byFAMAInventory_Vendorsfilter).isDisplayed()),
          "Vendors Page is not displayed");
      if (bCreateNew) {
        // TODO remove hardcoded xpaths
        Thread.sleep(GlobalVariables.mediumSleep);
        driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
        Thread.sleep(GlobalVariables.longSleep);
        Assert.assertTrue(
            (driver.findElement(byCompanyText).isDisplayed()
                && driver.findElement(byNewRecord).isDisplayed()),
            "New Company Page is not displayed");
      }
    } catch (Exception e) {
      logger.error(driver.getCurrentUrl());
      logger.error("goto_filterFAMA_Inventory_Vendor --failed with error" + e.toString());
      Assert.fail("goto_filterFAMAA_Inventory_Vendor --failed with error" + e.toString());
    }
  }


  public void goto_FAMInventoryLinks(WebDriver driver, String linkName) {
    try {

      goto_menufiltersearch(driver, "Work Orders");
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      if (driver.findElement(facilitiesAssetManagementLink).isDisplayed()) {
        functions.clickAt(driver, facilitiesAssetManagementLink);

        SeleniumWait.hold(GlobalVariables.mediumSleep);
        if (driver.findElement(facilitiesAssetInventoryLink).isDisplayed()
            && driver.findElement(facilitiesAssetInventoryLink).getAttribute("area-expanded")
                .equalsIgnoreCase("true")) {
          logger.info("FacilitiesAssetInventoryLink is already expanded");
        }
        else {
          functions.click(driver, facilitiesAssetManagementLink, "Clicked on Asset Management");
          SeleniumWait.hold(GlobalVariables.mediumSleep);

        }
//TODO - check on wait times. try moving by actions or wait by click


        if (driver.findElement(getFAMInventoryLinksByName(linkName)).isDisplayed()) {
          // functions.clickAt(driver,getInventoryLinksByName(linkName),"Clicked on Inventory Link"
          // +getInventoryLinksByName(linkName));
          functions.click(driver, getFAMInventoryLinksByName(linkName),
              "Clicked on Inventory Link" + getFAMInventoryLinksByName(linkName));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("Not able to goto_filterFacilitiesInventory" + e.toString());
      Assert.fail("Not able to goto_filterFacilitiesInventory");

    }
  }

  /*
   * @author sreemoore
   */


  public void goto_CAM_Links(WebDriver driver, String linkName) {
    try {
      functions.type(driver, bySearchFilter, linkName, "Search for " + linkName);
      logger.info("Search Link Completed");
      Thread.sleep(mediumSleep);
      List<WebElement> searchedLink =
          // driver.findElements(By.xpath("//a[contains(@ng-href,'x_nuvo_eam_clinical_ealerts')]"));
          // Locator got changed after Prod clone down on 09/17 in KP QA
          driver.findElements(By.xpath("//a[contains(@href,'x_nuvo_eam_clinical_ealerts')]"));
      logger.info("Wait for Link Completed");
      for (WebElement link : searchedLink)
        if (link.getText().equals(linkName)) {
          logger.info("CLick Link");
          link.click();
          break;
        }


    } catch (Exception e) {
      logger.info("Not able to find link");
    }

  }

  /*
   * @author sreemoore
   */

  public boolean goto_FAMA_WorkOrderLinks(WebDriver driver, String linkName) {
    try {

      functions.type(driver, bySearchFilter, linkName,
          "Search for Facilities Asset Management Admin");
      logger.info("Search Link Completed");
      Thread.sleep(mediumSleep);
      List<WebElement> searchedLink = driver.findElements(By.xpath(
          "//ul[@aria-label='Modules for Application: Facilities Asset Management Admin']//div[text()='"
              + linkName + "']"));
//      new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfAllElements(searchedLink));
      logger.info("Wait for Link Completed");
      for (WebElement link : searchedLink)
        if (link.getText().equals(linkName)) {
          logger.info("CLick Link");
          link.click();
          return true;
        }


    } catch (Exception e) {
      logger.info("Not able to find link");
    }
    return false;
  }


//To handle links under Clinical Work orders:

  public void goto_CAM_WorkOrders(WebDriver driver, String linkName) {
    try {
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      if (driver.findElement(clinicalAssetManagementLink).isDisplayed()) {
        if (driver.findElement(clinicalAssetManagementLink).getAttribute("aria-expanded")
            .equalsIgnoreCase("false")) {
          functions.clickAt(driver, clinicalAssetManagementLink);
        }
        SeleniumWait.hold(GlobalVariables.mediumSleep);
        if (driver.findElement(clinicalAssetManagementLink_WorkOrders).isDisplayed()
            && driver.findElement(clinicalAssetManagementLink_WorkOrders)
                .getAttribute("aria-expanded").equalsIgnoreCase("true")) {
          logger.info("clinical AssetManagementLink_WorkOrders is already expanded");
        }
        else {
          functions.clickAt(driver, clinicalAssetManagementLink_WorkOrders,
              "Clicked on Clinical AssetManagementLink_WorkOrders");
          SeleniumWait.hold(GlobalVariables.mediumSleep);

        }

        if (driver.findElement(geClinicalWorkOrderLinksByName(linkName)).isDisplayed()) {
          functions.click(driver, geClinicalWorkOrderLinksByName(linkName),
              "Clicked on WorkOrder Link" + linkName);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("Not able to goto_filterWorkOrder" + e.toString());
      Assert.fail("Not able to goto_filterWorkOrder");

    }
  }


}
