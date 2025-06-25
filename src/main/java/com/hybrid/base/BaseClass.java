package com.hybrid.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.hybrid.utils.ExtentReportManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BaseClass {

    public static ExtentReports report;
    public static ExtentTest logger;
    public WebDriver driver;

    public void launchBrowser() throws IOException, InterruptedException {
        System.out.println("===> Launching browser...");

        // ✅ Load URL from config.properties
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);
        String url = prop.getProperty("url");

        // ✅ Read browser from Jenkins system property OR fallback to config
        String browser = System.getProperty("browser"); // from Jenkins
        if (browser == null || browser.isEmpty()) {
            browser = prop.getProperty("browser", "chrome"); // fallback to config
        }

        // ✅ Launch the correct browser
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new org.openqa.selenium.firefox.FirefoxDriver();
        } else {
//            throw new RuntimeException("❌ Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(3000);
    }

    @BeforeTest
    public void startReport() {
        report = ExtentReportManager.getReportInstance();
    }

    @AfterTest
    public void endReport() {
        if (report != null) {
            report.flush();
        }
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}