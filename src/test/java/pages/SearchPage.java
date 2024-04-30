package pages;
import bases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class SearchPage extends BasePage {

    private final By item = By.xpath("/html[1]/body[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/figure[1]/a[1]/img[1]");

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public ItemPage clickOnItem(){
        getElement(item).click();

        return new ItemPage(driver);
    }
}
