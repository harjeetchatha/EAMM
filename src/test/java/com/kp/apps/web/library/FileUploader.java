package com.kp.apps.web.library;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

/**
 * Takes care of FileUpload
 * 
 * @author HariKrishna Pesala
 */
public class FileUploader {
  private final Log logger = LogFactory.getLog(FileUploader.class);

  /**
   * @param aWebDriver WebDriver
   * @param aSeleniumWait SeleniumWait
   * @param aFormId ID of the main form
   * @param aElementId ID of the input element
   * @param aRelativeFilePath relative path to the file for upload
   */
  public void uploadDocument(final WebDriver aWebDriver, final SeleniumWait aSeleniumWait,
      final String aFormId, final String aElementId, final String aRelativeFilePath) {
    uploadFile(aWebDriver, aSeleniumWait, aFormId, aElementId, aRelativeFilePath);
  }

  /**
   * @param webDriver
   * @param seleniumWait
   * @param aFormId
   * @param keyAttribute
   * @param qualifyingAttribute
   * @param aRelativeFilePath
   */
  public void uploadDocument(WebDriver webDriver, SeleniumWait seleniumWait, final String aFormId,
      String keyAttribute, String qualifyingAttribute, String aRelativeFilePath) {
    String xpathExpression;
    Assert.assertTrue(StringUtils.isNotBlank(qualifyingAttribute),
        "Name/ID contains attribute blank");
    final String[] splitQualifyingAttribute = qualifyingAttribute.split("=");
    if (!StringUtils.isBlank(keyAttribute)) {
      xpathExpression =
          "//input[@" + keyAttribute + " and contains(@" + splitQualifyingAttribute[0] + ", "
              + splitQualifyingAttribute[1] + ")]";
    } else {
      xpathExpression =
          "//input[contains(@" + splitQualifyingAttribute[0] + ", '" + splitQualifyingAttribute[1]
              + "')]";
    }
    final WebElement uploadElement = webDriver.findElement(By.xpath(xpathExpression));
    final String elementId = uploadElement.getAttribute("id");
    uploadFile(webDriver, seleniumWait, aFormId, elementId, aRelativeFilePath);
  }

  public void uploadDocument(final WebDriver aWebDriver, final SeleniumWait aSeleniumWait,
      final String aElementId, final List<File> aFileArray) {
    // TODO SANTOSH support for multiple document upload
  }

  private void uploadFile(final WebDriver aWebDriver, final SeleniumWait aSeleniumWait,
      final String aFormId, final String aElementId, final String aRelativeFilePath) {
    try {
      URL classpathResource = getClass().getResource(aRelativeFilePath);
      if (classpathResource == null) {
        throw new IllegalArgumentException(String.format(
            "Error opening classpath:%s from %s class loader", aRelativeFilePath, getClass()));
      }
      File fileToUpload = new File(classpathResource.toURI());
      logger
          .info(String.format("Executing JS to Attach File [%s]", fileToUpload.getAbsolutePath()));
      JavascriptExecutor javascriptExecutor = (JavascriptExecutor) aWebDriver;
      String javascriptCode =
          "document.forms['" + aFormId + "'].appendChild(document.getElementById('" + aElementId
              + "'))";
      javascriptExecutor.executeScript(javascriptCode);
      if (aWebDriver instanceof RemoteWebDriver) {
        logger.info(String.format("Attaching file [%s] (Selenium Driver = RemoteWebDriver)",
            fileToUpload.getAbsolutePath()));
        final RemoteWebElement uploadElement =
            (RemoteWebElement) aWebDriver.findElement(By.id(aElementId));
        uploadElement.setFileDetector(new LocalFileDetector());
        uploadElement.sendKeys(fileToUpload.getAbsolutePath());
      } else {
        logger.info(String.format("Attaching file [%s] (Selenium Driver = Local WebDriver)",
            fileToUpload.getAbsolutePath()));
        final WebElement uploadElement = aWebDriver.findElement(By.id(aElementId));
        uploadElement.sendKeys(fileToUpload.getAbsolutePath());
      }
      aSeleniumWait.waitForElementPresence(By.xpath("//*[contains(text(), '"
          + fileToUpload.getName() + "')]"));
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }
}
