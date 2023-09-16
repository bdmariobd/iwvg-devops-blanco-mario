package es.upm.miw.iwvg_devops.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;
    private Fraction fraction;
    private User userWithFraction;

    @BeforeEach
    public void setUp() {
        // Create a new User and Fraction instance before each test
        user = new User("1", "John", "Doe");
        fraction = new Fraction(1, 2);
        userWithFraction = new User("2", "Pepe", "Domingo", List.of(fraction));
    }

    @Test
    public void testFullName() {
        assertEquals("John Doe", user.fullName());
    }

    @Test
    public void testInitials() {
        assertEquals("J.", user.initials());
    }

    @Test
    public void testUserWithNoFractions() {
        assertEquals(0, user.getFractions().size());
    }

    @Test
    public void testUserWithFractions() {
        assertEquals(1, userWithFraction.getFractions().size());
        assertEquals(fraction, userWithFraction.getFractions().get(0));
    }

    @Test
    public void testAddFraction() {
        user.addFraction(fraction);

        List<Fraction> fractions = user.getFractions();
        assertEquals(1, fractions.size());
        assertEquals(fraction, fractions.get(0));
    }

    @Test
    public void testToString() {
        String expectedToString = "User{id='1', name='John', familyName='Doe', fractions=[]}";
        assertEquals(expectedToString, user.toString());
    }

}
