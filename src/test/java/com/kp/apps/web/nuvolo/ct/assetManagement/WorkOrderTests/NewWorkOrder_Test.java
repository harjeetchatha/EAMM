package com.kp.apps.web.nuvolo.ct.assetManagement.WorkOrderTests;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.kp.apps.web.library.GlobalVariables;
import com.kp.apps.web.library.SeleniumWait;
import com.kp.apps.web.nuvolo.application.HomePage;
import com.kp.apps.web.nuvolo.application.NuvoloAppMenu;
import com.kp.apps.web.nuvolo.ct.assetManagement.WorkOrder.NewWorkOrder_Page;
import com.kp.apps.web.nuvolo.functions.BaseTest;
import io.qameta.allure.Description;

public class NewWorkOrder_Test extends BaseTest {

  HomePage      home = new HomePage();
  NuvoloAppMenu namp = new NuvoloAppMenu();
  private Logger logger =  Logger.getLogger(NewWorkOrder_Test.class);

//*************Mile stone 9 Test cases*************
  /*CAM_NewWrkOrder_01 As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes Yes Yes No  Yes CAM_NewWrkOrder_01_TC01 Verify user is able to click on New Work order and verify Clinical Work Orders new record page is displayed     1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and verify new work order page  "User should be able taken to ""New work order"" Page and able to view the work order number
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes Yes Yes No  Yes CAM_NewWrkOrder_01_TC02 Verify user is able to enter all mdatory details and Save WorkOrder as a Draft      1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and verify user is able to save the work order as a draft   "User should be able taken to ""New work order"" Page and able to enter the mandatory details and save the work order as a draft
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes Yes Yes No  Yes CAM_NewWrkOrder_01_TC03 Verify error messages when a user trying to save the WO as Draft without entering Mandatory details     1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and verify user is not able to save the work order as a draft with out entering mandatory details   System should display error message when a user is trying to save the work order with out entering mandatory details
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes Yes No  Yes CAM_NewWrkOrder_01_TC03 CAM_NewWrkOrder_01_TC04 Verify User is able to view Draft Header, PendingAssignment Header, "PendingAcceptance Header, ReadyForWork Header, PendingReview Header and Closed Header in new work order page       1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and verify the work order states in status bar  User is able to view Draft Header, PendingAssignment Header, "PendingAcceptance Header, ReadyForWork Header, PendingReview Header and Closed Header in new work order page
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC05 Verify user is able to Submit the work order  after entering mandatory details      1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and verify user is able to submit the work order by clicking on the submit button   "User should be able taken to ""New work order"" Page and able to enter the mandatory details and Submit the work order successfully
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC06 Verify user is able to view Draft , PendingAssignment, PendingAcceptance, WorkInProgress, OnHold, Work Complete and Cancel buttons      1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Verify user is able view all the work order states  "User should be able to view all work order states:
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC07 Verify user is able to assign the work order to him self by clciking on Assign To Me  button in new work order page     1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and verify user is able to click on the Assign To Me button "User should be able taken to ""New work order"" Page and able to enter the mandatory details and assign work order to himself by clicking on the assign to me button
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC08 Verify user able to enter all the details and click on Save & Stay button for a work order      1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and click on "Save & Stay" button   User should be able to Click on the Save & Go button and Should be stay in the same work order page.
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC09 Verify Technician able to enter all the details and click on Save & Go button for a new work order      1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and click on "Save & Go" button User should be able to Click on the Save & Go button and Should be navigate to home page
  */


  /*//*************Mile stone 10 Test cases*************
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC10 Verify Technician is able to view all the sections displayed in new work order page
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC11 Verify user is able to view enter all mandatory details and click on AssignToMe button and navigate to till OnHold status
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC12 Verify Technician is able to view enter all mandatory details and click on AssignToMe button and verify error message for onHold
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC13 Verify user is able to enter all mandatory details and click on AssignToMe, Work inprogress button and Enter itemized cost details
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC14 Verify user is able assign the work order to him self by clicking on 'Assign to me' button and verify the error message for OnHold work order
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC15 Verify user is able assign the work order to him self by clicking on 'Assign to me' button and enter itemized cost details
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC16 Verify user is able assign the work order to him self by clicking on 'Assign to me' button and enter itemized cost details
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC17 Verify user is able cancel the work order and verify the Work Order Closed Cancel status
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC18 Verify user is able cancel the work order and verify the Work Order Closed Complete status
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC19 Verify user is able click on work complete button after entering mandatroy details and verify the error message for itemized cost details
  */

  //*************Mile stone 11 Test cases*************
  /* CAM_NewWrkOrder_01 As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC20 Verify user is able update the default priority of a work order and move the work order to inprogress status
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC21 Verify user is able verify the activities details under details section after submitting the work order successfully
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   National Admin  Yes Yes Yes No  Yes CAM_NewWrkOrder_01_TC02 Verify user is able to enter all mdatory details and Save WorkOrder as a Draft
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   National Admin  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC23 Verify user is able to assign the work order to campus admin
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   National Admin  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC24 Verify user  is able to assign the work order to campus admin
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   National Admin  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC25 Verify Technician is able to assign the work order to campus admin and enter itemized cost details
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   National Admin  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC26 Verify user is able to assign the work order to campus admin and assigned user is able to complete the work order
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   RegionalAdmin   Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC27 Verify RegionalAdmin is able to assign the work order to campus admin and assigned user is able to complete the work order
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   RegionalAdmin   Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC28 Verify RegionalAdmin is able to assign the work order to campus admin and assigned user is able to complete the work order with external technician details
  CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   RegionalAdmin   Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC29 Verify RegionalAdmin is able to assign the work order to campus admin and assigned user is able to complete the work order by changing the default priority
   */

  //Note: To sync up with KP team sprint names, Automation sprint directly moved from Milestone11 to Milestone 18

