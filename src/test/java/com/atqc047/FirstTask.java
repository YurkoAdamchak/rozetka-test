package com.atqc047;

import com.atqc047.consts.RozetkaLocators;
import com.atqc047.consts.RozetkaInfo;
import com.atqc047.pageObject.HomePage;
import com.atqc047.pageObject.PersonalCabinet;
import com.atqc047.tools.Wait;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTask {

	private WebDriver webDriver;
	private HomePage homePage;
	private PersonalCabinet personalCabinet;
	private static final Logger LOGGER = Logger.getLogger(FirstTask.class);

	@BeforeClass
	public void setUp() {
		webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();
		webDriver.get(RozetkaInfo.URL_ROZETKA);
		homePage = new HomePage(webDriver);
	}

	@Test
	public void logIn() {
		LOGGER.info("First task starts");
		homePage = homePage.logIn();
		Wait wait = new Wait(webDriver);
		wait.waitForElementToBeClickAble(By.name(RozetkaLocators.USER_PROFILE));
		Assert.assertTrue(webDriver.findElement(
				By.name(RozetkaLocators.SIGNOUT_LINK)).isEnabled());
	}

	@Test(dependsOnMethods = "logIn")
	public void openUserProfile() {
		personalCabinet = homePage.openProfile();
		Assert.assertEquals(webDriver.getCurrentUrl(),
				RozetkaInfo.URL_USER_PROFILE);
	}

	@Test(dependsOnMethods = "openUserProfile")
	public void logOut() {
		homePage = personalCabinet.logOut();
		Wait wait = new Wait(webDriver);
		wait.waitForElementToBeClickAble(By.name(RozetkaLocators.SIGNIN_LINK));
		Assert.assertTrue(webDriver.findElement(
				By.name(RozetkaLocators.SIGNIN_LINK)).isEnabled());
		LOGGER.info("First task is finished");
	}

	@AfterClass
	public void tearDown() {
		webDriver.quit();
	}
}
