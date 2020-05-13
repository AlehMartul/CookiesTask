import org.testng.Assert;
import org.testng.annotations.Test;

public class CookiesTest extends BaseTest{

    @Test
    public void testCookies() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isMainPageLoaded(), "Main page didn't load");
        mainPage.setCookie1();
        mainPage.setCookie2();
        mainPage.setCookie3();
        Assert.assertTrue(mainPage.isCookieOneAdded(), "First cookie added");
        Assert.assertTrue(mainPage.isCookieTwoAdded(), "Second cookie added");
        Assert.assertTrue(mainPage.isCookieThreeAdded(), "Third cookie added");
        mainPage.deleteFirstCookie();
        Assert.assertFalse(mainPage.isCookieOneAdded(), "First cookie deleted");
        mainPage.changeThirdCookie();
        Assert.assertTrue(mainPage.isCookieThreeChanged());
        mainPage.deleteAllCookies();
        Assert.assertFalse(mainPage.isCookieTwoAdded(), "Second cookie deleted");
        Assert.assertFalse(mainPage.isCookieThreeChanged(), "Third cookie deleted");
    }
}