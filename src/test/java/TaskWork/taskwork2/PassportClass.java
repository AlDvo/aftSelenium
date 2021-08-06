package TaskWork.taskwork2;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class PassportClass {
    public static Stream<Arguments> msMP() {
        return Stream.of(
                Arguments.of("Иванов Иван Иванович", "11.05.1995", "Москва" , "2200", "321321", "11.06.2006", "111", "г Москва, Ломоносовский пр-кт, д 27Д"),
                Arguments.of("Сидоров Семен Иванович", "03.09.1987", "Пенза" , "2700", "355321", "15.01.2000", "111", "г Москва, Ломоносовский пр-кт, д 27Д"),
                Arguments.of("Малевич Алексей Аркадьевич", "23.08.1975", "Тверь" , "6201", "321885", "10.09.1999", "111", "г Москва, Ломоносовский пр-кт, д 27Д"));
    }
}
