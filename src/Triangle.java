import java.util.Scanner;

public class Triangle {
    public static final String RED = "\u001B[31m";
    public static final String BOLD = "\u001B[1m";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static void main(String[] args) {
        int a = inputSide('A');
        int b = inputSide('B');
        int c = inputSide('C');

        String result = classifyTriangle(a, b, c);
        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("C: " + c);
        System.out.println("Result: " + result);
    }

    public static int inputSide(char side) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Input: Three sides of the triangle
            System.out.print("Enter side " + side +": ");
            int value = scanner.nextInt();

            // Check if the value is positive
            if (value < 0)
                throw new Exception("Side length must be a positive integer. Please try again."); // Valid input, exit the loop
            return value;
        } catch (Exception e) {
            System.out.println("=".repeat(100) + BOLD + RED + "\nError:" + RESET + " Invalid Input, "+ e.getMessage() + "\n" + "=".repeat(100));
            return inputSide(side);
        }
    }

    //Test cases to avoid invalid inputs.
    public static String classifyTriangle(int a, int b, int c) {
        // Triangle Inequality Theorem
        if (a + b <= c || a + c <= b || b + c <= a) {
            return BOLD + RED + "Not a Triangle" + RESET;
        }

        // Check type of triangle
        if (a == b && b == c) {
            return BOLD + GREEN + "Equilateral Triangle" + RESET;
        } else if (a == b || b == c || a == c) {
            return BOLD + GREEN + "Isosceles Triangle" + RESET;
        } else {
            return BOLD + GREEN + "Scalene Triangle" + RESET;
        }
    }
}
