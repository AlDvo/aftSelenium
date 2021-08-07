package TaskWork.taskwork2;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TaskWork2Test extends BaseTest{

    @Test
    void TaskWork2Test(){
        select(By.xpath("//div[text() = 'Да']"));
        select(By.xpath("//div[@class = 'header__bottom']//a[contains(text(),'Ипотека')]"));
        select(By.xpath("//div[@id = 'menu2']//a[contains(text(),'Рефинансирование')]"));
        chekSelect("Рефинансирование ипотеки и других кредитов",By.xpath("//h1[contains(text(),'Рефинансирование ипотеки')]"));
        select(By.xpath("//div[@class = 'b-intro']//a[contains(text(),'Оставить заявку')]"));
        chekSelect("Оставьте заявку на рефинансирование ипотеки прямо сейчас",By.xpath("//div[text() = 'Оставьте заявку на рефинансирование ипотеки прямо сейчас']"));


        fill(By.xpath("//input[@id = 'fullName']"),"Иванов Иван Иванович");
        fillDate(By.xpath("//input[@name = 'birthDate']"),"11.05.1995");
        fill(By.xpath("//input[@name = 'birthPlace']"),"Москва");

        select(By.xpath("//span[text() = 'Мужской']"));

        passportNotRF(By.xpath("//h3[contains(text(),'Паспорт')]"));

        select(By.xpath("//div[@name ='citizenship']"));
        select(By.xpath("//div[text() = 'Германия']"));
        chekSelect("Германия",By.xpath("//div[@name ='citizenship']//span[text() = 'Германия']"));


        fill(By.xpath("//input[@name = 'foreignSeries']"),"2200");
        fill(By.xpath("//input[@name = 'foreignNumber']"),"321321");
        fillDate(By.xpath("//input[@name = 'foreignIssuedDate']"),"11.06.2006");
        fill(By.xpath("//input[@name = 'foreignIssuedBy']"),"111");
        fill(By.xpath("//input[@name = 'registrationAddress']"),"г Москва, Ломоносовский пр-кт, д 27Д");

        select(By.xpath("//button[text()='Продолжить']"));

        chekSelect("Поле обязательно для заполнения",By.xpath("//div[text()='Ежемесячный доход']/../div[text()='Поле обязательно для заполнения']"));
        chekSelect("Поле обязательно для заполнения",By.xpath("//div[text()='Могу подтвердить с помощью']/../div[text()='Поле обязательно для заполнения']"));
        chekSelect("Выберите из списка", By.xpath("//div[text()='Город приобретаемой недвижимости']/../div[text()='Выберите из списка']"));
        chekSelect("Поле обязательно для заполнения",By.xpath("//div[text()='E-mail']/../div[text()='Поле обязательно для заполнения']"));
        chekSelect("Поле обязательно для заполнения",By.xpath("//div[text()='Телефон']/../div[text()='Поле обязательно для заполнения']"));
        chekSelect("Поле обязательно для заполнения",By.xpath("//label[@data-marker='Checkbox.Box']/../div[text()='Поле обязательно для заполнения']"));

    }
}
