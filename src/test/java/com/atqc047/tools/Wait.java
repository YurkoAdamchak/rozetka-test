package com.atqc047.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	private WebDriver webDriver;
	private int timeToWait = 10;

	public Wait(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void waitForElementToBeClickAble(By locator) {
		WebDriverWait wait = new WebDriverWait(webDriver, timeToWait);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitForElementToBeClickAble(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(webDriver, timeToWait);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
}
