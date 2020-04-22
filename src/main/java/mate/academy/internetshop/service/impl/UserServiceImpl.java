package mate.academy.internetshop.service.impl;

import java.util.List;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.dao.UserDao;
import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.UserService;

public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Override
    public User setName(String name) {
        User user = new User(name);
        userDao.create(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return Storage.users;
    }
}
