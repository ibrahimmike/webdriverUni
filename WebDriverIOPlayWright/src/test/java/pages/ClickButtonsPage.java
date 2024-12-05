package pages;

import browserManager.BrowserManager;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.JSHandle;
import com.microsoft.playwright.Page;
import pages.basePage.BasePage;

public class ClickButtonsPage extends BasePage {

    String button1Xpath = "//div//span[@id='button1']";
    String button2Xpath = "//div//span[@id='button2']";
    String button3Xpath = "//div//span[@id='button3']";
    String notificationMessage;
    public ClickButtonsPage(BrowserManager browserManager) {

        super(browserManager);
    }

    public String clickOnTheFirstClickMeButton(){


        waitAndClickOnElementBySelector(button1Xpath);
     //   getBrowserManager().getPage().bringToFront();
        String content = getBrowserManager().getPage().waitForSelector("//div[@class='modal-content']//h4[1]").textContent();
        System.out.println("Extracted data : " + content);
        notificationMessage = getBrowserManager().getPage().waitForSelector("//div[@class='modal-content']//p")
                .textContent();

        System.out.println("The notification text from the method itself : " + notificationMessage);

        return notificationMessage;

    }
    public String clickOnTheSecondButton(){
        waitAndClickOnElementBySelector(button2Xpath);

        String header = getBrowserManager().getPage().waitForSelector("//div[@class='modal-dialog modal-md']//h4").textContent();
      //  notificationMessage = getBrowserManager().getPage().waitForSelector("//div[@class='modal-content']//p").textContent();


        return notificationMessage = header;
    }
    public String clickOnTheThirdButton(){
        getBrowserManager().getPage().onceDialog(
                dialog -> {
                    notificationMessage = dialog.message();
                    dialog.accept();
                }
        );
        waitAndClickOnElementBySelector(button3Xpath);
        return notificationMessage;
    }

}
