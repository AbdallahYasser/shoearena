package pages;

import bases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {



    private final By item = By.cssSelector("h2[class='product-title'] a");


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName(){
        return getElement(item).getText();
    }

}

