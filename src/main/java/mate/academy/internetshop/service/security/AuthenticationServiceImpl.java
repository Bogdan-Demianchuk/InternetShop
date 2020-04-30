package mate.academy.internetshop.service.security;

import mate.academy.internetshop.exeptions.AuthenticationException;
import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.lib.Service;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Override
    public User login(String login, String password) throws AuthenticationException {
        User userFromDb = userService.findeByLogin(login)
                .orElseThrow(() -> new AuthenticationException("Incorrect user or password"));
        if (userFromDb.getPassword().equals(password)) {
            return userFromDb;
        } else {
            throw new AuthenticationException("Incorrect login or password");
        }

    }
}
