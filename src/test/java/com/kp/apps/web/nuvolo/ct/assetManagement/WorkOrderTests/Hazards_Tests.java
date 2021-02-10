package com.kp.apps.web.nuvolo.ct.assetManagement.WorkOrderTests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kp.apps.web.library.Functions;
import com.kp.apps.web.library.GlobalVariables;
import com.kp.apps.web.nuvolo.application.HomePage;
import com.kp.apps.web.nuvolo.application.NuvoloAppMenu;
import com.kp.apps.web.nuvolo.ct.assetManagement.WorkOrder.HazardsBuilder;
import com.kp.apps.web.nuvolo.ct.assetManagement.WorkOrder.HazardsPage;
import com.kp.apps.web.nuvolo.functions.BaseTest;


public class Hazards_Tests extends BaseTest {
	
	 private Logger             logger      = Logger.getLogger(Hazards_Tests.class);
	
	  HomePage                   home        = new HomePage();
	  NuvoloAppMenu              namp        = new NuvoloAppMenu();
	  CompanyFiltersPage         cfp         = new CompanyFiltersPage();
	  Functions                  functions   = new Functions();

	  CompanyFiltersPage         cfilterPage = new CompanyFiltersPage();
	  
	  HazardsPage  hp = new HazardsPage();




	  /**
	   * 10 test cases
	   */
	  // National Yes No Yes No Yes Verify that the user is able to click on Hazards Type  link and New button is displayed
	  //
	  @Test(
	      groups = {"CAMA_Hazards_01_TC01", "CT_BVT", "", "CT_Regression", "Hazards", "Milestone11"},
	      enabled = true)
	  public void CAMA_Hazards_01_TC01() throws Exception {
	    String Test_ID = "CAMA_Hazards_01_TC01";
	    String result = "Failed";
	    HazardsBuilder hb = new HazardsBuilder();
	    try {
	      home.goto_NuvoloAppHomePage(getDriver());
	      cfilterPage.switchUserInPersonation(getDriver(), GlobalVariables.NationalAdmin().get("NameNational"));
	      hb.setVerifyHazardTypesScreen(true);
	      hp.manageHazardTypes(getDriver(), false, hb);
	      result = "Passed";
	    } catch (Exception e) {
	      result = "Failed";
	      logger.error("******************" + Test_ID + "  failed. *****\n" + e.toString());
	      e.printStackTrace();
	      Assert.fail();
	    }
	    finally {
	      logger.info("\n*****************************Execution of testcase: " + Test_ID
	          + "  ends.******************************\n");
	  
	      
	    }
	  }

	  // Verify error message after clicking on submit button when no mandatory fields are selected

	  @Test(
	      groups = {"CAMA_Hazards_01_TC02", "CT_BVT", "", "CT_Regression", "Hazards", "Milestone11"},
	      enabled = true)
	  public void CAMA_Hazards_01_TC02() throws Exception {
	    String Test_ID = "CAMA_Hazards_01_TC02";
	    String result = "Failed";
	    HazardsBuilder hb = new HazardsBuilder();
	    try {
	      home.goto_NuvoloAppHomePage(getDriver());
	      cfilterPage.switchUserInPersonation(getDriver(),GlobalVariables.NationalAdmin().get("NameNational"));
	      hb.setVerifyErrorMssg(true);
	      hp.manageHazardTypes(getDriver(), false, hb);
	      result = "Passed";
	    } catch (Exception e) {
	      result = "Failed";
	      logger.error("******************" + Test_ID + "  failed. *****\n" + e.toString());
	      e.printStackTrace();
	      Assert.fail();
	    }
	    finally {
	      logger.info("\n*****************************Execution of testcase: " + Test_ID
	          + "  ends.******************************\n");
	  
	      
	    }
	  }

