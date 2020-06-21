package bogdan.internetshop.dao;

import bogdan.internetshop.model.User;
import java.util.Optional;

public interface UserDao extends GenericDao<User, Long> {
    Optional<User> findeByLogin(String login);
}
