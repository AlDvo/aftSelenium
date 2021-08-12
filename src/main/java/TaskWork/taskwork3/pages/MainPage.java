package TaskWork.taskwork3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//form[@class= 'presearch']//input")
    WebElement search;

    @FindBy(xpath = "//div[@class = 'dropdown-city']//a[text()='Да']")
    WebElement town;

    @FindBy(xpath = "//div[@class = 'dropdown-city']//p[@class='w-choose-city-widget__city-info']")
    WebElement townAsk;

    @FindBy(xpath = "//div[@class= 'container']//span[@class='ui-input-search__icon ui-input-search__icon_search ui-input-search__icon_presearch']")
    WebElement magnifier;


    public SearchPage Search(String product){
        search.clear();
        search.sendKeys(product);
        magnifier.click();
        return new SearchPage();
    }

    public MainPage selectTown(){
        if(townAsk.isEnabled()){
            town.click();
        }
        return this;
    }
}
