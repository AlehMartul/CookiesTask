import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import framework.utils.ReadPropertyTool;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private static final String MAIN_URL = ReadPropertyTool.getData("mainUrl");;

    protected BaseTest() {
    }

    @BeforeMethod
    protected void beforeMethod() {
        getBrowser().maximize();
        getBrowser().goTo(MAIN_URL);
    }

    @AfterMethod
    public void afterTest() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }

    protected Browser getBrowser() {
        return AqualityServices.getBrowser();
    }
}
