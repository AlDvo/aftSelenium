package TaskWork.taskwork3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//div[@class = 'left-filters']")
    WebElement filter;

    @FindBy(xpath = "//div[@class = 'left-filters']//button[text() = 'Применить']")
    WebElement applyFilter;

    @FindBy(xpath = "//div[@class = 'catalog-products view-simple'][1]")
    WebElement chooseProduct;

    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver , this);
        this.driver = driver;
    }

    public void selectFilter(String value){
        filter.findElement(By.xpath(".//span[text() = '"+value+"']")).click();
    }

    public void selectApplyFilter(){
        applyFilter.click();
    }

    public void selectChooseProduct(String value){
        chooseProduct.isEnabled();
        chooseProduct.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
    }
}
