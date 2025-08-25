public class DivisionByZeroHandling {
    public static void main(String[] args) {

        // Test Case 1
        divide(10, 2);

        // Test Case 2
        divide(20, 0);

        // Test Case 3
        divide(-5, 5);

        // Test Case 4
        divide(0, 3);

        // Test Case 5
        divide(100, -10);
    }

    // Method to perform division with exception handling
    static void divide(int num1, int num2) {
        try {
            int result = num1 / num2;
            System.out.println( num1 + " / " + num2 + "  = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception handled: Cannot divide " + num1 + " by " + num2);
        }
    }
}
