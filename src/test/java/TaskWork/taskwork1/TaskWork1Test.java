package TaskWork.taskwork1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TaskWork1Test {
    WebDriver driver;
    String BaseURL;

    @Before
    public void Before(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        BaseURL = "http://www.rgs.ru";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BaseURL);
    }

    @Test
    public void taskWork1Test(){
        driver.findElement(By.xpath("//*[@class ='btn btn-default text-uppercase']")).click();
        driver.findElement(By.xpath("//*[@class ='dropdown adv-analytics-navigation-line1-link current']")).click();
        driver.findElement(By.xpath("//div[@class = 'rgs-main-menu-category']//*[contains(text(),'Здоровье') and @class ='hidden-xs' ]")).click();
        driver.findElement(By.xpath("//div[@class = 'list-group list-group-rgs-menu']//*[contains(text(),'Добровольное медицинское страхование (ДМС)') ]")).click();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement title = driver.findElement(By.xpath("//*[@class = 'content-document-header']"));
        Assert.assertEquals("Заголовок отсутвтвует", "ДМС — добровольное медицинское страхование",title.getText());

        driver.findElement(By.xpath("//*[@class = 'container']//*[contains(text(),'Отправить заявку')]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement application = driver.findElement(By.xpath("//*[@class = 'modal-content']//*[contains(text(),'Заявка на добровольное медицинское страхование')]"));
        Assert.assertEquals("Окно не открылось", "Заявка на добровольное медицинское страхование",application.getText());

        fill(By.xpath("//*[@class = 'row']//*[@name='LastName']"),"Фамилия");
        fill(By.xpath("//*[@class = 'row']//*[@name='FirstName']"),"Имя");
        fill(By.xpath("//*[@class = 'row']//*[@name='MiddleName']"),"Отчество");
        fill(By.xpath("//*[contains(@data-bind,'Phone')]"),"9991231236");
        fill(By.xpath("//*[@class = 'row']//*[@name='Email']"),"qwertyqwerty");
        fill(By.xpath("//*[@class = 'row']//*[@name='Comment']"),"комментарий");


        new Select(driver.findElement(By.xpath("//*[@class = 'row']//*[@name='Region']"))).selectByVisibleText("Москва");


        driver.findElement(By.xpath("//*[@class = 'col-xs-12']//*[@type='checkbox']")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals("Данные не совпадают", "Фамилия",driver.findElement(By.xpath("//*[@class = 'row']//*[@name='LastName']")).getAttribute("value"));
        Assert.assertEquals("Данные не совпадают", "Имя",driver.findElement(By.xpath("//*[@class = 'row']//*[@name='FirstName']")).getAttribute("value"));
        Assert.assertEquals("Данные не совпадают", "Отчество",driver.findElement(By.xpath("//*[@class = 'row']//*[@name='MiddleName']")).getAttribute("value"));
//        Assert.assertEquals("Данные не совпадают", "+7 (999) 123-12-36",driver.findElement(By.xpath("//*[contains(@data-bind,'Phone')]")).getAttribute("value"));
        Assert.assertEquals("Данные не совпадают", "qwertyqwerty",driver.findElement(By.xpath("//*[@class = 'row']//*[@name='Email']")).getAttribute("value"));
        Assert.assertEquals("Данные не совпадают", "комментарий",driver.findElement(By.xpath("//*[@class = 'row']//*[@name='Comment']")).getAttribute("value"));
        Assert.assertEquals("Москва", new Select(driver.findElement(By.xpath("//*[@class = 'row']//*[@name='Region']"))).getAllSelectedOptions().get(0).getText());

        driver.findElement(By.xpath("//*[@class = 'col-md-12 col-xs-12']//*[@type='button']")).click();

        WebElement mistake = driver.findElement(By.xpath("//*[text()='Введите адрес электронной почты']"));
        Assert.assertEquals("Ошибка отсутвстует", "Введите адрес электронной почты",mistake.getText());

    }
    public void fill(By locator , String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    @After
    public void After(){driver.quit();}
}
