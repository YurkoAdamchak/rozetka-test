package com.atqc047;

import com.atqc047.consts.RozetkaInfo;
import com.atqc047.consts.RozetkaLocators;
import com.atqc047.pageObject.HomePage;
import com.atqc047.pageObject.SearchPage;
import com.atqc047.tools.Wait;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FourthTask {
	private WebDriver webDriver;
	private HomePage homePage;
	private SearchPage searchPage;

	@BeforeClass
	public void setUp() {
		webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();
		webDriver.get(RozetkaInfo.URL_ROZETKA);
		homePage = new HomePage(webDriver);
	}

	@Test
	public void productSearch() {
		homePage = homePage.logIn();
		Wait wait = new Wait(webDriver);
		wait.waitForElementToBeClickAble(By.name(RozetkaLocators.USER_PROFILE));
		searchPage = homePage.doSearch(RozetkaInfo.PRODUCT);
		Assert.assertTrue(webDriver
				.findElement(By.xpath(RozetkaLocators.SEARCH_RESULT)).getText()
				.contains(RozetkaInfo.PRODUCT));
	}

	@Test(dependsOnMethods = "productSearch")
	public void searchWord() {
		Assert.assertTrue(webDriver
				.findElement(By.xpath(RozetkaLocators.SEARCH_WORD))
				.getCssValue("color").contains(RozetkaInfo.RGB_OF_GREEN_COLOR));
	}

	@Test(dependsOnMethods = "searchWord")
	public void toWishList() {
		searchPage.addToWishLIst().submitFishListForm().closeWishListPopup();
		Assert.assertTrue(!webDriver
				.findElement(By.xpath(RozetkaLocators.ADD_TO_WISHLIST_LINK))
				.getAttribute("href").equals("#Wishlist"));
		takeScreenShot(webDriver);
	}

	@AfterClass
	public void tearDown() {
		webDriver.quit();
	}

	private void takeScreenShot(WebDriver webDriver) {
		File srcFile = ((TakesScreenshot) webDriver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(new SimpleDateFormat(
					"yyyy-MM-dd HH-mm-ss").format(new Date()) + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
