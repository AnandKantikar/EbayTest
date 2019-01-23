package com.wipro.constant;

public class Constants {

    //    Common Text
    public static final String WIDGET = "//android.widget.";
    public static final String TEXT_VIEW = WIDGET+"TextView[";
    public static final String EDIT_TEXT = WIDGET+"EditText[";
    public static final String BUTTON = WIDGET +"Button[";
    public static final String IMAGE_BUTTON = WIDGET+"ImageButton[";
    public static final String LINEAR_LAYOUT = WIDGET+"LinearLayout[";
    public static final String CHECKED_TEXT_VIEW = WIDGET+"CheckedTextView[";
    public static final String SWITCH = WIDGET+"Switch[";
    public static final String CONTAINS ="contains(";
    public static final String _TEXT = "@text";
    public static final String _RESOURCE_ID = "@resource-id";
    public static final String _CONTENT_DESC = "@content-desc";


    //    Settings Screen String
    public static final String BTN_MENU_ITEM = IMAGE_BUTTON + CONTAINS + _CONTENT_DESC +",'Main navigation, open')]";
    public static final String BTN_HOME = CHECKED_TEXT_VIEW + CONTAINS + _TEXT +",'Home')]";
    public static final String BTN_SETTINGS = CHECKED_TEXT_VIEW +CONTAINS+ _TEXT +",'Settings')]";
    public static final String BTN_COUNTRY_REGION = TEXT_VIEW + CONTAINS+_TEXT +",'India')]";
    public static final String BTN_AUTODETECTTOGGLE = SWITCH + CONTAINS + _RESOURCE_ID +",'switch_widget')]";
    public static final String BTN_NAVIGATEBACK = IMAGE_BUTTON +CONTAINS+ _CONTENT_DESC +",'Navigate up']";
    public static final String TXT_SEARCHCOUNTRY = EDIT_TEXT + CONTAINS + _CONTENT_DESC +",'filter')]";
    public static final String LABEL_UNITEDSTATES = CHECKED_TEXT_VIEW + CONTAINS + _TEXT +",'United States')]";

    //    SignIn Screen String
    public static final String TXT_EMAIL = EDIT_TEXT + CONTAINS + _TEXT +",'Email or username')]";
    public static final String TXT_PASSWORD = EDIT_TEXT + CONTAINS + _TEXT +",'Password')]";
    public static final String BTN_SIGNIN = BUTTON + _TEXT +"='SIGN IN']";
    public static final String BUTTON_POP_UP_XPATH = BUTTON + CONTAINS + _TEXT +",'NO THANKS')]";
    // Product Details
    public static final String BTN_SEARCH = TEXT_VIEW + CONTAINS + _RESOURCE_ID +",'search_box')]";
    public static final String TXT_SEARCH = TEXT_VIEW + CONTAINS + _TEXT +",'Search for anything')]";
    public static final String btn_product = TEXT_VIEW + CONTAINS + _TEXT +",'Cell Phones & Smartphones')]";
    public static final String btn_ProductNme = TEXT_VIEW + CONTAINS + _RESOURCE_ID +_TEXT+",'Apple iPhone 5 16GB 32GB 64GB - Factory Unlocked - (AT&T T-Mobile) 4G Smartphone')]";
    public static final String BTN_ADDTOBUCKET = BUTTON + CONTAINS + _RESOURCE_ID +",'button_add_to_cart')]";
    public static final String DRPDWN_STORAGE = LINEAR_LAYOUT + CONTAINS + _RESOURCE_ID +",'selection_option_row') and @index='1']";
    public static final String DRPDWN_OPTION_STORAGE = TEXT_VIEW + CONTAINS + _TEXT +",'16GB')]";
    public static final String DRPDWN_COLOR = LINEAR_LAYOUT + CONTAINS + _RESOURCE_ID +",'selection_option_row') and @index='0']";
    public static final String DRPDWN_OPTION_COLOR = TEXT_VIEW + CONTAINS + _TEXT +",'Black')]";
    public static final String BTN_ADDTOBASKET = TEXT_VIEW + CONTAINS + _TEXT +",'ADD TO BASKET')]";
    public static final String BTN_BUYITNOW = TEXT_VIEW + CONTAINS + _TEXT +",'BUY IT NOW')]";

}

