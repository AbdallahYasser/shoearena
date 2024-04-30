package pages;

import bases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage extends BasePage {


    private final By itemTitle = By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h1[3]");
    private final By buttonSize40 = By.cssSelector("[data-eu=40]");
    private final By buttonSizeOS = By.cssSelector("[data-eu=OS]");
    private final By addToCartButton = By.cssSelector("[id=button-cart]");
    private final By showCartButton = By.cssSelector("button[class='btn-primary']");

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName(){
        return getElement(itemTitle).getText();
    }

    public ItemPage clickOSSize(){
        getElement(buttonSizeOS).click();
        return this;
    }

    public CartPage showCart(){
        getElement(showCartButton).isDisplayed();
        getElement(showCartButton).click();
        return new CartPage(driver);
    }

    public ItemPage addToCart(){
        getElement(addToCartButton).click();

        //wait until the popup appear (FireFox)
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }






}
