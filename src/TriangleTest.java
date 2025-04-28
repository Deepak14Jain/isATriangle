import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TriangleTest {

    @Test
    void testEquilateralTriangle() {
        assertEquals("Equilateral Triangle", Triangle.classifyTriangle(3, 3, 3));
    }

    @Test
    void testIsoscelesTriangle() {
        assertEquals("Isosceles Triangle", Triangle.classifyTriangle(3, 3, 4));
        assertEquals("Isosceles Triangle", Triangle.classifyTriangle(4, 3, 3));
        assertEquals("Isosceles Triangle", Triangle.classifyTriangle(3, 4, 3));
    }

    @Test
    void testScaleneTriangle() {
        assertEquals("Scalene Triangle", Triangle.classifyTriangle(3, 4, 5));
        assertEquals("Scalene Triangle", Triangle.classifyTriangle(5, 6, 7));
    }

    @Test
    void testInvalidTriangleZeroOrNegativeSides() {
        assertEquals("Not a Triangle", Triangle.classifyTriangle(0, 3, 3));
        assertEquals("Not a Triangle", Triangle.classifyTriangle(-1, 3, 4));
    }

    @Test
    void testInvalidTriangleInequality() {
        assertEquals("Not a Triangle", Triangle.classifyTriangle(1, 2, 3));
        assertEquals("Not a Triangle", Triangle.classifyTriangle(10, 2, 2));
    }
}
