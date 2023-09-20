package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class DatabaseResolver {
    public static UsersDatabase usersDatabase = new UsersDatabase();

    public Stream<String> findUserFamilyNameInitialBySomeProperFraction() {
        return usersDatabase.findAll()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
                .map(User::initials);
    }
    
    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
        return usersDatabase.findAll()
                .filter(user -> user.getFamilyName().equals(familyName))
                .flatMap(user -> user.getFractions().stream())
                .reduce(Fraction::multiply)
                .orElseThrow();
    }

    public Fraction findFractionDivisionByUserId(String id) {
        return usersDatabase.findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .reduce(Fraction::divide)
                .orElseThrow();
    }
}
