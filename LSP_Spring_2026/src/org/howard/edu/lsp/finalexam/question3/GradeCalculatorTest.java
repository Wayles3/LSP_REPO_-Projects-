package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class GradeCalculatorTest {
    GradeCalculator calculator = new GradeCalculator();

    @Test
    @DisplayName("Test for average()")
    void testAverage() {
        assertEquals(80.0, calculator.average(70, 80, 90));
    }

    @Test
    @DisplayName("Test for letterGrade()")
    void testLetterGrade() {
        assertEquals("B", calculator.letterGrade(85.0));
    }

    @Test
    @DisplayName("Test for isPassing()")
    void testIsPassing() {
        assertTrue(calculator.isPassing(60.0));
    }

    @Test
    @DisplayName("Boundary Value Tests")
    void testBoundaries() {
        // Requirement 4: Two boundary-value tests
        assertEquals("A", calculator.letterGrade(90.0));
        assertEquals("F", calculator.letterGrade(59.9));
    }

    @Test
    @DisplayName("Exception Tests")
    void testExceptions() {
        // Requirement 5: Two exception tests using assertThrows()
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(-1, 80, 80);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(101, 80, 80);
        });
    }
}