public class StringHelper {
    private static final String DELIMITER = "_";

    /**
     * Check if string is empty
     * @return true if input string is empty, otherwise - false
     */
    public boolean isEmpty(String string) {
        return string == null || string.equals("");
    }

    /**
     * Return string without first second symbols
     * @param string to convert
     * @return result string without first second symbols. Example "Test" will be replaced into "st"
     */
    //Повертає стрічку без перших двох симовлів
    public String getWithoutFirstSecondSymbols(String string) {
        if (isEmpty(string) || string.length() < 2) {
            throw new IllegalArgumentException("String should contain 2 or more symbols");
        }
        return string.substring(2);
    }

    /**
     * Concatenate two strings with delimiter
     * @param firstString to concatenate
     * @param secondString to concatenate
     *
     * @return result of concatenation. For "string" and "1" result will be "string_1"
     */
    //Повертає результат обєднання двох стрічок з деліметром "_"
    public String concatenateTwoStringsWithDelimiter(String firstString, String secondString) {
        if (isEmpty(firstString) || isEmpty(secondString)) {
            throw new IllegalArgumentException("Strings must not be empty");
        }
        if (firstString.equals(secondString)) {
            throw new IllegalArgumentException("Strings must be different");
        }
        return firstString + DELIMITER + secondString;
    }
}
