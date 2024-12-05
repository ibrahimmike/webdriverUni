package pages;

import browserManager.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pages.basePage.BasePage;
import sun.security.ec.point.ProjectivePoint;
import sun.security.util.math.ImmutableIntegerModuloP;

public class PageObjectModelPage extends BasePage {

    private final String carouselPreviousBtnXpath = "//div[@id='carousel-example-generic']//a[@data-slide='prev']";
    private final String carouselNextBtnXpath = "//div[@id='carousel-example-generic']//a[@data-slide='next']";



    public PageObjectModelPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void clickOnTheHomeAnchorTagInTheMiniNavBar(){
        Locator homeLinkOnTheNavBar = browserManager.getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home"));
        homeLinkOnTheNavBar.click();

    }
}
