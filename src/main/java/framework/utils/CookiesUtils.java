package framework.utils;

import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class CookiesUtils {

    public static void setCookie(Cookie cookie) {
        AqualityServices.getBrowser().getDriver().manage().addCookie(cookie);
    }

    public static Set<Cookie> getAllCookies() {
        Set<Cookie> cookies = AqualityServices.getBrowser().getDriver().manage().getCookies();
        return cookies;
    }

    public static boolean isCookieAdded(Cookie cookie) {
        return getAllCookies().contains(cookie);
    }

    public static boolean isCookieChanged(Cookie cookie) {
        return getAllCookies().contains(cookie);
    }

    public static void deleteCookie(Cookie cookie) {
        AqualityServices.getBrowser().getDriver().manage().deleteCookie(cookie);
    }

    public static void deleteAllCookies() {
        AqualityServices.getBrowser().getDriver().manage().deleteAllCookies();
    }

    public static void changeCookie(Cookie cookie, Cookie cookie1) {
        AqualityServices.getBrowser().getDriver().manage().deleteCookie(cookie);
        AqualityServices.getBrowser().getDriver().manage().addCookie(cookie1);
    }

}