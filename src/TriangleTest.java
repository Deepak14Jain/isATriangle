import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";

    @Test
    public void testEquilateralTriangle() {
        Assert.assertEquals(BOLD + GREEN + "Equilateral Triangle" + RESET, Triangle.classifyTriangle(3, 3, 3));
    }

    @Test
    public void testIsoscelesTriangle() {
        Assert.assertEquals(BOLD + GREEN + "Isosceles Triangle" + RESET, Triangle.classifyTriangle(3, 3, 4));
        Assert.assertEquals(BOLD + GREEN + "Isosceles Triangle" + RESET, Triangle.classifyTriangle(4, 3, 3));
        Assert.assertEquals(BOLD + GREEN + "Isosceles Triangle" + RESET, Triangle.classifyTriangle(3, 4, 3));
    }

    @Test
    public void testScaleneTriangle() {
        Assert.assertEquals(BOLD + GREEN + "Scalene Triangle" + RESET, Triangle.classifyTriangle(3, 4, 5));
        Assert.assertEquals(BOLD + GREEN + "Scalene Triangle" + RESET, Triangle.classifyTriangle(5, 6, 7));
    }

    @Test
    public void testInvalidTriangleZeroOrNegativeSides() {
        Assert.assertEquals(BOLD + RED + "Not a Triangle" + RESET, Triangle.classifyTriangle(0, 3, 3));
        Assert.assertEquals(BOLD + RED + "Not a Triangle" + RESET, Triangle.classifyTriangle(-1, 3, 4));
    }

    @Test
    public void testInvalidTriangleInequality() {
        Assert.assertEquals(BOLD + RED + "Not a Triangle" + RESET, Triangle.classifyTriangle(1, 2, 3));
        Assert.assertEquals(BOLD + RED + "Not a Triangle" + RESET, Triangle.classifyTriangle(10, 2, 2));
    }
}
