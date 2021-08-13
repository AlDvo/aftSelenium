package TaskWork.taskwork4_1.pages;

import TaskWork.taskwork4_1.manager.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected DriverManager driverManager = DriverManager.getDriverManager();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 10,1000);


    public BasePage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }


    public boolean isElementPresent(By locator) {
        try {
            driverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driverManager.getDriver().findElement(locator);
            driverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return true;
        } catch (NoSuchElementException e) {
            driverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return false;
        }
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void checkPrice(Integer product, Integer basket) {
        Assertions.assertEquals(basket,product);
    }

}
