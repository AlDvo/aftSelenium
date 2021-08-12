package TaskWork.taskwork3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetalInfoProductPage extends BasePage{

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

    public DetalInfoProductPage selectBuy(){
        buy.click();
        return this;
    }

    public int rememberPriceBasket(){
        return Integer.parseInt(basket.getText());
    }

    public BasketPage selectInBasket(){
        inBasket.click();
        return new BasketPage();
    }
}
