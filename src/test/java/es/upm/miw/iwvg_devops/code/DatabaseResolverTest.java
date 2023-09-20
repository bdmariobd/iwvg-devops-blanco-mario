package es.upm.miw.iwvg_devops.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseResolverTest {

    DatabaseResolver databaseResolver;
    @BeforeEach
    void setUp() {
        databaseResolver = new DatabaseResolver();
    }

    @Test
    void testFindUserFamilyNameInitialBySomeProperFraction() {
        List<String> listOfInitials = databaseResolver.findUserFamilyNameInitialBySomeProperFraction().toList();
        assertEquals(5, listOfInitials.size());
    }

    @Test
    void testFindFractionMultiplicationByUserFamilyName() {        
        Fraction fractionTorres = databaseResolver.findFractionMultiplicationByUserFamilyName("Torres");
        assertEquals(new Fraction(0,1), fractionTorres);

        Fraction fractionBlanco = databaseResolver.findFractionMultiplicationByUserFamilyName("Blanco");
        assertEquals(new Fraction(0,1), fractionBlanco);

        Fraction fractionLopez = databaseResolver.findFractionMultiplicationByUserFamilyName("López");
        assertEquals(new Fraction(1,-20), fractionLopez);

        Fraction fractionFernandez = databaseResolver.findFractionMultiplicationByUserFamilyName("Fernandez");
        assertEquals(new Fraction(0,1), fractionFernandez);
    }
    
    @Test
    void testFindFractionDivisionByUserId() {
        Fraction fraction1 = databaseResolver.findFractionDivisionByUserId("1");
        assertEquals(new Fraction(0,1), fraction1);

        Fraction fraction2 = databaseResolver.findFractionDivisionByUserId("2");
        assertEquals(new Fraction(-15,1), fraction2);

        assertThrows(Exception.class, () -> databaseResolver.findFractionDivisionByUserId("Err"));
    }
}
