## EAMM Test Automation
EAMM Test Automation using selenium and developed by Prokarma Team. 

The project is broken into separate modules for Facilities, Clinical Operations. Each of these modules can be utilized independently of the others using maven profiles.

-> For each module we have individual testng.xml files 
Below is the Maven command format to run specific module.
  mvn clean test -P Run -Dsuite=${suitefile} 

eg:To run Customer Portal tests
mvn clean test -P Run -Dsuite=customerportaltests_testng


### Advice/Troubleshooting
1. It may be useful to use a Java IDE such as IntelliJ or Eclipse to help troubleshoot potential issues.
2. There may be additional latency when using a remote webdriver to run tests on lower environments. Timeouts or Waits may need to be increased.
    * [Selenium tips regarding explicit waits](https://wiki.saucelabs.com/display/DOCS/Best+Practice%3A+Use+Explicit+Waits)

### Resources
##### [SeleniumHQ Documentation](http://www.seleniumhq.org/docs/)

##### [TestNg Documentation](http://testng.org/javadocs/index.html)
