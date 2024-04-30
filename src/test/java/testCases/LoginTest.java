package testCases;
import bases.BaseTest;
import models.User;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import utils.UserUtils;

public class LoginTest extends BaseTest {

    @Test
    public void shouldBeAbleToLoginWithEmailAndPassword(){


        User user = UserUtils.generateUSer(User.Gender.MEN);

        HomePage homePage = new HomePage(driver);
          homePage
                .load()
                .register(user);

        driver.manage().deleteAllCookies();


//            I don't know why it doesn't load the page second time in chrome, edge, so I added wait
        if(driver instanceof ChromeDriver || driver instanceof EdgeDriver){
            UserUtils.waitMe(3000);
        }

        AccountPage accountPage = homePage
                .load()
                .login(user);

        Assert.assertEquals(user.getFirstName(),accountPage.getFirstName());
        Assert.assertEquals(user.getLastName(),accountPage.getLastName());
        Assert.assertEquals(user.getEmail(),accountPage.getEmail());

    }

    }

