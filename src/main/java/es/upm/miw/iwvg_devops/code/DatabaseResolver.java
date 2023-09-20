package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class DatabaseResolver {
    public static UsersDatabase usersDatabase = new UsersDatabase();

    public Stream<String> findUserFamilyNameInitialBySomeProperFraction() {
        return usersDatabase.findAll()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
                .map(User::initials);
    }    
}
