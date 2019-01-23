package com.wipro.testUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.ServerSocket;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


public class BaseSuiteSetUp {
    protected Logger log;
    private String workingDir = System.getProperty("user.dir");
    private String loggerLocation = workingDir + "\\Files\\log4j.properties";
    int port = 4723;
    protected ExtentTest test;
    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities cap;

    @BeforeSuite(alwaysRun = true)
    public void onBeforeSuite() throws Throwable {
        PropertyConfigurator.configure(loggerLocation);
        log = Logger.getLogger(this.getClass().getName());
        java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
        String machine = localMachine.getHostName();
        String username = System.getProperty("user.name");
        TestReport.getInstance().initReport(machine, username, this.getClass().getSimpleName());
        if (!checkIfServerIsRunnning(port)) {
            startServer();
        } else {
            log.info("Appium Server already running on Port - " + port);
        }
        PageElements.getInstance().suiteSetUp();

    }


    @BeforeMethod
    public void launchEbayApp() throws Throwable {
        java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
        String machine = localMachine.getHostName();
        String username = System.getProperty("user.name");
        TestReport.getInstance().initReport(machine, username, this.getClass().getSimpleName());
    }

    /*
    Method Name - startServer
    Method description-This method will start the Appium server programatically
     */

    public void startServer() {
        //Set Capabilities
        cap = new DesiredCapabilities();
        cap.setCapability("noReset", "false");
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(port);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }
      /*
    Method Name - checkIfServerIsRunnning
    Method description-This method will check port running status
     */

    public boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }
   /*
    Method Name - stopServer
    Method description-This method will stop the Appium server programatically
     */

    public void stopServer() {
        try {
            {
                service.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


     /* Method Name - getResult
      Method description-This method will check pass and fail test
       */
    @AfterMethod(alwaysRun = true)
    public void getResult(ITestResult result) throws InterruptedException, IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, result.getThrowable());
        }
        getExtent().endTest(test);
        getExtent().flush();

    }

    /*
     Method Name - afterSuite
     Method description-This method reset all objects
      */
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        PageElements.getInstance().resetApplication();
        if (checkIfServerIsRunnning(port)) {
            stopServer();
        }
        PageElements.removeInstance();
        log.info("Suite Execution is Completed");
    }

    protected ExtentReports getExtent() {
        return TestReport.getInstance().getReport();
    }

    /*
     Method Name - initTestReport
     Method description-This method initailize the report
      */
    protected void initTestReport(String testName) {
        test = getExtent().startTest("Automation Test: " + testName);
    }

    /*
     Method Name - res_Pass
     Method description-This method initailize the Pass Result
      */
    protected void res_Pass(String screenName) {
        TestReport.getInstance().res_Pass(test, screenName);
    }

    /*
        Method Name - res_Fail
        Method description-This method initailize the Fail Result
         */
    protected void res_Fail(String screenName) {
        TestReport.getInstance().res_Fail(test, screenName);
    }
}