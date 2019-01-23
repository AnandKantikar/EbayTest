package com.wipro.CommonFunctions;

import com.wipro.testUtils.PageElements;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static org.testng.Assert.assertEquals;

// This class is created to  maintain all generic/common functions
public class CommonFunctions {
    public AndroidDriver<AndroidElement> driver;
    boolean isVisible, isDisplayed;
    String screensDirectory;
    public String workingDir = System.getProperty("user.dir");

    public CommonFunctions(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Method Name - isDisplayed
     * Method description - Verifies the element presence passed as parameter
     * param 1 - Anroid Element
     */
    public boolean isDisplayed(AndroidElement element) {
        return waitForVisibilityOfElement(element) && element != null && element.isDisplayed();

    }

    /**
     * Method Name - waitForVisibilityOfElement
     * Method description - Explicitly Wait the element appearance for specified time, if it appears before specified time, then it skip the remaining wait
     * param 1 - Anroid Element
     */
    public boolean waitForVisibilityOfElement(AndroidElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(PageElements.getInstance().driver, 80);
            element = (AndroidElement) wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Method Name - getTextFromElement
     * Method description -Get the text passed  parameter as element
     */
    public String getTextFromElement(AndroidElement element) {
        boolean isValue = false;
        String actTxt = null;
        isValue = waitForVisibilityOfElement(element);
        if (isValue) {
            actTxt = element.getText().trim();
        }

        return actTxt;
    }

    /**
     * Method Name - tap_On_Element
     * Method description - Click on the element array passed as parameter
     */
    public void tap_On_Element(AndroidElement... element) {
        for (int i = 0; i < element.length; i++) {
            isVisible = waitForVisibilityOfElement(element[i]);
            isDisplayed = isDisplayed(element[i]);
            if (isVisible && isDisplayed)
                PageElements.getInstance().driver.tap(1, element[i], 1);
        }
    }

    /**
     * Method Name - enter_Value
     * Method description - Enter on the element array passed as parameter
     */

    public void enter_Value(String value, AndroidElement... element) {
        for (int i = 0; i < element.length; i++) {
            isVisible = waitForVisibilityOfElement(element[i]);
            isDisplayed = isDisplayed(element[i]);
            if (isVisible && isDisplayed) {
                element[i].sendKeys(value);
            }
        }
    }

    /**
     * Method Name - SwipeElementUp
     * Method description - swipes the screen based on the co-ordinates passed as parameter
     * param 1 - Anroid Element  is passed
     * param 2 - Duration is passed
     */
    public void SwipeElementUp(AndroidElement element, int duration) {

        int offset = 1;
        Point p = element.getCenter();
        Point location = element.getLocation();
        Dimension size = element.getSize();
        PageElements.getInstance().driver.swipe(p.getX(), location.getY() + size.getHeight() + offset, p.getX(), location.getY(), duration);
    }

    /**
     * Method Name - fail_Test_ScreenShot
     * Method description - Capture the Screen shot passes parameter as ScreenName
     * param 1 - Screen Name
     */

    public void fail_Test_ScreenShot(String screenName) {
        screensDirectory = "FailedScreenshots";
        try {
            String FailTest = workingDir + "\\app\\Reports";
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
            File theDir = new File(FailTest + "\\" + screensDirectory);
            if (!theDir.exists()) {
                new File(FailTest + "\\" + screensDirectory).mkdirs();
            }
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH.mm.ss");
            String currentDateTime = format.format(date);
            String destFile = currentDateTime + "_" + screenName + ".png";
            FileUtils.copyFile(scrFile, new File(screensDirectory + "/" + destFile));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * Method Name - setScreen_Resolution
     * Method description - sSet the resolution  passed as parameter
     */
    public void setScreen_Resolution(String Resolution) {
        if (Resolution.equalsIgnoreCase("LANDSCAPE")) {
            PageElements.getInstance().driver.rotate(ScreenOrientation.LANDSCAPE);
            try {
                assertEquals(ScreenOrientation.LANDSCAPE, driver.getOrientation());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (Resolution.equalsIgnoreCase("PORTRAIT")) {
            PageElements.getInstance().driver.rotate(ScreenOrientation.PORTRAIT);
            try {
                assertEquals(ScreenOrientation.PORTRAIT, driver.getOrientation());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
