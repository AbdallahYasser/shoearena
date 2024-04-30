package pages;
import bases.BasePage;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertiesUtils;

public class HomePage extends BasePage {


    //here I have to submit button the two buttons have the same name
   private final By registerLoginButton = By.cssSelector(".clsHeadAccountIcon");
    private final By registerButton = By.cssSelector(".clsRlink");
    private final By loginButton = By.cssSelector(".clsLlink.clsLRActive");
    private final By registerSubmitButton = By.xpath("(//input[@id='submit'])[3]");
    private final By loginSubmitButton = By.cssSelector("input[onclick='javascript: submitnotifylogin();']");
    private final By firstNameTextField = By.cssSelector("#registerfirst");
    private final By lastNameTextField = By.cssSelector("#registerlast");
    private final By emailTextField = By.cssSelector("#registeremail");
    private final By passwordTextField = By.cssSelector("#registerpassword");
    private final By femaleGenderRadioButton = By.cssSelector("[value=female]");
    private final By maleGenderRadioButton = By.cssSelector("[value=male]");
    private final By loginEmailTextField = By.cssSelector("#notifyemail");
    private final By loginPasswordTextField = By.cssSelector("#notifypassword");
    private final By megaSaleBanner = By.xpath("(//img[@alt='MEGA SALE'])[1] or ");






    public HomePage(WebDriver driver) {
        super(driver);
    }


    public AccountPage register(User user){

//        getElement(firstNameTxt).click();

        getElement(registerLoginButton).click();
        getElement(registerButton).click();
        getElement(firstNameTextField).sendKeys(user.getFirstName());
        getElement(lastNameTextField).sendKeys(user.getLastName());
        getElement(emailTextField).sendKeys(user.getEmail());
        getElement(passwordTextField).sendKeys(user.getPassword());

        switch (user.getGender()){
            case MEN  -> getElement(maleGenderRadioButton).click();
            case WOMAN -> getElement(femaleGenderRadioButton).click();
            default -> System.out.println("error in gender");

        }
        getElement(registerSubmitButton).click();



        return new AccountPage(driver);
    }



    public HomePage load(){
        driver.get(PropertiesUtils.getBaseUrl());
        return this;
    }

    public AccountPage login(User user){

//       getElement(megaSaleBanner).isDisplayed();
        getElement(registerLoginButton).click();
        getElement(loginButton).click();
        getElement(loginEmailTextField).sendKeys(user.getEmail());
        getElement(loginPasswordTextField).sendKeys(user.getPassword());
        getElement(loginSubmitButton).click();



        return new AccountPage(driver);
    }






}
