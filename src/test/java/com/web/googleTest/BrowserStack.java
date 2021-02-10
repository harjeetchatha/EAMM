package com.web.googleTest;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.kp.apps.web.library.GlobalVariables;
import java.io.IOException;
import java.net.URL;
public class BrowserStack {
    public static final String AUTOMATE_USERNAME = "anilgopu1";
    public static final String AUTOMATE_ACCESS_KEY = "qbYNhfcpju6srUZUzBAS";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test(dataProvider="BrowserDetails")
    public void ParallelExecutionTest(Platform platform, String browserName, String browserVersion) throws InterruptedException, IOException {
        DesiredCapabilities caps = new DesiredCapabilities();

         caps.setPlatform(platform);
         caps.setBrowserName(browserName);
         caps.setVersion(browserVersion);

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get(GlobalVariables.GoogleApplicationURL);
        System.out.println(driver.getTitle());
        if (driver.getTitle().contains("Google")) {
            Assert.assertTrue(true, "Google opened successfully in browser stack");
            }
        else {
            Assert.assertTrue(false, " Google page not working");
                  }
        driver.quit();
    }

    @DataProvider(name="BrowserDetails", parallel=true)
    public Object[][] getData(){

        Object[][] testData = new Object[][]{
                {Platform.WIN8, "chrome", "62.0"},
                {Platform.WINDOWS, "firefox", "57"},
                {Platform.MAC, "Safari", "13.1"},
                {Platform.WINDOWS, "edge", "88.0 Beta"},
              
       };
        return testData;
    }



}

