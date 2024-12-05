package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ClickButtonsPage;

public class ClickOnButtonsTest extends BaseTest{

    @Test
    public void clickOnClickButtonsPage(){
        hp.navigateToHomePage();
       ClickButtonsPage cbp = hp.clickOnButtonsTitle();

       String notificationText = cbp.clickOnTheFirstClickMeButton();
        System.out.println("The notification text for the first button : "+ notificationText);
        Assert.assertEquals(notificationText, "Well done for successfully using the click() method!");

    }
    @Test
    public void clickOnTheSecondButton(){
        hp.navigateToHomePage();
        ClickButtonsPage cbp = hp.clickOnButtonsTitle();

        String notificationText = cbp.clickOnTheSecondButton();
        System.out.println("The notification text for the second button : "+ notificationText);
        Assert.assertEquals(notificationText, "Well done for successfully using the click() method!");
    }
}
