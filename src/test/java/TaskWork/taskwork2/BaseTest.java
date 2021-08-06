package TaskWork.taskwork2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    String BaseURL;

    @BeforeEach
    public void Before() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        BaseURL = "https://www.raiffeisen.ru";
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

    public void select(By locator ){
        driver.findElement(locator).click();
    }

    public void chekSelect(String value ,By locator  ){
        Assertions.assertEquals(value ,driver.findElement(locator).getText(),"Данные не совпадают");
    }

    public void passportNotRF(By locator){
        if(driver.findElement(locator).getText().equals("Паспорт гражданина РФ")){
            driver.findElement(By.xpath("//b[text() = 'Являюсь гражданином РФ']")).click();
            Assertions.assertEquals("Паспорт иностранного гражданина" ,driver.findElement(locator).getText(),"Данные не совпадают");
        }
    }
    public void fillDate(By locator , String value){
        driver.findElement(locator).sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        driver.findElement(locator).sendKeys(value);
        Assertions.assertEquals( value ,driver.findElement(locator).getAttribute("value"),"Данные не совпадают");

    }
}
