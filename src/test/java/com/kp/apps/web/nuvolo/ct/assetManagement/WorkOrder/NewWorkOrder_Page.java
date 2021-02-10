package com.kp.apps.web.nuvolo.ct.assetManagement.WorkOrder;

import static org.testng.Assert.assertTrue;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.kp.apps.web.library.EAMMPageActions;
import com.kp.apps.web.library.Functions;
import com.kp.apps.web.library.GlobalVariables;
import com.kp.apps.web.library.SeleniumWait;
import com.kp.apps.web.nuvolo.application.NuvoloAppMenu;
import io.qameta.allure.Step;

public class NewWorkOrder_Page {

  private Logger  logger                 = Logger.getLogger(NewWorkOrder_Page.class);
  WebDriver       driver;
  EAMMPageActions pageActions;
  Functions       functions              = new Functions();
  NuvoloAppMenu   namp                   = new NuvoloAppMenu();

  @FindBy(xpath = "//*[contains(text(),'New Work Order')]")
  WebElement      newWorkOrderLink;

  @FindBy(xpath = "//input[contains(@id, 'sys_display.x_nuvo_eam_clinical_work_orders.asset')]")
  WebElement      assetTxtField;

  @FindBy(
      xpath = "//input[contains(@id, 'sys_display.x_nuvo_eam_clinical_work_orders.u_issue_category')]")
  WebElement      issueCategory;

  @FindBy(xpath = "(//input[contains(@id,'x_nuvo_eam_clinical_work_orders.short_description')])[4]")
  WebElement      orderSummary;

  @FindBy(xpath = "//button[contains(text(),'Draft')]")
  WebElement      draftBtn;

  @FindBy(xpath = "//*[@id='gsft_main']")
  WebElement      iframe;

  @FindBy(xpath = "//*[@id='dialog_frame']")
  WebElement      itemizedFrame;

  @FindBy(xpath = "(//button[contains(text(),'Save & Go')])[1]")
  WebElement      saveAndGoButton;

  @FindBy(xpath = "(//button[contains(text(),'Save & Stay')])[1]")
  WebElement      saveAndStayButton;

  // @FindBy(xpath = "(//button[contains(text(),'Itemized Costs')])[1]")

  @FindBy(xpath = "//*[@id='showWOICForm']")
  WebElement      itemizedCostsButton;


  @FindBy(xpath = "//input[@id='x_nuvo_eam_work_order_itemize_cost.u_minutes']")
  WebElement      itemizedMinutes;

  @FindBy(xpath = "//input[@id='x_nuvo_eam_work_order_itemize_cost.u_hours']")
  WebElement      itemizedHours;

  @FindBy(xpath = "//input[@id='x_nuvo_eam_work_order_itemize_cost.start_time']")
  WebElement      itemizedStartTime;

  @FindBy(xpath = "//button[@id='sysverb_insert_bottom']")
  WebElement      itemizedSubmitButton;

  @FindBy(
      xpath = "(//*[@id='x_nuvo_eam_work_order_itemize_cost.start_time.ui_policy_sensitive']/span)[3]")
  WebElement      clickOnCalender;

  @FindBy(xpath = "//*[@id='GwtDateTimePicker_ok']")
  WebElement      selectDate;

  @FindBy(xpath = "//span[@class = 'outputmsg_text']")
  WebElement      errorMessage;


  @FindBy(xpath = "//*[@id='sys_display.x_nuvo_eam_clinical_work_orders.assignment_group']")
  WebElement      pendingAssignMentGroupName;

  @FindBy(xpath = "//*[contains(@class,'process-breadcrumb process-breadcrumb-border')]")
  WebElement      workOrderStates;

  @FindBy(xpath = "//a[contains(text(),'Draft')]")
  WebElement      draftTab;

  @FindBy(xpath = "//a[contains(text(),'Pending Assignment')]")
  WebElement      pendingAssignmentTab;

  @FindBy(xpath = "//a[contains(text(),'Pending Acceptance')]")
  WebElement      pendingAcceptanceTab;

  @FindBy(xpath = "//a[contains(text(),'Ready for Work')]")
  WebElement      readyForWorkTab;

  @FindBy(xpath = "//a[contains(text(),'Work in Progress')]")
  WebElement      workInProgressTab;

  @FindBy(xpath = "//a[contains(text(),'On Hold')]")
  WebElement      onHoldTab;

  @FindBy(xpath = "//a[contains(text(),'Pending Review')]")
  WebElement      pendingReviewTab;

  @FindBy(xpath = "//a[contains(text(),'Closed')]")
  WebElement      cosedTab;

  @FindBy(xpath = "//*[contains(@class,'form_header navbar-title navbar-title-twoline')]")
  WebElement      clinicalWorkOrderHeaderTab;

  @FindBy(xpath = "//button[@id='sysverb_insert']")
  WebElement      submitBtn;

  @FindBy(xpath = "//button[contains(text(),'Pending Assignment')]")
  WebElement      pendingAssignmentBtn;

  @FindBy(xpath = "//button[contains(text(),'Pending Acceptance')]")
  WebElement      pendingAcceptanceBtn;

  @FindBy(xpath = "//button[contains(text(),'Work in Progress')]")
  WebElement      workInProgressBtn;

  @FindBy(xpath = "//button[contains(text(),'Work Complete')]")
  WebElement      workCompleteBtn;

  @FindBy(xpath = "//button[contains(text(),'Pending Review')]")
  WebElement      pendingReviewBtn;

  @FindBy(xpath = "//button[contains(text(),'On Hold')]")
  WebElement      onHoldBtn;

  @FindBy(xpath = "//button[contains(text(),'Closed Complete')]")
  WebElement      closedCompleteBtn;

  @FindBy(xpath = "//button[contains(text(),'Cancel')]")
  WebElement      cancelBtn;

  @FindBy(xpath = "//*[contains(text(),'Closed Cancelled')]")
  WebElement      closedCancelledLabel;

  @FindBy(xpath = "//*[contains(text(),'Closed Complete')]")
  WebElement      closedCompleteLabel;



  @FindBy(xpath = "//button[contains(text(),'Assign to me')]")
  WebElement      assignToMeBtn;

  @FindBy(xpath = "//input[@id='sys_display.x_nuvo_eam_clinical_work_orders.assigned_to']")
  WebElement      assignToTxtFiled;

  @FindBy(xpath = "//input[contains(@id, 'sys_readonly.x_nuvo_eam_clinical_work_orders.number')]")
  WebElement      workOrderNumber;

  @FindBy(xpath = "//a[@class='breadcrumb_link']")
  WebElement      allOrdersLink;

  @FindBy(xpath = "//select[@class='form-control default-focus-outline']")
  WebElement      allSelectFilter;

  @FindBy(xpath = "(//input[@class='form-control'])[1]")
  WebElement      allSearchBox;

  @FindBy(xpath = "//a[@class='linked formlink']")
  WebElement      searchRecord;


  @FindBy(xpath = "(//*[contains(@class,'tabs2_tab default-focus-outline')])[1]")
  WebElement      detailsTab;

  @FindBy(xpath = "(//*[contains(@class,'tabs2_tab default-focus-outline')])[2]")
  WebElement      resolutionTab;


  @FindBy(xpath = "(//*[contains(@class,'tabs2_tab default-focus-outline')])[3]")
  WebElement      financialTab;


  @FindBy(xpath = "(//*[contains(@class,'tabs2_tab default-focus-outline')])[4]")
  WebElement      scheduleTab;


  @FindBy(xpath = "(//*[contains(@class,'tabs2_tab default-focus-outline')])[5]")
  WebElement      variablesTab;

  @FindBy(xpath = "(//*[contains(@class,'tabs2_tab default-focus-outline')])[6]")
  WebElement      vendorTab;


  @FindBy(xpath = "//*[@id='sys_display.x_nuvo_eam_clinical_work_orders.substate']")
  WebElement      subState;


  @FindBy(xpath = "//*[@id='x_nuvo_eam_clinical_work_orders.u_estimated_return_date']")
  WebElement      estimatedReturnTo;


  @FindBy(
      xpath = "//span[contains(text(),'The following mandatory fields are not filled in: Substate, Estimated Return to Service')]")
  WebElement      EstimatedReturnToService_ErrorMsg;


  @FindBy(xpath = "//input[@id='sys_display.x_nuvo_eam_clinical_work_orders.resolution_code']")
  WebElement      resolutionCode;

