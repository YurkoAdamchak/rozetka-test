package com.atqc047.pageObject;

import com.atqc047.consts.RozetkaLocators;
import com.atqc047.consts.RozetkaInfo;
import com.atqc047.tools.Wait;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	private WebDriver webDriver;
	private static final Logger LOGGER = Logger.getLogger(HomePage.class);

	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public HomePage logIn() {
		webDriver.findElement(By.name(RozetkaLocators.SIGNIN_LINK)).click();
		webDriver.findElement(By.name(RozetkaLocators.LOGIN_INPUT_FIELD))
				.sendKeys(RozetkaInfo.USER_LOGIN);
		webDriver.findElement(By.name(RozetkaLocators.PASSWORD_INPUT_FIELD))
				.sendKeys(RozetkaInfo.USER_PASSWORD);
		webDriver.findElement(By.name(RozetkaLocators.LOGIN_FORM)).submit();
		LOGGER.info("Login");
		return new HomePage(webDriver);
	}

	public PersonalCabinet openProfile() {
		webDriver.findElement(By.name(RozetkaLocators.USER_PROFILE)).click();
		LOGGER.info("Open profile");
		return new PersonalCabinet(webDriver);
	}

	public int getQuantityOfNewCategories() {
		int quantityOfNewCategories = webDriver.findElements(
				By.className(RozetkaLocators.NEW_CATEGORIES)).size();
		return quantityOfNewCategories;
	}

	public String getColorOfNewCategories() {
		String color = webDriver.findElement(
				By.className(RozetkaLocators.NEW_CATEGORIES))
				.getCssValue("color");
		return color;
	}

	public SearchPage doSearch(String searchValue) {
		webDriver.findElement(By.name(RozetkaLocators.SEARCH_INPUT))
				.sendKeys(searchValue);
		webDriver.findElement(By.xpath(RozetkaLocators.FIND_BUTTON)).click();
		return new SearchPage(webDriver);
	}

	public ProductsPage goToTelephonesPage() {
		WebElement phonesMp3GpsMenu = webDriver.findElement(By
				.id(RozetkaLocators.PHONES_MP3_GPS_MENU));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(phonesMp3GpsMenu).perform();
		WebElement phones = webDriver.findElement(By
				.cssSelector(RozetkaLocators.TELEPHONES_LINK));
		Wait wait = new Wait(webDriver);
		wait.waitForElementToBeClickAble(phones);
		phones.click();
		return new ProductsPage(this.webDriver);
	}
}
