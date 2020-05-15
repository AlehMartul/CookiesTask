import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private IButton link = AqualityServices.getElementFactory()
            .getButton(By.xpath("//a[contains(@href, 'example')]"), "link");

    public MainPage() {
        super(By.xpath("//pre[contains(@style, 'word')]"), "MainPage");
    }

    @Override
    public boolean isPageLoaded() {
        return link.state().waitForDisplayed();
    }

}