  @FindBy(xpath = "//input[@id='sys_display.x_nuvo_eam_clinical_work_orders.problem_cause']")
  WebElement      problemCause;


  @FindBy(xpath = "//*[@id='x_nuvo_eam_clinical_work_orders.resolution_detail']")
  WebElement      resolutionDetails;

  @FindBy(xpath = "//*[@id='x_nuvo_eam_clinical_work_orders.external_technician']")
  WebElement      externalTechnicianName;

  @FindBy(xpath = "//*[@id='label.ni.x_nuvo_eam_clinical_work_orders.external_technician_flag']")
  WebElement      externalTechnicianChkbox;

  @FindBy(xpath = "//*[@id='output_messages']/div/div[2]")
  WebElement      workOrderCompleteErrorMessage;

  @FindBy(xpath = "//*[@id='output_messages']/div/div")
  WebElement      itemizedcostErrorMessage;

  @FindBy(xpath = "//*[@id='x_nuvo_eam_clinical_work_orders.priority']")
  WebElement      priority;

  @FindBy(xpath = "//li[@class='h-card h-card_md h-card_comments']")
  WebElement      activitiesDetails;

  @FindBy(xpath = "//*[@id='lookup.x_nuvo_eam_clinical_work_orders.assigned_to']")
  WebElement      assignedToLookUp;

  @FindBy(xpath = "(//td/a)[1]")
  WebElement      selectingFirstResult;

  @FindBy(xpath = "//select[contains(@class,'outline')]")
  WebElement      searchDropdown;

  @FindBy(xpath = "(//select[contains(@class,'outline')])[2]")
  WebElement      searchDropdownWorkOrder;


  @FindBy(xpath = "(//input[@class='form-control'])[1]")
  WebElement      numberSearchTextbox;

  @FindBy(xpath = "//td//a[contains(@href,'devices')]")
  WebElement      numberAfterSrch;


  @FindBy(xpath = "(//input[@class='form-control'])[2]")
  WebElement      workOrderSearchTextbox;


  @FindBy(xpath = "(//td//a[contains(@href,'work_orders')])[2]")
  WebElement      workOrderNumberAfterSrch;


  @FindBy(xpath = "//*[@id='allApps_tab']")
  WebElement      allApplicationsTab;


  @FindBy(
      xpath = "(//*[@id='x_nuvo_eam_clinical_work_orders.work_start.ui_policy_sensitive']/span)[3]")
  WebElement      actualStartCaleder;

  @FindBy(xpath = "//button[@id='GwtDateTimePicker_ok']")
  WebElement      selectDateCheckMark;


  @FindBy(
      xpath = "(//*[@id='x_nuvo_eam_clinical_work_orders.work_end.ui_policy_sensitive']/span)[3]")
  WebElement      actualEndCaleder;


  @FindBy(
      xpath = "(//*[@id='x_nuvo_eam_clinical_work_orders.planned_start.ui_policy_sensitive']/span)[3]")
  WebElement      planStartDateCaleder;



//******************FAMA LOCATORS*****************************************
  //Added for FAMA_WokOrders Validations--Sree
  @FindBy(id="lookup.x_nuvo_eam_clinical_work_orders.work_order_type")
  WebElement workOrderTypeLookup;

  @FindBy(xpath="//input[contains(@id,'text')]")
  WebElement wrkOrdLookupSearch;

  @FindBy(xpath="(//input[@id='x_nuvo_eam_work_order_type_table_header_search_control'])[1]")
  WebElement searchInTypeGrid;

  @FindBy(id="lookup.x_nuvo_eam_clinical_work_orders.substate")
  WebElement workOrderSubStateLookup;

 // @FindBy(xpath="(//input[@id=' x_nuvo_eam_work_order_substate_table_header_search_control'])[1]")
  @FindBy(xpath="(//input[@id=' x_nuvo_eam_work_order_substate_table_header_search_control'])[2]")
   WebElement searchInSubStateGrid;

  @FindBy(id="lookup.x_nuvo_eam_clinical_work_orders.u_issue_category")
  WebElement issueCategtoryLookup;

  @FindBy(xpath="(//input[@id='x_nuvo_eam_symptoms_table_header_search_control'])[1]")
  WebElement searchInTypeIssueCategoryGrid;

  @FindBy(id="lookup.x_nuvo_eam_work_order_itemize_cost.service_activity")
  WebElement localJobCodeLookup;

  @FindBy(xpath="(//input[@id='x_nuvo_eam_work_order_service_activities_table_header_search_control'])[1]")
  WebElement searchInLocalJobCodeGrid;

  @FindBy(id="lookup.x_nuvo_eam_clinical_work_orders.problem_cause")
  WebElement problemCauseLookup;

  @FindBy(xpath="(//input[@id='x_nuvo_eam_problem_cause_table_header_search_control'])[1]")
  WebElement searchInProblemCauseGrid;

  @FindBy(xpath="//select[contains(@id,'select')]")
  WebElement wrkOrdLookupSearchBy;

  @FindBy(xpath="(//input[@aria-label='Search column: short description'])[1]")
  WebElement shortDescriptionSearch;

  @FindBy(id="lookup.x_nuvo_eam_clinical_work_orders.resolution_code")
  WebElement resolutionCodeLookup;

  @FindBy(xpath="(//input[@id='x_nuvo_eam_resolution_code_table_header_search_control'])[1]")
  WebElement searchInResolutionCodesGrid;

//***************End of FAMA ********************************************

  // *********Footer Bottom Work order Related Links***************

  @FindBy(xpath = "(//*[contains(text(),'Work Order Itemized Costs')])[1]")
  WebElement      workOrderItemizedCostsTab;

  @FindBy(xpath = "(//*[contains(text(),'Verification Data')])[1]")
  WebElement      verificationDataTab;


  @FindBy(xpath = "(//*[contains(text(),'Verification Data (1)')])[1]")
  WebElement      verificationDataTabAfterCheckList;

  @FindBy(xpath = "(//span[contains(text(),'Tools')])[1]")
  WebElement      toolsTab;

  @FindBy(xpath = "(//span[contains(text(),'Related Knowledge')])[1]")
  WebElement      relatedKnowledgeTab;

  @FindBy(xpath = "(//span[contains(text(),'Clinical Work Order Tasks')])[1]")
  WebElement      clinicalWorkOrderTasksTab;

  @FindBy(xpath = "(//span[contains(text(),'Clinical Purchase Requisitions')])[1]")
  WebElement      ClinicalPurchaseRequisitionsTab;

  @FindBy(xpath = "(//span[contains(text(),'Clinical Purchase Requisitions (1)')])[1]")
  WebElement      ClinicalPurchaseReqTabAfterCreatingNew;

  @FindBy(xpath = "(//span[contains(text(),'Clinical Transfer Orders')])[1]")
  WebElement      ClinicalTransferOrdersTab;

  @FindBy(xpath = "(//span[contains(text(),'Asset Metrics')])[1]")
  WebElement      assetMetricsTab;

  @FindBy(xpath = "(//span[contains(text(),'Contract Coverage')])[1]")
  WebElement      contractCoverageTab;

  @FindBy(xpath = "(//span[contains(text(),'Work Order SLA')])[1]")
  WebElement      workOrderSLATab;
  // ------------------------------------------------------------------
  @FindBy(xpath = "(//span[contains(text(),'Related Work Orders')])[1]")
  WebElement      relatedWorkOrdersTab;

  @FindBy(xpath = "(//span[contains(text(),'Upcoming Maintenances')])[1]")
  WebElement      upcomingMaintenancesTab;

  @FindBy(xpath = "(//*[contains(text(),'Clinical Work Order Parts')])[1]")
  WebElement      clinicalWorkOrderPartsTab;

  @FindBy(xpath = "(//*[contains(text(),'Clinical Work Order Skills')])[1]")
  WebElement      clinicalWorkOrderSkillsTab;

  @FindBy(xpath = "(//*[contains(text(),'Measurement Uncertainty Budget Worksheets')])[1]")
  WebElement      MeasurementUncertaintyBudgetWorksheetsTab;

  @FindBy(xpath = "(//*[contains(text(),'Asset Vulnerabilities')])[1]")
  WebElement      assetVulnerabilitiesTab;

  @FindBy(xpath = "(//*[contains(text(),'Approvers')])[1]")
  WebElement      approversTab;

