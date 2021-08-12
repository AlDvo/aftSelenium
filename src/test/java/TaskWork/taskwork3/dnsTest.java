package TaskWork.taskwork3;

import TaskWork.taskwork3.pages.*;
import org.junit.jupiter.api.Test;

public class dnsTest extends BaseTest{
    MainPage mainPage = new MainPage();


    @Test
    public void dnsTest(){

        mainPage.selectTown()
                .Search("Samsung S10")
                .selectChooseProduct("S10+")
                .selectBuy()
                .selectInBasket()
                .selectWarranty()
                .selectMainPage()
                .Search("Detroit")
                .selectChooseProduct("")
                .selectBuy()
                .selectInBasket()
                .checkWarranty()
                .selectDeletProduct("Detroit")
                .searchProduct("Detroit")
                .addProduct("Samsung")
                .selectReturnDeletProduct();



    }
}
