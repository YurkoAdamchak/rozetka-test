package com.atqc047;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atqc047.consts.RozetkaInfo;
import com.atqc047.pageObject.HomePage;
import com.atqc047.pageObject.ProductsPage;
import com.atqc047.pageObject.ProductDetailsPage;

public class FifthTask {

	private WebDriver webDriver;
	private HomePage homePage;
	private ProductsPage telephonesPage;
	private ProductDetailsPage telephoneDetailsPage;

	private int priceOnTelephonesPage;
	private int priceOnTelephoneDetailsPage;
	private int starsRatingOnTelephonesPage;
	private int starsRatingOnTelephoneDetailsPage;

	@BeforeClass
	public void setUp() {
		webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();
		webDriver.get(RozetkaInfo.URL_ROZETKA);
		homePage = new HomePage(webDriver);
		telephonesPage = homePage.goToTelephonesPage();
		telephonesPage.selectPriceCategory(
				RozetkaInfo.TELEPHONES_PRICE_CATEGORY).selectProducer(
				RozetkaInfo.TELEPHONES_PRODUCER);
		priceOnTelephonesPage = telephonesPage
				.getPriceOfProductByPosition(RozetkaInfo.TELEPHONE_POSITION);
		starsRatingOnTelephonesPage = telephonesPage
				.getStarsRatingOfProductByPosition(RozetkaInfo.TELEPHONE_POSITION);
		telephoneDetailsPage = telephonesPage
				.goToProductByPosition(RozetkaInfo.TELEPHONE_POSITION);
		priceOnTelephoneDetailsPage = telephoneDetailsPage.getPrice();
		starsRatingOnTelephoneDetailsPage = telephoneDetailsPage
				.getStarsRating();
	}

	@Test
	public void verifyPrice() {
		Reporter.log("Price on telephones page: " + priceOnTelephonesPage);
		Reporter.log("Price on telephone details page: "
				+ priceOnTelephoneDetailsPage);
		Assert.assertTrue(priceOnTelephonesPage == priceOnTelephoneDetailsPage);
	}

	@Test
	public void verifyStarsRating() {
		Reporter.log("Stars rating on telephones page: "
				+ starsRatingOnTelephonesPage);
		Reporter.log("Stars rating on telephone details page: "
				+ starsRatingOnTelephoneDetailsPage);
		Assert.assertTrue(starsRatingOnTelephonesPage == starsRatingOnTelephoneDetailsPage);
	}

	@AfterClass()
	public void tearDown() {
		webDriver.close();
	}
}
