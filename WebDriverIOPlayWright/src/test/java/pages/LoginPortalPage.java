package pages;

import browserManager.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pages.basePage.BasePage;

public class LoginPortalPage extends BasePage {

    Locator userNameField = browserManager.getPage().getByPlaceholder("Username");
    Locator userPasswordField = browserManager.getPage().getByPlaceholder("Password");
    Locator loginBtn = browserManager.getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
    String alertText;

    public LoginPortalPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void typeUserName(String name){
        userNameField.fill(name);
    }
    public void typePassword(String password){
        userPasswordField.fill(password);
    }
    public void clickOnTheLoginBtn(){


        browserManager.getPage().onceDialog(dialog ->{
            alertText = dialog.message();
            dialog.accept();
                });
        loginBtn.click();
    }
    public String getTheAlertTextBtn(){
        return alertText;
    }


}
