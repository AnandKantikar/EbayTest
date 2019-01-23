package com.wipro.HelperMethods;

import com.wipro.testUtils.PageElements;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

// This class is created to  maintain all project specific/ repeatative functions

public class HelperMethods {
    public AndroidDriver<AndroidElement> driver;
    String getTxt = null;
    public Logger log;
    final String workingDir = System.getProperty("user.dir");
    final String loggerLocation = workingDir + "\\Files\\log4j.properties";
    final String portrait = "PORTRAIT";
    final String landscape = "LANDSCAPE";

    public HelperMethods(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Method Name - selectCountry
     * Method description - Helps to select desired country passed as parameter
     * param 1 - Anroid Element
     * param 2 - Country
     */

    public void selectCountry(AndroidElement androidElement, String country) {
        PropertyConfigurator.configure(loggerLocation);
        log = Logger.getLogger(this.getClass().getName());
        PageElements.getInstance().getCommonFunctions().setScreen_Resolution(landscape);
        if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getSettingsScreen().btn_MenuItem)) {
            log.info("Menu Item button displayed");
            PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getSettingsScreen().btn_MenuItem);
            log.info("Clicked on Menu Item button, Settings and Country buttons");
        } else {
            log.fatal("Menu Item button does not displayed");
        }
        if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getSettingsScreen().btn_Home)) {
            PageElements.getInstance().getCommonFunctions().setScreen_Resolution(portrait);

        } else {
            log.fatal("Menu Item button does not Clicked");
        }
        if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getSettingsScreen().btn_Settings)) {
            log.info("Settings button displayed");
            PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getSettingsScreen().btn_Settings);
        } else {
            log.fatal("Settings button does not displayed");
        }

        if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getSettingsScreen().btn_Country_Region)) {
            log.info("Country button displayed");
            PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getSettingsScreen().btn_Country_Region);
            getTxt = PageElements.getInstance().getCommonFunctions().getTextFromElement(PageElements.getInstance().getSettingsScreen().btn_AutoDetectToggle);
            log.info("Get Text of Toggle button :" + " " + getTxt);
            if (getTxt.equalsIgnoreCase(PageElements.getInstance().getDataFactory().getExcelData("EbayData", 2, 0))) {
                log.info("Auto Detect Toggle button is ON");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getSettingsScreen().btn_AutoDetectToggle);
            } else {
                log.info("Auto Detect Toggle button is OFF");
            }
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getSettingsScreen().btn_Country_Region)) {
                log.info("Country Region button displayed");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getSettingsScreen().btn_Country_Region);
                log.info("Clicked on Country/Region button");
            } else {
                log.info("Country Region button does not displayed");
            }
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getSettingsScreen().txt_searchCountry)) {
                log.info("enter country text filed displayed");
                PageElements.getInstance().getCommonFunctions().enter_Value(country, PageElements.getInstance().getSettingsScreen().txt_searchCountry);
                log.info("Entered Country in search country filed :" + " " + country);
            } else {
                log.info("enter country text filed does not displayed");
            }
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getSettingsScreen().txt_searchCountry)) {
                log.info("enter country text filed displayed");
                PageElements.getInstance().getCommonFunctions().enter_Value(country, PageElements.getInstance().getSettingsScreen().txt_searchCountry);
                log.info("Entered Country in search country filed :" + " " + country);
            } else {
                log.info("enter country text filed does not displayed");
            }
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(androidElement)) {
                log.info(country + "Country/Region is displayed");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(androidElement);
                log.info(country + "Clicked ...");
            } else {
                log.info(country + "Country/Region does not displayed");
            }
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getSettingsScreen().btn_NaviagteBack)) {
                log.info(country + "Back button is displayed");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getSettingsScreen().btn_NaviagteBack);
                log.info("Back button is clicked");
            } else {
                log.info(country + "Back button does not displayed");
            }
        } else {
            getTxt = PageElements.getInstance().getCommonFunctions().getTextFromElement(PageElements.getInstance().getSettingsScreen().label_UnitedStates);
            if (getTxt.equalsIgnoreCase(PageElements.getInstance().getDataFactory().getExcelData("EbayData", 1, 3))) {
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getSettingsScreen().btn_NaviagteBack);
            }
        }

    }

    /**
     * Method Name - loginintoEbay
     * Test description - eBay app is logged in based on the credentials passed from the DataSheet.xlsx in Files folder
     */

    public void loginintoEbay(String usrNme, String password) {
        PropertyConfigurator.configure(loggerLocation);
        log = Logger.getLogger(this.getClass().getName());
        if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getSignInScreen().btn_SignIn)) {
            log.info("Sign In Button is displayed");
            PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getSignInScreen().btn_SignIn);
            log.info("Sign In Button Clicked ...");
        } else {
            log.info("Sign In Button does not displayed");
        }
        if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getSignInScreen().txt_Email)) {
            PageElements.getInstance().getCommonFunctions().enter_Value(usrNme, PageElements.getInstance().getSignInScreen().txt_Email);
            log.info("Entered User Name ...");
            PageElements.getInstance().getCommonFunctions().enter_Value(password, PageElements.getInstance().getSignInScreen().txt_Password);
            log.info("Entered Password ...");
            PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getSignInScreen().btn_SignIn);
            log.info("Sign In Button Clicked ...");
        } else {
            log.info("Sign In Button does not displayed");
        }
    }
}

