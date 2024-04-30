package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class WebDriverFactory {


    public static WebDriver initialise(){

        WebDriver webDriver;

        String driverType =  System.getProperty("driver","edge");
          switch (driverType) {
            case "chrome" -> webDriver = new ChromeDriver();
            case "firefox" -> webDriver = new FirefoxDriver();
            case "edge" -> webDriver = new EdgeDriver();
            case "safari" -> webDriver = new SafariDriver();

            default -> throw new RuntimeException(driverType + "driver in not supported");
        };

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return webDriver;
    }
}
