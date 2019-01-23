package com.wipro.objectrepository;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static com.wipro.constant.Constants.BTN_SIGNIN;
import static com.wipro.constant.Constants.TXT_EMAIL;
import static com.wipro.constant.Constants.TXT_PASSWORD;


public class SignInScreen {
    public AndroidDriver<AndroidElement> driver;


    public SignInScreen(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Email or User name
    @AndroidFindBy(xpath = TXT_EMAIL)
    public AndroidElement txt_Email;

    // Password
    @AndroidFindBy(xpath = TXT_PASSWORD)
    public AndroidElement txt_Password;
    //Sign In
    @AndroidFindBy(xpath = BTN_SIGNIN)
    public AndroidElement btn_SignIn;
}
