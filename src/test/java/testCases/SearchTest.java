package testCases;
import bases.BaseTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ItemPage;
import utils.PropertiesUtils;
import utils.UserUtils;

public class SearchTest extends BaseTest {

    @Test
    public void searchForItem(){

        User user = UserUtils.generateUSer(User.Gender.MEN);

        HomePage homePage = new HomePage(driver);
       ItemPage itemPage =  homePage.load()
                .register(user)
                .searchForItem(PropertiesUtils.getItemName())
                .clickOnItem();

        Assert.assertEquals(itemPage.getItemName(), PropertiesUtils.getItemName());

    }

}