package TaskWork.taskwork4_2.steps;

import TaskWork.taskwork4_2.manager.PageManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;

public class CompleteHousePageSteps {
    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Скролим до калькулятора$")
    public void scroll(){
        pageManager.getCompleteHousePage().scroll().switchToFrame();
    }


    @И("^Заполняем поля :$")
    public void selectCalculator(DataTable mapFieldsAndValue){
        mapFieldsAndValue.asMap(String.class, String.class).forEach((value, rub) ->
            pageManager.getCompleteHousePage().selectCalculator((String) value, (String) rub));
    }

    @И("^Проверяем  поля :$")
    public void selectResultBlock(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((value, rub) ->
                pageManager.getCompleteHousePage().selectResultBlock((String) value, (String) rub));
    }

    @И("^Устанавливаем галочку в графе  статус$")
    public void selectCheckbox(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getCompleteHousePage().selectCheckbox((String) key, (String) value));
    }


}