  @FindBy(xpath = "(//*[contains(text(),'Work Order Reassignments')])[1]")
  WebElement      workOrderReassignmentsTab;


  @FindBy(xpath = "//select[@id='sys_select.x_nuvo_eam_work_order_itemize_cost.type']")
  WebElement      itemize_CostType;

  @FindBy(xpath = "//*[@id='lookup.x_nuvo_eam_work_order_itemize_cost.u_parts']")
  WebElement      clickOnThePartsLookUp;

  @FindBy(xpath = "//input[@id='x_nuvo_eam_work_order_itemize_cost.quantity']")
  WebElement      partsQuantity;

  @FindBy(xpath = "//*[@id='x_nuvo_eam_work_order_itemize_cost.summary']")
  WebElement      ItemizedCostSummary;

  @FindBy(xpath = "//input[@id='sys_display.x_nuvo_eam_work_order_itemize_cost.u_parts']")
  WebElement      PartsName;

  @FindBy(xpath = "//*[@id='label.ni.x_nuvo_eam_work_order_itemize_cost.inventoried_part']")
  WebElement      deselectInventoriedPart;

  @FindBy(xpath = "//*[@id='x_nuvo_eam_work_order_itemize_cost.part_description']")
  WebElement      partDescription;

  @FindBy(xpath = "//*[@id='x_nuvo_eam_work_order_itemize_cost.price_per_unit.display']")
  WebElement      pricePerUnit;

  @FindBy(xpath = "//*[@id='sys_display.x_nuvo_eam_work_order_itemize_cost.service_activity']")
  WebElement      localJobCode;

  @FindBy(xpath ="//div[contains(@id,'list_nav_x_nuvo_eam_clinical_work_orders.x_nuvo_eam_clinical_purchase_order.work_order') and contains(@class,'navbar navbar-default list_nav list_nav_top  list_nav_top_border')]//button[.='New']")
  WebElement      clinicalPurchaseReqNewButton;


  @FindBy(xpath="//input[@id='x_nuvo_eam_clinical_purchase_order.external_po_number']")
  WebElement externalPO_Number;


  @FindBy(xpath="//input[@id='x_nuvo_eam_clinical_purchase_order.short_description']")
  WebElement clinicalPurchaseShortDescription;

  @FindBy(xpath ="//button[@class='form_action_button  action_context btn btn-default']")
  WebElement clinicalPurchaseSubmitButton;
//
//  @FindBy(xpath ="(//select[@class='form-control default-focus-outline'])[7]")
//  WebElement clinicalPurchaseDropDown;
//
//  @FindBy(xpath ="(//input[@class='form-control'])[8]")
//  WebElement searchClicnialPONumber;

  @FindBy(xpath ="(//td//a[contains(@href,'clinical_purchase')])[2]")
  WebElement verifyClinicalPONumber;


  @FindBy(xpath= "//input[@id='sys_display.x_nuvo_eam_clinical_work_orders.work_order_type']")
  WebElement workOrderType;

  @FindBy(xpath ="(//button[contains(text(),'Working-Checklist')])[1]")
  WebElement workChecingkList;


  @FindBy(xpath="//*[@id='selectAll']")
  WebElement selectDefaultWorkOrderListCheckBox;

  @FindBy(xpath="//*[@class='onoffswitch-label']")
  WebElement enableWorkListCheckList;


  @FindBy(xpath="//*[@id='ok_button']")
  WebElement saveWorkListCheckList;

  @FindBy(xpath ="(//td//a[contains(@href,'verification_data')])[2]")
  WebElement verificationDataRecord;



  // By Locators :

  private By      byclinicalAssetmgmt    =
      By.xpath("//*[contains(text(),'Clinical Asset Management')]");

  private By      byFilter               = By.xpath("//*[@id=\"filter\"]");

