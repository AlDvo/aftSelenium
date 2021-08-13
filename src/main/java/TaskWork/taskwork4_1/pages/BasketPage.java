package TaskWork.taskwork4_1.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasketPage extends BasePage {

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

    @Step("Добавляем гарантию для товара")
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

    @Step("Проверяем, что гарантия выбрана")
    public BasketPage checkWarranty(){
        radioButtonWarranty.getAttribute("class").contains("base-ui-radio-button__icon base-ui-radio-button__icon_checked");
        return this;
    }

    @Step("Переходим в главное меню")
    public MainPage selectMainPage(){
        mainPage.click();
        return new MainPage();
    }

    @Step("Удаляем товар '{value}' из корзины")
    public BasketPage selectDeletProduct(String value){
        driverManager.getDriver().findElement(By.xpath("//a[contains(text(),'"+value+"')]/../..//button[text() = 'Удалить']" )).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[contains(text(),'"+value+"')]")));
        return this;
    }

    @Step("Опеределяем , есть ли товар '{value}' в корзине")
    public BasketPage searchProduct(String value){
        if(isElementPresent(By.xpath("//a[contains(text(),'"+value+"')]"))==true){
            Assertions.fail("Объект в корзине");
        }
        return this;
    }

    @Step("Увеличиваем количество товара '{value}' на 1 шт.")
    public BasketPage addProduct(String value) {
        driverManager.getDriver().findElement(By.xpath("//*[contains(text(),'" + value + "')]/../../../../..//div[@class= 'count-buttons']//i[@class = 'count-buttons__icon-plus']" )).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Вернуть удаленный товар ,проверяем что товар '{value}'  в корзине")
    public BasketPage selectReturnDeletProduct(String value){
        returnDeletProduct.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'"+value+"')]")));
        if(isElementPresent(By.xpath("//a[contains(text(),'"+value+"')]"))==false){
            Assertions.fail("Объекта нет в корзине");
        }
        return this;
    }
}
