public class Multiplier {

    /**
     * Multiply two double numbers
     * @param a first number
     * @param b second number
     * @return result of multiplying
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Multiply three double numbers
     * @param a first number
     * @param b second number
     * @param c third number
     * @return result of multiplying
     */
    public double multiply(double a, double b, double c) {
        final double resultOfMultiplyingForFirstTwoNumbers = multiply(a,b);
        return multiply(resultOfMultiplyingForFirstTwoNumbers, c);
    }

    /**
     * Multiply two positive double numbers
     * @param a first number
     * @param b second number
     * @return result of multiplying
     * @throws IllegalArgumentException when one of numbers is negative or 0
     */
    public double positiveMultiply(double a, double b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Only positive number can be multiplied");
        }
        return multiply(a, b);
    }
}