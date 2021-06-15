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
            "abc",
            "'   '",
            "."
    })
    void testStringIsNotEmpty(String string) {
        boolean actual = stringHelper.isEmpty(string);
        Assertions.assertFalse(actual);
    }

    //Teсткейс або тесткейси для методу isEmpty() який повинен повернути false
    @ParameterizedTest
    @CsvSource(value = {
            "abc",
            "'   '",
            "."
    })
    void testStringIsEmpty(String string) {
        boolean actual = stringHelper.isEmpty(string);
        Assertions.assertFalse(actual);
    }

    //Teсткейс або тесткейси для методу getWithoutFirstSecondSymbols() який повинен повернути стрічку без перших двох символів
    @ParameterizedTest
    @CsvSource(value = {
            "abcde, cde",
            "ab, ''"
    })
    void testGetWithoutFirstSecondSymbols(String string, String expected) {
        String actual = stringHelper.getWithoutFirstSecondSymbols(string);
        Assertions.assertEquals(actual, expected);
    }

    //Teсткейс або тесткейси для методу getWithoutFirstSecondSymbols() який повинен викинути ексепшин
    @ParameterizedTest
    @CsvSource(value = {
            "a",
            "''",
    })
    void testGetWithoutFirstSecondSymbolsException(String string) {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringHelper.getWithoutFirstSecondSymbols(string));
        Assertions.assertEquals("String should contain 2 or more symbols", illegalArgumentException.getMessage());
    }
    //Tecткейси для методу concatenateTwoStringsWithDelimiter
    @ParameterizedTest
    @CsvSource(value = {
            "abc, def, abc_def",
            "abc, cba, abc_cba"
    })
    void testConcatenateTwoStringsWithDelimiter(String firstString, String secondString, String expected){
        String actual = stringHelper.concatenateTwoStringsWithDelimiter(firstString, secondString);
        Assertions.assertEquals(actual, expected);
    }
    @ParameterizedTest
    @CsvSource(value = {
            "'', 'f'",
            "'', ''",
            "'     ', ''"
    })
    void testConcatenateTwoStringsWithDelimiterEmptyString(String firstString, String secondString){
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringHelper.concatenateTwoStringsWithDelimiter(firstString, secondString));
        Assertions.assertEquals("Strings must not be empty", illegalArgumentException.getMessage());
    }
    @ParameterizedTest
    @CsvSource(value = {
            "a, a",
            "abc, abc"
    })
    void testConcatenateTwoStringsWithDelimiterIdentical(String firstString, String secondString){
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringHelper.concatenateTwoStringsWithDelimiter(firstString, secondString));
        Assertions.assertEquals("Strings must be different", illegalArgumentException.getMessage());
    }
}
