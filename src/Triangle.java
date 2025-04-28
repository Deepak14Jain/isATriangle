import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Three sides of the triangle
        System.out.print("Enter side A: ");
        int a = scanner.nextInt();

        System.out.print("Enter side B: ");
        int b = scanner.nextInt();

        System.out.print("Enter side C: ");
        int c = scanner.nextInt();

        String result = classifyTriangle(a, b, c);
        System.out.println("Result: " + result);

        scanner.close();
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
