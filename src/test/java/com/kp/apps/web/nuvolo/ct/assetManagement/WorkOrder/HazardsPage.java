package com.kp.apps.web.nuvolo.ct.assetManagement.WorkOrder;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.kp.apps.web.library.Functions;
import com.kp.apps.web.library.GlobalVariables;
import com.kp.apps.web.library.SeleniumWait;
import com.kp.apps.web.nuvolo.application.HomePage;
import com.kp.apps.web.nuvolo.application.NuvoloAppMenu;



public class HazardsPage {
	
	 HomePage           nuvoloAppHomePg = new HomePage();
	  Functions          function        = new Functions();
	  Functions          functions       = new Functions();
	  NuvoloAppMenu      nAppMenu        = new NuvoloAppMenu();
	  private Logger     logger          = Logger.getLogger(HazardsPage.class);

	  public By gethazardLinksByName(String linkName) {

	    return By.xpath(
	        "//a[span='Clinical Asset Management']/..//div[@class='sn-widget-list-title'][contains(text(),'"
	            + linkName + "')]");
	  }

	  private static final By clinicalAssetAdminHazardsLink           =
	      By.xpath("//a[span='Clinical Asset Management Admin']/..//a/span[.='Hazards']/..");


	  private static final By allLinkInHazards                        =
	      By.xpath("//a[contains(@class,'breadcrumb_link')]//b");

	  /*
	   * Hazard Type Page
	   */

	  /*
	   * Fill in Hazard Types form
	   */

	  private static final By hazardTypeTextBox                       =
	      By.xpath("(//input[contains(@id,'x_nuvo_eam_clinical_hazard_type.name')])[2]");

	  // generated number for hazard
	  private static final By hazard_Number                           =
	      By.id("sys_readonly.x_nuvo_eam_clinical_hazard_type.number");

	  // hazard description
	  private static final By hazard_Description                      =
	      By.xpath("//textarea[contains(@id,'x_nuvo_eam_clinical_hazard_type.description')]");

	  private static final By hazardSubmitBtn                         =
	      By.xpath("(//button[contains(@id,'sysverb_insert')])[2]");
	  // *********************************************************************

	  /*
	   * @Hazards Fill form
	   */



	  private static final By hazardsNumber                           =
	      By.xpath("//input[contains(@id,'sys_readonly.x_nuvo_eam_clinical_hazard.number')]");

	  private static final By hazardsType                             =
	      By.xpath("//input[contains(@id,'sys_display.x_nuvo_eam_clinical_hazard.hazard_type')]");

	  private static final By hazardsMaterialsCheckBox                =
	      By.id("label.ni.x_nuvo_eam_clinical_hazard.hazardous_materials");

	  private static final By hazardsCriticalityDropDown              =
	      By.xpath("//select[contains(@id,'x_nuvo_eam_clinical_hazard.criticality')]");

	  private static final By hazardsShortDescription                 =
	      By.xpath("(//input[contains(@id,'x_nuvo_eam_clinical_hazard.name')])[2]");

	  private static final By hazardstDescription                     =
	      By.xpath("//textarea[contains(@id,'x_nuvo_eam_clinical_hazard.description')]");

	  private static final By hazardsValue                            =
	      By.xpath("(//input[contains(@id,'x_nuvo_eam_clinical_hazard.value')])[2]");

	  private static final By hazardsUnitOfMeasure                    =
	      By.xpath("//input[contains(@id,'sys_display.x_nuvo_eam_clinical_hazard.unit_of_measure')]");

	  private static final By hazardsTagOutRequired                   =
	      By.xpath("//label[contains(@id,'label.ni.x_nuvo_eam_clinical_hazard.tagout_required')]");


	  /*
	   * service now frame
	   */
	  private static final By ServiceNowCompanyFrame                  =
	      By.xpath("//iframe[contains(@title,'ServiceNow')]");

	  private static final By hazardTypesheader                       =
	      By.xpath("//h2[contains(.,'Clinical Hazard Types')]");


