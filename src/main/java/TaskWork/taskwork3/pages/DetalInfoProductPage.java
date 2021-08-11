package TaskWork.taskwork3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetalInfoProductPage extends BasePage{

    @FindBy(xpath = "//div[@class='product-card-top__buy']//div[@class = 'product-buy__price']")
    WebElement priceDetal;

    @FindBy(xpath = "//div[@class = 'product-card-top__buy']//*[text() = 'Купить']")
    WebElement buy;

    @FindBy(xpath = "/div[@class = 'buttons']//*[@class = 'cart-link__price']")
    WebElement basket;

    @FindBy(xpath = "//div[@class = 'product-card-top__buy']//*[text() = 'В корзине']")
    WebElement inBasket;


    public DetalInfoProductPage(WebDriver driver){
        PageFactory.initElements(driver , this);
        this.driver = driver;
    }

    public int rememberPriceDetal(){
        return Integer.parseInt(priceDetal.getText());
    }

    public void selectBuy(){
        buy.click();
    }

    public int rememberPriceBasket(){
        return Integer.parseInt(basket.getText());
    }

    public void selectInBasket(){
        inBasket.click();
    }
}
