package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ToDoListPage;

public class ToDoListTests extends BaseTest {

    String toDoListHeader = "//div[@id='container']/h1";
    ToDoListPage toDoListPage ;


    @Test(priority = 1)
    public void clickOnToDoListBtn(){
       hp.navigateToHomePage();
      hp.clickOnToDoListTitle();
    }
    @Test(priority=2)
    public void checkTheHeaderOfTheToDoList(){
        hp.navigateToHomePage();
        toDoListPage =  hp.clickOnToDoListTitle();
        Assert.assertEquals(toDoListPage.checkTheHeaderText().trim(),"TO-DO LIST");
    }
    @Test(priority = 3)
    public void removeToDoListItem(){
        hp.navigateToHomePage();
      ToDoListPage tdl =  hp.clickOnToDoListTitle();
      tdl.removeItemFromList();
    }

}
