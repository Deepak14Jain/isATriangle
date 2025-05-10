import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {


    @Test
    public void testEquilateralTriangle() {
        Assert.assertEquals("Equilateral Triangle", Triangle.classifyTriangle(3, 3, 3));
    }

    @Test
    public void testIsoscelesTriangle() {
        Assert.assertEquals("Isosceles Triangle", Triangle.classifyTriangle(3, 3, 4));
        Assert.assertEquals("Isosceles Triangle", Triangle.classifyTriangle(4, 3, 3));
        Assert.assertEquals("Isosceles Triangle", Triangle.classifyTriangle(3, 4, 3));
    }

    @Test
    public void testScaleneTriangle() {
        Assert.assertEquals("Scalene Triangle", Triangle.classifyTriangle(3, 4, 5));
        Assert.assertEquals("Scalene Triangle", Triangle.classifyTriangle(5, 6, 7));
    }

    @Test
    public void testInvalidTriangleZeroOrNegativeSides() {
        Assert.assertEquals("Not a Triangle", Triangle.classifyTriangle(0, 3, 3));
        Assert.assertEquals("Not a Triangle", Triangle.classifyTriangle(-1, 3, 4));
    }

    @Test
    public void testInvalidTriangleInequality() {
        Assert.assertEquals("Not a Triangle", Triangle.classifyTriangle(1, 2, 3));
        Assert.assertEquals("Not a Triangle", Triangle.classifyTriangle(10, 2, 2));
    }
}
