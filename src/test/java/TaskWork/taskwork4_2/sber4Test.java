package TaskWork.taskwork4_2;

import TaskWork.taskwork4_2.pages.MainPage;
import org.junit.jupiter.api.Test;

public class sber4Test extends BaseTest{
    MainPage mainPage = new MainPage();

    @Test
    public void sber4_2Test(){

        mainPage.closeCookie()
                .selectTopMenu("Ипотека")
                .selectSubMenu("Ипотека на вторичное жильё")
                .scroll()
                .switchToFrame()
                .selectCalculator("Стоимость недвижимости","5 180 000")
                .selectCalculator("Первоначальный взнос", "3 058 000")
                .selectCalculator("Срок кредита","30")
                .selectCheckbox("Страхование жизни и здоровья","false")
                .selectCheckbox("Молодая семья","true")
                .selectResultBlock("Сумма кредита", "2 122 000 ₽")
                .selectResultBlock("Ежемесячный платеж","16 618 ₽")
                .selectResultBlock("Необходимый доход","21 393 ₽")
                .selectResultBlock("Процентная ставка","11%");
    }
}
