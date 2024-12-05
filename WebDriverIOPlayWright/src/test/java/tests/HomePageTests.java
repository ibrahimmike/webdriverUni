package tests;

import browserManager.BrowserManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.LoginPortalPage;
import pages.basePage.BasePage;

public class HomePageTests extends BaseTest {


    @Test
    public void clickOnContactUsPage1() throws InterruptedException {
       hp.navigateToHomePage();
      ContactUsPage cp = hp.clickOnContactUsPage();
      cp.typeFirstName("Ibrahim the cute");
      cp.typeLastName("The cutest");
      cp.typeEmail("Ibahim.thecute@cutest.com");
      cp.typeComment("The cutest ever");
      cp.clickOnTheSubmitButton();


    //   Thread.sleep(30000);
    }
    @Test
    public void clickOnContactUsPage2(){
        hp.navigateToHomePage();
        ContactUsPage cp = hp.clickOnContactUsPage();
        cp.typeFirstName("Ibrahim the cute2");
        cp.typeLastName("The cutest");
        cp.typeEmail("Ibahim.thecute@cutest.com");
        cp.typeComment("The cutest ever");
        cp.clickOnTheSubmitButton();

    }
    @Test
    public void clickOnContactUsPage3(){
        hp.navigateToHomePage();
        ContactUsPage cp = hp.clickOnContactUsPage();
        cp.typeFirstName("Ibrahim the cute3");
        cp.typeLastName("The cutest");
        cp.typeEmail("Ibahim.thecute@cutest.com");
        cp.typeComment("The cutest ever");
        cp.clickOnTheSubmitButton();

    }
    @Test
    public void clickOnContactUsPage4(){
        hp.navigateToHomePage();
        ContactUsPage cp = hp.clickOnContactUsPage();
        cp.typeFirstName("Ibrahim the cute4");
        cp.typeLastName("The cutest");
        cp.typeEmail("Ibahim.thecute@cutest.com");
        cp.typeComment("The cutest ever");
        cp.clickOnTheSubmitButton();

    }
    @Test
    public void clickOnLoginTitle(){
        hp.navigateToHomePage();
      LoginPortalPage loginPortalPage =  hp.clickOnTheLoginPortalTitle();
      loginPortalPage.typeUserName("lalal");
      loginPortalPage.typePassword("gogogo");
      loginPortalPage.clickOnTheLoginBtn();
        System.out.println("The alert on the login page text : "+loginPortalPage.getTheAlertTextBtn());


    }



}
