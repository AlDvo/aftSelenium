package TaskWork.taskwork4_1.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    @FindBy(xpath = "//form[@class= 'presearch']//input")
    WebElement search;

    @FindBy(xpath = "//div[@class = 'dropdown-city']//a[text()='Да']")
    WebElement town;

    @FindBy(xpath = "//div[@class = 'dropdown-city']//p[@class='w-choose-city-widget__city-info']")
    WebElement townAsk;

    @FindBy(xpath = "//div[@class= 'container']//span[@class='ui-input-search__icon ui-input-search__icon_search ui-input-search__icon_presearch']")
    WebElement magnifier;


    @Step("Ввели в поисковую строку '{product}' и нажали поиск")
    public SearchPage Search(String product){
        wait.until(ExpectedConditions.elementToBeClickable(search));
        search.clear();
        search.sendKeys(product);
        magnifier.click();
        return new SearchPage();
    }

    @Step("Подтвердили своё местонахождение")
    public MainPage selectTown(){
        if(townAsk.isEnabled()){
            town.click();
        }
        return this;
    }
}
