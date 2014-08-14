package com.atqc047;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atqc047.consts.RozetkaInfo;
import com.atqc047.consts.RozetkaLocators;
import com.atqc047.pageObject.ProductDetailsPage;
import com.atqc047.pageObject.SearchPage;

public class SixthTask {
	private WebDriver webDriver;
	final static Logger logger = Logger.getLogger(SixthTask.class);
	private SearchPage searchPage;
	private ProductDetailsPage productDetailsPage;

	@BeforeClass
	public void setUp() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("plugin.state.flash", 0);
		webDriver = new FirefoxDriver(profile);
		webDriver.manage().window().maximize();
		webDriver.get(RozetkaInfo.URL_ROZETKA);
		searchPage = new SearchPage(webDriver);
		productDetailsPage = new ProductDetailsPage(webDriver);
	}
	
	@Test(priority = 0)
	public void verifyThatKeyWordIsPresentInSearchList() {
		searchPage = searchPage.searchByKeyword();
		Assert.assertTrue(webDriver.getPageSource().contains(RozetkaInfo.KEYWORD));
		Reporter.log("Keyword is present!");
		logger.info("Keyword is present!");
	}
	
	
	@Test(priority=1)
	public void verifyNumberOfViews(){
		String numberOfReviewsSearchPage = searchPage.getReview();
		webDriver.findElement(By.cssSelector(RozetkaLocators.PRODUCT_SELECTOR)).click();
		String numberOfReviewsProductDetailsPage = productDetailsPage.getReview();
		Assert.assertEquals(numberOfReviewsSearchPage, numberOfReviewsProductDetailsPage);
		Reporter.log("Number of reviews are the same!");
		logger.info("Number of reviews are the same!");
		
	}
	
	@Test(priority = 2)
	public void verifyThatReviewTabIsOpened() {
		productDetailsPage = productDetailsPage.openReviewTab();
		Assert.assertTrue(webDriver.findElement(By.cssSelector(RozetkaLocators.REVIEW_TAB)).isDisplayed());
		Reporter.log("Review page is opened!");
		logger.info("Review page is opened!");
	}
	
	@AfterClass
	public void after() {
		webDriver.quit();
	}

	
	
	

}
