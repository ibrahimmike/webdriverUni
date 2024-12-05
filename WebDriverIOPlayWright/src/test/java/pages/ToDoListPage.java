package pages;

import browserManager.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.basePage.BasePage;

import java.util.concurrent.TimeUnit;

public class ToDoListPage extends BasePage {
    String toDoListHeaderXpath = "//div[@id='container']/h1";
    String firstElementOnTheToDoList = "//div[@id='container']//ul//li[1]";
    String deleteItem = "//div[@id='container']//ul//li/span";
    public ToDoListPage(BrowserManager browserManager) {
        super(browserManager);
    }
    public String checkTheHeaderText(){
      return  browserManager.getPage().waitForSelector(toDoListHeaderXpath).textContent();
    }
    public void addNewToDoList(){

    }
    public void removeItemFromList(){
        Locator firstItemLocator = getBrowserManager().getPage().locator(firstElementOnTheToDoList);

        getBrowserManager().getPage().hover(firstElementOnTheToDoList);
      //  Locator span = firstItemLocator.locator("span/i");

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.getMessage();
        }
        getBrowserManager().getPage().click("//div[@id='container']//ul//li[1]//span//i");
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.getMessage();
        }


    }
}
