import framework.utils.CookiesUtils;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CookiesTest extends BaseTest{

    private static final Cookie COOKIE1 = new Cookie("Example_key_1", "Example_value_1");
    private static final Cookie COOKIE2 = new Cookie("Example_key_2", "Example_value_2");
    private static final Cookie COOKIE3 = new Cookie("Example_key_3", "Example_value_3");
    private static final Cookie COOKIE3_UPD = new Cookie("Example_key_3", "Example_value_300");

    @Test
    public void testCookies() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageLoaded(), "Main page didn't load");
        CookiesUtils.setCookie(COOKIE1);
        CookiesUtils.setCookie(COOKIE2);
        CookiesUtils.setCookie(COOKIE3);
        Assert.assertTrue(CookiesUtils.isCookieAdded(COOKIE1), "First cookie added");
        Assert.assertTrue(CookiesUtils.isCookieAdded(COOKIE2), "Second cookie added");
        Assert.assertTrue(CookiesUtils.isCookieAdded(COOKIE3), "Third cookie added");
        CookiesUtils.deleteCookie(COOKIE1);
        Assert.assertFalse(CookiesUtils.isCookieAdded(COOKIE1), "First cookie deleted");
        CookiesUtils.changeCookie(COOKIE3, COOKIE3_UPD);
        Assert.assertTrue(CookiesUtils.isCookieChanged(COOKIE3_UPD));
        CookiesUtils.deleteAllCookies();
        Assert.assertFalse(CookiesUtils.isCookieAdded(COOKIE3), "Second cookie deleted");
        Assert.assertFalse(CookiesUtils.isCookieAdded(COOKIE3_UPD), "Third cookie deleted");
    }
}