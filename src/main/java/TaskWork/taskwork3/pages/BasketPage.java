package TaskWork.taskwork3.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends BasePage{

    @FindBy(xpath = "//div[@class = 'slider']//*[contains(text(),'+ 12  мес.')]")
    WebElement warranty;

    @FindBy(xpath = "//div[@class = 'total-amount']//*[@class = 'price__current']")
    WebElement priceBasket;

    @FindBy(xpath = "//span[@class = 'base-ui-radio-button__icon base-ui-radio-button__icon_checked']")
    WebElement radioButtonWarranty;

    @FindBy(xpath = "//nav[@id= 'header-search']//a[@id='header-logo']")
    WebElement mainPage;

    @FindBy(xpath = "//div[@class = 'group-tabs']//span[@class = 'restore-last-removed']")
    WebElement returnDeletProduct;


    public BasketPage(WebDriver driver){
        PageFactory.initElements(driver , this);
        this.driver = driver;
    }

    public void selectWarranty(){
        warranty.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int rememberPriceBasket(){
        return Integer.parseInt(priceBasket.getText());
    }

    public void checkWarranty(){
        radioButtonWarranty.getAttribute("class").contains("base-ui-radio-button__icon base-ui-radio-button__icon_checked");
    }

    public void selectMainPage(){
        mainPage.click();
    }

    public void selectDeletProduct(String value){
        driver.findElement(By.xpath("//a[contains(text(),'"+value+"')]/../..//button[text() = 'Удалить']" )).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void searchProduct(String value){
        if(isElementPresent(By.xpath("//a[contains(text(),'"+value+"')]"))==true){
            Assertions.assertAll();
        };
    }

    public void addProduct(String value) {
        driver.findElement(By.xpath("//*[contains(text(),'" + value + "')]/../../../../..//div[@class= 'count-buttons']//i[@class = 'count-buttons__icon-plus']" )).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectReturnDeletProduct(){
        returnDeletProduct.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
