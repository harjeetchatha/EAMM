package com.kp.apps.web.library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * 
 * @author HariKrishna Pesala
 */

/**
 * Singleton class that stores all of the properties for the tests
 * 
 */
public class TestProperties {

  private Properties            defaultProperties;
  public String                 propFile;

  /**
   * Logger for logging
   */
  private static Logger         logger   = Logger.getLogger(TestProperties.class);

  /**
   * Only instance anywhere of TestProperties
   */
  private static TestProperties instance = null;



  /**
   * Blank constructor so no one can create a new instance
   */
  private TestProperties() {

  }


  /**
   * Get the only instance of TestProperties
   * 
   * @return the instance of TestProperties
   */
  public static synchronized TestProperties getInstance() throws Exception {
    if (instance == null) {
      instance = new TestProperties();
    }
    // instance.readTestProperties();

    return instance;
  }

  private Properties getPropertiesFromClasspath(String propFileName) throws IOException {
    // loading xmlProfileGen.properties from the classpath
    Properties props = new Properties();
    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);

    if (inputStream == null) {
      throw new FileNotFoundException("property file '" + propFileName
          + "' not found in the classpath");
    }

    props.load(inputStream);

    return props;
  }

  public synchronized Properties getDefaultProperties() throws IOException {
    if (this.defaultProperties != null)
      return defaultProperties;
    // Store the properties read from the file
    // Name of the properties file
    // propFile = System.getProperty("eam.props");

    // Make sure we get a valid properties file
    if (propFile == null || !propFile.endsWith(".properties")) {
      propFile = GlobalVariables.sProperties;
    }

    defaultProperties = getPropertiesFromClasspath(propFile);
    if (defaultProperties == null) {
      // Attempt to read in the properties
      try {
        defaultProperties.load(new FileInputStream(propFile));
      } catch (FileNotFoundException fnfe) {
        logger.error("Failed to find properties file: " + propFile, fnfe);
        throw fnfe;
      } catch (IOException ioe) {
        logger.error("Problem reading properties file: " + propFile, ioe);
        throw ioe;
      }
    }
    return defaultProperties;
  }

  /**
   * Read in the test properties from the properties file
   * 
   * @throws Exception if there is a problem with the properties
   */
  public synchronized void readTestProperties() throws Exception {

    Properties configTable = getDefaultProperties();

    // Clean up the read in properties
    Enumeration<Object> keys = configTable.keys();
    while (keys.hasMoreElements()) {
      String key = (String) keys.nextElement();
      String value = configTable.getProperty(key);

      String newKey = key.trim();
      String newValue = value.trim();
      if ("".equals(newValue)) {
        configTable.remove(key);
      }
      else if (!newKey.equals(key)) {
        configTable.remove(key);
        configTable.put(newKey, newValue);
      }
      else if (!newValue.equals(value)) {
        configTable.setProperty(key, newValue);
      }
    }
  }

}
