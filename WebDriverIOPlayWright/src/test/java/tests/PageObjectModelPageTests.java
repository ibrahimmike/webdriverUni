package tests;

import org.testng.annotations.Test;
import pages.PageObjectModelPage;

public class PageObjectModelPageTests extends BaseTest {

    @Test
    public void clickOnTheHomeBtn(){
        hp.navigateToHomePage();
        hp.clickOnPageObjectModelBtn().clickOnTheHomeAnchorTagInTheMiniNavBar();

    }
}
