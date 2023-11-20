package com.juhnkim;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

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
                "Not a valid triangle with 0, 0, 0 values");
    }


    @Test
    @DisplayName("Test constructor with no values in constructor")
    public void testEmptyConstructor() {
        Triangle triangle = new Triangle();
        assertNull(triangle.getCurrent_type(),
                "Not a triangle with no values");
    }

    @Test
    @DisplayName("Test constructor with invalid sides")
    public void testConstructorWithInvalidSides() {
        Triangle triangle = new Triangle(1, 1, 3);
        assertNull(triangle.getCurrent_type(),
                "Triangle with sides 1, 1, 3 should not form a valid triangle");
    }

    @Test
    @DisplayName("Test constructor with MAX integer values")
    public void testConstructorWithMaxIntValues() {
        Triangle triangle = new Triangle(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type(),
                "Triangle with maximum integer values should be EQUILATERAL");
    }

    @Test
    @DisplayName("Test constructor with negative values")
    public void testConstructorWithNegativeValues() {
        Triangle triangle = new Triangle(new String[]{"-4", "-5", "-2"});
        assertNull(triangle.getCurrent_type(),
                "Triangle with sides -4, -5, -2 should not form a valid triangle");
    }

    /**
     * CONSTRUCTOR TESTS /w String array parameter
     */

    @Test
    @DisplayName("Test constructor with valid string array for an SCALENE triangle")
    public void testConstructorWithStringArrayValidScalene() {
        Triangle triangle = new Triangle(new String[]{"2", "3", "4"});
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

    @Test
    @DisplayName("Test constructor with a null value")
    public void testNullStringArrayConstructor() {
        Triangle triangle = new Triangle(new String[]{null, null, null});
        assertNull(triangle.getCurrent_type(),
                "Not a triangle");
    }

    @Test
    @DisplayName("Test constructor with invalid string array values")
    public void testConstructorWithStringArrayInvalidSides() {
        Triangle triangle = new Triangle(new String[]{"1", "1", "3"});
        assertNull(triangle.getCurrent_type(),
                "Triangle with sides 1, 1, 3 should not form a valid triangle");
    }

    @Test
    @DisplayName("Test constructor with negative string array values")
    public void testConstructorWithStringArrayNegativeValues() {
        Triangle triangle = new Triangle(new String[]{"-4", "-5", "-2"});
        assertNull(triangle.getCurrent_type(),
                "Triangle with sides -4, -5, -2 should not form a valid triangle");
    }

    @Test
    @DisplayName("Test constructor with string array containing non-integer values")
    public void testConstructorWithStringArrayNonInteger() {
        Triangle triangle = new Triangle(new String[]{"3", "four", "5"});
        assertNull(triangle.getCurrent_type(),
                "Triangle should not be created with a non-integer value in the array");
    }

    @Test
    @DisplayName("Test constructor with string array of maximum integer values")
    public void testConstructorWithStringArrayMaxIntValues() {
        Triangle triangle = new Triangle(new String[]{String.valueOf(Integer.MAX_VALUE), String.valueOf(Integer.MAX_VALUE), String.valueOf(Integer.MAX_VALUE)});
        assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type(),
                "Triangle with string representations of maximum integer values should be EQUILATERAL");
    }

    @Test
    @DisplayName("Test constructor with string array of extremely large numbers")
    public void testConstructorWithStringArrayExtremelyLargeNumbers() {
        Triangle triangle = new Triangle(new String[]{"9999999999", "9999999999", "9999999999"});
        assertNull(triangle.getCurrent_type(),
                "Triangle with extremely large numbers should not form a valid triangle");
    }


    /**
     * User Input Tests
     */

    @AfterEach
    public void restoreSystemInput() {
        System.setIn(System.in);
    }

    // Helper method to read user input from console
    private void userInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
    @Test
    @DisplayName("Test getUserInput with valid scalene triangle input")
    public void testGetUserInputValidScalene() {
        userInput("3,4,5\n");
        Triangle triangle = new Triangle();
        triangle.getUserInput();
        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type(),
                "Input '3,4,5' should create a SCALENE triangle");
    }

    @Test
    @DisplayName("Test getUserInput with invalid input (non-numeric)")
    public void testGetUserInputNonNumeric() {
        userInput("a,b,c\n");
        Triangle triangle = new Triangle();
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type(),
                "Non-numeric input should not create a valid triangle");
    }

    @Test
    @DisplayName("Test getUserInput with incorrect number of sides")
    public void testGetUserInputIncorrectNumberOfSides() {
        userInput("1,2\n");
        Triangle triangle = new Triangle();
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type(),
                "Input with less than 3 sides should not create a valid triangle");
    }

    @Test
    @DisplayName("Test getUserInput with extra whitespaces in input")
    public void testGetUserInputWithExtraWhitespaces() {
        userInput(" 3 , 4 , 5 \n");
        Triangle triangle = new Triangle();
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type(),
                "Input with extra whitespaces ' 3 , 4 , 5 ' should not create a valid triangle");
    }

    @Test
    @DisplayName("Test getUserInput with incorrect delimiters in input")
    public void testGetUserInputWithIncorrectDelimiters() {
        userInput("3:4;5 \n");
        Triangle triangle = new Triangle();
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type(),
                "Input with incorrect delimiters '3:4;5' should not create a valid triangle");
    }

    @Test
    @DisplayName("Test getUserInput with large numeric values")
    public void testGetUserInputLargeValues() {
        userInput("999999999,999999998,999999997\n");
        Triangle triangle = new Triangle();
        triangle.getUserInput();
        assertEquals(Triangle.TYPE.SCALENE,triangle.getCurrent_type(),
                "Input '999999999,999999998,999999997' should create a SCALENE triangle");
    }

    @Test
    @DisplayName("Test getUserInput with no input")
    public void testGetUserInputNoValue() {
        userInput("\n");
        Triangle triangle = new Triangle();
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type(), "Input is empty or null");
    }
}