package TaskWork.taskwork3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//div[@class = 'left-filters']")
    WebElement filter;

    @FindBy(xpath = "//div[@class = 'left-filters']//button[text() = 'Применить']")
    WebElement applyFilter;

    @FindBy(xpath = "//div[@class = 'catalog-products view-simple'][1]")
    WebElement chooseProduct;


    public SearchPage selectFilter(String value){
        filter.findElement(By.xpath(".//span[text() = '"+value+"']")).click();
        return this;
    }

    public SearchPage selectApplyFilter(){
        applyFilter.click();
        return this;
    }

    public DetalInfoProductPage selectChooseProduct(String value){
        chooseProduct.isEnabled();
        chooseProduct.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
        return new DetalInfoProductPage();
    }
}