	  /*
	   * Error Message
	   */
	  private static final By hazardsErrorMessg                       = By.className("outputmsg_text");
	  // generated number


	  /*
	   * Fill in hazard form
	   */



	  /*
	   * save n go button
	   */
	  private By              bySaveNGoBtn                            =
	      By.xpath("(//button[contains(text(),'Save & Go')])[1]");
	//button[@id='sysverb_nuvo_insert']


	  private By              hazardSearchTextbox                     =
	      By.xpath("(//input[@class='form-control'])[1]");

	  private By              bySearchDropdown                        =
	      By.xpath("//select[contains(@class,'outline')]");



	  /*
	   * tabs after clicking submit
	   */



	  private By              hazzardNewButton                        =
	      By.xpath("(//button[contains(@id,'sysverb_new')])[1]");



	  private By              newButtonInClinicalhazard               =
	      By.xpath("(//button[contains(@id,'sysverb_new')])[1]");



	  private By              clinicalAssetManagementAdminHazardsLink = By.xpath(
	      "//a[span='Clinical Asset Management Admin']/..//a[contains(@class,'group-title') and .='Hazards']");

	  private static final By clinicalAssetManagementAdminLink        =
	      By.xpath("//a[span='Clinical Asset Management Admin']");

	  public By getHazardsLinkByName(String linkName) {

	    return By.xpath(
	        "//a[span='Clinical Asset Management Admin']/..//a[contains(@class,'group-title') and .='Hazards']/../..//li[.='"
	            + linkName + "']");
	  }

	  /*
	   *
	   *
	   * Manage Hazards Types
	   */


	  public void manageHazardTypes(WebDriver driver, boolean bCreate, HazardsBuilder hb)
	      throws Exception {
	    try {
	      logger.info("Manage Hazards method");
	      if (driver.getTitle().contains("Service")) {
	        logger.info("Nuvolo app is already having existing session");
	      }
	      else {
	        nuvoloAppHomePg.goto_NuvoloAppHomePage(driver);
	      }
	      if (bCreate) {
	        goto_CAMA_HazardsLinks(driver, "Hazard Types");
	        functions.waitForFrameAndSwitch(driver, ServiceNowCompanyFrame);
	        fillHazardTypesForm(driver, hb);
	        if (hb.isVerifyNewHazardType()) {
	          SearchByNumber(driver, hb.getHazardTypeNumber());
	          verifyHazardsType(driver, hb);
	        }

	      }
	      /*
	       * Verify all link is hazard type
	       */
	      else {
	        if (hb.isVerifyAllHazardTypesScreen()) {
	          goto_CAMA_HazardsLinks(driver, "Hazard Types");
	          functions.waitForFrameAndSwitch(driver, ServiceNowCompanyFrame);
	          verifyAllHazardsPage(driver);
	        }

	        if (hb.isVerifyHazardTypesScreen()) {
	          goto_CAMA_HazardsLinks(driver, "Hazard Types");
	          functions.waitForFrameAndSwitch(driver, ServiceNowCompanyFrame);
	          SeleniumWait.hold(GlobalVariables.mediumSleep);
	          logger.info("switched into frame");
	          verifyHazardsTypeScreen(driver);
	        }
	        else {
	          logger.info("Did not verify Hazard screen screen");
	        }
	        if (hb.isVerifyErrorMssg()) {
	          goto_CAMA_HazardsLinks(driver, "Hazards");
	          functions.waitForFrameAndSwitch(driver, ServiceNowCompanyFrame);
	          SeleniumWait.hold(GlobalVariables.mediumSleep);
	          logger.info("switched into frame");
	          verifyErrorMessageOnHazardTypes(driver);
	          logger.info(
	              "Did verify error Message after clicking submit button and selecting any mandotory fields");
	        }
	        else {
	          logger.info(
	              "Did not verify error Message after clicking on submit button and selecting manditory fields");
	        }
	        if (hb.isVerifyEnabledFields()) {
	          goto_CAMA_HazardsLinks(driver, "Hazard Types");
	          functions.waitForFrameAndSwitch(driver, ServiceNowCompanyFrame);
	          SeleniumWait.hold(GlobalVariables.mediumSleep);
	          logger.info("switched into frame");
	          validatehazardTypesFieldsAreEditable(driver);
	        }

	      }

	    } catch (Exception e) {
	      e.printStackTrace();

	    }
	  }

