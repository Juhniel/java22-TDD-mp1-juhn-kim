# java22-TDD-mp1-juhn-kim

# Overview 
Triangle classification project for identifying what type of triangle (Scalene, Isosceles, Equilateral) based on lengths of its sides. This project is a mini project 
to practise unit testing with JUnit in Java.

# Key Features
* Input Handling
* Triangle Classification
* Error Handling

# Constructor Tests 
* Verifies that triangles are correctly classified when instantiated with integer parameters. 
* Test constructor that accepts string arrays ensuring correct handling of valid strings.

# User Input Tests
* Valid inputs to check that the application processes valid user inputs.
* Invalid inputs to check for non-numeric inputs, incorrect numbers and incorrect formats.
* Boundary testing.
* System input reset.

# Important tests
* Boundary Conditions
* Null values
* Exceptions
* Input / Output

# Reflection and Conclusion

Throughout the development and testing of the Triangle Classification Project, one notable aspect was the approach to exception handling in the codebase. 
The current implementation of the Triangle class does not explicitly throw exceptions for most invalid inputs or erroneous conditions. Instead, it handles them internally, 
often setting the triangle type to null in cases of invalidity.

Another key area identified for future improvement in the testing suite is the use of parameterized tests. Currently, many tests follow a similar pattern but with different 
input values, leading to some redundancy in the test code. I would like to read more about JUnit's @ParameterizedTest annotation and data sources like Stream of
Arguments can significantly reduce this redundancy. It allows for running the same test logic with different inputs, making the tests more scalable and maintainable.

