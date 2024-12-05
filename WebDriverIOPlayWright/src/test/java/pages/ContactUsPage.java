package pages;

import browserManager.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pages.basePage.BasePage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactUsPage extends BasePage {
    Locator firstName = browserManager.getPage().getByPlaceholder("First Name");
    Locator lastName = browserManager.getPage().getByPlaceholder("Last Name");
    Locator emailLocator = browserManager.getPage().getByPlaceholder("Email Address");
    Locator commentsLocator = browserManager.getPage().getByPlaceholder("Comments");
    Locator submitBtn = browserManager.getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SUBMIT"));
    public ContactUsPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void typeFirstName(String name){
        firstName.fill(name);
    }
    public void typeLastName(String lastNameName){
        lastName.fill(lastNameName);
    }
    public void typeEmail(String email){
        emailLocator.fill(email);
    }
    public void typeComment(String comments){
        commentsLocator.fill(comments);
    }
    public void clickOnTheSubmitButton(){
        submitBtn.click();
    }
    public boolean getTheErrorMessage(){
        browserManager.getPage().waitForSelector("body");
        Locator bodyElement = browserManager.getPage().locator("body");
        String bodyText = bodyElement.textContent();
        Pattern pattern = Pattern.compile("Error: (all fields are required|Invalid email address)");
        Matcher matcher = pattern.matcher(bodyText);
        return matcher.find();

    }
}
