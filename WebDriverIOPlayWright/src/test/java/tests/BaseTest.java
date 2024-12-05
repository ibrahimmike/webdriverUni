package tests;

import browserManager.BrowserManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTest {

    BrowserManager browserManager;

    HomePage hp;

    @BeforeMethod
    public void setUp(){
        browserManager = new BrowserManager();
        hp =new HomePage(browserManager);



    }
    @AfterMethod
    public void tearDown(){
        browserManager.tearDown();

    }
}