	  /*
	   *
	   *
	   * Manage Hazards Page
	   */
	  public void manageHazards(WebDriver driver, boolean bCreate, HazardsBuilder hb) throws Exception {
	    try {
	      logger.info("Manage Hazards method");
	      if (driver.getTitle().contains("Service")) {
	        logger.info("Nuvolo app is already having existing session");
	      }
	      else {
	        nuvoloAppHomePg.goto_NuvoloAppHomePage(driver);
	      }
	      if (bCreate) {
	        goto_CAMA_HazardsLinks(driver, "Hazards");
	        logger.info("clicked on Hazards link under Hazard Module");
	        functions.waitForFrameAndSwitch(driver, ServiceNowCompanyFrame);
	        fillHazardsForm(driver, hb);
	        if (hb.isVerifyHazardsSavedPage()) {
	          SearchByNumber(driver, hb.getHazardsNumber());
	          verifyHazardsSavedinTable(driver, hb);
	        }

	      }
	      /*
	       * Verify 'ALL' link in hazards types page
	       */
	      else {
	        if (hb.isVerifyAllHazardTypesScreen()) {
	          goto_CAMA_HazardsLinks(driver, "Hazards");
	          functions.waitForFrameAndSwitch(driver, ServiceNowCompanyFrame);
	          verifyAllHazardsPage(driver);
	        }

	        if (hb.isVerifyHazardsScreen()) {
	          goto_CAMA_HazardsLinks(driver, "Hazards");
	          functions.waitForFrameAndSwitch(driver, ServiceNowCompanyFrame);
	          SeleniumWait.hold(GlobalVariables.mediumSleep);
	          logger.info("switched into frame");
	          verifyHazardsScreen(driver);
	        }
	        else {
	          logger.info("Did not verify Hazard screen screen");
	        }
	        if (hb.isVerifyErrorMssgOnHazzardsPage()) {
	          goto_CAMA_HazardsLinks(driver, "Hazards");
	          functions.waitForFrameAndSwitch(driver, ServiceNowCompanyFrame);
	          SeleniumWait.hold(GlobalVariables.mediumSleep);
	          logger.info("switched into frame");
	          verifyErrorMessageOnHazardsPage(driver);
	          logger.info(
	              "Did verify error Message after clicking submit button and selecting any mandotory fields");
	        }
	        else {
	          logger.info(
	              "Did not verify error Message after clicking on submit button and selecting manditory fields");
	        }
	        if (hb.isVerifyEnabledFieldsinHazardsPage()) {
	          goto_CAMA_HazardsLinks(driver, "Hazards");
	          functions.waitForFrameAndSwitch(driver, ServiceNowCompanyFrame);
	          SeleniumWait.hold(GlobalVariables.mediumSleep);
	          logger.info("switched into frame");
	          validateHazardsFieldsAreEditable(driver);
	        }

	      }

	    } catch (Exception e) {
	      e.printStackTrace();

	    }

	  }

	  /*
	   * Validating the after clicking the Hazard Types link the new button is on the page and text is 'Clinical Hazard Type'
	   */
	  private boolean verifyHazardsTypeScreen(WebDriver driver) throws Exception {
	    logger.info("Clicked on Hazards Type page");
	    boolean flg = false;
	    try {
	      functions.waitForElementToBeClickable(driver, hazzardNewButton, 5);
	      Assert.assertTrue(driver.findElements(hazzardNewButton).size() == 1,
	          "Failed to verify New button");
	      logger.info("new Button exist on the Hazzard Type");
	      functions.highlighElement(driver, hazzardNewButton);
	      Assert.assertTrue(
	          driver.findElement(hazardTypesheader).getText().contains("Clinical Hazard Type"),
	          "Failed to find the Hazards Type record tile");
	      logger.info("Verified Hazards Type record Title with "
	          + (driver.findElement(hazardTypesheader).getText()));
	      functions.highlighElement(driver, hazardTypesheader);

	      flg = true;

	    } catch (Exception e) {
	      e.printStackTrace();
	      throw e;
	    }
	    return flg;
	  }

