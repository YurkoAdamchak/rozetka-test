package com.atqc047.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atqc047.consts.RozetkaLocators;
import com.atqc047.tools.StringHelper;
import com.atqc047.tools.Wait;

public class ProductDetailsPage {

	private WebDriver webDriver;

	public ProductDetailsPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public int getStarsRating() {
		WebElement stars = webDriver.findElement(By
				.cssSelector(RozetkaLocators.PRICE_PRODUCT_DETAILS_PAGE));
		int starsValue = StringHelper
				.getAllDigitsFromWebElementStyleAttribute(stars);
		return starsValue;
	}

	public int getPrice() {
		WebElement price = webDriver.findElement(By.cssSelector(
				RozetkaLocators.STARS_RATING_PRODUCT_DETAILS_PAGE));
		int priceValue = StringHelper
				.getAllDigitsFromWebElementInnerText(price);
		return priceValue;
	}
	
	public String getReview() {
		WebElement numberOfReviews = webDriver.findElement(By.cssSelector(RozetkaLocators.NUMBER_OF_REVIEWS_PRODUCT_DETAILS_PAGE));
		String reviewValue = StringHelper.getAllNumbersFromWebElementInnerText(numberOfReviews);
		return reviewValue;
	}
	
	public ProductDetailsPage openReviewTab(){
		webDriver.findElement(By.cssSelector("#tabs li[name=comments]")).click();
		Wait wait = new Wait(webDriver);
		wait.waitForElementToBeClickAble(By.cssSelector("#detail-tab-reviews-add-submit"));
		return this;

	}
}
