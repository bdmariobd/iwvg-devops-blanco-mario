package es.upm.miw.iwvg_devops.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    private User user;
    private Fraction fraction;
    private User userWithFraction;
    private User userNoData;

    @BeforeEach
    void setUp() {
        // Create a new User and Fraction instance before each test
        user = new User("1", "John", "Doe");
        fraction = new Fraction(1, 2);
        userWithFraction = new User("2", "Pepe", "Domingo", List.of(fraction));
        userNoData = new User();
    }

    @Test
    void testUserData() {
        assertEquals("1", user.getId());
        assertEquals("John", user.getName());
        assertEquals("Doe", user.getFamilyName());
    }

    @Test
    void testUserNoData() {
        assertEquals(null, userNoData.getId());
        assertEquals(null, userNoData.getName());
        assertEquals(null, userNoData.getFamilyName());
        assertEquals(0, userNoData.getFractions().size());        
    }

    @Test
    void testGetId() {
        assertEquals("1", user.getId());
        assertEquals("2", userWithFraction.getId());
        assertNull(userNoData.getId(), "User no id has id");
    }

    @Test
    void testGetName() {
        assertEquals("John", user.getName());
        assertEquals("Pepe", userWithFraction.getName());
        assertNull(userNoData.getName(), "User no name has name");
    }

    @Test
    void testSetName() {
        user.setName("Jane");
        assertEquals("Jane", user.getName());
    }

    @Test
    void testGetFamilyName() {
        assertEquals("Doe", user.getFamilyName());
        assertEquals("Domingo", userWithFraction.getFamilyName());
        assertNull(userNoData.getFamilyName(), "User no family name has family name");
    }

    @Test
    void testSetFamilyName() {
        user.setFamilyName("Smith");
        assertEquals("Smith", user.getFamilyName());
    }

    @Test
    void testUserWithNoFractions() {
        assertEquals(0, user.getFractions().size());
    }

    @Test
    void testUserWithFractions() {
        assertEquals(1, userWithFraction.getFractions().size());
        assertEquals(fraction, userWithFraction.getFractions().get(0));
    }

    @Test
    void testSetFractions() {
        user.setFractions(List.of(fraction));
        assertEquals(1, user.getFractions().size());
        assertEquals(fraction, user.getFractions().get(0));
    }



    @Test
    void testFullName() {
        assertEquals("John Doe", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("J.", user.initials());
    }

    @Test
    void testAddFraction() {
        user.addFraction(fraction);

        List<Fraction> fractions = user.getFractions();
        assertEquals(1, fractions.size());
        assertEquals(fraction, fractions.get(0));
    }

    @Test
    void testToString() {
        String expectedToString = "User{id='1', name='John', familyName='Doe', fractions=[]}";
        assertEquals(expectedToString, user.toString());
    }
}