	  // National Yes No Yes No Yes Verify the Hazard Types fields are enabled
	  @Test(groups = {"CAMA_Hazards_01_TC03", "", "", "CT_Regression", "Hazards", "Milestone10"},
	      enabled = true)
	  public void CAMA_Hazards_01_TC03() throws Exception {
	    String Test_ID = "CAMA_Hazards_01_TC03";
	    String result = "Failed";
	    HazardsBuilder hb = new HazardsBuilder();
	    try {
	     home.goto_NuvoloAppHomePage(getDriver());
	      cfilterPage.switchUserInPersonation(getDriver(),
	          GlobalVariables.NationalAdmin().get("NameNational"));
	      hb.setVerifyEnabledFields(true);
	      hp.manageHazardTypes(getDriver(), false, hb);
	      result = "Passed";
	    } catch (Exception e) {
	      result = "Failed";
	      logger.error("******************" + Test_ID + "  failed. *****\n" + e.toString());
	      e.printStackTrace();
	      Assert.fail();
	    }
	    finally {
	      logger.info("\n*****************************Execution of testcase: " + Test_ID
	          + "  ends.******************************\n");
	  
	      
	    }
	  }
	    //passed 7/28
	  // National Yes No Yes No Yes as a user create a new Hazard Type record
	  @Test(groups = {"CAMA_Hazards_01_TC04", "", "", "CT_Regression", "Hazards", "Milestone10"},
	      enabled = true)
	  public void CAMA_Hazards_01_TC04() throws Exception {
	    String Test_ID = "CAMA_Hazards_01_TC04";
	    String result = "Failed";
	    HazardsBuilder hb = new HazardsBuilder();
	    try {
	      home.goto_NuvoloAppHomePage(getDriver());
	      cfilterPage.switchUserInPersonation(getDriver(),
	          GlobalVariables.NationalAdmin().get("NameNational"));
	      hb.setDescription("testing");
	      hb.setHazardTypeTextBox("hazard test");
	      hb.setVerifyNewHazardType(true);
	      hp.manageHazardTypes(getDriver(), true, hb);

	      result = "Passed";
	    } catch (Exception e) {
	      result = "Failed";
	      logger.error("******************" + Test_ID + "  failed. *****\n" + e.toString());
	      e.printStackTrace();
	      Assert.fail();
	    }
	    finally {
	      logger.info("\n*****************************Execution of testcase: " + Test_ID
	          + "  ends.******************************\n");
	  
	      
	    }
	  }

	    //test case passed 726
	  // as a National User I should be able to click on the All link and validate im on the 'All' Hazard Type
	  @Test(groups = {"CAM_Hazard_01_TC05", "", "", "CT_Regression", "Hazard", "Milestone10"},
	      enabled = true)
	  public void CAM_Hazard_01_TC05() throws Exception {
	    String Test_ID = "CAM_Hazard_01_TC05";
	    String result = "Failed";
	    HazardsBuilder hb = new HazardsBuilder();

	    try {
	      home.goto_NuvoloAppHomePage(getDriver());
	      cfilterPage.switchUserInPersonation(getDriver(),
	          GlobalVariables.NationalAdmin().get("NameNational"));
	      hb.setVerifyAllHazardTypesScreen(true);
	      hp.manageHazardTypes(getDriver(), false, hb);
	      result = "Passed";
	    } catch (Exception e) {
	      result = "Failed";
	      logger.error("******************" + Test_ID + "  failed. *****\n" + e.toString());
	      e.printStackTrace();
	      Assert.fail();
	    }
	    finally {
	      logger.info("\n*****************************Execution of testcase: " + Test_ID
	          + "  ends.******************************\n");
	  
	      
	    }
	  }

	  // National Yes No Yes No Yes Verify that the user is able to click on Hazards  link and New button is displayed
	  //
	  @Test(
	      groups = {"CAMA_Hazards_01_TC06", "CT_BVT", "", "CT_Regression", "Hazards", "Milestone11"},
	      enabled = true)
	  public void CAMA_Hazards_01_TC06() throws Exception {
	    String Test_ID = "CAMA_Hazards_01_TC06";
	    String result = "Failed";
	    HazardsBuilder hb = new HazardsBuilder();
	    try {
	      home.goto_NuvoloAppHomePage(getDriver());
	      cfilterPage.switchUserInPersonation(getDriver(), GlobalVariables.NationalAdmin().get("NameNational"));
	      hb.setVerifyHazardsScreen(true);
	      hp.manageHazards(getDriver(), false, hb);
	      result = "Passed";
	    } catch (Exception e) {
	      result = "Failed";
	      logger.error("******************" + Test_ID + "  failed. *****\n" + e.toString());
	      e.printStackTrace();
	      Assert.fail();
	    }
	    finally {
	      logger.info("\n*****************************Execution of testcase: " + Test_ID
	          + "  ends.******************************\n");
	  
	      
	    }
	  }

	  // Verify error message after clicking on submit button when no mandatory fields are selected in Hazards

