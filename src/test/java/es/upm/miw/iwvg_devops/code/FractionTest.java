package es.upm.miw.iwvg_devops.code;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FractionTest {

    private Fraction fraction, fractionNonProper;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(2, 3);
        fractionNonProper = new Fraction(3, 2);
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

    @Test
    void testIsProper() {
        assertTrue(Fraction.isProper(fraction));
        assertFalse(Fraction.isProper(fractionNonProper));
    }

    @Test
    void testIsNotProper() {
        assertTrue(Fraction.isImproper(fractionNonProper));
        assertFalse(Fraction.isImproper(fraction));
    }

    @Test
    void testIsEquivalent() {
        assertTrue(Fraction.isEquivalent(fraction, new Fraction(4, 6)));
        assertTrue(Fraction.isEquivalent(fractionNonProper, new Fraction(27, 18)));
    }

    @Test
    void testAdd() {
        assertEquals(new Fraction(13, 6), Fraction.add(fraction, fractionNonProper));
    }

    @Test
    void testMultiply() {
        assertEquals(new Fraction(6, 6), Fraction.multiply(fraction, fractionNonProper));
    }

    @Test
    void testDivide() {
        assertEquals(new Fraction(4, 9), Fraction.divide(fraction, fractionNonProper));
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> Fraction.divide(fraction, new Fraction(0, 1)));
    }

    @Test
    void testCreatedFractionsReduced() {
        assertEquals(new Fraction(1, 2), new Fraction(2, 4));
        assertEquals(new Fraction(1, 2), new Fraction(4, 8));
        assertEquals(new Fraction(1, 2), new Fraction(6, 12));
        assertEquals(new Fraction(1, 2), new Fraction(8, 16));
    }

    @Test
    void testEquals() {
        assertEquals(fraction, new Fraction(20, 30));
        assertNotEquals(fraction, new Fraction(79, 2));
        assertNotEquals(fraction, new Fraction(2, 9));
        Boolean a = true;
        Boolean b = null;
        assertNotEquals(fraction, a);
        assertNotEquals(fraction, b);
        assertEquals(fraction.hashCode(), new Fraction(20, 30).hashCode());
    }

    @Test
    void testCreateFractions() {
        Fraction fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
        assertThrows(IllegalArgumentException.class, () -> new Fraction(1, 0));
    }
}

