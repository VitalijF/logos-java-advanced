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
    @CsvSource(value = {
            "1, -1",
            "-2, 1",
            "-3, -5",
    })
    public void testPositiveMultiplyError(double firstNumber, double secondNumber) {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> multiplier.positiveMultiply(firstNumber, secondNumber));
        Assertions.assertEquals("Only positive number can be multiplied", exception.getMessage());
    }

    // TODO: Написати тест кейси для positiveMultiply (мінімум 5) для випадку коли два числа додатні
    @ParameterizedTest
    @CsvSource(value = {
            "6, 6, 36",
            "100, 5, 500",
            "30, 5, 150",
            "41, 2, 82",
            "2, 11, 22",
            "3, 7, 21",
    })
    public void testPositiveMultiply(double firstNumber, double secondNumber, double expected) {
        double actual = multiplier.positiveMultiply(firstNumber, secondNumber);
        Assertions.assertEquals(expected, actual);
    }
}