  private By      byReportedBy           =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.reported_by\"]");

  private By      byAssetLocation        =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.asset_location\"]");

  private By      byWorkOrderType        = By.xpath(
      "//input[contains(@id, 'sys_display.x_nuvo_eam_clinical_work_orders.work_order_type')]");

  private By      byInitiationReason     =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.initiation_reason\"]");
  private By      byBuilding             =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.building\"]");
  private By      byFloor                =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.floor\"]");
  private By      byAssignedLocation     =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.assigned_location\"]");
  private By      byCurrentAssetLocation =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.current_asset_location\"]");

  private By      byOrderDescription     =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.order_description\"]");

  private By      byPriority             =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.priority\"]");


  private By      byAssignmentGroup      =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.assignment_group\"]");

  private By      byServiceProvider      =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.service_provider\"]");
  private By      byExternalTechnician   =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.external_technician_flag\"]");
  private By      byUnderContract        =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.under_contract\"]");
  private By      byParentWorkOrder      =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.parent\"]");
  private By      byChildWorkOrder       =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.u_child_work_order\"]");
  private By      byAssetVulnerability   =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.asset_vulnerability\"]");
  private By      byAlert                =
      By.xpath("//*[@id=\"sys_display.x_nuvo_eam_clinical_work_orders.u_alert\"]");


  // -----------------Actions----------------------------------------------------


  public NewWorkOrder_Page(WebDriver driver) throws Exception {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);
    driver.switchTo().defaultContent();
    driver.switchTo().frame(iframe);
    logger.info("Switched to New work order frame successfully");
    pageActions = new EAMMPageActions(driver);

    try {
      new WebDriverWait(driver, 20)
          .until(ExpectedConditions.visibilityOf(clinicalWorkOrderHeaderTab));
    } catch (Exception e) {
      throw new Exception("New clicnical work order page is not displayed " + e.toString());
    }

  }


  @Step("Verifying new work order page is displaying")
  public void ValidateCreateNewWorkOrderPage() {
    Assert.assertTrue(driver.getTitle().contains("create"),
        "Create New Clinical Work Order Page is not displaying");
  }


  @Step("Entering mandatory details for new work order ")
  public void validateWOMandatoryDetailsAndSaveDraft(String AssetNumber, String Issuecategory) {
    SeleniumWait.hold(GlobalVariables.mediumSleep);
    assetTxtField.clear();
    functions.highlighElement(driver, assetTxtField);
    logger.info("Entering the Assert Number");
    assetTxtField.sendKeys(AssetNumber);
    issueCategory.clear();
    logger.info("Entering the Issue category");
    functions.highlighElement(driver, issueCategory);
    issueCategory.sendKeys(Issuecategory);
    orderSummary.clear();
    logger.info("Entering the order summary");
    orderSummary.sendKeys("Automation Testing Work Order");

  }

  @Step("Verifying error message for mandatory details in new work order ")
  public void verifyErrorMessageMandatoryDetails() {

    new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(draftBtn));
    // SeleniumWait.hold(GlobalVariables.mediumSleep);
    logger.info("Clicking on draft button");
    draftBtn.click();
    Assert.assertTrue(errorMessage.isDisplayed(),
        "User is able to verify the error message for mandatory details");
  }

  @Step("Verifying clicking on draft button")
  public void clickOnDraftButton() {
    try {
      new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(draftBtn));
      // SeleniumWait.hold(GlobalVariables.mediumSleep);
      logger.info("Clicking on draft button");
      //Added on 01/12/2020
      submitBtn.click();
      //draftBtn.click();
      SeleniumWait.hold(GlobalVariables.longSleep);
      Assert.assertTrue(saveAndGoButton.isDisplayed(),
          "User is able to save the work order as a draft successfully");
    } catch (Exception e) {
      e.printStackTrace();
   //   Assert.fail("Unable to click on draft button" + e.getMessage());

    }

  }

  @Step("Verifying clicking on Submit button")
  public void clickOnSubmitButton() {
    logger.info("Clicking on Submit button");
    functions.highlighElement(driver, submitBtn);
    submitBtn.click();
    SeleniumWait.hold(GlobalVariables.mediumSleep);
    Assert.assertTrue(saveAndGoButton.isDisplayed(),
        "User is able to submit the work order successfully");
  }

  @Step("Verifying clicking on Assign To Me button")
  public void clickOnAssignToMeButton(String actualAssignee) {
    try {
      new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(assignToMeBtn));
      logger.info("Clicking on Assign To Me button");
      assignToMeBtn.click();
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      String expectedAssignee = assignToTxtFiled.getAttribute("value");
      logger.info("Work order Assigned to : " + expectedAssignee);
      Assert.assertEquals(actualAssignee, expectedAssignee,
          "User is not able to assign the wok order to himself by clicking on Assign To Me Button");
    } catch (Exception e) {
      e.printStackTrace();
   //   Assert.fail("Unable to click on Assign To Me button" + e.getStackTrace());
    }

  }


  @Step("Verifying Save & Stay functionality")
  public void verifySaveAndStayButtonFunctionality() {
    logger.info("Clicking on draft button");
    clickOnDraftButton();
    String beforeSavingWO = workOrderNumber.getAttribute("value");
    logger.info("Clicking on Save and Stay button");
    saveAndStayButton.click();
    SeleniumWait.hold(GlobalVariables.mediumSleep);
    String afterSavingWO = workOrderNumber.getAttribute("value");
    Assert.assertEquals(beforeSavingWO, afterSavingWO,
        "Save and Stay functioanlity is not working");

  }


  @Step("Verifying Save & Go functionality")
  public void verifySaveAndGoButtonFunctionality() {
    logger.info("Clicking on draft button");
    clickOnDraftButton();
    String WONumber = workOrderNumber.getAttribute("value");
    logger.info("Clicking on Save and Go button");
    saveAndGoButton.click();
    SeleniumWait.hold(GlobalVariables.mediumSleep);
    Assert.assertTrue(allOrdersLink.isDisplayed(),
        "Save & Go is not navigating to all orders page");
    verifyAllWorkOrderFilter(WONumber);

  }

  @Step("Verifying newly save work order is diplaying in the ALL orders search results ")
  public void verifyAllWorkOrderFilter(String WONumber) {
    logger.info("Entering Work order number in search box");
    allSearchBox.sendKeys(WONumber);
    allSearchBox.sendKeys(Keys.RETURN);
    Assert.assertTrue(searchRecord.isDisplayed());
    logger.info("Verified Newly created work order in All Work orders page");

  }

  @Step("Verifying Details Tab is available in new work order page")
  public boolean verifyDetailsTabIsAvailable() {
    return detailsTab.isDisplayed();
  }

  @Step("Verifying Resolutions Tab is available in new work order page")
  public boolean verifyResolutionTabIsAvailable() {
    return resolutionTab.isDisplayed();
  }

  @Step("Verifying Financial Tab is available in new work order page")
  public boolean verifyFinancialTabIsAvailable() {
    return financialTab.isDisplayed();
  }

  @Step("Verifying Schedule Tab is available in new work order page")
  public boolean verifyScheduleTabIsAvailable() {
    return scheduleTab.isDisplayed();
  }

  @Step("Verifying variables Tab is available in new work order page")
  public boolean verifyVariablesTabIsAvailable() {
    return variablesTab.isDisplayed();
  }


  @Step("Verifying Vendors Tab is available in new work order page")
  public boolean verifyVendorTabIsAvailable() {
    return vendorTab.isDisplayed();
  }



  @Step("Verifying draft Tab is available in new work order page")
  public boolean isveriyDraftTabExist() {
    return draftTab.isDisplayed();
  }

  @Step("Verifying pendingAssignmentTab is available in new work order page")
  public boolean isPendingAssignmentTabExist() {
    return pendingAssignmentTab.isDisplayed();
  }

  @Step("Verifying pendingAcceptanceTab is available in new work order page")
  public boolean isPendingAcceptanceTabExist() {
    return pendingAcceptanceTab.isDisplayed();
  }

  @Step("Verifying readyForWorkTab is available in new work order page")
  public boolean isReadyForWorkTabExist() {
    return readyForWorkTab.isDisplayed();
  }


  @Step("Verifying onHoldTab is available in new work order page")
  public boolean isOnHoldTabExist() {
    return onHoldTab.isDisplayed();
  }


  @Step("Verifying pendingReviewTab is available in new work order page")
  public boolean isPendingReviewTabExist() {
    return pendingReviewTab.isDisplayed();
  }


  @Step("Verifying cosedTab is available in new work order page")
  public boolean isCosedTabExist() {
    return cosedTab.isDisplayed();
  }


  @Step("Verifying pendingAssignmentBtn is available in new work order page")
  public boolean isPendingAssignmentBtnAvalable() {
    return pendingAssignmentBtn.isDisplayed();
  }

  @Step("Verifying pendingAcceptanceBtn is available in new work order page")
  public boolean isPendingAcceptanceBtnAvalable() {
    return pendingAcceptanceBtn.isDisplayed();
  }

  @Step("Verifying workInProgressBtn is available in new work order page")
  public boolean isWorkInProgressBtnAvalable() {
    return workInProgressBtn.isDisplayed();
  }

  @Step("Verifying pendingAssignmentBtn is available in new work order page")
  public boolean isOnHoldBtnAvalable() {
    return onHoldBtn.isDisplayed();
  }

  @Step("Verifying closedCompleteBtn is available in new work order page")
  public boolean isClosedCompleteBtnAvalable() {
    return closedCompleteBtn.isDisplayed();
  }

  public void createNewWorkOrder_OnHoldErrorMessage(String AssetNumber, String Issuecategory) {
    validateWOMandatoryDetailsAndSaveDraft(AssetNumber, Issuecategory);
    onHoldBtn.click();
    logger.info("Clicked on OnHold button");
    Assert.assertTrue(EstimatedReturnToService_ErrorMsg.isDisplayed(),
        "substate and Estimated Return to Service error message is not displaying");

  }

  @Step("Validating the Resolution Details")
  public void validateResolutionDetails() {
    try {
      SeleniumWait.hold(GlobalVariables.ShortSleep);
      pageActions.scrollthePage(resolutionTab);
      new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(resolutionTab));
      resolutionTab.click();
      resolutionCode.clear();
      resolutionCode.sendKeys("Service, Normal");
      problemCause.clear();
      problemCause.sendKeys("Equipment, Damage");
      resolutionDetails.clear();
      resolutionDetails.sendKeys("Automation script_ResolutionDetails");
    } catch (Exception e) {
      e.printStackTrace();
  //    Assert.fail("Unable to enter the resolution details under Resolution tab " + e.getMessage());
    }

  }

  @Step("Validating the Schedule Date Details")
  public void validateScheduleDateDetails() {
    pageActions.scrollthePage(scheduleTab);
    scheduleTab.click();
    actualStartCaleder.click();
    SeleniumWait.hold(GlobalVariables.ShortSleep);
    logger.info("Entered actual start date");
    selectDateCheckMark.click();
    SeleniumWait.hold(GlobalVariables.ShortSleep);
    actualEndCaleder.click();
    SeleniumWait.hold(GlobalVariables.ShortSleep);
    logger.info("Entered actual End date");
    selectDateCheckMark.click();
    SeleniumWait.hold(GlobalVariables.ShortSleep);
    planStartDateCaleder.click();
    logger.info("Entered plan start date");
    selectDateCheckMark.click();
    SeleniumWait.hold(GlobalVariables.ShortSleep);

  }



  public void clickingOnItemizedCost() {
    try {
      SeleniumWait.hold(GlobalVariables.longSleep);
  new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(itemizedCostsButton));
 itemizedCostsButton.click();
 logger.info("Clicked on Itemized cost button");
 SeleniumWait.hold(GlobalVariables.mediumSleep);
 driver.switchTo().frame(itemizedFrame);
 logger.info("Switched to ItemizedCost Frame successfully");
 new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(itemizedSubmitButton));
    } catch (Exception e) {

      e.printStackTrace();
    }

  }



  @Step("Validating Itemized cost details for different Types")
  public void enterItemizedCostsDetails(String ItemizedCostType) {
    try {
//      Select select;
//      new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(itemizedCostsButton));
//      itemizedCostsButton.click();
//      logger.info("Clicked on Itemized cost button");
//      SeleniumWait.hold(GlobalVariables.mediumSleep);
//      driver.switchTo().frame(itemizedFrame);
//      logger.info("Switched to ItemizedCost Frame successfully");
//      new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(itemizedSubmitButton));

      if (ItemizedCostType.contains("LocalJobCode")) {
        clickingOnItemizedCost();
        pageActions.selectDropDown(itemize_CostType, "Local Job Code");
        localJobCode.sendKeys("Dynamic Segmentation");
        itemizedMinutes.click();
        itemizedMinutes.clear();
        functions.highlighElement(driver, itemizedMinutes);
        itemizedMinutes.sendKeys("6");
        logger.info("Enterd itemizedMinutes");
        itemizedHours.clear();
        functions.highlighElement(driver, itemizedHours);
        itemizedHours.sendKeys("1");
        logger.info("Entered itemizedHours");
        clickOnCalender.click();
        logger.info("Clicked calender icon");
        SeleniumWait.hold(GlobalVariables.ShortSleep);
        selectDate.click();
        logger.info("Selected the date and time");
        SeleniumWait.hold(GlobalVariables.ShortSleep);
        itemizedSubmitButton.click();
        SeleniumWait.hold(GlobalVariables.ShortSleep);
        driver.switchTo().frame(iframe);
        logger.info("Switched to Service Now Frame");
      }


      if (ItemizedCostType.contains("Inventoried")) {
        clickingOnItemizedCost();
        pageActions.selectDropDown(itemize_CostType, "Parts");
        clickOnThePartsLookUp.click();
        functions.switchToWindow(driver, 1);
        pageActions.clickAt(selectingFirstResult,
            "Clicked on the first part from the search result");
        SeleniumWait.hold(GlobalVariables.mediumSleep);
        functions.switchToWindow(driver, 0);
        driver.switchTo().frame(iframe);
        driver.switchTo().frame(itemizedFrame);
        partsQuantity.sendKeys("1");
        ItemizedCostSummary.sendKeys("Automation Test Entered Itemized cost:Parts Details");
        itemizedSubmitButton.click();
        logger.info("Clicked on Itemized submit button");
        SeleniumWait.hold(GlobalVariables.ShortSleep);
        driver.switchTo().frame(iframe);
        logger.info("Switched to Service Now Frame");
      }


      if (ItemizedCostType.contains("FeeForService")) {
        clickingOnItemizedCost();
        pageActions.selectDropDown(itemize_CostType, "Fee For Service");
        ItemizedCostSummary.sendKeys("Automation Test Entered Itemized cost:Fee For Service");
        itemizedSubmitButton.click();
        SeleniumWait.hold(GlobalVariables.ShortSleep);
        driver.switchTo().frame(iframe);
        logger.info("Switched to Service Now Frame");
      }


      if (ItemizedCostType.contains("Lodging")) {
        clickingOnItemizedCost();
        pageActions.selectDropDown(itemize_CostType, "Lodging");
        ItemizedCostSummary.sendKeys("Automation Test Entered Itemized cost:Lodging");
        itemizedSubmitButton.click();
        SeleniumWait.hold(GlobalVariables.ShortSleep);
        driver.switchTo().frame(iframe);
        logger.info("Switched to Service Now Frame");
      }

      if (ItemizedCostType.contains("Meals")) {
        clickingOnItemizedCost();
        pageActions.selectDropDown(itemize_CostType,"Meals");
        ItemizedCostSummary.sendKeys("Automation Test Entered Itemized cost:Meals");
        itemizedSubmitButton.click();
        SeleniumWait.hold(GlobalVariables.ShortSleep);
        driver.switchTo().frame(iframe);
        logger.info("Switched to Service Now Frame");
      }


      if (ItemizedCostType.contains("Parts")) {
        clickingOnItemizedCost();
        pageActions.selectDropDown(itemize_CostType,"Parts");
        if (deselectInventoriedPart.isEnabled()) {
          deselectInventoriedPart.click();
        }
        partDescription.clear();
        partDescription.sendKeys("AutomationPart");
        pricePerUnit.clear();
        pricePerUnit.sendKeys("10");
        partsQuantity.sendKeys("1");
        ItemizedCostSummary.sendKeys("Automation Test Entered Itemized cost:Parts Details");
        itemizedSubmitButton.click();
        SeleniumWait.hold(GlobalVariables.ShortSleep);
        logger.info("Clicked on Itemized submit button");
        driver.switchTo().frame(iframe);
        logger.info("Switched to Service Now Frame");
      }

      if (ItemizedCostType.contains("Labor")) {
        clickingOnItemizedCost();
        itemizedMinutes.clear();
        functions.highlighElement(driver, itemizedMinutes);
        itemizedMinutes.sendKeys("6");
        logger.info("Enterd itemizedMinutes");
        itemizedHours.clear();
        functions.highlighElement(driver, itemizedHours);
        itemizedHours.sendKeys("1");
        logger.info("Entered itemizedHours");
        clickOnCalender.click();
        logger.info("Clicked calender icon");
        SeleniumWait.hold(GlobalVariables.ShortSleep);
        selectDate.click();
        logger.info("Selected the date and time");
        SeleniumWait.hold(GlobalVariables.ShortSleep);
        itemizedSubmitButton.click();
        SeleniumWait.hold(GlobalVariables.ShortSleep);
        driver.switchTo().frame(iframe);
        logger.info("Switched to Service Now Frame");
      }

      if (ItemizedCostType.contains("Travel")) {
        clickingOnItemizedCost();
        pageActions.selectDropDown(itemize_CostType,"Travel");
        itemizedMinutes.clear();
        functions.highlighElement(driver, itemizedMinutes);
        itemizedMinutes.sendKeys("6");
        logger.info("Enterd itemizedMinutes");
        itemizedHours.clear();
        functions.highlighElement(driver, itemizedHours);
        itemizedHours.sendKeys("1");
        logger.info("Entered itemizedHours");
        clickOnCalender.click();
        logger.info("Clicked calender icon");
        SeleniumWait.hold(GlobalVariables.ShortSleep);
        selectDate.click();
        logger.info("Selected the date and time");
        SeleniumWait.hold(GlobalVariables.ShortSleep);
        itemizedSubmitButton.click();
        SeleniumWait.hold(GlobalVariables.ShortSleep);
        driver.switchTo().frame(iframe);
        logger.info("Switched to Service Now Frame");
      }


    } catch (Exception e) {
      e.printStackTrace();
   //   Assert.fail("Unable to enter the itemized cost details" + e.getMessage());
    }

  }


  @Step("Validating the Itemized Cost for Labor")
  public void enterItemizedCosts() {
    try {
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      itemizedCostsButton.click();
      logger.info("Clicked on Itemized cost button");
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      driver.switchTo().frame(itemizedFrame);
      new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(itemizedMinutes));
      itemizedMinutes.clear();
      functions.highlighElement(driver, itemizedMinutes);
      itemizedMinutes.sendKeys("4");
      logger.info("Enterd itemizedMinutes");
      itemizedHours.clear();
      functions.highlighElement(driver, itemizedHours);
      itemizedHours.sendKeys("5");
      logger.info("Entered itemizedHours");
      clickOnCalender.click();
      logger.info("Clicked calender icon");
      SeleniumWait.hold(GlobalVariables.ShortSleep);
      selectDate.click();
      logger.info("Selected the date and time");
      SeleniumWait.hold(GlobalVariables.ShortSleep);
      itemizedSubmitButton.click();
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      driver.switchTo().frame(iframe);
      logger.info("Switch back to servcie now iframe");
    } catch (Exception e) {
      e.printStackTrace();
  //    Assert.fail("Unable to enter the itemized cost details" + e.getMessage());

    }


  }

  @Step("Assign the WorkOrder to same user and enter itemized details")
  public void validateAssignToMe_ItemizedCosts(String AssetNumber, String Issuecategory,
      String ItemizedCostType) {
    validateWOMandatoryDetailsAndSaveDraft(AssetNumber, Issuecategory);
    assignToMeBtn.click();
    new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(workInProgressBtn));
    workInProgressBtn.click();
    logger.info("Clicked on Work in progress button");
    SeleniumWait.hold(GlobalVariables.ShortSleep);
    enterItemizedCostsDetails(ItemizedCostType);

