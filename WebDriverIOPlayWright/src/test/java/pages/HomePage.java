package pages;

import browserManager.BrowserManager;
import com.microsoft.playwright.Page;
import pages.basePage.BasePage;

public class HomePage extends BasePage {

    String contactUsXpath = "//div[@class='section-title']//h1[text()='CONTACT US']";
    String loginPortalBtnXpath = "//div[@class='section-title']//h1[text()='LOGIN PORTAL']";
    String buttonClicksXpath = "//div[@class='section-title']//h1[text()='BUTTON CLICKS']";
    String toDoListBtnXpath = "//div[@class='section-title']//h1[text()='TO DO LIST']";
    String pageObjectModelXpathBtn = "//a[@id='page-object-model']//h1[text()='PAGE OBJECT MODEL']";



    public HomePage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void navigateToHomePage(){
        browserManager.getPage().navigate("https://www.webdriveruniversity.com/");
    }
    public ContactUsPage clickOnContactUsPage(){

        getBrowserManager().setPage(browserManager.getBrowserContext().waitForPage(
                ()->   waitAndClickOnElementBySelector(contactUsXpath)
        ));
        getBrowserManager().getPage().bringToFront();
//        page.context().waitForPage(
//
//                ()->  waitAndClickOnElementBySelector(contactUsXpath)
//        );
//        page.context().browser().newContext().waitForPage(
//                ()->  waitAndClickOnElementBySelector(contactUsXpath)
//        );
//        page.bringToFront();

       return new ContactUsPage(browserManager);
    }
    public LoginPortalPage clickOnTheLoginPortalTitle(){
        getBrowserManager().setPage(browserManager.getBrowserContext().waitForPage(
                ()-> waitAndClickOnElementBySelector(loginPortalBtnXpath)
        ));
        getBrowserManager().getPage().bringToFront();
        return new LoginPortalPage(browserManager);
    }
    public ClickButtonsPage clickOnButtonsTitle(){
        getBrowserManager().setPage(getBrowserManager().getBrowserContext().waitForPage(
                ()->waitAndClickOnElementBySelector(buttonClicksXpath)
        ));
        return new ClickButtonsPage(browserManager);
    }
    public ToDoListPage clickOnToDoListTitle(){
        getBrowserManager().setPage(getBrowserManager().getBrowserContext().waitForPage(
                ()->waitAndClickOnElementBySelector(toDoListBtnXpath)
        ));
        return new ToDoListPage(browserManager);
    }
    public PageObjectModelPage clickOnPageObjectModelBtn(){
        getBrowserManager().setPage(
                getBrowserManager().getBrowserContext().waitForPage(
                        ()->  waitAndClickOnElementBySelector(pageObjectModelXpathBtn)
                )
        );
        return new PageObjectModelPage(browserManager);
    }



}
