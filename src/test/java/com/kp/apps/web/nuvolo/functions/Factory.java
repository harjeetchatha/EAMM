package com.kp.apps.web.nuvolo.functions;

import org.openqa.selenium.WebDriver;

/**
 * @author sreemoore
*/

public class Factory {
private static Factory instance=null;
ThreadLocal<WebDriver> webdriver=new ThreadLocal<WebDriver>();


public static Factory getinstance()
{
  if(instance==null)
    instance= new Factory();
  return instance;
}

public final void setDriver(WebDriver driver)
{
  webdriver.set(driver);
}

public WebDriver getDriver()
{
  return webdriver.get();
}
}