//    Assert.assertTrue(draftBtn.isDisplayed(), "Error while entering itemized cost details");
  }

  @Step("Validating Work order to OnHold Status")
  public void createNewWorkOrder_OnHold(String AssetNumber, String Issuecategory) {
    validateWOMandatoryDetailsAndSaveDraft(AssetNumber, Issuecategory);
    assignToMeBtn.click();
    logger.info("Clicked on Assinged to me button");
    pageActions.doubleClick(workCompleteBtn, "Clicked on Work Complete Button");
    onHoldBtn.click();
    logger.info("Clicked on onHold button");
    SeleniumWait.hold(GlobalVariables.ShortSleep);
    subState.sendKeys("Pending vendor support");
    estimatedReturnTo.sendKeys("2020-09-31");
    pageActions.doubleClick(onHoldBtn, "Clicked on Hold Button");
    Assert.assertTrue(estimatedReturnTo.isDisplayed(), "Error while moving WO to OnHold status ");

  }


  public void verifyClickingOnCompleteWorkOrderButton() {
    pageActions.doubleClick(workCompleteBtn, "Clicked on Work Complete button");
    // workCompleteBtn.click();
    // SeleniumWait.hold(GlobalVariables.ShortSleep);
//    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(pendingReviewBtn));
 //   functions.highlighElement(driver, pendingReviewBtn);
  //  Assert.assertTrue(pendingReviewBtn.isDisplayed(), "Unable to complete the work order");
  }



  public void validateExternalTechnician() {
    try {
      if (!externalTechnicianChkbox.isSelected()) {
        externalTechnicianChkbox.click();
        logger.info("Clicking on the external technician check box");
        externalTechnicianName.clear();
        externalTechnicianName.sendKeys("ExternalTechnician Name");
        logger.info("Entered external ExternalTechnician name");
      }
      else {
        externalTechnicianName.clear();
        externalTechnicianName.sendKeys("ExternalTechnician Name");
        logger.info("Entered external ExternalTechnician name");
      }
    } catch (Exception e) {
      e.printStackTrace();
 //     Assert.fail("Unable to select external technican check box and enter the details");
    }

  }



  public void verifyClickingOnCancelButton() {
    pageActions.doubleClick(cancelBtn, "Clicked on Canel button");
    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(closedCancelledLabel));
    Assert.assertTrue(closedCancelledLabel.isDisplayed(), "Unable to cancel the work order");
  }

  public void verifyClickingOnClosedCompleteButton() {
    pageActions.doubleClick(closedCompleteBtn, "Clicked on Closed Complete button");
    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(closedCompleteLabel));
    Assert.assertTrue(closedCompleteLabel.isDisplayed(), "Unable to close complete the work order");
  }


  public void verifyClickingOnWorkCompleteButton() {
    pageActions.doubleClick(workCompleteBtn, "Clicked on Work Complete Button");
    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(closedCompleteLabel));
    Assert.assertTrue(itemizedcostErrorMessage.isDisplayed(),
        "Itemized cost details error message is not displaying");
  }


  public void validateWorkOrderPriority(String value) {
    Select select = new Select(priority);
    select.selectByValue(value);
    logger.info("Selected priority as Medium");
    pageActions.doubleClick(workInProgressBtn, "Clicked on Work Complete Button");

  }

  public void verifyActivityDetails() {
    try {
      clickOnSubmitButton();
      new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(activitiesDetails));
      if (activitiesDetails.isDisplayed()) {
        Assert.assertTrue(activitiesDetails.isDisplayed(), "Activities are not displaying");
        logger.info("Activities details are displaying");
      }
      else {
        logger.info("submit button did not get clicked");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }


  public void workOrderFlowBetweenUsers() throws Exception {
    String captureWorkOrderNumber = workOrderNumber.getAttribute("value");
    pageActions.clickAt(assignedToLookUp, "Clicked on the assinged to lookup");
    functions.switchToWindow(driver, 1);
    pageActions.clickAt(selectingFirstResult, "Clicked on the assinged user from the search");
    functions.switchToWindow(driver, 0);
    SeleniumWait.hold(GlobalVariables.mediumSleep);
    driver.switchTo().frame(iframe);
    String assingedToUser = assignToTxtFiled.getAttribute("value");
    clickOnSubmitButton();
    namp.set_impersonateUser(driver, assingedToUser);
    SeleniumWait.hold(GlobalVariables.mediumSleep);
    allApplicationsTab.click();
    namp.goto_CAM_IventoryLinks(driver, "My Work Orders");
    SeleniumWait.hold(GlobalVariables.mediumSleep);
    driver.switchTo().frame(iframe);
    SeleniumWait.hold(GlobalVariables.ShortSleep);
    searchByNumber(captureWorkOrderNumber);
    verifyClikingOntheNumber();
    SeleniumWait.hold(GlobalVariables.mediumSleep);
    searchByWorkOrderNumber(captureWorkOrderNumber);
    verifyClikingOnWorkOrderNumber();

  }

  public void searchByNumber(String workOrderNumber) throws Exception {
    try {
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(searchDropdown));
      logger.info("Search work order number By Number");
      pageActions.selectDropDown(searchDropdown, "Number");
      logger.info("Work Order Number entered in search box");
      Assert.assertTrue(searchDropdown.isEnabled());
      Actions act = new Actions(driver);
      functions.highlighElement(driver, numberSearchTextbox);
      numberSearchTextbox.sendKeys(workOrderNumber);
      act.sendKeys(Keys.ENTER).build().perform();
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      logger.info("WorkOrder number is : " + workOrderNumber);
    } catch (Exception e) {
      e.printStackTrace();
  //    Assert.fail("Failed : SearchByNumber for asset for new assigned user");

    }
  }


  public void searchByWorkOrderNumber(String workOrderNumber) throws Exception {
    try {
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      JavascriptExecutor executor = (JavascriptExecutor) driver;
      executor.executeScript("arguments[0].scrollIntoView(true);", searchDropdownWorkOrder);
      logger.info("Scroll down the page to view the asset work orders");
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(searchDropdownWorkOrder));
      logger.info("Search work order number By Number");
      pageActions.selectDropDown(searchDropdownWorkOrder, "Number");
      logger.info("Work Order Number entered in search box");
      Assert.assertTrue(searchDropdownWorkOrder.isEnabled());
      Actions act = new Actions(driver);
      functions.highlighElement(driver, workOrderSearchTextbox);
      workOrderSearchTextbox.sendKeys(workOrderNumber);
      act.sendKeys(Keys.ENTER).build().perform();
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      logger.info("WorkOrder number is : " + workOrderNumber);
    } catch (Exception e) {
      e.printStackTrace();
//      Assert.fail("Failed : workOrderSearchTextbox");

    }
  }


  public void verifyClikingOntheNumber() {
    try {
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      functions.highlighElement(driver, numberAfterSrch);
      SeleniumWait.hold(GlobalVariables.ShortSleep);
      pageActions.clickAt(numberAfterSrch,
          "Clicked on the searched asset corresponding to work order number");
    } catch (Exception e) {
      e.printStackTrace();
  //    Assert.fail("Failed : Unable to click asset corresponding to work order number");
    }

  }


  public void verifyClikingOnWorkOrderNumber() {
    try {
      functions.highlighElement(driver, workOrderNumberAfterSrch);
      pageActions.clickAt(workOrderNumberAfterSrch, "Clicked on the searched work order number");
    } catch (Exception e) {
      e.printStackTrace();
  //    Assert.fail("Failed : Unable to click on the  WorkOrder number in the search results screen");
    }

  }

  public void completeWorkOrder() {
    enterItemizedCosts();
    validateResolutionDetails();
    validateScheduleDateDetails();
    verifyClickingOnCompleteWorkOrderButton();

  }

  public void validateAssignedWorkOrders(String workOrderAction, String ItemizedCost) {
    try {
      workOrderFlowBetweenUsers();

      if (workOrderAction.equals("WorkInProgress")) {
        pageActions.doubleClick(workInProgressBtn,
            "Clicked on Work In Progress button, Work order moved to Workinprogress Status");
      }
      if (workOrderAction.equals("ItemizedCostDetails")) {
        SeleniumWait.hold(GlobalVariables.mediumSleep);
        enterItemizedCosts();
      }
      if (workOrderAction.equals("CompleteWorkOrder")) {
        enterItemizedCostsDetails(ItemizedCost);
        //enterItemizedCosts();
        validateResolutionDetails();
        validateScheduleDateDetails();
        verifyClickingOnCompleteWorkOrderButton();
      }
      if (workOrderAction.equals("ExternalTechnicianToCompleteWorkOrder")) {
        enterItemizedCostsDetails(ItemizedCost);
       // enterItemizedCosts();
        validateResolutionDetails();
        validateScheduleDateDetails();
        validateExternalTechnician();
        verifyClickingOnCompleteWorkOrderButton();
      }
    } catch (Exception e) {
      e.printStackTrace();

    }

  }

  // ---------------------Footer Work Order Related links verification-------------------------------------------------------------------
  @Step("Verifying workOrderItemizedCostsTab is available bottom of the new work order page under related links")
  public boolean isworkOrderItemizedCostsTabAvalable() {
    SeleniumWait.hold(GlobalVariables.ShortSleep);
    pageActions.scrollthePage(workOrderItemizedCostsTab);
    SeleniumWait.hold(GlobalVariables.ShortSleep);
    functions.highlighElement(driver, workOrderItemizedCostsTab);
    return workOrderItemizedCostsTab.isDisplayed();
  }


  @Step("Verifying verificationDataTab is available bottom of the new work order page under related links")
  public boolean isverificationDataTabsTabAvalable() {
    functions.highlighElement(driver, verificationDataTab);
    return verificationDataTab.isDisplayed();
  }


  @Step("Verifying toolsTab is available bottom of the new work order page under related links")
  public boolean istoolsTabTabAvalable() {
    functions.highlighElement(driver, toolsTab);
    return toolsTab.isDisplayed();
  }

  @Step("Verifying relatedKnowledgeTab is available bottom of the new work order page under related links")
  public boolean isrelatedKnowledgeTabTabAvalable() {
    functions.highlighElement(driver, relatedKnowledgeTab);
    return relatedKnowledgeTab.isDisplayed();
  }


  @Step("Verifying clinicalWorkOrderTasksTab is available bottom of the new work order page under related links")
  public boolean isclinicalWorkOrderTasksTabTabAvalable() {
    functions.highlighElement(driver, clinicalWorkOrderTasksTab);
    return clinicalWorkOrderTasksTab.isDisplayed();
  }


  @Step("Verifying ClinicalPurchaseRequisitionsTab is available bottom of the new work order page under related links")
  public boolean isClinicalPurchaseRequisitionsTabTabAvalable() {
    functions.highlighElement(driver, ClinicalPurchaseRequisitionsTab);
    return ClinicalPurchaseRequisitionsTab.isDisplayed();
  }

  @Step("Verifying ClinicalTransferOrdersTab is available bottom of the new work order page under related links")
  public boolean isClinicalTransferOrdersTabTabAvalable() {
    functions.highlighElement(driver, ClinicalTransferOrdersTab);
    return ClinicalTransferOrdersTab.isDisplayed();
  }

  @Step("Verifying assetMetricsTab is available bottom of the new work order page under related links")
  public boolean isassetMetricsTabTabTabAvalable() {
    functions.highlighElement(driver, assetMetricsTab);
    return assetMetricsTab.isDisplayed();
  }

  @Step("Verifying contractCoverageTab is available bottom of the new work order page under related links")
  public boolean iscontractCoverageTabTabTabAvalable() {
    functions.highlighElement(driver, contractCoverageTab);
    return contractCoverageTab.isDisplayed();
  }


  @Step("Verifying workOrderSLATab is available bottom of the new work order page under related links")
  public boolean isworkOrderSLATabTabTabAvalable() {
    functions.highlighElement(driver, workOrderSLATab);
    return workOrderSLATab.isDisplayed();
  }


  @Step("Verifying relatedWorkOrdersTab is available bottom of the new work order page under related links")
  public boolean isrelatedWorkOrdersTabAvalable() {
    SeleniumWait.hold(GlobalVariables.ShortSleep);
    pageActions.scrollthePage(relatedWorkOrdersTab);
    SeleniumWait.hold(GlobalVariables.ShortSleep);
    functions.highlighElement(driver, relatedWorkOrdersTab);
    logger.info("relatedWorkOrdersTab is displaying");
    return relatedWorkOrdersTab.isDisplayed();
  }


  @Step("Verifying upcomingMaintenancesTab is available bottom of the new work order page under related links")
  public boolean isupcomingMaintenancesTabAvalable() {
    functions.highlighElement(driver, upcomingMaintenancesTab);
    logger.info("upcomingMaintenancesTab is displaying");
    return upcomingMaintenancesTab.isDisplayed();
  }

  @Step("Verifying clinicalWorkOrderPartsTab is available bottom of the new work order page under related links")
  public boolean isclinicalWorkOrderPartsTabAvalable() {
    functions.highlighElement(driver, clinicalWorkOrderPartsTab);
    logger.info("clinicalWorkOrderPartsTab is displaying");
    return clinicalWorkOrderPartsTab.isDisplayed();
  }


  @Step("Verifying clinicalWorkOrderSkillsTab is available bottom of the new work order page under related links")
  public boolean isclinicalWorkOrderSkillsTabAvalable() {
    functions.highlighElement(driver, clinicalWorkOrderTasksTab);
    logger.info("clinicalWorkOrderSkillsTab is displaying");
    return clinicalWorkOrderSkillsTab.isDisplayed();
  }


  @Step("Verifying assetVulnerabilitiesTab is available bottom of the new work order page under related links")
  public boolean isassetVulnerabilitiesTabAvalable() {
    functions.highlighElement(driver, assetVulnerabilitiesTab);
    logger.info("assetVulnerabilitiesTab is displaying");
    return assetVulnerabilitiesTab.isDisplayed();
  }

  @Step("Verifying approversTab is available bottom of the new work order page under related links")
  public boolean isapproversTabAvalable() {
    functions.highlighElement(driver, approversTab);
    logger.info("approversTab is displaying");
    return approversTab.isDisplayed();
  }

  @Step("Verifying workOrderReassignmentsTab is available bottom of the new work order page under related links")
  public boolean isworkOrderReassignmentsTabAvalable() {
    functions.highlighElement(driver, workOrderReassignmentsTab);
    logger.info("workOrderReassignmentsTab is displaying");
    return workOrderReassignmentsTab.isDisplayed();

  }
