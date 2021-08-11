package TaskWork.taskwork3;

import TaskWork.taskwork3.pages.*;
import org.junit.jupiter.api.Test;

public class dnsTest extends BaseTest{

    @Test
    public void dnsTest(){
        MainPage mainPage = new MainPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        DetalInfoProductPage detalInfoProductPage = new DetalInfoProductPage(driver);
        BasketPage basketPage = new BasketPage(driver);

        mainPage.selectTown();
        mainPage.Search("Samsung S10");
        searchPage.selectChooseProduct("S10+");
        detalInfoProductPage.selectBuy();
        detalInfoProductPage.selectInBasket();
        basketPage.selectWarranty();
        basketPage.selectMainPage();
        mainPage.Search("Detroit");
        searchPage.selectChooseProduct("");
        detalInfoProductPage.selectBuy();
        detalInfoProductPage.selectInBasket();
        basketPage.checkWarranty();
        basketPage.selectDeletProduct("Detroit");
        basketPage.searchProduct("Detroit");
        basketPage.addProduct("Samsung");
        basketPage.selectReturnDeletProduct();



    }
}
