package com.wipro.objectrepository;

import com.wipro.constant.Constants;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductDetailsPage {
    AndroidDriver<AndroidElement> driver;

    public ProductDetailsPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Google Pop Up
    @AndroidFindBy(xpath = Constants.BUTTON_POP_UP_XPATH)
    public AndroidElement btn_popUp;

    // Main Search filed
    @AndroidFindBy(xpath = Constants.BTN_SEARCH)
    public AndroidElement btn_searchTxt;

    // Main Search filed
    @AndroidFindBy(xpath = Constants.TXT_SEARCH)
    public AndroidElement txt_searchTxt;

    // Iphone 5
    @AndroidFindBy(xpath = Constants.btn_product)
    public AndroidElement btn_product;

    // Iphone 5 from product list
    @AndroidFindBy(xpath = Constants.btn_ProductNme)
    public AndroidElement btn_ProductFrmList;


    // Add to Cart
    @AndroidFindBy(xpath = Constants.BTN_ADDTOBUCKET)
    public AndroidElement btn_AddToCart;


    // Color
    @AndroidFindBy(xpath = Constants.DRPDWN_COLOR)
    public AndroidElement drpDwn_Color;

    //Black color

    @AndroidFindBy(xpath = Constants.DRPDWN_OPTION_COLOR)
    public AndroidElement drpDwn_Color_Black;

    // Storage
    @AndroidFindBy(xpath = Constants.DRPDWN_STORAGE)
    public AndroidElement drpDwn_Storage;

    //Storage GB
    @AndroidFindBy(xpath = Constants.DRPDWN_OPTION_STORAGE)
    public AndroidElement drpDwn_Storage_GB;

    //Add to Basket
    @AndroidFindBy(xpath = Constants.BTN_ADDTOBASKET)
    public AndroidElement btn_AddBasket;

    //Add to Basket
    @AndroidFindBy(xpath=Constants.BTN_BUYITNOW)
    public AndroidElement btn_buyItNow;


}

