package TaskWork.taskwork2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

public class TaskWork2_1Test extends BaseTest{

        @ParameterizedTest
        @MethodSource("TaskWork.taskwork2.PassportClass#msMP")
        void TaskWork2_1Test(String fullName , String birthDate , String birthPlace ,String foreignSeries,String foreignNumber,String foreignIssuedDate,String foreignIssuedBy,String registrationAddress){

            select(By.xpath("//div[text() = 'Да']"));
            select(By.xpath("//div[@class = 'header__bottom']//a[contains(text(),'Ипотека')]"));
            select(By.xpath("//div[@id = 'menu2']//a[contains(text(),'Рефинансирование')]"));
            chekSelect("Рефинансирование ипотеки и других кредитов",By.xpath("//h1[contains(text(),'Рефинансирование ипотеки')]"));
            select(By.xpath("//div[@class = 'b-intro']//a[contains(text(),'Оставить заявку')]"));
            chekSelect("Оставьте заявку на рефинансирование ипотеки прямо сейчас",By.xpath("//div[text() = 'Оставьте заявку на рефинансирование ипотеки прямо сейчас']"));


            fill(By.xpath("//input[@id = 'fullName']"),fullName);
            fillDate(By.xpath("//input[@name = 'birthDate']"),birthDate);
            fill(By.xpath("//input[@name = 'birthPlace']"),birthPlace);

            select(By.xpath("//span[text() = 'Мужской']"));

            passportNotRF(By.xpath("//h3[contains(text(),'Паспорт')]"));

            select(By.xpath("//div[@name ='citizenship']"));
            select(By.xpath("//div[text() = 'Германия']"));
            chekSelect("Германия",By.xpath("//div[@name ='citizenship']//span[text() = 'Германия']"));

            fill(By.xpath("//input[@name = 'foreignSeries']"),foreignSeries);
            fill(By.xpath("//input[@name = 'foreignNumber']"),foreignNumber);
            fillDate(By.xpath("//input[@name = 'foreignIssuedDate']"),foreignIssuedDate);
            fill(By.xpath("//input[@name = 'foreignIssuedBy']"),foreignIssuedBy);
            fill(By.xpath("//input[@name = 'registrationAddress']"),registrationAddress);

            select(By.xpath("//button[text()='Продолжить']"));

            chekSelect("Поле обязательно для заполнения",By.xpath("//div[text()='Ежемесячный доход']/../div[text()='Поле обязательно для заполнения']"));
            chekSelect("Поле обязательно для заполнения",By.xpath("//div[text()='Могу подтвердить с помощью']/../div[text()='Поле обязательно для заполнения']"));
            chekSelect("Выберите из списка", By.xpath("//div[text()='Город приобретаемой недвижимости']/../div[text()='Выберите из списка']"));
            chekSelect("Поле обязательно для заполнения",By.xpath("//div[text()='E-mail']/../div[text()='Поле обязательно для заполнения']"));
            chekSelect("Поле обязательно для заполнения",By.xpath("//div[text()='Телефон']/../div[text()='Поле обязательно для заполнения']"));
            chekSelect("Поле обязательно для заполнения",By.xpath("//label[@data-marker='Checkbox.Box']/../div[text()='Поле обязательно для заполнения']"));


        }
    }

