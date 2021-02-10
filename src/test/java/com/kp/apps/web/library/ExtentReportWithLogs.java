package com.kp.apps.web.library;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportWithLogs {

  private static ExtentReportWithLogs instance = null;
  private ExtentReports               extent   = null;

  private ExtentReportWithLogs() {
    ExtentHtmlReporter reporter =
        new ExtentHtmlReporter(Functions.getTimeStamp() + "AutomationExtentReport.html");
    extent = new ExtentReports();
    extent.attachReporter(reporter);
  }

  public static ExtentReportWithLogs getInstance() {
    if (instance == null)
      instance = new ExtentReportWithLogs();
    return instance;
  }

  public ExtentReports getReports() {
    return extent;
  }

}
