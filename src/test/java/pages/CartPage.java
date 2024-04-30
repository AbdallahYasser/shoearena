package pages;
import bases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CartPage extends BasePage {
    private final By item = By.cssSelector("div[class='clsMainCartProductName'] p a");
    private final By processToCheckOutButton = By.cssSelector(".btn.btn-block.btn-sm.btn-primary");
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public String getItemName(){
        return getElement(item).getText();
    }
    public CheckOutPage clickProcessToCheckOut(){
        getElement(processToCheckOutButton).click();
        return new CheckOutPage(driver);
    }


}