//--------------------End on Footer work order related links verification---------------------------------------------


  @Step("Creating a new Clinical Purchase Requisitions for a Work Order")
  public void verifyCreatingNewPurchaseRequistion() throws Exception {
    SeleniumWait.hold(GlobalVariables.ShortSleep);
    pageActions.scrollthePage(ClinicalPurchaseRequisitionsTab);
    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(ClinicalPurchaseRequisitionsTab));
    functions.highlighElement(driver, ClinicalPurchaseRequisitionsTab);
    pageActions.clickAt(ClinicalPurchaseRequisitionsTab, "Clicking on purchase requistions tab");
    pageActions.clickAt(clinicalPurchaseReqNewButton, "Clicking on purchase requistions New buttton");
    String randomExternalPO_Number = "Test"+Functions.getTimeStamp();
    pageActions.type(externalPO_Number, randomExternalPO_Number, "Entered Clicnical PO Number");
    clinicalPurchaseShortDescription.sendKeys("Automation externalPO_Numbner desc");
    pageActions.clickAt(clinicalPurchaseSubmitButton, "Clicking on SubmitButton");
    pageActions.clickAt(saveAndGoButton, "Clicked on save and go button");
    searchExternalPONumber();

  }

  @Step("Searching and verifying for a newly created Clinical Purchase Requisitions ")
   public void searchExternalPONumber() throws Exception {
      SeleniumWait.hold(GlobalVariables.mediumSleep);
      pageActions.scrollthePage(ClinicalPurchaseReqTabAfterCreatingNew);
      logger.info("Scroll down the page to view the ClinicalPurchaseReqTab after Creating New Record");
      new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(ClinicalPurchaseReqTabAfterCreatingNew));
      pageActions.clickAt(ClinicalPurchaseRequisitionsTab, "Clicking on purchase requistions tab");
      functions.highlighElement(driver, verifyClinicalPONumber);
      Assert.assertTrue(verifyClinicalPONumber.isDisplayed());
      logger.info("Verified newly submitted created  Clinical Purchase Requisitions record");
   }

  @Step("Selecting Work order type as Preventive Maintenance")
  public void verifyWorkOrderPreventiveMaintenance() {
    workOrderType.clear();
    workOrderType.click();
    workOrderType.sendKeys("Preventive Maintenance");
   // typeAndPressEnterKey(workOrderType, "Preventive Maintenance", "Selecting Work order type as Preventive Maintenance");
    assetTxtField.click();

  }


  public void validateCheckListforPreventiveMaintenance() throws Exception {
    pageActions.doubleClick(workInProgressBtn, "Clicked on Work InProgress button");
    pageActions.clickAt(workInProgressBtn, "Clicked on WorkOrder InProgress button");
    new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(workChecingkList));
    pageActions.clickAt(workChecingkList, "click on Work Order CheckList");
    pageActions.clickAt(selectDefaultWorkOrderListCheckBox ,"Select the Default WorkOrder List CheckBox");
    pageActions.clickAt(enableWorkListCheckList, "Enable the work order checklist");
    pageActions.clickAt(saveWorkListCheckList, "Save the WorkOrder Cheklist");
    SeleniumWait.hold(GlobalVariables.mediumSleep);
    verifyWorkOrderCheckList_VerificationData();
  }


  @Step("Searching and verifying for a newly created work order checklist under Verification Data")
  public void verifyWorkOrderCheckList_VerificationData() throws Exception {
     SeleniumWait.hold(GlobalVariables.mediumSleep);
     pageActions.scrollthePage(verificationDataTabAfterCheckList);
     logger.info("Scroll down the page to view the ClinicalPurchaseReqTab after Creating New Record");
     new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(verificationDataTabAfterCheckList));
     pageActions.clickAt(verificationDataTabAfterCheckList, "Clicking on verfication data tab");
     functions.highlighElement(driver, verificationDataRecord);
     Assert.assertTrue(verificationDataRecord.isDisplayed());
     logger.info("Verified newly submitted checklist is displaying under verification data section");
  }


