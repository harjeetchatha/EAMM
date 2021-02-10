package com.kp.apps.web.library;

import com.gargoylesoftware.htmlunit.html.HtmlListing;

import java.util.HashMap;

/**
 *
 * @author HariKrishna Pesala
 */
public class GlobalVariables {


  public static String                  sComputerName;
  public static String                  CapitalProject                    = null;
  public static String                  AssetTag                          = null;
  public static String                  Room                              = null;
  public static String                  GL_Account                        = null;
  public static String                  AssetAvailableDate                = null;
  public static String                  AssetNumber                       = null;
  public static String                  GL_Department                     = null;
  public static String                  GL_Location                       = null;
  public static String                  GL_BusinessUnit                   = null;
  public static String                  CT_workOrderPattern               = "CWKD";
  public static String                  FO_workOrderPattern               = "FWKD";

  public static boolean                 bfileupload                       = false;
  public static String                  RequestedFor                      = null;
  public static String                  UserID                            = null;
  public static String                  BestContactNumber                 = null;
  public static String                  Role                              = null;
  public static String                  AlternateContact                  = null;
  // public static String sUploadfilesPath = ".\\src\\test\\resources\\uploadfiles\\";
  public static String                  sUploadfilesPath                  =
                                                                              "./src/test/resources/uploadfiles/";

  public static String                  Asset_DecommissioningDate         = null;
  public static String                  AssignmentGroup                   = null;
  public static String                  AdditionalNote                    = null;
  public static String                  DescriptionofRequest              = null;
  public static String                  WorkHours                         = null;
  public static String                  AlternateContactNumber            = null;

  public static String                  DepartmentManager                 = null;

  public static String                  Justification                     = null;
  public static String                  DescribeAsset_BeingDecommissioned = null;

  public static String                  ServiceType                       = null;
  public static String                  IssueCategory                     = "Other";
  public static String                  Floor                             = null;
  public static String                  Site                              = null;
  public static String                  Campus                            = null;
  public static String                  Region                            = null;
  public static String                  sWorkspace                        =
                                                                              System
                                                                                  .getProperty("user.dir");
  public static String                  env                               =
                                                                              System
                                                                                  .getProperty("environment_for_test");

  public static String                  AssetType;
  public static String                  sProperties                       = "default.properties";
  public static String                  KPLoginUsername;
  public static String                  KPLoginPassword;
  public static Object                  Pagetimeout;
  public static String                  environment;
  public static String                  NuvoloCustomerPortalURL;
  public static String                  GoogleApplicationURL;


  public static long                    profile_delay;
  public static long                    ShortSleep                        = 1000;
  public static long                    mediumSleep                       = 3000;
  public static long                    longSleep                         = 5000;
  public static long                    xlongSleep                        = 8000;
  public static long                    vvlongSleep                       = 11000;

  public static String                  browser;
  public static String                  sResBackUp                        = "./res/TestReport.txt";
  public static String                  sTestDataFile;
  // = "./src/test/resources/TestData.xls";
  public static String                  systemUserName;

  public static String                  testCompanyMftrVendorName          = null;
  public static String                  testCompanyMftrName                = null;
  public static String                  testCompanyMftrPayeeName           = null;

  public static String                  testPartName                      = null;
  public static String                  testPartTypeName                  = null;
  public static String                  testModelName                     = null;
  public static String                  testAssetType                     = "Ophthalmology Miscellaneous";
  public static String                  testEndOfLifeInMonths             = "6";

  /*
    CT CN Instrumentation Roseville
    User
    G961220
    ANDREW w. snyder

    CT CN Instrumentation Roseville
    User
    T294649
    Billy Ollis

    CT CN Instrumentation Roseville
    User
    D114950
    Jaclyn R. Duncan

    CT CN Instrumentation Roseville
    User
    K257518
    Jesus Lopez

    CT CN Instrumentation Roseville
    User
    H191644
    Shane A. Hockett

    EAMM National Admin
    National Admin
    D111980
    Dale A. Durham

    EAMM National Admin
    National Admin
    W805831
    David Lloyd

    */

