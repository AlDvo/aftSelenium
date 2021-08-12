package TaskWork.taskwork3.pages;

import TaskWork.taskwork3.manager.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected DriverManager driverManager = DriverManager.getDriverManager();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 10,1000);


    public BasePage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }


    public boolean isElementPresent(By locator) {
        try {
            driverManager.getDriver().findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
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
