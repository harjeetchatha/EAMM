package com.kp.apps.web.library;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.reporters.EmailableReporter;
import org.testng.xml.XmlSuite;

/**
 * TestNG listener that will email the testng report after execution has completed
 * 
 * @author HariKrishna Pesala
 * 
 */
public class EmailReport extends EmailableReporter {

  /**
   * Logger used for logging
   */
  private Logger logger = Logger.getLogger(EmailReport.class);

  /**
   * TestProperties we can use to get the email info
   */
  private TestProperties props;

  /**
   * Used to send email
   */
  private EmailService email;

  /**
   * Calls the parent to ensure the report is generated, and then emails it.
   */
  @Override
  public void generateReport(List<XmlSuite> xml, List<ISuite> suites, String outdir) {
    // Call the parent to generate the report
    super.generateReport(xml, suites, outdir);

    // Get the test properties to get the email info
    try {
      props = TestProperties.getInstance();
      props.readTestProperties();
    } catch (Exception e) {
      logger.error("Failed to get TestProperties", e);
      return;
    }

    // Setup the email service
    email = new EmailService();
  }

  /**
   * Reads in the contents of a file and returns a string
   * 
   * @param filePath the path to the file to read
   * @return the contents of the file as a string
   * @throws IOException if there is a problem reading the file
   * @throws URISyntaxException
   */
  private String readFileAsString(String filePath) throws IOException {
    // Byte array to store the data

    byte[] buffer = null;
    // try {
    buffer = new byte[(int) new File(filePath).length()];
    // } catch (URISyntaxException e) {
    // new IOException(filePath + "path not found");
    // }
    // Read in the entire file into the byte array
    BufferedInputStream f = null;
    try {
      f = new BufferedInputStream(new FileInputStream(new File(filePath)));
      // f = new
      // BufferedInputStream(this.getClass().getClassLoader().getResourceAsStream(filePath));
      f.read(buffer);
    } finally {
      if (f != null)
        try {
          f.close();
        } catch (IOException ioe) {
        }
    }
    // Return the byte array converted to a String
    return new String(buffer);
  }

}