	  private boolean verifyHazardsScreen(WebDriver driver) throws Exception {
	    logger.info("Clicked on Hazards Type page");
	    boolean flg = false;
	    try {
	      functions.waitForElementToBeClickable(driver, hazzardNewButton, 5);
	      Assert.assertTrue(driver.findElements(hazzardNewButton).size() == 1,
	          "Failed to verify New button");
	      logger.info("new Button exist on the Hazzards screen");
	      functions.highlighElement(driver, hazzardNewButton);
	      Assert.assertTrue(
	          driver.findElement(hazardTypesheader).getText().contains("Clinical Hazards"),
	          "Failed to find the Hazards Type record tile");
	      logger.info("Verified Hazards Type record Title with "
	          + (driver.findElement(hazardTypesheader).getText()));
	      functions.highlighElement(driver, hazardTypesheader);

	      flg = true;

	    } catch (Exception e) {
	      e.printStackTrace();
	      throw e;
	    }
	    return flg;
	  }

	  public void verifyAllHazardsPage(WebDriver driver) throws Exception {
	    try {
	      SeleniumWait.hold(GlobalVariables.mediumSleep);
	      logger.info("switched into frame");
	      Assert.assertEquals(driver.findElement(allLinkInHazards).getText().trim(), "All",
	          "Failed to verify the Hazards All link");
	      functions.highlighElement(driver, allLinkInHazards);
	      logger.info("Verified the Hazards All link");

	    } catch (Exception e) {
	      e.printStackTrace();

	    }
	  }

	  /*
	   * Error Message in Hazards Type Page
	   */
	  private void verifyErrorMessageOnHazardTypes(WebDriver driver) {
	    functions.waitForElementToBeClickable(driver, hazzardNewButton, 5);
	    function.highlighElement(driver, hazzardNewButton);
	    functions.clickAt(driver, hazzardNewButton, "clicked new button");
	    SeleniumWait.hold(GlobalVariables.ShortSleep);
	    functions.click(driver, hazardSubmitBtn, "Clicked on submit button");
	    SeleniumWait.hold(GlobalVariables.ShortSleep);
	    String errorMssg = driver.findElement(hazardsErrorMessg).getText().trim();
	    //Updated as on 9/16 as the Short Description Field became Mandatory--By Sree
	    Assert.assertEquals(errorMssg, "The following mandatory fields are not filled in: Hazard Type, Short Description");
	    logger.info("hazardType updated. Actual : [ " + errorMssg
	        + " ] Expected : [The following mandatory fields are not filled in: Hazard Type, Short Description]");
	  }

	  private void verifyErrorMessageOnHazardsPage(WebDriver driver) {
	    functions.waitForElementToBeClickable(driver, hazzardNewButton, 5);
	    function.highlighElement(driver, hazzardNewButton);
	    functions.clickAt(driver, hazzardNewButton, "clicked new button");
	    SeleniumWait.hold(GlobalVariables.ShortSleep);
	    functions.click(driver, hazardSubmitBtn, "Clicked on submit button");
	    SeleniumWait.hold(GlobalVariables.ShortSleep);
	    String errorMssg = driver.findElement(hazardsErrorMessg).getText().trim();
	    Assert.assertEquals(errorMssg,
	        "The following mandatory fields are not filled in: Hazard Type, Short Description");
	    logger.info("hazardType updated. Actual : [ " + errorMssg
	        + " ] Expected : [The following mandatory fields are not filled in: Hazard Type, Short Description]");
	  }

