package com.atqc047;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atqc047.consts.RozetkaInfo;
import com.atqc047.consts.RozetkaLocators;


public class ThirdTask {

	private WebDriver driver;
	final static Logger logger = Logger
			.getLogger(ThirdTask.class);

	@BeforeClass
	public void setUp() {
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void verifyThatFindButtonIsVisible() {
		driver.get(RozetkaInfo.URL_ROZETKA);
		Assert.assertTrue(driver.findElement(By.xpath(RozetkaLocators.FIND_BUTTON)).isDisplayed());
		Reporter.log("'Find' button present!");
		logger.info("'Find' button present!");

	}

	@Test(priority = 1)
	public void verifyThatFindButtonIsNotVisible() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(RozetkaInfo.CHANGE_VISIBILITY, driver.findElement(By.xpath(RozetkaLocators.FIND_BUTTON)));
		Assert.assertFalse(driver.findElement(By.xpath(RozetkaLocators.FIND_BUTTON)).isDisplayed());
		Reporter.log("'Find' button does not present!");
		logger.info("'Find' button does not present!");
			
	}

	@AfterClass
	public void after() {
		driver.quit();
	}
}
