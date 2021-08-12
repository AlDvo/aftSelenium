package TaskWork.taskwork3.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    public BasketPage selectWarranty(){
        warranty.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public int rememberPriceBasket(){
        return Integer.parseInt(priceBasket.getText());
    }

    public BasketPage checkWarranty(){
        radioButtonWarranty.getAttribute("class").contains("base-ui-radio-button__icon base-ui-radio-button__icon_checked");
        return this;
    }

    public MainPage selectMainPage(){
        mainPage.click();
        return new MainPage();
    }

    public BasketPage selectDeletProduct(String value){
        driverManager.getDriver().findElement(By.xpath("//a[contains(text(),'"+value+"')]/../..//button[text() = 'Удалить']" )).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public  BasketPage searchProduct(String value){
        if(isElementPresent(By.xpath("//a[contains(text(),'"+value+"')]"))==true){
            Assertions.assertAll();
        }
        return this;
    }

    public BasketPage addProduct(String value) {
        driverManager.getDriver().findElement(By.xpath("//*[contains(text(),'" + value + "')]/../../../../..//div[@class= 'count-buttons']//i[@class = 'count-buttons__icon-plus']" )).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BasketPage selectReturnDeletProduct(){
        returnDeletProduct.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
