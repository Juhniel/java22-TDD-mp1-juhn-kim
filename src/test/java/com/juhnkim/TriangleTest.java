package com.juhnkim;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    /**
     * CONSTRUCTOR TESTS /w int parameters
     */

    @Test
    @DisplayName("Test constructor with valid SCALENE triangle sides")
    public void testConstructorWithValidScaleneSides() {
        Triangle triangle = new Triangle(3, 4, 5);
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type(),
                "Triangle with sides '3, 4, 5' - SCALENE Triangle");
    }

    @Test
    @DisplayName("Test constructor with valid ISOSCELES triangle sides")
    public void testConstructorWithValidIsoscelesSides() {
        Triangle triangle = new Triangle(2, 2, 3);
        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type(),
                "Triangle with sides '2, 2, 3' - ISOSCELES Triangle");
    }

    @Test
    @DisplayName("Test constructor with valid EQUILATERAL triangle sides")
    public void testConstructorWithValidEquilateralSides() {
        Triangle triangle = new Triangle(2, 2, 2);
        assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type(),
                "Triangle with sides '2, 2, 2' - EQUILATERAL Triangle");
    }

    @Test
    @DisplayName("Test constructor with zero values on triangle sides")
    public void testZeroValuesConstructor() {
        Triangle triangle = new Triangle(0, 0, 0);
        assertNull(triangle.getCurrent_type(),
                "Not a triangle with 0, 0, 0 values");
    }

    @Test
    @DisplayName("Test constructor with no values in constructor")
    public void testEmptyConstructor() {
        Triangle triangle = new Triangle();
        assertNull(triangle.getCurrent_type(),
                "Not a triangle with no values");
    }

    /**
     * CONSTRUCTOR TESTS /w String array parameter
     */

    @Test
    @DisplayName("Test constructor with valid string array for an SCALENE triangle")
    public void testConstructorWithStringArrayValidScalene() {
        Triangle triangle = new Triangle(new String[]{"2", "3", "5"});
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type(),
                "Triangle with sides {2, 3, 5} - SCALENE Triangle");
    }

    @Test
    @DisplayName("Test constructor with valid string array for an ISOSCELES triangle")
    public void testConstructorWithStringArrayValidIsosceles() {
        Triangle triangle = new Triangle(new String[]{"2", "2", "3"});
        assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type(),
                "Triangle with sides {2, 2, 3} - ISOSCELES Triangle");
    }

    @Test
    @DisplayName("Test constructor with valid string array for an isosceles triangle")
    public void testConstructorWithStringArrayValidEquilateral() {
        Triangle triangle = new Triangle(new String[]{"2", "2", "2"});
        assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type(),
                "Triangle with sides {2, 2, 2} - EQUILATERAL Triangle");
    }

    @Test
    @DisplayName("Test constructor with a empty string array")
    public void testEmptyStringArrayConstructor() {
        Triangle triangle = new Triangle(new String[]{});
        assertNull(triangle.getCurrent_type(),
                "Not a triangle");
    }
}