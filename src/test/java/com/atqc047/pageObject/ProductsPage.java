package com.atqc047.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.atqc047.consts.RozetkaLocators;
import com.atqc047.tools.StringHelper;

public class ProductsPage {

	private WebDriver webDriver;

	public ProductsPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public ProductsPage selectPriceCategory(String priceCategory) {
		String priceCategoryLocator = StringHelper.concatInToLocator(
				RozetkaLocators.PRICE_CATEGORY_LINK_BEGIN, priceCategory);
		try {
			webDriver.findElement(By.cssSelector(priceCategoryLocator)).click();
		} catch (NoSuchElementException ex) {
			Reporter.log("No such price category: " + priceCategory);
		}
		return this;
	}

	public ProductsPage selectProducer(String producer) {
		String producerLocator = StringHelper.concatInToLocator(
				RozetkaLocators.PRODUCER_CATEGORY_LINK_BEGIN, producer,
				RozetkaLocators.PRODUCER_CATEGORY_LINK_END);
		try {
			webDriver.findElement(By.xpath(producerLocator)).click();
		} catch (NoSuchElementException ex) {
			Reporter.log("No such producer: " + producer);
		}
		return this;
	}

	public ProductDetailsPage goToProductByPosition(int position) {
		String positionLocator = StringHelper.concatInToLocator(
				RozetkaLocators.PRODUCT_POSITION_BEGIN, position,
				RozetkaLocators.PRODUCT_POSITION_END);
		try {
			webDriver.findElement(By.cssSelector(positionLocator)).click();
		} catch (NoSuchElementException ex) {
			Reporter.log("No product on position: " + position);
		}
		return new ProductDetailsPage(this.webDriver);
	}

	public int getStarsRatingOfProductByPosition(int position) {
		String starsLocator = StringHelper.concatInToLocator(
				RozetkaLocators.STARS_RATING_PRODUCT_PAGE_BEGIN, position,
				RozetkaLocators.STARS_RATING_PRODUCT_PAGE_END);
		int starsValue = 0;
		try {
			WebElement stars = webDriver.findElement(By
					.cssSelector(starsLocator));
			starsValue = StringHelper
					.getAllDigitsFromWebElementStyleAttribute(stars);
		} catch (NoSuchElementException ex) {
			Reporter.log("No stars rating on position: " + position);
		}
		return starsValue;
	}

	public int getPriceOfProductByPosition(int position) {
		String priceLocator = StringHelper.concatInToLocator(
				RozetkaLocators.PRICE_PRODUCT_PAGE_BEGIN, position,
				RozetkaLocators.PRICE_PRODUCT_PAGE_END);
		int priceValue = 0;
		try {
			WebElement price = webDriver.findElement(By
					.cssSelector(priceLocator));
			priceValue = StringHelper
					.getAllDigitsFromWebElementInnerText(price);
		} catch (NoSuchElementException ex) {
			Reporter.log("No price on position: " + position);
		}
		return priceValue;
	}
}