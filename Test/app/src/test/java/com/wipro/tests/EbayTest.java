package com.wipro.tests;

import com.wipro.testUtils.BaseSuiteSetUp;
import com.wipro.testUtils.PageElements;

import org.testng.annotations.Test;


public class EbayTest extends BaseSuiteSetUp {

    /**
     * Test Name - settingsTest
     * Test description - Test sets the country based on passed from the DataSheet.xlsx in resources folder
     */
    @Test(groups = {"ebay-test"}, priority = 1)

    public void settingsTest() {
        initTestReport("settingsTest Test");
        log.info("settings Test Starts");
        PageElements.getInstance().getHelperMethods().selectCountry(PageElements.getInstance().getSettingsScreen().label_UnitedStates, PageElements.getInstance().getDataFactory().getExcelData("EbayData", 1, 3));

        if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getSignInScreen().btn_SignIn)) {
            res_Pass("Settings Test Pass");
        } else {
            res_Fail("Settings Test Fail");
        }
    }

    /**
     * Test Name - login
     * Test description - eBay app is logged in based on the credentials passed from the DataSheet.xlsx in resources folder
     */

   @Test(groups = {"ebay-test"}, priority = 2)

    public void loginTest() {
        initTestReport("Login Test");
        log.info("Login Test Starts");
        PageElements.getInstance().getHelperMethods().loginintoEbay(PageElements.getInstance().getDataFactory().getExcelData("EbayData", 1, 1), PageElements.getInstance().getDataFactory().getExcelData("EbayData", 1, 2));
        if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_popUp)) {
            PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_popUp);
            log.info("Google Pop up Clicked");
        }
        if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_searchTxt)) {
            res_Pass("Login Test Pass");
        } else {
            res_Fail("Login Test Fail");
        }
    }

  @Test(groups = {"ebay-test"}, priority = 3)
    public void searchProductTest() {
        initTestReport("Search Product Test");
        log.info("SearchProduct Test");
        if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_searchTxt)) {
            log.info("Search Text field is dispayed");
            PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_searchTxt);
            log.info("Search Text field is Clicked");
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().txt_searchTxt)) {
                log.info("Product Search Text field is dispayed");
                PageElements.getInstance().getCommonFunctions().enter_Value(PageElements.getInstance().getDataFactory().getExcelData("EbayData", 1, 4), PageElements.getInstance().getProductDetailsPage().txt_searchTxt);
                log.info(" Product name entered in search text fiels");
            } else {
                log.info("Product Search Text field does not dispayed");
            }
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_product)) {
                log.info("Iphone 5 is dispayed");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_product);
                log.info("Clicked Iphone 5");
            } else {
                log.info("Iphone 5 is product does not dispayed");
            }
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_ProductFrmList)) {
                log.info("Iphone 5 is listed ");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_ProductFrmList);
                log.info("Clicked Iphone 5 from listed product");
            } else {
                log.info("Iphone 5 is product does not listed");
            }
        }
        if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_AddToCart)) {
            res_Pass("Search Product Test Pass");
        } else {
            res_Fail("Search Product Test Fail");
        }
    }

   @Test(groups = {"ebay-test"}, priority = 4)
    public void buytItNow() {
        initTestReport("buytItNow");
        if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_AddToCart)) {
            log.info("AddToKart is displayed ");
            PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_AddToCart);
            log.info("Clicked AddToKart button");
        } else {
            log.info("AddToKart is displayed");
        }
        if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().drpDwn_Color)) {
            log.info("Color dropDown displayed");
            PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().drpDwn_Color, PageElements.getInstance().getProductDetailsPage().drpDwn_Color_Black,  PageElements.getInstance().getProductDetailsPage().drpDwn_Storage, PageElements.getInstance().getProductDetailsPage().drpDwn_Storage_GB);

            log.info("Choosen Carrier,Selected Color, Storage and Grade from dropDown");
        } else {
            log.info("Color dropDown  does not displayed");
        }
        if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_AddBasket)) {
            log.info("Add Basket is displayed ");
            PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_AddBasket);
            log.info("Clicked Add Basket button");
        } else {
            log.info("Add Basket does not displayed ");
        }
        if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_buyItNow)) {
            res_Pass("Buy It Now  Test Pass");
        } else {
            res_Fail("Buy It Now Test Fail");
        }

      }

}


/*
@Test
    public void purchaseProduct()  {
    initTestReport("Automation Test");
        log.info("Login Test Starts");
     PageElements.getInstance().getHelperMethods().selectCountry(PageElements.getInstance().getSettingsScreen().label_UnitedStates, PageElements.getInstance().getDataFactory().getExcelData("EbayData", 1, 3));
    if(PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getSignInScreen().btn_SignIn))
    {
        res_Pass("Settings Test Pass");
    }else{
        res_Fail("Settings Test Fail");
    }
        usrNme= PageElements.getInstance().getDataFactory().getExcelData("EbayData", 1, 1);
        password=PageElements.getInstance().getDataFactory().getExcelData("EbayData", 1, 2);
        PageElements.getInstance().getHelperMethods().loginintoEbay(usrNme,password);

        if(PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_popUp)){
            PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_popUp);
            log.info("Google Pop up Clicked");
        }
    if(PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_searchTxt))
    {
        res_Pass("Login Test Pass");
    }else{
        res_Fail("Login Test Fail");
    }
        if(PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_searchTxt)) {
            log.info("Search Text field is dispayed");
            PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_searchTxt);
            log.info("Search Text field is Clicked");
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().txt_searchTxt)) {
                log.info("Product Search Text field is dispayed");
                PageElements.getInstance().getCommonFunctions().enter_Value(PageElements.getInstance().getDataFactory().getExcelData("EbayData", 1, 4), PageElements.getInstance().getProductDetailsPage().txt_searchTxt);
                log.info(" Product name entered in search text fiels");
            } else {
                log.info("Product Search Text field does not dispayed");
            }
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_iPhone5)) {
                log.info("Iphone 5 is dispayed");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_iPhone5);
                log.info("Clicked Iphone 5");
            } else {
                log.info("Iphone 5 is product does not dispayed");
            }
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_iPhone5Product)) {
                log.info("Iphone 5 is listed ");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_iPhone5Product);
                log.info("Clicked Iphone 5 from listed product");
            } else {
                log.info("Iphone 5 is product does not listed");
            }
            if(PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_AddToCart))
            {
                res_Pass("Search Product Test Pass");
                log.info("AddToKart is displayed ");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_AddToCart);
                log.info("Clicked AddToKart button");

            }else{
                res_Fail("Search Product Test Fail");
                log.info("AddToKart is displayed");
            }
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().drpDwn_Color)) {
                log.info("Color dropDown displayed");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().drpDwn_Color,PageElements.getInstance().getProductDetailsPage().drpDwn_Color_Black,PageElements.getInstance().getProductDetailsPage().drpDwn_Grade,PageElements.getInstance().getProductDetailsPage().drpDwn_Grade_A,PageElements.getInstance().getProductDetailsPage().drpDwn_Storage,PageElements.getInstance().getProductDetailsPage().drpDwn_Storage_GB);

                log.info("Selected Color, Storage and Grade from dropDown");
            } else {
                log.info("Color dropDown  does not displayed");
            }
            if(PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_AddToCart))
            {
                res_Pass("Search Product Test Pass");
            }else{
                res_Fail("Search Product Test Fail");
            }
           */
/* if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_AddBasket)) {
                log.info("Add Basket is displayed ");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_AddBasket);
                log.info("Clicked Add Basket button");
            } else {
                log.info("Add Basket does not displayed ");
            }*//*

        }

    }
}*/
