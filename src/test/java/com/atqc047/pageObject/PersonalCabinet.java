package com.atqc047.pageObject;

import com.atqc047.consts.RozetkaLocators;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalCabinet {
	private static final Logger LOGGER = Logger
			.getLogger(PersonalCabinet.class);

	private WebDriver webDriver;

	public PersonalCabinet(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public HomePage logOut() {
		webDriver.findElement(By.name(RozetkaLocators.SIGNOUT_LINK)).click();
		LOGGER.info("Logout");
		return new HomePage(webDriver);
	}
}