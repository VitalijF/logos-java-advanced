package logos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringHelperTest {

    private StringHelper stringHelper;

    @BeforeEach
    public void initialize() {
        stringHelper = new StringHelper();
    }

    //Teсткейс або тесткейси для методу isEmpty() який повинен повернути true
    @Test
    void testStringIsNotEmpty() {

        String nullStr = null;
        String emptyStr = "";

        Assertions.assertTrue(stringHelper.isEmpty(emptyStr));
        Assertions.assertTrue(stringHelper.isEmpty(nullStr));
    }

    //Teсткейс або тесткейси для методу isEmpty() який повинен повернути false
    @ParameterizedTest
    @CsvSource(
            value = {
                    "Value",
                    "Str",
                    "test"
            }
    )
    void testStringIsEmpty(String str) {
        Assertions.assertFalse(stringHelper.isEmpty(str));
    }

    //Teсткейс або тесткейси для методу getWithoutFirstSecondSymbols() який повинен повернути стрічку без перших двох символів
    @ParameterizedTest
    @CsvSource(
            value = {
                    "unhappy, happy",
                    "good, od"
            }
    )
    void testGetWithoutFirstSecondSymbols(String str, String expected) {

        Assertions.assertEquals(expected, stringHelper.getWithoutFirstSecondSymbols(str));

    }

    //Teсткейс або тесткейси для методу getWithoutFirstSecondSymbols() який повинен викинути ексепшин
    @Test
    void testGetWithoutFirstSecondSymbolsException() {
        String nullStr = null;
        String emptyStr = "";
        String oneElemStr = "a";

        Assertions.assertThrows(IllegalArgumentException.class, () -> stringHelper.getWithoutFirstSecondSymbols(nullStr));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringHelper.getWithoutFirstSecondSymbols(emptyStr));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringHelper.getWithoutFirstSecondSymbols(oneElemStr));
    }

    //Tecткейси для методу concatenateTwoStringsWithDelimiter
    @ParameterizedTest
    @CsvSource(
            value = {
                    "Test, value, Test_value",
                    "8888, pppp, 8888_pppp"
            }
    )
    void testConcatenateTwoStringsWithDelimiter(String str1, String str2, String expected){

        Assertions.assertEquals(expected, stringHelper.concatenateTwoStringsWithDelimiter(str1, str2));


    }

    @Test
    void testConcatenateTwoStringsWithDelimiterException() {
        String nullStr = null;
        String emptyStr = "";

        String str1 = "test";
        String str2 = "test";

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringHelper.concatenateTwoStringsWithDelimiter(str1, nullStr));
        IllegalArgumentException illegalArgumentExceptionEmpty = Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringHelper.concatenateTwoStringsWithDelimiter(str1, emptyStr));

        IllegalArgumentException illegalArgumentExceptionEqual = Assertions.assertThrows(IllegalArgumentException.class,
                () -> stringHelper.concatenateTwoStringsWithDelimiter(str1, str2));

        Assertions.assertNotEquals(illegalArgumentExceptionEmpty.getMessage(), illegalArgumentExceptionEqual.getMessage());
    }
}