package pages;

import bases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {


    private final By firstName = By.xpath("//*[contains(text(),'الاسم الأول ') or contains(text(),'First Name : ') ]");
    private  final By lastName = By.xpath("//*[contains(text(),'اسم العائلة : ') or contains(text(),'Last Name : ') ]");
    private  final By email = By.xpath("//*[contains(text(),'البريد الالكتروني : ')or contains(text(),'E-Mail : ') ]");
    private  final By searchTextField = By.cssSelector("#search-box");
    private  final By searchButton = By.cssSelector("#search-submit");
    private  final By controlPanel = By.cssSelector(".dashbord");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstName() {

        getElement(firstName).isDisplayed();
        String firstNameText = getElement(firstName).getText() ;
        //use
//        return getElement(firstName).getText().replace("الاسم الأول : ","");
        return firstNameText.substring(firstNameText.indexOf(": ") + 2);
    }

    public String getLastName(){

        String lastNameText = getElement(lastName).getText() ;
        return lastNameText.substring(lastNameText.indexOf(": ") + 2);
    }

    public String getEmail(){
//        String emailText = getElement(email).getText();
        return getElement(email).findElement(By.xpath("*")).getText();
//        return getElement(email).findElement(By.xpath("*")).getAttribute("href");
    }

    public SearchPage searchForItem(String itemName)  {


        // this line to make selenium wait until accountPage loads, if you remove it, search function won't work
        getElement(controlPanel).isDisplayed();


        getElement(searchTextField).sendKeys(itemName);
        getElement(searchButton).click();

        return new SearchPage(driver);
    }





}
