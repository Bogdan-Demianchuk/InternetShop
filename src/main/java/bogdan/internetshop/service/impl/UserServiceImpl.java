package bogdan.internetshop.service.impl;

import bogdan.internetshop.dao.UserDao;
import bogdan.internetshop.lib.Inject;
import bogdan.internetshop.lib.Service;
import bogdan.internetshop.model.User;
import bogdan.internetshop.service.UserService;
import bogdan.internetshop.util.HashUtil;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User create(User user) {
        byte[] salt = HashUtil.getSalt();
        user.setPassword(HashUtil.hashPassword(user.getPassword(), salt));
        user.setSalt(salt);
        return userDao.create(user);
    }

    @Override
    public User get(Long userId) {
        return userDao.get(userId).get();
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public Optional<User> findeByLogin(String login) {
        return userDao.findeByLogin(login);
    }

    @Override
    public boolean delete(Long userId) {
        return userDao.delete(userId);
    }
}