  public static HashMap<String, String> NationalAdmin() {
    HashMap<String, String> NationalAdmin = new HashMap<String, String>();

NationalAdmin.put("Name", "David Lloyd");
NationalAdmin.put("NameNational", "David Lloyd");

 //NationalAdmin.put("Name", "Harjeet Chatha");
 //NationalAdmin.put("NameNational", "Harjeet Chatha");
  NationalAdmin.put("Phone", "d");
  NationalAdmin.put("Email", "d");
  NationalAdmin.put("Role", "National Admin");
  NationalAdmin.put("NUID", "W805831");
  NationalAdmin.put("Group", "EAMM National Admin");
  return NationalAdmin;

}


public static HashMap<String, String> NCal_RegionalAdmin() {
 HashMap<String, String> NCal_RegionalAdmin = new HashMap<String, String>();
 NCal_RegionalAdmin.put("Name", "Sharon Abeleda");
 NCal_RegionalAdmin.put("Phone", "d");
 NCal_RegionalAdmin.put("Email", "d");
 NCal_RegionalAdmin.put("Role", "Regional Admin");
 NCal_RegionalAdmin.put("NUID", "Q286679");
 NCal_RegionalAdmin.put("Group", "CT CN Regional Admin");
 NCal_RegionalAdmin.put("Region", "Northern California");
 return NCal_RegionalAdmin;
}

//public static HashMap<String, String> SCal2_RegionalAdmin() {
// HashMap<String, String> SCal_RegionalAdmin = new HashMap<String, String>();
// SCal_RegionalAdmin.put("Name", "Rommelynn J. Miguel");
// SCal_RegionalAdmin.put("Phone", "d");
// SCal_RegionalAdmin.put("Email", "d");
// SCal_RegionalAdmin.put("Role", "Regional Admin");
// SCal_RegionalAdmin.put("NUID", "M949461");
// SCal_RegionalAdmin.put("Group", "CT CS Regional Admin");
// SCal_RegionalAdmin.put("Region", "Southern California");
// return SCal_RegionalAdmin;
//}



public static HashMap<String, String> NCal_Roseville_CampusAdmin() {
 HashMap<String, String> NCal_Roseville_CampusAdmin = new HashMap<String, String>();
 NCal_Roseville_CampusAdmin.put("Name", "Andrew J. Davis");
 NCal_Roseville_CampusAdmin.put("Role", "Campus Admin");
 NCal_Roseville_CampusAdmin.put("Phone", "d");
 NCal_Roseville_CampusAdmin.put("NUID", "H662882");
 NCal_Roseville_CampusAdmin.put("Group", "CT CN Campus Admin Roseville");
 return NCal_Roseville_CampusAdmin;

}


public static HashMap<String, String> NCal_OAK_CampusAdmin() {
HashMap<String, String> NCal_OAK_CampusAdmin = new HashMap<String, String>();
 NCal_OAK_CampusAdmin.put("Name", "Ryan A. Otto");//William K. Rojek// new  Ryan A. Otto
 NCal_OAK_CampusAdmin.put("Role", "Campus Admin");
 NCal_OAK_CampusAdmin.put("Phone", "d");
 NCal_OAK_CampusAdmin.put("NUID", "D182929");
 NCal_OAK_CampusAdmin.put("Group", "CT CN Campus Admin Oakland");
 NCal_OAK_CampusAdmin.put("Region", "Northern California");
 return NCal_OAK_CampusAdmin;
}


public static HashMap<String, String> NCal_OAK_Technician() {
 HashMap<String, String> NCal_OAK_Technician = new HashMap<String, String>();
 NCal_OAK_Technician.put("Name", "Dana R. Massey"); //Nick Anthony B. REYES // new  Cris Tongol
 NCal_OAK_Technician.put("Phone", "d");
 NCal_OAK_Technician.put("Email", "d");
 NCal_OAK_Technician.put("Role", "User");
 NCal_OAK_Technician.put("NUID", "G287672");
 NCal_OAK_Technician.put("Group", "CT CN Instrumentation Oakland");
 NCal_OAK_Technician.put("Region", "Northern California");
 return NCal_OAK_Technician;

}


public static HashMap<String, String> NCal_OAK_Customer() {
 HashMap<String, String> NCal_OAK_Customer = new HashMap<String, String>();
 NCal_OAK_Customer.put("StockroomName", "Test_");
 NCal_OAK_Customer.put("Name", "Mony Singh");
 NCal_OAK_Customer.put("Phone", "d");
 NCal_OAK_Customer.put("Email", "d");
 NCal_OAK_Customer.put("Role", "");
 NCal_OAK_Customer.put("NUID", "");
 NCal_OAK_Customer.put("Group", "");
 NCal_OAK_Customer.put("Region", "Northern California");
 NCal_OAK_Customer.put("Option", "floor.building.campus.region.name");
 NCal_OAK_Customer.put("Location", "2910");
 return NCal_OAK_Customer;
}

public static HashMap<String, String> SCal_DOWNEY_Customer() {
 HashMap<String, String> SCal_DOWNEY_Customer = new HashMap<String, String>();
 SCal_DOWNEY_Customer.put("StockroomName", "Test_");
 SCal_DOWNEY_Customer.put("Name", "Mony Singh");
 SCal_DOWNEY_Customer.put("Phone", "d");
 SCal_DOWNEY_Customer.put("Email", "d");
 SCal_DOWNEY_Customer.put("Role", "");
 SCal_DOWNEY_Customer.put("NUID", "");
 SCal_DOWNEY_Customer.put("Group", "");
 SCal_DOWNEY_Customer.put("Region", "Southern California");
 SCal_DOWNEY_Customer.put("Option", "floor.building.campus.region.name");
 SCal_DOWNEY_Customer.put("Location", "EL03");
 return SCal_DOWNEY_Customer;
}

public static HashMap<String, String> NCal_SACRAMENTO_Customer() {
 HashMap<String, String> NCal_PERSONAL_STOCKROOM_Customer = new HashMap<String, String>();
 NCal_PERSONAL_STOCKROOM_Customer.put("StockroomName", "Test_");
 NCal_PERSONAL_STOCKROOM_Customer.put("Name", "Mony Singh");
 NCal_PERSONAL_STOCKROOM_Customer.put("Phone", "d");
 NCal_PERSONAL_STOCKROOM_Customer.put("Email", "d");
 NCal_PERSONAL_STOCKROOM_Customer.put("Role", "");
 NCal_PERSONAL_STOCKROOM_Customer.put("NUID", "");
 NCal_PERSONAL_STOCKROOM_Customer.put("Group", "");
 NCal_PERSONAL_STOCKROOM_Customer.put("Region", "North California");
 NCal_PERSONAL_STOCKROOM_Customer.put("Option", "floor.building.campus.region.name");
 NCal_PERSONAL_STOCKROOM_Customer.put("Location", "2910");
 return NCal_PERSONAL_STOCKROOM_Customer;
}

public static HashMap<String, String> NCal_PERSONAL_STOCKROOM_Customer() {
 HashMap<String, String> NCal_PERSONAL_STOCKROOM_Customer = new HashMap<String, String>();
 NCal_PERSONAL_STOCKROOM_Customer.put("StockroomName", "Harjeet Truck");
 NCal_PERSONAL_STOCKROOM_Customer.put("Name", "Harjeet Chatha");
 NCal_PERSONAL_STOCKROOM_Customer.put("Phone", "d");
 NCal_PERSONAL_STOCKROOM_Customer.put("Email", "d");
 NCal_PERSONAL_STOCKROOM_Customer.put("Role", "");
 NCal_PERSONAL_STOCKROOM_Customer.put("NUID", "");
 NCal_PERSONAL_STOCKROOM_Customer.put("Group", "");
 NCal_PERSONAL_STOCKROOM_Customer.put("Region", "North California");
 NCal_PERSONAL_STOCKROOM_Customer.put("Option", "floor.building.campus.region.name");
 NCal_PERSONAL_STOCKROOM_Customer.put("Location", "2910");
 return NCal_PERSONAL_STOCKROOM_Customer;
}

public static HashMap<String, String> COL_Locations() {
 HashMap<String, String> NCal_OAK_locations = new HashMap<String, String>();
 NCal_OAK_locations.put("SearchOption", "floor.building.campus.region.name");
 NCal_OAK_locations.put("Region", "Colorado Region");
 NCal_OAK_locations.put("Location", "21R80");
 NCal_OAK_locations.put("Loc1", "");
NCal_OAK_locations.put("Loc1 ID", "");
 NCal_OAK_locations.put("Loc1", "");
 NCal_OAK_locations.put("Loc1", "North California");
 return NCal_OAK_locations;
}

public static HashMap<String, String> NCal_OAK_locations() {
 HashMap<String, String> NCal_OAK_locations = new HashMap<String, String>();
 NCal_OAK_locations.put("LOC1", "Mony Singh");
 NCal_OAK_locations.put("Loc1", "d");
 NCal_OAK_locations.put("Loc1", "d");
 NCal_OAK_locations.put("Loc1", "");
 NCal_OAK_locations.put("Loc1 ID", "");
 NCal_OAK_locations.put("Loc1", "");
 NCal_OAK_locations.put("Loc1", "North California");
 return NCal_OAK_locations;
}



public static HashMap<String, String> SCal_RegionalAdmin() {
 HashMap<String, String> SCal_RegionalAdmin = new HashMap<String, String>();
 SCal_RegionalAdmin.put("Name", "b");
 SCal_RegionalAdmin.put("Phone", "d");
 SCal_RegionalAdmin.put("Email", "d");
 SCal_RegionalAdmin.put("Role", "Regional Admin");
 SCal_RegionalAdmin.put("NUID", "");
 SCal_RegionalAdmin.put("Group", "");
 return SCal_RegionalAdmin;
}

public static HashMap<String, String> SCal_LA_CampusAdmin() {
 HashMap<String, String> SCal_LA_CampusAdmin = new HashMap<String, String>();
 SCal_LA_CampusAdmin.put("Name", "b");
 SCal_LA_CampusAdmin.put("Phone", "d");
 SCal_LA_CampusAdmin.put("Email", "d");
 SCal_LA_CampusAdmin.put("Role", "Campus Admin");
 SCal_LA_CampusAdmin.put("NUID", "");
 SCal_LA_CampusAdmin.put("Group", "");
 return SCal_LA_CampusAdmin;
}

public static HashMap<String, String> SCal_LA_Technician() {
 HashMap<String, String> SCal_LA_Technician = new HashMap<String, String>();
 SCal_LA_Technician.put("Name", "b");
 SCal_LA_Technician.put("Phone", "d");
 SCal_LA_Technician.put("Email", "d");
 SCal_LA_Technician.put("Role", "User");
 SCal_LA_Technician.put("NUID", "");
 SCal_LA_Technician.put("Group", "");
 return SCal_LA_Technician;
}


public static HashMap<String, String> SCal_LA_Customer() {
 HashMap<String, String> SCal_LA_Customer = new HashMap<String, String>();
 SCal_LA_Customer.put("Name", "b");
 SCal_LA_Customer.put("Phone", "d");
 SCal_LA_Customer.put("Email", "d");
 SCal_LA_Customer.put("Role", "");
 SCal_LA_Customer.put("NUID", "");
 SCal_LA_Customer.put("Group", "");
 return SCal_LA_Customer;
}
public static HashMap<String, String>  FO_NCal_SAC_User() {
 HashMap<String, String>  FO_NCal_SAC_User = new HashMap<String, String>();
FO_NCal_SAC_User.put("Name", "Ronald R. Cook");
FO_NCal_SAC_User.put("Role", "User");
FO_NCal_SAC_User.put("Phone", "d");
FO_NCal_SAC_User.put("NUID", "P210078");
FO_NCal_SAC_User.put("Group", "FO CN Engineering Sacramento");
FO_NCal_SAC_User.put("Region", "Northern California");
return  FO_NCal_SAC_User;

}

public static HashMap<String, String>  FO_NCal_SAC_CampusAdmin() {
  HashMap<String, String>  FO_NCal_SAC_CampusAdmin = new HashMap<String, String>();
  FO_NCal_SAC_CampusAdmin.put("Name", "Jon C. Blanton");
  FO_NCal_SAC_CampusAdmin.put("Role", "Campus Admin");
  FO_NCal_SAC_CampusAdmin.put("Phone", "d");
  FO_NCal_SAC_CampusAdmin.put("NUID", "A363394");
  FO_NCal_SAC_CampusAdmin.put("Group", "FO CN Campus Admin San Jose");
  FO_NCal_SAC_CampusAdmin.put("Region", "Northern California");
  return FO_NCal_SAC_CampusAdmin;

}
  public enum browser_list {
    IE, CHROME;
  }
}