//**************************FAMA Actions**************************************
//Added by Sree for FAMA_WorkOrder Validations

  @Step("Work Order Type Search Lookup")
  public boolean lookupWorkOrderTypeSearch(String searchText) {
    boolean flag = false;
    pageActions.clickAt(workOrderTypeLookup, "Clicking on Work Order Type Look Up Search");
    try {
      SeleniumWait.hold(GlobalVariables.ShortSleep);
      functions.switchToWindow(driver, 1);
      pageActions.typeAndPressEnterKey(wrkOrdLookupSearch, searchText,
          "Searching in the lookUp Window");
      new WebDriverWait(driver, 20)
          .until(ExpectedConditions.elementToBeClickable(searchInTypeGrid));
      pageActions.typeAndPressEnterKey(searchInTypeGrid, searchText,
          "Searching in the lookUp Window Grid");
      new WebDriverWait(driver, 20).until(ExpectedConditions
          .elementToBeClickable(By.xpath("//a[contains(text(),'" + searchText + "')]")));
      flag =
          driver.findElement(By.xpath("//a[contains(text(),'" + searchText + "')]")).isDisplayed();
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage());
    }
    finally {
      functions.switchToWindow(driver, 0);
    }
    return flag;
  }

//Added by Sree for FAMA_WorkOrder Validations

  @Step("Work Order Sub State Search Lookup")
  public boolean lookupWorkOrderSubStateSearch(String searchText) {
    boolean flag = false;
    pageActions.clickAt(workOrderSubStateLookup, "Clicking on Work Order Sub State Look Up Search");
    try {
      SeleniumWait.hold(GlobalVariables.ShortSleep);
      functions.switchToWindow(driver, 1);
      pageActions.typeAndPressEnterKey(wrkOrdLookupSearch, searchText,
          "Searching in the lookUp Window");
      pageActions.typeAndPressEnterKey(searchInSubStateGrid, searchText,
          "Searching in the lookUp Window Grid");
      new WebDriverWait(driver, 20).until(ExpectedConditions
          .elementToBeClickable(By.xpath("//a[contains(text(),'" + searchText + "')]")));
      flag =
          driver.findElement(By.xpath("//a[contains(text(),'" + searchText + "')]")).isDisplayed();
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage());
    }
    finally {
      functions.switchToWindow(driver, 0);
    }
    return flag;
  }

