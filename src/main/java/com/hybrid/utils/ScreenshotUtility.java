package com.hybrid.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	
	public static String captureScreenshot(WebDriver driver, String testName)
	{
		 String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	     String path = "test-output/screenshots/" + testName + "_" + timestamp + ".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}

	
	}

