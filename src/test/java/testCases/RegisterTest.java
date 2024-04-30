package testCases;

import bases.BaseTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import utils.UserUtils;

public class RegisterTest extends BaseTest {



    @Test
    public void ShouldBeAbleToRegister  (){

        User user = UserUtils.generateUSer(User.Gender.MEN);

        HomePage homePage = new HomePage(driver);
     AccountPage accountPage =  homePage
                .load()
                .register(user);

        Assert.assertEquals(user.getFirstName(),accountPage.getFirstName());
        Assert.assertEquals(user.getLastName(),accountPage.getLastName());
        Assert.assertEquals(user.getEmail(),accountPage.getEmail());

    }
}
