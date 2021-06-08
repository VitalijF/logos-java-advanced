package logos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MultiplierTest {

    private Multiplier multiplier;

    @BeforeEach
    public void test() {
        multiplier = new Multiplier();
    }

    //TODO: пофіксити
    @ParameterizedTest
    @CsvSource(value = {
            "1, 1, 1",
            "2, 1, 2",
            "3, 5, 15",
            "4, 2, 8",
            "1, 10, 10",
            "5, 5, 25",
    })
    public void testMultipleTwoNumbers(double firstNumber, double secondNumber, double expected) {
        double actual = multiplier.multiply(firstNumber, secondNumber);
        Assertions.assertEquals(expected, actual);
    }

    //TODO: пофіксити
    @ParameterizedTest
    @CsvSource(value = {
            "1, 1, 1, 1",
            "2, 1, 5, 10",
            "3, 5, 1, 15",
            "4, 2, 7, 56",
            "1, 10, 2, 20",
            "5, 5, 2, 50",
    })
    public void testMultipleThreeNumbers(double firstNumber, double secondNumber, double thirdNumber, double expected) {
        double actual = multiplier.multiply(firstNumber, secondNumber, thirdNumber);
        Assertions.assertEquals(expected, actual);
    }

    // TODO: Написати тест кейси для positiveMultiply (3 кейси) для випадку коли якесь з чисел або обидва є відємні
    @ParameterizedTest
    @CsvSource(
            value = {
                    "-3, 10",
                    "3, -10",
                    "-3, -10"
            }
    )
    public void testPositiveMultiplyError(double a, double b) {

        IllegalArgumentException illegalArgumentException =
                Assertions.assertThrows(IllegalArgumentException.class, () -> this.multiplier.positiveMultiply(a, b));

        Assertions.assertEquals("Only positive number can be multiplied", illegalArgumentException.getMessage());

    }

    // TODO: Написати тест кейси для positiveMultiply (мінімум 5) для випадку коли два числа додатні
    @ParameterizedTest
    @CsvSource(
            value = {
                    "1,1,1",
                    "2,2,4",
                    "2,5,10",
                    "11, 3, 33",
                    "6, 4, 24"
            }
    )
    public void testPositiveMultiply(double a, double b, double expected) {

        double actual = multiplier.positiveMultiply(a, b);

        Assertions.assertEquals(expected, actual);

    }
}
