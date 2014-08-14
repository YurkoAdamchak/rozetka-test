package com.atqc047.tools;

import org.openqa.selenium.WebElement;

public class StringHelper {

	public static String concatInToLocator(String begin, String value) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(begin).append(value).append("']");
		return stringBuilder.toString();
	}

	public static String concatInToLocator(String begin, String value,
			String end) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(begin).append(value).append(end);
		return stringBuilder.toString();
	}

	public static String concatInToLocator(String begin, int value, String end) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(begin).append(value).append(end);
		return stringBuilder.toString();
	}

	public static int getAllDigitsFromWebElementInnerText(WebElement webElement) {
		String stringValue = webElement.getText().replaceAll("[^0-9]", "");
		int digits = Integer.parseInt(stringValue);
		return digits;
	}

	public static int getAllDigitsFromWebElementStyleAttribute(
			WebElement webElement) {
		String stringValue = webElement.getAttribute("style").replaceAll(
				"[^0-9]", "");
		int digits = Integer.parseInt(stringValue);
		return digits;
	}
	
	public static String getAllNumbersFromWebElementInnerText(WebElement webElement) {
		String stringValue = webElement.getText().replaceAll("[^0-9]", "");
		return stringValue;
	}
}
