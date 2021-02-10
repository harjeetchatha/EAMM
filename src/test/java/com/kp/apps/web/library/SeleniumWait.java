package com.kp.apps.web.library;

/**
 * 
 * @author HariKrishna Pesala
 */

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWait {

  private final Logger      logger                       = Logger.getLogger(this.getClass());
  private static final int  WAIT_DURATION_IN_SECONDS     = 30;
  private static final int  POLLING_FREQUENCY_IN_SECONDS = 1;
  private static final long NINTY_SECOND_IN_MILLIS       = 91000;

  private final WebDriver   webDriver;

  public SeleniumWait(final WebDriver aWebDriver) {
    webDriver = aWebDriver;
  }

  public static void hold(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public WebElement waitForElementPresence(final By aLocator) {
    return waitForElementPresence(aLocator, WAIT_DURATION_IN_SECONDS, POLLING_FREQUENCY_IN_SECONDS);
  }

  public List<WebElement> waitForElementsPresence(final By aLocator) {
    return waitForElementsPresence(aLocator, WAIT_DURATION_IN_SECONDS, POLLING_FREQUENCY_IN_SECONDS);
  }

  public WebElement waitForElementPresence(final By aLocator, final int aWaitDurationInSeconds,
      final int aPollingFrequencyInSeconds) {
    final Wait<WebDriver> wait = getFluentWait(aWaitDurationInSeconds, aPollingFrequencyInSeconds);
    WebElement webElement = null;
    boolean found = false;
    final long startTime = System.currentTimeMillis();
    while ((System.currentTimeMillis() - startTime) < NINTY_SECOND_IN_MILLIS) {
      try {
        wait.until(ExpectedConditions.presenceOfElementLocated(aLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(aLocator));
        webElement = webDriver.findElement(aLocator);
        found = webElement.isDisplayed();
        if (found) {
          break;
        }
      } catch (final StaleElementReferenceException e) {
        logWarning(aLocator, e);
      } catch (final NoSuchElementException e) {
        logWarning(aLocator, e);
      } catch (final TimeoutException e) {
        logWarning(aLocator, e);
      }
    }
    final long endTime = System.currentTimeMillis();
    final long totalTime = endTime - startTime;
    if (found) {
      logger.info(String.format("Found element[%s]TimeTaken[%s ms]", aLocator,
          String.valueOf(totalTime)));
    }
    else {
      logger.error(String.format("Cannot find element[%s]Spent[%s ms] to find", aLocator,
          String.valueOf(totalTime)));
    }
    resetWait();
    return webElement;
  }

  public List<WebElement> waitForElementsPresence(final By aLocator,
      final int aWaitDurationInSeconds, final int aPollingFrequencyInSeconds) {
    final Wait<WebDriver> wait = getFluentWait(aWaitDurationInSeconds, aPollingFrequencyInSeconds);
    List<WebElement> webElements = null;
    int tries = 0;
    boolean elementIsDisplayed = true;
    final long startTime = System.currentTimeMillis();
    while ((System.currentTimeMillis() - startTime) < NINTY_SECOND_IN_MILLIS) {
      logger.info(String.format("Attempt[%s]WaitForElement(s)Presence[%s]",
          String.valueOf((tries++)), aLocator));
      try {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(aLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(aLocator));
        webElements = webDriver.findElements(aLocator);
        for (final WebElement webElement : webElements) {
          elementIsDisplayed = elementIsDisplayed && webElement.isDisplayed();
        }
        if (elementIsDisplayed) {
          break;
        }
      } catch (final StaleElementReferenceException e) {
        logWarning(aLocator, e);
      } catch (final NoSuchElementException e) {
        logWarning(aLocator, e);
      } catch (final TimeoutException e) {
        logWarning(aLocator, e);
      }
    }
    final long endTime = System.currentTimeMillis();
    final long totalTime = endTime - startTime;
    if (elementIsDisplayed) {
      logger.info(String.format("Found all elements[%s]TimeTaken[%s ms]", aLocator,
          String.valueOf(totalTime)));
    }
    else {
      logger.error(String.format("Cannot find all elements[%s]Spent[%s ms] to find", aLocator,
          String.valueOf(totalTime)));
    }
    resetWait();
    return webElements;

  }

  @SuppressWarnings("boxing")
  public boolean waitForJavaScriptCondition(final String aJavaScript) {
    nullifyImplicitWait(webDriver);
    boolean jscondition = false;
    try {
      new WebDriverWait(webDriver, WAIT_DURATION_IN_SECONDS) {}
          .until(new ExpectedCondition<Boolean>() {

            // @Override
            public Boolean apply(final WebDriver driverObject) {
              return (Boolean) ((JavascriptExecutor) driverObject).executeScript(aJavaScript);
            }
          });
      jscondition = (Boolean) ((JavascriptExecutor) webDriver).executeScript(aJavaScript);
      return jscondition;
    } catch (final Exception e) {
      logger.error(e);
    }
    resetImplicitWait(webDriver);
    return false;
  }

  @SuppressWarnings("boxing")
  public boolean waitForJQueryAjaxProcessing() {
    nullifyImplicitWait(webDriver);
    boolean jQcondition = false;
    try {
      new WebDriverWait(webDriver, WAIT_DURATION_IN_SECONDS) {}
          .until(new ExpectedCondition<Boolean>() {

            // @Override
            public Boolean apply(final WebDriver driverObject) {
              return (Boolean) ((JavascriptExecutor) driverObject)
                  .executeScript("return jQuery.active == 0");
            }
          });
      final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
      jQcondition = (Boolean) javascriptExecutor.executeScript("return jQuery.active == 0");
      return jQcondition;
    } catch (final Exception e) {
      logger.error(e);
    }
    resetImplicitWait(webDriver);
    return jQcondition;
  }


  public void waitForAjaxProcessing(final String cssExpression) {
    logger.info("wait for jquery - start");
    nullifyImplicitWait(webDriver);
    try {
      webDriver.findElement(By.cssSelector(cssExpression));
      logger.info(String.format("element found - [%s]", cssExpression));
    } catch (Exception e) {
      logger.info(String.format("element not found - [%s]", cssExpression));
    }
    final WebDriverWait wait = new WebDriverWait(webDriver, WAIT_DURATION_IN_SECONDS);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(cssExpression)));
    logger.info("wait for jquery - end");
    resetImplicitWait(webDriver);
  }

  public void waitForAjaxProcessing(final String cssExpression, final int aWaitDurationInSeconds) {
    logger.info("wait for jquery");
    nullifyImplicitWait(webDriver);
    final WebDriverWait wait = new WebDriverWait(webDriver, aWaitDurationInSeconds);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(cssExpression)));
    resetImplicitWait(webDriver);
  }

  public void explicitWaitForProgressBar() {
    final Wait<WebDriver> wait = new WebDriverWait(webDriver, WAIT_DURATION_IN_SECONDS);
    wait.until(new ExpectedCondition<Boolean>() {
      @SuppressWarnings("boxing")
      // @Override
      public Boolean apply(final WebDriver driverObject) {
        return !driverObject.findElement(By.cssSelector("div.progress-bar")).isDisplayed();
      }
    });
  }

  private Wait<WebDriver> getFluentWait(final int aWaitDurationInSeconds,
      final int aPollingFrequencyInSeconds) {
    nullifyImplicitWait(webDriver);
    final Integer waitDurationInSec = Integer.valueOf(aWaitDurationInSeconds);
    final Integer pollingFrequencyInSec = Integer.valueOf(aPollingFrequencyInSeconds);
    logger.info(String.format(
        "Prepare for fluent wait [waitDurationInSeconds=%d,pollingFrequencyInSeconds=%d]",
        waitDurationInSec, pollingFrequencyInSec));
    final FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(webDriver);
    final FluentWait<WebDriver> withTimeout =
        fluentWait.withTimeout(waitDurationInSec.intValue(), TimeUnit.SECONDS);
    final FluentWait<WebDriver> pollingEvery =
        withTimeout.pollingEvery(pollingFrequencyInSec.intValue(), TimeUnit.SECONDS);
    return pollingEvery
        .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
  }

  private void resetWait() {
    resetImplicitWait(webDriver);
  }

  private void logWarning(final By aLocator, final WebDriverException aWebDriverException) {
    logger.warn(String.format("Locator[%s]StaleElementReferenceException[%s]", aLocator,
        aWebDriverException.getMessage()));
  }

  private static void nullifyImplicitWait(final WebDriver aWebDriver) {
    aWebDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
  }

  private static void resetImplicitWait(final WebDriver aWebDriver) {
    aWebDriver.manage().timeouts().implicitlyWait(WAIT_DURATION_IN_SECONDS, TimeUnit.SECONDS);
  }
}
