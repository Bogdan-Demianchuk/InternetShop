package mate.academy.internetshop.dao;

import java.util.Optional;
import mate.academy.internetshop.model.User;

public interface UserDao extends GenericDao<User, Long> {
    Optional<User> findeByLogin(String login);
}
