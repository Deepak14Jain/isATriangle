import java.util.Scanner;

public class Triangle {
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
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error: Invalid Input, Expecting an Integer\n----------------------");
            return inputSide(side);
        }
    }

    public static String classifyTriangle(int a, int b, int c) {
        // Check for valid triangle
        if (a <= 0 || b <= 0 || c <= 0) {
            return "Not a Triangle";
        }

        // Triangle Inequality Theorem
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "Not a Triangle";
        }

        // Check type of triangle
        if (a == b && b == c) {
            return "Equilateral Triangle";
        } else if (a == b || b == c || a == c) {
            return "Isosceles Triangle";
        } else {
            return "Scalene Triangle";
        }
    }
}
