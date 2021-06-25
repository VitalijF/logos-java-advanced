package logos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringHelperTest {

    private StringHelper stringHelper;

    @BeforeEach
    public void test() {
        stringHelper = new StringHelper();
    }

    //Teсткейс або тесткейси для методу isEmpty() який повинен повернути true
    @ParameterizedTest
    @CsvSource(value = {
            ", true"
    })
    void testStringIsNotEmpty(String stringToCheck, boolean expected) {
        boolean actual = stringHelper.isEmpty(stringToCheck);
        Assertions.assertEquals(expected, actual);
    }

    //Teсткейс або тесткейси для методу isEmpty() який повинен повернути false
    @ParameterizedTest
    @CsvSource(value = {
            "notEmptyString, false",
            "also not empty string, false",
            "f, false"
    })
    void testStringIsEmpty(String stringToCheck, boolean expected) {
        boolean actual = stringHelper.isEmpty(stringToCheck);
        Assertions.assertEquals(expected, actual);
    }

    //Teсткейс або тесткейси для методу getWithoutFirstSecondSymbols() який повинен повернути стрічку без перших двох символів
    @ParameterizedTest
    @CsvSource(value = {
            "notEmptyString, tEmptyString",
            "also not empty string, so not empty string",
            "test, st",
            "hi, "
    })
    void testGetWithoutFirstSecondSymbols(String stringToCheck, String expected) {
        String actual = stringHelper.getWithoutFirstSecondSymbols(stringToCheck);
        Assertions.assertEquals(expected, actual);
    }

    //Teсткейс або тесткейси для методу getWithoutFirstSecondSymbols() який повинен викинути ексепшин
    @ParameterizedTest
    @CsvSource(value = {
            "h, String should contain 2 or more symbols",
            ", String should contain 2 or more symbols"
    })
    void testGetWithoutFirstSecondSymbolsException(String stringToCheck, String expected) {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringHelper.getWithoutFirstSecondSymbols(stringToCheck));
        Assertions.assertEquals(expected, exception.getMessage());
    }

    //Tecткейси для методу concatenateTwoStringsWithDelimiter
    @ParameterizedTest
    @CsvSource(value = {
            "first, second, first_second",
            "Sofiia, Didula, Sofiia_Didula",
            "test task, task, test task_task"
    })
    void testConcatenateTwoStringsWithDelimiter(String firstString, String secondString, String expected) {
        String actual = stringHelper.concatenateTwoStringsWithDelimiter(firstString, secondString);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            ",",
            "Sofiia,",
            ", test task"
    })
    void testConcatenateTwoStringsWithDelimiterEmptyStringsException(String firstString, String secondString) {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringHelper.concatenateTwoStringsWithDelimiter(firstString, secondString));
        Assertions.assertEquals("Strings must not be empty", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "first, first",
            "Sofiia, Sofiia",
            "test task, test task"
    })
    void testConcatenateTwoStringsWithDelimiterSameStringsException(String firstString, String secondString) {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringHelper.concatenateTwoStringsWithDelimiter(firstString, secondString));
        Assertions.assertEquals("Strings must be different", exception.getMessage());
    }
}
