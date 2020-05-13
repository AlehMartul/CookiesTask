import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import java.util.Set;

public class MainPage extends BasePage{

    private aquality.selenium.browser.Browser browser = AqualityServices.getBrowser();
    private IButton link = AqualityServices.getElementFactory()
            .getButton(By.xpath("//a[contains(@href, 'example')]"), "link");
    Cookie cookie1 = new Cookie("Example_key_1", "Example_value_1");
    Cookie cookie2 = new Cookie("Example_key_2", "Example_value_2");
    Cookie cookie3 = new Cookie("Example_key_3", "Example_value_3");
    Cookie cookie3UPD = new Cookie("Example_key_3", "Example_value_300");

    public boolean isMainPageLoaded() {
        return isPageLoaded(link);
    }

    public void setCookie1() {
        browser.getDriver().manage().addCookie(cookie1);
    }

    public void setCookie2() {
        browser.getDriver().manage().addCookie(cookie2);
    }

    public void setCookie3() {
        browser.getDriver().manage().addCookie(cookie3);
    }

    public Set<Cookie> getAllCookies() {
        Set<Cookie> cookies = browser.getDriver().manage().getCookies();
        return cookies;
    }

    public boolean isCookieOneAdded() {
        return getAllCookies().contains(cookie1);
    }

    public boolean isCookieTwoAdded() {
        return getAllCookies().contains(cookie2);
    }

    public boolean isCookieThreeAdded() {
        return getAllCookies().contains(cookie3);
    }

    public boolean isCookieThreeChanged() {
        return getAllCookies().contains(cookie3UPD);
    }

    public void deleteFirstCookie() {
        browser.getDriver().manage().deleteCookie(cookie1);
    }

    public void deleteAllCookies(){
        browser.getDriver().manage().deleteAllCookies();
    }

    public void changeThirdCookie() {
        browser.getDriver().manage().deleteCookie(cookie3);
        browser.getDriver().manage().addCookie(cookie3UPD);
    }
}
