package com.hybrid.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Purpose: Page classes hold UI element locators and related actions – this is Page Object Model (POM).

public class GooglePage {
	
	WebDriver driver;
	
	public GooglePage(WebDriver driver)
	
	  
	{
		this.driver=driver;
	}
	
	By searchBox = By.name("q");
	
	
	Logger log = LoggerFactory.getLogger(GooglePage.class);
	public void search(String query)
	{
		log.info("Searching for: " + query);
		driver.findElement(searchBox).sendKeys(query);
		driver.findElement(searchBox).submit();
	}



	
	
	
	
	
	

}
