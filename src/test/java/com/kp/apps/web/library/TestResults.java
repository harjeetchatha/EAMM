package com.kp.apps.web.library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Assert;

/**
 * 
 * @author HariKrishna Pesala
 */
public class TestResults {

  public static String sResBackUp = "./res/";
  public static String sResFile = "TestReport.txt";
  public static String slogBackUp = "./logs/";
  public static String slogFile = "log.out";

  private static String getDateTime() {
    DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
    Date date = new Date();
    return dateFormat.format(date);
  }

  public static boolean ResultsBackup(Integer iCount, String filename) throws IOException {
    String sResultBackUP;
    File file = new File(filename);
    try {
      if (file.exists()) {
        sResultBackUP = sResBackUp + "TestReport-" + getDateTime() + "-R" + iCount + ".txt";
        // System.out.println("File name found.");
        if (new File(sResultBackUP).exists()) {
          System.out.println("TestReport-" + getDateTime() + "-R" + iCount + ".txt already exists");
          return false;
        } else {
          file.renameTo(new File(sResultBackUP));
          System.out.println("TestReport.txt is renamed to TestReport-" + getDateTime() + "-R"
              + iCount + ".txt");
          return true;
        }
      } else {
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }


  public static boolean logBackup(Integer iCount, String filename) throws IOException {
    String slog;
    File file = new File(filename);
    try {
      if (file.exists()) {
        slog = slogBackUp + "log-" + getDateTime() + "-R" + iCount + ".out";
        // System.out.println("File name found.");
        if (new File(slog).exists()) {
          System.out.println("log-" + getDateTime() + "-R" + iCount + ".out already exists");
          return false;
        } else {
          file.renameTo(new File(slog));
          System.out.println("log.out is renamed to log-" + getDateTime() + "-R" + iCount + ".out");
          return true;
        }
      } else {
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }



  public static void Createlog() throws IOException {
    Integer iCount = 1;
    String filename = slogBackUp + slogFile;
    File f;
    try {
      while (logBackup(iCount, filename) != true) {
        iCount++;
      }
      f = new File("./logs/log.out");
      if (!f.exists()) {
        f.createNewFile();
        System.out.println("New file \"log.out\" has been created to the current directory");
        Assert.assertTrue(true, "slogBackUp test case has been Passed.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail("slogBackUp test case has been failed.");
    }
  }


  public static void CreateResultTxt() throws IOException {
    Integer iCount = 1;
    String filename = sResBackUp + sResFile;
    File f;
    try {
      while (ResultsBackup(iCount, filename) != true) {
        iCount++;
      }
      f = new File("./res/TestReport.txt");
      if (!f.exists()) {
        f.createNewFile();
        System.out.println("New file \"TestReport.txt\" has been created to the current directory");
        Assert.assertTrue(true, "ResultsBackUp test case has been Passed.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail("ResultsBackUp test case has been failed.");
    }
  }

  public static String ExportResultToTxt(String sWriteStr, String sResFile) throws IOException {
    String line;
    String newLine = System.getProperty("line.separator");
    StringBuffer sb = new StringBuffer();
    boolean bStatus = false;
    try {

      int sTestIDlength = sWriteStr.length();
      while (sTestIDlength < 100) {
        sWriteStr = sWriteStr + " ";
        sTestIDlength = sWriteStr.length();
      }

      FileInputStream fis = new FileInputStream(sResFile);
      BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
      String[] sTestCaseID = sWriteStr.split("\t");

      while ((line = reader.readLine()) != null) {
        // System.out.println("File name1 found.");
        String[] fields = line.split("\t");
        if (fields[0].equalsIgnoreCase(sTestCaseID[0])) {
          line = line.replaceAll(line, sWriteStr);
          sb.append(line);
          sb.append(newLine);
          bStatus = true;
        } else {
          sb.append(line);
          sb.append(newLine);
        }
      }
      // System.out.println("File name2 found.");
      if (!bStatus) {
        sb.append(sWriteStr);
        sb.append(newLine);
      }
      reader.close();
      BufferedWriter out = new BufferedWriter(new FileWriter(sResFile));
      out.write(sb.toString());
      out.close();
    } catch (Throwable e) {
      e.printStackTrace();
      System.err.println("*** exception ***");
    }
    return "";
  }


  public static String ExportTxtResultTohtml(String sWriteStr, String sResFile) throws IOException {
    String line;
    String newLine = System.getProperty("line.separator");
    StringBuffer sb = new StringBuffer();
    boolean bStatus = false;
    try {

      int sTestIDlength = sWriteStr.length();
      while (sTestIDlength < 100) {
        sWriteStr = sWriteStr + " ";
        sTestIDlength = sWriteStr.length();
      }

      FileInputStream fis = new FileInputStream(sResFile);
      BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
      String[] sTestCaseID = sWriteStr.split("\t");

      while ((line = reader.readLine()) != null) {
        // System.out.println("File name1 found.");
        String[] fields = line.split("\t");
        if (fields[0].equalsIgnoreCase(sTestCaseID[0])) {
          line = line.replaceAll(line, sWriteStr);
          sb.append(line);
          sb.append(newLine);
          bStatus = true;
        } else {
          sb.append(line);
          sb.append(newLine);
        }
      }
      // System.out.println("File name2 found.");
      if (!bStatus) {
        sb.append(sWriteStr);
        sb.append(newLine);
      }
      reader.close();
      BufferedWriter out = new BufferedWriter(new FileWriter(sResFile));
      out.write(sb.toString());
      out.close();
    } catch (Throwable e) {
      e.printStackTrace();
      System.err.println("*** exception ***");
    }
    return "";
  }



}
