package mate.academy.internetshop.service;

import java.util.List;
import mate.academy.internetshop.model.User;

public interface UserService {
    User setName(String name);

    List<User> getAllUsers();
}
