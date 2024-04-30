package testCases;

import bases.BaseTest;
import models.User;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.HomePage;
import pages.ItemPage;
import utils.PropertiesUtils;
import utils.UserUtils;

public class CheckoutTest extends BaseTest {


    @Test
    public void shouldBeAbleToCheckOut(){

        User user = UserUtils.generateUSer(User.Gender.MEN);

        HomePage homePage = new HomePage(driver);
         homePage.load()
                .register(user)
                .searchForItem(PropertiesUtils.getItemName())
                .clickOnItem()
                .clickOSSize()
                .addToCart();


       //add wait for FireFox
        if (driver instanceof FirefoxDriver){
            UserUtils.waitMe(4000);
        }
       ItemPage itemPage = new ItemPage(driver);
        CheckOutPage checkOutPage =itemPage.showCart().clickProcessToCheckOut();
        //////////////////////////////////////////////////////





        Assert.assertEquals(PropertiesUtils.getItemName(),checkOutPage.getItemName());



    }

}
