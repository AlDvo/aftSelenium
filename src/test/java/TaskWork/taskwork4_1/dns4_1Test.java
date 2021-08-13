package TaskWork.taskwork4_1;

import TaskWork.taskwork4_1.pages.*;
import org.junit.jupiter.api.Test;

public class dns4_1Test extends BaseTest {
    MainPage mainPage = new MainPage();


    @Test
    public void dns4_1Test(){

        mainPage.selectTown()
                .Search("Samsung S10")
                .selectChooseProduct("S10+")
                .selectBuy()
                .selectInBasket()
                .selectWarranty()
                .selectMainPage()
                .Search("Detroit")
                .selectChooseProduct("Игра Detroit")
                .selectBuy()
                .selectInBasket()
                .checkWarranty()
                .selectDeletProduct("Detroit")
                .searchProduct("Detroit")
                .addProduct("Samsung")
                .selectReturnDeletProduct("Detroit");

    }
}
