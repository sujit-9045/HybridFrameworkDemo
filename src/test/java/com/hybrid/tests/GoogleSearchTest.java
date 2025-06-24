//package com.hybrid.tests;
//	import org.testng.annotations.*;
//	import java.io.IOException;
//	import org.testng.ITestResult;
//	import com.hybrid.base.BaseClass;
//	import com.hybrid.pages.GooglePage;
//	import com.hybrid.utils.ExtentReportManager;
//	import com.hybrid.utils.ScreenshotUtility;
//
//	public class GoogleSearchTest extends BaseClass {
//
//	    @BeforeClass
//	    public void startTestLogger() {
//	        ExtentReportManager.test = report.createTest("Google Search Test");
//	    }
//
//	    @BeforeMethod
//	    public void setup() throws IOException {
//	        launchBrowser();
//	    }
//
//	    @Test
//	    public void testGoogleSearch() throws InterruptedException {
//	        driver.get("https://www.google.com");
//	        GooglePage page = new GooglePage(driver);
//	        Thread.sleep(3000); // Just for demonstration. Prefer WebDriverWait in real frameworks.
//	        page.search("Rishabh Software");
//	    }
//
//	    @AfterMethod
//	    public void tearDown(ITestResult result) throws InterruptedException {
//	        if (result.getStatus() == ITestResult.FAILURE) {
//	            String screenshotPath = ScreenshotUtility.captureScreenshot(driver, result.getName());
//	            ExtentReportManager.test.fail("Test Failed: " + result.getThrowable());
//	            try {
//	                ExtentReportManager.test.addScreenCaptureFromPath(screenshotPath);
//	            } catch (Exception e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        Thread.sleep(2000);
//	        driver.quit();
//	    }
//	}


package com.hybrid.tests;

import org.testng.annotations.*;

import java.io.IOException;
import org.testng.ITestResult;

import com.hybrid.base.BaseClass;
import com.hybrid.utils.ExtentReportManager;
import com.hybrid.utils.ScreenshotUtility;
import com.hybrid.pages.GooglePage;

public class GoogleSearchTest extends BaseClass {

    @BeforeClass
    public void startTestLogger() {
        ExtentReportManager.test = report.createTest("Google Search Test");
    }

    @BeforeMethod
    public void setup() throws IOException {
        launchBrowser();
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        GooglePage page = new GooglePage(driver);
        Thread.sleep(2000);
        page.search("Rishabh Software");

        Thread.sleep(5000);
        System.out.println("✅ Search performed");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtility.captureScreenshot(driver, result.getName());
            ExtentReportManager.test.fail("Test Failed. Screenshot: ");
            try {
                ExtentReportManager.test.addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        driver.quit(); // Close browser after test
    }
}