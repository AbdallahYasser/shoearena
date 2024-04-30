package testCases;

import bases.BaseTest;
import models.User;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ItemPage;
import utils.PropertiesUtils;
import utils.UserUtils;

public class AddToCartTest extends BaseTest {
    



    @Test
    public void shouldBeAbleToAddItemToCart(){

        User user = UserUtils.generateUSer(User.Gender.MEN);

        HomePage homePage = new HomePage(driver);
         homePage.load()
                .register(user)
                .searchForItem(PropertiesUtils.getItemName())
                .clickOnItem()
                .clickOSSize()
                .addToCart();


        //Add wait until the popup appear (FireFox)
        if (driver instanceof FirefoxDriver){
            UserUtils.waitMe(4000);
            System.out.println("inside fireFox wait");
        }

        ItemPage itemPage = new ItemPage(driver);
        CartPage cartPage =  itemPage.showCart();
        ////////////////////////////////////////////

        Assert.assertEquals(PropertiesUtils.getItemName(),cartPage.getItemName());



    }




}
