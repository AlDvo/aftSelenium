package TaskWork.taskwork3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//form[@class= 'presearch']//input")
    WebElement search;

    @FindBy(xpath = "//div[@class = 'dropdown-city']//a[text()='Да']")
    WebElement town;

    @FindBy(xpath = "//div[@class = 'dropdown-city']//p[@class='w-choose-city-widget__city-info']")
    WebElement townAsk;

    @FindBy(xpath = "//div[@class= 'container']//span[@class='ui-input-search__icon ui-input-search__icon_search ui-input-search__icon_presearch']")
    WebElement magnifier;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver , this);
        this.driver = driver;
    }

    public void Search(String product){
        search.clear();
        search.sendKeys(product);
        magnifier.click();
    }

    public void selectTown(){
        if(townAsk.isEnabled()){
            town.click();
        }
    }
}
