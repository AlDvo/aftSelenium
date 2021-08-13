package TaskWork.taskwork4_1.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetalInfoProductPage extends BasePage {

    @FindBy(xpath = "//div[@class='product-card-top__buy']//div[@class = 'product-buy__price']")
    WebElement priceDetal;

    @FindBy(xpath = "//div[@class = 'product-card-top__buy']//*[text() = 'Купить']")
    WebElement buy;

    @FindBy(xpath = "/div[@class = 'buttons']//*[@class = 'cart-link__price']")
    WebElement basket;

    @FindBy(xpath = "//div[@class = 'product-card-top__buy']//*[text() = 'В корзине']")
    WebElement inBasket;


    public int rememberPriceDetal(){
        return Integer.parseInt(priceDetal.getText());
    }

    @Step("Нажали кнопку Купить , в карточке товара")
    public DetalInfoProductPage selectBuy(){
        buy.click();
        return this;
    }

    public int rememberPriceBasket(){
        return Integer.parseInt(basket.getText());
    }

    @Step("Нажали кнопку корзина , перешли на страницу корзина")
    public BasketPage selectInBasket(){
        inBasket.click();
        return new BasketPage();
    }
}
