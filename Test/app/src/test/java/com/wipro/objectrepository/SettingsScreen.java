package com.wipro.objectrepository;

import com.wipro.constant.Constants;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static com.wipro.constant.Constants.BTN_MENU_ITEM;


public class SettingsScreen {
    public AndroidDriver<AndroidElement> driver;

    public SettingsScreen(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    // MenuItem button
    @AndroidFindBy(xpath = BTN_MENU_ITEM)
    public AndroidElement btn_MenuItem;

    // Home button
    @AndroidFindBy(xpath = Constants.BTN_HOME)
    public AndroidElement btn_Home;

    // Settings button
    @AndroidFindBy(xpath = Constants.BTN_SETTINGS)
    public AndroidElement btn_Settings;

    // Country/Region button
    @AndroidFindBy(xpath = Constants.BTN_COUNTRY_REGION)
    public AndroidElement btn_Country_Region;

    // Country/Region button
    @AndroidFindBy(xpath = Constants.BTN_AUTODETECTTOGGLE)
    public AndroidElement btn_AutoDetectToggle;

    // Naviagte Back button
    @AndroidFindBy(xpath = Constants.BTN_NAVIGATEBACK)
    public AndroidElement btn_NaviagteBack;


    // Country search field
    @AndroidFindBy(xpath = Constants.TXT_SEARCHCOUNTRY)
    public AndroidElement txt_searchCountry;

    // Select Country Label
    @AndroidFindBy(xpath = Constants.LABEL_UNITEDSTATES)
    public AndroidElement label_UnitedStates;

}
