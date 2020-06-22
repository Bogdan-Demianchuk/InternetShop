package mate.academy.internetshop.dao;

import mate.academy.internetshop.model.User;
import java.util.Optional;

public interface UserDao extends GenericDao<User, Long> {
    Optional<User> findeByLogin(String login);
}