  //*************Mile stone 18 Test cases*************
 /* CAM_NewWrkOrder_01 As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   RegionalAdmin   Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC30 Verify user is able to view Draft , PendingAssignment, PendingAcceptance, WorkInProgress, OnHold, Work Complete and Cancel buttons      1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Verify user is able view all the work order states  "User should be able to view all work order states:
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   RegionalAdmin   Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC31 Verify RegionalAdmin is able to assign the work order to himself with external technician details and complete the work order       1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and assign the work order to himself and complete the work order    RegionalAdmin should able to assign the work order to himself with external technician details and complete the work order
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   RegionalAdmin   Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC32 Verify RegionalAdmin creates work order to a user from the assets group     1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and verify Technician able to assign the work order to campus admin and enter itemized cost  assigned user is able to complete the work order   User should be able to able to assign the work order to campus admin and campus admin able to enter itemized cost details and assigned user is able to complete the work order
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC33 Verify Technician is able to update the default Priority to critical and assign the work order to himself and complete the work order with itemized cost details, resolution details, schedule details.     1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and verify Technician able to change the priority to critical and complete the work order   Technician is able to complete the work order after changing the priority to critical
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   National Admin  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC34 Verify NationalAdmin is able update the default Priority to Medium, complete all the details and close the WorkOrder        1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and verify Technician able to change the priority to critical and complete the work order   National Admin is able to complete the work order after changing the priority to Medium
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC35 Verify Technician is able to enter mandatory details and Save WorkOrder as a Draft and verify related links at the bottom of the work order page for section1       1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and verify Technician able to view all the tabs under related links User should able  to view all the tabs under related links
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC36 Verify User is able to enter mandatory details and Save WorkOrder as a Draft and verify related links at the bottom of the work order page for section2     1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and verify Technician able to view all the tabs under related links User should able  to view all the tabs under related links
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC37 Verify User is able to assign the work order to himself and enter itemized cost details for PARTS and complete the work order       1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and  enter itemized cost details for Travel and complete the work order User should be able to enter itemized cost details for PARTS and complete the work order
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC38 Verify User is able to assign the work order to himself and enter itemized cost details for Local Job Codes and complete the work order     1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and  enter itemized cost details for Travel and complete the work order User is able to enter itemized cost details for Local Job Codes and complete the work order
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC39 Verify User is able to assign the work order to himself and enter itemized cost details for Travel and complete the work order      1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and  enter itemized cost details for Travel and complete the work order User is able to enter itemized cost details for Travel and complete the work order
 */

//*************Mile stone 19 Test cases only 9 test Cases*************
 /* CAM_NewWrkOrder_01 As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   RegionalAdmin   Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC40 Verify user is able to view Draft , PendingAssignment, PendingAcceptance, WorkInProgress, OnHold, Work Complete and Cancel buttons      1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Verify user is able view all the work order states  "User should be able to view all work order states:
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   RegionalAdmin   Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC41 Verify RegionalAdmin is able to assign the work order to himself with external technician details and complete the work order       1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and assign the work order to himself and complete the work order    RegionalAdmin should able to assign the work order to himself with external technician details and complete the work order
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   RegionalAdmin   Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC42 Verify RegionalAdmin creates work order to a user from the assets group     1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and verify Technician able to assign the work order to campus admin and enter itemized cost  assigned user is able to complete the work order   User should be able to able to assign the work order to campus admin and campus admin able to enter itemized cost details and assigned user is able to complete the work order
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC43 Verify Technician is able to update the default Priority to critical and assign the work order to himself and complete the work order with itemized cost details, resolution details, schedule details.     1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and verify Technician able to change the priority to critical and complete the work order   Technician is able to complete the work order after changing the priority to critical
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   National Admin  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC44 Verify NationalAdmin is able update the default Priority to Medium, complete all the details and close the WorkOrder        1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and verify Technician able to change the priority to critical and complete the work order   National Admin is able to complete the work order after changing the priority to Medium
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC45 Verify Technician is able to enter mandatory details and Save WorkOrder as a Draft and verify related links at the bottom of the work order page for section1       1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and verify Technician able to view all the tabs under related links User should able  to view all the tabs under related links
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC46 Verify User is able to enter mandatory details and Save WorkOrder as a Draft and verify related links at the bottom of the work order page for section2     1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and verify Technician able to view all the tabs under related links User should able  to view all the tabs under related links
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC47 Verify User is able to assign the work order to himself and enter itemized cost details for PARTS and complete the work order       1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and  enter itemized cost details for Travel and complete the work order User should be able to enter itemized cost details for PARTS and complete the work order
CAM_NewWrkOrder_01  As a user I should be able to access "New Work Order" link on the left menu under clinical Asset management>New Work Order  1   Technician  Yes No  Yes No  Yes CAM_NewWrkOrder_01_TC48 Verify User is able to assign the work order to himself and enter itemized cost details for Local Job Codes and complete the work order     1) Navigate to ServiceNow page, go to "Work orders" tab under Clinical Asset Management 2) Click on  "New Work Orders"  and Enter mandatory details and  enter itemized cost details for Travel and complete the work order User is able to enter itemized cost details for Local Job Codes and complete the work order

 */


//*************Mile stone 20 Test cases*************
 /*  10 test cases from KK and 10 Test cases for Harjeet
  CAM_NewWrkOrder_01_TC49 Verify campusAdmin is able to assign the work order to himself with external technician details and complete the work order
  CAM_NewWrkOrder_01_TC50 Verify Technician is able to creates a new draft wok order  and create a new clinical purchase requistion for work order
  CAM_NewWrkOrder_01_TC51 Verify CampusAdmin enters mandatory details and Save WorkOrder as a Draft
  CAM_NewWrkOrder_01_TC52 Verify RegionalAdmin enters mandatory details and Save WorkOrder as a Draft
  CAM_NewWrkOrder_01_TC53 Verify NationalAdmin enters mandatory details and Save WorkOrder as a Draft
  CAM_NewWrkOrder_01_TC54 Verify error messages when a CampusAdmin trying to save the WO as Draft without entering Mandatory details
  CAM_NewWrkOrder_01_TC55 Verify error messages when a RegionalAdmin trying to save the WO as Draft without entering Mandatory details
  CAM_NewWrkOrder_01_TC56 Verify error messages when a NationalAdmin trying to save the WO as Draft without entering Mandatory details
  CAM_NewWrkOrder_01_TC57 Verify CampusAdmin is able to view Draft Header, PendingAssignment Header, PendingAcceptance Header, ReadyForWork Header, Pending Review Header and Closed Header in new work order page
  CAM_NewWrkOrder_01_TC58 Verify RegionalAdmin is able to view Draft Header, PendingAssignment Header, PendingAcceptance Header, ReadyForWork Header, Pending Review Header and Closed Header in new work order page
  CAM_NewWrkOrder_01_TC59 Verify NationalAdmin is able to view Draft Header, PendingAssignment Header, PendingAcceptance Header, ReadyForWork Header, Pending Review Header and Closed Header in new work order page

  CAM_NewWrkOrder_01_TC60 Verify CampusAdmin is able to creates a new draft wok order  and create a new clinical purchase requistion for work order under related links section
  CAM_NewWrkOrder_01_TC61 Verify RegionalAdmin is able to creates a new draft wok order  and create a new clinical purchase requistion for work order under related links section
  CAM_NewWrkOrder_01_TC62 Verify NationalAdmin is able to creates a new draft wok order  and create a new clinical purchase requistion for work order under related links section
  CAM_NewWrkOrder_01_TC63 Verify Technician is able to create a Preventive Maintenance work order type and complete the predefined checklist
  CAM_NewWrkOrder_01_TC64 Verify RegionalAdmin is able to create a Preventive Maintenance work order type and complete the predefined checklist
  CAM_NewWrkOrder_01_TC65 Verify CampusAdmin is able to create a Preventive Maintenance work order type and complete the predefined checklist
  CAM_NewWrkOrder_01_TC66 Verify NationalAdmin is able to create a Preventive Maintenance work order type and complete the predefined checklist and complete the work order successfully
  CAM_NewWrkOrder_01_TC67 Verify Technician is able to create a Preventive Maintenance work order type and complete the predefined checklist
  CAM_NewWrkOrder_01_TC68 Verify Technician is able to create a Preventive Maintenance work order type and complete the predefined checklist and complete the work order successfully
  */


//*************Mile stone 21 Test cases*************
 /*CAM_NewWrkOrder_01_TC69   Verify CampusAdmin is able to submit the work order
 CAM_NewWrkOrder_01_TC70 Verify RegionalAdmin is able to submit the work order
 CAM_NewWrkOrder_01_TC71 Verify NationalAdmin is able to submit the work order
 CAM_NewWrkOrder_01_TC72 Verify CampusAdmin is able to view Draft , PendingAssignment, PendingAcceptance, WorkInProgress, OnHold, Work Complete and Cancel buttons
 CAM_NewWrkOrder_01_TC73 Verify RegionalAdmin is able to view Draft , PendingAssignment, PendingAcceptance, WorkInProgress, OnHold, Work Complete and Cancel buttons
 CAM_NewWrkOrder_01_TC74 Verify NationalAdmin is able to view Draft , PendingAssignment, PendingAcceptance, WorkInProgress, OnHold, Work Complete and Cancel buttons
 CAM_NewWrkOrder_01_TC75 Verify CampusAdmin is able to assign the work order to him self by clicking on Assign To Me  button in new work order page
 CAM_NewWrkOrder_01_TC76 Verify RegionalAdmin is able to assign the work order to him self by clicking on Assign To Me  button in new work order page

 CAM_NewWrkOrder_01_TC77 Verify CampusAdmin is able to creates a new draft wok order  and create a new clinical purchase requisition and complete the work order successfully
 CAM_NewWrkOrder_01_TC78 Verify RegionalAdmin is able to creates a new draft wok order  and create a new clinical purchase requisition and complete the work order successfully
 CAM_NewWrkOrder_01_TC79 Verify NatioanlAdmin is able to creates a new draft wok order  and create a new clinical purchase requisition and complete the work order successfully
 CAM_NewWrkOrder_01_TC80 Verify Technician is able to creates a new draft wok order  and create a new clinical purchase requisition and complete the work order successfully

 */




