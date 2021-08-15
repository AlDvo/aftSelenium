package TaskWork.taskwork4_2.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CompleteHousePage extends BasePage{

    @FindBy(xpath = "//div[@class = 'dc-input__input-container-4-9-1']")
    WebElement calculator;

    @FindBy(xpath = "//div[@data-e2e-id= 'mland-calculator/result-block']")
    WebElement resultBlock;

    @FindBy(xpath = "//h2[text() = '\u200BРассчитайте ипотеку']")
    WebElement scroll;


    public CompleteHousePage scroll(){
        scrollToElementJs(scroll);
        return this;
    }

    public CompleteHousePage switchToFrame(){
        driverManager.getDriver().switchTo().frame(driverManager.getDriver().findElement(By.id("iFrameResizer0")));
        return this;
    }

    @Step("Заполняем поле '{value}' , значение '{rub}'")
    public CompleteHousePage selectCalculator(String value, String rub){
        calculator.findElement(By.xpath("//div[@class = 'dc-input__input-container-4-9-1']//div[text() = '"+value+"']/../input")).sendKeys(Keys.CONTROL + "a");
        calculator.findElement(By.xpath("//div[@class = 'dc-input__input-container-4-9-1']//div[text() = '"+value+"']/../input")).sendKeys(rub);
//        wait.until(ExpectedConditions.attributeContains
//                (calculator.findElement(By.xpath("//div[@class = 'dc-input__input-container-4-9-1']//div[text() = '"+value+"']/../input")), "value" , rub));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Проверяем значение поля '{value}' равно '{rub}'")
    public CompleteHousePage selectResultBlock(String value, String rub){
        Assertions.assertEquals(rub, resultBlock.findElement(By.xpath(".//*[text() = '"+value+"']/../span[contains(@data-e2e-id,'mland-calculator')]")).getText(), "Значение не совпадет");
      return this;
    }

    @Step("Устанавливаем галочку в графе '{value}' в статус '{checkbox}'")
    public CompleteHousePage selectCheckbox(String value , String checkbox){
        if(!driverManager.getDriver().findElement(By.xpath("//span[text() = '"+value+"']/../..//*[@type = 'checkbox']"))
                .getAttribute("aria-checked").contains(checkbox)){
        driverManager.getDriver().findElement(By.xpath("//span[text() = '"+value+"']/../..//*[@type = 'checkbox']")).click(); }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

}