//Added by Sree for CAMA_WorkOrder Validations
  @Step("Work Order Issue Category Search Lookup")
  public boolean lookupWorkOrderIssueCategorySearch(String searchText) {
    boolean flag = false;
    pageActions.clickAt(issueCategtoryLookup, "Clicking on issue Categtory Look Up Search");
    try {
      SeleniumWait.hold(GlobalVariables.ShortSleep);
      functions.switchToWindow(driver, 1);
      pageActions.typeAndPressEnterKey(wrkOrdLookupSearch, searchText,
          "Searching in the lookUp Window");
      pageActions.typeAndPressEnterKey(searchInTypeIssueCategoryGrid, searchText,
          "Searching in the lookUp Window Grid");
      new WebDriverWait(driver, 30).until(ExpectedConditions
          .elementToBeClickable(By.xpath("//a[contains(text(),'" + searchText + "')]")));
      flag =
          driver.findElement(By.xpath("//a[contains(text(),'" + searchText + "')]")).isDisplayed();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    finally {
      functions.switchToWindow(driver, 0);
    }
    return flag;
  }

//Added by Sree for CAMA_WorkOrder Validations
  @Step("Work Order ServiceActivity Search Lookup")
  public boolean lookupWorkOrderServiceActivitySearch(String searchText) {
    boolean flag = false;
    try {
      pageActions.clickAt(assignToMeBtn, "Clicking on Assign to me button");
      pageActions.clickAt(itemizedCostsButton, "Clicking on Itemized Cost Button");
      new WebDriverWait(driver, 45)
          .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(itemizedFrame));
      logger.info("Switched to ItemizedCost Frame successfully");
      new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(itemizedSubmitButton));
      pageActions.selectDropDown(itemize_CostType, "Local Job Code");
      pageActions.clickAt(localJobCodeLookup, "Clicking on Local Job Code  Look Up Search");

      SeleniumWait.hold(GlobalVariables.ShortSleep);
      functions.switchToWindow(driver, 1);
      pageActions.selectDropDown(wrkOrdLookupSearchBy, "Short Description");
      pageActions.typeAndPressEnterKey(wrkOrdLookupSearch, searchText,
          "Searching in the lookUp Window");
      pageActions.typeAndPressEnterKey(shortDescriptionSearch, searchText,
          "Searching in the lookUp Window Grid");
      new WebDriverWait(driver, 30).until(ExpectedConditions
          .elementToBeClickable(By.xpath("//td[contains(text(),'" + searchText + "')]")));
      flag =
          driver.findElement(By.xpath("//td[contains(text(),'" + searchText + "')]")).isDisplayed();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
    finally {
      functions.switchToWindow(driver, 0);
    }
    return flag;
  }

//Added by Sree for FAMA_WorkOrder Validations
  @Step("Work Order Problem Cause Search Lookup")
  public boolean lookupWorkOrderProblemCauseSearch(String searchText) {
    boolean flag = false;
    pageActions.clickAt(resolutionTab, "Clicking on Resolution Tab");
    pageActions.clickAt(problemCauseLookup, "Clicking on Problem Cause Look Up Search");
    try {
      SeleniumWait.hold(GlobalVariables.ShortSleep);
      functions.switchToWindow(driver, 1);
      pageActions.typeAndPressEnterKey(wrkOrdLookupSearch, searchText,
          "Searching in the lookUp Window");
      pageActions.typeAndPressEnterKey(searchInProblemCauseGrid, searchText,
          "Searching in the lookUp Window Grid");
      new WebDriverWait(driver, 30).until(ExpectedConditions
          .elementToBeClickable(By.xpath("//a[contains(text(),'" + searchText + "')]")));
      flag =
          driver.findElement(By.xpath("//a[contains(text(),'" + searchText + "')]")).isDisplayed();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
    finally {
      functions.switchToWindow(driver, 0);
    }
    return flag;
  }

//Added by Sree for FAMA_WorkOrder Validations
  @Step("Work Order Resolution Code Search Lookup")
  public boolean lookupWorkOrderResolutionCodeSearch(String searchText) {
    boolean flag = false;
    pageActions.clickAt(resolutionTab, "Clicking on Resolution Tab");
    pageActions.clickAt(resolutionCodeLookup, "Clicking on Resolution Code Look Up Search");
    try {
      SeleniumWait.hold(GlobalVariables.ShortSleep);
      functions.switchToWindow(driver, 1);
      pageActions.typeAndPressEnterKey(wrkOrdLookupSearch, searchText,
          "Searching in the lookUp Window");
      pageActions.typeAndPressEnterKey(searchInResolutionCodesGrid, searchText,
          "Searching in the lookUp Window Grid");
      new WebDriverWait(driver, 40).until(ExpectedConditions
          .elementToBeClickable(By.xpath("//a[contains(text(),'" + searchText + "')]")));
      flag =
          driver.findElement(By.xpath("//a[contains(text(),'" + searchText + "')]")).isDisplayed();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
    finally {
      functions.switchToWindow(driver, 0);
    }
    return flag;
  }
//**************************End of FAMA Actions**************************************


}
