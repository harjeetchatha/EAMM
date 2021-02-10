package com.kp.apps.web.library;

/**
 * Function: Result Backup
 * 
 * @author HariKrishna Pesala
 */

public class BackUP {
  public static String sResBackUp = "./res/TestReport.txt";
  // Functions Function=new Functions();
  boolean masterTemp = true;
  protected long tcTimeBg, tcTimeEd;
  protected String testCaseName;
  boolean Success = true;
  static String result = "Failed";
  static String browserPath = "";
  static String propertyCountry = "";
  static String timeOut = "";
  static String threadSleep = "5000";
  static String pageDelay = "8000";
  static String longDelay = "10000";

  // @Test(groups = {"BackUP"}, description = "Results file creation", alwaysRun = true)
  // @BeforeSuite(alwaysRun = true)
  public static void AAResultsBackUp() throws Exception {
    System.out.println("*****Begining of ResultsBackUp *********************");
    try {
      TestResults.CreateResultTxt();
      System.out.println("*****Ending of ResultsBackUp *********************");
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println("Exception happened in executing test case ResultsBackUp");
      System.out.println("*****Ending of ResultsBackUp*********************");
      // fail("ResultsBackUp test case has been failed.");
    }
  }
}
