package TaskWork.taskwork4_2.steps;

import TaskWork.taskwork4_2.manager.PageManager;
import io.cucumber.java.ru.И;

public class MainPageSteps {
    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Нажали кнопку Закрыть , в всплывающем окне куки$")
    public void closeCookie() {
        pageManager.getMainPage().closeCookie();
    }

    @И("^Выбрали пункт меню \"(.+)\"$")
    public void selectTopMenu(String value){
        pageManager.getMainPage().selectTopMenu(value);
    }

    @И("^Выбрали под пункт меню \"(.+)\"$")
    public void selectSubMenu(String value){
        pageManager.getMainPage().selectSubMenu(value);
    }
}