  @Test (groups = {"CAM_NewWrkOrder_01", "CT_Regression", "CT_BVT", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
  @Description("Verify Technician is able to navigate to New Work Order page")
  public void CAM_NewWrkOrder_01_TC01() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC01";
   //log = extent.createTest("CAM_NewWrkOrder_01_TC01", "Verify user is able to navigate to New Work Order page");
   logger.info("Impersonate as a Technician: " +  GlobalVariables.NCal_OAK_Technician().get("Name"));
   Commonfn_ValidateCreateNewWorkOrderPage(GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

   }


  @Test (groups = {"CAM_NewWrkOrder_02", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
  @Description("Verify Technician is able to enters mandatory details and Save WorkOrder as a Draft")
  public void CAM_NewWrkOrder_01_TC02() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC02";
   logger.info("Impersonate as a Technician: " +  GlobalVariables.NCal_OAK_Technician().get("Name"));
   Commonfn_validateWOMandatoryDetailsAndSaveDraft(GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

   }

  @Test (groups = {"CAM_NewWrkOrder_03", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
  @Description("Verify error messages when a Technician trying to save the WO as Draft without entering Mandatory details")
  public void CAM_NewWrkOrder_01_TC03() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC03";
   logger.info("Impersonate as a Technician: " +  GlobalVariables.NCal_OAK_Technician().get("Name"));
   Commonfn_verifyErrorMessageMandatoryDetails(GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

   }

  @Test (groups = {"CAM_NewWrkOrder_04", "CT_Regression", "CT_BVT", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
  @Description("Verify Technician is able to view Draft Header, PendingAssignment Header, "
      + "PendingAcceptance Header, ReadyForWork Header, PendingReview Header and Closed Header in new work order page")
  public void CAM_NewWrkOrder_01_TC04() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC04";
   logger.info("Impersonate as a Technician: " +  GlobalVariables.NCal_OAK_Technician().get("Name"));
   Commonfn_verifyAllTheWorkFlowTabsForWorkOrder(GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

  }


  @Test (groups = {"CAM_NewWrkOrder_05", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
  @Description("Verify Technician is able to submit the work order successfully")
  public void CAM_NewWrkOrder_01_TC05() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC05";
    logger.info("Impersonate as a Technician: " +  GlobalVariables.NCal_OAK_Technician().get("Name"));
   Commonfn_verifyUserAbleToSubmitTheWorkOrder(GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

   }

  @Test (groups = {"CAM_NewWrkOrder_06", "CT_Regression", "CT_BVT", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
  @Description("Verify Technician is able to view Draft , PendingAssignment, PendingAcceptance, WorkInProgress, OnHold, Work Complete and Cancel buttons")
  public void CAM_NewWrkOrder_01_TC06() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC06";
    logger.info("Impersonate as a Technician: " +  GlobalVariables.NCal_OAK_Technician().get("Name"));
   Commonfn_verifyAllWorkOrderStates(GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

   }

  @Test (groups = {"CAM_NewWrkOrder_07", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
  @Description("Verify Technician is able to assign the work order to him self by clicking on Assign To Me button in new work order page")
  public void CAM_NewWrkOrder_01_TC07() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC07";
   logger.info("Impersonate as a Technician: " +  GlobalVariables.NCal_OAK_Technician().get("Name"));
   Commonfn_verifyUserAbleToClickOnAssignToMeButton(GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

   }


  @Test (groups = {"CAM_NewWrkOrder_08", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
  @Description("Verify Technician is able to enter all the mandatory details and click on Save & Stay button for a new work order")
  public void CAM_NewWrkOrder_01_TC08() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC08";
   logger.info("Impersonate as a Technician: " +  GlobalVariables.NCal_OAK_Technician().get("Name"));
   Commonfn_verifyUserAbleToClickOnSaveAndStayButton(GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

   }

  @Test (groups = {"CAM_NewWrkOrder_09", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
  @Description("Verify Technician able to enter all the mandatory details and click on Save & Go button for a new work order")
  public void CAM_NewWrkOrder_01_TC09() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC09";
   logger.info("Impersonate as a Technician: " +  GlobalVariables.NCal_OAK_Technician().get("Name"));
   Commonfn_verifyUserAbleToClickOnSaveAndGoButton(GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

   }


  @Test (groups = {"CAM_NewWrkOrder_10", "CT_Regression",  "CT_BVT", "Work Order", "NewWorkOrder", "MileStone10"}, enabled = true)
  @Description("Verify Technician is able to view all the sections displayed in new work order page")
  public void CAM_NewWrkOrder_01_TC10() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC10";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_verifyAllSectionsUnderWO( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

   }


  @Test (groups = {"CAM_NewWrkOrder_11", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone10"}, enabled = true)
  @Description("Verify Technician is able to view enter all mandatory details and click on AssignToMe button and move the work order to On Hold status")
  public void CAM_NewWrkOrder_01_TC11() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC11";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_verifyCreateNewWorkOrder_AssignToMe_OnHoldWorkOrder( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

   }

  @Test (groups = {"CAM_NewWrkOrder_12", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone10"}, enabled = true)
  @Description("Verify Technician is able to view enter all mandatory details and click on AssignToMe button and verify error message for onHold status")
  public void CAM_NewWrkOrder_01_TC12() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC12";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_verifyCreateNewWorkOrder_AssignToMe_OnHoldWorkOrderErrorMessage( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

   }


  @Test (groups = {"CAM_NewWrkOrder_13", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone10"}, enabled = true)
  @Description("Verify Technician is able to view enter all mandatory details, click on AssignToMe, Enter itemized cost details and move the Work order to inprogress status")
  public void CAM_NewWrkOrder_01_TC13() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC13";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_verifyCreateNewWorkOrder_AssignToMe_EnterItemizedCostDetails( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

   }



   @Test (groups = {"CAM_NewWrkOrder_14", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone10"}, enabled = true)
  @Description("Verify Technician is able to view enter all mandatory details and click on AssignToMe button and Enter resolution details")
  public void CAM_NewWrkOrder_01_TC14() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC14";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_ResolutionDetailsValidation( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);
   }


   @Test (groups = {"CAM_NewWrkOrder_15", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone10"}, enabled = true)
  @Description("Verify Technician is able to assing the work order to himself and complete the work order successfully")
  public void CAM_NewWrkOrder_01_TC15() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC15";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_CompleteWorkOrder( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);
   }


  @Test (groups = {"CAM_NewWrkOrder_16", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone10"}, enabled = true)
  @Description("Verify Technician is able to assign the work order to himself with external technician details and complete the work order")
  public void CAM_NewWrkOrder_01_TC16() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC16";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_CompleteWorkOrderWithExternalTechnician( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);
   }

  @Test (groups = {"CAM_NewWrkOrder_17", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone10"}, enabled = true)
  @Description("Verify Technician is able to cancel the work order")
  public void CAM_NewWrkOrder_01_TC17() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC17";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_CancelWorkOrder( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);
   }


  @Test (groups = {"CAM_NewWrkOrder_18", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone10"}, enabled = true)
  @Description("Verify Technician is able close complete the work order with all mandataroy details")
  public void CAM_NewWrkOrder_01_TC18() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC18";
   logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NationalAdmin().get("Name") );
   Commonfn_CloseCompleteWorkOrder(GlobalVariables.NationalAdmin().get("Name") ,Test_ID);
   }

  @Test (groups = {"CAM_NewWrkOrder_19", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone10"}, enabled = true)
  @Description("Verify Technician is able complete the work order without entering itemized cost details")
  public void CAM_NewWrkOrder_01_TC19() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC19";
   logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NationalAdmin().get("Name") );
   Commonfn_WorkCompleteWorkOrderErroMessage(GlobalVariables.NationalAdmin().get("Name") ,Test_ID);
   }


  @Test (groups = {"CAM_NewWrkOrder_20", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone11"}, enabled = true)
  @Description("Verify Technician is able update the default Priority of a WorkOrder ")
  public void CAM_NewWrkOrder_01_TC20() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC20";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_UpdateWorkOrderPriorityAndMoveItToWorkInProgress( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);
   }


  @Test (groups = {"CAM_NewWrkOrder_21", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone11"}, enabled = true)
  @Description("Verify Technician is able to save the work order as a draft and verify the Activities details ")
  public void CAM_NewWrkOrder_01_TC21() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC21";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_verifyActivitiesDetailsAfterWorkOrderDraft( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);
   }


  @Test (groups = {"CAM_NewWrkOrder_22", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone11"}, enabled = true)
  @Description("Verify NationalAdmin enters mandatory details and Save WorkOrder as a Draft")
  public void CAM_NewWrkOrder_01_TC22() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC22";
   logger.info("Impersonate as a NationalAdmin: " +  GlobalVariables.NationalAdmin().get("Name"));
   Commonfn_validateWOMandatoryDetailsAndSaveDraft(GlobalVariables.NationalAdmin().get("Name") ,Test_ID);

   }

  @Test (groups = {"CAM_NewWrkOrder_23", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone11"}, enabled = true)
  @Description("Verify National admin creates work order ans assign to a Technician")
  public void CAM_NewWrkOrder_01_TC23() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC23";
    logger.info("Impersonate as a NationalAdmin: " +  GlobalVariables.NationalAdmin().get("Name"));
    Commonfn_AssisnedUserOpensWorkOrderFromMyWorkOrders( GlobalVariables.NationalAdmin().get("Name") ,Test_ID);

   }

  @Test (groups = {"CAM_NewWrkOrder_24", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone11"}, enabled = true)
  @Description("Verify National admin creates work order ans assign to a Technician. Technician will move the work order to in progress status")
  public void CAM_NewWrkOrder_01_TC24() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC24";
   logger.info("Impersonate as a NationalAdmin: " +  GlobalVariables.NationalAdmin().get("Name"));
    Commonfn_WorkOrderFlowBetweenNatioanlAdminToTechnician(Test_ID, "WorkInProgress","Labor");

  }

  @Test (groups = {"CAM_NewWrkOrder_25", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone11"}, enabled = true)
    @Description("Verify National admin creates work order and assign to a Techncian and Technician enters the itemizied cost details successfully")
    public void CAM_NewWrkOrder_01_TC25() throws Exception {
      String Test_ID = "CAM_NewWrkOrder_01_TC25";
      logger.info("Impersonate as a NationalAdmin: " +  GlobalVariables.NationalAdmin().get("Name"));
      Commonfn_WorkOrderFlowBetweenNatioanlAdminToTechnician(Test_ID, "ItemizedCostDetails","Labor");
    }

  @Test (groups = {"CAM_NewWrkOrder_26", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone11"}, enabled = true)
  @Description("Verify National admin creates a new work order ans assign to a Technician and Technician will complete the work order")
  public void CAM_NewWrkOrder_01_TC26() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC26";
    logger.info("Impersonate as a NationalAdmin: " +  GlobalVariables.NationalAdmin().get("Name"));
    Commonfn_WorkOrderFlowBetweenNatioanlAdminToTechnician(Test_ID,"CompleteWorkOrder","Labor");
 }

  @Test (groups = {"CAM_NewWrkOrder_27", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone11"}, enabled = true)
  @Description("Verify Regional admin creates a new work order ans assign to a user and assigned user enters the External Technician details")
  public void CAM_NewWrkOrder_01_TC27() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC27";
    logger.info("Impersonate as a RegionalAdmin: " +  GlobalVariables.NCal_RegionalAdmin().get("Name"));
    Commonfn_WorkOrderFlowBetweenNatioanlAdminToTechnician(Test_ID,"ExternalTechnicianToCompleteWorkOrder","Labor");
 }

  @Test (groups = {"CAM_NewWrkOrder_28", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone11"}, enabled = true)
  @Description("Verify Regional admin creates a new work order and assign to a one of the user in the asset assignment group and"
      + "assigned user enters all the mandatory details and close the work order")
  public void CAM_NewWrkOrder_01_TC28() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC28";
    logger.info("Impersonate as a RegionalAdmin: " +  GlobalVariables.NCal_RegionalAdmin().get("Name"));
    Commonfn_WorkOrderFlowBetweenDifferentUsers( GlobalVariables.NCal_RegionalAdmin().get("Name") ,Test_ID, "CompleteWorkOrder" ,"Labor");
 }


  @Test (groups = {"CAM_NewWrkOrder_29", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone11"}, enabled = true)
  @Description("Verify Technician creates a new work order and assign to a one of the user in the asset assignment group and "
      + "assigned user enters all the mandatory details and close the work order")
  public void CAM_NewWrkOrder_01_TC29() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC29";
    logger.info("Impersonate as a Technician: " +  GlobalVariables.NCal_OAK_Technician().get("Name"));
    Commonfn_WorkOrderFlowBetweenDifferentUsers( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID, "CompleteWorkOrder" ,"Labor");
 }


  @Test (groups = {"CAM_NewWrkOrder_30", "CT_Regression", "CT_BVT",  "Work Order", "NewWorkOrder", "MileStone18"}, enabled = true)
  @Description("Verify RegionalAdmin is able to view Draft , PendingAssignment, PendingAcceptance, WorkInProgress, OnHold, Work Complete and Cancel buttons")
  public void CAM_NewWrkOrder_01_TC30() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC30";
    logger.info("Impersonate as a RegionalAdmin: " +  GlobalVariables.NCal_RegionalAdmin().get("Name"));
   Commonfn_verifyAllWorkOrderStates(GlobalVariables.NCal_RegionalAdmin().get("Name") ,Test_ID);

   }

  @Test (groups = {"CAM_NewWrkOrder_31", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone18"}, enabled = true)
  @Description("Verify RegionalAdmin is able to assign the work order to himself with external technician details and complete the work order")
  public void CAM_NewWrkOrder_01_TC31() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC31";
   logger.info("Impersonate as a RegionalAdmin: " + GlobalVariables.NCal_RegionalAdmin().get("Name") );
   Commonfn_CompleteWorkOrderWithExternalTechnician( GlobalVariables.NCal_RegionalAdmin().get("Name") ,Test_ID);
   }


  @Test (groups = {"CAM_NewWrkOrder_32", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone18"}, enabled = true)
  @Description("Verify CampusAdmin creates work order to a user from the assets group ")
  public void CAM_NewWrkOrder_01_TC32() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC32";
    logger.info("Impersonate as a RegionalAdmin: " + GlobalVariables.NCal_OAK_CampusAdmin().get("Name"));
    Commonfn_WorkOrderFlowBetweenDifferentUsers( GlobalVariables.NCal_OAK_CampusAdmin().get("Name") ,Test_ID,"CompleteWorkOrder", "Labor");

  }

  @Test (groups = {"CAM_NewWrkOrder_33", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone18"}, enabled = true)
  @Description("Verify Technician is able update the default Priority to critical,complete all the details and close the WorkOrder ")
  public void CAM_NewWrkOrder_01_TC33() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC33";
   String Priority = "1"; //Priority 1 is critical
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_UpdateWorkOrderPriorityAndCompleteTheWorkOrder( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID, Priority);
   }


  @Test (groups = {"CAM_NewWrkOrder_34", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone18"}, enabled = true)
  @Description("Verify NationalAdmin is able update the default Priority to Medium, complete all the details and close the WorkOrder ")
  public void CAM_NewWrkOrder_01_TC34() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC34";
   String Priority = "3"; //Priority 3 is medium
   logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NationalAdmin().get("Name") );
   Commonfn_UpdateWorkOrderPriorityAndCompleteTheWorkOrder( GlobalVariables.NationalAdmin().get("Name") ,Test_ID, Priority);
   }

  @Test (groups = {"CAM_NewWrkOrder_35", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone18"}, enabled = true)
  @Description("Verify Technician is able to enter mandatory details and Save WorkOrder as a Draft and verify related links at the bottom of the work order pagemat first lane")
  public void CAM_NewWrkOrder_01_TC35() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC35";
   logger.info("Impersonate as a Technician: " +  GlobalVariables.NCal_OAK_Technician().get("Name"));
   Commonfn_validateWOMandatoryDetailsAndVerifyRelatedLinksSection1(GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

   }

  @Test (groups = {"CAM_NewWrkOrder_36", "CT_Regression",  "CT_BVT",  "Work Order", "NewWorkOrder", "MileStone18"}, enabled = true)
  @Description("Verify Technician is able to enter mandatory details and Save WorkOrder as a Draft and verify related links at the bottom of the work order page at second lane")
  public void CAM_NewWrkOrder_01_TC36() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC36";
   logger.info("Impersonate as a Technician: " +  GlobalVariables.NCal_OAK_Technician().get("Name"));
   Commonfn_validateWOMandatoryDetailsAndVerifyRelatedLinksSection2(GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

   }


  @Test (groups = {"CAM_NewWrkOrder_37", "CT_Regression", "CT_BVT",  "Work Order", "NewWorkOrder", "MileStone18"}, enabled = true)
  @Description("Verify Technician is able to assign the work order to himself and enter itemized cost details for PARTS and complete the work order")
  public void CAM_NewWrkOrder_01_TC37() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC37";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_CompleteWorkOrder_DifferentItemizedCosts( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID, "Parts");
   }


  @Test (groups = {"CAM_NewWrkOrder_38", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone18"}, enabled = true)
  @Description("Verify Technician is able to assign the work order to himself and enter itemized cost details for LOCAL JOB CODES and complete the work order")
  public void CAM_NewWrkOrder_01_TC38() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC38";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_CompleteWorkOrder_DifferentItemizedCosts( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID, "LocalJobCode");
   }


  @Test (groups = {"CAM_NewWrkOrder_39", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone18"}, enabled = true)
  @Description("Verify Technician is able to assign the work order to himself and enter itemized cost details for TRAVEL and complete the work order")
  public void CAM_NewWrkOrder_01_TC39() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC39";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_CompleteWorkOrder_DifferentItemizedCosts( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID, "Travel");
   }


  @Test (groups = {"CAM_NewWrkOrder_40", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone19"}, enabled = true)
  @Description("Verify Technician is able to assign the work order to himself and enter itemized cost details for Fee For Service and complete the work order")
  public void CAM_NewWrkOrder_01_TC40() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC40";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_CompleteWorkOrder_DifferentItemizedCosts( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID, "FeeForService");
   }


  @Test (groups = {"CAM_NewWrkOrder_41", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone19"}, enabled = true)
  @Description("Verify Technician is able to assign the work order to himself and enter itemized cost details for both Travel and Meals and complete the work order")
  public void CAM_NewWrkOrder_01_TC41() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC41";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_CompleteWorkOrder_DifferentItemizedCosts( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID, "Travel:Meals");
   }


   @Test (groups = {"CAM_NewWrkOrder_42", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone19"}, enabled = true)
   @Description("Verify Technician is able to assign the work order to himself and enter itemized cost details for both Lodging and FeeForService and complete the work order")
   public void CAM_NewWrkOrder_01_TC42() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC42";
    logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
    Commonfn_CompleteWorkOrder_DifferentItemizedCosts( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID, "Lodging:FeeForService");
    }

   @Test (groups = {"CAM_NewWrkOrder_43", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone19"}, enabled = true)
   @Description("Verify Regional admin creates a new work order ans assign to a user and assigned user enters the External Technician details"
       + "for itemized details as Travel")
   public void CAM_NewWrkOrder_01_TC43() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC43";
     logger.info("Impersonate as a RegionalAdmin: " +  GlobalVariables.NCal_RegionalAdmin().get("Name"));
     Commonfn_WorkOrderFlowBetweenNatioanlAdminToTechnician(Test_ID,"ExternalTechnicianToCompleteWorkOrder","Travel");
   }

   @Test (groups = {"CAM_NewWrkOrder_44", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone19"}, enabled = true)
   @Description("Verify user creates work order and assigns to a user from the assets group. Assigned user enterd  itemized details as only Parts and completes the work order")
   public void CAM_NewWrkOrder_01_TC44() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC44";
     logger.info("Impersonate as a RegionalAdmin: " + GlobalVariables.NCal_OAK_CampusAdmin().get("Name"));
     Commonfn_WorkOrderFlowBetweenDifferentUsers( GlobalVariables.NCal_OAK_CampusAdmin().get("Name") ,Test_ID,"CompleteWorkOrder", "Parts");
   }

   @Test (groups = {"CAM_NewWrkOrder_45", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone19"}, enabled = true)
   @Description("Verify Technician is able to assign the work order to himself and enter itemized cost details for InventoriedParts and complete the work order")
   public void CAM_NewWrkOrder_01_TC45() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC45";
   logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
   Commonfn_CompleteWorkOrder_DifferentItemizedCosts( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID, "Inventoried");
    }

   @Test (groups = {"CAM_NewWrkOrder_46", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone19"}, enabled = true)
   @Description("Verify NationalAdmin creates a new work order ans assign to a user and assigned user enters the External Technician details"
       + "for itemized details as Travel and Labor")
   public void CAM_NewWrkOrder_01_TC46() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC46";
     logger.info("Impersonate as a National admin "+ GlobalVariables.NationalAdmin().get("Name"));
     Commonfn_WorkOrderFlowBetweenNatioanlAdminToTechnician(Test_ID,"CompleteWorkOrder","Labor:Travel");
   }


   @Test (groups = {"CAM_NewWrkOrder_47", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone19"}, enabled = true)
   @Description("Verify Technician is able to assign the work order to himself and enter itemized cost details for Travel, Meals and Fee for service and complete the work order")
   public void CAM_NewWrkOrder_01_TC47() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC47";
    logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
    Commonfn_CompleteWorkOrder_DifferentItemizedCosts( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID, "Travel:Meals:FeeForService");
    }


   @Test (groups = {"CAM_NewWrkOrder_48", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone19"}, enabled = true)
   @Description("Verify Regional admin creates a new work order ans assign to a user and assigned user enters the External Technician details"
       + "and itemized details are Labor,Travel and LocalJobCode")
   public void CAM_NewWrkOrder_01_TC48() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC48";
     logger.info("Impersonate as a National admin "+ GlobalVariables.NationalAdmin().get("Name"));
     Commonfn_WorkOrderFlowBetweenNatioanlAdminToTechnician(Test_ID,"ExternalTechnicianToCompleteWorkOrder","Labor:Travel:LocalJobCode");
   }

  @Test (groups = {"CAM_NewWrkOrder_49", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
   @Description("Verify campusAdmin is able to assign the work order to himself with external technician details and complete the work order")
   public void CAM_NewWrkOrder_01_TC49() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC49";
    logger.info("Impersonate as a RegionalAdmin: " + GlobalVariables.NCal_OAK_CampusAdmin().get("Name") );
    Commonfn_CompleteWorkOrderWithExternalTechnician( GlobalVariables.NCal_OAK_CampusAdmin().get("Name") ,Test_ID);

   }

//-----------------MileStone20-------Harjeet--------------

   @Test (groups = {"CAM_NewWrkOrder_50", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
   @Description("Verify Technician is able to creates a new draft wok order  and create a new clinical purchase requistion for work order")
   public void CAM_NewWrkOrder_01_TC50() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC50";
    logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
    Commonfn_validateCreatingNewClinicalPurchseRequistion( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);
    }

  @Test (groups = {"CAM_NewWrkOrder_51", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
   @Description("Verify CampusAdmin enters mdatory details and Save WorkOrder as a Draft")
   public void CAM_NewWrkOrder_01_TC51() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC51";
    logger.info("Impersonate as a CampusAdmin: " +  GlobalVariables.NCal_OAK_CampusAdmin().get("Name"));
    Commonfn_validateWOMandatoryDetailsAndSaveDraft(GlobalVariables.NCal_OAK_CampusAdmin().get("Name") ,Test_ID);

    }

   @Test (groups = {"CAM_NewWrkOrder_52", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
   @Description("Verify RegionalAdmin enters mdatory details and Save WorkOrder as a Draft")
   public void CAM_NewWrkOrder_01_TC52() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC52";
    logger.info("Impersonate as a RegionalAdmin: " +  GlobalVariables.NCal_RegionalAdmin().get("Name"));
    Commonfn_validateWOMandatoryDetailsAndSaveDraft(GlobalVariables.NCal_RegionalAdmin().get("Name") ,Test_ID);

    }

   @Test (groups = {"CAM_NewWrkOrder_53", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
   @Description("Verify NationalAdmin enters mdatory details and Save WorkOrder as a Draft")
   public void CAM_NewWrkOrder_01_TC53() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC53";
    logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NationalAdmin().get("Name") );
    Commonfn_validateWOMandatoryDetailsAndSaveDraft( GlobalVariables.NationalAdmin().get("Name") ,Test_ID);

    }


   @Test (groups = {"CAM_NewWrkOrder_54", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
  @Description("Verify error messages when a CampusAdmin tring to save the WO as Draft without entering Mandatory details")
  public void CAM_NewWrkOrder_01_TC54() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC54";
   logger.info("Impersonate as a CampusAdmin: " +  GlobalVariables.NCal_OAK_CampusAdmin().get("Name"));
   Commonfn_verifyErrorMessageMandatoryDetails(GlobalVariables.NCal_OAK_CampusAdmin().get("Name") ,Test_ID);

   }

  @Test (groups = {"CAM_NewWrkOrder_55", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
  @Description("Verify error messages when a RegionalAdmin tring to save the WO as Draft without entering Mandatory details")
  public void CAM_NewWrkOrder_01_TC55() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC55";
   logger.info("Impersonate as a RegionalAdmin: " +  GlobalVariables.NCal_RegionalAdmin().get("Name"));
   Commonfn_verifyErrorMessageMandatoryDetails(GlobalVariables.NCal_RegionalAdmin().get("Name") ,Test_ID);

   }

  @Test (groups = {"CAM_NewWrkOrder_56", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
  @Description("Verify error messages when a NationalAdmin tring to save the WO as Draft without entering Mandatory details")
  public void CAM_NewWrkOrder_01_TC56() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC56";
   logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NationalAdmin().get("Name") );
   Commonfn_verifyErrorMessageMandatoryDetails( GlobalVariables.NationalAdmin().get("Name") ,Test_ID);

   }

  @Test (groups = {"CAM_NewWrkOrder_57", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
  @Description("Verify CampusAdmin is able to view Draft Header, PendingAssignment Header, "
      + "PendingAcceptance Header, ReadyForWork Header, PendingReview Header and Closed Header in new work order page")
  public void CAM_NewWrkOrder_01_TC57() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC57";
    logger.info("Impersonate as a CampusAdmin: " +  GlobalVariables.NCal_OAK_CampusAdmin().get("Name"));
   Commonfn_verifyAllTheWorkFlowTabsForWorkOrder(GlobalVariables.NCal_OAK_CampusAdmin().get("Name") ,Test_ID);

  }

  @Test (groups = {"CAM_NewWrkOrder_58", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
  @Description("Verify RegionalAdmin is able to view Draft Header, PendingAssignment Header, "
      + "PendingAcceptance Header, ReadyForWork Header, PendingReview Header and Closed Header in new work order page")
  public void CAM_NewWrkOrder_01_TC58() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC58";
   logger.info("Impersonate as a RegionalAdmin: " +  GlobalVariables.NCal_RegionalAdmin().get("Name"));
   Commonfn_verifyAllTheWorkFlowTabsForWorkOrder(GlobalVariables.NCal_RegionalAdmin().get("Name") ,Test_ID);

   }

  @Test (groups = {"CAM_NewWrkOrder_59", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
  @Description("Verify NationalAdmin is able to view Draft Header, PendingAssignment Header, "
      + "PendingAcceptance Header, ReadyForWork Header, PendingReview Header and Closed Header in new work order page")
  public void CAM_NewWrkOrder_01_TC59() throws Exception {
   String Test_ID = "CAM_NewWrkOrder_01_TC59";
   logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NationalAdmin().get("Name") );
   Commonfn_verifyAllTheWorkFlowTabsForWorkOrder( GlobalVariables.NationalAdmin().get("Name") ,Test_ID);

   }


   //--------------------End Harjeet Test cases for sprint 20----------------------------------------------


   @Test (groups = {"CAM_NewWrkOrder_60", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
   @Description("Verify CampusAdmin is able to creates a new draft wok order  and create a new clinical purchase requistion for work order")
   public void CAM_NewWrkOrder_01_TC60() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC60";
    logger.info("Impersonate as a CampusAdmin: " + GlobalVariables.NCal_OAK_CampusAdmin().get("Name") );
    Commonfn_validateCreatingNewClinicalPurchseRequistion( GlobalVariables.NCal_OAK_CampusAdmin().get("Name") ,Test_ID);

   }

   @Test (groups = {"CAM_NewWrkOrder_61", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
   @Description("Verify RegionalAdmin is able to creates a new draft wok order  and create a new clinical purchase requistion for work order")
   public void CAM_NewWrkOrder_01_TC61() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC61";
    logger.info("Impersonate as a RegionalAdmin: " + GlobalVariables.NCal_RegionalAdmin().get("Name") );
    Commonfn_validateCreatingNewClinicalPurchseRequistion( GlobalVariables.NCal_RegionalAdmin().get("Name") ,Test_ID);

   }

   @Test (groups = {"CAM_NewWrkOrder_62", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
    @Description("Verify NationalAdmin is able to creates a new draft wok order  and create a new clinical purchase requistion for work order")
    public void CAM_NewWrkOrder_01_TC62() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC62";
     logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NationalAdmin().get("Name") );
     Commonfn_validateCreatingNewClinicalPurchseRequistion( GlobalVariables.NationalAdmin().get("Name") ,Test_ID);

    }


    @Test (groups = {"CAM_NewWrkOrder_63", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
    @Description("Verify Technician is able to create a Preventive Maintenance work order type and complete the predefined checklist")
    public void CAM_NewWrkOrder_01_TC63() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC63";
     logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NationalAdmin().get("Name") );
     Commonfn_validateCreatingPreventiveMaintenanceWorkOrder( GlobalVariables.NationalAdmin().get("Name") ,Test_ID);

    }

    @Test (groups = {"CAM_NewWrkOrder_64", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
    @Description("Verify RegionalAdmin is able to create a Preventive Maintenance work order type and complete the predefined checklist")
    public void CAM_NewWrkOrder_01_TC64() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC64";
     logger.info("Impersonate as a RegionalAdmin: " + GlobalVariables.NCal_RegionalAdmin().get("Name") );
     Commonfn_validateCreatingPreventiveMaintenanceWorkOrder( GlobalVariables.NCal_RegionalAdmin().get("Name") ,Test_ID);

    }


    @Test (groups = {"CAM_NewWrkOrder_65", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
    @Description("Verify NCal_OAK_CampusAdmin is able to create a Preventive Maintenance work order type and complete the predefined checklist")
    public void CAM_NewWrkOrder_01_TC65() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC65";
     logger.info("Impersonate as a NCal_OAK_CampusAdmin: " + GlobalVariables.NCal_OAK_CampusAdmin().get("Name") );
     Commonfn_validateCreatingPreventiveMaintenanceWorkOrder( GlobalVariables.NCal_OAK_CampusAdmin().get("Name") ,Test_ID);

    }

    @Test (groups = {"CAM_NewWrkOrder_66", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
    @Description("Verify NationalAdmin is able to create a Preventive Maintenance work order type and complete the predefined checklist and complete the work order successfully")
    public void CAM_NewWrkOrder_01_TC66() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC66";
     logger.info("Impersonate as a Technician: " + GlobalVariables.NationalAdmin().get("Name") );
     Commonfn_validateCreatingPreventiveMaintenanceWorkOrderAndCompleteWorkOrder( GlobalVariables.NationalAdmin().get("Name") ,Test_ID);

    }

    @Test (groups = {"CAM_NewWrkOrder_67", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
    @Description("Verify Technician is able to create a Preventive Maintenance work order type and complete the predefined checklist")
    public void CAM_NewWrkOrder_01_TC67() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC67";
     logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
     Commonfn_validateCreatingPreventiveMaintenanceWorkOrder( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

    }

    @Test (groups = {"CAM_NewWrkOrder_68", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone20"}, enabled = true)
    @Description("Verify Technician is able to create a Preventive Maintenance work order type and complete the predefined checklist and complete the work order sucessfully")
    public void CAM_NewWrkOrder_01_TC68() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC68";
     logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
     Commonfn_validateCreatingPreventiveMaintenanceWorkOrderAndCompleteWorkOrder( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

    }

    //-------Sprint 21 test cases for Harjeet---------------------


   @Test (groups = {"CAM_NewWrkOrder_69", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone21"}, enabled = true)
    @Description("Verify CampusAdmin is able to submit the work order")
    public void CAM_NewWrkOrder_01_TC69() throws Exception {
      String Test_ID = "CAM_NewWrkOrder_01_TC69";
     logger.info("Impersonate as a CampusAdmin: " +  GlobalVariables.NCal_OAK_CampusAdmin().get("Name"));
     Commonfn_verifyUserAbleToSubmitTheWorkOrder(GlobalVariables.NCal_OAK_CampusAdmin().get("Name") ,Test_ID);

     }

    @Test (groups = {"CAM_NewWrkOrder_70", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone21"}, enabled = true)
    @Description("Verify RegionalAdmin is able to submit the work order")
    public void CAM_NewWrkOrder_01_TC70() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC70";
    logger.info("Impersonate as a RegionalAdmin: " +  GlobalVariables.NCal_RegionalAdmin().get("Name"));
     Commonfn_verifyUserAbleToSubmitTheWorkOrder(GlobalVariables.NCal_RegionalAdmin().get("Name") ,Test_ID);

     }

    @Test (groups = {"CAM_NewWrkOrder_71", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone21"}, enabled = true)
    @Description("Verify NationalAdmin is able to submit the work order")
    public void CAM_NewWrkOrder_01_TC71() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC71";
     logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NationalAdmin().get("Name") );
     Commonfn_verifyUserAbleToSubmitTheWorkOrder( GlobalVariables.NationalAdmin().get("Name") ,Test_ID);

     }


     @Test (groups = {"CAM_NewWrkOrder_72", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone21"}, enabled = true)
    @Description("Verify CampusAdmin is able to view Draft , PendingAssignment, PendingAcceptance, WorkInProgress, OnHold, Work Complete and Cancel buttons")
    public void CAM_NewWrkOrder_01_TC72() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC72";
     logger.info("Impersonate as a CampusAdmin: " +  GlobalVariables.NCal_OAK_CampusAdmin().get("Name"));
     Commonfn_verifyAllWorkOrderStates(GlobalVariables.NCal_OAK_CampusAdmin().get("Name") ,Test_ID);

     }

    @Test (groups = {"CAM_NewWrkOrder_73", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone21"}, enabled = true)
    @Description("Verify RegionalAdmin is able to view Draft , PendingAssignment, PendingAcceptance, WorkInProgress, OnHold, Work Complete and Cancel buttons")
    public void CAM_NewWrkOrder_01_TC73() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC73";
     logger.info("Impersonate as a RegionalAdmin: " +  GlobalVariables.NCal_RegionalAdmin().get("Name"));
     Commonfn_verifyAllWorkOrderStates(GlobalVariables.NCal_RegionalAdmin().get("Name") ,Test_ID);

     }

    @Test (groups = {"CAM_NewWrkOrder_74", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone21"}, enabled = true)
    @Description("Verify NationalAdmin is able to view Draft , PendingAssignment, PendingAcceptance, WorkInProgress, OnHold, Work Complete and Cancel buttons")
    public void CAM_NewWrkOrder_01_TC74() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC74";
     logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NationalAdmin().get("Name") );
     Commonfn_verifyAllWorkOrderStates( GlobalVariables.NationalAdmin().get("Name") ,Test_ID);

     }


    @Test (groups = {"CAM_NewWrkOrder_75", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone21"}, enabled = true)
    @Description("Verify CampusAdmin is able to assign the work order to him self by clciking on Assign To Me  button in new work order page")
    public void CAM_NewWrkOrder_01_TC75() throws Exception {
      String Test_ID = "CAM_NewWrkOrder_01_TC75";
     logger.info("Impersonate as a CampusAdmin: " +  GlobalVariables.NCal_OAK_CampusAdmin().get("Name"));
     Commonfn_verifyUserAbleToClickOnAssignToMeButton(GlobalVariables.NCal_OAK_CampusAdmin().get("Name") ,Test_ID);

     }

    @Test (groups = {"CAM_NewWrkOrder_76", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone21"}, enabled = true)
    @Description("Verify RegionalAdmin is able to assign the work order to him self by clciking on Assign To Me  button in new work order page")
    public void CAM_NewWrkOrder_01_TC76() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC76";
     logger.info("Impersonate as a RegionalAdmin: " +  GlobalVariables.NCal_RegionalAdmin().get("Name"));
     Commonfn_verifyUserAbleToClickOnAssignToMeButton(GlobalVariables.NCal_RegionalAdmin().get("Name") ,Test_ID);

     }
    //--------End of Harjeet Test cases for Sprint21----------

    @Test (groups = {"CAM_NewWrkOrder_77", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone21"}, enabled = true)
    @Description("Verify CampusAdmin is able to creates a new draft wok order  and create a new clinical purchase requistion and complete the work order successfully")
    public void CAM_NewWrkOrder_01_TC77() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC77";
     logger.info("Impersonate as a CampusAdmin: " + GlobalVariables.NCal_OAK_CampusAdmin().get("Name") );
     Commonfn_validateCreatingNewClinicalPurchseRequistionAndCompleteWorkOrder( GlobalVariables.NCal_OAK_CampusAdmin().get("Name") ,Test_ID);

    }

    @Test (groups = {"CAM_NewWrkOrder_78", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone21"}, enabled = true)
    @Description("Verify RegionalAdmin is able to creates a new draft wok order  and create a new clinical purchase requistion and complete the work order successfully")
    public void CAM_NewWrkOrder_01_TC78() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC78";
     logger.info("Impersonate as a RegionalAdmin: " + GlobalVariables.NCal_RegionalAdmin().get("Name") );
     Commonfn_validateCreatingNewClinicalPurchseRequistionAndCompleteWorkOrder( GlobalVariables.NCal_RegionalAdmin().get("Name") ,Test_ID);

    }

    @Test (groups = {"CAM_NewWrkOrder_79", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone21"}, enabled = true)
    @Description("Verify NationalAdmin is able to creates a new draft wok order  and create a new clinical purchase requistion and complete the work order successfully")
    public void CAM_NewWrkOrder_01_TC79() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC79";
     logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NationalAdmin().get("Name") );
     Commonfn_validateCreatingNewClinicalPurchseRequistionAndCompleteWorkOrder( GlobalVariables.NationalAdmin().get("Name") ,Test_ID);

    }

    @Test (groups = {"CAM_NewWrkOrder_80", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone21"}, enabled = true)
    @Description("Verify Technician is able to creates a new draft wok order  and create a new clinical purchase requistion and complete the work order successfully")
    public void CAM_NewWrkOrder_01_TC80() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC80";
     logger.info("Impersonate as a Technician: " + GlobalVariables.NCal_OAK_Technician().get("Name") );
     Commonfn_validateCreatingNewClinicalPurchseRequistionAndCompleteWorkOrder( GlobalVariables.NCal_OAK_Technician().get("Name") ,Test_ID);

    }








//------------------------Common Functions------------------------------------------

 public void Commonfn_ValidateCreateNewWorkOrderPage(String userRole, String Test_ID) throws Exception {
   try {
   home.goto_NuvoloAppHomePage(getDriver());
   logger.info("Nuvolo application launched successfully");
  
  }
  finally {
    logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

  }
 }


 public void Commonfn_validateWOMandatoryDetailsAndSaveDraft(String userRole, String Test_ID) throws Exception {

   try {
   home.goto_NuvoloAppHomePage(getDriver());
   logger.info("Nuvolo application launched successfully");
   namp.set_impersonateUser(getDriver(), userRole);
   namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
   logger.info("User is able to click on the new work order link");
   NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
   nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
   nwo.clickOnDraftButton();
   logger.info("User is able to save the work order as a draft successfully");

    } catch (Exception e) {
    e.printStackTrace();

    logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

  }
  finally {
    logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

  }
 }


 public void Commonfn_verifyErrorMessageMandatoryDetails(String userRole, String Test_ID) throws Exception {

   try {
   home.goto_NuvoloAppHomePage(getDriver());
   logger.info("Nuvolo application launched successfully");
   namp.set_impersonateUser(getDriver(), userRole);
   namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
   logger.info("User is able to click on the new work order link");
   NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
   nwo.verifyErrorMessageMandatoryDetails();
   logger.info("User is able to verify the error message for all mandatory details successfully");


   } catch (Exception e) {
    e.printStackTrace();

    logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

  }
  finally {
    logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

  }
 }


 public void Commonfn_verifyAllTheWorkFlowTabsForWorkOrder(String userRole, String Test_ID)
     throws Exception {

   SoftAssert softAssert = new SoftAssert();
   try {

     home.goto_NuvoloAppHomePage(getDriver());
     logger.info("Nuvolo application launched successfully");
     namp.set_impersonateUser(getDriver(), userRole);
     namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
     logger.info("User is able to click on the new work order link");
     NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
     softAssert.assertTrue(nwo.isveriyDraftTabExist(), "Draft status tab is not displaying");
     softAssert.assertTrue(nwo.isPendingAssignmentTabExist(), "PendingAssignmentTab is not displaying");
     softAssert.assertTrue(nwo.isPendingAcceptanceTabExist(), "PendingAcceptanceTab is not displaying");
     softAssert.assertTrue(nwo.isReadyForWorkTabExist(), "ReadyForWorkTab is not displaying");
     softAssert.assertTrue(nwo.isPendingReviewTabExist(), "PendingReviewTab is not displaying");
     softAssert.assertTrue(nwo.isCosedTabExist(), "ClosedTab is not displaying");
     softAssert.assertAll();
     logger.info ("User is able to view Draft , PendingAssignmentTab, PendingAcceptanceTab, ReadyForWork, PendingReviewTab and Closed");

   } catch (Exception e) {
    e.printStackTrace();

    logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());
    softAssert.fail();
    softAssert.assertAll();
  }
  finally {
    logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

  }
 }

 public void Commonfn_verifyUserAbleToSubmitTheWorkOrder(String userRole, String Test_ID) throws Exception {

   try {
   home.goto_NuvoloAppHomePage(getDriver());
   logger.info("Nuvolo application launched successfully");
   namp.set_impersonateUser(getDriver(), userRole);
   namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
   logger.info("User is able to click on the new work order link");
   NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
   nwo.validateWOMandatoryDetailsAndSaveDraft("1018069", "Device Not Working");
   nwo.clickOnSubmitButton();
   logger.info("User is able to submit the work order successfully");

   } catch (Exception e) {
    e.printStackTrace();

    logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

  }
  finally {
    logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

  }
 }


 public void Commonfn_verifyAllWorkOrderStates(String userRole, String Test_ID)
     throws Exception {

   SoftAssert softAssert = new SoftAssert();
   try {

     home.goto_NuvoloAppHomePage(getDriver());
     logger.info("Nuvolo application launched successfully");
     namp.set_impersonateUser(getDriver(), userRole);
     namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
     logger.info("User is able to click on the new work order link");
     NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
     SeleniumWait.hold(GlobalVariables.mediumSleep);
     softAssert.assertTrue(nwo.isPendingAssignmentBtnAvalable(), "PendingAssignment button is not displaying");
     softAssert.assertTrue(nwo.isPendingAcceptanceBtnAvalable(), "PendingAcceptance button is not  displaying");
     softAssert.assertTrue(nwo.isWorkInProgressBtnAvalable(), "WorkInProgress button is not displaying");
     softAssert.assertTrue(nwo.isOnHoldBtnAvalable(), "On Hold button is not displaying");
     softAssert.assertAll();
     logger.info ("PendingAssignment button, PendingAcceptance button, WorkInProgress button, On Hold button, ClosedComplete");


   } catch (Exception e) {
    e.printStackTrace();

    logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());
    softAssert.fail();
    softAssert.assertAll();
  }
  finally {
    logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

  }
 }


 public void Commonfn_verifyUserAbleToClickOnAssignToMeButton(String userRole, String Test_ID) throws Exception {

   try {
   home.goto_NuvoloAppHomePage(getDriver());
   logger.info("Nuvolo application launched successfully");
   namp.set_impersonateUser(getDriver(), userRole);
   namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
   logger.info("User is able to click on the new work order link");
   NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
   nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
   nwo.verifySaveAndGoButtonFunctionality();
   logger.info("User is able to assign the work order to him self by clicking on Assign To Me button successfully");

   } catch (Exception e) {
    e.printStackTrace();

    logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

  }
  finally {
    logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

  }
 }


 public void Commonfn_verifyUserAbleToClickOnSaveAndStayButton(String userRole, String Test_ID) throws Exception {

   try {
   home.goto_NuvoloAppHomePage(getDriver());
   logger.info("Nuvolo application launched successfully");
   namp.set_impersonateUser(getDriver(), userRole);
   namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
   logger.info("User is able to click on the new work order link");
   NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
   nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
   nwo.verifySaveAndStayButtonFunctionality();
   logger.info("User is able to enter all the details and use the Save and Stay functionality");

   } catch (Exception e) {
    e.printStackTrace();

    logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

  }
  finally {
    logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

  }
 }


 public void Commonfn_verifyUserAbleToClickOnSaveAndGoButton(String userRole, String Test_ID) throws Exception {

   try {
   home.goto_NuvoloAppHomePage(getDriver());
   logger.info("Nuvolo application launched successfully");
   namp.set_impersonateUser(getDriver(), userRole);
   namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
   logger.info("User is able to click on the new work order link");
   NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
   nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
   nwo.verifySaveAndGoButtonFunctionality();
   logger.info("User is able to enter all the details and verified the Save and Go functionality");

   } catch (Exception e) {
    e.printStackTrace();

    logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

  }
  finally {
    logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

  }
 }


 public void Commonfn_verifyAllSectionsUnderWO(String userRole, String Test_ID)
     throws Exception {

   SoftAssert softAssert = new SoftAssert();
   try {
     home.goto_NuvoloAppHomePage(getDriver());
     logger.info("Nuvolo application launched successfully");
     namp.set_impersonateUser(getDriver(), userRole);
     namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
     logger.info("User is able to click on the new work order link");
     NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
     softAssert.assertTrue(nwo.verifyDetailsTabIsAvailable(), "Details Tab is  not displaying");
     softAssert.assertTrue(nwo.verifyResolutionTabIsAvailable(), "Resolution Tab is not displaying");
     softAssert.assertTrue(nwo.verifyFinancialTabIsAvailable(), "Financial Tab is not displaying");
     softAssert.assertTrue(nwo.verifyScheduleTabIsAvailable(), "Schedule Tab is not displaying");
     softAssert.assertTrue(nwo.verifyVariablesTabIsAvailable(), "Variables Tab is not displaying");
     softAssert.assertTrue(nwo.verifyVendorTabIsAvailable(), "Vendor Tab is not displaying");
     softAssert.assertAll();
     logger.info ("User is able to view Details , Resolution, Financial, Schedule, Variables and Vendor Tabs in new work order page");


   } catch (Exception e) {
    e.printStackTrace();

    logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());
    softAssert.fail();
    softAssert.assertAll();
  }
  finally {
    logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

  }
 }


 public void Commonfn_verifyCreateNewWorkOrder_AssignToMe_OnHoldWorkOrder(String userRole, String Test_ID) throws Exception {

   try {
   home.goto_NuvoloAppHomePage(getDriver());
   logger.info("Nuvolo application launched successfully");
   namp.set_impersonateUser(getDriver(), userRole);
   namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
   logger.info("User is able to click on the new work order link");
   NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
   nwo.createNewWorkOrder_OnHold("0009431", "Device Not Working");
   logger.info("Technician is able to view enter all mandatory details and click on AssignToMe button and navigate to till OnHold status");

   } catch (Exception e) {
    e.printStackTrace();

    logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

  }
  finally {
    logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

  }
 }

  public void Commonfn_verifyCreateNewWorkOrder_AssignToMe_OnHoldWorkOrderErrorMessage(String userRole, String Test_ID) throws Exception {

   try {
   home.goto_NuvoloAppHomePage(getDriver());
   logger.info("Nuvolo application launched successfully");
   namp.set_impersonateUser(getDriver(), userRole);
   namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
   logger.info("User is able to click on the new work order link");
   NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
   nwo.createNewWorkOrder_OnHoldErrorMessage("0009431", "Device Not Working");
   logger.info("Technician is able to view enter all mandatory details and click on AssignToMe "
       + "button and verify error message for onHold");


   } catch (Exception e) {
    e.printStackTrace();

    logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

  }
  finally {
    logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

  }
 }


  public void Commonfn_verifyCreateNewWorkOrder_AssignToMe_EnterItemizedCostDetails(String userRole, String Test_ID) throws Exception {

    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateAssignToMe_ItemizedCosts("0009431", "Device Not Working","Labor");
    logger.info("Verify Technician is able to view enter all mandatory details and click on AssignToMe, "
        + "Work inprogress button and Enter itemized cost details");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }

  public void Commonfn_ResolutionDetailsValidation(String userRole, String Test_ID) throws Exception {

    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateAssignToMe_ItemizedCosts("0009431", "Device Not Working","Labor");
    nwo.validateResolutionDetails();
    logger.info("Verify Technician is able to view enter all mandatory details and click on AssignToMe button and Enter resolution details");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }

  public void Commonfn_CompleteWorkOrder(String userRole, String Test_ID) throws Exception {

    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateAssignToMe_ItemizedCosts("0009431", "Device Not Working","Labor");
    nwo.validateResolutionDetails();
    nwo.verifyClickingOnCompleteWorkOrderButton();
    logger.info("Technician is able to assing the work order to himself and complete the work order");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }

  public void Commonfn_CompleteWorkOrderWithExternalTechnician(String userRole, String Test_ID) throws Exception {

    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateAssignToMe_ItemizedCosts("0009431", "Device Not Working","Labors");
    nwo.validateResolutionDetails();
    nwo.validateExternalTechnician();
    nwo.verifyClickingOnCompleteWorkOrderButton();
    logger.info("Technician is able to assign the work order to himself with external technician details and complete the work order");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }



  public void Commonfn_CancelWorkOrder(String userRole, String Test_ID) throws Exception {

    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
    nwo.verifyClickingOnCancelButton();
    logger.info("Technician is able to assign the work order to himself with external technician details and complete the work order");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }




  public void Commonfn_CloseCompleteWorkOrder(String userRole, String Test_ID) throws Exception {

    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
    nwo.verifyClickingOnClosedCompleteButton();
    logger.info("Verify Technician is able complete the work order with all mandataroy details");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }


  public void Commonfn_WorkCompleteWorkOrderErroMessage(String userRole, String Test_ID) throws Exception {

    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
    nwo.verifyClickingOnWorkCompleteButton();
    logger.info("Technician is able complete the work order without entering itemized cost details");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }

  public void Commonfn_UpdateWorkOrderPriorityAndMoveItToWorkInProgress(String userRole, String Test_ID) throws Exception {

    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
    nwo.validateWorkOrderPriority("3");
    logger.info("NationalAdmin is able update the Priority of a WorkOrder");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }





  public void Commonfn_verifyActivitiesDetailsAfterWorkOrderDraft(String userRole, String Test_ID) throws Exception {

    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
    nwo.verifyActivityDetails();
    logger.info("User is able to verify the activities details successfully ");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }

  public void Commonfn_AssisnedUserOpensWorkOrderFromMyWorkOrders(String userRole, String Test_ID) throws Exception {

    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
   // namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
    nwo.workOrderFlowBetweenUsers();
    logger.info("National admin creates work order ans assign to a Technician and Technician completed the work order successfully");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }

  public void Commonfn_WorkOrderFlowBetweenNatioanlAdminToTechnician(String Test_ID , String Status, String ItemizedCost) throws Exception {

    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
    nwo.validateAssignedWorkOrders(Status, ItemizedCost);
    logger.info("User is able to enter the Itemized cost details, Schedule details and Resolution details and Completed the Work order successfully");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }


  public void Commonfn_WorkOrderFlowBetweenDifferentUsers(String userRole, String Test_ID , String Status ,String ItemizedCost) throws Exception {

    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
    nwo.validateAssignedWorkOrders(Status,ItemizedCost);
    logger.info("User is able to enter the Itemized cost details, Schedule details and Resolution details and Completed the Work order successfully");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }


  public void Commonfn_UpdateWorkOrderPriorityAndCompleteTheWorkOrder(String userRole, String Test_ID, String Priority) throws Exception {

    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
    nwo.clickOnAssignToMeButton(userRole);
    nwo.validateWorkOrderPriority(Priority);
    nwo.completeWorkOrder();
    logger.info("NationalAdmin is able update the Priority of a WorkOrder");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }

  public void Commonfn_validateWOMandatoryDetailsAndVerifyRelatedLinksSection1(String userRole, String Test_ID) throws Exception {
    SoftAssert softAssert = new SoftAssert();
    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
    nwo.clickOnDraftButton();
    softAssert.assertTrue(nwo.isworkOrderItemizedCostsTabAvalable(), "WorkOrderItemizedCosts Tab is not displaying");
    softAssert.assertTrue(nwo.isverificationDataTabsTabAvalable(), "VerificationData Tab is not  displaying");
    softAssert.assertTrue(nwo.istoolsTabTabAvalable(), "Tools Tab is displaying");
    softAssert.assertTrue(nwo.isrelatedKnowledgeTabTabAvalable(), "RelatedKnowledge Tab is not displaying");
    softAssert.assertTrue(nwo.isclinicalWorkOrderTasksTabTabAvalable(), "ClinicalWorkOrderTasks Tab is not displaying");
    softAssert.assertTrue(nwo.isClinicalPurchaseRequisitionsTabTabAvalable(), "ClinicalPurchaseRequisitions Tab is not displaying");
    softAssert.assertTrue(nwo.isClinicalTransferOrdersTabTabAvalable(), "ClinicalTransferOrders Tab is not displaying");
    softAssert.assertTrue(nwo.isassetMetricsTabTabTabAvalable(), "AssetMetrics Tab is not  displaying");
    softAssert.assertTrue(nwo.iscontractCoverageTabTabTabAvalable(), "ContractCoverage Tab is not displaying");
    softAssert.assertTrue(nwo.isworkOrderSLATabTabTabAvalable(), "WorkOrderSLA Tab is not displaying");
    softAssert.assertAll();
    logger.info("User is able to save the work order as a draft successfully");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }



  public void Commonfn_validateWOMandatoryDetailsAndVerifyRelatedLinksSection2(String userRole, String Test_ID) throws Exception {

    SoftAssert softAssert = new SoftAssert();
    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
    nwo.clickOnDraftButton();
    softAssert.assertTrue(nwo.isrelatedWorkOrdersTabAvalable(), "RelatedWorkOrdersTab Tab is not displaying");
    softAssert.assertTrue(nwo.isupcomingMaintenancesTabAvalable(), "UpcomingMaintenancesTab Tab is not displaying");
    softAssert.assertTrue(nwo.isclinicalWorkOrderPartsTabAvalable(), "ClinicalWorkOrderPartsTab is not displaying");
    softAssert.assertTrue(nwo.isclinicalWorkOrderSkillsTabAvalable(), "ClinicalWorkOrderSkills Tab is not  displaying");
    softAssert.assertTrue(nwo.isassetVulnerabilitiesTabAvalable(), "AssetVulnerabilitiesTab Tab is not displaying");
    softAssert.assertTrue(nwo.isapproversTabAvalable(), "ApproversTab Tab is not displaying");
    softAssert.assertTrue(nwo.isworkOrderReassignmentsTabAvalable(), "WorkOrderReassignments Tab is not displaying");
    softAssert.assertAll();

    logger.info("User is able to save the work order as a draft successfully");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }

  public void Commonfn_CompleteWorkOrder_DifferentItemizedCosts(String userRole, String Test_ID, String ItemizedCostType) throws Exception {

    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateAssignToMe_ItemizedCosts("0009431", "Device Not Working",ItemizedCostType);
    nwo.validateResolutionDetails();
    nwo.validateScheduleDateDetails();
    nwo.verifyClickingOnCompleteWorkOrderButton();
    logger.info("Technician is able to assing the work order to himself and complete the work order");

    } catch (Exception e) {
     e.printStackTrace();

     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());

   }
   finally {
     logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");

   }
  }


  public void Commonfn_validateCreatingNewClinicalPurchseRequistion(String userRole, String Test_ID) throws Exception {
    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
    nwo.clickOnDraftButton();
    nwo.verifyCreatingNewPurchaseRequistion();
    } catch (Exception e) {
      e.printStackTrace();
     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());
   }
    finally {
      logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");
   }
  }

  public void Commonfn_validateCreatingPreventiveMaintenanceWorkOrder(String userRole, String Test_ID) throws Exception {
    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.verifyWorkOrderPreventiveMaintenance();
    nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
    nwo.clickOnAssignToMeButton(userRole);
    nwo.validateCheckListforPreventiveMaintenance();

    } catch (Exception e) {
      e.printStackTrace();
     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());
   }
    finally {
      logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");
   }
  }


  public void Commonfn_validateCreatingPreventiveMaintenanceWorkOrderAndCompleteWorkOrder(String userRole, String Test_ID) throws Exception {
    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.verifyWorkOrderPreventiveMaintenance();
    nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
    nwo.clickOnAssignToMeButton(userRole);
    nwo.validateCheckListforPreventiveMaintenance();
    nwo.completeWorkOrder();

    } catch (Exception e) {
      e.printStackTrace();
     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());
   }
    finally {
      logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");
   }
  }



  public void Commonfn_validateCreatingNewClinicalPurchseRequistionAndCompleteWorkOrder(String userRole, String Test_ID) throws Exception {
    try {
    home.goto_NuvoloAppHomePage(getDriver());
    logger.info("Nuvolo application launched successfully");
    namp.set_impersonateUser(getDriver(), userRole);
    namp.goto_CAM_IventoryLinks(getDriver(), "New Work Order");
    logger.info("User is able to click on the new work order link");
    NewWorkOrder_Page nwo = new NewWorkOrder_Page(getDriver());
    nwo.validateWOMandatoryDetailsAndSaveDraft("0009431", "Device Not Working");
    nwo.clickOnAssignToMeButton(userRole);
    SeleniumWait.hold(GlobalVariables.mediumSleep);
    nwo.verifyCreatingNewPurchaseRequistion();
    nwo.completeWorkOrder();
    } catch (Exception e) {
      e.printStackTrace();
     logger.error("******" + Test_ID + "  failed. *****\n" + e.toString());
   }
    finally {
      logger.info("\n************Execution of testcase: " + Test_ID + "  ends.************\n");
   }
  }



}






//--------------------------------------------------------------------------------------------------------------------------------------------------
   /*

   @Test (groups = {"CAM_NewWrkOrder_28", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
   @Description("Verify NationalAdmin is able to assign the work order to him self by clciking on Assign To Me  button in new work order page")
   public void CAM_NewWrkOrder_01_TC28() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC28";
   logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NationalAdmin().get("Name") );
    Commonfn_verifyUserAbleToClickOnAssignToMeButton( GlobalVariables.NationalAdmin().get("Name") ,Test_ID);

    }*/


   /*@Test (groups = {"CAM_NewWrkOrder_30", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
   @Description("Verify CampusAdmin is able to enter all the details and click on Save & Stay button for a work order")
   public void CAM_NewWrkOrder_01_TC30() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC30";
     logger.info("Impersonate as a CampusAdmin: " +  GlobalVariables.NCal_OAK_CampusAdmin().get("Name"));
     Commonfn_verifyUserAbleToClickOnSaveAndStayButton(GlobalVariables.NCal_OAK_CampusAdmin().get("Name") ,Test_ID);

    }

   @Test (groups = {"CAM_NewWrkOrder_31", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
   @Description("Verify RegionalAdmin able to enter all the details and click on Save & Stay button for a work order")
   public void CAM_NewWrkOrder_01_TC31() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC31";
    logger.info("Impersonate as a RegionalAdmin: " +  GlobalVariables.NCal_RegionalAdmin().get("Name"));
    Commonfn_verifyUserAbleToClickOnSaveAndStayButton(GlobalVariables.NCal_RegionalAdmin().get("Name") ,Test_ID);

    }

   @Test (groups = {"CAM_NewWrkOrder_32", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
   @Description("Verify NationalAdmin able to enter all the details and click on Save & Stay button for a work order")
   public void CAM_NewWrkOrder_01_TC32() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC32";
    logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NationalAdmin().get("Name") );
    Commonfn_verifyUserAbleToClickOnSaveAndStayButton( GlobalVariables.NationalAdmin().get("Name") ,Test_ID);

    }*/

//---------------------------------------------------------------------------------------------------------------


   /* @Test (groups = {"CAM_NewWrkOrder_34", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
   @Description("Verify CampusAdmin is able to enter all the details and click on Save & Go button for a new work order")
   public void CAM_NewWrkOrder_01_TC34() throws Exception {
     String Test_ID = "CAM_NewWrkOrder_01_TC34";
     logger.info("Impersonate as a CampusAdmin: " +  GlobalVariables.NCal_OAK_CampusAdmin().get("Name"));
     Commonfn_verifyUserAbleToClickOnSaveAndStayButton(GlobalVariables.NCal_OAK_CampusAdmin().get("Name") ,Test_ID);

    }

   @Test (groups = {"CAM_NewWrkOrder_35", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
   @Description("Verify RegionalAdmin able to enter all the details and click on Save & Go button for a new work order")
   public void CAM_NewWrkOrder_01_TC35() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC35";
    logger.info("Impersonate as a RegionalAdmin: " +  GlobalVariables.NCal_RegionalAdmin().get("Name"));
    Commonfn_verifyUserAbleToClickOnSaveAndStayButton(GlobalVariables.NCal_RegionalAdmin().get("Name") ,Test_ID);

    }

   @Test (groups = {"CAM_NewWrkOrder_36", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
   @Description("Verify NationalAdmin able to enter all the details and click on Save & Go button for a new work order")
   public void CAM_NewWrkOrder_01_TC36() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC36";
    logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NationalAdmin().get("Name") );
    Commonfn_verifyUserAbleToClickOnSaveAndStayButton( GlobalVariables.NationalAdmin().get("Name") ,Test_ID);

    }*/

//-------------------------------------------------------------------------------------------------

   /*
   @Test (groups = {"CAM_NewWrkOrder_38", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
   @Description("Verify CampusAdmin is able to view all the sections displayed in new work order page")
   public void CAM_NewWrkOrder_01_TC38() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC38";
    logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NCal_OAK_CampusAdmin().get("Name") );
    Commonfn_verifyAllSectionsUnderWO( GlobalVariables.NCal_OAK_CampusAdmin().get("Name") ,Test_ID);

    }

   @Test (groups = {"CAM_NewWrkOrder_39", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
   @Description("Verify RegionalAdmin is able to view all the sections displayed in new work order page")
   public void CAM_NewWrkOrder_01_TC39() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC39";
    logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NCal_RegionalAdmin().get("Name") );
    Commonfn_verifyAllSectionsUnderWO( GlobalVariables.NCal_RegionalAdmin().get("Name") ,Test_ID);

    }

   @Test (groups = {"CAM_NewWrkOrder_40", "CT_Regression", "Work Order", "NewWorkOrder", "MileStone9"}, enabled = true)
   @Description("Verify NationalAdmin is able to view all the sections displayed in new work order page")
   public void CAM_NewWrkOrder_01_TC40() throws Exception {
    String Test_ID = "CAM_NewWrkOrder_01_TC40";
    logger.info("Impersonate as a NationalAdmin: " + GlobalVariables.NationalAdmin().get("Name") );
    Commonfn_verifyAllSectionsUnderWO( GlobalVariables.NationalAdmin().get("Name") ,Test_ID);

    }

   }*/