	  @Test(
	      groups = {"CAMA_Hazards_01_TC07", "CT_BVT", "", "CT_Regression", "Hazards", "Milestone11"},
	      enabled = true)
	  public void CAMA_Hazards_01_TC07() throws Exception {
	    String Test_ID = "CAMA_Hazards_01_TC07";
	    String result = "Failed";
	    HazardsBuilder hb = new HazardsBuilder();
	    try {
	      home.goto_NuvoloAppHomePage(getDriver());
	      cfilterPage.switchUserInPersonation(getDriver(),GlobalVariables.NationalAdmin().get("NameNational"));
	      hb.setVerifyErrorMssgOnHazzardsPage(true);
	      hp.manageHazards(getDriver(), false, hb);
	      result = "Passed";
	    } catch (Exception e) {
	      result = "Failed";
	      logger.error("******************" + Test_ID + "  failed. *****\n" + e.toString());
	      e.printStackTrace();
	      Assert.fail();
	    }
	    finally {
	      logger.info("\n*****************************Execution of testcase: " + Test_ID
	          + "  ends.******************************\n");
	  
	      
	    }
	  }

	  // National Yes No Yes No Yes Verify the Hazards fields are enabled
	  @Test(groups = {"CAMA_Hazards_01_TC08", "", "", "CT_Regression", "Hazards", "Milestone10"},
	      enabled = true)
	  public void CAMA_Hazards_01_TC08() throws Exception {
	    String Test_ID = "CAMA_Hazards_01_TC08";
	    String result = "Failed";
	    HazardsBuilder hb = new HazardsBuilder();
	    try {
	     home.goto_NuvoloAppHomePage(getDriver());
	      cfilterPage.switchUserInPersonation(getDriver(),
	          GlobalVariables.NationalAdmin().get("NameNational"));
	      hb.setVerifyEnabledFieldsinHazardsPage(true);
	      hp.manageHazards(getDriver(), false, hb);
	      result = "Passed";
	    } catch (Exception e) {
	      result = "Failed";
	      logger.error("******************" + Test_ID + "  failed. *****\n" + e.toString());
	      e.printStackTrace();
	      Assert.fail();
	    }
	    finally {
	      logger.info("\n*****************************Execution of testcase: " + Test_ID
	          + "  ends.******************************\n");
	  
	      
	    }
	  }

	  // National Yes No Yes No Yes as a user create a new Hazards record
	  @Test(groups = {"CAMA_Hazards_01_TC09", "", "", "CT_Regression", "Hazards", "Milestone10"},
	      enabled = true)
	  public void CAMA_Hazards_01_TC09() throws Exception {
	    String Test_ID = "CAMA_Hazards_01_TC09";
	    String result = "Failed";
	    HazardsBuilder hb = new HazardsBuilder();
	    try {
	      home.goto_NuvoloAppHomePage(getDriver());
	      cfilterPage.switchUserInPersonation(getDriver(),
	          GlobalVariables.NationalAdmin().get("NameNational"));
	      hb.setHazardsType("Temperature");
	      hb.setHazardsShortDescription("Test");
	      hb.setVerifyHazardsSavedPage(true);
	      hp.manageHazards(getDriver(), true, hb);

	      result = "Passed";
	    } catch (Exception e) {
	      result = "Failed";
	      logger.error("******************" + Test_ID + "  failed. *****\n" + e.toString());
	      e.printStackTrace();
	      Assert.fail();
	    }
	    finally {
	      logger.info("\n*****************************Execution of testcase: " + Test_ID
	          + "  ends.******************************\n");
	  
	      
	    }
	  }

	  // National Yes No Yes No Yes as a user create a new Hazards record with Hazardous Materials
	  @Test(groups = {"CAMA_Hazards_01_TC10", "", "", "CT_Regression", "Hazards", "Milestone10"},
	      enabled = true)
	  public void CAMA_Hazards_01_TC10() throws Exception {
	    String Test_ID = "CAMA_Hazards_01_TC10";
	    String result = "Failed";
	    HazardsBuilder hb = new HazardsBuilder();
	    try {
	      home.goto_NuvoloAppHomePage(getDriver());
	      cfilterPage.switchUserInPersonation(getDriver(),
	          GlobalVariables.NationalAdmin().get("NameNational"));
	      hb.setHazardsType("Temperature");
	      hb.setHazardsShortDescription("Test");
	      hb.setVerifyHazardsSavedPage(true);
	      hb.setHazardousMaterialsCheckBox(true);
	      hp.manageHazards(getDriver(), true, hb);

	      result = "Passed";
	    } catch (Exception e) {
	      result = "Failed";
	      logger.error("******************" + Test_ID + "  failed. *****\n" + e.toString());
	      e.printStackTrace();
	      Assert.fail();
	    }
	    finally {
	      logger.info("\n*****************************Execution of testcase: " + Test_ID
	          + "  ends.******************************\n");
	  
	      
	    }
	  }

}
