package com.atqc047.consts;

public interface RozetkaLocators {
	public static final String SIGNIN_LINK = "signin";
	public static final String LOGIN_INPUT_FIELD = "login";
	public static final String PASSWORD_INPUT_FIELD = "password";
	public static final String LOGIN_FORM = "msg";
	public static final String USER_PROFILE = "profile";
	public static final String SEARCH_INPUT = "text";
	public static final String SIGNOUT_LINK = "signout";
	public static final String NEW_CATEGORIES = "new";
	public static final String FIND_BUTTON = "//*[@id='body-header']//button";
	public static final String SEARCH_RESULT = "//*[contains(@id, 'head')]//h1";
	public static final String SEARCH_WORD = "//*[contains(@id, 'head')]//h1/span";
	public static final String ADD_TO_WISHLIST_LINK = "(//*[@href='#Wishlist'])[3]";
	public static final String SUBMIT_WISHLIST_FORM = "submit-by-ajax";
	public static final String CLOSE_WISHLIST_POPUP = "close";
	public static final String PHONES_MP3_GPS_MENU = "phones-mp3-gps";
	public static final String TELEPHONES_LINK = "h6>a[href*='mobile-phones']";
	public static final String PRICE_CATEGORY_LINK_BEGIN = "a[href*='";
	public static final String PRODUCER_CATEGORY_LINK_BEGIN = ".//span[contains(text(),'";
	public static final String PRODUCER_CATEGORY_LINK_END = "')]";
	public static final String PRODUCT_POSITION_BEGIN = "input[value='";
	public static final String PRODUCT_POSITION_END = "']+div .gtile-i-title>a";
	public static final String STARS_RATING_PRODUCT_PAGE_BEGIN = "input[value='";
	public static final String STARS_RATING_PRODUCT_PAGE_END = "']+div .g-rating-stars-i";
	public static final String PRICE_PRODUCT_PAGE_BEGIN = "input[value='";
	public static final String PRICE_PRODUCT_PAGE_END = "']+div .g-price-uah";
	public static final String PRICE_PRODUCT_DETAILS_PAGE = ".pp-rating-section .g-rating *[style]";
	public static final String STARS_RATING_PRODUCT_DETAILS_PAGE = ".pp-uah";	
	public static final String NUMBER_OF_REVIEWS_SEARCH_PAGE = ".underline.lightblue.g-rating-reviews-link";
	public static final String NUMBER_OF_REVIEWS_PRODUCT_DETAILS_PAGE = ".underline>span[itemprop='reviewCount']";
	public static final String PRODUCT_SELECTOR = ".g-i-list-title>a";
	public static final String REVIEW_TAB = "#detail-tab-reviews-add-submit";

}
