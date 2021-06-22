package logos;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class StringHelperTest {

    private StringHelper stringHelper;

    @BeforeEach
    public void init() {
        stringHelper = new StringHelper();
    }

    //Teсткейс або тесткейси для методу isEmpty() який повинен повернути true
    @ParameterizedTest
    @NullAndEmptySource
    void testStringIsEmpty(String string) {
        Assertions.assertTrue(stringHelper.isEmpty(string));
    }

    //Teсткейс або тесткейси для методу isEmpty() який повинен повернути false
    @ParameterizedTest
    @ValueSource(strings = {
            "test",
            ",",
            "123",
            " "
    })
    void testStringIsNotEmpty(String string) {
        Assertions.assertFalse(stringHelper.isEmpty(string));
    }

    //Teсткейс або тесткейси для методу getWithoutFirstSecondSymbols() який повинен повернути стрічку без перших двох символів
    @ParameterizedTest
    @CsvSource(value = {
            "Test, st",
            "bicycle, cycle",
            "defrost, frost",
    })
    void testGetWithoutFirstSecondSymbols(String string, String expected) {
        String actual = stringHelper.getWithoutFirstSecondSymbols(string);
        Assertions.assertEquals(expected, actual);
    }

    //Teсткейс або тесткейси для методу getWithoutFirstSecondSymbols() який повинен викинути ексепшин
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "t",
            ","
    })
    void testGetWithoutFirstSecondSymbolsException(String string) {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringHelper.getWithoutFirstSecondSymbols(string));
        Assertions.assertEquals("String should contain 2 or more symbols", exception.getMessage());
    }

    //Tecткейси для методу concatenateTwoStringsWithDelimiter
    @ParameterizedTest
    @CsvSource(value = {
            "First, test, First_test",
            "2, test, 2_test",
            "1, 5, 1_5"
    })
    void testConcatenateTwoStringsWithDelimiter(String firstString, String secondString, String expected) {
        String actual = stringHelper.concatenateTwoStringsWithDelimiter(firstString, secondString);
        Assertions.assertEquals(expected, actual);
    }

    //Tесткейси для методу concatenateTwoStringsWithDelimiter які повинні викинути ексепшин на пусту стрічку
    //Варіант 1
    @ParameterizedTest
    @CsvSource(value = {
            "test1, ''",
            "'', test2",
            "'',''",
            ", test3",
            "test4, ",
            ","
    })
    void testConcatenateTwoStringsWithDelimiterEmptyException1(String firstString, String secondString) {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringHelper.concatenateTwoStringsWithDelimiter(firstString, secondString));
        Assertions.assertEquals("Strings must not be empty", exception.getMessage());
    }

    //Tесткейси для методу concatenateTwoStringsWithDelimiter які повинні викинути ексепшин на пусту стрічку
    //Варіант 2
    @ParameterizedTest
    @MethodSource("stringsForTestProvider")
    void testConcatenateTwoStringsWithDelimiterEmptyException2(String firstString, String secondString) {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringHelper.concatenateTwoStringsWithDelimiter(firstString, secondString));
        Assertions.assertEquals("Strings must not be empty", exception.getMessage());
    }

    static Stream<Arguments> stringsForTestProvider() {
        return Stream.of(
                Arguments.arguments("test1", null),
                Arguments.arguments(null, "test2"),
                Arguments.arguments(null, null),
                Arguments.arguments("test3", ""),
                Arguments.arguments("", "test4"),
                Arguments.arguments("", "")
        );
    }

    //Tесткейси для методу concatenateTwoStringsWithDelimiter які повинні викинути ексепшин на однакові стрічки
    @ParameterizedTest
    @CsvSource(value = {
            "test, test",
            "1, 1"
    })
    void testConcatenateTwoStringsWithDelimiterEqualStringsException(String firstString, String secondString) {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringHelper.concatenateTwoStringsWithDelimiter(firstString, secondString));
        Assertions.assertEquals("Strings must be different", exception.getMessage());
    }

}