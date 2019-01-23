package com.wipro.testUtils;

import com.wipro.CommonFunctions.CommonFunctions;
import com.wipro.DataFactory.DataFactory;
import com.wipro.HelperMethods.HelperMethods;
import com.wipro.objectrepository.ProductDetailsPage;
import com.wipro.objectrepository.SettingsScreen;
import com.wipro.objectrepository.SignInScreen;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;


// // This class is created to  intatitate all class objects using singletone constructor
public class PageElements implements IReporter {
    private static PageElements mInstance;
    private SignInScreen signInScreen;
    private SettingsScreen settingsScreen;
    private CommonFunctions commonFunctions;
    private DataFactory dataFactory;
    private HelperMethods helperMethods;
    private ProductDetailsPage productDetailsPage;
    public AndroidDriver driver;
    public static PageElements getInstance() {
        if (mInstance == null) {
            synchronized (PageElements.class) {
                if (mInstance == null) mInstance = new PageElements();
            }
        }
        return mInstance;
    }

    public void suiteSetUp() throws Throwable {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Samsung Galaxy A7");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("appPackage", "com.ebay.mobile");
        caps.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
        caps.setCapability("noReset", "true");
        caps.setCapability("sendKeyStrategy", "setValue");
        caps.setCapability("unicodeKeyboard", true);
        caps.setCapability("resetKeyboard", false);
        driver = new AndroidDriver(caps);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    public static void removeInstance() {
        mInstance = null;
    }


    public ProductDetailsPage getProductDetailsPage() {
        if (productDetailsPage == null)
            productDetailsPage = new ProductDetailsPage(driver);
        return productDetailsPage;
    }

    public SignInScreen getSignInScreen() {
        if (signInScreen == null)
            signInScreen = new SignInScreen(driver);
        return signInScreen;
    }

    public HelperMethods getHelperMethods() {
        if (helperMethods == null)
            helperMethods = new HelperMethods(driver);
        return helperMethods;
    }

    public DataFactory getDataFactory() {
        if (dataFactory == null)
            dataFactory = new DataFactory();
        return dataFactory;
    }

    public SettingsScreen getSettingsScreen() {
        if (signInScreen == null)
            settingsScreen = new SettingsScreen(driver);
        return settingsScreen;
    }

    public CommonFunctions getCommonFunctions() {
        if (commonFunctions == null)
            commonFunctions = new CommonFunctions(driver);
        return commonFunctions;
    }

    public void resetApplication() {
        settingsScreen = null;
        signInScreen = null;
        commonFunctions = null;
        dataFactory = null;
        productDetailsPage = null;
        helperMethods = null;
        driver.quit();
    }

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory) {
        //Iterating over each suite included in the test
        for (ISuite suite : suites) {
            //Following code gets the suite name
            String suiteName = suite.getName();
            //Getting the results for the said suite
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()) {
                ITestContext tc = sr.getTestContext();
                System.out.println("Passed tests for suite '" + suiteName +
                        "' is:" + tc.getPassedTests().getAllResults().size());
                System.out.println("Failed tests for suite '" + suiteName +
                        "' is:" +
                        tc.getFailedTests().getAllResults().size());
                System.out.println("Skipped tests for suite '" + suiteName +
                        "' is:" +
                        tc.getSkippedTests().getAllResults().size());
            }
        }
    }
}