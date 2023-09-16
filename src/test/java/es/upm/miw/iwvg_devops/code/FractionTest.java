package es.upm.miw.iwvg_devops.code;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(2, 3);
    }

    @Test
    void testGetNumerator() {
        assertEquals(2, fraction.getNumerator());
    }

    @Test
    void testSetNumerator() {
        fraction.setNumerator(5);
        assertEquals(5, fraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        assertEquals(3, fraction.getDenominator());
    }

    @Test
    void testSetDenominator() {
        fraction.setDenominator(7);
        assertEquals(7, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(0.6666666666666666, fraction.decimal(), 0.001);
    }

    @Test
    void testToString() {
        assertEquals("Fraction{numerator=2, denominator=3}", fraction.toString());
    }
}

