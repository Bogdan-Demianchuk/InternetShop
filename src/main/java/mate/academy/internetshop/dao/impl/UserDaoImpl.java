package mate.academy.internetshop.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.dao.UserDao;
import mate.academy.internetshop.model.User;

public class UserDaoImpl implements UserDao {
    @Override
    public User create(User user) {
        Storage.addUser(user);
        return user;
    }

    @Override
    public Optional<User> get(Long userId) {
        return Storage.users.stream()
                .filter(i -> i.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public List<User> getAll() {
        return Storage.users;
    }

    @Override
    public User update(User user) {
        IntStream.range(0, Storage.users.size())
                .filter(x -> user.getUserId().equals(Storage.users.get(x).getUserId()))
                .forEach(i -> Storage.users.set(i, user));
        return user;
    }

    @Override
    public boolean delete(Long userId) {
        return Storage.users
                .removeIf(i -> i.getUserId().equals(userId));
    }

    @Override
    public Optional<User> findeByLogin(String login) {
        return Storage.users.stream().filter(s -> s.getLogin().equals(login)).findAny();
    }
}
