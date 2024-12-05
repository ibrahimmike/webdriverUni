package pages.basePage;

import browserManager.BrowserManager;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class BasePage {

   public BrowserManager browserManager;

    public BasePage(BrowserManager browserManager){
        this.browserManager = browserManager;
    }
    protected Page getPage() {
        return browserManager.getPage();
    }
    public BrowserManager getBrowserManager(){
        return browserManager;
    }
    protected void waitAndClickOnElementBySelector(String selector){
        browserManager.getPage().waitForSelector(selector,
                new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        browserManager.getPage().click(selector);
    }
}
