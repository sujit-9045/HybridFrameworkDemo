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
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void setup() throws IOException, InterruptedException {
        launchBrowser();
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
    	   driver.get("https://www.google.com");

    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
    	    searchBox.sendKeys("Rishabh Software");
    	    searchBox.sendKeys(Keys.ENTER);

    	    wait.until(ExpectedConditions.titleContains("Rishabh"));
    	    System.out.println("✅ Search successful");
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