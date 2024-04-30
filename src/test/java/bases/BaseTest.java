package bases;

import factory.WebDriverFactory;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BaseTest {

  protected  WebDriver driver;

    @BeforeMethod

    public void beforeMethod(){

        driver = WebDriverFactory.initialise();
    }


    @AfterMethod
    public void afterMethod(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        takeScreenShot(testName);

        driver.quit();

    }

    public void takeScreenShot(String fileName){

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File("screenshots/"+fileName+".png");


        try {
            FileHandler.copy(file,destination);
        } catch (IOException e) {
            throw new RuntimeException("error while save screenshot"+e);
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(destination);
            Allure.addAttachment("screenshot",fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}

