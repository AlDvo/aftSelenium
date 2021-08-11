package TaskWork.taskwork3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected String BaseURL;

    @BeforeEach
    public void Before() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        BaseURL = "https://www.dns-shop.ru/";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BaseURL);
    }

    @AfterEach
    public void After(){driver.quit();}

    public void fill(By locator , String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
        Assertions.assertEquals( value ,driver.findElement(locator).getAttribute("value"), "Данные не совпадают");
        driver.findElement(locator).click();
    }

}
