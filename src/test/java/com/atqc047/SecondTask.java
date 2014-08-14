package com.atqc047;

import com.atqc047.consts.RozetkaInfo;
import com.atqc047.pageObject.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SecondTask {

	private WebDriver webDriver;
	private HomePage homePage;

	@BeforeClass
	public void setUp() {
		webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();
		webDriver.get(RozetkaInfo.URL_ROZETKA);
	}

	@Test
	public void secondTask() {
		homePage = new HomePage(webDriver);
		int quantity = homePage.getQuantityOfNewCategories();
		Reporter.log("Found new categories: " + quantity);
		String color = homePage.getColorOfNewCategories();
		boolean colorIsRed = color.contains(RozetkaInfo.RGB_OF_RED_COLOR);
		Assert.assertTrue(colorIsRed, RozetkaInfo.COLOR_ISNT_RED);
	}

	@AfterClass
	public void tearDown() {
		webDriver.quit();
	}
}
