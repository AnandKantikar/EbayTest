package com.wipro.testUtils;

import android.support.annotation.Nullable;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;

// This class describes report implementation for the tests
public class TestReport {
    private String workingDir = System.getProperty("user.dir");
    private String extentConfig = workingDir + "\\Files\\config.xml";
    private static TestReport instance;
    private ExtentReports report;
    private BaseSuiteSetUp suite;
    private String fileLocation;

    private TestReport() {

    }

    // Single tone design patter to avoid creating multiple objects
    public static TestReport getInstance() {
        if (instance == null) {
            synchronized (TestReport.class) {
                if (instance == null)
                    instance = new TestReport();
            }
        }
        return instance;
    }

    /**
     * Method Name - isDisplayed
     * Method description - Verifies the element presence passed as parameter
     * param 1 - String Machine
     * param 2 - String Machine User Name
     * param 3 - ClassName in which tests are written
     */
    public void initReport(String machine, String username, String className) {
        StringBuilder builder = new StringBuilder();
        builder.append(workingDir);
        builder.append("\\Reports\\TestResults\\");
        builder.append(className);
        builder.append(".html");
        report = new ExtentReports(builder.toString(), true);
        report
                .addSystemInfo("Host Name", machine)
                .addSystemInfo("User Name", username);
        report.loadConfig(new File(extentConfig));
    }

    @Nullable
    public ExtentReports getReport() {
        return report;
    }

    /**
     * Method Name - res_Pass
     * Method description - This method display pass message for passed test
     * * param 1 - test
     * param 2 - screenName
     */

    public void res_Pass(ExtentTest test, String screenName) {
        try {
            test.log(LogStatus.PASS, screenName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method Name - res_Fail
     * Method description - This method display Fail message for passed test
     * * param 1 - test
     * param 2 - screenName
     */

    public void res_Fail(ExtentTest test, String screenName) {
        try {
            PageElements.getInstance().getCommonFunctions().fail_Test_ScreenShot(screenName);
            test.log(LogStatus.FAIL, screenName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