	  public void validatehazardTypesFieldsAreEditable(WebDriver driver) {
	    functions.waitForElementToBeClickable(driver, hazzardNewButton, 5);
	    function.highlighElement(driver, hazzardNewButton);
	    functions.clickAt(driver, hazzardNewButton, "clicked new button");
	    functions.waitForElement(driver, hazardTypeTextBox);
	    function.highlighElement(driver, hazardTypeTextBox);
	    Assert.assertTrue(driver.findElement(hazardTypeTextBox).isEnabled(),
	        "hazardType TextBox is not editable");
	    logger.info("hazardTypeTextBox is editable");
	    function.highlighElement(driver, hazard_Description);
	    Assert.assertTrue(driver.findElement(hazard_Description).isEnabled(),
	        "hazard_Description is not editable");
	    logger.info("hazard_Description is editable");
	    logger.info("hazard types fields are enabled");
	  }

	  public void validateHazardsFieldsAreEditable(WebDriver driver) {
	    functions.waitForElementToBeClickable(driver, hazzardNewButton, 5);
	    function.highlighElement(driver, hazzardNewButton);
	    functions.clickAt(driver, hazzardNewButton, "clicked new button");
	    functions.waitForElement(driver, hazardsType);
	    function.highlighElement(driver, hazardsType);
	    Assert.assertTrue(driver.findElement(hazardsType).isEnabled(),
	        "hazards type TextBox is not editable");
	    logger.info("hazards type text box is editable");
	    function.highlighElement(driver, hazardsShortDescription);
	    Assert.assertTrue(driver.findElement(hazardsShortDescription).isEnabled(),
	        "hazards short description is not editable");
	    logger.info("hazards short description is editable");
	    function.highlighElement(driver, hazardsCriticalityDropDown);
	    Assert.assertTrue(driver.findElement(hazardsCriticalityDropDown).isEnabled(),
	        "hazardsCriticalityDropDown is not editable");
	    logger.info("hazardsCriticalityDropDown is editable");
	    function.highlighElement(driver, hazardsMaterialsCheckBox);
	    Assert.assertTrue(driver.findElement(hazardsMaterialsCheckBox).isEnabled(),
	        "hazardsMaterialsCheckBox is not editable");
	    logger.info("hazardsMaterialsCheckBox is editable");
	    logger.info("hazards fields are enabled");
	  }

	  /*
	   * Filling in the hazard types
	   */
	  public void fillHazardTypesForm(WebDriver driver, HazardsBuilder hb) throws Exception {
	    SeleniumWait.hold(GlobalVariables.ShortSleep);
	    functions.click(driver, newButtonInClinicalhazard, "clicked on new button");
	    functions.waitForElementPrescence(driver, hazard_Number);
	    hb.setHazardTypeNumber(driver.findElement(hazard_Number).getAttribute("value"));
	    functions.type(driver, hazardTypeTextBox, hb.getHazardTypeTextBox(), "hazard type text added");
	    functions.type(driver, hazard_Description, hb.getDescription(), "description added");
	    SeleniumWait.hold(GlobalVariables.ShortSleep);
	    functions.waitForElementPrescence(driver, hazardSubmitBtn);
	    functions.clickAt(driver, hazardSubmitBtn, "clicked on submit button");
	    functions.click(driver, bySaveNGoBtn);

	  }
	  /*
	   * Filling in the Hazards Page
	   */

