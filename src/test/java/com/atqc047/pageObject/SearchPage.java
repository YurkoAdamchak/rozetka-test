package com.atqc047.pageObject;

import com.atqc047.consts.RozetkaInfo;
import com.atqc047.consts.RozetkaLocators;
import com.atqc047.tools.StringHelper;
import com.atqc047.tools.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	private WebDriver webDriver;

	public SearchPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public SearchPage addToWishLIst() {
		webDriver.findElement(By.xpath(RozetkaLocators.ADD_TO_WISHLIST_LINK))
				.click();
		return this;
	}

	public SearchPage submitFishListForm() {
		webDriver.findElement(By.name(RozetkaLocators.SUBMIT_WISHLIST_FORM))
				.submit();
		return this;
	}

	public SearchPage closeWishListPopup() {
		Wait wait = new Wait(webDriver);
		wait.waitForElementToBeClickAble(By
				.name(RozetkaLocators.CLOSE_WISHLIST_POPUP));
		webDriver.findElement(By.name(RozetkaLocators.CLOSE_WISHLIST_POPUP))
				.click();
		return this;
	}
	
	public SearchPage searchByKeyword() {
		webDriver.findElement(By.name(RozetkaLocators.SEARCH_INPUT)).click();
		webDriver.findElement(By.name(RozetkaLocators.SEARCH_INPUT)).sendKeys(RozetkaInfo.KEYWORD);		
		webDriver.findElement(By.xpath(RozetkaLocators.FIND_BUTTON)).click();
		return this;
	}
	
	
	public String getReview() {
		WebElement numberOfReviews = webDriver.findElement(By.cssSelector(RozetkaLocators.NUMBER_OF_REVIEWS_SEARCH_PAGE));
		String reviewValue = StringHelper.getAllNumbersFromWebElementInnerText(numberOfReviews);
		return reviewValue;
	}
	
}