	  public void fillHazardsForm(WebDriver driver, HazardsBuilder hb) throws Exception {
	    SeleniumWait.hold(GlobalVariables.ShortSleep);
	    functions.click(driver, newButtonInClinicalhazard, "clicked on new button");
	    functions.waitForElementPrescence(driver, hazardsNumber);
	    hb.setHazardsNumber(driver.findElement(hazardsNumber).getAttribute("value"));
	    functions.type(driver, hazardsType, hb.getHazardsType(), "hazards type text added");
	    functions.waitForElementPrescence(driver, hazardsShortDescription);
	    functions.type(driver, hazardsShortDescription, hb.getHazardsShortDescription(),
	        "short description added");
	    if (hb.isHazardousMaterialsCheckBox()==true) {
	      functions.click(driver, hazardsMaterialsCheckBox,"check box got clicked");
	    }
	    SeleniumWait.hold(GlobalVariables.ShortSleep);
	    functions.waitForElementPrescence(driver, hazardSubmitBtn);
	    functions.clickAt(driver, hazardSubmitBtn, "clicked on submit button");
	    functions.click(driver, bySaveNGoBtn);

	  }



	  /*
	   * verifying the New button is under the Clinical hazard tab
	   */



	  public void SearchByNumber(WebDriver driver, String number) throws Exception {
	    try {
	      SeleniumWait.hold(GlobalVariables.mediumSleep);
	      functions.waitForElementPrescence(driver, bySearchDropdown);
	      logger.info("Search new hazard By Number");
	      functions.selectDropDown(driver, bySearchDropdown, "Number");
	      logger.info("hazard Number passed in number textBox");
	      Assert.assertTrue(driver.findElement(bySearchDropdown).isEnabled());
	      Actions act = new Actions(driver);
	      functions.highlighElement(driver, hazardSearchTextbox);
	      try {
	        driver.findElement(hazardSearchTextbox).sendKeys(number);
	        act.sendKeys(Keys.ENTER).build().perform();
	        SeleniumWait.hold(GlobalVariables.mediumSleep);
	        logger.info("hazards number : " + number);
	      } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }

	    } catch (Exception e) {
	      e.printStackTrace();
	      Assert.fail("Failed : SearchByNumber");

	    }
	  }

	  /*
	   * Validate the saved fields after creating a Hazard Type
	   */

	  public boolean verifyHazardsSavedinTable(WebDriver driver, HazardsBuilder hb) throws Exception {
	    logger.info("Clicked on Hazards page");
	    boolean flg = false;
	    try {
	      Assert.assertEquals(
	          functions.getCellByTableAndHeader(driver, "hazard", "Number").getText().trim(),
	          hb.getHazardsNumber());
	      logger.info("hazard's Number verified Actual: [ "
	          + functions.getCellByTableAndHeader(driver, "hazard", "Number").getText().trim()
	          + " ] Expected : [ " + hb.getHazardsNumber() + " ]");
	      functions.highlighElement(driver,
	          functions.getCellByTableAndHeader(driver, "hazard", "Number"));

	      Assert.assertEquals(
	          functions.getCellByTableAndHeader(driver, "hazard", "Hazard Type").getText().trim(),
	          hb.getHazardsType());
	      logger.info("Hazard Types text box verified Actual: [ "
	          + functions.getCellByTableAndHeader(driver, "hazard", "Hazard Type").getText().trim()
	          + " ] Expected : [ " + hb.getHazardsType() + " ]");
	      functions.highlighElement(driver,
	          functions.getCellByTableAndHeader(driver, "hazard", "Hazard Type"));

	      Assert.assertEquals(
	          functions.getCellByTableAndHeader(driver, "hazard", "Short Description").getText().trim(),
	          hb.getHazardsShortDescription());
	      logger
	          .info(
	              "HazardType Short Description verified Actual: [ "
	                  + functions.getCellByTableAndHeader(driver, "hazard", "Short Description")
	                      .getText().trim()
	                  + " ] Expected : [ " + hb.getHazardsShortDescription() + " ]");
	      functions.highlighElement(driver,
	          functions.getCellByTableAndHeader(driver, "hazard", "Short Description"));

	      if(hb.isHazardousMaterialsCheckBox()){
	        Assert.assertEquals(
	            functions.getCellByTableAndHeader(driver, "hazard", "Hazardous Materials").getText().trim(),
	            String.valueOf(hb.isHazardousMaterialsCheckBox()));
	        logger
	            .info(
	                "HazardType Short Description verified Actual: [ "
	                    + functions.getCellByTableAndHeader(driver, "hazard", "Hazardous Materials")
	                        .getText().trim()
	                    + " ] Expected : [ " + hb.isHazardousMaterialsCheckBox() + " ]");
	        functions.highlighElement(driver,
	            functions.getCellByTableAndHeader(driver, "hazard", "Hazardous Materials"));
	      }


	    } catch (Exception e) {
	      e.printStackTrace();
	      throw e;
	    }
	    return flg;
	  }

	  public boolean verifyHazardsType(WebDriver driver, HazardsBuilder hb) throws Exception {
	    logger.info("Clicked on Hazard Types filter page");
	    boolean flg = false;
	    try {

	      Assert.assertEquals(
	          functions.getCellByTableAndHeader(driver, "hazard", "Number").getText().trim(),
	          hb.getHazardTypeNumber());
	      logger.info("hazard's Number verified Actual: [ "
	          + functions.getCellByTableAndHeader(driver, "hazard", "Number").getText().trim()
	          + " ] Expected : [ " + hb.getHazardTypeNumber() + " ]");
	      functions.highlighElement(driver,
	          functions.getCellByTableAndHeader(driver, "hazard", "Number"));

	      Assert.assertEquals(
	          functions.getCellByTableAndHeader(driver, "hazard", "Hazard Type").getText().trim(),
	          hb.getHazardTypeTextBox());
	      logger.info("Hazard Types text box verified Actual: [ "
	          + functions.getCellByTableAndHeader(driver, "hazard", "Hazard Type").getText().trim()
	          + " ] Expected : [ " + hb.getHazardTypeTextBox() + " ]");
	      functions.highlighElement(driver,
	          functions.getCellByTableAndHeader(driver, "hazard", "Hazard Type"));

	      Assert.assertEquals(
	          functions.getCellByTableAndHeader(driver, "hazard", "Description").getText().trim(),
	          hb.getDescription());
	      logger.info("HazardType Short Description verified Actual: [ "
	          + functions.getCellByTableAndHeader(driver, "hazard", "Description").getText().trim()
	          + " ] Expected : [ " + hb.getDescription() + " ]");
	      functions.highlighElement(driver,
	          functions.getCellByTableAndHeader(driver, "hazard", "Description"));


	    } catch (Exception e) {
	      e.printStackTrace();
	      throw e;
	    }
	    return flg;
	  }


	  public void goto_CAMA_HazardsLinks(WebDriver driver, String linkName) {
	    try {
	      SeleniumWait.hold(GlobalVariables.mediumSleep);
	      if (driver.findElement(clinicalAssetManagementAdminLink).isDisplayed()) {
	        if (driver.findElement(clinicalAssetManagementAdminLink).getAttribute("aria-expanded")
	            .equalsIgnoreCase("false")) {
	          functions.clickAt(driver, clinicalAssetManagementAdminLink);
	        }
	        SeleniumWait.hold(GlobalVariables.mediumSleep);
	        if (driver.findElement(clinicalAssetManagementAdminHazardsLink).isDisplayed()
	            && driver.findElement(clinicalAssetManagementAdminHazardsLink)
	                .getAttribute("aria-expanded").equalsIgnoreCase("true")) {
	          logger.info("ClinicalAsset Manage. Admin Hazards is already expanded");
	        }
	        else {
	          functions.clickAt(driver, clinicalAssetManagementAdminHazardsLink,
	              "Clicked on CAMA Hazards");
	          SeleniumWait.hold(GlobalVariables.mediumSleep);

	        }
	        if (driver.findElement(getHazardsLinkByName(linkName)).isDisplayed()) {

	          functions.click(driver, getHazardsLinkByName(linkName),
	              "Clicked on hazard Link" + linkName);
	        }
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	      logger.error("Not able to goto_filterClinicalHazards" + e.toString());
	      Assert.fail("Not able to goto_filterClinicalHazards");

	    }
	  }

}
